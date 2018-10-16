package com.baidu.fsg.face.base.b;

import com.baidu.android.common.logging.Log;
import com.baidu.fsg.face.base.b.b;
import com.baidu.fsg.face.base.d.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class c {
    public static final String a = "SdkConfigOptions";
    public static final String b = "global-config";
    public static final String c = "host_version";
    public static final String d = "zip_version";
    public static final String e = "updateFail";
    public static final String f = "distributedSdk";
    public static final String g = "files";
    public static final String h = "list";
    public static final String i = "cpu";
    public static final String j = "extra_params";
    public static final String k = "extra_global_enable";
    public static final String l = "enable";
    public static final String m = "gray";
    public String n;
    public a o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
        r1.o = com.baidu.fsg.face.base.b.c.a.a(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c a(JSONObject jSONObject, b.a aVar) {
        JSONArray jSONArray;
        c cVar = new c();
        cVar.q = jSONObject.optBoolean(k, true);
        try {
            cVar.n = jSONObject.optString(d);
            cVar.r = jSONObject.optBoolean(l, true);
            cVar.s = jSONObject.optInt(m);
            jSONArray = jSONObject.getJSONArray("list");
        } catch (JSONException e2) {
            Log.e(a, e2);
        }
        if (jSONArray == null) {
            return cVar;
        }
        String e3 = h.e();
        if (h.a.equals(e3)) {
            e3 = h.b;
        }
        int i2 = 0;
        while (true) {
            if (i2 < jSONArray.length()) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                if (jSONObject2 != null && e3.equals(jSONObject2.optString("cpu"))) {
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return cVar;
    }

    public static c a(JSONObject jSONObject) {
        c cVar = new c();
        cVar.n = jSONObject.optString(d);
        cVar.p = jSONObject.optBoolean(e);
        cVar.q = jSONObject.optBoolean(k);
        cVar.r = jSONObject.optBoolean(l);
        cVar.s = jSONObject.optInt(m);
        cVar.o = a.a(jSONObject.optJSONObject(f));
        return cVar;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(d, this.n);
            jSONObject.put(e, this.p);
            jSONObject.put(k, this.q);
            jSONObject.put(l, this.r);
            jSONObject.put(m, this.s);
            jSONObject.put(f, this.o == null ? "" : this.o.a());
            return jSONObject;
        } catch (JSONException e2) {
            return null;
        }
    }

    /* loaded from: classes6.dex */
    public static class a {
        private static final String d = "name";
        private static final String e = "url";
        private static final String f = "hash";
        public String a = null;
        public String b = null;
        public String c = null;

        public static a a(JSONObject jSONObject) {
            a aVar = new a();
            if (jSONObject != null) {
                aVar.a = jSONObject.optString("name");
                aVar.b = jSONObject.optString("url");
                aVar.c = jSONObject.optString(f);
            }
            return aVar;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.a);
                jSONObject.put("url", this.b);
                jSONObject.put(f, this.c);
                return jSONObject;
            } catch (JSONException e2) {
                com.baidu.fsg.face.base.d.d.a(e2);
                return null;
            }
        }
    }
}
