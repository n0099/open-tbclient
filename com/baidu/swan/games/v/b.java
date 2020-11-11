package com.baidu.swan.games.v;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private static volatile b dZr;
    private int bbO;
    private volatile ArrayList<a> dZs = new ArrayList<>(20);

    private b() {
    }

    public static b aXb() {
        if (dZr == null) {
            synchronized (b.class) {
                if (dZr == null) {
                    dZr = new b();
                }
            }
        }
        return dZr;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.dZs.size() < 20) {
                this.dZs.add(aVar);
            } else {
                this.bbO++;
            }
        }
    }

    public synchronized JSONObject aXc() {
        JSONObject jSONObject;
        int size = this.dZs.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.bbO);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.dZs.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.dZs.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.dZs.clear();
        this.bbO = 0;
    }
}
