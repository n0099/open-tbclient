package com.baidu.swan.games.r;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private static volatile b blg;
    private volatile ArrayList<a> blh = new ArrayList<>(20);
    private int mDropCount;

    private b() {
    }

    public static b Tf() {
        if (blg == null) {
            synchronized (b.class) {
                if (blg == null) {
                    blg = new b();
                }
            }
        }
        return blg;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.blh.size() < 20) {
                this.blh.add(aVar);
            } else {
                this.mDropCount++;
            }
        }
    }

    public synchronized JSONObject Tg() {
        JSONObject jSONObject;
        int size;
        JSONArray jSONArray;
        JSONObject jSONObject2 = new JSONObject();
        try {
            size = this.blh.size();
            jSONObject2.put("dropcnt", this.mDropCount);
            jSONObject2.put("errorcnt", size);
            jSONArray = new JSONArray();
            jSONObject2.put("errors", jSONArray);
        } catch (JSONException e) {
        }
        if (size == 0) {
            jSONObject = jSONObject2;
        } else {
            Iterator<a> it = this.blh.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJSON());
            }
            this.blh.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.blh.clear();
        this.mDropCount = 0;
    }
}
