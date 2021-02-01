package com.baidu.fsg.face.base.b;

import com.baidu.android.common.logging.Log;
import com.baidu.fsg.face.base.b.b;
import com.baidu.fsg.face.base.d.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2062a = "SdkConfigOptions";

    /* renamed from: b  reason: collision with root package name */
    public static final String f2063b = "global-config";
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
            cVar.n = jSONObject.optString("zip_version");
            cVar.r = jSONObject.optBoolean(l, true);
            cVar.s = jSONObject.optInt(m);
            jSONArray = jSONObject.getJSONArray("list");
        } catch (JSONException e2) {
            Log.e("SdkConfigOptions", e2);
        }
        if (jSONArray == null) {
            return cVar;
        }
        String e3 = h.e();
        if ("armeabi".equals(e3)) {
            e3 = "armeabi-v7a";
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
        cVar.n = jSONObject.optString("zip_version");
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
            jSONObject.put("zip_version", this.n);
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

    /* loaded from: classes5.dex */
    public static class a {
        private static final String d = "name";
        private static final String e = "url";
        private static final String f = "hash";

        /* renamed from: a  reason: collision with root package name */
        public String f2064a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f2065b = null;
        public String c = null;

        public static a a(JSONObject jSONObject) {
            a aVar = new a();
            if (jSONObject != null) {
                aVar.f2064a = jSONObject.optString("name");
                aVar.f2065b = jSONObject.optString("url");
                aVar.c = jSONObject.optString(f);
            }
            return aVar;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.f2064a);
                jSONObject.put("url", this.f2065b);
                jSONObject.put(f, this.c);
                return jSONObject;
            } catch (JSONException e2) {
                com.baidu.fsg.face.base.d.d.a(e2);
                return null;
            }
        }
    }
}
