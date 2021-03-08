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
/* loaded from: classes4.dex */
public class CloudControlManager {
    private static final String KEY_SP_CLOUDCONTROL = "cloudControlCCS117";
    private static final String TAG = "CloudControlManager";
    private static CloudControlManager mCloudControlManager;
    private DataProcessors mProcessors = new DataProcessors();
    private SharedPrefsWrapper mSharedPrefsWrapper = new SharedPrefsWrapper(KEY_SP_CLOUDCONTROL);

    private CloudControlManager() {
    }

    public static CloudControlManager getInstance() {
        synchronized (CloudControlManager.class) {
            if (mCloudControlManager == null) {
                mCloudControlManager = new CloudControlManager();
            }
        }
        return mCloudControlManager;
    }

    public SharedPrefsWrapper getSharedPrefsWrapper() {
        return this.mSharedPrefsWrapper;
    }

    public HashMap<String, ICloudControlProcessor> getProcessors() {
        return this.mProcessors.getProcessors();
    }

    public void registProcessor(String str, ICloudControlProcessor iCloudControlProcessor) {
        this.mProcessors.addProcessor(str, iCloudControlProcessor);
    }

    public ICloudControlProcessor getProcessor(String str) {
        return this.mProcessors.getProcessor(str);
    }

    public ArrayList<CloudControlRequestInfo> getPostData(String str) {
        JSONObject jSONObject;
        ArrayList<CloudControlRequestInfo> arrayList = new ArrayList<>();
        HashMap<String, ICloudControlProcessor> processors = this.mProcessors.getProcessors();
        try {
            jSONObject = new JSONObject(this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_DEGRADE_LIST, ""));
        } catch (JSONException e) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "drage is not json  " + e.toString());
            }
            jSONObject = null;
        }
        if (jSONObject == null || jSONObject.length() != 0) {
            for (Map.Entry<String, ICloudControlProcessor> entry : processors.entrySet()) {
                String key = entry.getKey();
                CloudControlRequestInfo postData = entry.getValue().getPostData(str, isDegradeTime(), jSONObject != null ? jSONObject.optJSONObject(key) : null);
                if (AppConfig.isDebug()) {
                    if (postData == null) {
                        throw new Exception(key + " service get post data is error ");
                    }
                    try {
                        if (!this.mProcessors.containKey(key)) {
                            throw new Exception(key + " service is not register");
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                arrayList.add(postData);
            }
            return arrayList;
        }
        return arrayList;
    }

    public boolean isInDegradeList(JSONObject jSONObject, String str, String str2) {
        JSONObject optJSONObject;
        if (isDegradeTime() && jSONObject != null) {
            if (jSONObject.length() == 0) {
                return true;
            }
            if (jSONObject.has(str) && (optJSONObject = jSONObject.optJSONObject(str)) != null) {
                if (optJSONObject.length() == 0) {
                    return true;
                }
                if (optJSONObject.has(str2)) {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(str2);
                    return optJSONObject2 != null && optJSONObject2.length() == 0;
                }
            }
        }
        return false;
    }

    public boolean isInDegradeList(String str, String str2, String str3) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        if (isDegradeTime()) {
            try {
                jSONObject = new JSONObject(this.mSharedPrefsWrapper.getString(CloudControlConstant.SP_KEY_DEGRADE_LIST, ""));
            } catch (JSONException e) {
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "drage is not json  " + e.toString());
                }
                jSONObject = null;
            }
            if (jSONObject == null || jSONObject.length() != 0) {
                JSONObject optJSONObject2 = jSONObject != null ? jSONObject.optJSONObject(str) : null;
                if (optJSONObject2 != null) {
                    if (optJSONObject2.length() == 0) {
                        return true;
                    }
                    if (optJSONObject2.has(str2) && (optJSONObject = optJSONObject2.optJSONObject(str2)) != null) {
                        if (optJSONObject.length() == 0) {
                            return true;
                        }
                        if (optJSONObject.has(str3)) {
                            JSONObject optJSONObject3 = optJSONObject.optJSONObject(str3);
                            return optJSONObject3 != null && optJSONObject3.length() == 0;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean isDegradeTime() {
        try {
            String string = this.mSharedPrefsWrapper.getString("st", "0");
            String string2 = this.mSharedPrefsWrapper.getString("et", "0");
            long parseLong = Long.parseLong(string);
            long parseLong2 = Long.parseLong(string2);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            return parseLong <= currentTimeMillis && currentTimeMillis <= parseLong2;
        } catch (Exception e) {
            return false;
        }
    }

    public void onBackgroundToForeground() {
        getInstance().requestCloudControl("1");
    }

    public boolean getConnectData(JSONObject jSONObject, JSONObject jSONObject2, String str) {
        try {
            CloudControlData parseConnectResponse = new CloudControlResponseParse(str).parseConnectResponse(jSONObject, jSONObject2);
            new DataRouter().routeServiceData(parseConnectResponse);
            return parseConnectResponse != null;
        } catch (JSONException e) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "connect response parse is error" + e.toString());
                return false;
            }
            return false;
        }
    }

    public void requestCloudControl(final String str) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.cloudcontrol.CloudControlManager.1
            @Override // java.lang.Runnable
            public void run() {
                new CloudControlRequest().cloudControlRequest(str, null);
            }
        }, "requestCloudControl", 0);
    }

    public void fetchCloudControl(final String str, final ArrayList<CloudControlRequestInfo> arrayList) {
        if (TextUtils.equals(str, "0") || TextUtils.equals(str, "1")) {
            if (AppConfig.isDebug()) {
                try {
                    throw new Exception("runType " + str + " is error please check runType");
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.cloudcontrol.CloudControlManager.2
            @Override // java.lang.Runnable
            public void run() {
                new CloudControlRequest().cloudControlRequest(str, arrayList);
            }
        }, "fetchCloudControl", 0);
    }
}
