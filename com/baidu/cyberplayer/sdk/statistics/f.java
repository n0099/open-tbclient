package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final int f5113a;

    /* renamed from: c  reason: collision with root package name */
    public c f5115c = new c(DpStatConstants.SESSION_TYPE_PLAY_COMMON);

    /* renamed from: b  reason: collision with root package name */
    public List<c> f5114b = new ArrayList();

    public f(int i) {
        this.f5113a = i;
    }

    public int a() {
        return this.f5113a;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        this.f5115c.a(jSONObject);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < this.f5114b.size(); i++) {
            JSONObject jSONObject2 = new JSONObject();
            if (this.f5114b.get(i).a(jSONObject2) != null) {
                jSONArray.put(jSONObject2);
            }
        }
        if (jSONArray.length() != 0) {
            jSONObject.put("data", jSONArray);
        }
        return jSONObject;
    }

    public void a(e eVar) {
        this.f5115c.a(eVar);
    }
}
