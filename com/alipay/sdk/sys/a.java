package com.alipay.sdk.sys;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.alipay.sdk.util.c;
import com.alipay.sdk.util.n;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1912a = "\"&";

    /* renamed from: b  reason: collision with root package name */
    public static final String f1913b = "&";

    /* renamed from: c  reason: collision with root package name */
    public static final String f1914c = "bizcontext=\"";

    /* renamed from: d  reason: collision with root package name */
    public static final String f1915d = "bizcontext=";

    /* renamed from: e  reason: collision with root package name */
    public static final String f1916e = "\"";

    /* renamed from: f  reason: collision with root package name */
    public static final String f1917f = "appkey";

    /* renamed from: g  reason: collision with root package name */
    public static final String f1918g = "ty";

    /* renamed from: h  reason: collision with root package name */
    public static final String f1919h = "sv";

    /* renamed from: i  reason: collision with root package name */
    public static final String f1920i = "an";
    public static final String j = "setting";
    public static final String k = "av";
    public static final String l = "sdk_start_time";
    public static final String m = "UTF-8";
    public String n;
    public String o;
    public Context p;

    public a(Context context) {
        this.n = "";
        this.o = "";
        this.p = null;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.n = packageInfo.versionName;
            this.o = packageInfo.packageName;
            this.p = context.getApplicationContext();
        } catch (Exception unused) {
        }
    }

    private boolean b(String str) {
        return !str.contains(f1912a);
    }

    private String c(String str) {
        try {
            String a2 = a(str, "&", f1915d);
            if (TextUtils.isEmpty(a2)) {
                str = str + "&" + b(f1915d, "");
            } else {
                int indexOf = str.indexOf(a2);
                str = str.substring(0, indexOf) + a(a2, f1915d, "", true) + str.substring(indexOf + a2.length());
            }
        } catch (Throwable unused) {
        }
        return str;
    }

    private String d(String str) {
        try {
            String a2 = a(str, f1912a, f1914c);
            if (TextUtils.isEmpty(a2)) {
                return str + "&" + b(f1914c, "\"");
            }
            if (!a2.endsWith("\"")) {
                a2 = a2 + "\"";
            }
            int indexOf = str.indexOf(a2);
            return str.substring(0, indexOf) + a(a2, f1914c, "\"", false) + str.substring(indexOf + a2.length());
        } catch (Throwable unused) {
            return str;
        }
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("new_external_info==")) {
            return str;
        }
        if (b(str)) {
            return c(str);
        }
        return d(str);
    }

    private String b(String str, String str2) throws JSONException, UnsupportedEncodingException {
        String a2 = a("", "");
        return str + a2 + str2;
    }

    private String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(str2);
        for (int i2 = 0; i2 < split.length; i2++) {
            if (!TextUtils.isEmpty(split[i2]) && split[i2].startsWith(str3)) {
                return split[i2];
            }
        }
        return null;
    }

    public String a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", com.alipay.sdk.cons.a.f1818d);
            jSONObject.put("ty", "and_lite");
            jSONObject.put("sv", "h.a.3.6.5");
            if (!this.o.contains(j) || !n.b(this.p)) {
                jSONObject.put(f1920i, this.o);
            }
            jSONObject.put(k, this.n);
            jSONObject.put(l, System.currentTimeMillis());
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(str, str2);
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            c.a(th);
            return "";
        }
    }

    private String a(String str, String str2, String str3, boolean z) throws JSONException, UnsupportedEncodingException {
        JSONObject jSONObject;
        String substring = str.substring(str2.length());
        boolean z2 = false;
        String substring2 = substring.substring(0, substring.length() - str3.length());
        if (substring2.length() >= 2 && substring2.startsWith("\"") && substring2.endsWith("\"")) {
            jSONObject = new JSONObject(substring2.substring(1, substring2.length() - 1));
            z2 = true;
        } else {
            jSONObject = new JSONObject(substring2);
        }
        if (!jSONObject.has("appkey")) {
            jSONObject.put("appkey", com.alipay.sdk.cons.a.f1818d);
        }
        if (!jSONObject.has("ty")) {
            jSONObject.put("ty", "and_lite");
        }
        if (!jSONObject.has("sv")) {
            jSONObject.put("sv", "h.a.3.6.5");
        }
        if (!jSONObject.has(f1920i) && (!this.o.contains(j) || !n.b(this.p))) {
            jSONObject.put(f1920i, this.o);
        }
        if (!jSONObject.has(k)) {
            jSONObject.put(k, this.n);
        }
        if (!jSONObject.has(l)) {
            jSONObject.put(l, System.currentTimeMillis());
        }
        String jSONObject2 = jSONObject.toString();
        if (z2) {
            jSONObject2 = "\"" + jSONObject2 + "\"";
        }
        return str2 + jSONObject2 + str3;
    }
}
