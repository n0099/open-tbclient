package com.baidu.swan.games.u;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static volatile b cso;
    private int alY;
    private volatile ArrayList<a> csp = new ArrayList<>(20);

    private b() {
    }

    public static b apD() {
        if (cso == null) {
            synchronized (b.class) {
                if (cso == null) {
                    cso = new b();
                }
            }
        }
        return cso;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.csp.size() < 20) {
                this.csp.add(aVar);
            } else {
                this.alY++;
            }
        }
    }

    public synchronized JSONObject apE() {
        JSONObject jSONObject;
        int size = this.csp.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.alY);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.csp.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.csp.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.csp.clear();
        this.alY = 0;
    }
}
