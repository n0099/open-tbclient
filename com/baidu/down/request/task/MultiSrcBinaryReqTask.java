package com.baidu.down.request.task;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.down.common.FileMsg;
import com.baidu.down.common.StatisticInfo;
import com.baidu.down.loopj.android.http.AsyncHttpRequest;
import com.baidu.down.loopj.android.http.BinaryHttpResponseHandler;
import com.baidu.down.loopj.android.http.ConnectManager;
import com.baidu.down.loopj.android.http.MultiSrcAsyncHttpRequest;
import com.baidu.down.loopj.android.http.MultiSrcBinaryTaskHandler;
import com.baidu.down.loopj.android.urlconnection.HttpURLExecutorRunnable;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.down.request.taskmanager.HttpDNSCacheInfo;
import com.baidu.down.request.taskmanager.HttpDNSInfo;
import com.baidu.down.request.taskmanager.MultiSrcTaskMsg;
import com.baidu.down.request.taskmanager.OnFetchDataRequestListener;
import com.baidu.down.request.taskmanager.TaskFacade;
import com.baidu.down.request.taskmanager.TaskNetRequestMng;
import com.baidu.down.statistic.StatisticPoster;
import com.baidu.down.utils.Constants;
import com.baidu.down.utils.CryptUtil;
import com.baidu.down.utils.DownPrefUtils;
import com.baidu.down.utils.Utils;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MultiSrcBinaryReqTask extends BinaryReqTask {
    public static final boolean DEBUG = false;
    public static final String DOWNFLOW_DOWNLOAD_INNER = "download_inner";
    public static final String DOWNFLOW_DYRES = "dyres";
    public static final String DOWNFLOW_DYSTAT = "dystat";
    public static final String DOWNFLOW_ERROR_NO = "error_no";
    public static final String DOWNFLOW_FRES = "fres";
    public static final String DOWNFLOW_FSTAT = "fstat";
    public static final String DOWNFLOW_MODE = "mode";
    public static final String DOWNFLOW_SID = "sid";
    public static final String DOWNFLOW_TN = "tn";
    public static final long DOWNLOAD_SPEED_TIME_THRESHOLD = 5;
    public static final String HTTP_DNS_CDN_DATA = "data";
    public static final String HTTP_DNS_CDN_HOST = "host";
    public static final String HTTP_DNS_CDN_LIVE_TIME = "live_time";
    public static final String HTTP_DNS_CDN_STATUS = "status";
    public static final String HTTP_DNS_CDN_VIPS = "vips";
    public static final String HTTP_DNS_CDN_XCODE = "xcode";
    public static final String TAG = "MultiSrcBinaryReqTask";
    public boolean isRetryDownloadInfo;
    public String mDownInfoVpn;
    public long mFetchHttpDNSDataElapsedTime;
    public Timer mFetchHttpDNSDataOverTime;
    public long mFetchServerDataElapsedTime;
    public Timer mFetchServerDataOverTime;
    public boolean mIsDirectStart;
    public boolean mIsFetchHttpDnsData;
    public List<OnFetchDataRequestListener> mOnFetchDataRequestListener;
    public int mPauseNum;
    public TreeSet<HttpDNSInfo> mPriorityHttpDNSInfoSet;
    public long mTestSpeedDataSize;
    public long mTestSpeedDuration;

    public MultiSrcBinaryReqTask(Context context, FileMsg fileMsg) {
        super(context, fileMsg);
        this.mIsDirectStart = false;
        this.mIsFetchHttpDnsData = true;
        this.mPauseNum = 0;
        this.isRetryDownloadInfo = false;
        this.mPriorityHttpDNSInfoSet = new TreeSet<>();
        MultiSrcBinaryTaskHandler multiSrcBinaryTaskHandler = new MultiSrcBinaryTaskHandler(this);
        this.mTaskHandler = multiSrcBinaryTaskHandler;
        multiSrcBinaryTaskHandler.setCurTask(this);
        this.mTestSpeedDataSize = DownPrefUtils.testConfigurationGetLong(this.mContext, DownPrefUtils.PREF_CONFIG_TEST_SPEED_DATA_SIZE, 512L) * 1024;
        this.mTestSpeedDuration = DownPrefUtils.testConfigurationGetLong(this.mContext, DownPrefUtils.PREF_CONFIG_TEST_SPEED_DURATION, 15L) * 1000;
    }

    private void checkAndAdjustByAverageSpeed() {
        long j;
        List<WeakReference<AsyncHttpRequest>> taskHttpRequestList = TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().getTaskHttpRequestList(this.myContext);
        if (taskHttpRequestList != null) {
            HttpDNSInfo firstAvailableDownloadIpInfo = getFirstAvailableDownloadIpInfo();
            if (firstAvailableDownloadIpInfo != null) {
                for (WeakReference<AsyncHttpRequest> weakReference : taskHttpRequestList) {
                    MultiSrcAsyncHttpRequest multiSrcAsyncHttpRequest = (MultiSrcAsyncHttpRequest) weakReference.get();
                    if (multiSrcAsyncHttpRequest != null && multiSrcAsyncHttpRequest.requestIsRunning() && multiSrcAsyncHttpRequest.isTestSpeedRequest()) {
                        long testAverageSpeed = firstAvailableDownloadIpInfo.getTestAverageSpeed();
                        long testConfigurationGetLong = DownPrefUtils.testConfigurationGetLong(this.mContext, DownPrefUtils.PREF_CONFIG_DOWNLOAD_SPEED_OFFSET_MAX, 10L);
                        long testConfigurationGetLong2 = DownPrefUtils.testConfigurationGetLong(this.mContext, DownPrefUtils.PREF_CONFIG_DOWNLOAD_SPEED_OFFSET_MIN, 20L) * 1024;
                        if (!firstAvailableDownloadIpInfo.mUrl.equals(multiSrcAsyncHttpRequest.mRequestUrl) && testAverageSpeed != 0) {
                            long j2 = multiSrcAsyncHttpRequest.mAverageSpeed;
                            if ((j2 / testAverageSpeed) * 100 < 100 - testConfigurationGetLong && testAverageSpeed - j2 > testConfigurationGetLong2) {
                                long segEndByPos = this.mProgressInfo.getSegEndByPos(multiSrcAsyncHttpRequest.mCurFilePos);
                                long j3 = multiSrcAsyncHttpRequest.mAverageSpeed;
                                if (j3 == 0) {
                                    j = 2147483647L;
                                } else {
                                    long j4 = multiSrcAsyncHttpRequest.mRequestBytes;
                                    j = ((segEndByPos - j4) / j3) - ((segEndByPos - j4) / testAverageSpeed);
                                }
                                if (j > 5) {
                                    MultiSrcTaskMsg multiSrcTaskMsg = new MultiSrcTaskMsg();
                                    multiSrcTaskMsg.mTask = this;
                                    multiSrcTaskMsg.request = multiSrcAsyncHttpRequest;
                                    TaskFacade.getInstance(null).getBinaryTaskMng().sendMessage(7, multiSrcTaskMsg);
                                    ProgressInfo.Segment segment = this.mProgressInfo.getSegment(multiSrcAsyncHttpRequest.mCurFilePos);
                                    HttpDNSInfo downloadIpInfo = getDownloadIpInfo(multiSrcAsyncHttpRequest.mRequestUrl);
                                    if (downloadIpInfo != null) {
                                        downloadIpInfo.mIsWorking = 0;
                                    }
                                    if (segment.current < segment.end) {
                                        MultiSrcTaskMsg multiSrcTaskMsg2 = new MultiSrcTaskMsg();
                                        multiSrcTaskMsg2.mTask = this;
                                        multiSrcTaskMsg2.mSegment = segment;
                                        TaskFacade.getInstance(null).getBinaryTaskMng().sendMessage(6, multiSrcTaskMsg2);
                                    }
                                }
                            }
                        }
                    }
                }
                HttpDNSCacheInfo httpDNSCacheInfo = TaskFacade.getInstance(null).getBinaryTaskMng().getHttpDNSCacheInfo();
                if (httpDNSCacheInfo != null) {
                    synchronized (this) {
                        httpDNSCacheInfo.mBackupHttpDNSInfoSet = new TreeSet<>();
                        Iterator<HttpDNSInfo> it = this.mPriorityHttpDNSInfoSet.iterator();
                        while (it.hasNext()) {
                            httpDNSCacheInfo.mBackupHttpDNSInfoSet.add(it.next().backupHttpDNSInfo());
                        }
                    }
                }
                ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.dtest = firstAvailableDownloadIpInfo.mDownloadTimes;
                return;
            }
            multiSrcToNormal();
        }
    }

    private String getReplaceIpUrl() {
        if (TaskFacade.getInstance(null).getBinaryTaskMng().getPatternConfig().patternType == 1) {
            return this.mDownloadUri;
        }
        return this.mUri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initHttpDNSInfo(HttpDNSCacheInfo httpDNSCacheInfo) {
        ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.dyuse = 0;
        if (httpDNSCacheInfo.mIsTestSpeed) {
            this.mPriorityHttpDNSInfoSet = readHttpDNSCacheInfo(httpDNSCacheInfo, false);
            ((MultiSrcBinaryTaskHandler) this.mTaskHandler).setNeedTestSpeed(false);
            return;
        }
        this.mPriorityHttpDNSInfoSet = readHttpDNSCacheInfo(httpDNSCacheInfo, true);
        ((MultiSrcBinaryTaskHandler) this.mTaskHandler).setNeedTestSpeed(true);
    }

    private void onFetchServerDataRequest(final OnFetchDataRequestListener onFetchDataRequestListener) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        TimerTask timerTask = new TimerTask() { // from class: com.baidu.down.request.task.MultiSrcBinaryReqTask.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (MultiSrcBinaryReqTask.this.mFetchServerDataOverTime == null) {
                    return;
                }
                MultiSrcBinaryReqTask.this.mFetchServerDataOverTime = null;
                OnFetchDataRequestListener onFetchDataRequestListener2 = onFetchDataRequestListener;
                if (onFetchDataRequestListener2 != null) {
                    onFetchDataRequestListener2.afterRequest(false, null);
                }
                MultiSrcBinaryReqTask.this.mFetchServerDataElapsedTime = SystemClock.elapsedRealtime() - elapsedRealtime;
                MultiSrcBinaryReqTask multiSrcBinaryReqTask = MultiSrcBinaryReqTask.this;
                BinaryHttpResponseHandler binaryHttpResponseHandler = multiSrcBinaryReqTask.mTaskHandler;
                ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).mMultiSrcStatData.dfstat = 2;
                ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).mMultiSrcStatData.dfcost = multiSrcBinaryReqTask.mFetchServerDataElapsedTime;
            }
        };
        Timer timer = new Timer();
        this.mFetchServerDataOverTime = timer;
        timer.schedule(timerTask, DownPrefUtils.testConfigurationGetLong(this.mContext, DownPrefUtils.PREF_CONFIG_DOWNINFO_URL_TIMEOUT, 15L) * 1000);
        this.mDownInfoVpn = Utils.getWifiOr2gOr3G(this.mContext);
        TaskNetRequestMng.requestRemoteConfig(this.mContext, this.mDownloadType, this.mFromParam, this.mTj, this.mUri, this.mIsFetchHttpDnsData, this.mDownInfoParams, this.mSize, new HttpURLExecutorRunnable.OnWebRequestListener() { // from class: com.baidu.down.request.task.MultiSrcBinaryReqTask.3
            @Override // com.baidu.down.loopj.android.urlconnection.HttpURLExecutorRunnable.OnWebRequestListener
            public void onFailed() {
                if (MultiSrcBinaryReqTask.this.mFetchServerDataOverTime == null) {
                    return;
                }
                MultiSrcBinaryReqTask.this.mFetchServerDataOverTime.cancel();
                MultiSrcBinaryReqTask.this.mFetchServerDataOverTime = null;
                OnFetchDataRequestListener onFetchDataRequestListener2 = onFetchDataRequestListener;
                if (onFetchDataRequestListener2 != null) {
                    onFetchDataRequestListener2.afterRequest(false, null);
                }
                MultiSrcBinaryReqTask.this.mFetchServerDataElapsedTime = SystemClock.elapsedRealtime() - elapsedRealtime;
                MultiSrcBinaryReqTask multiSrcBinaryReqTask = MultiSrcBinaryReqTask.this;
                BinaryHttpResponseHandler binaryHttpResponseHandler = multiSrcBinaryReqTask.mTaskHandler;
                ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).mMultiSrcStatData.dfstat = 1;
                ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).mMultiSrcStatData.dfcost = multiSrcBinaryReqTask.mFetchServerDataElapsedTime;
            }

            @Override // com.baidu.down.loopj.android.urlconnection.HttpURLExecutorRunnable.OnWebRequestListener
            public void onSuccess(String str) {
                if (MultiSrcBinaryReqTask.this.mFetchServerDataOverTime == null) {
                    return;
                }
                MultiSrcBinaryReqTask.this.mFetchServerDataOverTime.cancel();
                MultiSrcBinaryReqTask.this.mFetchServerDataOverTime = null;
                MultiSrcBinaryReqTask.this.mFetchServerDataElapsedTime = SystemClock.elapsedRealtime() - elapsedRealtime;
                MultiSrcBinaryReqTask multiSrcBinaryReqTask = MultiSrcBinaryReqTask.this;
                ((MultiSrcBinaryTaskHandler) multiSrcBinaryReqTask.mTaskHandler).mMultiSrcStatData.dfcost = multiSrcBinaryReqTask.mFetchServerDataElapsedTime;
                ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dfstat = 0;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.optInt("error_no") == 0) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("fres");
                            if (jSONObject.optInt("fstat", 1) == 0 && optJSONObject != null && !optJSONObject.optString("download_inner").equals("")) {
                                MultiSrcBinaryReqTask.this.mSid = optJSONObject.optString("sid", "");
                                StatisticInfo statisticInfo = new StatisticInfo();
                                statisticInfo.sid = MultiSrcBinaryReqTask.this.mSid;
                                statisticInfo.sdkVer = Constants.SDK_VER;
                                MultiSrcBinaryReqTask.this.mDownInfoMode = Integer.parseInt(optJSONObject.optString("mode", "-1"));
                                statisticInfo.mode = MultiSrcBinaryReqTask.this.mDownInfoMode;
                                int parseInt = Integer.parseInt(optJSONObject.optString("tn", "-1"));
                                if (parseInt > 0) {
                                    MultiSrcBinaryReqTask.this.mMaxThread = parseInt;
                                }
                                statisticInfo.tn = parseInt;
                                MultiSrcBinaryReqTask.this.mDownloadUri = optJSONObject.optString("download_inner", "");
                                TaskFacade.getInstance(null).getBinaryTaskMng().addStatsticMap(Long.valueOf(MultiSrcBinaryReqTask.this.mDownloadId), statisticInfo);
                                if ((MultiSrcBinaryReqTask.this.mDownInfoMode & 1) == 1) {
                                    if (MultiSrcBinaryReqTask.this.mIsFetchHttpDnsData) {
                                        TreeSet<HttpDNSInfo> treeSet = new TreeSet<>();
                                        HttpDNSCacheInfo httpDNSCacheInfo = new HttpDNSCacheInfo();
                                        ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dyget = jSONObject.optInt("dystat", 1);
                                        if (jSONObject.optInt("dystat", 1) == 0) {
                                            MultiSrcBinaryReqTask.this.parserHttpDNSData(jSONObject.optJSONObject("dyres"), onFetchDataRequestListener, treeSet, httpDNSCacheInfo);
                                        }
                                        if (treeSet.isEmpty()) {
                                            ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dyuse = 2;
                                            if (onFetchDataRequestListener != null) {
                                                onFetchDataRequestListener.afterRequest(false, null);
                                            }
                                        } else {
                                            ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dyuse = 1;
                                            if (onFetchDataRequestListener != null) {
                                                onFetchDataRequestListener.afterRequest(true, treeSet);
                                            }
                                        }
                                        TaskFacade.getInstance(null).getBinaryTaskMng().setHttpDNSCacheInfo(httpDNSCacheInfo);
                                        return;
                                    } else if (onFetchDataRequestListener != null) {
                                        onFetchDataRequestListener.afterRequest(true, null);
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dyuse = 7;
                                if (onFetchDataRequestListener != null) {
                                    onFetchDataRequestListener.afterRequest(true, null);
                                    return;
                                }
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dfstat = 1;
                    }
                }
                ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dyuse = 8;
                OnFetchDataRequestListener onFetchDataRequestListener2 = onFetchDataRequestListener;
                if (onFetchDataRequestListener2 != null) {
                    onFetchDataRequestListener2.afterRequest(false, null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parserHttpDNSData(JSONObject jSONObject, OnFetchDataRequestListener onFetchDataRequestListener, TreeSet<HttpDNSInfo> treeSet, HttpDNSCacheInfo httpDNSCacheInfo) {
        if (jSONObject != null) {
            try {
                if (jSONObject != null) {
                    try {
                        String string = jSONObject.getString("data");
                        if (TextUtils.isEmpty(string)) {
                            return;
                        }
                        String host = new URL(getReplaceIpUrl()).getHost();
                        String decryptCdnData = CryptUtil.decryptCdnData(this.mContext, string);
                        if (TextUtils.isEmpty(decryptCdnData)) {
                            return;
                        }
                        JSONObject jSONObject2 = new JSONObject(decryptCdnData);
                        int optInt = jSONObject.optInt("status");
                        if (optInt == 0) {
                            JSONArray optJSONArray = jSONObject2.optJSONArray("vips");
                            String optString = jSONObject2.optString("xcode");
                            httpDNSCacheInfo.mXCode = optString;
                            String optString2 = jSONObject2.optString("host");
                            this.mHost = optString2;
                            httpDNSCacheInfo.mHost = optString2;
                            httpDNSCacheInfo.mIpLiveTime = jSONObject2.optInt("live_time");
                            httpDNSCacheInfo.mApn = Utils.getWifiOr2gOr3G(this.mContext);
                            httpDNSCacheInfo.mRequestTime = SystemClock.elapsedRealtime();
                            if (optJSONArray != null && !TextUtils.isEmpty(this.mHost)) {
                                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                    if (Utils.isIpAddress(optJSONArray.getString(i2))) {
                                        HttpDNSInfo httpDNSInfo = new HttpDNSInfo();
                                        String replace = getReplaceIpUrl().replace(host, optJSONArray.getString(i2));
                                        httpDNSInfo.mUrl = replace;
                                        if (Utils.isUrlContainsQ(replace)) {
                                            httpDNSInfo.mUrl += "&xcode=" + optString;
                                        } else {
                                            httpDNSInfo.mUrl += "?xcode=" + optString;
                                        }
                                        httpDNSInfo.mCDNSequence = i2;
                                        httpDNSInfo.mCNDIp = optJSONArray.getString(i2);
                                        treeSet.add(httpDNSInfo);
                                        httpDNSCacheInfo.mIpList.add(optJSONArray.getString(i2));
                                    }
                                }
                            }
                        } else if (optInt == 1) {
                            httpDNSCacheInfo.mIpLiveTime = 600;
                            httpDNSCacheInfo.mApn = Utils.getWifiOr2gOr3G(this.mContext);
                            httpDNSCacheInfo.mRequestTime = SystemClock.elapsedRealtime();
                        }
                        httpDNSCacheInfo.mStatus = optInt;
                    } catch (MalformedURLException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private TreeSet<HttpDNSInfo> readHttpDNSCacheInfo(HttpDNSCacheInfo httpDNSCacheInfo, boolean z) {
        TreeSet<HttpDNSInfo> treeSet = new TreeSet<>();
        if (z) {
            try {
                String host = new URL(getReplaceIpUrl()).getHost();
                for (int i2 = 0; i2 < httpDNSCacheInfo.mIpList.size(); i2++) {
                    if (Utils.isIpAddress(httpDNSCacheInfo.mIpList.get(i2))) {
                        HttpDNSInfo httpDNSInfo = new HttpDNSInfo();
                        String replace = getReplaceIpUrl().replace(host, httpDNSCacheInfo.mIpList.get(i2));
                        httpDNSInfo.mUrl = replace;
                        if (Utils.isUrlContainsQ(replace)) {
                            httpDNSInfo.mUrl += "&xcode=" + httpDNSCacheInfo.mXCode;
                        } else {
                            httpDNSInfo.mUrl += "?xcode=" + httpDNSCacheInfo.mXCode;
                        }
                        httpDNSInfo.mCDNSequence = i2;
                        httpDNSInfo.mCNDIp = httpDNSCacheInfo.mIpList.get(i2);
                        treeSet.add(httpDNSInfo);
                    }
                }
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
        } else {
            Iterator<HttpDNSInfo> it = httpDNSCacheInfo.mBackupHttpDNSInfoSet.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().clone(this.mDownloadUri, httpDNSCacheInfo.mXCode));
            }
        }
        this.mHost = httpDNSCacheInfo.mHost;
        BinaryHttpResponseHandler binaryHttpResponseHandler = this.mTaskHandler;
        ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).mMultiSrcStatData.ccost = 0L;
        ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).mMultiSrcStatData.cstatus = 6;
        return treeSet;
    }

    public void addAsyncRequest(ProgressInfo.Segment segment) {
        startSegment(segment.current, segment.end, 2);
    }

    public void cancelAsyncRequest(MultiSrcAsyncHttpRequest multiSrcAsyncHttpRequest) {
        multiSrcAsyncHttpRequest.stopRequestRunning();
        TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().cancelTaskRequests(this.myContext, multiSrcAsyncHttpRequest);
    }

    @Override // com.baidu.down.request.task.BinaryReqTask, com.baidu.down.request.task.AbstractTask
    public String getDefaultUrl() {
        if (!TextUtils.isEmpty(this.mDownloadUri)) {
            return this.mDownloadUri;
        }
        return this.mUri;
    }

    public HttpDNSInfo getDownloadIpInfo(String str) {
        TreeSet<HttpDNSInfo> treeSet = this.mPriorityHttpDNSInfoSet;
        if (treeSet == null || treeSet.size() <= 0) {
            return null;
        }
        Iterator<HttpDNSInfo> it = this.mPriorityHttpDNSInfoSet.iterator();
        while (it.hasNext()) {
            HttpDNSInfo next = it.next();
            if (str == next.mUrl) {
                return next;
            }
        }
        return null;
    }

    @Override // com.baidu.down.request.task.BinaryReqTask, com.baidu.down.request.task.AbstractTask
    public String getFastestUrl() {
        TreeSet<HttpDNSInfo> treeSet = this.mPriorityHttpDNSInfoSet;
        if (treeSet != null && treeSet.size() > 0) {
            Iterator<HttpDNSInfo> it = this.mPriorityHttpDNSInfoSet.iterator();
            while (it.hasNext()) {
                HttpDNSInfo next = it.next();
                if (next.mStatus == 2) {
                    return next.mUrl;
                }
            }
        }
        return getDefaultUrl();
    }

    public HttpDNSInfo getFirstAvailableDownloadIpInfo() {
        TreeSet<HttpDNSInfo> treeSet = new TreeSet<>((SortedSet<HttpDNSInfo>) this.mPriorityHttpDNSInfoSet);
        this.mPriorityHttpDNSInfoSet = treeSet;
        Iterator<HttpDNSInfo> it = treeSet.iterator();
        while (it.hasNext()) {
            HttpDNSInfo next = it.next();
            if (next.mStatus == 2) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    @Override // com.baidu.down.request.task.BinaryReqTask, com.baidu.down.request.task.AbstractTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getNoMeasuredUrl(boolean z) {
        Iterator<HttpDNSInfo> it = this.mPriorityHttpDNSInfoSet.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            HttpDNSInfo next = it.next();
            if (next.mStatus != 3) {
                i2++;
            }
            if (i2 > this.mMaxTestIpCount) {
                break;
            } else if (next.mStatus == 0) {
                if (z) {
                    next.mStatus = 1;
                    next.mTestSpeedThread++;
                }
                return next.mUrl;
            }
        }
        Iterator<HttpDNSInfo> it2 = this.mPriorityHttpDNSInfoSet.iterator();
        while (it2.hasNext()) {
            HttpDNSInfo next2 = it2.next();
            int i3 = next2.mStatus;
            if (i3 == 1 || i3 == 2) {
                if (z) {
                    next2.mTestSpeedThread++;
                }
                return next2.mUrl;
            }
            while (it2.hasNext()) {
            }
        }
        multiSrcToNormal();
        return null;
    }

    public TreeSet<HttpDNSInfo> getPriorityDownloadIpInfoSet() {
        return this.mPriorityHttpDNSInfoSet;
    }

    public String getWorkingDownloadIpInfoStat() {
        HttpDNSInfo next;
        TreeSet<HttpDNSInfo> treeSet = this.mPriorityHttpDNSInfoSet;
        if (treeSet == null || treeSet.size() <= 0) {
            return "";
        }
        Iterator<HttpDNSInfo> it = this.mPriorityHttpDNSInfoSet.iterator();
        String str = "";
        while (it.hasNext()) {
            if (it.next().mIsWorking == 1) {
                if (str.equals("")) {
                    str = next.mCDNSequence + "";
                } else {
                    str = str + "@" + next.mCDNSequence;
                }
            }
        }
        return str;
    }

    public boolean isDownInfoNeedRequest() {
        String wifiOr2gOr3G = Utils.getWifiOr2gOr3G(this.mContext);
        return TextUtils.isEmpty(wifiOr2gOr3G) || !wifiOr2gOr3G.equals(this.mDownInfoVpn) || TextUtils.isEmpty(this.mDownloadUri);
    }

    public void multiSrcToNormal() {
        if (((MultiSrcBinaryTaskHandler) this.mTaskHandler).isNeedMultiSrc()) {
            ((MultiSrcBinaryTaskHandler) this.mTaskHandler).setTestSpeedStage(0);
            ((MultiSrcBinaryTaskHandler) this.mTaskHandler).setNeedMultiSrc(false);
            BinaryHttpResponseHandler binaryHttpResponseHandler = this.mTaskHandler;
            ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).mMultiSrcStatData.cstatus = 3;
            ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).mMultiSrcStatData.dyuse = 4;
            ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).mMultiSrcStatData.dbtype = 2;
            TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().cancelRequests(this.myContext, true, this.mTaskHandler);
            if (this.mProgressInfo.getSegmentCount() > 0) {
                ConnectManager.NetWorkType netWorkType = TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().getNetWorkType();
                for (ProgressInfo.Segment segment : this.mProgressInfo.getSegments()) {
                    long j = segment.current;
                    long j2 = segment.end;
                    if (j < j2) {
                        startSegment(j, j2, 0);
                        if (netWorkType == ConnectManager.NetWorkType.TYPE_2G) {
                            return;
                        }
                    }
                }
                return;
            }
            startSegment(0L, AbstractTask.minSegLen, 0);
        }
    }

    public void notifyTaskStatus(int i2) {
        if (DownPrefUtils.getString(this.mContext, DownPrefUtils.PREF_CONFI_IS_UPLOAD_LOG, "1").equals("1")) {
            switch (i2) {
                case 1004:
                case 1006:
                    if (((MultiSrcBinaryTaskHandler) this.mTaskHandler).isNeedStat()) {
                        StatisticPoster.getInstance(this.mContext).statisticDownload(this, 1);
                        break;
                    }
                    break;
                case 1005:
                    StatisticPoster.getInstance(this.mContext).statisticDownload(this, 2);
                    break;
                case 1008:
                    StatisticPoster.getInstance(this.mContext).statisticDownload(this, 0);
                    break;
            }
        }
        resetData();
    }

    public void resetData() {
        this.mIsDirectStart = false;
        Timer timer = this.mFetchHttpDNSDataOverTime;
        if (timer != null) {
            timer.cancel();
            this.mFetchHttpDNSDataOverTime = null;
        }
        Timer timer2 = this.mFetchServerDataOverTime;
        if (timer2 != null) {
            timer2.cancel();
            this.mFetchServerDataOverTime = null;
        }
        this.mPriorityHttpDNSInfoSet.clear();
        ((MultiSrcBinaryTaskHandler) this.mTaskHandler).cleanData();
    }

    public synchronized void retryServerInfo(OnFetchDataRequestListener onFetchDataRequestListener) {
        HttpDNSCacheInfo httpDNSCacheInfo = TaskFacade.getInstance(null).getBinaryTaskMng().getHttpDNSCacheInfo();
        boolean z = (httpDNSCacheInfo == null || httpDNSCacheInfo.isNeedRequest(this.mContext)) ? false : true;
        if (z && !isDownInfoNeedRequest()) {
            initHttpDNSInfo(httpDNSCacheInfo);
            ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.network = Utils.getWifiOr2gOr3G(this.mContext);
            onFetchDataRequestListener.afterRequest(true, null);
        } else if (!this.isRetryDownloadInfo) {
            this.isRetryDownloadInfo = true;
            this.mIsFetchHttpDnsData = z ? false : true;
            ArrayList arrayList = new ArrayList();
            this.mOnFetchDataRequestListener = arrayList;
            arrayList.add(onFetchDataRequestListener);
            onFetchServerDataRequest(new OnFetchDataRequestListener() { // from class: com.baidu.down.request.task.MultiSrcBinaryReqTask.4
                @Override // com.baidu.down.request.taskmanager.OnFetchDataRequestListener
                public void afterRequest(boolean z2, TreeSet<HttpDNSInfo> treeSet) {
                    if (z2) {
                        MultiSrcBinaryReqTask multiSrcBinaryReqTask = MultiSrcBinaryReqTask.this;
                        if ((multiSrcBinaryReqTask.mDownInfoMode & 1) == 1) {
                            if (!multiSrcBinaryReqTask.mIsFetchHttpDnsData) {
                                MultiSrcBinaryReqTask.this.initHttpDNSInfo(TaskFacade.getInstance(null).getBinaryTaskMng().getHttpDNSCacheInfo());
                            } else {
                                if (treeSet != null) {
                                    MultiSrcBinaryReqTask.this.mPriorityHttpDNSInfoSet = treeSet;
                                }
                                ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).setNeedTestSpeed(true);
                            }
                            ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).setNeedMultiSrc(true);
                            if (((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).isNeedTestSpeed()) {
                                ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).setTestSpeedStage(1);
                            }
                        } else {
                            ((MultiSrcBinaryTaskHandler) multiSrcBinaryReqTask.mTaskHandler).setNeedMultiSrc(false);
                        }
                        MultiSrcBinaryReqTask multiSrcBinaryReqTask2 = MultiSrcBinaryReqTask.this;
                        ((MultiSrcBinaryTaskHandler) multiSrcBinaryReqTask2.mTaskHandler).mMultiSrcStatData.network = Utils.getWifiOr2gOr3G(multiSrcBinaryReqTask2.mContext);
                    } else {
                        ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).setNeedMultiSrc(false);
                    }
                    for (int i2 = 0; i2 < MultiSrcBinaryReqTask.this.mOnFetchDataRequestListener.size(); i2++) {
                        ((OnFetchDataRequestListener) MultiSrcBinaryReqTask.this.mOnFetchDataRequestListener.get(i2)).afterRequest(z2, treeSet);
                    }
                    MultiSrcBinaryReqTask.this.mOnFetchDataRequestListener.clear();
                    MultiSrcBinaryReqTask.this.isRetryDownloadInfo = false;
                }
            });
        } else {
            this.mOnFetchDataRequestListener.add(onFetchDataRequestListener);
        }
    }

    public void savePriorityDownloadIpConnectTime(String str, long j) {
        TreeSet<HttpDNSInfo> treeSet = this.mPriorityHttpDNSInfoSet;
        if (treeSet == null || treeSet.size() <= 0) {
            return;
        }
        Iterator<HttpDNSInfo> it = this.mPriorityHttpDNSInfoSet.iterator();
        while (it.hasNext()) {
            HttpDNSInfo next = it.next();
            if (str.equals(next.mUrl)) {
                next.mHttpConnectTime.add(Long.valueOf(j));
            }
        }
    }

    public void setHttpDNSInfoStatus(String str, int i2) {
        TreeSet<HttpDNSInfo> treeSet = this.mPriorityHttpDNSInfoSet;
        if (treeSet == null || treeSet.size() <= 0) {
            return;
        }
        Iterator<HttpDNSInfo> it = this.mPriorityHttpDNSInfoSet.iterator();
        while (it.hasNext()) {
            HttpDNSInfo next = it.next();
            if (str.equals(next.mUrl)) {
                if (i2 == 2 && next.mStatus != 1) {
                    return;
                }
                next.mStatus = i2;
            }
        }
    }

    @Override // com.baidu.down.request.task.BinaryReqTask, com.baidu.down.request.task.AbstractTask
    public void start() {
        if (TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().getNetWorkType() == ConnectManager.NetWorkType.TYPE_2G) {
            ((MultiSrcBinaryTaskHandler) this.mTaskHandler).setNeedMultiSrc(false);
            BinaryHttpResponseHandler binaryHttpResponseHandler = this.mTaskHandler;
            ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).mMultiSrcStatData.cstatus = 4;
            ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).mMultiSrcStatData.dyuse = 5;
            ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).mMultiSrcStatData.dbtype = 4;
        } else {
            if (!this.mIsDirectStart) {
                HttpDNSCacheInfo httpDNSCacheInfo = TaskFacade.getInstance(null).getBinaryTaskMng().getHttpDNSCacheInfo();
                if (httpDNSCacheInfo != null && httpDNSCacheInfo.isHttpDNSInAvailable(this.mContext)) {
                    this.mIsFetchHttpDnsData = false;
                    if (isDownInfoNeedRequest()) {
                        this.mIsDirectStart = false;
                    } else {
                        this.mIsDirectStart = true;
                        ((MultiSrcBinaryTaskHandler) this.mTaskHandler).setNeedMultiSrc(false);
                    }
                } else if (httpDNSCacheInfo != null && !httpDNSCacheInfo.isNeedRequest(this.mContext)) {
                    this.mIsFetchHttpDnsData = false;
                    if (TaskFacade.getInstance(null).getBinaryTaskMng().getPatternConfig().patternType == 1) {
                        if (isDownInfoNeedRequest()) {
                            this.mIsDirectStart = false;
                        } else {
                            this.mIsDirectStart = true;
                            initHttpDNSInfo(httpDNSCacheInfo);
                        }
                    }
                } else {
                    this.mIsFetchHttpDnsData = true;
                }
            }
            if (!this.mIsDirectStart) {
                if (TaskFacade.getInstance(null).getBinaryTaskMng().getPatternConfig().patternType != 1) {
                    return;
                }
                onFetchServerDataRequest(new OnFetchDataRequestListener() { // from class: com.baidu.down.request.task.MultiSrcBinaryReqTask.1
                    @Override // com.baidu.down.request.taskmanager.OnFetchDataRequestListener
                    public void afterRequest(boolean z, TreeSet<HttpDNSInfo> treeSet) {
                        MultiSrcBinaryReqTask.this.mIsDirectStart = true;
                        if (z) {
                            HttpDNSCacheInfo httpDNSCacheInfo2 = TaskFacade.getInstance(null).getBinaryTaskMng().getHttpDNSCacheInfo();
                            if (httpDNSCacheInfo2 != null && httpDNSCacheInfo2.isHttpDNSInAvailable(MultiSrcBinaryReqTask.this.mContext)) {
                                ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).setNeedMultiSrc(false);
                                ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dbtype = 0;
                            } else {
                                MultiSrcBinaryReqTask multiSrcBinaryReqTask = MultiSrcBinaryReqTask.this;
                                if ((multiSrcBinaryReqTask.mDownInfoMode & 1) == 1) {
                                    if (!multiSrcBinaryReqTask.mIsFetchHttpDnsData) {
                                        MultiSrcBinaryReqTask.this.initHttpDNSInfo(httpDNSCacheInfo2);
                                    } else if (treeSet != null) {
                                        MultiSrcBinaryReqTask.this.mPriorityHttpDNSInfoSet = treeSet;
                                    }
                                    ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).setNeedMultiSrc(true);
                                } else {
                                    ((MultiSrcBinaryTaskHandler) multiSrcBinaryReqTask.mTaskHandler).setNeedMultiSrc(false);
                                    ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dbtype = 0;
                                }
                            }
                        } else {
                            ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).setNeedMultiSrc(false);
                            ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dbtype = 0;
                        }
                        MultiSrcBinaryReqTask.this.start();
                    }
                });
                return;
            }
            BinaryHttpResponseHandler binaryHttpResponseHandler2 = this.mTaskHandler;
            ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler2).mMultiSrcStatData.tnum = this.mMaxThread;
            ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler2).mMultiSrcStatData.network = Utils.getWifiOr2gOr3G(this.mContext);
            ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.sid = this.mSid;
        }
        super.start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
        r2 = r7.mTotalBytes;
        r1.mDownloadBytes = r2;
        r4 = r7.mTotalTimes;
        r1.mDownloadTimes = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
        if (r2 >= r6.mTestSpeedDataSize) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
        if (r4 < r6.mTestSpeedDuration) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
        if (r6.mTaskHandler.getTestSpeedStage() != 1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
        r6.mTaskHandler.setTestSpeedStage(2);
        checkAndAdjustByAverageSpeed();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void updateAverageSpeed(MultiSrcTaskMsg multiSrcTaskMsg) {
        if (this.mPriorityHttpDNSInfoSet != null && this.mPriorityHttpDNSInfoSet.size() > 0) {
            Iterator<HttpDNSInfo> it = this.mPriorityHttpDNSInfoSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                HttpDNSInfo next = it.next();
                if (next.mUrl.equals(multiSrcTaskMsg.mUrl)) {
                    break;
                }
            }
        }
    }
}
