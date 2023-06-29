package com.baidu.searchbox.cloudcommand.processor;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.UniKV;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.cloudcommand.dao.CloudCommandDao;
import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.cloudcontrol.data.CloudControlResponseInfo;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.tieba.il1;
import com.baidu.tieba.kl1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CloudCommandProcessor implements ICloudControlProcessor {
    public static final String COMMAND_CLOUD_VERSION = "command_cloudconfig_version";
    public static final String COMMAND_KEY = "command";
    public static final String COMMAND_VERSION_ASC_DEFAULT = "0";
    public static final String COMMAND_VERSION_DEFAULT = "0";
    public static final String COMMAND_VERSION_KEY = "step";
    public static final String KEY_COUNT = "count";
    public static final String KEY_DATA = "data";
    public static final String KEY_ITEMS = "items";
    public static final String KEY_LIST = "list";
    public static final String KEY_MSG_ID = "msgid";
    public static final String KEY_PRODUCT = "product";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VALID = "valid";
    public static final String KEY_VERSION = "version";
    public static final String SP_COMMAND_FILE_NAME = "com.baidu.searchbox_cloud_command";
    public static final String TAG = "CloudCommandProcessor";
    public static final String VALUE_FILTER = "2";
    public static final String VALUE_INVALID = "0";
    public static final String VALUE_SUC = "1";
    @Inject
    public kl1<ICloudCommandObserver> mCloudCommandObservers;

    public void initmCloudCommandObservers() {
        il1 b = il1.b();
        this.mCloudCommandObservers = b;
        b.a(new ICloudCommandObserver_CloudCommandProcessor_ListProvider());
    }

    public CloudCommandProcessor() {
        initmCloudCommandObservers();
    }

    public static UniKV sharedPrefsWrapper() {
        return new UniKV(SP_COMMAND_FILE_NAME);
    }

    private ICloudCommandObserver getCommandObserver(String str) {
        kl1<ICloudCommandObserver> kl1Var = this.mCloudCommandObservers;
        if (kl1Var != null && kl1Var.getList() != null && this.mCloudCommandObservers.getList().size() > 0) {
            for (ICloudCommandObserver iCloudCommandObserver : this.mCloudCommandObservers.getList()) {
                if (TextUtils.equals(str, iCloudCommandObserver.getCommandType())) {
                    return iCloudCommandObserver;
                }
            }
            return null;
        }
        return null;
    }

    private void handleReceiveCommand(JSONArray jSONArray, ICloudControlUBCCallBack iCloudControlUBCCallBack) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray2 = new JSONArray();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i4);
            JSONObject jSONObject2 = new JSONObject();
            if (optJSONObject != null) {
                i++;
                String optString = optJSONObject.optString("type");
                String optString2 = optJSONObject.optString("msgid");
                String optString3 = optJSONObject.optString("version");
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                jSONObject2.put("product", optString);
                jSONObject2.put("version", optString2);
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                    if (CloudCommandDao.getInstance().queryDispatched(optString2, 1).size() <= 0) {
                        ICloudCommandObserver commandObserver = getCommandObserver(optString);
                        if (commandObserver != null) {
                            commandObserver.dispatch(optJSONObject2);
                            CloudCommandDao.getInstance().addCommand(optString, optString2, 1, optString3, System.currentTimeMillis());
                            i2++;
                            jSONObject2.put("valid", "1");
                        } else {
                            jSONObject2.put("valid", "0");
                        }
                    } else {
                        i3++;
                        jSONObject2.put("valid", "2");
                    }
                    jSONArray2.put(jSONObject2);
                } else {
                    jSONObject2.put("valid", "0");
                    jSONArray2.put(jSONObject2);
                }
            }
        }
        jSONObject.put("count", String.format("%s,%s,%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)));
        jSONObject.put("items", jSONArray2);
        if (iCloudControlUBCCallBack != null) {
            iCloudControlUBCCallBack.setServiceInfo(jSONObject);
        }
    }

    @Override // com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public CloudControlRequestInfo getPostData(String str, boolean z, JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() == 0) {
            return null;
        }
        String string = sharedPrefsWrapper().getString(COMMAND_CLOUD_VERSION, "0");
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("step", string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new CloudControlRequestInfo("command", null, null, "", jSONObject2);
    }

    @Override // com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor
    public void processServiceData(CloudControlResponseInfo cloudControlResponseInfo, ICloudControlUBCCallBack iCloudControlUBCCallBack) throws JSONException {
        JSONObject serviceData = cloudControlResponseInfo.getServiceData();
        if (serviceData == null) {
            return;
        }
        String optString = serviceData.optString("step");
        if (!TextUtils.isEmpty(optString)) {
            sharedPrefsWrapper().putString(COMMAND_CLOUD_VERSION, optString);
        }
        JSONArray optJSONArray = serviceData.optJSONArray("list");
        if (optJSONArray == null) {
            return;
        }
        handleReceiveCommand(optJSONArray, iCloudControlUBCCallBack);
        if (AppConfig.isDebug()) {
            Log.d(TAG, "service data " + serviceData);
        }
    }
}
