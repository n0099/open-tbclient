package com.baidu.swan.games.u;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static volatile b cRz;
    private int aEG;
    private volatile ArrayList<a> cRA = new ArrayList<>(20);

    private b() {
    }

    public static b axS() {
        if (cRz == null) {
            synchronized (b.class) {
                if (cRz == null) {
                    cRz = new b();
                }
            }
        }
        return cRz;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.cRA.size() < 20) {
                this.cRA.add(aVar);
            } else {
                this.aEG++;
            }
        }
    }

    public synchronized JSONObject axT() {
        JSONObject jSONObject;
        int size = this.cRA.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.aEG);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.cRA.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.cRA.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.cRA.clear();
        this.aEG = 0;
    }
}
