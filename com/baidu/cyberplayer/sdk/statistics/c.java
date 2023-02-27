package com.baidu.cyberplayer.sdk.statistics;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public int a;
    public ArrayList<e> b = new ArrayList<>();

    public c(int i) {
        this.a = i;
    }

    public int a() {
        return this.a;
    }

    public JSONObject a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return jSONObject;
        }
        int i = this.a;
        if (i != 24321 && i != 24323 && i != 24322 && i != 20488) {
            jSONObject.put("type", i);
        }
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            e eVar = this.b.get(i2);
            if (eVar != null) {
                jSONObject.put(eVar.a(), eVar.b());
            }
        }
        return jSONObject;
    }

    public void a(e eVar) {
        this.b.add(eVar);
    }

    public void b() {
        ArrayList<e> arrayList = this.b;
        if (arrayList != null) {
            arrayList.clear();
        }
    }
}
