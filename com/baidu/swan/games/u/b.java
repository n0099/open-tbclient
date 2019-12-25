package com.baidu.swan.games.u;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    private static volatile b cnY;
    private int ajh;
    private volatile ArrayList<a> cnZ = new ArrayList<>(20);

    private b() {
    }

    public static b amU() {
        if (cnY == null) {
            synchronized (b.class) {
                if (cnY == null) {
                    cnY = new b();
                }
            }
        }
        return cnY;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.cnZ.size() < 20) {
                this.cnZ.add(aVar);
            } else {
                this.ajh++;
            }
        }
    }

    public synchronized JSONObject amV() {
        JSONObject jSONObject;
        int size = this.cnZ.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.ajh);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.cnZ.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.cnZ.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.cnZ.clear();
        this.ajh = 0;
    }
}
