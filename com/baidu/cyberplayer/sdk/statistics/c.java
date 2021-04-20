package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public int f5105a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<e> f5106b = new ArrayList<>();

    public c(int i) {
        this.f5105a = i;
    }

    public int a() {
        return this.f5105a;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return jSONObject;
        }
        int i = this.f5105a;
        if (i != 24321 && i != 24323 && i != 24322 && i != 20488) {
            jSONObject.put("type", i);
        }
        int size = this.f5106b.size();
        for (int i2 = 0; i2 < size; i2++) {
            e eVar = this.f5106b.get(i2);
            if (eVar != null) {
                jSONObject.put(eVar.a(), eVar.b());
            }
        }
        return jSONObject;
    }

    public void a(e eVar) {
        this.f5106b.add(eVar);
    }

    public void b() {
        ArrayList<e> arrayList = this.f5106b;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
