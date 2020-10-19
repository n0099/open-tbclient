package com.baidu.swan.games.v;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private static volatile b dLc;
    private int aYY;
    private volatile ArrayList<a> dLd = new ArrayList<>(20);

    private b() {
    }

    public static b aSH() {
        if (dLc == null) {
            synchronized (b.class) {
                if (dLc == null) {
                    dLc = new b();
                }
            }
        }
        return dLc;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.dLd.size() < 20) {
                this.dLd.add(aVar);
            } else {
                this.aYY++;
            }
        }
    }

    public synchronized JSONObject aSI() {
        JSONObject jSONObject;
        int size = this.dLd.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.aYY);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.dLd.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.dLd.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.dLd.clear();
        this.aYY = 0;
    }
}
