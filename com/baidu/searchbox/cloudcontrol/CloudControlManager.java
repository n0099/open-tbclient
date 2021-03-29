package com.baidu.searchbox.cloudcontrol;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.sp.SharedPrefsWrapper;
import com.baidu.searchbox.cloudcontrol.constant.CloudControlConstant;
import com.baidu.searchbox.cloudcontrol.data.CloudControlData;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.cloudcontrol.processor.DataProcessors;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.searchbox.cloudcontrol.request.CloudControlRequest;
import com.baidu.searchbox.cloudcontrol.request.CloudControlResponseParse;
import com.baidu.searchbox.cloudcontrol.router.DataRouter;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CloudControlManager {
    public static final String KEY_SP_CLOUDCONTROL = "cloudControlCCS117";
    public static final String TAG = "CloudControlManager";
    public static CloudControlManager mCloudControlManager;
    public DataProcessors mProcessors = new DataProcessors();
    public SharedPrefsWrapper mSharedPrefsWrapper = new SharedPrefsWrapper(KEY_SP_CLOUDCONTROL);

    public static CloudControlManager getInstance() {
        synchronized (CloudControlManager.class) {
            if (mCloudControlManager == null) {
                mCloudControlManager = new CloudControlManager();
            }
        }
        return mCloudControlManager;
    }

    public void fetchCloudControl(final String str, final ArrayList<CloudControlRequestInfo> arrayList) {
        if (!TextUtils.equals(str, "0") && !TextUtils.equals(str, "1")) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.cloudcontrol.CloudControlManager.2
                @Override // java.lang.Runnable
                public void run() {
                    new CloudControlRequest().cloudControlRequest(str, arrayList);
                }
            }, "fetchCloudControl", 0);
        } else if (AppConfig.isDebug()) {
            try {
                throw new Exception("runType " + str + " is error please check runType");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public boolean getConnectData(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        try {
            CloudControlData parseConnectResponse = new CloudControlResponseParse(str).parseConnectResponse(jSONObject, jSONObject2);
            new DataRouter().routeServiceData(parseConnectResponse);
            return parseConnectResponse != null;
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "connect response parse is error" + e2.toString());
            }
            return false;
        }
    }

    public ArrayList<CloudControlRequestInfo> getPostData(String str) {
        JSONObject jSONObject;
        ArrayList<CloudControlRequestInfo> arrayList = new ArrayList<>();
        HashMap<String, ICloudControlProcessor> processors = this.mProcessors.getProcessors();
        try {
            jSONObject = new JSONObject(this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_DEGRADE_LIST, ""));
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "drage is not json  " + e2.toString());
            }
            jSONObject = null;
        }
        if (jSONObject == null || jSONObject.length() != 0) {
            for (Map.Entry<String, ICloudControlProcessor> entry : processors.entrySet()) {
                String key = entry.getKey();
                CloudControlRequestInfo postData = entry.getValue().getPostData(str, isDegradeTime(), jSONObject != null ? jSONObject.optJSONObject(key) : null);
                if (AppConfig.isDebug()) {
                    if (postData != null) {
                        try {
                            if (!this.mProcessors.containKey(key)) {
                                throw new Exception(key + " service is not register");
                            }
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    } else {
                        throw new Exception(key + " service get post data is error ");
                    }
                }
                arrayList.add(postData);
            }
            return arrayList;
        }
        return arrayList;
    }

    public ICloudControlProcessor getProcessor(String str) {
        return this.mProcessors.getProcessor(str);
    }

    public HashMap<String, ICloudControlProcessor> getProcessors() {
        return this.mProcessors.getProcessors();
    }

    public SharedPrefsWrapper getSharedPrefsWrapper() {
        return this.mSharedPrefsWrapper;
    }

    public boolean isDegradeTime() {
        long parseLong;
        long parseLong2;
        long currentTimeMillis;
        try {
            String string = this.mSharedPrefsWrapper.getString("st", "0");
            String string2 = this.mSharedPrefsWrapper.getString("et", "0");
            parseLong = Long.parseLong(string);
            parseLong2 = Long.parseLong(string2);
            currentTimeMillis = System.currentTimeMillis() / 1000;
        } catch (Exception unused) {
        }
        return parseLong <= currentTimeMillis && currentTimeMillis <= parseLong2;
    }

    public boolean isInDegradeList(JSONObject jSONObject, String str, String str2) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (!isDegradeTime() || jSONObject == null) {
            return false;
        }
        if (jSONObject.length() == 0) {
            return true;
        }
        if (!jSONObject.has(str) || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            return false;
        }
        if (optJSONObject.length() == 0) {
            return true;
        }
        return optJSONObject.has(str2) && (optJSONObject2 = optJSONObject.optJSONObject(str2)) != null && optJSONObject2.length() == 0;
    }

    public void onBackgroundToForeground() {
        getInstance().requestCloudControl("1");
    }

    public void registProcessor(String str, ICloudControlProcessor iCloudControlProcessor) {
        this.mProcessors.addProcessor(str, iCloudControlProcessor);
    }

    public void requestCloudControl(final String str) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.cloudcontrol.CloudControlManager.1
            @Override // java.lang.Runnable
            public void run() {
                new CloudControlRequest().cloudControlRequest(str, null);
            }
        }, "requestCloudControl", 0);
    }

    public boolean isInDegradeList(String str, String str2, String str3) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (isDegradeTime()) {
            try {
                jSONObject = new JSONObject(this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_DEGRADE_LIST, ""));
            } catch (JSONException e2) {
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "drage is not json  " + e2.toString());
                }
                jSONObject = null;
            }
            if (jSONObject == null || jSONObject.length() != 0) {
                JSONObject optJSONObject3 = jSONObject != null ? jSONObject.optJSONObject(str) : null;
                if (optJSONObject3 != null) {
                    if (optJSONObject3.length() == 0) {
                        return true;
                    }
                    if (!optJSONObject3.has(str2) || (optJSONObject = optJSONObject3.optJSONObject(str2)) == null) {
                        return false;
                    }
                    if (optJSONObject.length() == 0) {
                        return true;
                    }
                    return optJSONObject.has(str3) && (optJSONObject2 = optJSONObject.optJSONObject(str3)) != null && optJSONObject2.length() == 0;
                }
                return false;
            }
            return true;
        }
        return false;
    }
}
