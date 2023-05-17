package com.baidu.searchbox.devicescore.config;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.devicescore.DeviceScoreConfig;
import com.baidu.searchbox.devicescore.IDeviceScoreConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONException;
import org.json.JSONObject;
@UpdateAction(action = "device_score", module = "performance")
/* loaded from: classes3.dex */
public class DeviceScoreConfigUpdateListener extends JSONObjectCommandListener {
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String KEY_UPDATE_VERSION = "device_score_update_version";
    public static final String TAG = "DeviceScoreConfig";
    public static final String UPDATE_ACTION = "device_score";

    private float getFloatByString(String str) {
        try {
            return new BigDecimal(str).setScale(4, RoundingMode.DOWN).floatValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return -1.0f;
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        if (commandPostData != null && commandPostData.getVersion() != null) {
            commandPostData.getVersion().put("device_score", getLocalVersion(context, str, str2));
            if (DEBUG) {
                Log.d(TAG, "post version " + commandPostData.getVersion().toString());
            }
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        if (DEBUG) {
            Log.d(TAG, "executeCommand: " + str + " content " + actionData);
        }
        if (actionData != null && actionData.data != null && !TextUtils.isEmpty(actionData.version)) {
            JSONObject optJSONObject = actionData.data.optJSONObject("score_threshold");
            if (optJSONObject != null) {
                QuickPersistConfig.getInstance().putString(KEY_UPDATE_VERSION, actionData.version);
                DeviceScoreConfig deviceScoreConfig = new DeviceScoreConfig();
                deviceScoreConfig.lowThreshold = getFloatByString(optJSONObject.optString("low_threshold"));
                deviceScoreConfig.midThreshold = getFloatByString(optJSONObject.optString("mid_threshold"));
                ((IDeviceScoreConfig) ServiceManager.getService(IDeviceScoreConfig.SERVICE_REFERENCE)).updateConfig(deviceScoreConfig);
            }
            if (DEBUG) {
                Log.d(TAG, "version " + actionData.version + " content " + actionData.data.toString());
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return QuickPersistConfig.getInstance().getString(KEY_UPDATE_VERSION, "0");
    }
}
