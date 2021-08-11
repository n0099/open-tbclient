package com.baidu.searchbox.cloudcontrol.request;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.cloudcontrol.constant.CloudControlConstant;
import com.baidu.searchbox.cloudcontrol.data.CloudControlData;
import com.baidu.searchbox.cloudcontrol.data.CloudControlErrorBean;
import com.baidu.searchbox.cloudcontrol.data.CloudControlUBCData;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class CloudControlResponseParse {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FAIL_VALID = "0";
    public static final String FILTER_VALID = "2";
    public static final String KEY_BODY_BLACK = "req_body_black";
    public static final String KEY_CONTROL = "control";
    public static final String KEY_D = "data";
    public static final String KEY_DATA = "data";
    public static final String KEY_DEGRADE_LIST = "ccs_degrade_list";
    public static final String KEY_ERRNO = "errno";
    public static final String KEY_HOTRUN_INTERVAL = "ccs_hotrun_interval";
    public static final String KEY_LOGID = "logid";
    public static final String KEY_PUBPARAM = "pubparam";
    public static final String KEY_RUNTYPE_BLACK = "runtype_black";
    public static final String KEY_SERVICE = "service";
    public static final String KEY_V = "version";
    public static final String KEY_VERSIONS = "versions";
    public static final String KEY_VERSION_ASC = "version_asc";
    public static final String NEED_CHECK_VERSION = "1";
    public static final String SUCCESS_VALID = "1";
    public static final String TAG = "CloudControlParse";
    public transient /* synthetic */ FieldHolder $fh;
    public String mRuntype;
    public SharedPrefsWrapper mSharedPrefsWrapper;
    public String mTraceId;

    public CloudControlResponseParse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
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
        this.mRuntype = str;
    }

    public CloudControlData parseConnectResponse(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, jSONObject2)) == null) {
            CloudControlData parseResponse = parseResponse(jSONObject, TextUtils.equals("1", jSONObject2.optString("version_asc")));
            parseResponse.setOptionsData(jSONObject2);
            return parseResponse;
        }
        return (CloudControlData) invokeLL.objValue;
    }

    public long parseLong(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                return Long.parseLong(str);
            } catch (Exception unused) {
                AppConfig.isDebug();
                return 0L;
            }
        }
        return invokeL.longValue;
    }

    public CloudControlData parseResponse(JSONObject jSONObject, boolean z) throws JSONException {
        InterceptResult invokeLZ;
        CloudControlUBCData cloudControlUBCData;
        JSONObject jSONObject2;
        String str;
        CloudControlUBCData cloudControlUBCData2;
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, jSONObject, z)) == null) {
            int optInt = jSONObject.optInt("errno");
            if (optInt != 0) {
                CloudControlData cloudControlData = new CloudControlData();
                CloudControlErrorBean cloudControlErrorBean = new CloudControlErrorBean();
                cloudControlErrorBean.setErrorCode(2);
                cloudControlErrorBean.setSubErrorCode(optInt);
                cloudControlData.setCloudControlErrorBean(cloudControlErrorBean);
                return cloudControlData;
            }
            String optString = jSONObject.optString("logid");
            CloudControlUBCData cloudControlUBCData3 = new CloudControlUBCData();
            cloudControlUBCData3.setLogId(optString);
            cloudControlUBCData3.setTraceId(this.mTraceId);
            cloudControlUBCData3.setRunType(this.mRuntype);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                CloudControlData cloudControlData2 = new CloudControlData();
                CloudControlErrorBean cloudControlErrorBean2 = new CloudControlErrorBean();
                cloudControlErrorBean2.setErrorCode(3);
                cloudControlErrorBean2.setSubErrorCode(30);
                cloudControlData2.setCloudControlErrorBean(cloudControlErrorBean2);
                return cloudControlData2;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("service");
            String optString2 = optJSONObject.optString("pubparam");
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("control");
            if (optJSONObject3 == null || optJSONObject3.length() == 0) {
                cloudControlUBCData = cloudControlUBCData3;
                jSONObject2 = optJSONObject2;
                str = optString2;
            } else {
                JSONArray jSONArray = new JSONArray();
                JSONObject optJSONObject4 = optJSONObject3.optJSONObject("ccs_hotrun_interval");
                int i6 = 1;
                if (optJSONObject4 != null) {
                    jSONObject2 = optJSONObject2;
                    String optString3 = optJSONObject4.optString("data");
                    String optString4 = optJSONObject4.optString("version", "0");
                    str = optString2;
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("product", "ccs_hotrun_interval");
                    jSONObject3.put("version", optString4);
                    cloudControlUBCData2 = cloudControlUBCData3;
                    String string = this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_INTERVAL_VERSION, "0");
                    if (z && parseLong(optString4) <= parseLong(string)) {
                        jSONObject3.put("valid", "2");
                        i2 = 1;
                        i3 = 0;
                    } else {
                        this.mSharedPrefsWrapper.putString(CloudControlConstant.SP_KEY_INTERVAL_VERSION, optString4);
                        this.mSharedPrefsWrapper.putString(CloudControlConstant.SP_KEY_HOTRUNTIME_INTERVAL, optString3);
                        jSONObject3.put("valid", "1");
                        i2 = 0;
                        i3 = 1;
                    }
                    jSONArray.put(jSONObject3);
                } else {
                    cloudControlUBCData2 = cloudControlUBCData3;
                    jSONObject2 = optJSONObject2;
                    str = optString2;
                    i2 = 0;
                    i3 = 0;
                    i6 = 0;
                }
                JSONObject optJSONObject5 = optJSONObject3.optJSONObject("ccs_degrade_list");
                if (optJSONObject5 != null) {
                    i6++;
                    JSONObject optJSONObject6 = optJSONObject5.optJSONObject("data");
                    String optString5 = optJSONObject5.optString("version", "0");
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("product", "ccs_degrade_list");
                    jSONObject4.put("version", optString5);
                    String string2 = this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_DEGRADE_LIST_VERSION, "0");
                    if (z && parseLong(optString5) <= parseLong(string2)) {
                        jSONObject4.put("valid", "2");
                        i2++;
                    } else {
                        this.mSharedPrefsWrapper.putString(CloudControlConstant.SP_KEY_DEGRADE_LIST_VERSION, optString5);
                        int i7 = i3 + 1;
                        if (optJSONObject6 != null && optJSONObject6.length() != 0) {
                            i4 = i2;
                            i5 = i7;
                            this.mSharedPrefsWrapper.putString("st", optJSONObject6.optString("st", "0"));
                            this.mSharedPrefsWrapper.putString("et", optJSONObject6.optString("et", "0"));
                            this.mSharedPrefsWrapper.putString(CloudControlConstant.SP_KEY_RUNTYPE_BLACK, optJSONObject6.optString(KEY_RUNTYPE_BLACK));
                            JSONObject optJSONObject7 = optJSONObject6.optJSONObject(KEY_BODY_BLACK);
                            if (optJSONObject7 != null) {
                                String optString6 = optJSONObject7.optString("versions");
                                boolean has = optJSONObject7.has("pubparam");
                                this.mSharedPrefsWrapper.putString(CloudControlConstant.SP_KEY_DEGRADE_LIST, optString6);
                                this.mSharedPrefsWrapper.putBoolean(CloudControlConstant.SP_KEY_BLACK_PUBPARAM, has);
                                jSONObject4.put("valid", "1");
                            } else {
                                this.mSharedPrefsWrapper.putString(CloudControlConstant.SP_KEY_DEGRADE_LIST, "");
                                this.mSharedPrefsWrapper.putBoolean(CloudControlConstant.SP_KEY_BLACK_PUBPARAM, false);
                            }
                        } else {
                            i4 = i2;
                            i5 = i7;
                            this.mSharedPrefsWrapper.putString("st", "0");
                            this.mSharedPrefsWrapper.putString("et", "0");
                            this.mSharedPrefsWrapper.putString(CloudControlConstant.SP_KEY_RUNTYPE_BLACK, "");
                            this.mSharedPrefsWrapper.putString(CloudControlConstant.SP_KEY_DEGRADE_LIST, "");
                            this.mSharedPrefsWrapper.putBoolean(CloudControlConstant.SP_KEY_BLACK_PUBPARAM, false);
                            jSONObject4.put("valid", "0");
                        }
                        i3 = i5;
                        i2 = i4;
                    }
                    jSONArray.put(jSONObject4);
                }
                cloudControlUBCData = cloudControlUBCData2;
                cloudControlUBCData.collectDegradegInfo(i6, i3, i2, jSONArray);
            }
            this.mSharedPrefsWrapper.putString(CloudControlConstant.SP_KEY_PUBPARAM, str);
            this.mSharedPrefsWrapper.putLong(CloudControlConstant.SP_KEY_LAST_REQUEST_TIME, System.currentTimeMillis());
            if (jSONObject2 == null) {
                CloudControlData cloudControlData3 = new CloudControlData();
                CloudControlErrorBean cloudControlErrorBean3 = new CloudControlErrorBean();
                cloudControlErrorBean3.setErrorCode(3);
                cloudControlErrorBean3.setSubErrorCode(30);
                cloudControlData3.setCloudControlErrorBean(cloudControlErrorBean3);
                cloudControlData3.setCloudControlUBCData(cloudControlUBCData);
                return cloudControlData3;
            }
            CloudControlData cloudControlData4 = new CloudControlData(jSONObject2);
            CloudControlErrorBean cloudControlErrorBean4 = new CloudControlErrorBean();
            cloudControlErrorBean4.setErrorCode(0);
            cloudControlData4.setCloudControlErrorBean(cloudControlErrorBean4);
            cloudControlData4.setCloudControlUBCData(cloudControlUBCData);
            return cloudControlData4;
        }
        return (CloudControlData) invokeLZ.objValue;
    }

    public CloudControlResponseParse(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSharedPrefsWrapper = CloudControlManager.getInstance().getSharedPrefsWrapper();
        this.mRuntype = str;
        this.mTraceId = str2;
    }
}
