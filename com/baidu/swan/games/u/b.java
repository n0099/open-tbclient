package com.baidu.swan.games.u;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static volatile b csn;
    private int alX;
    private volatile ArrayList<a> cso = new ArrayList<>(20);

    private b() {
    }

    public static b apD() {
        if (csn == null) {
            synchronized (b.class) {
                if (csn == null) {
                    csn = new b();
                }
            }
        }
        return csn;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.cso.size() < 20) {
                this.cso.add(aVar);
            } else {
                this.alX++;
            }
        }
    }

    public synchronized JSONObject apE() {
        JSONObject jSONObject;
        int size = this.cso.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.alX);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.cso.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.cso.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.cso.clear();
        this.alX = 0;
    }
}
