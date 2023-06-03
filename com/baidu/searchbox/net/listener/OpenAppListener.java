package com.baidu.searchbox.net.listener;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import com.baidu.searchbox.schemedispatch.monitor.control.OpenAppAlertControl;
import org.json.JSONException;
import org.json.JSONObject;
@UpdateAction(action = OpenAppListener.OPEN_APP_ALERT_CONTROL_ACTION, module = "scheme")
/* loaded from: classes4.dex */
public class OpenAppListener extends JSONObjectCommandListener {
    public static final String DEFAULT_VERSION = "0";
    public static final String OPEN_APP_ALERT_CONTROL_ACTION = "diaoqi_control";
    public static final String OPEN_APP_ALERT_CONTROL_V = "diaoqi_control_v";
    public static final String TAG = "OpenAppListener";

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        String localVersion = getLocalVersion(context, str, str2);
        if (commandPostData != null && commandPostData.getVersion() != null) {
            commandPostData.getVersion().put(OPEN_APP_ALERT_CONTROL_ACTION, localVersion);
            if (AppConfig.isDebug()) {
                Log.d(TAG, "post data version. === " + commandPostData.getVersion());
            }
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        if (actionData == null || actionData.data == null || !TextUtils.equals(str2, OPEN_APP_ALERT_CONTROL_ACTION)) {
            return false;
        }
        if (AppConfig.isDebug()) {
            Log.d(TAG, "executeCommand: " + actionData.data.toString());
        }
        if (!OpenAppAlertControl.saveConfiguration(actionData.data)) {
            return false;
        }
        DefaultSharedPrefsWrapper.getInstance().putString(OPEN_APP_ALERT_CONTROL_V, actionData.version);
        return true;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return DefaultSharedPrefsWrapper.getInstance().getString(OPEN_APP_ALERT_CONTROL_V, "0");
    }
}
