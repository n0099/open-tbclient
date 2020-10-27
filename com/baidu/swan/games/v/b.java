package com.baidu.swan.games.v;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private static volatile b dTz;
    private int baw;
    private volatile ArrayList<a> dTA = new ArrayList<>(20);

    private b() {
    }

    public static b aUB() {
        if (dTz == null) {
            synchronized (b.class) {
                if (dTz == null) {
                    dTz = new b();
                }
            }
        }
        return dTz;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.dTA.size() < 20) {
                this.dTA.add(aVar);
            } else {
                this.baw++;
            }
        }
    }

    public synchronized JSONObject aUC() {
        JSONObject jSONObject;
        int size = this.dTA.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.baw);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.dTA.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.dTA.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.dTA.clear();
        this.baw = 0;
    }
}
