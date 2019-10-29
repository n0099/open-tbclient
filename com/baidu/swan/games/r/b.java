package com.baidu.swan.games.r;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    private static volatile b bEs;
    private int aby;
    private volatile ArrayList<a> bEt = new ArrayList<>(20);

    private b() {
    }

    public static b Ya() {
        if (bEs == null) {
            synchronized (b.class) {
                if (bEs == null) {
                    bEs = new b();
                }
            }
        }
        return bEs;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.bEt.size() < 20) {
                this.bEt.add(aVar);
            } else {
                this.aby++;
            }
        }
    }

    public synchronized JSONObject Yb() {
        JSONObject jSONObject;
        int size;
        JSONArray jSONArray;
        JSONObject jSONObject2 = new JSONObject();
        try {
            size = this.bEt.size();
            jSONObject2.put("dropcnt", this.aby);
            jSONObject2.put("errorcnt", size);
            jSONArray = new JSONArray();
            jSONObject2.put("errors", jSONArray);
        } catch (JSONException e) {
        }
        if (size == 0) {
            jSONObject = jSONObject2;
        } else {
            Iterator<a> it = this.bEt.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJSON());
            }
            this.bEt.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.bEt.clear();
        this.aby = 0;
    }
}
