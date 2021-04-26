package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final int f5242a;

    /* renamed from: c  reason: collision with root package name */
    public c f5244c = new c(DpStatConstants.SESSION_TYPE_PLAY_COMMON);

    /* renamed from: b  reason: collision with root package name */
    public List<c> f5243b = new ArrayList();

    public f(int i2) {
        this.f5242a = i2;
    }

    public int a() {
        return this.f5242a;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        this.f5244c.a(jSONObject);
        JSONArray jSONArray = new JSONArray();
        for (int i2 = 0; i2 < this.f5243b.size(); i2++) {
            JSONObject jSONObject2 = new JSONObject();
            if (this.f5243b.get(i2).a(jSONObject2) != null) {
                jSONArray.put(jSONObject2);
            }
        }
        if (jSONArray.length() != 0) {
            jSONObject.put("data", jSONArray);
        }
        return jSONObject;
    }

    public void a(e eVar) {
        this.f5244c.a(eVar);
    }
}
