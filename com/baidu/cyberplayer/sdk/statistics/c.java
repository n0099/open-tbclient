package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private int f1886a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<e> f1887b = new ArrayList<>();

    public c(int i) {
        this.f1886a = i;
    }

    public int a() {
        return this.f1886a;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            if (this.f1886a != 24321 && this.f1886a != 24323 && this.f1886a != 24322 && this.f1886a != 20488) {
                jSONObject.put("type", this.f1886a);
            }
            int size = this.f1887b.size();
            for (int i = 0; i < size; i++) {
                e eVar = this.f1887b.get(i);
                if (eVar != null) {
                    jSONObject.put(eVar.a(), eVar.b());
                }
            }
        }
        return jSONObject;
    }

    public void a(e eVar) {
        this.f1887b.add(eVar);
    }

    public void b() {
        if (this.f1887b != null) {
            this.f1887b.clear();
        }
    }
}
