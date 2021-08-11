package com.baidu.searchbox.cloudcontrol.request;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class CloudControlRequest {
    public static /* synthetic */ Interceptable $ic = null;
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
    public transient /* synthetic */ FieldHolder $fh;
    public final SharedPrefsWrapper mSharedPrefsWrapper;

    /* loaded from: classes5.dex */
    public class CloudControlResponseCallback extends ResponseCallback<CloudControlData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashMap<String, Object> mCheckData;
        public long mContentLength;
        public long mDuration;
        public HashMap<String, Boolean> mIsForceDispatchs;
        public long mPostLength;
        public String mRuntype;
        public long mStart;
        public String mTraceID;
        public final /* synthetic */ CloudControlRequest this$0;

        public CloudControlResponseCallback(CloudControlRequest cloudControlRequest, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cloudControlRequest, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = cloudControlRequest;
            this.mRuntype = str;
        }

        private void doStabilityUBCEvent(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(65538, this, i2, i3, str) == null) {
                CloudStabilityUBCUtils.doResponseStatistics(this.mRuntype, i2, this.mTraceID, i3, -100, str, this.mDuration, this.mContentLength, this.mPostLength);
            }
        }

        private void parseCloudErrorBean(CloudControlData cloudControlData, Response response, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(65539, this, cloudControlData, response, i2) == null) || cloudControlData.getCloudControlErrorBean() == null) {
                return;
            }
            int errorCode = cloudControlData.getCloudControlErrorBean().getErrorCode();
            int subErrorCode = cloudControlData.getCloudControlErrorBean().getSubErrorCode();
            if (errorCode == 2) {
                doStabilityUBCEvent(4, i2, subErrorCode, response.message());
            } else if (errorCode != 3) {
            } else {
                doStabilityUBCEvent(5, i2, subErrorCode, response.message());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
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
                AppConfig.isDebug();
            }
        }

        public void setCheckData(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, hashMap) == null) {
                this.mCheckData = hashMap;
            }
        }

        public void setIsForceDispatchs(HashMap<String, Boolean> hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, hashMap) == null) {
                this.mIsForceDispatchs = hashMap;
            }
        }

        public void setPostLength(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) {
                this.mPostLength = j2;
            }
        }

        public void setStart(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
                this.mStart = j2;
            }
        }

        public void setTraceID(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
                this.mTraceID = str;
            }
        }

        private void doStabilityUBCEvent(int i2, int i3, int i4, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str}) == null) {
                CloudStabilityUBCUtils.doResponseStatistics(this.mRuntype, i2, this.mTraceID, i3, i4, str, this.mDuration, this.mContentLength, this.mPostLength);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(CloudControlData cloudControlData, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cloudControlData, i2) == null) {
                doStabilityUBCEvent(0, i2, "");
                new DataRouter().routeServiceData(cloudControlData);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public CloudControlData parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, response, i2)) == null) {
                this.mDuration = SystemClock.elapsedRealtime() - this.mStart;
                if (response.code() != 200) {
                    doStabilityUBCEvent(2, i2, response.message());
                }
                if (response.body() != null) {
                    String string = response.body().string();
                    this.mContentLength = string.length();
                    CloudControlData parseResponse = new CloudControlResponseParse(this.mRuntype, this.mTraceID).parseResponse(new JSONObject(string), false);
                    parseResponse.setCheckDatas(this.mCheckData);
                    parseResponse.setIsForceDispatchs(this.mIsForceDispatchs);
                    parseCloudErrorBean(parseResponse, response, i2);
                    return parseResponse;
                }
                CloudControlData cloudControlData = new CloudControlData();
                CloudControlErrorBean cloudControlErrorBean = new CloudControlErrorBean();
                cloudControlErrorBean.setErrorCode(1);
                cloudControlErrorBean.setSubErrorCode(response.code());
                cloudControlData.setCloudControlErrorBean(cloudControlErrorBean);
                cloudControlData.setCheckDatas(this.mCheckData);
                cloudControlData.setIsForceDispatchs(this.mIsForceDispatchs);
                doStabilityUBCEvent(3, i2, response.message());
                return cloudControlData;
            }
            return (CloudControlData) invokeLI.objValue;
        }
    }

    public CloudControlRequest() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSharedPrefsWrapper = CloudControlManager.getInstance().getSharedPrefsWrapper();
    }

    private void doStabilityRequestUBCEvent(String str, HttpRequest httpRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, str, httpRequest) == null) {
            try {
                String bdTraceId = httpRequest.getBdTraceId();
                long j2 = -1;
                if (httpRequest.getOkRequest() != null && httpRequest.getOkRequest().body() != null) {
                    j2 = httpRequest.getOkRequest().body().contentLength();
                }
                CloudStabilityUBCUtils.doRequestStatistics(str, bdTraceId, j2);
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    String str2 = "doStabilityRequestUBCEvent error " + e2.toString();
                }
            }
        }
    }

    private boolean isContentInterval(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (TextUtils.equals(str, "1")) {
                String string = this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_HOTRUNTIME_INTERVAL, "300");
                long j2 = this.mSharedPrefsWrapper.getLong(CloudControlConstant.SP_KEY_LAST_REQUEST_TIME, 0L);
                try {
                    long parseLong = Long.parseLong(string);
                    long currentTimeMillis = System.currentTimeMillis();
                    long j3 = currentTimeMillis - j2;
                    if (currentTimeMillis > j2) {
                        if ((j3 / 1000) - parseLong >= 0) {
                            return true;
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    private boolean isInBlackInterrupt(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            if (!TextUtils.equals(str, "1") && !TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONArray(this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_RUNTYPE_BLACK, ""));
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        if (TextUtils.equals(jSONArray.optString(i2), str)) {
                            return true;
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.baidu.searchbox.http.request.HttpRequestBuilder] */
    public void cloudControlRequest(String str, ArrayList<CloudControlRequestInfo> arrayList) {
        String jSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, arrayList) == null) && isContentInterval(str) && !isInBlackInterrupt(str)) {
            CloudControlResponseCallback cloudControlResponseCallback = new CloudControlResponseCallback(this, str);
            String cloudControlUrl = CloudControlUrlConfig.getCloudControlUrl(str);
            if (arrayList == null) {
                arrayList = CloudControlManager.getInstance().getPostData(str);
            }
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            HashMap<String, Object> hashMap = new HashMap<>();
            HashMap<String, Boolean> hashMap2 = new HashMap<>();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                CloudControlRequestInfo cloudControlRequestInfo = arrayList.get(i2);
                if (cloudControlRequestInfo != null) {
                    try {
                        jSONObject2.put(cloudControlRequestInfo.getServiceName(), cloudControlRequestInfo.getPostData());
                    } catch (JSONException e2) {
                        if (AppConfig.isDebug()) {
                            String str2 = "post data put error" + e2.toString();
                        }
                    }
                    Object checkInfo = cloudControlRequestInfo.getCheckInfo();
                    boolean isForceDispatch = cloudControlRequestInfo.isForceDispatch();
                    hashMap.put(cloudControlRequestInfo.getServiceName(), checkInfo);
                    hashMap2.put(cloudControlRequestInfo.getServiceName(), Boolean.valueOf(isForceDispatch));
                    HashMap<String, String> queryData = cloudControlRequestInfo.getQueryData();
                    try {
                        jSONObject3.put(cloudControlRequestInfo.getServiceName(), cloudControlRequestInfo.getFilter());
                    } catch (JSONException e3) {
                        if (AppConfig.isDebug()) {
                            String str3 = "filter data  put error" + e3.toString();
                        }
                    }
                    for (Map.Entry<String, String> entry : queryData.entrySet()) {
                        cloudControlUrl = UrlUtil.addParam(cloudControlUrl, entry.getKey(), entry.getValue());
                    }
                }
            }
            cloudControlResponseCallback.setCheckData(hashMap);
            cloudControlResponseCallback.setIsForceDispatchs(hashMap2);
            HttpManager httpManager = HttpManager.getDefault(AppRuntime.getAppContext());
            HttpCommonRequestBuilder httpCommonRequestBuilder = (HttpCommonRequestBuilder) httpManager.postRequest().url(cloudControlUrl);
            HashMap hashMap3 = new HashMap();
            if (jSONObject2.length() != 0) {
                hashMap3.put("versions", jSONObject2);
            }
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("ccs_hotrun_interval", this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_INTERVAL_VERSION, "0"));
                jSONObject4.put("ccs_degrade_list", this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_DEGRADE_LIST_VERSION, "0"));
            } catch (JSONException unused) {
                jSONObject4 = null;
            }
            if (jSONObject4 != null && jSONObject4.length() != 0) {
                hashMap3.put(REQUEST_KEY_CTRL_VERSION, jSONObject4);
            }
            if (jSONObject3.length() != 0) {
                hashMap3.put(REQUEST_KEY_FILTER, jSONObject3);
            }
            if (!this.mSharedPrefsWrapper.getBoolean(CloudControlConstant.SP_KEY_BLACK_PUBPARAM, false)) {
                String string = this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_PUBPARAM, "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        hashMap3.put("pubparam", new JSONObject(string));
                    } catch (JSONException unused2) {
                        AppConfig.isDebug();
                    }
                }
            }
            HttpRequest build = httpCommonRequestBuilder.requestBody(RequestBody.create(MediaType.parse("application/json"), new JSONObject(hashMap3).toString())).requestSubFrom(101).cookieManager(httpManager.getCookieManager(true, false)).build();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String bdTraceId = build.getBdTraceId();
            cloudControlResponseCallback.setStart(elapsedRealtime);
            cloudControlResponseCallback.setTraceID(bdTraceId);
            cloudControlResponseCallback.setPostLength(jSONObject.length());
            doStabilityRequestUBCEvent(str, build);
            build.executeAsync(cloudControlResponseCallback);
        }
    }
}
