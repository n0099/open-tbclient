package com.baidu.swan.games.v;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private static volatile b dmR;
    private int aOj;
    private volatile ArrayList<a> dmS = new ArrayList<>(20);

    private b() {
    }

    public static b aGw() {
        if (dmR == null) {
            synchronized (b.class) {
                if (dmR == null) {
                    dmR = new b();
                }
            }
        }
        return dmR;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.dmS.size() < 20) {
                this.dmS.add(aVar);
            } else {
                this.aOj++;
            }
        }
    }

    public synchronized JSONObject aGx() {
        JSONObject jSONObject;
        int size = this.dmS.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.aOj);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.dmS.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.dmS.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.dmS.clear();
        this.aOj = 0;
    }
}
