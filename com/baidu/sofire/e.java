package com.baidu.sofire;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f10288a;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f10289b;

    /* renamed from: c  reason: collision with root package name */
    public SharedPreferences.Editor f10290c;

    /* renamed from: d  reason: collision with root package name */
    public SharedPreferences.Editor f10291d;

    /* renamed from: e  reason: collision with root package name */
    public SharedPreferences f10292e;

    /* renamed from: f  reason: collision with root package name */
    public SharedPreferences.Editor f10293f;

    /* renamed from: g  reason: collision with root package name */
    public Context f10294g;

    public e(Context context) {
        try {
            this.f10294g = context;
            SharedPreferences sharedPreferences = context.getSharedPreferences("leroadcfg", 4);
            this.f10288a = sharedPreferences;
            this.f10290c = sharedPreferences.edit();
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("leroadcfg", 4);
            this.f10289b = sharedPreferences2;
            this.f10291d = sharedPreferences2.edit();
            SharedPreferences sharedPreferences3 = context.getSharedPreferences("re_po_rt", 4);
            this.f10292e = sharedPreferences3;
            this.f10293f = sharedPreferences3.edit();
        } catch (Throwable th) {
            th.getMessage();
            b.c();
        }
    }

    public final String A() {
        String string = this.f10288a.getString("p_s_a_i_t", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(com.baidu.sofire.g.a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10), true), "UTF-8");
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return "";
        }
    }

    public final String B() {
        String string = this.f10288a.getString("p_s_e_c_t", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(com.baidu.sofire.g.a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10), true), "UTF-8");
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return "";
        }
    }

    public final String C() {
        String string = this.f10288a.getString("p_s_s_c_t", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(com.baidu.sofire.g.a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10), true), "UTF-8");
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return "";
        }
    }

    public final String D() {
        String string = this.f10288a.getString("p_s_o_d_t", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(com.baidu.sofire.g.a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10), true), "UTF-8");
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return "";
        }
    }

    public final String E() {
        String string = this.f10288a.getString("p_s_s_o_t", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(com.baidu.sofire.g.a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10), true), "UTF-8");
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return "";
        }
    }

    public final String F() {
        String string = this.f10288a.getString("p_s_n_o_t", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(com.baidu.sofire.g.a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10), true), "UTF-8");
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return "";
        }
    }

    public final boolean a() {
        return this.f10288a.getBoolean("iio", false);
    }

    public final String b() {
        return this.f10288a.getString("svi_n", "");
    }

    public final boolean c() {
        return this.f10288a.getBoolean("bka", true);
    }

    public final void d() {
        this.f10290c.putLong("pu_ap_fd", System.currentTimeMillis());
        this.f10290c.commit();
    }

    public final int e() {
        return this.f10288a.getInt("wi_fa_pu_ap", 0);
    }

    public final int f() {
        return this.f10288a.getInt("mo_fa_pu_ap", 0);
    }

    public final void g() {
        this.f10290c.putLong("pu_cl_fd", System.currentTimeMillis());
        this.f10290c.commit();
    }

    public final void h() {
        this.f10290c.putLong("se_ae_fd", System.currentTimeMillis());
        this.f10290c.commit();
    }

    public final int i() {
        return this.f10288a.getInt("wi_fa_pu_cl", 0);
    }

    public final int j() {
        return this.f10288a.getInt("mo_fa_pu_cl", 0);
    }

    public final int k() {
        return this.f10288a.getInt("mo_ae_fa_ct", 0);
    }

    public final String l() {
        return this.f10289b.getString("xyus", "");
    }

    public final String m() {
        return this.f10289b.getString("xyusec", "");
    }

    public final String n() {
        String string = this.f10289b.getString("xyglsn", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(com.baidu.sofire.g.a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10), true), "UTF-8");
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return "";
        }
    }

    public final String o() {
        String string = this.f10289b.getString("rpiiemn", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(com.baidu.sofire.g.a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10), true), "UTF-8");
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return "";
        }
    }

    public final String p() {
        String string = this.f10289b.getString("rpnewuidn", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(com.baidu.sofire.g.a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10), true), "UTF-8");
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return "";
        }
    }

    public final List<Integer> q() {
        String[] split;
        ArrayList arrayList = new ArrayList();
        String string = this.f10288a.getString("hcpk", "");
        if (!TextUtils.isEmpty(string) && (split = string.split("-")) != null && split.length > 0) {
            for (String str : split) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException e2) {
                    e2.getMessage();
                    b.c();
                }
            }
        }
        return arrayList;
    }

    public final List<Integer> r() {
        String[] split;
        ArrayList arrayList = new ArrayList();
        String string = this.f10288a.getString("glspk", "");
        if (!TextUtils.isEmpty(string) && (split = string.split("-")) != null && split.length > 0) {
            for (String str : split) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException e2) {
                    e2.getMessage();
                    b.c();
                }
            }
        }
        return arrayList;
    }

    public final int s() {
        return this.f10288a.getInt("appal_te", 24);
    }

    public final int t() {
        return this.f10288a.getInt("sustfd", 0);
    }

    public final int u() {
        return this.f10288a.getInt("sufzfd", 0);
    }

    public final List<com.baidu.sofire.b.a> v() {
        String[] split;
        com.baidu.sofire.b.a a2;
        String string = this.f10292e.getString("re_con", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : string.split("\\|\\|")) {
            if (!TextUtils.isEmpty(str) && (a2 = com.baidu.sofire.b.a.a(str)) != null) {
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
    public final int w() {
        int i2 = 24;
        if ("com.baidu.BaiduMap.meizu".equals(this.f10294g.getPackageName())) {
            return this.f10292e.getInt("re_net_hr", 24);
        }
        int i3 = this.f10292e.getInt("re_net_hr", 3);
        try {
            String[] h2 = com.baidu.sofire.g.d.h(this.f10294g);
            if (h2 != null && h2.length == 2 && !TextUtils.isEmpty(h2[0]) && !TextUtils.isEmpty(h2[1]) && "200080".equals(h2[0])) {
                if ("com.baidu.BaiduMap".equals(this.f10294g.getPackageName())) {
                }
            }
            i2 = i3;
            return i2;
        } catch (Throwable unused) {
            return i3;
        }
    }

    public final int x() {
        return this.f10292e.getInt("up_nu_li", 100);
    }

    public final boolean y() {
        return this.f10288a.getBoolean("s_c_c", true);
    }

    public final String z() {
        String string = this.f10288a.getString("p_s_i_t", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            return new String(com.baidu.sofire.g.a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10), true), "UTF-8");
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return "";
        }
    }

    public final void a(int i2) {
        this.f10290c.putInt("wi_fa_pu_ap", i2);
        this.f10290c.commit();
    }

    public final void b(int i2) {
        this.f10290c.putInt("mo_fa_pu_ap", i2);
        this.f10290c.commit();
    }

    public final void c(int i2) {
        this.f10290c.putInt("mo_ae_fa_ct", i2);
        this.f10290c.commit();
    }

    public final void e(int i2) {
        this.f10290c.putInt("appal_te", i2);
        this.f10290c.commit();
    }

    public final void f(int i2) {
        this.f10290c.putInt("sustfd", i2);
        this.f10290c.commit();
    }

    public final void d(int i2) {
        this.f10290c.putInt("appal_daa", i2);
        this.f10290c.commit();
    }

    public final void g(int i2) {
        this.f10290c.putInt("sufzfd", i2);
        this.f10290c.commit();
    }

    public final void h(int i2) {
        this.f10293f.putInt("g_r_d_d_n", i2);
        this.f10293f.commit();
    }

    public final void a(String str) {
        this.f10291d.putString("xyus", str);
        this.f10291d.commit();
    }

    public final void b(String str) {
        this.f10291d.putString("xyusec", str);
        this.f10291d.commit();
    }

    public final void c(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f10291d.putString("rpnewuidn", "");
            this.f10291d.commit();
            return;
        }
        try {
            this.f10291d.putString("rpnewuidn", new String(Base64.encode(com.baidu.sofire.g.a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes("UTF-8")), 10), "UTF-8"));
            this.f10291d.commit();
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
    }

    public final void d(long j) {
        this.f10293f.putLong("re_day_b_t", j);
        this.f10293f.commit();
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
            this.f10290c.putString("hcpk", sb.toString());
        } else {
            this.f10290c.putString("hcpk", "");
        }
        this.f10290c.commit();
    }

    public final void b(long j) {
        this.f10293f.putLong("re_last_ofline_time", j);
        this.f10293f.commit();
    }

    public final String d(String str) {
        SharedPreferences sharedPreferences = this.f10292e;
        return sharedPreferences.getString("al_da" + str, "");
    }

    public final void b(boolean z) {
        this.f10290c.putBoolean("se_fg_s", z);
        this.f10290c.commit();
    }

    public final void c(long j) {
        this.f10293f.putLong("re_day_len", j);
        this.f10293f.commit();
    }

    public final void a(List<Integer> list) {
        if (list.size() == 0) {
            this.f10290c.putString("glspk", "");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(list.get(i2));
                if (i2 != list.size() - 1) {
                    sb.append("-");
                }
            }
            this.f10290c.putString("glspk", sb.toString());
        }
        this.f10290c.commit();
    }

    public final void c(boolean z) {
        this.f10290c.putBoolean("a_a_c_b", z);
        this.f10290c.commit();
    }

    public final void a(long j) {
        this.f10290c.putLong("slruct", j);
        this.f10290c.commit();
    }

    public final void a(int i2, int i3, int i4) {
        String str = i2 != 0 ? i2 != 1 ? "" : "suetfite" : "sustfits";
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor editor = this.f10290c;
        editor.putInt(str + i3, i4);
        this.f10290c.commit();
    }

    public final int a(int i2, int i3) {
        String str = i2 != 0 ? i2 != 1 ? "" : "suetfite" : "sustfits";
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        SharedPreferences sharedPreferences = this.f10288a;
        return sharedPreferences.getInt(str + i3, 0);
    }

    public final void a(com.baidu.sofire.b.a aVar) {
        String string = this.f10292e.getString("re_con", "");
        SharedPreferences.Editor editor = this.f10293f;
        editor.putString("re_con", string + "||" + com.baidu.sofire.b.a.a(aVar));
        this.f10293f.commit();
    }

    public final void a(boolean z) {
        this.f10290c.putBoolean("s_c_c", z);
        if (Build.VERSION.SDK_INT >= 9) {
            this.f10290c.apply();
        } else {
            this.f10290c.commit();
        }
    }
}
