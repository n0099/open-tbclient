package com.baidu.swan.games.v;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private static volatile b emD;
    private volatile ArrayList<a> emE = new ArrayList<>(20);
    private int mDropCount;

    private b() {
    }

    public static b aYo() {
        if (emD == null) {
            synchronized (b.class) {
                if (emD == null) {
                    emD = new b();
                }
            }
        }
        return emD;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.emE.size() < 20) {
                this.emE.add(aVar);
            } else {
                this.mDropCount++;
            }
        }
    }

    public synchronized JSONObject aYp() {
        JSONObject jSONObject;
        int size = this.emE.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.mDropCount);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.emE.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.emE.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.emE.clear();
        this.mDropCount = 0;
    }
}
