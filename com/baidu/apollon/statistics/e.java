package com.baidu.apollon.statistics;

import android.text.TextUtils;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3954a = "en";

    /* renamed from: b  reason: collision with root package name */
    public static final String f3955b = "et";

    /* renamed from: c  reason: collision with root package name */
    public static final String f3956c = "ev";

    /* renamed from: d  reason: collision with root package name */
    public static final String f3957d = "eg";

    /* renamed from: e  reason: collision with root package name */
    public static final String f3958e = "lk";

    /* renamed from: f  reason: collision with root package name */
    public static final String f3959f = "nu";

    /* renamed from: g  reason: collision with root package name */
    public static final String f3960g = "at";

    /* renamed from: h  reason: collision with root package name */
    public String f3961h;

    /* renamed from: i  reason: collision with root package name */
    public long f3962i;
    public String j;
    public String k;
    public String l;
    public long m;
    public String n;

    public JSONObject a() throws NullPointerException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("en", this.f3961h);
            jSONObject.put("et", this.f3962i);
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
        eVar.f3961h = str;
        eVar.f3962i = j;
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
