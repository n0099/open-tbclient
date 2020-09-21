package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    private int a;
    private ArrayList<e> b = new ArrayList<>();

    public c(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            if (this.a != 24321 && this.a != 24323 && this.a != 24322 && this.a != 20488) {
                jSONObject.put("type", this.a);
            }
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                e eVar = this.b.get(i);
                if (eVar != null) {
                    jSONObject.put(eVar.a(), eVar.b());
                }
            }
        }
        return jSONObject;
    }

    public void a(e eVar) {
        this.b.add(eVar);
    }

    public void b() {
        if (this.b != null) {
            this.b.clear();
        }
    }
}
