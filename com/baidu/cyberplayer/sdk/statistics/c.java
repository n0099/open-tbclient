package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f5234a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<e> f5235b = new ArrayList<>();

    public c(int i2) {
        this.f5234a = i2;
    }

    public int a() {
        return this.f5234a;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return jSONObject;
        }
        int i2 = this.f5234a;
        if (i2 != 24321 && i2 != 24323 && i2 != 24322 && i2 != 20488) {
            jSONObject.put("type", i2);
        }
        int size = this.f5235b.size();
        for (int i3 = 0; i3 < size; i3++) {
            e eVar = this.f5235b.get(i3);
            if (eVar != null) {
                jSONObject.put(eVar.a(), eVar.b());
            }
        }
        return jSONObject;
    }

    public void a(e eVar) {
        this.f5235b.add(eVar);
    }

    public void b() {
        ArrayList<e> arrayList = this.f5235b;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
