package com.baidu.swan.games.v;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b {
    private static volatile b dwW;
    private int aTw;
    private volatile ArrayList<a> dwX = new ArrayList<>(20);

    private b() {
    }

    public static b aPn() {
        if (dwW == null) {
            synchronized (b.class) {
                if (dwW == null) {
                    dwW = new b();
                }
            }
        }
        return dwW;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.dwX.size() < 20) {
                this.dwX.add(aVar);
            } else {
                this.aTw++;
            }
        }
    }

    public synchronized JSONObject aPo() {
        JSONObject jSONObject;
        int size = this.dwX.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.aTw);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.dwX.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.dwX.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.dwX.clear();
        this.aTw = 0;
    }
}
