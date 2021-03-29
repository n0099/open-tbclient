package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public c f5081a = new c(DpStatConstants.SESSION_TYPE_PLAY_COMMON);

    /* renamed from: b  reason: collision with root package name */
    public List<f> f5082b = new ArrayList();

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        c cVar = this.f5081a;
        if (cVar != null) {
            cVar.a(jSONObject);
        }
        if (this.f5082b != null) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.f5082b.size(); i++) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", this.f5082b.get(i).a());
                if (this.f5082b.get(i).a(jSONObject2) != null) {
                    jSONArray.put(jSONObject2);
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("data", jSONArray);
            }
        }
        return jSONObject;
    }

    public void a(int i, String str, String str2) {
        c cVar = this.f5081a;
        if (cVar != null && i == 24322) {
            cVar.a(new e(i, str, str2));
        } else if (this.f5082b != null) {
            e eVar = new e(i, str, str2);
            for (int i2 = 0; i2 < this.f5082b.size(); i2++) {
                f fVar = this.f5082b.get(i2);
                if (fVar.a() == i) {
                    fVar.a(eVar);
                    return;
                }
            }
            f fVar2 = new f(i);
            fVar2.a(eVar);
            this.f5082b.add(fVar2);
        }
    }

    public void b() {
        c cVar = this.f5081a;
        if (cVar != null) {
            cVar.b();
        }
        List<f> list = this.f5082b;
        if (list != null) {
            list.clear();
        }
    }
}
