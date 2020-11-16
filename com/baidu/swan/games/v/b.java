package com.baidu.swan.games.v;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private static volatile b dXJ;
    private int bac;
    private volatile ArrayList<a> dXK = new ArrayList<>(20);

    private b() {
    }

    public static b aWt() {
        if (dXJ == null) {
            synchronized (b.class) {
                if (dXJ == null) {
                    dXJ = new b();
                }
            }
        }
        return dXJ;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.dXK.size() < 20) {
                this.dXK.add(aVar);
            } else {
                this.bac++;
            }
        }
    }

    public synchronized JSONObject aWu() {
        JSONObject jSONObject;
        int size = this.dXK.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.bac);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.dXK.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.dXK.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.dXK.clear();
        this.bac = 0;
    }
}
