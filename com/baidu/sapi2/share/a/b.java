package com.baidu.sapi2.share.a;

import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static final String a = "diu_ne";
    public static final String b = "face_check_result";
    public static final String c = "face_check_time";
    public static final String d = "eman_yalpsid";
    public static final String e = "last_time";
    public String f;
    public String g;
    public long h;
    public String i;
    public String j;
    public long k;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(a, this.f);
            jSONObject.put(b, this.g);
            jSONObject.put(c, this.h);
            jSONObject.put(d, this.i);
            jSONObject.put("cuid", this.j);
            jSONObject.put(e, this.k);
            return jSONObject;
        } catch (JSONException e2) {
            return null;
        }
    }

    public static b a(JSONObject jSONObject) {
        b bVar = new b();
        bVar.f = jSONObject.optString(a);
        bVar.g = jSONObject.optString(b);
        bVar.h = jSONObject.optLong(c);
        bVar.j = jSONObject.optString("cuid");
        bVar.i = jSONObject.optString(d);
        bVar.k = jSONObject.optLong(e);
        return bVar;
    }

    public int b() {
        try {
            return new JSONObject(this.g).optInt("errno");
        } catch (JSONException e2) {
            return -1;
        }
    }

    /* loaded from: classes.dex */
    public static class a implements Comparable<a> {
        public String a;
        public long b;

        public a(String str, long j) {
            this.a = str;
            this.b = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(a aVar) {
            if (aVar.b - this.b > 0) {
                return 1;
            }
            return aVar.b - this.b == 0 ? 0 : -1;
        }
    }
}
