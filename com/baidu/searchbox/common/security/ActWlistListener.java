package com.baidu.searchbox.common.security;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.AbstractCommandListener;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import com.google.gson.JsonElement;
import org.json.JSONException;
@UpdateAction(action = ActWlistListener.ACT_WLIST_ACTION, module = "scheme")
/* loaded from: classes3.dex */
public class ActWlistListener extends AbstractCommandListener<JsonElement> {
    public static final String ACT_WLIST_ACTION = "act_wlist";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final String SECURITY_WHITELIST_ACTIVITY_V = "act_wlist_v";
    public static final String TAG = "ActWlistListener";

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        String localVersion = getLocalVersion(context, str, str2);
        if (commandPostData != null && commandPostData.getVersion() != null) {
            commandPostData.getVersion().put(ACT_WLIST_ACTION, localVersion);
            if (DEBUG) {
                Log.d(TAG, "post data version. === " + commandPostData.getVersion());
            }
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JsonElement> actionData) {
        if (actionData != null && actionData.data != null && TextUtils.equals(str2, ACT_WLIST_ACTION)) {
            if (DEBUG) {
                Log.d(TAG, "executeCommand: " + actionData.data.toString());
            }
            if (!TextUtils.isEmpty(actionData.version) && !TextUtils.equals(actionData.version, getLocalVersion(context, str, str2))) {
                if (DEBUG) {
                    Log.d(TAG, "action: " + str2 + " | Version: " + actionData.version + " | Content: " + actionData.data);
                }
                PermissionCheckUtils.saveActivityWhiteList(context, actionData.data.toString());
                QuickPersistConfig.getInstance().putString(SECURITY_WHITELIST_ACTIVITY_V, actionData.version);
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return QuickPersistConfig.getInstance().getString(SECURITY_WHITELIST_ACTIVITY_V, "0");
    }
}
