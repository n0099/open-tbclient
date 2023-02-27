package com.baidu.ar.statistic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a implements Cloneable {
    public static volatile boolean sL;
    public static final Object wk = new Object();
    public static a wl;
    public static int wm;
    public a wj = null;
    public JSONObject wi = new JSONObject();

    public a(String str) {
        aA(str);
        setTimestamp(System.currentTimeMillis());
    }

    public static void a(a aVar) {
        if (sL) {
            return;
        }
        synchronized (wk) {
            aVar.ge();
        }
    }

    public static void a(a... aVarArr) {
        if (sL) {
            return;
        }
        synchronized (wk) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    aVar.ge();
                }
            }
        }
    }

    public static a aG(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(str.trim());
                a az = az(jSONObject.getString("event_id"));
                az.wi = jSONObject;
                return az;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static a az(String str) {
        if (!sL) {
            synchronized (wk) {
                if (wl != null) {
                    a aVar = wl;
                    wl = aVar.wj;
                    aVar.wj = null;
                    wm--;
                    if (aVar.wi == null) {
                        aVar.wi = new JSONObject();
                    }
                    aVar.aA(str);
                    aVar.setTimestamp(System.currentTimeMillis());
                    return aVar;
                }
            }
        }
        return new a(str);
    }

    public static String b(a aVar) {
        JSONObject jSONObject;
        if (aVar == null || (jSONObject = aVar.wi) == null) {
            return null;
        }
        return jSONObject.toString();
    }

    private void ge() {
        this.wi = null;
        int i = wm;
        if (i < 500) {
            this.wj = wl;
            wl = this;
            wm = i + 1;
        }
    }

    public static void release() {
        if (sL) {
            return;
        }
        synchronized (wk) {
            sL = true;
            wl = null;
            wm = 0;
        }
    }

    public JSONObject a(Collection<String> collection) {
        return a(null, collection);
    }

    public JSONObject a(JSONObject jSONObject, Collection<String> collection) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            Iterator<String> keys = this.wi.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (collection == null || !collection.contains(next)) {
                    jSONObject.put(next, this.wi.get(next));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.wi.putOpt(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void aA(String str) {
        try {
            this.wi.putOpt("event_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String aB(String str) {
        return this.wi.optString(str);
    }

    public Object aC(String str) {
        return this.wi.opt(str);
    }

    public long aD(String str) {
        Object aC = aC(str);
        if (aC instanceof Number) {
            return ((Number) aC).longValue();
        }
        return 0L;
    }

    public boolean aE(String str) {
        return this.wi.has(str);
    }

    public void aF(String str) {
        this.wi.remove(str);
    }

    public void b(String str, Object obj) {
        try {
            this.wi.putOpt(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public long getTimestamp() {
        return this.wi.optLong("time");
    }

    public String gf() {
        return this.wi.optString("event_id");
    }

    public String gg() {
        String b = b(this);
        if (b == null) {
            return null;
        }
        return com.baidu.ar.h.l.aT(b);
    }

    public JSONObject gh() {
        return a(null, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: gi */
    public a clone() {
        a az = az("");
        try {
            az.wi = new JSONObject(this.wi.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return az;
    }

    public Iterator<String> keys() {
        return this.wi.keys();
    }

    public void setTimestamp(long j) {
        try {
            this.wi.putOpt("time", Long.valueOf(j));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
