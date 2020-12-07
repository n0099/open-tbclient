package com.baidu.swan.games.v;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public class b {
    private static volatile b eeI;
    private int bdC;
    private volatile ArrayList<a> eeJ = new ArrayList<>(20);

    private b() {
    }

    public static b aZy() {
        if (eeI == null) {
            synchronized (b.class) {
                if (eeI == null) {
                    eeI = new b();
                }
            }
        }
        return eeI;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.eeJ.size() < 20) {
                this.eeJ.add(aVar);
            } else {
                this.bdC++;
            }
        }
    }

    public synchronized JSONObject aZz() {
        JSONObject jSONObject;
        int size = this.eeJ.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.bdC);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.eeJ.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.eeJ.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.eeJ.clear();
        this.bdC = 0;
    }
}
