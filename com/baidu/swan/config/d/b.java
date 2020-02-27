package com.baidu.swan.config.d;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.config.core.b.a {
    @Override // com.baidu.swan.config.core.b.c
    public void bj(JSONObject jSONObject) {
        int optInt;
        JSONArray optJSONArray;
        JSONObject bi = bi(jSONObject);
        if (bi != null && (optInt = bi.optInt("version")) > 0 && (optJSONArray = bi.optJSONArray("tips")) != null) {
            HashMap<String, String> hashMap = new HashMap<>(optJSONArray.length());
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                hashMap.put(optJSONObject.optString("tipno"), optJSONObject.optString("tipmsg"));
            }
            c.ajg().c(hashMap, optInt);
        }
    }
}
