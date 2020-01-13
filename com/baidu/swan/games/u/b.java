package com.baidu.swan.games.u;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private static volatile b col;
    private int ajR;

    /* renamed from: com  reason: collision with root package name */
    private volatile ArrayList<a> f971com = new ArrayList<>(20);

    private b() {
    }

    public static b ann() {
        if (col == null) {
            synchronized (b.class) {
                if (col == null) {
                    col = new b();
                }
            }
        }
        return col;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.f971com.size() < 20) {
                this.f971com.add(aVar);
            } else {
                this.ajR++;
            }
        }
    }

    public synchronized JSONObject ano() {
        JSONObject jSONObject;
        int size = this.f971com.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.ajR);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.f971com.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.f971com.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.f971com.clear();
        this.ajR = 0;
    }
}
