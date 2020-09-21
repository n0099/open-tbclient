package com.baidu.swan.games.v;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    private static volatile b dzb;
    private int aVN;
    private volatile ArrayList<a> dzc = new ArrayList<>(20);

    private b() {
    }

    public static b aPY() {
        if (dzb == null) {
            synchronized (b.class) {
                if (dzb == null) {
                    dzb = new b();
                }
            }
        }
        return dzb;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.dzc.size() < 20) {
                this.dzc.add(aVar);
            } else {
                this.aVN++;
            }
        }
    }

    public synchronized JSONObject aPZ() {
        JSONObject jSONObject;
        int size = this.dzc.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.aVN);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.dzc.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.dzc.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.dzc.clear();
        this.aVN = 0;
    }
}
