package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f5069a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<e> f5070b = new ArrayList<>();

    public c(int i) {
        this.f5069a = i;
    }

    public int a() {
        return this.f5069a;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return jSONObject;
        }
        int i = this.f5069a;
        if (i != 24321 && i != 24323 && i != 24322 && i != 20488) {
            jSONObject.put("type", i);
        }
        int size = this.f5070b.size();
        for (int i2 = 0; i2 < size; i2++) {
            e eVar = this.f5070b.get(i2);
            if (eVar != null) {
                jSONObject.put(eVar.a(), eVar.b());
            }
        }
        return jSONObject;
    }

    public void a(e eVar) {
        this.f5070b.add(eVar);
    }

    public void b() {
        ArrayList<e> arrayList = this.f5070b;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
