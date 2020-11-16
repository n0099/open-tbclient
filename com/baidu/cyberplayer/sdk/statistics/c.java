package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private int f1432a;
    private ArrayList<e> b = new ArrayList<>();

    public c(int i) {
        this.f1432a = i;
    }

    public int a() {
        return this.f1432a;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            if (this.f1432a != 24321 && this.f1432a != 24323 && this.f1432a != 24322 && this.f1432a != 20488) {
                jSONObject.put("type", this.f1432a);
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
