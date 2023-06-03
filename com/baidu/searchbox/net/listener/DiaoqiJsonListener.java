package com.baidu.searchbox.net.listener;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.AbstractCommandListener;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.UpdateAction;
import com.baidu.searchbox.schemedispatch.monitor.OpenAppManager;
import com.google.gson.JsonElement;
import org.json.JSONException;
@UpdateAction(action = DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST, module = "baidu")
/* loaded from: classes4.dex */
public class DiaoqiJsonListener extends AbstractCommandListener<JsonElement> {
    public static final String DEFAULT_VERSION = "0";
    public static final String SCHEME_FORBID_WHITE_LIST = "invoke";
    public static final String SCHEME_FORBID_WHITLIST_V = "invoke_v";
    public static final String TAG = "DiaoqiJsonListener";

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        String localVersion = getLocalVersion(context, str, str2);
        if (commandPostData != null && commandPostData.getVersion() != null) {
            commandPostData.getVersion().put(SCHEME_FORBID_WHITE_LIST, localVersion);
            if (AppConfig.isDebug()) {
                String str3 = TAG;
                Log.d(str3, "post data version. === " + commandPostData.getVersion());
            }
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JsonElement> actionData) {
        if (actionData != null && actionData.data != null && TextUtils.equals(str2, SCHEME_FORBID_WHITE_LIST)) {
            if (AppConfig.isDebug()) {
                String str3 = TAG;
                Log.d(str3, "executeCommand: " + actionData.data.toString());
            }
            if (OpenAppManager.saveWhiteList(actionData.data.toString())) {
                PreferenceUtils.setString("invoke_v", actionData.version);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return PreferenceUtils.getString("invoke_v", "0");
    }
}
