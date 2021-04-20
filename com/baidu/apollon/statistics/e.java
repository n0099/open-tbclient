package com.baidu.apollon.statistics;

import android.text.TextUtils;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3898a = "en";

    /* renamed from: b  reason: collision with root package name */
    public static final String f3899b = "et";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3900c = "ev";

    /* renamed from: d  reason: collision with root package name */
    public static final String f3901d = "eg";

    /* renamed from: e  reason: collision with root package name */
    public static final String f3902e = "lk";

    /* renamed from: f  reason: collision with root package name */
    public static final String f3903f = "nu";

    /* renamed from: g  reason: collision with root package name */
    public static final String f3904g = "at";

    /* renamed from: h  reason: collision with root package name */
    public String f3905h;
    public long i;
    public String j;
    public String k;
    public String l;
    public long m;
    public String n;

    public JSONObject a() throws NullPointerException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("en", this.f3905h);
            jSONObject.put("et", this.i);
            jSONObject.put("nu", this.m);
            if (!TextUtils.isEmpty(this.k)) {
                jSONObject.put("eg", this.k);
            }
            jSONObject.putOpt("lk", this.l);
            if (this.j != null) {
                jSONObject.put("ev", this.j);
            }
            if (!TextUtils.isEmpty(this.n)) {
                jSONObject.put("at", this.n);
            }
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            return jSONObject;
        }
        throw null;
    }

    public static e a(String str, long j, String str2, long j2, String str3, Collection<String> collection, String str4) {
        e eVar = new e();
        eVar.f3905h = str;
        eVar.i = j;
        eVar.k = str2;
        eVar.m = j2;
        eVar.l = str3;
        eVar.n = str4;
        if (collection != null) {
            new JSONArray();
            JSONArray jSONArray = new JSONArray();
            for (String str5 : collection) {
                jSONArray.put(str5);
            }
            eVar.j = jSONArray.toString();
        }
        return eVar;
    }
}
