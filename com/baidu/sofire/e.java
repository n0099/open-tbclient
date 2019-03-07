package com.baidu.sofire;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sofire.ac.F;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class e {
    public SharedPreferences a;
    public SharedPreferences b;
    public SharedPreferences.Editor c;
    public SharedPreferences.Editor d;
    public SharedPreferences e;
    public SharedPreferences.Editor f;
    private Context g;

    public e(Context context) {
        try {
            this.g = context;
            this.a = context.getSharedPreferences("leroadcfg", 4);
            this.c = this.a.edit();
            this.b = context.getSharedPreferences("leroadcfg", 4);
            this.d = this.b.edit();
            this.e = context.getSharedPreferences("re_po_rt", 4);
            this.f = this.e.edit();
        } catch (Throwable th) {
            th.getMessage();
            b.c();
        }
    }

    public final void a(long j) {
        this.c.putLong("npuct", j);
        this.c.commit();
    }

    public final boolean a() {
        return this.a.getBoolean("iio", false);
    }

    public final String b() {
        return this.a.getString("svi_n", "");
    }

    public final boolean c() {
        return this.a.getBoolean("bka", true);
    }

    public final void a(String str, long j) {
        b.a();
        try {
            this.c.putString("lsl", Base64.encodeToString(F.getInstance().ae(str.getBytes(), Base64.decode("MzAyMTIxMDJkaWN1ZGlhYg==", 0)), 0));
            this.c.putLong("lslt", j);
            this.c.commit();
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a();
        }
    }

    public final String d() {
        try {
            String str = new String(F.getInstance().ad(Base64.decode(this.a.getString("lsl", ""), 0), Base64.decode("MzAyMTIxMDJkaWN1ZGlhYg==", 0)));
            b.a();
            return str;
        } catch (Throwable th) {
            return "";
        }
    }

    public final long e() {
        return this.a.getLong("lslt", 0L);
    }

    public final void f() {
        this.c.putLong("pu_ap_fd", System.currentTimeMillis());
        this.c.commit();
    }

    public final int g() {
        return this.a.getInt("wi_fa_pu_ap", 0);
    }

    public final void a(int i) {
        this.c.putInt("wi_fa_pu_ap", i);
        this.c.commit();
    }

    public final int h() {
        return this.a.getInt("mo_fa_pu_ap", 0);
    }

    public final void b(int i) {
        this.c.putInt("mo_fa_pu_ap", i);
        this.c.commit();
    }

    public final void i() {
        this.c.putLong("pu_cl_fd", System.currentTimeMillis());
        this.c.commit();
    }

    public final void j() {
        this.c.putLong("se_ae_fd", System.currentTimeMillis());
        this.c.commit();
    }

    public final int k() {
        return this.a.getInt("wi_fa_pu_cl", 0);
    }

    public final int l() {
        return this.a.getInt("mo_fa_pu_cl", 0);
    }

    public final int m() {
        return this.a.getInt("mo_ae_fa_ct", 0);
    }

    public final void c(int i) {
        this.c.putInt("mo_ae_fa_ct", i);
        this.c.commit();
    }

    public final boolean n() {
        return this.a.getBoolean("hac", false);
    }

    public final String o() {
        return this.b.getString("xyus", "");
    }

    public final void a(String str) {
        this.d.putString("xyus", str);
        this.d.commit();
    }

    public final void b(String str) {
        this.c.putString("cczd_s", str);
        this.c.commit();
    }

    public final List<Integer> p() {
        String[] split;
        ArrayList arrayList = new ArrayList();
        String string = this.a.getString("hcpk", "");
        if (!TextUtils.isEmpty(string) && (split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != null && split.length > 0) {
            for (String str : split) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException e) {
                    e.getMessage();
                    b.c();
                }
            }
        }
        return arrayList;
    }

    public final void a(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.c.putString("hcpk", "");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < iArr.length; i++) {
                sb.append(iArr[i]);
                if (i != iArr.length - 1) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
            }
            this.c.putString("hcpk", sb.toString());
        }
        this.c.commit();
    }

    public final List<Integer> q() {
        String[] split;
        ArrayList arrayList = new ArrayList();
        String string = this.a.getString("glspk", "");
        if (!TextUtils.isEmpty(string) && (split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != null && split.length > 0) {
            for (String str : split) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException e) {
                    e.getMessage();
                    b.c();
                }
            }
        }
        return arrayList;
    }

    public final void a(List<Integer> list) {
        if (list.size() == 0) {
            this.c.putString("glspk", "");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i != list.size() - 1) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
            }
            this.c.putString("glspk", sb.toString());
        }
        this.c.commit();
    }

    public final void r() {
        this.c.putBoolean("lpcf", true);
        this.c.commit();
    }

    public final void d(int i) {
        this.c.putInt("appal_daa", i);
        this.c.commit();
    }

    public final void e(int i) {
        this.c.putInt("appal_te", i);
        this.c.commit();
    }

    public final int s() {
        return this.a.getInt("appal_te", 24);
    }

    public final void f(int i) {
        this.c.putInt("sustfd", i);
        this.c.commit();
    }

    public final int t() {
        return this.a.getInt("sustfd", 0);
    }

    public final void g(int i) {
        this.c.putInt("sufzfd", i);
        this.c.commit();
    }

    public final int u() {
        return this.a.getInt("sufzfd", 0);
    }

    public final void b(long j) {
        this.c.putLong("slruct", j);
        this.c.commit();
    }

    public final void a(int i, int i2, int i3) {
        String str = "";
        switch (i) {
            case 0:
                str = "sustfits";
                break;
            case 1:
                str = "suetfite";
                break;
        }
        if (!TextUtils.isEmpty(str)) {
            this.c.putInt(str + i2, i3);
            this.c.commit();
        }
    }

    public final int a(int i, int i2) {
        String str = "";
        switch (i) {
            case 0:
                str = "sustfits";
                break;
            case 1:
                str = "suetfite";
                break;
        }
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return this.a.getInt(str + i2, 0);
    }

    public final void a(com.baidu.sofire.rp.a.a aVar) {
        this.f.putString("re_con", this.e.getString("re_con", "") + "||" + com.baidu.sofire.rp.a.a.a(aVar));
        this.f.commit();
    }

    public final List<com.baidu.sofire.rp.a.a> v() {
        com.baidu.sofire.rp.a.a a;
        String string = this.e.getString("re_con", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String[] split = string.split("\\|\\|");
        for (String str : split) {
            if (!TextUtils.isEmpty(str) && (a = com.baidu.sofire.rp.a.a.a(str)) != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    public final int w() {
        if ("com.baidu.BaiduMap.meizu".equals(this.g.getPackageName())) {
            return this.e.getInt("re_net_hr", 24);
        }
        int i = this.e.getInt("re_net_hr", 3);
        try {
            String[] g = com.baidu.sofire.b.e.g(this.g);
            if (g != null && g.length == 2 && !TextUtils.isEmpty(g[0]) && !TextUtils.isEmpty(g[1]) && "200080".equals(g[0])) {
                if ("com.baidu.BaiduMap".equals(this.g.getPackageName()) && i < 24) {
                    return 24;
                }
            }
        } catch (Throwable th) {
        }
        return i;
    }

    public final void c(long j) {
        this.f.putLong("re_last_ofline_time", j);
        this.f.commit();
    }

    public final int x() {
        return this.e.getInt("up_nu_li", 100);
    }

    public final void d(long j) {
        this.f.putLong("re_day_len", j);
        this.f.commit();
    }

    public final void e(long j) {
        this.f.putLong("re_day_b_t", j);
        this.f.commit();
    }

    public final String c(String str) {
        return this.e.getString("al_da" + str, "");
    }

    public final void h(int i) {
        this.f.putInt("g_r_d_d_n", i);
        this.f.commit();
    }
}
