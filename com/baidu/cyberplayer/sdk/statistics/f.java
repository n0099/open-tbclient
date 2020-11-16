package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final int f1435a;
    private c c = new c(DpStatConstants.SESSION_TYPE_PLAY_COMMON);
    private List<c> b = new ArrayList();

    public f(int i) {
        this.f1435a = i;
    }

    public int a() {
        return this.f1435a;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        this.c.a(jSONObject);
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.size()) {
                break;
            }
            JSONObject jSONObject2 = new JSONObject();
            if (this.b.get(i2).a(jSONObject2) != null) {
                jSONArray.put(jSONObject2);
            }
            i = i2 + 1;
        }
        if (jSONArray.length() != 0) {
            jSONObject.put("data", jSONArray);
        }
        return jSONObject;
    }

    public void a(e eVar) {
        this.c.a(eVar);
    }
}
