package com.baidu.swan.games.v;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private static volatile b dxa;
    private int aTy;
    private volatile ArrayList<a> dxb = new ArrayList<>(20);

    private b() {
    }

    public static b aPn() {
        if (dxa == null) {
            synchronized (b.class) {
                if (dxa == null) {
                    dxa = new b();
                }
            }
        }
        return dxa;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.dxb.size() < 20) {
                this.dxb.add(aVar);
            } else {
                this.aTy++;
            }
        }
    }

    public synchronized JSONObject aPo() {
        JSONObject jSONObject;
        int size = this.dxb.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.aTy);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.dxb.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.dxb.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.dxb.clear();
        this.aTy = 0;
    }
}
