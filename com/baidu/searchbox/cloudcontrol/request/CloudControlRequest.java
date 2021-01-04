package com.baidu.searchbox.cloudcontrol.request;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.cloudcontrol.constant.CloudControlConstant;
import com.baidu.searchbox.cloudcontrol.data.CloudControlData;
import com.baidu.searchbox.cloudcontrol.data.CloudControlErrorBean;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.cloudcontrol.router.DataRouter;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUrlConfig;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import com.baidu.searchbox.http.request.HttpRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CloudControlRequest {
    private static final String DEFAULT_TIME = "300";
    private static final String REQUEST_CONTENT_TYPE = "application/json";
    private static final String REQUEST_KEY_CONTENT_TYPE = "Content-Type";
    private static final String REQUEST_KEY_CTRL_VERSION = "ctrlversion";
    private static final String REQUEST_KEY_DEGRADE_LIST = "ccs_degrade_list";
    private static final String REQUEST_KEY_FILTER = "filter";
    private static final String REQUEST_KEY_HOTRUN_INTERVAL = "ccs_hotrun_interval";
    private static final String REQUEST_KEY_PUBPARAM = "pubparam";
    private static final String REQUEST_KEY_VERSIONS = "versions";
    private static final int SUB_FROM_CLOUD_CONTROL = 101;
    private static final String TAG = "CloudControlRequest";
    private final SharedPrefsWrapper mSharedPrefsWrapper = CloudControlManager.getInstance().getSharedPrefsWrapper();

    private boolean isContentInterval(String str) {
        if (TextUtils.equals(str, "1")) {
            String string = this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_HOTRUNTIME_INTERVAL, "300");
            long j = this.mSharedPrefsWrapper.getLong(CloudControlConstant.SP_KEY_LAST_REQUEST_TIME, 0L);
            try {
                long parseLong = Long.parseLong(string);
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = currentTimeMillis - j;
                if (currentTimeMillis > j) {
                    if ((j2 / 1000) - parseLong >= 0) {
                        return true;
                    }
                }
                return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    private boolean isInBlackInterrupt(String str) {
        if (TextUtils.equals(str, "1") || TextUtils.equals(str, "0")) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_RUNTYPE_BLACK, ""));
            for (int i = 0; i < jSONArray.length(); i++) {
                if (TextUtils.equals(jSONArray.optString(i), str)) {
                    return true;
                }
            }
            return false;
        } catch (JSONException e) {
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.baidu.searchbox.http.request.HttpRequestBuilder] */
    public void cloudControlRequest(String str, ArrayList<CloudControlRequestInfo> arrayList) {
        String str2;
        if (isContentInterval(str) && !isInBlackInterrupt(str)) {
            CloudControlResponseCallback cloudControlResponseCallback = new CloudControlResponseCallback(str);
            String cloudControlUrl = CloudControlUrlConfig.getCloudControlUrl(str);
            if (arrayList == null) {
                arrayList = CloudControlManager.getInstance().getPostData(str);
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            HashMap<String, Object> hashMap = new HashMap<>();
            HashMap<String, Boolean> hashMap2 = new HashMap<>();
            String str3 = cloudControlUrl;
            for (int i = 0; i < arrayList.size(); i++) {
                CloudControlRequestInfo cloudControlRequestInfo = arrayList.get(i);
                if (cloudControlRequestInfo != null) {
                    try {
                        jSONObject.put(cloudControlRequestInfo.getServiceName(), cloudControlRequestInfo.getPostData());
                    } catch (JSONException e) {
                        if (AppConfig.isDebug()) {
                            Log.d(TAG, "post data put error" + e.toString());
                        }
                    }
                    Object checkInfo = cloudControlRequestInfo.getCheckInfo();
                    boolean isForceDispatch = cloudControlRequestInfo.isForceDispatch();
                    hashMap.put(cloudControlRequestInfo.getServiceName(), checkInfo);
                    hashMap2.put(cloudControlRequestInfo.getServiceName(), Boolean.valueOf(isForceDispatch));
                    HashMap<String, String> queryData = cloudControlRequestInfo.getQueryData();
                    try {
                        jSONObject2.put(cloudControlRequestInfo.getServiceName(), cloudControlRequestInfo.getFilter());
                    } catch (JSONException e2) {
                        if (AppConfig.isDebug()) {
                            Log.d(TAG, "filter data  put error" + e2.toString());
                        }
                    }
                    Iterator<Map.Entry<String, String>> it = queryData.entrySet().iterator();
                    while (true) {
                        str2 = str3;
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<String, String> next = it.next();
                        str3 = UrlUtil.addParam(str2, next.getKey(), next.getValue());
                    }
                    str3 = str2;
                }
            }
            cloudControlResponseCallback.setCheckData(hashMap);
            cloudControlResponseCallback.setIsForceDispatchs(hashMap2);
            HttpManager httpManager = HttpManager.getDefault(AppRuntime.getAppContext());
            HttpCommonRequestBuilder httpCommonRequestBuilder = (HttpCommonRequestBuilder) httpManager.postRequest().url(str3);
            HashMap hashMap3 = new HashMap();
            if (jSONObject.length() != 0) {
                hashMap3.put(REQUEST_KEY_VERSIONS, jSONObject);
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put(REQUEST_KEY_HOTRUN_INTERVAL, this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_INTERVAL_VERSION, "0"));
                jSONObject3.put(REQUEST_KEY_DEGRADE_LIST, this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_DEGRADE_LIST_VERSION, "0"));
            } catch (JSONException e3) {
                jSONObject3 = null;
            }
            if (jSONObject3 != null && jSONObject3.length() != 0) {
                hashMap3.put(REQUEST_KEY_CTRL_VERSION, jSONObject3);
            }
            if (jSONObject2.length() != 0) {
                hashMap3.put("filter", jSONObject2);
            }
            if (!this.mSharedPrefsWrapper.getBoolean(CloudControlConstant.SP_KEY_BLACK_PUBPARAM, false)) {
                String string = this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_PUBPARAM, "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        hashMap3.put(REQUEST_KEY_PUBPARAM, new JSONObject(string));
                    } catch (JSONException e4) {
                        if (AppConfig.isDebug()) {
                            Log.d(TAG, "sp pubparam parse json is error");
                        }
                    }
                }
            }
            HttpRequest build = httpCommonRequestBuilder.requestBody(RequestBody.create(MediaType.parse("application/json"), new JSONObject(hashMap3).toString())).requestSubFrom(101).cookieManager(httpManager.getCookieManager(true, false)).build();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String bdTraceId = build.getBdTraceId();
            cloudControlResponseCallback.setStart(elapsedRealtime);
            cloudControlResponseCallback.setTraceID(bdTraceId);
            CloudStabilityUBCUtils.doRequestStatistics(str, bdTraceId);
            build.executeAsync(cloudControlResponseCallback);
        }
    }

    /* loaded from: classes3.dex */
    private class CloudControlResponseCallback extends ResponseCallback<CloudControlData> {
        private HashMap<String, Object> mCheckData;
        private long mDuration;
        private HashMap<String, Boolean> mIsForceDispatchs;
        private String mRuntype;
        private long mStart;
        private String mTraceID;

        public CloudControlResponseCallback(String str) {
            this.mRuntype = str;
        }

        public void setCheckData(HashMap<String, Object> hashMap) {
            this.mCheckData = hashMap;
        }

        public void setStart(long j) {
            this.mStart = j;
        }

        public void setTraceID(String str) {
            this.mTraceID = str;
        }

        public void setIsForceDispatchs(HashMap<String, Boolean> hashMap) {
            this.mIsForceDispatchs = hashMap;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public CloudControlData parseResponse(Response response, int i) throws Exception {
            this.mDuration = SystemClock.elapsedRealtime() - this.mStart;
            if (response.code() != 200) {
                doStabilityUBCEvent(2, i, response.message());
            }
            if (response.body() != null) {
                CloudControlData parseResponse = new CloudControlResponseParse(this.mRuntype, this.mTraceID).parseResponse(new JSONObject(response.body().string()), false);
                parseResponse.setCheckDatas(this.mCheckData);
                parseResponse.setIsForceDispatchs(this.mIsForceDispatchs);
                parseCloudErrorBean(parseResponse, response, i);
                return parseResponse;
            }
            CloudControlData cloudControlData = new CloudControlData();
            CloudControlErrorBean cloudControlErrorBean = new CloudControlErrorBean();
            cloudControlErrorBean.setErrorCode(1);
            cloudControlErrorBean.setSubErrorCode(response.code());
            cloudControlData.setCloudControlErrorBean(cloudControlErrorBean);
            cloudControlData.setCheckDatas(this.mCheckData);
            cloudControlData.setIsForceDispatchs(this.mIsForceDispatchs);
            doStabilityUBCEvent(3, i, response.message());
            return cloudControlData;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(CloudControlData cloudControlData, int i) {
            doStabilityUBCEvent(0, i, "");
            new DataRouter().routeServiceData(cloudControlData);
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.mDuration = SystemClock.elapsedRealtime() - this.mStart;
            doStabilityUBCEvent(6, 0, "onFail");
            CloudControlData cloudControlData = new CloudControlData();
            CloudControlErrorBean cloudControlErrorBean = new CloudControlErrorBean();
            cloudControlErrorBean.setErrorCode(1);
            cloudControlErrorBean.setSubErrorCode(exc.hashCode());
            cloudControlData.setCloudControlErrorBean(cloudControlErrorBean);
            cloudControlData.setCheckDatas(this.mCheckData);
            cloudControlData.setIsForceDispatchs(this.mIsForceDispatchs);
            new DataRouter().routeServiceData(cloudControlData);
            if (AppConfig.isDebug()) {
                Log.d(CloudControlRequest.TAG, "cloud control response json is error");
            }
        }

        private void parseCloudErrorBean(CloudControlData cloudControlData, Response response, int i) {
            if (cloudControlData.getCloudControlErrorBean() != null) {
                int errorCode = cloudControlData.getCloudControlErrorBean().getErrorCode();
                int subErrorCode = cloudControlData.getCloudControlErrorBean().getSubErrorCode();
                switch (errorCode) {
                    case 2:
                        doStabilityUBCEvent(4, i, subErrorCode, response.message());
                        return;
                    case 3:
                        doStabilityUBCEvent(5, i, subErrorCode, response.message());
                        return;
                    default:
                        return;
                }
            }
        }

        private void doStabilityUBCEvent(int i, int i2, String str) {
            CloudStabilityUBCUtils.doResponseStatistics(this.mRuntype, i, this.mTraceID, i2, -100, str, this.mDuration);
        }

        private void doStabilityUBCEvent(int i, int i2, int i3, String str) {
            CloudStabilityUBCUtils.doResponseStatistics(this.mRuntype, i, this.mTraceID, i2, i3, str, this.mDuration);
        }
    }
}
