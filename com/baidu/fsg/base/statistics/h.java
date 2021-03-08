package com.baidu.fsg.base.statistics;

import android.text.TextUtils;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1535a = "en";
    public static final String b = "et";
    public static final String c = "ev";
    public static final String d = "eg";
    public static final String e = "lk";
    public static final String f = "nu";
    public static final String g = "extra1";
    public static final String h = "extra2";
    public static final String i = "extra3";
    public static final String j = "extra4";
    public static final String k = "extra5";
    public static final String l = "extra6";
    public static final String m = "extra7";
    public static final String n = "extra8";
    public static final String o = "extra9";
    String p;
    long q;
    String r;
    String s;
    String t;
    long u;

    public JSONObject a() throws NullPointerException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f1535a, this.p);
            jSONObject.put("et", this.q);
            jSONObject.put(f, this.u);
            if (!TextUtils.isEmpty(this.s)) {
                jSONObject.putOpt(d, this.s);
            }
            jSONObject.putOpt(e, this.t);
            if (this.r != null) {
                jSONObject.put("ev", this.r);
            }
        } catch (JSONException e2) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            throw new NullPointerException();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h a(String str, long j2, String str2, String str3, Collection<String> collection) {
        h hVar = new h();
        hVar.p = str;
        hVar.q = j2;
        hVar.s = str2;
        hVar.t = str3;
        if (collection != null) {
            new JSONArray();
            JSONArray jSONArray = new JSONArray();
            for (String str4 : collection) {
                jSONArray.put(str4);
            }
            hVar.r = jSONArray.toString();
        }
        return hVar;
    }
}
