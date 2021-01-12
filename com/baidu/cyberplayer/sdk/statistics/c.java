package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private int f1836a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<e> f1837b = new ArrayList<>();

    public c(int i) {
        this.f1836a = i;
    }

    public int a() {
        return this.f1836a;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            if (this.f1836a != 24321 && this.f1836a != 24323 && this.f1836a != 24322 && this.f1836a != 20488) {
                jSONObject.put("type", this.f1836a);
            }
            int size = this.f1837b.size();
            for (int i = 0; i < size; i++) {
                e eVar = this.f1837b.get(i);
                if (eVar != null) {
                    jSONObject.put(eVar.a(), eVar.b());
                }
            }
        }
        return jSONObject;
    }

    public void a(e eVar) {
        this.f1837b.add(eVar);
    }

    public void b() {
        if (this.f1837b != null) {
            this.f1837b.clear();
        }
    }
}
