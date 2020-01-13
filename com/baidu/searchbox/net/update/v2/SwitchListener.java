package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.net.update.CommandPostData;
import org.json.JSONException;
/* loaded from: classes12.dex */
public abstract class SwitchListener extends AbstractCommandListener<SwitchData> {
    private static final String VERSION_POSTFIX = "_version";

    public abstract String getKey(String str, String str2);

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        String localVersion = getLocalVersion(context, str, str2);
        if (commandPostData != null && commandPostData.getVersion() != null) {
            commandPostData.getVersion().put(str2, localVersion);
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<SwitchData> actionData) {
        String key = getKey(str, str2);
        if (key == null) {
            throw new IllegalArgumentException("getKey should be implemented correctly to return preference key");
        }
        if (actionData.data == null || actionData.data.auth == null) {
            return false;
        }
        if (handleData(context, str, str2, key, getSwitchValue(actionData.data.auth))) {
            DefaultSharedPrefsWrapper.getInstance().putString(key + VERSION_POSTFIX, actionData.version);
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return DefaultSharedPrefsWrapper.getInstance().getString(getKey(str, str2) + VERSION_POSTFIX, "0");
    }

    public boolean handleData(Context context, String str, String str2, String str3, boolean z) {
        DefaultSharedPrefsWrapper.getInstance().putBoolean(str3, z);
        return true;
    }

    private static boolean getSwitchValue(String str) {
        return TextUtils.equals(str, "1") || !TextUtils.equals(str, "0");
    }
}
