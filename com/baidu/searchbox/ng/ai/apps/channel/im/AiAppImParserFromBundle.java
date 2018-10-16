package com.baidu.searchbox.ng.ai.apps.channel.im;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.process.AiAppsMessengerClient;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AiAppImParserFromBundle {
    public JSONObject getJSONObjectByObject(Object obj) {
        JSONObject jSONObject;
        if (obj == null || !(obj instanceof Bundle)) {
            return null;
        }
        String string = ((Bundle) obj).getString(AiAppsMessengerClient.MSG_BUNDLE_DATA_KEY);
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
