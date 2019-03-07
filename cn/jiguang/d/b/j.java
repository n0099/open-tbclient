package cn.jiguang.d.b;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class j {
    private static j lJ = null;
    private static Pattern lK = Pattern.compile("(([0-1]?[0-9]{1,2}\\.)|(2[0-4][0-9]\\.)|(25[0-5]\\.)){3}(([0-1]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))");
    String f;
    String g;
    int h;
    String k;
    List<String> a = new ArrayList();
    List<String> b = new ArrayList();
    List<String> c = new ArrayList();
    List<String> d = new ArrayList();
    boolean e = false;
    List<String> i = new ArrayList();
    List<Integer> j = new ArrayList();
    boolean l = false;

    public static boolean c(String str) {
        return lK.matcher(str).matches();
    }

    public final String a() {
        return this.g;
    }

    public final void a(String str) {
        if (cn.jiguang.g.i.a(str)) {
            str = cn.jiguang.d.a.a.k();
        }
        if (cn.jiguang.g.i.a(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("ips");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.a.add(optJSONArray.optString(i));
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("ssl_ips");
            if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                return;
            }
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                this.b.add(optJSONArray2.optString(i2));
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("op_conns");
            if (optJSONArray3 != null) {
                optJSONArray3.length();
            }
            if (optJSONArray3 != null) {
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    this.c.add(optJSONArray3.optString(i3));
                }
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("sis_ips");
            if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                    this.d.add(optJSONArray4.optString(i4));
                }
            }
            this.e = jSONObject.optBoolean("data_report");
        } catch (Throwable th) {
        }
    }

    public final int b() {
        return this.h;
    }

    public final void b(String str) {
        this.k = str;
        if (this.a == null) {
            cn.jiguang.e.c.d("SisInfo", "Unexpected - Invalid sis - no ips key.");
            this.l = true;
        } else if (this.a.size() == 0) {
            cn.jiguang.e.c.d("SisInfo", "Unexpected - invalid sis - ips array len is 0");
            this.l = true;
        } else {
            try {
                k kVar = new k(this.a.get(0));
                this.g = kVar.a;
                this.h = kVar.b;
                if (this.c != null) {
                    for (String str2 : this.c) {
                        try {
                            k kVar2 = new k(str2);
                            this.i.add(kVar2.a);
                            this.j.add(Integer.valueOf(kVar2.b));
                        } catch (Exception e) {
                        }
                    }
                }
            } catch (Exception e2) {
                cn.jiguang.e.c.a("SisInfo", "Failed to parse ips-1 - main ip.", e2);
                this.l = true;
            }
        }
    }

    public final List<String> c() {
        return this.i;
    }

    public final List<Integer> d() {
        return this.j;
    }

    public final boolean e() {
        return this.l;
    }

    public final List<String> f() {
        return this.d;
    }

    public final boolean g() {
        return this.e;
    }

    public final void h() {
        int size = this.a.size();
        if (size == 0) {
            return;
        }
        cn.jiguang.d.a.a.c(this.k);
        if (size > 1) {
            try {
                k kVar = new k(this.a.get(1));
                cn.jiguang.d.a.a.d(kVar.a, kVar.b);
            } catch (Exception e) {
                cn.jiguang.e.c.a("SisInfo", "Failed to parse ips-2 - default ip.", e);
            }
        } else {
            cn.jiguang.e.c.c("SisInfo", "Only main ip in sis.");
        }
        if (this.b.size() > 2) {
            cn.jiguang.d.a.d.a(this.b.get(2));
        } else {
            cn.jiguang.e.c.c("SisInfo", "No report backup ip.");
        }
        if (this.f != null) {
            cn.jiguang.d.a.a.b(this.f);
        }
    }
}
