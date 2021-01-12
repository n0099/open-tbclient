package com.baidu.swan.games.v;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private static volatile b eiV;
    private int baz;
    private volatile ArrayList<a> eiW = new ArrayList<>(20);

    private b() {
    }

    public static b aXZ() {
        if (eiV == null) {
            synchronized (b.class) {
                if (eiV == null) {
                    eiV = new b();
                }
            }
        }
        return eiV;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.eiW.size() < 20) {
                this.eiW.add(aVar);
            } else {
                this.baz++;
            }
        }
    }

    public synchronized JSONObject aYa() {
        JSONObject jSONObject;
        int size = this.eiW.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.baz);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.eiW.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.eiW.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.eiW.clear();
        this.baz = 0;
    }
}
