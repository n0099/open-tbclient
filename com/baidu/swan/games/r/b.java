package com.baidu.swan.games.r;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private static volatile b bkt;
    private volatile ArrayList<a> bku = new ArrayList<>(20);
    private int mDropCount;

    private b() {
    }

    public static b Sm() {
        if (bkt == null) {
            synchronized (b.class) {
                if (bkt == null) {
                    bkt = new b();
                }
            }
        }
        return bkt;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.bku.size() < 20) {
                this.bku.add(aVar);
            } else {
                this.mDropCount++;
            }
        }
    }

    public synchronized JSONObject Sn() {
        JSONObject jSONObject;
        int size;
        JSONArray jSONArray;
        JSONObject jSONObject2 = new JSONObject();
        try {
            size = this.bku.size();
            jSONObject2.put("dropcnt", this.mDropCount);
            jSONObject2.put("errorcnt", size);
            jSONArray = new JSONArray();
            jSONObject2.put("errors", jSONArray);
        } catch (JSONException e) {
        }
        if (size == 0) {
            jSONObject = jSONObject2;
        } else {
            Iterator<a> it = this.bku.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJSON());
            }
            this.bku.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.bku.clear();
        this.mDropCount = 0;
    }
}
