package com.baidu.sofire.h;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.utility.g;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: g  reason: collision with root package name */
    public static a f10320g;

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f10321a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences.Editor f10322b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences f10323c;

    /* renamed from: d  reason: collision with root package name */
    public SharedPreferences.Editor f10324d;

    /* renamed from: e  reason: collision with root package name */
    public SharedPreferences f10325e;

    /* renamed from: f  reason: collision with root package name */
    public SharedPreferences.Editor f10326f;

    /* renamed from: h  reason: collision with root package name */
    public Context f10327h;

    /* renamed from: i  reason: collision with root package name */
    public int f10328i;
    public String j = null;
    public Map<String, SharedPreferences> k = new HashMap();

    public a(Context context) {
        this.f10327h = context;
        int a2 = com.baidu.sofire.utility.c.a(context);
        this.f10328i = a2;
        c cVar = new c(this.f10327h, a2 == 1 ? context.getSharedPreferences("leroadcfg", 0) : null, "leroadcfg", this.f10328i);
        this.f10321a = cVar;
        SharedPreferences.Editor edit = cVar.edit();
        this.f10322b = edit;
        this.f10323c = this.f10321a;
        this.f10324d = edit;
        c cVar2 = new c(this.f10327h, this.f10328i == 1 ? context.getSharedPreferences("re_po_rt", 0) : null, "re_po_rt", this.f10328i);
        this.f10325e = cVar2;
        this.f10326f = cVar2.edit();
    }

    public static synchronized a a(Context context) {
        synchronized (a.class) {
            if (context == null) {
                return f10320g;
            }
            if (f10320g == null) {
                f10320g = new a(context);
            }
            return f10320g;
        }
    }

    public final String A() {
        String string = this.f10321a.getString("p_s_s_c_t", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10)), "UTF-8");
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return "";
        }
    }

    public final String B() {
        String string = this.f10321a.getString("p_s_o_d_t", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10)), "UTF-8");
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return "";
        }
    }

    public final String C() {
        String string = this.f10321a.getString("p_s_s_o_t", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10)), "UTF-8");
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return "";
        }
    }

    public final String D() {
        String string = this.f10321a.getString("p_s_n_o_t", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10)), "UTF-8");
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return "";
        }
    }

    public final String E() {
        return this.f10323c.getString("xytk", "");
    }

    public final boolean b() {
        return this.f10321a.getBoolean("bka", true);
    }

    public final void c() {
        this.f10322b.putLong("pu_ap_fd", System.currentTimeMillis());
        this.f10322b.commit();
    }

    public final int d() {
        return this.f10321a.getInt("wi_fa_pu_ap", 0);
    }

    public final int e() {
        return this.f10321a.getInt("mo_fa_pu_ap", 0);
    }

    public final void f() {
        this.f10322b.putLong("pu_cl_fd", System.currentTimeMillis());
        this.f10322b.commit();
    }

    public final void g() {
        this.f10322b.putLong("se_ae_fd", System.currentTimeMillis());
        this.f10322b.commit();
    }

    public final int h() {
        return this.f10321a.getInt("wi_fa_pu_cl", 0);
    }

    public final int i() {
        return this.f10321a.getInt("mo_fa_pu_cl", 0);
    }

    public final int j() {
        return this.f10321a.getInt("mo_ae_fa_ct", 0);
    }

    public final String k() {
        return this.f10323c.getString("xyus", "");
    }

    public final String l() {
        return this.f10323c.getString("xyusec", "");
    }

    public final String m() {
        String string = this.f10323c.getString("xyglsn", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10)), "UTF-8");
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return "";
        }
    }

    public final String n() {
        String string = this.f10323c.getString("rpiiemn", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10)), "UTF-8");
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return "";
        }
    }

    public final String o() {
        String string = this.f10323c.getString("rpnewuidn", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10)), "UTF-8");
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return "";
        }
    }

    public final List<Integer> p() {
        String[] split;
        ArrayList arrayList = new ArrayList();
        String string = this.f10321a.getString("hcpk", "");
        if (!TextUtils.isEmpty(string) && (split = string.split("-")) != null && split.length > 0) {
            for (String str : split) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException e2) {
                    e2.getMessage();
                    com.baidu.sofire.b.b();
                }
            }
        }
        return arrayList;
    }

    public final List<Integer> q() {
        String[] split;
        ArrayList arrayList = new ArrayList();
        String string = this.f10321a.getString("glspk", "");
        if (!TextUtils.isEmpty(string) && (split = string.split("-")) != null && split.length > 0) {
            for (String str : split) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException e2) {
                    e2.getMessage();
                    com.baidu.sofire.b.b();
                }
            }
        }
        return arrayList;
    }

    public final int r() {
        return this.f10321a.getInt("sustfd", 0);
    }

    public final int s() {
        return this.f10321a.getInt("sufzfd", 0);
    }

    public final List<com.baidu.sofire.c.a> t() {
        String[] split;
        com.baidu.sofire.c.a a2;
        String string = this.f10325e.getString("re_con", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : string.split("\\|\\|")) {
            if (!TextUtils.isEmpty(str) && (a2 = com.baidu.sofire.c.a.a(str)) != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
        if (r0 < 24) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int u() {
        int i2 = 24;
        if ("com.baidu.BaiduMap.meizu".equals(this.f10327h.getPackageName())) {
            return this.f10325e.getInt("re_net_hr", 24);
        }
        int i3 = this.f10325e.getInt("re_net_hr", 3);
        try {
            String[] g2 = com.baidu.sofire.utility.c.g(this.f10327h);
            if (g2 != null && g2.length == 2 && !TextUtils.isEmpty(g2[0]) && !TextUtils.isEmpty(g2[1]) && "200080".equals(g2[0])) {
                if ("com.baidu.BaiduMap".equals(this.f10327h.getPackageName())) {
                }
            }
            i2 = i3;
            return i2;
        } catch (Throwable unused) {
            return i3;
        }
    }

    public final int v() {
        return this.f10325e.getInt("up_nu_li", 100);
    }

    public final boolean w() {
        return this.f10321a.getBoolean("s_c_c", true);
    }

    public final String x() {
        String string = this.f10321a.getString("p_s_i_t", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10)), "UTF-8");
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return "";
        }
    }

    public final String y() {
        String string = this.f10321a.getString("p_s_a_i_t", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10)), "UTF-8");
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return "";
        }
    }

    public final String z() {
        String string = this.f10321a.getString("p_s_e_c_t", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10)), "UTF-8");
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return "";
        }
    }

    public final void b(int i2) {
        this.f10322b.putInt("mo_fa_pu_ap", i2);
        this.f10322b.commit();
    }

    public final void d(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f10324d.putString("rpnewuidn", "");
            this.f10324d.commit();
            return;
        }
        try {
            this.f10324d.putString("rpnewuidn", new String(Base64.encode(g.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8"), true), 10), "UTF-8"));
            this.f10324d.commit();
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }

    public final void e(int i2) {
        this.f10322b.putInt("appal_te", i2);
        this.f10322b.commit();
    }

    public final void h(int i2) {
        this.f10326f.putInt("g_r_d_d_n", i2);
        this.f10326f.commit();
    }

    public final void i(long j) {
        this.f10322b.putLong("p_s_o_d_t_t", j);
        this.f10322b.commit();
    }

    public final void j(long j) {
        this.f10322b.putLong("p_s_s_o_t_t", j);
        this.f10322b.commit();
    }

    public final void k(long j) {
        this.f10322b.putLong("p_s_n_o_t_t", j);
        this.f10322b.commit();
    }

    public final void c(int i2) {
        this.f10322b.putInt("mo_ae_fa_ct", i2);
        this.f10322b.commit();
    }

    public final void f(int i2) {
        this.f10322b.putInt("sustfd", i2);
        this.f10322b.commit();
    }

    public final void g(int i2) {
        this.f10322b.putInt("sufzfd", i2);
        this.f10322b.commit();
    }

    public final void b(String str) {
        this.f10324d.putString("xyus", str);
        this.f10324d.commit();
    }

    public final String e(String str) {
        SharedPreferences sharedPreferences = this.f10325e;
        return sharedPreferences.getString("al_da" + str, "");
    }

    public final void h(long j) {
        this.f10322b.putLong("p_s_s_c_t_t", j);
        this.f10322b.commit();
    }

    public final Bundle a(Bundle bundle) {
        String string;
        SharedPreferences a2;
        try {
            string = bundle.getString(AppDownloadNetworkStateReceiver.KEY_OPERATION);
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        if ("querySharedHandler".equals(string)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("handle_platform", "sofire");
            return bundle2;
        }
        String string2 = bundle.getString("pref_name");
        if (TextUtils.isEmpty(string2)) {
            return null;
        }
        String string3 = bundle.getString("key");
        if (TextUtils.isEmpty(string3)) {
            return null;
        }
        if (string2.equals("leroadcfg")) {
            a2 = this.f10321a;
        } else if (string2.equals("leroadcfg")) {
            a2 = this.f10323c;
        } else if (string2.equals("re_po_rt")) {
            a2 = this.f10325e;
        } else {
            a2 = a(string2);
        }
        char c2 = 0;
        if (string.startsWith("get")) {
            String string4 = bundle.getString("defult_value");
            if (("getString".equals(string) || !TextUtils.isEmpty(string4)) && a2 != null) {
                Bundle bundle3 = new Bundle();
                switch (string.hashCode()) {
                    case -1249359687:
                        if (string.equals("getInt")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -75354382:
                        if (string.equals("getLong")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 804029191:
                        if (string.equals("getString")) {
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1101572082:
                        if (string.equals("getBoolean")) {
                            c2 = 4;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case 1953351846:
                        if (string.equals("getFloat")) {
                            c2 = 3;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
                if (c2 == 0) {
                    bundle3.putString("result", a2.getString(string3, string4));
                } else if (c2 == 1) {
                    bundle3.putInt("result", a2.getInt(string3, Integer.parseInt(string4)));
                } else if (c2 == 2) {
                    bundle3.putLong("result", a2.getLong(string3, Long.parseLong(string4)));
                } else if (c2 == 3) {
                    bundle3.putFloat("result", a2.getFloat(string3, Float.parseFloat(string4)));
                } else if (c2 == 4) {
                    bundle3.putBoolean("result", a2.getBoolean(string3, Boolean.parseBoolean(string4)));
                }
                return bundle3;
            }
            return null;
        }
        if (string.startsWith("put")) {
            SharedPreferences.Editor edit = a2.edit();
            switch (string.hashCode()) {
                case -976920992:
                    if (string.equals("putInt")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -462997504:
                    if (string.equals("putString")) {
                        break;
                    }
                    c2 = 65535;
                    break;
                case -219689429:
                    if (string.equals("putLong")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 478450201:
                    if (string.equals("putBoolean")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1773932685:
                    if (string.equals("putFloat")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 0) {
                edit.putString(string3, bundle.getString("value"));
            } else if (c2 == 1) {
                edit.putInt(string3, bundle.getInt("value"));
            } else if (c2 == 2) {
                edit.putLong(string3, bundle.getLong("value"));
            } else if (c2 == 3) {
                edit.putFloat(string3, bundle.getFloat("value"));
            } else if (c2 == 4) {
                edit.putBoolean(string3, bundle.getBoolean("value"));
            }
            edit.apply();
        }
        return null;
    }

    public final void c(String str) {
        this.f10324d.putString("xyusec", str);
        this.f10324d.commit();
    }

    public final void e(long j) {
        this.f10322b.putLong("p_s_i_t_t", j);
        this.f10322b.commit();
    }

    public final void f(long j) {
        this.f10322b.putLong("p_s_a_i_t_t", j);
        this.f10322b.commit();
    }

    public final void g(long j) {
        this.f10322b.putLong("p_s_e_c_t_t", j);
        this.f10322b.commit();
    }

    public final void b(long j) {
        this.f10326f.putLong("re_last_ofline_time", j);
        this.f10326f.commit();
    }

    public final void c(long j) {
        this.f10326f.putLong("re_day_len", j);
        this.f10326f.commit();
    }

    public final void b(boolean z) {
        this.f10322b.putBoolean("se_fg_s", z);
        this.f10322b.commit();
    }

    public final void c(boolean z) {
        this.f10322b.putBoolean("a_a_c_b", z);
        this.f10322b.commit();
    }

    public final void d(int i2) {
        this.f10322b.putInt("appal_daa", i2);
        this.f10322b.commit();
    }

    public final void d(long j) {
        this.f10326f.putLong("re_day_b_t", j);
        this.f10326f.commit();
    }

    public final SharedPreferences a(String str) {
        SharedPreferences sharedPreferences;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            synchronized (this.k) {
                sharedPreferences = this.k.get(str);
                if (sharedPreferences == null) {
                    c cVar = new c(this.f10327h, this.f10328i == 1 ? this.f10327h.getSharedPreferences(str, 0) : null, str, this.f10328i);
                    this.k.put(str, cVar);
                    sharedPreferences = cVar;
                }
            }
            return sharedPreferences;
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return null;
        }
    }

    public final String a() {
        return this.f10321a.getString("svi_n", "");
    }

    public final void a(int i2) {
        this.f10322b.putInt("wi_fa_pu_ap", i2);
        this.f10322b.commit();
    }

    public final void a(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                sb.append(iArr[i2]);
                if (i2 != iArr.length - 1) {
                    sb.append("-");
                }
            }
            this.f10322b.putString("hcpk", sb.toString());
        } else {
            this.f10322b.putString("hcpk", "");
        }
        this.f10322b.commit();
    }

    public final void a(List<Integer> list) {
        if (list.size() == 0) {
            this.f10322b.putString("glspk", "");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(list.get(i2));
                if (i2 != list.size() - 1) {
                    sb.append("-");
                }
            }
            this.f10322b.putString("glspk", sb.toString());
        }
        this.f10322b.commit();
    }

    public final void a(long j) {
        this.f10322b.putLong("slruct", j);
        this.f10322b.commit();
    }

    public final void a(int i2, int i3, int i4) {
        String str = i2 != 0 ? i2 != 1 ? "" : "suetfite" : "sustfits";
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor editor = this.f10322b;
        editor.putInt(str + i3, i4);
        this.f10322b.commit();
    }

    public final int a(int i2, int i3) {
        String str = i2 != 0 ? i2 != 1 ? "" : "suetfite" : "sustfits";
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        SharedPreferences sharedPreferences = this.f10321a;
        return sharedPreferences.getInt(str + i3, 0);
    }

    public final void a(com.baidu.sofire.c.a aVar) {
        String string = this.f10325e.getString("re_con", "");
        SharedPreferences.Editor editor = this.f10326f;
        editor.putString("re_con", string + "||" + com.baidu.sofire.c.a.a(aVar));
        this.f10326f.commit();
    }

    public final void a(boolean z) {
        this.f10322b.putBoolean("s_c_c", z);
        if (Build.VERSION.SDK_INT >= 9) {
            this.f10322b.apply();
        } else {
            this.f10322b.commit();
        }
    }
}
