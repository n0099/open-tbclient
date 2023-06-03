package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.net.update.CommandPostData;
import org.json.JSONException;
/* loaded from: classes4.dex */
public abstract class SwitchListener extends AbstractCommandListener<SwitchData> {
    public static final String VERSION_POSTFIX = "_version";

    public abstract String getKey(String str, String str2);

    public static boolean getSwitchValue(String str) {
        if (TextUtils.equals(str, "1") || !TextUtils.equals(str, "0")) {
            return true;
        }
        return false;
    }

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
            if (!AppConfig.isDebug()) {
                return false;
            }
            throw new IllegalArgumentException("getKey should be implemented correctly to return preference key");
        }
        SwitchData switchData = actionData.data;
        if (switchData == null || switchData.auth == null || !handleData(context, str, str2, key, getSwitchValue(switchData.auth))) {
            return false;
        }
        DefaultSharedPrefsWrapper defaultSharedPrefsWrapper = DefaultSharedPrefsWrapper.getInstance();
        defaultSharedPrefsWrapper.putString(key + "_version", actionData.version);
        return true;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return DefaultSharedPrefsWrapper.getInstance().getString(getKey(str, str2) + "_version", "0");
    }

    public boolean handleData(Context context, String str, String str2, String str3, boolean z) {
        DefaultSharedPrefsWrapper.getInstance().putBoolean(str3, z);
        return true;
    }
}
