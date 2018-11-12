package com.baidu.searchbox.ng.ai.apps.channel.im;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppImParserFromBundle {
    public JSONObject getJSONObjectByObject(Object obj) {
        JSONObject jSONObject;
        if (obj == null || !(obj instanceof Bundle)) {
            return null;
        }
        String string = ((Bundle) obj).getString("ai_apps_data");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(string);
        } catch (JSONException e) {
            jSONObject = null;
        }
        return jSONObject;
    }
}
