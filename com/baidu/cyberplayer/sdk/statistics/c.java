package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f5070a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<e> f5071b = new ArrayList<>();

    public c(int i) {
        this.f5070a = i;
    }

    public int a() {
        return this.f5070a;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return jSONObject;
        }
        int i = this.f5070a;
        if (i != 24321 && i != 24323 && i != 24322 && i != 20488) {
            jSONObject.put("type", i);
        }
        int size = this.f5071b.size();
        for (int i2 = 0; i2 < size; i2++) {
            e eVar = this.f5071b.get(i2);
            if (eVar != null) {
                jSONObject.put(eVar.a(), eVar.b());
            }
        }
        return jSONObject;
    }

    public void a(e eVar) {
        this.f5071b.add(eVar);
    }

    public void b() {
        ArrayList<e> arrayList = this.f5071b;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
