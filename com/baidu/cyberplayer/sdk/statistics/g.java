package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public c f4999a = new c(DpStatConstants.SESSION_TYPE_PLAY_COMMON);

    /* renamed from: b  reason: collision with root package name */
    public List<f> f5000b = new ArrayList();

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        c cVar = this.f4999a;
        if (cVar != null) {
            cVar.a(jSONObject);
        }
        if (this.f5000b != null) {
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < this.f5000b.size(); i2++) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", this.f5000b.get(i2).a());
                if (this.f5000b.get(i2).a(jSONObject2) != null) {
                    jSONArray.put(jSONObject2);
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("data", jSONArray);
            }
        }
        return jSONObject;
    }

    public void a(int i2, String str, String str2) {
        c cVar = this.f4999a;
        if (cVar != null && i2 == 24322) {
            cVar.a(new e(i2, str, str2));
        } else if (this.f5000b != null) {
            e eVar = new e(i2, str, str2);
            for (int i3 = 0; i3 < this.f5000b.size(); i3++) {
                f fVar = this.f5000b.get(i3);
                if (fVar.a() == i2) {
                    fVar.a(eVar);
                    return;
                }
            }
            f fVar2 = new f(i2);
            fVar2.a(eVar);
            this.f5000b.add(fVar2);
        }
    }

    public void b() {
        c cVar = this.f4999a;
        if (cVar != null) {
            cVar.b();
        }
        List<f> list = this.f5000b;
        if (list != null) {
            list.clear();
        }
    }
}
