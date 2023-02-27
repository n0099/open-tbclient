package com.baidu.searchbox.fluency.config;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import org.json.JSONException;
import org.json.JSONObject;
@UpdateAction(action = FpsConfigCommandListener.CLOUD_FLUENCY_FPS_ACTION, module = "aap_share_20")
/* loaded from: classes2.dex */
public class FpsConfigCommandListener extends JSONObjectCommandListener {
    public static final String CLOUD_FLUENCY_FPS_ACTION = "apm_fluency_fps";
    public static final String CLOUD_FLUENCY_FPS_AUTH = "auth";
    public static final String CLOUD_FLUENCY_FPS_AUTH_CLOSE = "0";
    public static final String CLOUD_FLUENCY_FPS_AUTH_OPEN = "1";
    public static final String SP_DEFAULT_VERSION_CODE = "0";
    public static final String SP_FLUENCY_FPS_SWITCHER = "fluency_apm_fps_switcher";
    public static final String SP_FLUENCY_FPS_VERSION = "fluency_fps_version";
    public static final String TAG = "FpsConfigCommand";

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        if (commandPostData != null && commandPostData.getVersion() != null) {
            commandPostData.getVersion().put(str2, getLocalVersion(context, str, str2));
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JSONObject> actionData) {
        if (actionData != null && actionData.data != null && TextUtils.equals(str2, CLOUD_FLUENCY_FPS_ACTION)) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "executeCommand: " + actionData.data.toString());
            }
            String str3 = actionData.version;
            JSONObject jSONObject = actionData.data;
            if (TextUtils.isEmpty(str3) || jSONObject == null || jSONObject.length() == 0 || getLocalVersion(context, str, str2).equals(str3)) {
                return false;
            }
            String optString = jSONObject.optString("auth");
            if ("1".equals(optString)) {
                QuickPersistConfig.getInstance().putString(SP_FLUENCY_FPS_VERSION, str3);
                QuickPersistConfig.getInstance().putBoolean(SP_FLUENCY_FPS_SWITCHER, true);
                return true;
            } else if ("0".equals(optString)) {
                QuickPersistConfig.getInstance().putString(SP_FLUENCY_FPS_VERSION, str3);
                QuickPersistConfig.getInstance().putBoolean(SP_FLUENCY_FPS_SWITCHER, false);
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return QuickPersistConfig.getInstance().getString(SP_FLUENCY_FPS_VERSION, "0");
    }
}
