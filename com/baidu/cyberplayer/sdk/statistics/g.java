package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class g {
    private c a = new c(DpStatConstants.SESSION_TYPE_PLAY_COMMON);
    private List<f> b = new ArrayList();

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (this.a != null) {
            this.a.a(jSONObject);
        }
        if (this.b != null) {
            JSONArray jSONArray = new JSONArray();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.b.size()) {
                    break;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", this.b.get(i2).a());
                if (this.b.get(i2).a(jSONObject2) != null) {
                    jSONArray.put(jSONObject2);
                }
                i = i2 + 1;
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("data", jSONArray);
            }
        }
        return jSONObject;
    }

    public void a(int i, String str, String str2) {
        if (this.a != null && i == 24322) {
            this.a.a(new e(i, str, str2));
        } else if (this.b == null) {
        } else {
            e eVar = new e(i, str, str2);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= this.b.size()) {
                    f fVar = new f(i);
                    fVar.a(eVar);
                    this.b.add(fVar);
                    return;
                }
                f fVar2 = this.b.get(i3);
                if (fVar2.a() == i) {
                    fVar2.a(eVar);
                    return;
                }
                i2 = i3 + 1;
            }
        }
    }

    public void b() {
        if (this.a != null) {
            this.a.b();
        }
        if (this.b != null) {
            this.b.clear();
        }
    }
}
