package com.baidu.searchbox.cloudcontrol.request;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.cloudcontrol.CloudControlManager;
import com.baidu.searchbox.cloudcontrol.constant.CloudControlConstant;
import com.baidu.searchbox.cloudcontrol.data.CloudControlData;
import com.baidu.searchbox.cloudcontrol.data.CloudControlErrorBean;
import com.baidu.searchbox.cloudcontrol.data.CloudControlUBCData;
import com.baidu.searchbox.cloudcontrol.utils.CloudControlUBCUtils;
import com.baidu.searchbox.config.AppConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CloudControlResponseParse {
    private static final String FAIL_VALID = "0";
    private static final String FILTER_VALID = "2";
    private static final String KEY_BODY_BLACK = "req_body_black";
    private static final String KEY_CONTROL = "control";
    private static final String KEY_D = "data";
    private static final String KEY_DATA = "data";
    private static final String KEY_DEGRADE_LIST = "ccs_degrade_list";
    private static final String KEY_ERRNO = "errno";
    private static final String KEY_HOTRUN_INTERVAL = "ccs_hotrun_interval";
    private static final String KEY_LOGID = "logid";
    private static final String KEY_PUBPARAM = "pubparam";
    private static final String KEY_RUNTYPE_BLACK = "runtype_black";
    private static final String KEY_SERVICE = "service";
    private static final String KEY_V = "version";
    private static final String KEY_VERSIONS = "versions";
    private static final String KEY_VERSION_ASC = "version_asc";
    private static final String NEED_CHECK_VERSION = "1";
    private static final String SUCCESS_VALID = "1";
    private static final String TAG = "CloudControlParse";
    private String mRuntype;
    private SharedPrefsWrapper mSharedPrefsWrapper = CloudControlManager.getInstance().getSharedPrefsWrapper();
    private String mTraceId;

    public CloudControlResponseParse(String str) {
        this.mRuntype = str;
    }

    public CloudControlResponseParse(String str, String str2) {
        this.mRuntype = str;
        this.mTraceId = str2;
    }

    public CloudControlData parseConnectResponse(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        CloudControlData parseResponse = parseResponse(jSONObject, TextUtils.equals("1", jSONObject2.optString(KEY_VERSION_ASC)));
        parseResponse.setOptionsData(jSONObject2);
        return parseResponse;
    }

    public long parseLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            if (!AppConfig.isDebug()) {
                return 0L;
            }
            Log.d(TAG, "parse version is not long");
            return 0L;
        }
    }

    public CloudControlData parseResponse(JSONObject jSONObject, boolean z) throws JSONException {
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
        CloudControlUBCData cloudControlUBCData = new CloudControlUBCData();
        cloudControlUBCData.setLogId(optString);
        cloudControlUBCData.setTraceId(this.mTraceId);
        cloudControlUBCData.setRunType(this.mRuntype);
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
        String optString2 = optJSONObject.optString(KEY_PUBPARAM);
        JSONObject optJSONObject3 = optJSONObject.optJSONObject(KEY_CONTROL);
        if (optJSONObject3 != null && optJSONObject3.length() != 0) {
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            JSONArray jSONArray = new JSONArray();
            JSONObject optJSONObject4 = optJSONObject3.optJSONObject(KEY_HOTRUN_INTERVAL);
            if (optJSONObject4 != null) {
                i = 1;
                String optString3 = optJSONObject4.optString("data");
                String optString4 = optJSONObject4.optString("version", "0");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("product", KEY_HOTRUN_INTERVAL);
                jSONObject2.put("version", optString4);
                String string = this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_INTERVAL_VERSION, "0");
                if (z && parseLong(optString4) <= parseLong(string)) {
                    jSONObject2.put(CloudControlUBCUtils.KEY_VALID, "2");
                    i3 = 1;
                } else {
                    this.mSharedPrefsWrapper.putString(CloudControlConstant.SP_KEY_INTERVAL_VERSION, optString4);
                    this.mSharedPrefsWrapper.putString(CloudControlConstant.SP_KEY_HOTRUNTIME_INTERVAL, optString3);
                    jSONObject2.put(CloudControlUBCUtils.KEY_VALID, "1");
                    i2 = 1;
                }
                jSONArray.put(jSONObject2);
            }
            JSONObject optJSONObject5 = optJSONObject3.optJSONObject(KEY_DEGRADE_LIST);
            if (optJSONObject5 != null) {
                i++;
                JSONObject optJSONObject6 = optJSONObject5.optJSONObject("data");
                String optString5 = optJSONObject5.optString("version", "0");
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("product", KEY_DEGRADE_LIST);
                jSONObject3.put("version", optString5);
                String string2 = this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_DEGRADE_LIST_VERSION, "0");
                if (!z || parseLong(optString5) > parseLong(string2)) {
                    this.mSharedPrefsWrapper.putString(CloudControlConstant.SP_KEY_DEGRADE_LIST_VERSION, optString5);
                    i2++;
                    if (optJSONObject6 != null && optJSONObject6.length() != 0) {
                        this.mSharedPrefsWrapper.putString("st", optJSONObject6.optString("st", "0"));
                        this.mSharedPrefsWrapper.putString("et", optJSONObject6.optString("et", "0"));
                        this.mSharedPrefsWrapper.putString(CloudControlConstant.SP_KEY_RUNTYPE_BLACK, optJSONObject6.optString(KEY_RUNTYPE_BLACK));
                        JSONObject optJSONObject7 = optJSONObject6.optJSONObject(KEY_BODY_BLACK);
                        if (optJSONObject7 != null) {
                            String optString6 = optJSONObject7.optString(KEY_VERSIONS);
                            boolean has = optJSONObject7.has(KEY_PUBPARAM);
                            this.mSharedPrefsWrapper.putString(CloudControlConstant.SP_KEY_DEGRADE_LIST, optString6);
                            this.mSharedPrefsWrapper.putBoolean(CloudControlConstant.SP_KEY_BLACK_PUBPARAM, has);
                            jSONObject3.put(CloudControlUBCUtils.KEY_VALID, "1");
                        } else {
                            this.mSharedPrefsWrapper.putString(CloudControlConstant.SP_KEY_DEGRADE_LIST, "");
                            this.mSharedPrefsWrapper.putBoolean(CloudControlConstant.SP_KEY_BLACK_PUBPARAM, false);
                        }
                    } else {
                        this.mSharedPrefsWrapper.putString("st", "0");
                        this.mSharedPrefsWrapper.putString("et", "0");
                        this.mSharedPrefsWrapper.putString(CloudControlConstant.SP_KEY_RUNTYPE_BLACK, "");
                        this.mSharedPrefsWrapper.putString(CloudControlConstant.SP_KEY_DEGRADE_LIST, "");
                        this.mSharedPrefsWrapper.putBoolean(CloudControlConstant.SP_KEY_BLACK_PUBPARAM, false);
                        jSONObject3.put(CloudControlUBCUtils.KEY_VALID, "0");
                    }
                } else {
                    jSONObject3.put(CloudControlUBCUtils.KEY_VALID, "2");
                    i3++;
                }
                jSONArray.put(jSONObject3);
            }
            cloudControlUBCData.collectDegradegInfo(i, i2, i3, jSONArray);
        }
        this.mSharedPrefsWrapper.putString(CloudControlConstant.SP_KEY_PUBPARAM, optString2);
        this.mSharedPrefsWrapper.putLong(CloudControlConstant.SP_KEY_LAST_REQUEST_TIME, System.currentTimeMillis());
        if (optJSONObject2 == null) {
            CloudControlData cloudControlData3 = new CloudControlData();
            CloudControlErrorBean cloudControlErrorBean3 = new CloudControlErrorBean();
            cloudControlErrorBean3.setErrorCode(3);
            cloudControlErrorBean3.setSubErrorCode(30);
            cloudControlData3.setCloudControlErrorBean(cloudControlErrorBean3);
            cloudControlData3.setCloudControlUBCData(cloudControlUBCData);
            return cloudControlData3;
        }
        CloudControlData cloudControlData4 = new CloudControlData(optJSONObject2);
        CloudControlErrorBean cloudControlErrorBean4 = new CloudControlErrorBean();
        cloudControlErrorBean4.setErrorCode(0);
        cloudControlData4.setCloudControlErrorBean(cloudControlErrorBean4);
        cloudControlData4.setCloudControlUBCData(cloudControlUBCData);
        return cloudControlData4;
    }
}
