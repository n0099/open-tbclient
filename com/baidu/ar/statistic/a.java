package com.baidu.ar.statistic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
final class a implements Cloneable {
    private static a uT;
    private static final Object uS = new Object();
    private static int uU = 0;
    private static volatile boolean uV = false;
    private a uR = null;
    private JSONObject uQ = new JSONObject();

    private a(String str) {
        at(str);
        setTimestamp(System.currentTimeMillis());
    }

    public static void a(a aVar) {
        if (uV) {
            return;
        }
        synchronized (uS) {
            aVar.eQ();
        }
    }

    public static void a(a... aVarArr) {
        if (uV) {
            return;
        }
        synchronized (uS) {
            if (aVarArr != null) {
                for (a aVar : aVarArr) {
                    aVar.eQ();
                }
            }
        }
    }

    public static a as(String str) {
        if (!uV) {
            synchronized (uS) {
                if (uT != null) {
                    a aVar = uT;
                    uT = aVar.uR;
                    aVar.uR = null;
                    uU--;
                    if (aVar.uQ == null) {
                        aVar.uQ = new JSONObject();
                    }
                    aVar.at(str);
                    aVar.setTimestamp(System.currentTimeMillis());
                    return aVar;
                }
            }
        }
        return new a(str);
    }

    public static a az(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str.trim());
            if (jSONObject != null) {
                a as = as(jSONObject.getString("event_id"));
                as.uQ = jSONObject;
                return as;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String b(a aVar) {
        if (aVar == null || aVar.uQ == null) {
            return null;
        }
        return aVar.uQ.toString();
    }

    private void eQ() {
        this.uQ = null;
        if (uU < 500) {
            this.uR = uT;
            uT = this;
            uU++;
        }
    }

    public static void release() {
        if (uV) {
            return;
        }
        synchronized (uS) {
            uV = true;
            uT = null;
            uU = 0;
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
            Iterator<String> keys = this.uQ.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (collection == null || !collection.contains(next)) {
                    jSONObject.put(next, this.uQ.get(next));
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
                this.uQ.putOpt(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void at(String str) {
        try {
            this.uQ.putOpt("event_id", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String au(String str) {
        return this.uQ.optString(str);
    }

    public Object av(String str) {
        return this.uQ.opt(str);
    }

    public long aw(String str) {
        Object av = av(str);
        if (av instanceof Number) {
            return ((Number) av).longValue();
        }
        return 0L;
    }

    public boolean ax(String str) {
        return this.uQ.has(str);
    }

    public void ay(String str) {
        this.uQ.remove(str);
    }

    public void c(String str, Object obj) {
        try {
            this.uQ.putOpt(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String eR() {
        return this.uQ.optString("event_id");
    }

    public String eS() {
        String b = b(this);
        if (b == null) {
            return null;
        }
        return com.baidu.ar.f.j.aM(b);
    }

    public JSONObject eT() {
        return a(null, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: eU */
    public a clone() {
        a as = as("");
        try {
            as.uQ = new JSONObject(this.uQ.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return as;
    }

    public long getTimestamp() {
        return this.uQ.optLong("time");
    }

    public Iterator<String> keys() {
        return this.uQ.keys();
    }

    public void setTimestamp(long j) {
        try {
            this.uQ.putOpt("time", Long.valueOf(j));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
