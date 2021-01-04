package com.baidu.swan.games.v;

import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    private static volatile b enJ;
    private int bfp;
    private volatile ArrayList<a> enK = new ArrayList<>(20);

    private b() {
    }

    public static b bbS() {
        if (enJ == null) {
            synchronized (b.class) {
                if (enJ == null) {
                    enJ = new b();
                }
            }
        }
        return enJ;
    }

    public synchronized void a(a aVar) {
        if (aVar != null) {
            if (this.enK.size() < 20) {
                this.enK.add(aVar);
            } else {
                this.bfp++;
            }
        }
    }

    public synchronized JSONObject bbT() {
        JSONObject jSONObject;
        int size = this.enK.size();
        if (size == 0) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("dropcnt", this.bfp);
                jSONObject2.put("errorcnt", size);
                JSONArray jSONArray = new JSONArray();
                jSONObject2.put("errors", jSONArray);
                Iterator<a> it = this.enK.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().toJSON());
                }
            } catch (JSONException e) {
            }
            this.enK.clear();
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public synchronized void clear() {
        this.enK.clear();
        this.bfp = 0;
    }
}
