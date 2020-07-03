package com.baidu.swan.games.v;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static volatile b dhi;
    private int aMO;
    private volatile ArrayList<a> dhj = new ArrayList<>(20);

    private b() {
    }

    public static b aCP() {
        if (dhi == null) {
            synchronized (b.class) {
                if (dhi == null) {
                    dhi = new b();
                }
            }
        }
        return dhi;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.dhj.size() < 20) {
                this.dhj.add(aVar);
            } else {
                this.aMO++;
            }
        }
    }

    public synchronized JSONObject aCQ() {
        JSONObject jSONObject;
        int size = this.dhj.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.aMO);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.dhj.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.dhj.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.dhj.clear();
        this.aMO = 0;
    }
}
