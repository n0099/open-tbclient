package com.baidu.swan.games.r;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private static volatile b bDB;
    private int abf;
    private volatile ArrayList<a> bDC = new ArrayList<>(20);

    private b() {
    }

    public static b XY() {
        if (bDB == null) {
            synchronized (b.class) {
                if (bDB == null) {
                    bDB = new b();
                }
            }
        }
        return bDB;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.bDC.size() < 20) {
                this.bDC.add(aVar);
            } else {
                this.abf++;
            }
        }
    }

    public synchronized JSONObject XZ() {
        JSONObject jSONObject;
        int size;
        JSONArray jSONArray;
        JSONObject jSONObject2 = new JSONObject();
        try {
            size = this.bDC.size();
            jSONObject2.put("dropcnt", this.abf);
            jSONObject2.put("errorcnt", size);
            jSONArray = new JSONArray();
            jSONObject2.put("errors", jSONArray);
        } catch (JSONException e) {
        }
        if (size == 0) {
            jSONObject = jSONObject2;
        } else {
            Iterator<a> it = this.bDC.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJSON());
            }
            this.bDC.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.bDC.clear();
        this.abf = 0;
    }
}
