package com.baidu.swan.games.r;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private static volatile b blE;
    private volatile ArrayList<a> blF = new ArrayList<>(20);
    private int mDropCount;

    private b() {
    }

    public static b Tj() {
        if (blE == null) {
            synchronized (b.class) {
                if (blE == null) {
                    blE = new b();
                }
            }
        }
        return blE;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.blF.size() < 20) {
                this.blF.add(aVar);
            } else {
                this.mDropCount++;
            }
        }
    }

    public synchronized JSONObject Tk() {
        JSONObject jSONObject;
        int size;
        JSONArray jSONArray;
        JSONObject jSONObject2 = new JSONObject();
        try {
            size = this.blF.size();
            jSONObject2.put("dropcnt", this.mDropCount);
            jSONObject2.put("errorcnt", size);
            jSONArray = new JSONArray();
            jSONObject2.put("errors", jSONArray);
        } catch (JSONException e) {
        }
        if (size == 0) {
            jSONObject = jSONObject2;
        } else {
            Iterator<a> it = this.blF.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJSON());
            }
            this.blF.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.blF.clear();
        this.mDropCount = 0;
    }
}
