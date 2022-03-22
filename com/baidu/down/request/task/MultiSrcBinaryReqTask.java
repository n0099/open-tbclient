package com.baidu.down.request.task;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.down.utils.CryptUtil;
import com.baidu.down.utils.DownPrefUtils;
import com.baidu.down.utils.Utils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes3.dex */
public class MultiSrcBinaryReqTask extends BinaryReqTask {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiSrcBinaryReqTask(Context context, FileMsg fileMsg) {
        super(context, fileMsg);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, fileMsg};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (FileMsg) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
        List<WeakReference<AsyncHttpRequest>> taskHttpRequestList;
        long j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65548, this) == null) || (taskHttpRequestList = TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().getTaskHttpRequestList(this.myContext)) == null) {
            return;
        }
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

    private String getReplaceIpUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            if (TaskFacade.getInstance(null).getBinaryTaskMng().getPatternConfig().patternType == 1) {
                return this.mDownloadUri;
            }
            return this.mUri;
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initHttpDNSInfo(HttpDNSCacheInfo httpDNSCacheInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, httpDNSCacheInfo) == null) {
            ((MultiSrcBinaryTaskHandler) this.mTaskHandler).mMultiSrcStatData.dyuse = 0;
            if (httpDNSCacheInfo.mIsTestSpeed) {
                this.mPriorityHttpDNSInfoSet = readHttpDNSCacheInfo(httpDNSCacheInfo, false);
                ((MultiSrcBinaryTaskHandler) this.mTaskHandler).setNeedTestSpeed(false);
                return;
            }
            this.mPriorityHttpDNSInfoSet = readHttpDNSCacheInfo(httpDNSCacheInfo, true);
            ((MultiSrcBinaryTaskHandler) this.mTaskHandler).setNeedTestSpeed(true);
        }
    }

    private void onFetchServerDataRequest(OnFetchDataRequestListener onFetchDataRequestListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, onFetchDataRequestListener) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            TimerTask timerTask = new TimerTask(this, onFetchDataRequestListener, elapsedRealtime) { // from class: com.baidu.down.request.task.MultiSrcBinaryReqTask.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MultiSrcBinaryReqTask this$0;
                public final /* synthetic */ OnFetchDataRequestListener val$onRequestListener;
                public final /* synthetic */ long val$startTime;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, onFetchDataRequestListener, Long.valueOf(elapsedRealtime)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$onRequestListener = onFetchDataRequestListener;
                    this.val$startTime = elapsedRealtime;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mFetchServerDataOverTime == null) {
                        return;
                    }
                    this.this$0.mFetchServerDataOverTime = null;
                    OnFetchDataRequestListener onFetchDataRequestListener2 = this.val$onRequestListener;
                    if (onFetchDataRequestListener2 != null) {
                        onFetchDataRequestListener2.afterRequest(false, null);
                    }
                    this.this$0.mFetchServerDataElapsedTime = SystemClock.elapsedRealtime() - this.val$startTime;
                    MultiSrcBinaryReqTask multiSrcBinaryReqTask = this.this$0;
                    BinaryHttpResponseHandler binaryHttpResponseHandler = multiSrcBinaryReqTask.mTaskHandler;
                    ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).mMultiSrcStatData.dfstat = 2;
                    ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).mMultiSrcStatData.dfcost = multiSrcBinaryReqTask.mFetchServerDataElapsedTime;
                }
            };
            Timer timer = new Timer();
            this.mFetchServerDataOverTime = timer;
            timer.schedule(timerTask, DownPrefUtils.testConfigurationGetLong(this.mContext, DownPrefUtils.PREF_CONFIG_DOWNINFO_URL_TIMEOUT, 15L) * 1000);
            this.mDownInfoVpn = Utils.getWifiOr2gOr3G(this.mContext);
            TaskNetRequestMng.requestRemoteConfig(this.mContext, this.mDownloadType, this.mFromParam, this.mTj, this.mUri, this.mIsFetchHttpDnsData, this.mDownInfoParams, this.mSize, new HttpURLExecutorRunnable.OnWebRequestListener(this, elapsedRealtime, onFetchDataRequestListener) { // from class: com.baidu.down.request.task.MultiSrcBinaryReqTask.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ MultiSrcBinaryReqTask this$0;
                public final /* synthetic */ OnFetchDataRequestListener val$onRequestListener;
                public final /* synthetic */ long val$startTime;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(elapsedRealtime), onFetchDataRequestListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$startTime = elapsedRealtime;
                    this.val$onRequestListener = onFetchDataRequestListener;
                }

                @Override // com.baidu.down.loopj.android.urlconnection.HttpURLExecutorRunnable.OnWebRequestListener
                public void onFailed() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mFetchServerDataOverTime == null) {
                        return;
                    }
                    this.this$0.mFetchServerDataOverTime.cancel();
                    this.this$0.mFetchServerDataOverTime = null;
                    OnFetchDataRequestListener onFetchDataRequestListener2 = this.val$onRequestListener;
                    if (onFetchDataRequestListener2 != null) {
                        onFetchDataRequestListener2.afterRequest(false, null);
                    }
                    this.this$0.mFetchServerDataElapsedTime = SystemClock.elapsedRealtime() - this.val$startTime;
                    MultiSrcBinaryReqTask multiSrcBinaryReqTask = this.this$0;
                    BinaryHttpResponseHandler binaryHttpResponseHandler = multiSrcBinaryReqTask.mTaskHandler;
                    ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).mMultiSrcStatData.dfstat = 1;
                    ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).mMultiSrcStatData.dfcost = multiSrcBinaryReqTask.mFetchServerDataElapsedTime;
                }

                @Override // com.baidu.down.loopj.android.urlconnection.HttpURLExecutorRunnable.OnWebRequestListener
                public void onSuccess(String str) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || this.this$0.mFetchServerDataOverTime == null) {
                        return;
                    }
                    this.this$0.mFetchServerDataOverTime.cancel();
                    this.this$0.mFetchServerDataOverTime = null;
                    this.this$0.mFetchServerDataElapsedTime = SystemClock.elapsedRealtime() - this.val$startTime;
                    MultiSrcBinaryReqTask multiSrcBinaryReqTask = this.this$0;
                    ((MultiSrcBinaryTaskHandler) multiSrcBinaryReqTask.mTaskHandler).mMultiSrcStatData.dfcost = multiSrcBinaryReqTask.mFetchServerDataElapsedTime;
                    ((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).mMultiSrcStatData.dfstat = 0;
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.optInt("error_no") == 0) {
                                JSONObject optJSONObject = jSONObject.optJSONObject("fres");
                                if (jSONObject.optInt("fstat", 1) == 0 && optJSONObject != null && !optJSONObject.optString("download_inner").equals("")) {
                                    this.this$0.mSid = optJSONObject.optString("sid", "");
                                    StatisticInfo statisticInfo = new StatisticInfo();
                                    statisticInfo.sid = this.this$0.mSid;
                                    statisticInfo.sdkVer = com.baidu.down.utils.Constants.SDK_VER;
                                    this.this$0.mDownInfoMode = Integer.parseInt(optJSONObject.optString("mode", "-1"));
                                    statisticInfo.mode = this.this$0.mDownInfoMode;
                                    int parseInt = Integer.parseInt(optJSONObject.optString(MultiSrcBinaryReqTask.DOWNFLOW_TN, "-1"));
                                    if (parseInt > 0) {
                                        this.this$0.mMaxThread = parseInt;
                                    }
                                    statisticInfo.tn = parseInt;
                                    this.this$0.mDownloadUri = optJSONObject.optString("download_inner", "");
                                    TaskFacade.getInstance(null).getBinaryTaskMng().addStatsticMap(Long.valueOf(this.this$0.mDownloadId), statisticInfo);
                                    if ((this.this$0.mDownInfoMode & 1) == 1) {
                                        if (this.this$0.mIsFetchHttpDnsData) {
                                            TreeSet<HttpDNSInfo> treeSet = new TreeSet<>();
                                            HttpDNSCacheInfo httpDNSCacheInfo = new HttpDNSCacheInfo();
                                            ((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).mMultiSrcStatData.dyget = jSONObject.optInt("dystat", 1);
                                            if (jSONObject.optInt("dystat", 1) == 0) {
                                                this.this$0.parserHttpDNSData(jSONObject.optJSONObject("dyres"), this.val$onRequestListener, treeSet, httpDNSCacheInfo);
                                            }
                                            if (treeSet.isEmpty()) {
                                                ((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).mMultiSrcStatData.dyuse = 2;
                                                if (this.val$onRequestListener != null) {
                                                    this.val$onRequestListener.afterRequest(false, null);
                                                }
                                            } else {
                                                ((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).mMultiSrcStatData.dyuse = 1;
                                                if (this.val$onRequestListener != null) {
                                                    this.val$onRequestListener.afterRequest(true, treeSet);
                                                }
                                            }
                                            TaskFacade.getInstance(null).getBinaryTaskMng().setHttpDNSCacheInfo(httpDNSCacheInfo);
                                            return;
                                        } else if (this.val$onRequestListener != null) {
                                            this.val$onRequestListener.afterRequest(true, null);
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                    ((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).mMultiSrcStatData.dyuse = 7;
                                    if (this.val$onRequestListener != null) {
                                        this.val$onRequestListener.afterRequest(true, null);
                                        return;
                                    }
                                    return;
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            ((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).mMultiSrcStatData.dfstat = 1;
                        }
                    }
                    ((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).mMultiSrcStatData.dyuse = 8;
                    OnFetchDataRequestListener onFetchDataRequestListener2 = this.val$onRequestListener;
                    if (onFetchDataRequestListener2 != null) {
                        onFetchDataRequestListener2.afterRequest(false, null);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parserHttpDNSData(JSONObject jSONObject, OnFetchDataRequestListener onFetchDataRequestListener, TreeSet<HttpDNSInfo> treeSet, HttpDNSCacheInfo httpDNSCacheInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65552, this, jSONObject, onFetchDataRequestListener, treeSet, httpDNSCacheInfo) == null) || jSONObject == null) {
            return;
        }
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
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                if (Utils.isIpAddress(optJSONArray.getString(i))) {
                                    HttpDNSInfo httpDNSInfo = new HttpDNSInfo();
                                    String replace = getReplaceIpUrl().replace(host, optJSONArray.getString(i));
                                    httpDNSInfo.mUrl = replace;
                                    if (Utils.isUrlContainsQ(replace)) {
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
                } catch (MalformedURLException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private TreeSet<HttpDNSInfo> readHttpDNSCacheInfo(HttpDNSCacheInfo httpDNSCacheInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65553, this, httpDNSCacheInfo, z)) == null) {
            TreeSet<HttpDNSInfo> treeSet = new TreeSet<>();
            if (z) {
                try {
                    String host = new URL(getReplaceIpUrl()).getHost();
                    for (int i = 0; i < httpDNSCacheInfo.mIpList.size(); i++) {
                        if (Utils.isIpAddress(httpDNSCacheInfo.mIpList.get(i))) {
                            HttpDNSInfo httpDNSInfo = new HttpDNSInfo();
                            String replace = getReplaceIpUrl().replace(host, httpDNSCacheInfo.mIpList.get(i));
                            httpDNSInfo.mUrl = replace;
                            if (Utils.isUrlContainsQ(replace)) {
                                httpDNSInfo.mUrl += "&xcode=" + httpDNSCacheInfo.mXCode;
                            } else {
                                httpDNSInfo.mUrl += "?xcode=" + httpDNSCacheInfo.mXCode;
                            }
                            httpDNSInfo.mCDNSequence = i;
                            httpDNSInfo.mCNDIp = httpDNSCacheInfo.mIpList.get(i);
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
        return (TreeSet) invokeLZ.objValue;
    }

    public void addAsyncRequest(ProgressInfo.Segment segment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, segment) == null) {
            startSegment(segment.current, segment.end, 2);
        }
    }

    public void cancelAsyncRequest(MultiSrcAsyncHttpRequest multiSrcAsyncHttpRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, multiSrcAsyncHttpRequest) == null) {
            multiSrcAsyncHttpRequest.stopRequestRunning();
            TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().cancelTaskRequests(this.myContext, multiSrcAsyncHttpRequest);
        }
    }

    @Override // com.baidu.down.request.task.BinaryReqTask, com.baidu.down.request.task.AbstractTask
    public String getDefaultUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!TextUtils.isEmpty(this.mDownloadUri)) {
                return this.mDownloadUri;
            }
            return this.mUri;
        }
        return (String) invokeV.objValue;
    }

    public HttpDNSInfo getDownloadIpInfo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
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
        return (HttpDNSInfo) invokeL.objValue;
    }

    @Override // com.baidu.down.request.task.BinaryReqTask, com.baidu.down.request.task.AbstractTask
    public String getFastestUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    public HttpDNSInfo getFirstAvailableDownloadIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
        return (HttpDNSInfo) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    @Override // com.baidu.down.request.task.BinaryReqTask, com.baidu.down.request.task.AbstractTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getNoMeasuredUrl(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
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
                int i2 = next2.mStatus;
                if (i2 == 1 || i2 == 2) {
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
        return (String) invokeZ.objValue;
    }

    public TreeSet<HttpDNSInfo> getPriorityDownloadIpInfoSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPriorityHttpDNSInfoSet : (TreeSet) invokeV.objValue;
    }

    public String getWorkingDownloadIpInfoStat() {
        InterceptResult invokeV;
        HttpDNSInfo next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    public boolean isDownInfoNeedRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            String wifiOr2gOr3G = Utils.getWifiOr2gOr3G(this.mContext);
            return TextUtils.isEmpty(wifiOr2gOr3G) || !wifiOr2gOr3G.equals(this.mDownInfoVpn) || TextUtils.isEmpty(this.mDownloadUri);
        }
        return invokeV.booleanValue;
    }

    public void multiSrcToNormal() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && ((MultiSrcBinaryTaskHandler) this.mTaskHandler).isNeedMultiSrc()) {
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

    public void notifyTaskStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
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
    }

    public void resetData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
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
    }

    public synchronized void retryServerInfo(OnFetchDataRequestListener onFetchDataRequestListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onFetchDataRequestListener) == null) {
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
                    ArrayList arrayList = new ArrayList();
                    this.mOnFetchDataRequestListener = arrayList;
                    arrayList.add(onFetchDataRequestListener);
                    onFetchServerDataRequest(new OnFetchDataRequestListener(this) { // from class: com.baidu.down.request.task.MultiSrcBinaryReqTask.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MultiSrcBinaryReqTask this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // com.baidu.down.request.taskmanager.OnFetchDataRequestListener
                        public void afterRequest(boolean z2, TreeSet<HttpDNSInfo> treeSet) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z2, treeSet) == null) {
                                if (z2) {
                                    MultiSrcBinaryReqTask multiSrcBinaryReqTask = this.this$0;
                                    if ((multiSrcBinaryReqTask.mDownInfoMode & 1) == 1) {
                                        if (!multiSrcBinaryReqTask.mIsFetchHttpDnsData) {
                                            this.this$0.initHttpDNSInfo(TaskFacade.getInstance(null).getBinaryTaskMng().getHttpDNSCacheInfo());
                                        } else {
                                            if (treeSet != null) {
                                                this.this$0.mPriorityHttpDNSInfoSet = treeSet;
                                            }
                                            ((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).setNeedTestSpeed(true);
                                        }
                                        ((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).setNeedMultiSrc(true);
                                        if (((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).isNeedTestSpeed()) {
                                            ((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).setTestSpeedStage(1);
                                        }
                                    } else {
                                        ((MultiSrcBinaryTaskHandler) multiSrcBinaryReqTask.mTaskHandler).setNeedMultiSrc(false);
                                    }
                                    MultiSrcBinaryReqTask multiSrcBinaryReqTask2 = this.this$0;
                                    ((MultiSrcBinaryTaskHandler) multiSrcBinaryReqTask2.mTaskHandler).mMultiSrcStatData.network = Utils.getWifiOr2gOr3G(multiSrcBinaryReqTask2.mContext);
                                } else {
                                    ((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).setNeedMultiSrc(false);
                                }
                                for (int i = 0; i < this.this$0.mOnFetchDataRequestListener.size(); i++) {
                                    ((OnFetchDataRequestListener) this.this$0.mOnFetchDataRequestListener.get(i)).afterRequest(z2, treeSet);
                                }
                                this.this$0.mOnFetchDataRequestListener.clear();
                                this.this$0.isRetryDownloadInfo = false;
                            }
                        }
                    });
                } else {
                    this.mOnFetchDataRequestListener.add(onFetchDataRequestListener);
                }
            }
        }
    }

    public void savePriorityDownloadIpConnectTime(String str, long j) {
        TreeSet<HttpDNSInfo> treeSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(1048590, this, str, j) == null) || (treeSet = this.mPriorityHttpDNSInfoSet) == null || treeSet.size() <= 0) {
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

    public void setHttpDNSInfoStatus(String str, int i) {
        TreeSet<HttpDNSInfo> treeSet;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, str, i) == null) || (treeSet = this.mPriorityHttpDNSInfoSet) == null || treeSet.size() <= 0) {
            return;
        }
        Iterator<HttpDNSInfo> it = this.mPriorityHttpDNSInfoSet.iterator();
        while (it.hasNext()) {
            HttpDNSInfo next = it.next();
            if (str.equals(next.mUrl)) {
                if (i == 2 && next.mStatus != 1) {
                    return;
                }
                next.mStatus = i;
            }
        }
    }

    @Override // com.baidu.down.request.task.BinaryReqTask, com.baidu.down.request.task.AbstractTask
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
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
                    onFetchServerDataRequest(new OnFetchDataRequestListener(this) { // from class: com.baidu.down.request.task.MultiSrcBinaryReqTask.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ MultiSrcBinaryReqTask this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // com.baidu.down.request.taskmanager.OnFetchDataRequestListener
                        public void afterRequest(boolean z, TreeSet<HttpDNSInfo> treeSet) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z, treeSet) == null) {
                                this.this$0.mIsDirectStart = true;
                                if (z) {
                                    HttpDNSCacheInfo httpDNSCacheInfo2 = TaskFacade.getInstance(null).getBinaryTaskMng().getHttpDNSCacheInfo();
                                    if (httpDNSCacheInfo2 != null && httpDNSCacheInfo2.isHttpDNSInAvailable(this.this$0.mContext)) {
                                        ((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).setNeedMultiSrc(false);
                                        ((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).mMultiSrcStatData.dbtype = 0;
                                    } else {
                                        MultiSrcBinaryReqTask multiSrcBinaryReqTask = this.this$0;
                                        if ((multiSrcBinaryReqTask.mDownInfoMode & 1) == 1) {
                                            if (!multiSrcBinaryReqTask.mIsFetchHttpDnsData) {
                                                this.this$0.initHttpDNSInfo(httpDNSCacheInfo2);
                                            } else if (treeSet != null) {
                                                this.this$0.mPriorityHttpDNSInfoSet = treeSet;
                                            }
                                            ((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).setNeedMultiSrc(true);
                                        } else {
                                            ((MultiSrcBinaryTaskHandler) multiSrcBinaryReqTask.mTaskHandler).setNeedMultiSrc(false);
                                            ((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).mMultiSrcStatData.dbtype = 0;
                                        }
                                    }
                                } else {
                                    ((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).setNeedMultiSrc(false);
                                    ((MultiSrcBinaryTaskHandler) this.this$0.mTaskHandler).mMultiSrcStatData.dbtype = 0;
                                }
                                this.this$0.start();
                            }
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
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        r2 = r7.mTotalBytes;
        r1.mDownloadBytes = r2;
        r4 = r7.mTotalTimes;
        r1.mDownloadTimes = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
        if (r2 >= r6.mTestSpeedDataSize) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
        if (r4 < r6.mTestSpeedDuration) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
        if (r6.mTaskHandler.getTestSpeedStage() != 1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
        r6.mTaskHandler.setTestSpeedStage(2);
        checkAndAdjustByAverageSpeed();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void updateAverageSpeed(MultiSrcTaskMsg multiSrcTaskMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, multiSrcTaskMsg) == null) {
            synchronized (this) {
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
    }
}
