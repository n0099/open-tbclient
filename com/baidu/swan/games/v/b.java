package com.baidu.swan.games.v;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private static volatile b dcw;
    private int aKi;
    private volatile ArrayList<a> dcx = new ArrayList<>(20);

    private b() {
    }

    public static b aBJ() {
        if (dcw == null) {
            synchronized (b.class) {
                if (dcw == null) {
                    dcw = new b();
                }
            }
        }
        return dcw;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.dcx.size() < 20) {
                this.dcx.add(aVar);
            } else {
                this.aKi++;
            }
        }
    }

    public synchronized JSONObject aBK() {
        JSONObject jSONObject;
        int size = this.dcx.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.aKi);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.dcx.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.dcx.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.dcx.clear();
        this.aKi = 0;
    }
}
