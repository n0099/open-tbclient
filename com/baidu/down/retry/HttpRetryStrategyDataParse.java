package com.baidu.down.retry;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.urlconnection.HttpURLExecutorRunnable;
import com.baidu.down.request.taskmanager.HttpDNSCacheInfo;
import com.baidu.down.request.taskmanager.TaskNetRequestMng;
import com.baidu.down.utils.CryptUtil;
import com.baidu.down.utils.DownPrefUtils;
import com.baidu.down.utils.Utils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class HttpRetryStrategyDataParse {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String DOWNFLOW_DOWNLOAD_INNER = "download_inner";
    public static final String DOWNFLOW_DYRES = "dyres";
    public static final String DOWNFLOW_DYSTAT = "dystat";
    public static final String DOWNFLOW_ERROR_NO = "error_no";
    public static final String DOWNFLOW_FRES = "fres";
    public static final String DOWNFLOW_FSTAT = "fstat";
    public static final String DOWNFLOW_LIVE_TIME = "ftime";
    public static final String DOWNFLOW_MODE = "mode";
    public static final String DOWNFLOW_RETRY_REQUEST_PARAM = "retry";
    public static final String DOWNFLOW_TETRY_ARR = "down_retry_arr";
    public static final String DOWNFLOW_TETRY_ARR_HEADER = "header";
    public static final String DOWNFLOW_TETRY_ARR_HEADER_NAME = "name";
    public static final String DOWNFLOW_TETRY_ARR_HEADER_VALUE = "value";
    public static final String DOWNFLOW_TETRY_ARR_URL = "url";
    public static final int DOWNFLOW_TETRY_MODE_IP = 6;
    public static final int DOWNFLOW_TETRY_MODE_IP_URL = 4;
    public static final int DOWNFLOW_TETRY_MODE_URL = 7;
    public static final int DOWNFLOW_TETRY_MODE_URL_IP = 5;
    public static final String DOWNFLOW_TETRY_REQUEST_ID = "request_id";
    public static final String HTTP_DNS_CDN_DATA = "data";
    public static final String HTTP_DNS_CDN_HOST = "host";
    public static final String HTTP_DNS_CDN_LIVE_TIME = "live_time";
    public static final String HTTP_DNS_CDN_STATUS = "status";
    public static final String HTTP_DNS_CDN_VIPS = "vips";
    public static final String HTTP_DNS_CDN_XCODE = "xcode";
    public static final String TAG = "HttpRetryStrategyDataParse";
    public transient /* synthetic */ FieldHolder $fh;
    public long mFetchServerDataElapsedTime;
    public Timer mFetchServerDataOverTime;

    /* loaded from: classes10.dex */
    public interface OnFetchRetryDataRequestListener {
        void afterRequest(boolean z, HttpDNSCacheInfo httpDNSCacheInfo, int i2);
    }

    public HttpRetryStrategyDataParse() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parserHttpDNSData(Context context, JSONObject jSONObject, HttpDNSCacheInfo httpDNSCacheInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, this, context, jSONObject, httpDNSCacheInfo) == null) || jSONObject == null || jSONObject == null) {
            return;
        }
        try {
            String string = jSONObject.getString("data");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            String decryptCdnData = CryptUtil.decryptCdnData(context, string);
            if (TextUtils.isEmpty(decryptCdnData)) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(decryptCdnData);
            int optInt = jSONObject.optInt("status");
            if (optInt == 0) {
                JSONArray optJSONArray = jSONObject2.optJSONArray("vips");
                httpDNSCacheInfo.mXCode = jSONObject2.optString("xcode");
                httpDNSCacheInfo.mHost = jSONObject2.optString("host");
                httpDNSCacheInfo.mIpLiveTime = jSONObject2.optInt("live_time");
                httpDNSCacheInfo.mApn = Utils.getWifiOr2gOr3G(context);
                if (optJSONArray != null && !TextUtils.isEmpty(httpDNSCacheInfo.mHost)) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        if (Utils.isIpAddress(optJSONArray.getString(i2))) {
                            httpDNSCacheInfo.mIpList.add(optJSONArray.getString(i2));
                        }
                    }
                }
            } else if (optInt == 1) {
                httpDNSCacheInfo.mIpLiveTime = 600;
                httpDNSCacheInfo.mApn = Utils.getWifiOr2gOr3G(context);
                httpDNSCacheInfo.mRequestTime = SystemClock.elapsedRealtime();
            }
            httpDNSCacheInfo.mStatus = optInt;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onFetchRetryDataRequest(Context context, String str, OnFetchRetryDataRequestListener onFetchRetryDataRequestListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, context, str, onFetchRetryDataRequestListener) == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            TimerTask timerTask = new TimerTask(this, onFetchRetryDataRequestListener, elapsedRealtime) { // from class: com.baidu.down.retry.HttpRetryStrategyDataParse.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HttpRetryStrategyDataParse this$0;
                public final /* synthetic */ OnFetchRetryDataRequestListener val$onRequestListener;
                public final /* synthetic */ long val$startTime;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, onFetchRetryDataRequestListener, Long.valueOf(elapsedRealtime)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$onRequestListener = onFetchRetryDataRequestListener;
                    this.val$startTime = elapsedRealtime;
                }

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mFetchServerDataOverTime == null) {
                        return;
                    }
                    this.this$0.mFetchServerDataOverTime = null;
                    OnFetchRetryDataRequestListener onFetchRetryDataRequestListener2 = this.val$onRequestListener;
                    if (onFetchRetryDataRequestListener2 != null) {
                        onFetchRetryDataRequestListener2.afterRequest(false, null, 2);
                    }
                    this.this$0.mFetchServerDataElapsedTime = SystemClock.elapsedRealtime() - this.val$startTime;
                }
            };
            Timer timer = new Timer();
            this.mFetchServerDataOverTime = timer;
            timer.schedule(timerTask, DownPrefUtils.testConfigurationGetLong(context, DownPrefUtils.PREF_CONFIG_DOWNINFO_URL_TIMEOUT, 15L) * 1000);
            TaskNetRequestMng.requestRemoteConfig(context, str, DOWNFLOW_RETRY_REQUEST_PARAM, new HttpURLExecutorRunnable.OnWebRequestListener(this, elapsedRealtime, onFetchRetryDataRequestListener, context) { // from class: com.baidu.down.retry.HttpRetryStrategyDataParse.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HttpRetryStrategyDataParse this$0;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ OnFetchRetryDataRequestListener val$onRequestListener;
                public final /* synthetic */ long val$startTime;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(elapsedRealtime), onFetchRetryDataRequestListener, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$startTime = elapsedRealtime;
                    this.val$onRequestListener = onFetchRetryDataRequestListener;
                    this.val$context = context;
                }

                @Override // com.baidu.down.loopj.android.urlconnection.HttpURLExecutorRunnable.OnWebRequestListener
                public void onFailed() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.this$0.mFetchServerDataOverTime == null) {
                        return;
                    }
                    this.this$0.mFetchServerDataOverTime.cancel();
                    this.this$0.mFetchServerDataOverTime = null;
                    OnFetchRetryDataRequestListener onFetchRetryDataRequestListener2 = this.val$onRequestListener;
                    if (onFetchRetryDataRequestListener2 != null) {
                        onFetchRetryDataRequestListener2.afterRequest(false, null, 6);
                    }
                    this.this$0.mFetchServerDataElapsedTime = SystemClock.elapsedRealtime() - this.val$startTime;
                }

                @Override // com.baidu.down.loopj.android.urlconnection.HttpURLExecutorRunnable.OnWebRequestListener
                public void onSuccess(String str2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str2) == null) || this.this$0.mFetchServerDataOverTime == null) {
                        return;
                    }
                    this.this$0.mFetchServerDataOverTime.cancel();
                    this.this$0.mFetchServerDataOverTime = null;
                    this.this$0.mFetchServerDataElapsedTime = SystemClock.elapsedRealtime() - this.val$startTime;
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            HttpDNSCacheInfo httpDNSCacheInfo = new HttpDNSCacheInfo();
                            JSONObject jSONObject = new JSONObject(str2);
                            httpDNSCacheInfo.mDownFlowCostTime = this.this$0.mFetchServerDataElapsedTime;
                            httpDNSCacheInfo.mRequestTime = SystemClock.elapsedRealtime();
                            httpDNSCacheInfo.mRequestId = jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
                            if (jSONObject.optInt("error_no") == 0) {
                                JSONObject optJSONObject = jSONObject.optJSONObject("fres");
                                if (jSONObject.optInt("fstat", 1) == 0 && optJSONObject != null) {
                                    httpDNSCacheInfo.mMode = Integer.parseInt(optJSONObject.optString("mode", "-1"));
                                    httpDNSCacheInfo.mDownloadUri = optJSONObject.optString("download_inner", "");
                                    httpDNSCacheInfo.mDownFlowLiveTime = optJSONObject.optInt("ftime", 600);
                                    httpDNSCacheInfo.mRetryRequestUrl = new ArrayList();
                                    if (httpDNSCacheInfo.mMode == 4 || httpDNSCacheInfo.mMode == 5 || httpDNSCacheInfo.mMode == 7) {
                                        JSONArray optJSONArray = optJSONObject.optJSONArray(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_ARR);
                                        if (optJSONArray != null && optJSONArray.length() > 0) {
                                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                                                RetryRequestInfo retryRequestInfo = new RetryRequestInfo();
                                                retryRequestInfo.url = jSONObject2.optString("url");
                                                retryRequestInfo.header = new HashMap();
                                                JSONArray optJSONArray2 = jSONObject2.optJSONArray("header");
                                                if (optJSONArray2 != null && optJSONArray2.length() > 0 && optJSONArray2 != null && optJSONArray2.length() > 0) {
                                                    for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i3);
                                                        retryRequestInfo.header.put(jSONObject3.optString("name"), jSONObject3.optString("value"));
                                                    }
                                                }
                                                if (URLUtil.isValidUrl(retryRequestInfo.url)) {
                                                    httpDNSCacheInfo.mRetryRequestUrl.add(retryRequestInfo);
                                                }
                                            }
                                        }
                                        if (httpDNSCacheInfo.mRetryRequestUrl != null) {
                                            if (httpDNSCacheInfo.mRetryRequestUrl.size() == 0) {
                                            }
                                        }
                                        this.val$onRequestListener.afterRequest(false, null, 5);
                                        return;
                                    }
                                    if (httpDNSCacheInfo.mMode != 4 && httpDNSCacheInfo.mMode != 5 && httpDNSCacheInfo.mMode != 6 && httpDNSCacheInfo.mMode != 7) {
                                        if (this.val$onRequestListener != null) {
                                            this.val$onRequestListener.afterRequest(false, null, 5);
                                            return;
                                        }
                                        return;
                                    }
                                    if (jSONObject.optInt("dystat", 1) == 0) {
                                        this.this$0.parserHttpDNSData(this.val$context, jSONObject.optJSONObject("dyres"), httpDNSCacheInfo);
                                        if (this.val$onRequestListener != null) {
                                            this.val$onRequestListener.afterRequest(true, httpDNSCacheInfo, 1);
                                            return;
                                        }
                                        return;
                                    } else if (this.val$onRequestListener != null) {
                                        this.val$onRequestListener.afterRequest(true, httpDNSCacheInfo, 1);
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    OnFetchRetryDataRequestListener onFetchRetryDataRequestListener2 = this.val$onRequestListener;
                    if (onFetchRetryDataRequestListener2 != null) {
                        onFetchRetryDataRequestListener2.afterRequest(false, null, 5);
                    }
                }
            });
        }
    }
}
