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
/* loaded from: classes15.dex */
public class MultiSrcBinaryReqTask extends BinaryReqTask {
    private static final boolean DEBUG = false;
    private static final String DOWNFLOW_DOWNLOAD_INNER = "download_inner";
    private static final String DOWNFLOW_DYRES = "dyres";
    private static final String DOWNFLOW_DYSTAT = "dystat";
    private static final String DOWNFLOW_ERROR_NO = "error_no";
    private static final String DOWNFLOW_FRES = "fres";
    private static final String DOWNFLOW_FSTAT = "fstat";
    private static final String DOWNFLOW_MODE = "mode";
    private static final String DOWNFLOW_SID = "sid";
    private static final String DOWNFLOW_TN = "tn";
    private static final long DOWNLOAD_SPEED_TIME_THRESHOLD = 5;
    private static final String HTTP_DNS_CDN_DATA = "data";
    private static final String HTTP_DNS_CDN_HOST = "host";
    private static final String HTTP_DNS_CDN_LIVE_TIME = "live_time";
    private static final String HTTP_DNS_CDN_STATUS = "status";
    private static final String HTTP_DNS_CDN_VIPS = "vips";
    private static final String HTTP_DNS_CDN_XCODE = "xcode";
    private static final String TAG = "MultiSrcBinaryReqTask";
    private boolean isRetryDownloadInfo;
    private String mDownInfoVpn;
    private long mFetchHttpDNSDataElapsedTime;
    private Timer mFetchHttpDNSDataOverTime;
    private long mFetchServerDataElapsedTime;
    private Timer mFetchServerDataOverTime;
    private boolean mIsDirectStart;
    private boolean mIsFetchHttpDnsData;
    private List<OnFetchDataRequestListener> mOnFetchDataRequestListener;
    public int mPauseNum;
    private TreeSet<HttpDNSInfo> mPriorityHttpDNSInfoSet;
    private long mTestSpeedDataSize;
    private long mTestSpeedDuration;

    public MultiSrcBinaryReqTask(Context context, FileMsg fileMsg) {
        super(context, fileMsg);
        this.mIsDirectStart = false;
        this.mIsFetchHttpDnsData = true;
        this.mPauseNum = 0;
        this.isRetryDownloadInfo = false;
        this.mPriorityHttpDNSInfoSet = new TreeSet<>();
        this.mTaskHandler = new MultiSrcBinaryTaskHandler(this);
        this.mTaskHandler.setCurTask(this);
        this.mTestSpeedDataSize = DownPrefUtils.testConfigurationGetLong(this.mContext, DownPrefUtils.PREF_CONFIG_TEST_SPEED_DATA_SIZE, 512L) * 1024;
        this.mTestSpeedDuration = DownPrefUtils.testConfigurationGetLong(this.mContext, DownPrefUtils.PREF_CONFIG_TEST_SPEED_DURATION, 15L) * 1000;
    }

    @Override // com.baidu.down.request.task.BinaryReqTask, com.baidu.down.request.task.AbstractTask
    public String getFastestUrl() {
        if (this.mPriorityHttpDNSInfoSet != null && this.mPriorityHttpDNSInfoSet.size() > 0) {
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

    public void savePriorityDownloadIpConnectTime(String str, long j) {
        if (this.mPriorityHttpDNSInfoSet != null && this.mPriorityHttpDNSInfoSet.size() > 0) {
            Iterator<HttpDNSInfo> it = this.mPriorityHttpDNSInfoSet.iterator();
            while (it.hasNext()) {
                HttpDNSInfo next = it.next();
                if (str.equals(next.mUrl)) {
                    next.mHttpConnectTime.add(Long.valueOf(j));
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    @Override // com.baidu.down.request.task.BinaryReqTask, com.baidu.down.request.task.AbstractTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getNoMeasuredUrl(boolean z) {
        Iterator<HttpDNSInfo> it = this.mPriorityHttpDNSInfoSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            HttpDNSInfo next = it.next();
            if (next.mStatus != 3) {
                i++;
            }
            if (i > this.mMaxTestIpCount) {
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
            if (next2.mStatus == 1 || next2.mStatus == 2) {
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

    public void multiSrcToNormal() {
        if (((MultiSrcBinaryTaskHandler) this.mTaskHandler).isNeedMultiSrc()) {
            ((MultiSrcBinaryTaskHandler) this.mTaskHandler).setTestSpeedStage(0);
            ((MultiSrcBinaryTaskHandler) this.mTaskHandler).setNeedMultiSrc(false);
            ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.cstatus = 3;
            ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.dyuse = 4;
            ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.dbtype = 2;
            TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().cancelRequests(this.myContext, true, this.mTaskHandler);
            if (this.mProgressInfo.getSegmentCount() > 0) {
                ConnectManager.NetWorkType netWorkType = TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().getNetWorkType();
                for (ProgressInfo.Segment segment : this.mProgressInfo.getSegments()) {
                    if (segment.current < segment.end) {
                        startSegment(segment.current, segment.end, 0);
                        if (netWorkType == ConnectManager.NetWorkType.TYPE_2G) {
                            return;
                        }
                    }
                }
                return;
            }
            startSegment(0L, minSegLen, 0);
        }
    }

    @Override // com.baidu.down.request.task.BinaryReqTask, com.baidu.down.request.task.AbstractTask
    public String getDefaultUrl() {
        return !TextUtils.isEmpty(this.mDownloadUri) ? this.mDownloadUri : this.mUri;
    }

    public void setHttpDNSInfoStatus(String str, int i) {
        if (this.mPriorityHttpDNSInfoSet != null && this.mPriorityHttpDNSInfoSet.size() > 0) {
            Iterator<HttpDNSInfo> it = this.mPriorityHttpDNSInfoSet.iterator();
            while (it.hasNext()) {
                HttpDNSInfo next = it.next();
                if (str.equals(next.mUrl)) {
                    if (i != 2 || next.mStatus == 1) {
                        next.mStatus = i;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
        r0.mDownloadBytes = r7.mTotalBytes;
        r0.mDownloadTimes = r7.mTotalTimes;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
        if (r0.mDownloadBytes >= r6.mTestSpeedDataSize) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (r0.mDownloadTimes < r6.mTestSpeedDuration) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
        r0 = r6.mTaskHandler.getTestSpeedStage();
        r1 = r6.mTaskHandler;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
        if (r0 != 1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
        r0 = r6.mTaskHandler;
        r1 = r6.mTaskHandler;
        r0.setTestSpeedStage(2);
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

    @Override // com.baidu.down.request.task.BinaryReqTask, com.baidu.down.request.task.AbstractTask
    public void start() {
        if (TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().getNetWorkType() == ConnectManager.NetWorkType.TYPE_2G) {
            ((MultiSrcBinaryTaskHandler) this.mTaskHandler).setNeedMultiSrc(false);
            ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.cstatus = 4;
            ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.dyuse = 5;
            ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.dbtype = 4;
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
                    switch (TaskFacade.getInstance(null).getBinaryTaskMng().getPatternConfig().patternType) {
                        case 1:
                            if (isDownInfoNeedRequest()) {
                                this.mIsDirectStart = false;
                                break;
                            } else {
                                this.mIsDirectStart = true;
                                initHttpDNSInfo(httpDNSCacheInfo);
                                break;
                            }
                    }
                } else {
                    this.mIsFetchHttpDnsData = true;
                }
            }
            if (!this.mIsDirectStart) {
                switch (TaskFacade.getInstance(null).getBinaryTaskMng().getPatternConfig().patternType) {
                    case 1:
                        onFetchServerDataRequest(new OnFetchDataRequestListener() { // from class: com.baidu.down.request.task.MultiSrcBinaryReqTask.1
                            @Override // com.baidu.down.request.taskmanager.OnFetchDataRequestListener
                            public void afterRequest(boolean z, TreeSet<HttpDNSInfo> treeSet) {
                                MultiSrcBinaryReqTask.this.mIsDirectStart = true;
                                if (z) {
                                    HttpDNSCacheInfo httpDNSCacheInfo2 = TaskFacade.getInstance(null).getBinaryTaskMng().getHttpDNSCacheInfo();
                                    if (httpDNSCacheInfo2 != null && httpDNSCacheInfo2.isHttpDNSInAvailable(MultiSrcBinaryReqTask.this.mContext)) {
                                        ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).setNeedMultiSrc(false);
                                        ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dbtype = 0;
                                    } else if ((MultiSrcBinaryReqTask.this.mDownInfoMode & 1) == 1) {
                                        if (!MultiSrcBinaryReqTask.this.mIsFetchHttpDnsData) {
                                            MultiSrcBinaryReqTask.this.initHttpDNSInfo(httpDNSCacheInfo2);
                                        } else if (treeSet != null) {
                                            MultiSrcBinaryReqTask.this.mPriorityHttpDNSInfoSet = treeSet;
                                        }
                                        ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).setNeedMultiSrc(true);
                                    } else {
                                        ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).setNeedMultiSrc(false);
                                        ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dbtype = 0;
                                    }
                                } else {
                                    ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).setNeedMultiSrc(false);
                                    ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dbtype = 0;
                                }
                                MultiSrcBinaryReqTask.this.start();
                            }
                        });
                        return;
                    default:
                        return;
                }
            }
            ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.tnum = this.mMaxThread;
            ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.network = Utils.getWifiOr2gOr3G(this.mContext);
            ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.sid = this.mSid;
        }
        super.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parserHttpDNSData(JSONObject jSONObject, OnFetchDataRequestListener onFetchDataRequestListener, TreeSet<HttpDNSInfo> treeSet, HttpDNSCacheInfo httpDNSCacheInfo) {
        if (jSONObject != null) {
            try {
                if (jSONObject != null) {
                    try {
                        String string = jSONObject.getString("data");
                        if (!TextUtils.isEmpty(string)) {
                            String host = new URL(getReplaceIpUrl()).getHost();
                            String decryptCdnData = CryptUtil.decryptCdnData(this.mContext, string);
                            if (!TextUtils.isEmpty(decryptCdnData)) {
                                JSONObject jSONObject2 = new JSONObject(decryptCdnData);
                                int optInt = jSONObject.optInt("status");
                                if (optInt == 0) {
                                    JSONArray optJSONArray = jSONObject2.optJSONArray(HTTP_DNS_CDN_VIPS);
                                    String optString = jSONObject2.optString(HTTP_DNS_CDN_XCODE);
                                    httpDNSCacheInfo.mXCode = optString;
                                    this.mHost = jSONObject2.optString(HTTP_DNS_CDN_HOST);
                                    httpDNSCacheInfo.mHost = this.mHost;
                                    httpDNSCacheInfo.mIpLiveTime = jSONObject2.optInt(HTTP_DNS_CDN_LIVE_TIME);
                                    httpDNSCacheInfo.mApn = Utils.getWifiOr2gOr3G(this.mContext);
                                    httpDNSCacheInfo.mRequestTime = SystemClock.elapsedRealtime();
                                    if (optJSONArray != null && !TextUtils.isEmpty(this.mHost)) {
                                        for (int i = 0; i < optJSONArray.length(); i++) {
                                            if (Utils.isIpAddress(optJSONArray.getString(i))) {
                                                HttpDNSInfo httpDNSInfo = new HttpDNSInfo();
                                                httpDNSInfo.mUrl = getReplaceIpUrl().replace(host, optJSONArray.getString(i));
                                                if (Utils.isUrlContainsQ(httpDNSInfo.mUrl)) {
                                                    httpDNSInfo.mUrl += "&xcode=" + optString;
                                                } else {
                                                    httpDNSInfo.mUrl += "?xcode=" + optString;
                                                }
                                                httpDNSInfo.mCDNSequence = i;
                                                httpDNSInfo.mCNDIp = optJSONArray.getString(i);
                                                treeSet.add(httpDNSInfo);
                                                httpDNSCacheInfo.mIpList.add(optJSONArray.getString(i));
                                            }
                                        }
                                    }
                                } else if (optInt == 1) {
                                    httpDNSCacheInfo.mIpLiveTime = 600;
                                    httpDNSCacheInfo.mApn = Utils.getWifiOr2gOr3G(this.mContext);
                                    httpDNSCacheInfo.mRequestTime = SystemClock.elapsedRealtime();
                                }
                                httpDNSCacheInfo.mStatus = optInt;
                            }
                        }
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void onFetchServerDataRequest(final OnFetchDataRequestListener onFetchDataRequestListener) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        TimerTask timerTask = new TimerTask() { // from class: com.baidu.down.request.task.MultiSrcBinaryReqTask.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (MultiSrcBinaryReqTask.this.mFetchServerDataOverTime != null) {
                    MultiSrcBinaryReqTask.this.mFetchServerDataOverTime = null;
                    if (onFetchDataRequestListener != null) {
                        onFetchDataRequestListener.afterRequest(false, null);
                    }
                    MultiSrcBinaryReqTask.this.mFetchServerDataElapsedTime = SystemClock.elapsedRealtime() - elapsedRealtime;
                    ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dfstat = 2;
                    ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dfcost = MultiSrcBinaryReqTask.this.mFetchServerDataElapsedTime;
                }
            }
        };
        this.mFetchServerDataOverTime = new Timer();
        this.mFetchServerDataOverTime.schedule(timerTask, DownPrefUtils.testConfigurationGetLong(this.mContext, DownPrefUtils.PREF_CONFIG_DOWNINFO_URL_TIMEOUT, 15L) * 1000);
        this.mDownInfoVpn = Utils.getWifiOr2gOr3G(this.mContext);
        TaskNetRequestMng.requestRemoteConfig(this.mContext, this.mDownloadType, this.mFromParam, this.mTj, this.mUri, this.mIsFetchHttpDnsData, this.mDownInfoParams, this.mSize, new HttpURLExecutorRunnable.OnWebRequestListener() { // from class: com.baidu.down.request.task.MultiSrcBinaryReqTask.3
            @Override // com.baidu.down.loopj.android.urlconnection.HttpURLExecutorRunnable.OnWebRequestListener
            public void onSuccess(String str) {
                if (MultiSrcBinaryReqTask.this.mFetchServerDataOverTime != null) {
                    MultiSrcBinaryReqTask.this.mFetchServerDataOverTime.cancel();
                    MultiSrcBinaryReqTask.this.mFetchServerDataOverTime = null;
                    MultiSrcBinaryReqTask.this.mFetchServerDataElapsedTime = SystemClock.elapsedRealtime() - elapsedRealtime;
                    ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dfcost = MultiSrcBinaryReqTask.this.mFetchServerDataElapsedTime;
                    ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dfstat = 0;
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.optInt(MultiSrcBinaryReqTask.DOWNFLOW_ERROR_NO) == 0) {
                                JSONObject optJSONObject = jSONObject.optJSONObject(MultiSrcBinaryReqTask.DOWNFLOW_FRES);
                                if (jSONObject.optInt(MultiSrcBinaryReqTask.DOWNFLOW_FSTAT, 1) == 0 && optJSONObject != null && !optJSONObject.optString(MultiSrcBinaryReqTask.DOWNFLOW_DOWNLOAD_INNER).equals("")) {
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
                                    MultiSrcBinaryReqTask.this.mDownloadUri = optJSONObject.optString(MultiSrcBinaryReqTask.DOWNFLOW_DOWNLOAD_INNER, "");
                                    TaskFacade.getInstance(null).getBinaryTaskMng().addStatsticMap(Long.valueOf(MultiSrcBinaryReqTask.this.mDownloadId), statisticInfo);
                                    if ((MultiSrcBinaryReqTask.this.mDownInfoMode & 1) == 1) {
                                        if (MultiSrcBinaryReqTask.this.mIsFetchHttpDnsData) {
                                            TreeSet<HttpDNSInfo> treeSet = new TreeSet<>();
                                            HttpDNSCacheInfo httpDNSCacheInfo = new HttpDNSCacheInfo();
                                            ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dyget = jSONObject.optInt(MultiSrcBinaryReqTask.DOWNFLOW_DYSTAT, 1);
                                            if (jSONObject.optInt(MultiSrcBinaryReqTask.DOWNFLOW_DYSTAT, 1) == 0) {
                                                MultiSrcBinaryReqTask.this.parserHttpDNSData(jSONObject.optJSONObject(MultiSrcBinaryReqTask.DOWNFLOW_DYRES), onFetchDataRequestListener, treeSet, httpDNSCacheInfo);
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
                        } catch (Exception e) {
                            e.printStackTrace();
                            ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dfstat = 1;
                        }
                    }
                    ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dyuse = 8;
                    if (onFetchDataRequestListener != null) {
                        onFetchDataRequestListener.afterRequest(false, null);
                    }
                }
            }

            @Override // com.baidu.down.loopj.android.urlconnection.HttpURLExecutorRunnable.OnWebRequestListener
            public void onFailed() {
                if (MultiSrcBinaryReqTask.this.mFetchServerDataOverTime != null) {
                    MultiSrcBinaryReqTask.this.mFetchServerDataOverTime.cancel();
                    MultiSrcBinaryReqTask.this.mFetchServerDataOverTime = null;
                    if (onFetchDataRequestListener != null) {
                        onFetchDataRequestListener.afterRequest(false, null);
                    }
                    MultiSrcBinaryReqTask.this.mFetchServerDataElapsedTime = SystemClock.elapsedRealtime() - elapsedRealtime;
                    ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dfstat = 1;
                    ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.dfcost = MultiSrcBinaryReqTask.this.mFetchServerDataElapsedTime;
                }
            }
        });
    }

    public void resetData() {
        this.mIsDirectStart = false;
        if (this.mFetchHttpDNSDataOverTime != null) {
            this.mFetchHttpDNSDataOverTime.cancel();
            this.mFetchHttpDNSDataOverTime = null;
        }
        if (this.mFetchServerDataOverTime != null) {
            this.mFetchServerDataOverTime.cancel();
            this.mFetchServerDataOverTime = null;
        }
        this.mPriorityHttpDNSInfoSet.clear();
        ((MultiSrcBinaryTaskHandler) this.mTaskHandler).cleanData();
    }

    public void addAsyncRequest(ProgressInfo.Segment segment) {
        startSegment(segment.current, segment.end, 2);
    }

    public void cancelAsyncRequest(MultiSrcAsyncHttpRequest multiSrcAsyncHttpRequest) {
        multiSrcAsyncHttpRequest.stopRequestRunning();
        TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().cancelTaskRequests(this.myContext, multiSrcAsyncHttpRequest);
    }

    public HttpDNSInfo getFirstAvailableDownloadIpInfo() {
        this.mPriorityHttpDNSInfoSet = new TreeSet<>((SortedSet<HttpDNSInfo>) this.mPriorityHttpDNSInfoSet);
        Iterator<HttpDNSInfo> it = this.mPriorityHttpDNSInfoSet.iterator();
        while (it.hasNext()) {
            HttpDNSInfo next = it.next();
            if (next.mStatus == 2) {
                return next;
            }
        }
        return null;
    }

    public String getWorkingDownloadIpInfoStat() {
        HttpDNSInfo next;
        String str;
        String str2 = "";
        if (this.mPriorityHttpDNSInfoSet != null && this.mPriorityHttpDNSInfoSet.size() > 0) {
            Iterator<HttpDNSInfo> it = this.mPriorityHttpDNSInfoSet.iterator();
            while (it.hasNext()) {
                if (it.next().mIsWorking != 1) {
                    str = str2;
                } else if (str2.equals("")) {
                    str = next.mCDNSequence + "";
                } else {
                    str = str2 + "@" + next.mCDNSequence;
                }
                str2 = str;
            }
        }
        return str2;
    }

    public TreeSet<HttpDNSInfo> getPriorityDownloadIpInfoSet() {
        return this.mPriorityHttpDNSInfoSet;
    }

    public synchronized void retryServerInfo(OnFetchDataRequestListener onFetchDataRequestListener) {
        synchronized (this) {
            HttpDNSCacheInfo httpDNSCacheInfo = TaskFacade.getInstance(null).getBinaryTaskMng().getHttpDNSCacheInfo();
            boolean z = (httpDNSCacheInfo == null || httpDNSCacheInfo.isNeedRequest(this.mContext)) ? false : true;
            if (z && !isDownInfoNeedRequest()) {
                initHttpDNSInfo(httpDNSCacheInfo);
                ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.network = Utils.getWifiOr2gOr3G(this.mContext);
                onFetchDataRequestListener.afterRequest(true, null);
            } else if (!this.isRetryDownloadInfo) {
                this.isRetryDownloadInfo = true;
                this.mIsFetchHttpDnsData = z ? false : true;
                this.mOnFetchDataRequestListener = new ArrayList();
                this.mOnFetchDataRequestListener.add(onFetchDataRequestListener);
                onFetchServerDataRequest(new OnFetchDataRequestListener() { // from class: com.baidu.down.request.task.MultiSrcBinaryReqTask.4
                    @Override // com.baidu.down.request.taskmanager.OnFetchDataRequestListener
                    public void afterRequest(boolean z2, TreeSet<HttpDNSInfo> treeSet) {
                        if (z2) {
                            if ((MultiSrcBinaryReqTask.this.mDownInfoMode & 1) == 1) {
                                if (!MultiSrcBinaryReqTask.this.mIsFetchHttpDnsData) {
                                    MultiSrcBinaryReqTask.this.initHttpDNSInfo(TaskFacade.getInstance(null).getBinaryTaskMng().getHttpDNSCacheInfo());
                                } else {
                                    if (treeSet != null) {
                                        MultiSrcBinaryReqTask.this.mPriorityHttpDNSInfoSet = treeSet;
                                    }
                                    ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).setNeedTestSpeed(true);
                                }
                                ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).setNeedMultiSrc(true);
                                if (((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).isNeedTestSpeed()) {
                                    BinaryHttpResponseHandler binaryHttpResponseHandler = MultiSrcBinaryReqTask.this.mTaskHandler;
                                    ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).setTestSpeedStage(1);
                                }
                            } else {
                                ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).setNeedMultiSrc(false);
                            }
                            ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).mMultiSrcStatData.network = Utils.getWifiOr2gOr3G(MultiSrcBinaryReqTask.this.mContext);
                        } else {
                            ((MultiSrcBinaryTaskHandler) MultiSrcBinaryReqTask.this.mTaskHandler).setNeedMultiSrc(false);
                        }
                        for (int i = 0; i < MultiSrcBinaryReqTask.this.mOnFetchDataRequestListener.size(); i++) {
                            ((OnFetchDataRequestListener) MultiSrcBinaryReqTask.this.mOnFetchDataRequestListener.get(i)).afterRequest(z2, treeSet);
                        }
                        MultiSrcBinaryReqTask.this.mOnFetchDataRequestListener.clear();
                        MultiSrcBinaryReqTask.this.isRetryDownloadInfo = false;
                    }
                });
            } else {
                this.mOnFetchDataRequestListener.add(onFetchDataRequestListener);
            }
        }
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
                        if (!firstAvailableDownloadIpInfo.mUrl.equals(multiSrcAsyncHttpRequest.mRequestUrl) && testAverageSpeed != 0 && (multiSrcAsyncHttpRequest.mAverageSpeed / testAverageSpeed) * 100 < 100 - testConfigurationGetLong && testAverageSpeed - multiSrcAsyncHttpRequest.mAverageSpeed > testConfigurationGetLong2) {
                            long segEndByPos = this.mProgressInfo.getSegEndByPos(multiSrcAsyncHttpRequest.mCurFilePos);
                            if (multiSrcAsyncHttpRequest.mAverageSpeed == 0) {
                                j = 2147483647L;
                            } else {
                                j = ((segEndByPos - multiSrcAsyncHttpRequest.mRequestBytes) / multiSrcAsyncHttpRequest.mAverageSpeed) - ((segEndByPos - multiSrcAsyncHttpRequest.mRequestBytes) / testAverageSpeed);
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

    public HttpDNSInfo getDownloadIpInfo(String str) {
        if (this.mPriorityHttpDNSInfoSet != null && this.mPriorityHttpDNSInfoSet.size() > 0) {
            Iterator<HttpDNSInfo> it = this.mPriorityHttpDNSInfoSet.iterator();
            while (it.hasNext()) {
                HttpDNSInfo next = it.next();
                if (str == next.mUrl) {
                    return next;
                }
            }
        }
        return null;
    }

    public void notifyTaskStatus(int i) {
        if (DownPrefUtils.getString(this.mContext, DownPrefUtils.PREF_CONFI_IS_UPLOAD_LOG, "1").equals("1")) {
            switch (i) {
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

    private TreeSet<HttpDNSInfo> readHttpDNSCacheInfo(HttpDNSCacheInfo httpDNSCacheInfo, boolean z) {
        TreeSet<HttpDNSInfo> treeSet = new TreeSet<>();
        if (z) {
            try {
                String host = new URL(getReplaceIpUrl()).getHost();
                for (int i = 0; i < httpDNSCacheInfo.mIpList.size(); i++) {
                    if (Utils.isIpAddress(httpDNSCacheInfo.mIpList.get(i))) {
                        HttpDNSInfo httpDNSInfo = new HttpDNSInfo();
                        httpDNSInfo.mUrl = getReplaceIpUrl().replace(host, httpDNSCacheInfo.mIpList.get(i));
                        if (Utils.isUrlContainsQ(httpDNSInfo.mUrl)) {
                            httpDNSInfo.mUrl += "&xcode=" + httpDNSCacheInfo.mXCode;
                        } else {
                            httpDNSInfo.mUrl += "?xcode=" + httpDNSCacheInfo.mXCode;
                        }
                        httpDNSInfo.mCDNSequence = i;
                        httpDNSInfo.mCNDIp = httpDNSCacheInfo.mIpList.get(i);
                        treeSet.add(httpDNSInfo);
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            Iterator<HttpDNSInfo> it = httpDNSCacheInfo.mBackupHttpDNSInfoSet.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().clone(this.mDownloadUri, httpDNSCacheInfo.mXCode));
            }
        }
        this.mHost = httpDNSCacheInfo.mHost;
        ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.ccost = 0L;
        ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.cstatus = 6;
        return treeSet;
    }

    public boolean isDownInfoNeedRequest() {
        String wifiOr2gOr3G = Utils.getWifiOr2gOr3G(this.mContext);
        return TextUtils.isEmpty(wifiOr2gOr3G) || !wifiOr2gOr3G.equals(this.mDownInfoVpn) || TextUtils.isEmpty(this.mDownloadUri);
    }

    private String getReplaceIpUrl() {
        return TaskFacade.getInstance(null).getBinaryTaskMng().getPatternConfig().patternType == 1 ? this.mDownloadUri : this.mUri;
    }
}
