package com.baidu.searchbox.command;

import android.content.Intent;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CommandEntity {
    public JSONObject mCommand;
    public Intent mIntent;

    public boolean valid() {
        return false;
    }

    public CommandEntity() {
    }

    public CommandEntity(String str, Intent intent) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.mCommand = new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        this.mIntent = intent;
    }

    public CommandEntity(JSONObject jSONObject, Intent intent) {
        this.mCommand = jSONObject;
        this.mIntent = intent;
    }
}
