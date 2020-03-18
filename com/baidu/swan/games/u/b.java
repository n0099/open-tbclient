package com.baidu.swan.games.u;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static volatile b csz;
    private int ami;
    private volatile ArrayList<a> csA = new ArrayList<>(20);

    private b() {
    }

    public static b apG() {
        if (csz == null) {
            synchronized (b.class) {
                if (csz == null) {
                    csz = new b();
                }
            }
        }
        return csz;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.csA.size() < 20) {
                this.csA.add(aVar);
            } else {
                this.ami++;
            }
        }
    }

    public synchronized JSONObject apH() {
        JSONObject jSONObject;
        int size = this.csA.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.ami);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.csA.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.csA.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.csA.clear();
        this.ami = 0;
    }
}
