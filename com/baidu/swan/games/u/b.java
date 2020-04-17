package com.baidu.swan.games.u;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static volatile b cRu;
    private int aEA;
    private volatile ArrayList<a> cRv = new ArrayList<>(20);

    private b() {
    }

    public static b axS() {
        if (cRu == null) {
            synchronized (b.class) {
                if (cRu == null) {
                    cRu = new b();
                }
            }
        }
        return cRu;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.cRv.size() < 20) {
                this.cRv.add(aVar);
            } else {
                this.aEA++;
            }
        }
    }

    public synchronized JSONObject axT() {
        JSONObject jSONObject;
        int size = this.cRv.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.aEA);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.cRv.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.cRv.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.cRv.clear();
        this.aEA = 0;
    }
}
