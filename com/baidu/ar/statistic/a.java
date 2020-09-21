package com.baidu.ar.statistic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
final class a implements Cloneable {
    private static a vx;
    private static final Object vw = new Object();
    private static int vy = 0;
    private static volatile boolean su = false;
    private a vv = null;
    private JSONObject vu = new JSONObject();

    private a(String str) {
        ax(str);
        setTimestamp(System.currentTimeMillis());
    }

    public static void a(a aVar) {
        if (su) {
            return;
        }
        synchronized (vw) {
            aVar.ge();
        }
    }

    public static void a(a... aVarArr) {
        if (su) {
            return;
        }
        synchronized (vw) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    aVar.ge();
                }
            }
        }
    }

    public static a aD(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str.trim());
            if (jSONObject != null) {
                a aw = aw(jSONObject.getString("event_id"));
                aw.vu = jSONObject;
                return aw;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static a aw(String str) {
        if (!su) {
            synchronized (vw) {
                if (vx != null) {
                    a aVar = vx;
                    vx = aVar.vv;
                    aVar.vv = null;
                    vy--;
                    if (aVar.vu == null) {
                        aVar.vu = new JSONObject();
                    }
                    aVar.ax(str);
                    aVar.setTimestamp(System.currentTimeMillis());
                    return aVar;
                }
            }
        }
        return new a(str);
    }

    public static String b(a aVar) {
        if (aVar == null || aVar.vu == null) {
            return null;
        }
        return aVar.vu.toString();
    }

    private void ge() {
        this.vu = null;
        if (vy < 500) {
            this.vv = vx;
            vx = this;
            vy++;
        }
    }

    public static void release() {
        if (su) {
            return;
        }
        synchronized (vw) {
            su = true;
            vx = null;
            vy = 0;
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
            Iterator<String> keys = this.vu.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (collection == null || !collection.contains(next)) {
                    jSONObject.put(next, this.vu.get(next));
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
                this.vu.putOpt(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public long aA(String str) {
        Object az = az(str);
        if (az instanceof Number) {
            return ((Number) az).longValue();
        }
        return 0L;
    }

    public boolean aB(String str) {
        return this.vu.has(str);
    }

    public void aC(String str) {
        this.vu.remove(str);
    }

    public void ax(String str) {
        try {
            this.vu.putOpt("event_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String ay(String str) {
        return this.vu.optString(str);
    }

    public Object az(String str) {
        return this.vu.opt(str);
    }

    public void c(String str, Object obj) {
        try {
            this.vu.putOpt(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public long getTimestamp() {
        return this.vu.optLong("time");
    }

    public String gf() {
        return this.vu.optString("event_id");
    }

    public String gg() {
        String b = b(this);
        if (b == null) {
            return null;
        }
        return com.baidu.ar.g.l.aQ(b);
    }

    public JSONObject gh() {
        return a(null, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: gi */
    public a clone() {
        a aw = aw("");
        try {
            aw.vu = new JSONObject(this.vu.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return aw;
    }

    public Iterator<String> keys() {
        return this.vu.keys();
    }

    public void setTimestamp(long j) {
        try {
            this.vu.putOpt("time", Long.valueOf(j));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
