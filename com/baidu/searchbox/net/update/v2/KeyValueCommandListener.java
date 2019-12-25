package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.net.update.CommandPostData;
import com.google.gson.JsonElement;
import org.json.JSONException;
/* loaded from: classes11.dex */
public abstract class KeyValueCommandListener extends AbstractCommandListener<JsonElement> {
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
    public boolean executeCommand(Context context, String str, String str2, ActionData<JsonElement> actionData) {
        String key = getKey(str, str2);
        if (key == null) {
            throw new IllegalArgumentException("getKey should be implemented correctly to return preference key");
        }
        if (handleData(context, str, str2, key, actionData.data.isJsonPrimitive() ? actionData.data.getAsString() : actionData.data.toString())) {
            DefaultSharedPrefsWrapper.getInstance().putString(key + VERSION_POSTFIX, actionData.version);
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return DefaultSharedPrefsWrapper.getInstance().getString(getKey(str, str2) + VERSION_POSTFIX, "0");
    }

    public boolean handleData(Context context, String str, String str2, String str3, String str4) {
        DefaultSharedPrefsWrapper.getInstance().putString(str3, str4);
        return true;
    }
}
