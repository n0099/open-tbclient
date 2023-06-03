package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {
    public final int a;
    public c c = new c(DpStatConstants.SESSION_TYPE_PLAY_COMMON);
    public List<c> b = new ArrayList();

    public f(int i) {
        this.a = i;
    }

    public void a(e eVar) {
        this.c.a(eVar);
    }

    public int a() {
        return this.a;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        this.c.a(jSONObject);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < this.b.size(); i++) {
            JSONObject jSONObject2 = new JSONObject();
            if (this.b.get(i).a(jSONObject2) != null) {
                jSONArray.put(jSONObject2);
            }
        }
        if (jSONArray.length() != 0) {
            jSONObject.put("data", jSONArray);
        }
        return jSONObject;
    }
}
