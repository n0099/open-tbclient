package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final int f4996a;

    /* renamed from: c  reason: collision with root package name */
    public c f4998c = new c(DpStatConstants.SESSION_TYPE_PLAY_COMMON);

    /* renamed from: b  reason: collision with root package name */
    public List<c> f4997b = new ArrayList();

    public f(int i2) {
        this.f4996a = i2;
    }

    public int a() {
        return this.f4996a;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        this.f4998c.a(jSONObject);
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < this.f4997b.size(); i2++) {
            JSONObject jSONObject2 = new JSONObject();
            if (this.f4997b.get(i2).a(jSONObject2) != null) {
                jSONArray.put(jSONObject2);
            }
        }
        if (jSONArray.length() != 0) {
            jSONObject.put("data", jSONArray);
        }
        return jSONObject;
    }

    public void a(e eVar) {
        this.f4998c.a(eVar);
    }
}
