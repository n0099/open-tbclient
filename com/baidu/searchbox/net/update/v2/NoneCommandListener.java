package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import com.baidu.searchbox.net.update.CommandPostData;
import com.google.gson.JsonElement;
import org.json.JSONException;
/* loaded from: classes13.dex */
public class NoneCommandListener extends AbstractCommandListener<JsonElement> {
    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException {
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public boolean executeCommand(Context context, String str, String str2, ActionData<JsonElement> actionData) {
        return false;
    }

    @Override // com.baidu.searchbox.net.update.v2.AbstractCommandListener
    public String getLocalVersion(Context context, String str, String str2) {
        return null;
    }
}
