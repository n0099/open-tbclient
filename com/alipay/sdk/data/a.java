package com.alipay.sdk.data;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.util.j;
import com.baidu.mobstat.Config;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int f1842a = 3500;

    /* renamed from: b  reason: collision with root package name */
    public static final String f1843b = "https://h5.m.taobao.com/mlapp/olist.html";

    /* renamed from: c  reason: collision with root package name */
    public static final int f1844c = 10;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f1845d = true;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f1846e = true;

    /* renamed from: f  reason: collision with root package name */
    public static final int f1847f = 1000;

    /* renamed from: g  reason: collision with root package name */
    public static final int f1848g = 20000;

    /* renamed from: h  reason: collision with root package name */
    public static final String f1849h = "alipay_cashier_dynamic_config";

    /* renamed from: i  reason: collision with root package name */
    public static final String f1850i = "timeout";
    public static final String j = "st_sdk_config";
    public static final String k = "tbreturl";
    public static final String l = "launchAppSwitch";
    public static final String m = "configQueryInterval";
    public static final String n = "scheme_pay";
    public static final String o = "scheme_pay_2";
    public static final String p = "intercept_batch";
    public static a x;
    public int r = 3500;
    public String s = f1843b;
    public int t = 10;
    public boolean u = true;
    public boolean v = true;
    public boolean q = false;
    public List<C0015a> w = null;

    public static a g() {
        if (x == null) {
            a aVar = new a();
            x = aVar;
            aVar.h();
        }
        return x;
    }

    private void h() {
        a(j.b(com.alipay.sdk.sys.b.a().b(), f1849h, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("timeout", a());
            jSONObject.put(k, d());
            jSONObject.put(m, e());
            jSONObject.put(l, C0015a.a(f()));
            jSONObject.put(o, b());
            jSONObject.put(p, c());
            j.a(com.alipay.sdk.sys.b.a().b(), f1849h, jSONObject.toString());
        } catch (Exception e2) {
            com.alipay.sdk.util.c.a(e2);
        }
    }

    public boolean b() {
        return this.u;
    }

    public boolean c() {
        return this.v;
    }

    public String d() {
        return this.s;
    }

    public int e() {
        return this.t;
    }

    public List<C0015a> f() {
        return this.w;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(j);
            if (optJSONObject != null) {
                this.r = optJSONObject.optInt("timeout", 3500);
                this.s = optJSONObject.optString(k, f1843b).trim();
                this.t = optJSONObject.optInt(m, 10);
                this.w = C0015a.a(optJSONObject.optJSONArray(l));
                this.u = optJSONObject.optBoolean(o, true);
                this.v = optJSONObject.optBoolean(p, true);
            } else {
                com.alipay.sdk.util.c.d(com.alipay.sdk.net.a.f1877a, "config is null");
            }
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }

    /* renamed from: com.alipay.sdk.data.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0015a {

        /* renamed from: a  reason: collision with root package name */
        public final String f1851a;

        /* renamed from: b  reason: collision with root package name */
        public final int f1852b;

        /* renamed from: c  reason: collision with root package name */
        public final String f1853c;

        public C0015a(String str, int i2, String str2) {
            this.f1851a = str;
            this.f1852b = i2;
            this.f1853c = str2;
        }

        public static C0015a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new C0015a(jSONObject.optString(Config.PACKAGE_NAME), jSONObject.optInt("v", 0), jSONObject.optString("pk"));
        }

        public String toString() {
            return String.valueOf(a(this));
        }

        public static List<C0015a> a(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                C0015a a2 = a(jSONArray.optJSONObject(i2));
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            return arrayList;
        }

        public static JSONObject a(C0015a c0015a) {
            if (c0015a == null) {
                return null;
            }
            try {
                return new JSONObject().put(Config.PACKAGE_NAME, c0015a.f1851a).put("v", c0015a.f1852b).put("pk", c0015a.f1853c);
            } catch (JSONException e2) {
                com.alipay.sdk.util.c.a(e2);
                return null;
            }
        }

        public static JSONArray a(List<C0015a> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (C0015a c0015a : list) {
                jSONArray.put(a(c0015a));
            }
            return jSONArray;
        }
    }

    public int a() {
        int i2 = this.r;
        if (i2 >= 1000 && i2 <= 20000) {
            com.alipay.sdk.util.c.b("", "DynamicConfig::getJumpTimeout >" + this.r);
            return this.r;
        }
        com.alipay.sdk.util.c.b("", "DynamicConfig::getJumpTimeout(default) >3500");
        return 3500;
    }

    public void a(boolean z) {
        this.q = z;
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.r = jSONObject.optInt("timeout", 3500);
            this.s = jSONObject.optString(k, f1843b).trim();
            this.t = jSONObject.optInt(m, 10);
            this.w = C0015a.a(jSONObject.optJSONArray(l));
            this.u = jSONObject.optBoolean(o, true);
            this.v = jSONObject.optBoolean(p, true);
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
        }
    }

    public void a(Context context) {
        new Thread(new b(this, context)).start();
    }
}
