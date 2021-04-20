package com.baidu.fsg.face.base.b;

import com.baidu.android.common.logging.Log;
import com.baidu.fsg.face.base.b.b;
import com.baidu.fsg.face.base.d.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5586a = "SdkConfigOptions";

    /* renamed from: b  reason: collision with root package name */
    public static final String f5587b = "global-config";

    /* renamed from: c  reason: collision with root package name */
    public static final String f5588c = "host_version";

    /* renamed from: d  reason: collision with root package name */
    public static final String f5589d = "zip_version";

    /* renamed from: e  reason: collision with root package name */
    public static final String f5590e = "updateFail";

    /* renamed from: f  reason: collision with root package name */
    public static final String f5591f = "distributedSdk";

    /* renamed from: g  reason: collision with root package name */
    public static final String f5592g = "files";

    /* renamed from: h  reason: collision with root package name */
    public static final String f5593h = "list";
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

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0057, code lost:
        r5.o = com.baidu.fsg.face.base.b.c.a.a(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c a(JSONObject jSONObject, b.a aVar) {
        JSONArray jSONArray;
        c cVar = new c();
        cVar.q = jSONObject.optBoolean(k, true);
        try {
            cVar.n = jSONObject.optString(f5589d);
            cVar.r = jSONObject.optBoolean(l, true);
            cVar.s = jSONObject.optInt("gray");
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

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public static final String f5594d = "name";

        /* renamed from: e  reason: collision with root package name */
        public static final String f5595e = "url";

        /* renamed from: f  reason: collision with root package name */
        public static final String f5596f = "hash";

        /* renamed from: a  reason: collision with root package name */
        public String f5597a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f5598b = null;

        /* renamed from: c  reason: collision with root package name */
        public String f5599c = null;

        public static a a(JSONObject jSONObject) {
            a aVar = new a();
            if (jSONObject == null) {
                return aVar;
            }
            aVar.f5597a = jSONObject.optString("name");
            aVar.f5598b = jSONObject.optString("url");
            aVar.f5599c = jSONObject.optString("hash");
            return aVar;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.f5597a);
                jSONObject.put("url", this.f5598b);
                jSONObject.put("hash", this.f5599c);
                return jSONObject;
            } catch (JSONException e2) {
                com.baidu.fsg.face.base.d.d.a(e2);
                return null;
            }
        }
    }

    public static c a(JSONObject jSONObject) {
        c cVar = new c();
        cVar.n = jSONObject.optString(f5589d);
        cVar.p = jSONObject.optBoolean(f5590e);
        cVar.q = jSONObject.optBoolean(k);
        cVar.r = jSONObject.optBoolean(l);
        cVar.s = jSONObject.optInt("gray");
        cVar.o = a.a(jSONObject.optJSONObject(f5591f));
        return cVar;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f5589d, this.n);
            jSONObject.put(f5590e, this.p);
            jSONObject.put(k, this.q);
            jSONObject.put(l, this.r);
            jSONObject.put("gray", this.s);
            jSONObject.put(f5591f, this.o == null ? "" : this.o.a());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
