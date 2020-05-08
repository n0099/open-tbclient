package com.baidu.swan.config.b;

import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.swan.config.e;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.config.core.a.a {
    @Override // com.baidu.swan.config.core.a.c
    public JSONObject arn() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put(SharedPrefConfig.VERSION_NAME, e.ari().acN());
            jSONObject.put("swan_core", jSONObject2);
            jSONObject3.put(SharedPrefConfig.VERSION_NAME, e.ari().acP());
            jSONObject.put("swan_game", jSONObject3);
        } catch (JSONException e) {
            if (e.DEBUG) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
