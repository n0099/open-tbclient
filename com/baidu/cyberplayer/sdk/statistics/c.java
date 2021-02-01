package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private int f1834a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<e> f1835b = new ArrayList<>();

    public c(int i) {
        this.f1834a = i;
    }

    public int a() {
        return this.f1834a;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            if (this.f1834a != 24321 && this.f1834a != 24323 && this.f1834a != 24322 && this.f1834a != 20488) {
                jSONObject.put("type", this.f1834a);
            }
            int size = this.f1835b.size();
            for (int i = 0; i < size; i++) {
                e eVar = this.f1835b.get(i);
                if (eVar != null) {
                    jSONObject.put(eVar.a(), eVar.b());
                }
            }
        }
        return jSONObject;
    }

    public void a(e eVar) {
        this.f1835b.add(eVar);
    }

    public void b() {
        if (this.f1835b != null) {
            this.f1835b.clear();
        }
    }
}
