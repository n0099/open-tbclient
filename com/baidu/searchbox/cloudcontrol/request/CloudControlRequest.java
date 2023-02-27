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
import com.baidu.searchbox.cloudcontrol.processor.IProcessorDataInterceptor;
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
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CloudControlRequest {
    public static final String DEFAULT_TIME = "300";
    public static final String REQUEST_CONTENT_TYPE = "application/json";
    public static final String REQUEST_KEY_CONTENT_TYPE = "Content-Type";
    public static final String REQUEST_KEY_CTRL_VERSION = "ctrlversion";
    public static final String REQUEST_KEY_DEGRADE_LIST = "ccs_degrade_list";
    public static final String REQUEST_KEY_FILTER = "filter";
    public static final String REQUEST_KEY_HOTRUN_INTERVAL = "ccs_hotrun_interval";
    public static final String REQUEST_KEY_PUBPARAM = "pubparam";
    public static final String REQUEST_KEY_VERSIONS = "versions";
    public static final int SUB_FROM_CLOUD_CONTROL = 101;
    public static final String TAG = "CloudControlRequest";
    public final SharedPrefsWrapper mSharedPrefsWrapper = CloudControlManager.getInstance().getSharedPrefsWrapper();

    /* loaded from: classes2.dex */
    public class CloudControlResponseCallback extends ResponseCallback<CloudControlData> {
        public HashMap<String, Object> mCheckData;
        public long mContentLength;
        public HashMap<String, IProcessorDataInterceptor> mDataInterceptors;
        public long mDuration;
        public HashMap<String, Boolean> mIsForceDispatchs;
        public long mPostLength;
        public String mRuntype;
        public long mStart;
        public String mTraceID;

        public CloudControlResponseCallback(String str) {
            this.mRuntype = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(CloudControlData cloudControlData, int i) {
            doStabilityUBCEvent(0, i, "");
            new DataRouter().routeServiceData(cloudControlData);
        }

        private void doStabilityUBCEvent(int i, int i2, int i3, String str) {
            CloudStabilityUBCUtils.doResponseStatistics(this.mRuntype, i, this.mTraceID, i2, i3, str, this.mDuration, this.mContentLength, this.mPostLength);
        }

        private void doStabilityUBCEvent(int i, int i2, String str) {
            CloudStabilityUBCUtils.doResponseStatistics(this.mRuntype, i, this.mTraceID, i2, -100, str, this.mDuration, this.mContentLength, this.mPostLength);
        }

        private void parseCloudErrorBean(CloudControlData cloudControlData, Response response, int i) {
            if (cloudControlData.getCloudControlErrorBean() != null) {
                int errorCode = cloudControlData.getCloudControlErrorBean().getErrorCode();
                int subErrorCode = cloudControlData.getCloudControlErrorBean().getSubErrorCode();
                if (errorCode != 2) {
                    if (errorCode == 3) {
                        doStabilityUBCEvent(5, i, subErrorCode, response.message());
                        return;
                    }
                    return;
                }
                doStabilityUBCEvent(4, i, subErrorCode, response.message());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            this.mDuration = SystemClock.elapsedRealtime() - this.mStart;
            doStabilityUBCEvent(6, 0, exc.getMessage());
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

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public CloudControlData parseResponse(Response response, int i) throws Exception {
            this.mDuration = SystemClock.elapsedRealtime() - this.mStart;
            if (response.code() != 200) {
                doStabilityUBCEvent(2, i, response.message());
            }
            if (response.body() != null) {
                String string = response.body().string();
                this.mContentLength = string.length();
                CloudControlData parseResponse = new CloudControlResponseParse(this.mRuntype, this.mTraceID).parseResponse(new JSONObject(string), false);
                parseResponse.setCheckDatas(this.mCheckData);
                parseResponse.setIsForceDispatchs(this.mIsForceDispatchs);
                parseResponse.setDataInterceptor(this.mDataInterceptors);
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
            cloudControlData.setDataInterceptor(this.mDataInterceptors);
            doStabilityUBCEvent(3, i, response.message());
            return cloudControlData;
        }

        public void setCheckData(HashMap<String, Object> hashMap) {
            this.mCheckData = hashMap;
        }

        public void setDataInterceptor(HashMap<String, IProcessorDataInterceptor> hashMap) {
            this.mDataInterceptors = hashMap;
        }

        public void setIsForceDispatchs(HashMap<String, Boolean> hashMap) {
            this.mIsForceDispatchs = hashMap;
        }

        public void setPostLength(long j) {
            this.mPostLength = j;
        }

        public void setStart(long j) {
            this.mStart = j;
        }

        public void setTraceID(String str) {
            this.mTraceID = str;
        }
    }

    private void doStabilityRequestUBCEvent(String str, HttpRequest httpRequest) {
        try {
            String bdTraceId = httpRequest.getBdTraceId();
            long j = -1;
            if (httpRequest.getOkRequest() != null && httpRequest.getOkRequest().body() != null) {
                j = httpRequest.getOkRequest().body().contentLength();
            }
            CloudStabilityUBCUtils.doRequestStatistics(str, bdTraceId, j);
        } catch (Exception e) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "doStabilityRequestUBCEvent error " + e.toString());
            }
        }
    }

    private boolean isContentInterval(String str) {
        if (!TextUtils.equals(str, "1")) {
            return true;
        }
        String string = this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_HOTRUNTIME_INTERVAL, DEFAULT_TIME);
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
        } catch (NumberFormatException unused) {
        }
        return false;
    }

    private boolean isInBlackInterrupt(String str) {
        if (!TextUtils.equals(str, "1") && !TextUtils.equals(str, "0")) {
            try {
                JSONArray jSONArray = new JSONArray(this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_RUNTYPE_BLACK, ""));
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (TextUtils.equals(jSONArray.optString(i), str)) {
                        return true;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r5v7, types: [com.baidu.searchbox.http.request.HttpRequestBuilder] */
    public void cloudControlRequest(String str, ArrayList<CloudControlRequestInfo> arrayList) {
        ArrayList<CloudControlRequestInfo> arrayList2;
        ArrayList<CloudControlRequestInfo> arrayList3;
        if (!isContentInterval(str) || isInBlackInterrupt(str)) {
            return;
        }
        CloudControlResponseCallback cloudControlResponseCallback = new CloudControlResponseCallback(str);
        String cloudControlUrl = CloudControlUrlConfig.getCloudControlUrl(str);
        if (arrayList == null) {
            arrayList2 = CloudControlManager.getInstance().getPostData(str);
        } else {
            arrayList2 = arrayList;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        HashMap<String, Object> hashMap = new HashMap<>();
        HashMap<String, Boolean> hashMap2 = new HashMap<>();
        HashMap<String, IProcessorDataInterceptor> hashMap3 = new HashMap<>();
        String str2 = cloudControlUrl;
        int i = 0;
        while (i < arrayList2.size()) {
            CloudControlRequestInfo cloudControlRequestInfo = arrayList2.get(i);
            if (cloudControlRequestInfo == null) {
                arrayList3 = arrayList2;
            } else {
                try {
                    jSONObject.put(cloudControlRequestInfo.getServiceName(), cloudControlRequestInfo.getPostData());
                } catch (JSONException e) {
                    if (AppConfig.isDebug()) {
                        StringBuilder sb = new StringBuilder();
                        arrayList3 = arrayList2;
                        sb.append("post data put error");
                        sb.append(e.toString());
                        Log.d(TAG, sb.toString());
                    }
                }
                arrayList3 = arrayList2;
                Object checkInfo = cloudControlRequestInfo.getCheckInfo();
                boolean isForceDispatch = cloudControlRequestInfo.isForceDispatch();
                hashMap.put(cloudControlRequestInfo.getServiceName(), checkInfo);
                hashMap2.put(cloudControlRequestInfo.getServiceName(), Boolean.valueOf(isForceDispatch));
                IProcessorDataInterceptor dataInterceptor = cloudControlRequestInfo.getDataInterceptor();
                if (dataInterceptor != null) {
                    hashMap3.put(cloudControlRequestInfo.getServiceName(), dataInterceptor);
                }
                HashMap<String, String> queryData = cloudControlRequestInfo.getQueryData();
                try {
                    jSONObject2.put(cloudControlRequestInfo.getServiceName(), cloudControlRequestInfo.getFilter());
                } catch (JSONException e2) {
                    if (AppConfig.isDebug()) {
                        Log.d(TAG, "filter data  put error" + e2.toString());
                    }
                }
                for (Map.Entry<String, String> entry : queryData.entrySet()) {
                    str2 = UrlUtil.addParam(str2, entry.getKey(), entry.getValue());
                }
            }
            i++;
            arrayList2 = arrayList3;
        }
        cloudControlResponseCallback.setCheckData(hashMap);
        cloudControlResponseCallback.setIsForceDispatchs(hashMap2);
        cloudControlResponseCallback.setDataInterceptor(hashMap3);
        HttpManager httpManager = HttpManager.getDefault(AppRuntime.getAppContext());
        HttpCommonRequestBuilder httpCommonRequestBuilder = (HttpCommonRequestBuilder) httpManager.postRequest().url(str2);
        HashMap hashMap4 = new HashMap();
        if (jSONObject.length() != 0) {
            hashMap4.put("versions", jSONObject);
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("ccs_hotrun_interval", this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_INTERVAL_VERSION, "0"));
            jSONObject3.put("ccs_degrade_list", this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_DEGRADE_LIST_VERSION, "0"));
        } catch (JSONException unused) {
            jSONObject3 = null;
        }
        if (jSONObject3 != null && jSONObject3.length() != 0) {
            hashMap4.put(REQUEST_KEY_CTRL_VERSION, jSONObject3);
        }
        if (jSONObject2.length() != 0) {
            hashMap4.put("filter", jSONObject2);
        }
        if (!this.mSharedPrefsWrapper.getBoolean(CloudControlConstant.SP_KEY_BLACK_PUBPARAM, false)) {
            String string = this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_PUBPARAM, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    hashMap4.put("pubparam", new JSONObject(string));
                } catch (JSONException unused2) {
                    if (AppConfig.isDebug()) {
                        Log.d(TAG, "sp pubparam parse json is error");
                    }
                }
            }
        }
        String jSONObject4 = new JSONObject(hashMap4).toString();
        HttpRequest build = httpCommonRequestBuilder.requestBody(RequestBody.create(MediaType.parse("application/json"), jSONObject4)).requestSubFrom(101).cookieManager(httpManager.getCookieManager(true, false)).build();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        String bdTraceId = build.getBdTraceId();
        cloudControlResponseCallback.setStart(elapsedRealtime);
        cloudControlResponseCallback.setTraceID(bdTraceId);
        cloudControlResponseCallback.setPostLength(jSONObject4.length());
        doStabilityRequestUBCEvent(str, build);
        build.executeAsync(cloudControlResponseCallback);
    }
}
