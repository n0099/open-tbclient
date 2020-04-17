package com.baidu.ar.statistic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
final class a implements Cloneable {
    private static a ut;
    private static final Object us = new Object();
    private static int uu = 0;
    private static volatile boolean uv = false;
    private a ur = null;
    private JSONObject uq = new JSONObject();

    private a(String str) {
        as(str);
        setTimestamp(System.currentTimeMillis());
    }

    public static void a(a aVar) {
        if (uv) {
            return;
        }
        synchronized (us) {
            aVar.eA();
        }
    }

    public static void a(a... aVarArr) {
        if (uv) {
            return;
        }
        synchronized (us) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    aVar.eA();
                }
            }
        }
    }

    public static a ar(String str) {
        if (!uv) {
            synchronized (us) {
                if (ut != null) {
                    a aVar = ut;
                    ut = aVar.ur;
                    aVar.ur = null;
                    uu--;
                    if (aVar.uq == null) {
                        aVar.uq = new JSONObject();
                    }
                    aVar.as(str);
                    aVar.setTimestamp(System.currentTimeMillis());
                    return aVar;
                }
            }
        }
        return new a(str);
    }

    public static a ay(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str.trim());
            if (jSONObject != null) {
                a ar = ar(jSONObject.getString("event_id"));
                ar.uq = jSONObject;
                return ar;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String b(a aVar) {
        if (aVar == null || aVar.uq == null) {
            return null;
        }
        return aVar.uq.toString();
    }

    private void eA() {
        this.uq = null;
        if (uu < 500) {
            this.ur = ut;
            ut = this;
            uu++;
        }
    }

    public static void release() {
        if (uv) {
            return;
        }
        synchronized (us) {
            uv = true;
            ut = null;
            uu = 0;
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
            Iterator<String> keys = this.uq.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (collection == null || !collection.contains(next)) {
                    jSONObject.put(next, this.uq.get(next));
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
                this.uq.putOpt(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void as(String str) {
        try {
            this.uq.putOpt("event_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String at(String str) {
        return this.uq.optString(str);
    }

    public Object au(String str) {
        return this.uq.opt(str);
    }

    public long av(String str) {
        Object au = au(str);
        if (au instanceof Number) {
            return ((Number) au).longValue();
        }
        return 0L;
    }

    public boolean aw(String str) {
        return this.uq.has(str);
    }

    public void ax(String str) {
        this.uq.remove(str);
    }

    public void c(String str, Object obj) {
        try {
            this.uq.putOpt(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String eB() {
        return this.uq.optString("event_id");
    }

    public String eC() {
        String b = b(this);
        if (b == null) {
            return null;
        }
        return com.baidu.ar.f.j.aL(b);
    }

    public JSONObject eD() {
        return a(null, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: eE */
    public a clone() {
        a ar = ar("");
        try {
            ar.uq = new JSONObject(this.uq.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return ar;
    }

    public long getTimestamp() {
        return this.uq.optLong("time");
    }

    public Iterator<String> keys() {
        return this.uq.keys();
    }

    public void setTimestamp(long j) {
        try {
            this.uq.putOpt("time", Long.valueOf(j));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
