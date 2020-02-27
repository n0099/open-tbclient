package com.baidu.swan.games.u;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static volatile b csm;
    private int alX;
    private volatile ArrayList<a> csn = new ArrayList<>(20);

    private b() {
    }

    public static b apB() {
        if (csm == null) {
            synchronized (b.class) {
                if (csm == null) {
                    csm = new b();
                }
            }
        }
        return csm;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.csn.size() < 20) {
                this.csn.add(aVar);
            } else {
                this.alX++;
            }
        }
    }

    public synchronized JSONObject apC() {
        JSONObject jSONObject;
        int size = this.csn.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.alX);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.csn.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.csn.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.csn.clear();
        this.alX = 0;
    }
}
