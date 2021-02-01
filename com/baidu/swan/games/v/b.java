package com.baidu.swan.games.v;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    private static volatile b elc;
    private volatile ArrayList<a> eld = new ArrayList<>(20);
    private int mDropCount;

    private b() {
    }

    public static b aYl() {
        if (elc == null) {
            synchronized (b.class) {
                if (elc == null) {
                    elc = new b();
                }
            }
        }
        return elc;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.eld.size() < 20) {
                this.eld.add(aVar);
            } else {
                this.mDropCount++;
            }
        }
    }

    public synchronized JSONObject aYm() {
        JSONObject jSONObject;
        int size = this.eld.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.mDropCount);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.eld.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.eld.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.eld.clear();
        this.mDropCount = 0;
    }
}
