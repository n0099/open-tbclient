package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.net.update.CommandPostData;
import com.google.gson.JsonElement;
import org.json.JSONException;
/* loaded from: classes3.dex */
public abstract class KeyValueCommandListener extends AbstractCommandListener<JsonElement> {
    public static final String VERSION_POSTFIX = "_version";

    public abstract String getKey(String str, String str2);

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
        String localVersion = getLocalVersion(context, str, str2);
        if (commandPostData != null && commandPostData.getVersion() != null) {
            commandPostData.getVersion().put(str2, localVersion);
        }
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JsonElement> actionData) {
        String jsonElement;
        String key = getKey(str, str2);
        if (key == null) {
            if (!AppConfig.isDebug()) {
                return false;
            }
            throw new IllegalArgumentException("getKey should be implemented correctly to return preference key");
        }
        if (actionData.data.isJsonPrimitive()) {
            jsonElement = actionData.data.getAsString();
        } else {
            jsonElement = actionData.data.toString();
        }
        if (!handleData(context, str, str2, key, jsonElement)) {
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

    public boolean handleData(Context context, String str, String str2, String str3, String str4) {
        DefaultSharedPrefsWrapper.getInstance().putString(str3, str4);
        return true;
    }
}
