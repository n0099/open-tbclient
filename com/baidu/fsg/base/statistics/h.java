package com.baidu.fsg.base.statistics;

import android.text.TextUtils;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5298a = "en";

    /* renamed from: b  reason: collision with root package name */
    public static final String f5299b = "et";

    /* renamed from: c  reason: collision with root package name */
    public static final String f5300c = "ev";

    /* renamed from: d  reason: collision with root package name */
    public static final String f5301d = "eg";

    /* renamed from: e  reason: collision with root package name */
    public static final String f5302e = "lk";

    /* renamed from: f  reason: collision with root package name */
    public static final String f5303f = "nu";

    /* renamed from: g  reason: collision with root package name */
    public static final String f5304g = "extra1";

    /* renamed from: h  reason: collision with root package name */
    public static final String f5305h = "extra2";
    public static final String i = "extra3";
    public static final String j = "extra4";
    public static final String k = "extra5";
    public static final String l = "extra6";
    public static final String m = "extra7";
    public static final String n = "extra8";
    public static final String o = "extra9";
    public String p;
    public long q;
    public String r;
    public String s;
    public String t;
    public long u;

    public JSONObject a() throws NullPointerException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("en", this.p);
            jSONObject.put("et", this.q);
            jSONObject.put("nu", this.u);
            if (!TextUtils.isEmpty(this.s)) {
                jSONObject.putOpt("eg", this.s);
            }
            jSONObject.putOpt("lk", this.t);
            if (this.r != null) {
                jSONObject.put("ev", this.r);
            }
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return jSONObject;
        }
        throw null;
    }

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
