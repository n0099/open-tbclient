package com.baidu.sofire;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.protocol.HTTP;
/* loaded from: classes2.dex */
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

    public final boolean a() {
        return this.a.getBoolean("iio", false);
    }

    public final String b() {
        return this.a.getString("svi_n", "");
    }

    public final boolean c() {
        return this.a.getBoolean("bka", true);
    }

    public final void d() {
        this.c.putLong("pu_ap_fd", System.currentTimeMillis());
        this.c.commit();
    }

    public final int e() {
        return this.a.getInt("wi_fa_pu_ap", 0);
    }

    public final void a(int i) {
        this.c.putInt("wi_fa_pu_ap", i);
        this.c.commit();
    }

    public final int f() {
        return this.a.getInt("mo_fa_pu_ap", 0);
    }

    public final void b(int i) {
        this.c.putInt("mo_fa_pu_ap", i);
        this.c.commit();
    }

    public final void g() {
        this.c.putLong("pu_cl_fd", System.currentTimeMillis());
        this.c.commit();
    }

    public final void h() {
        this.c.putLong("se_ae_fd", System.currentTimeMillis());
        this.c.commit();
    }

    public final int i() {
        return this.a.getInt("wi_fa_pu_cl", 0);
    }

    public final int j() {
        return this.a.getInt("mo_fa_pu_cl", 0);
    }

    public final int k() {
        return this.a.getInt("mo_ae_fa_ct", 0);
    }

    public final void c(int i) {
        this.c.putInt("mo_ae_fa_ct", i);
        this.c.commit();
    }

    public final String l() {
        return this.b.getString("xyus", "");
    }

    public final void a(String str) {
        this.d.putString("xyus", str);
        this.d.commit();
    }

    public final String m() {
        return this.b.getString("xyusec", "");
    }

    public final void b(String str) {
        this.d.putString("xyusec", str);
        this.d.commit();
    }

    public final String n() {
        String str;
        String string = this.b.getString("xyglsn", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            str = new String(com.baidu.sofire.i.a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10), true), HTTP.UTF_8);
        } catch (Throwable th) {
            str = "";
            com.baidu.sofire.i.d.a();
        }
        return str;
    }

    public final String o() {
        String str;
        String string = this.b.getString("rpiiemn", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            str = new String(com.baidu.sofire.i.a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10), true), HTTP.UTF_8);
        } catch (Throwable th) {
            str = "";
            com.baidu.sofire.i.d.a();
        }
        return str;
    }

    public final String p() {
        String str;
        String string = this.b.getString("rpnewuidn", "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            str = new String(com.baidu.sofire.i.a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), Base64.decode(string, 10), true), HTTP.UTF_8);
        } catch (Throwable th) {
            str = "";
            com.baidu.sofire.i.d.a();
        }
        return str;
    }

    public final void c(String str) {
        if (TextUtils.isEmpty(str)) {
            this.d.putString("rpnewuidn", "");
            this.d.commit();
            return;
        }
        try {
            this.d.putString("rpnewuidn", new String(Base64.encode(com.baidu.sofire.i.a.a("MzAyMTIxMDJkaWN1ZGlhYg==".getBytes(), str.getBytes(HTTP.UTF_8)), 10), HTTP.UTF_8));
            this.d.commit();
        } catch (Throwable th) {
            com.baidu.sofire.i.d.a();
        }
    }

    public final List<Integer> q() {
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

    public final List<Integer> r() {
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

    public final void s() {
        this.c.putBoolean("lpcf", true);
        this.c.commit();
    }

    public final boolean t() {
        return this.a.getBoolean("lpcf", false);
    }

    public final void d(int i) {
        this.c.putInt("appal_daa", i);
        this.c.commit();
    }

    public final void e(int i) {
        this.c.putInt("appal_te", i);
        this.c.commit();
    }

    public final int u() {
        return this.a.getInt("appal_te", 24);
    }

    public final void f(int i) {
        this.c.putInt("sustfd", i);
        this.c.commit();
    }

    public final int v() {
        return this.a.getInt("sustfd", 0);
    }

    public final void g(int i) {
        this.c.putInt("sufzfd", i);
        this.c.commit();
    }

    public final int w() {
        return this.a.getInt("sufzfd", 0);
    }

    public final void a(long j) {
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

    public final void a(com.baidu.sofire.d.a aVar) {
        this.f.putString("re_con", this.e.getString("re_con", "") + "||" + com.baidu.sofire.d.a.a(aVar));
        this.f.commit();
    }

    public final List<com.baidu.sofire.d.a> x() {
        com.baidu.sofire.d.a a;
        String string = this.e.getString("re_con", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String[] split = string.split("\\|\\|");
        for (String str : split) {
            if (!TextUtils.isEmpty(str) && (a = com.baidu.sofire.d.a.a(str)) != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    public final int y() {
        if ("com.baidu.BaiduMap.meizu".equals(this.g.getPackageName())) {
            return this.e.getInt("re_net_hr", 24);
        }
        int i = this.e.getInt("re_net_hr", 3);
        try {
            String[] g = com.baidu.sofire.i.d.g(this.g);
            if (g != null && g.length == 2 && !TextUtils.isEmpty(g[0]) && !TextUtils.isEmpty(g[1]) && "200080".equals(g[0])) {
                if ("com.baidu.BaiduMap".equals(this.g.getPackageName()) && i < 24) {
                    return 24;
                }
            }
        } catch (Throwable th) {
        }
        return i;
    }

    public final void b(long j) {
        this.f.putLong("re_last_ofline_time", j);
        this.f.commit();
    }

    public final int z() {
        return this.e.getInt("up_nu_li", 100);
    }

    public final void c(long j) {
        this.f.putLong("re_day_len", j);
        this.f.commit();
    }

    public final void d(long j) {
        this.f.putLong("re_day_b_t", j);
        this.f.commit();
    }

    public final String d(String str) {
        return this.e.getString("al_da" + str, "");
    }

    public final void h(int i) {
        this.f.putInt("g_r_d_d_n", i);
        this.f.commit();
    }

    public final void a(boolean z) {
        this.c.putBoolean("s_c_c", z);
        this.c.commit();
    }

    public final boolean A() {
        return this.a.getBoolean("s_c_c", true);
    }

    public final void b(boolean z) {
        this.c.putBoolean("se_fg_s", z);
        this.c.commit();
    }

    public final void c(boolean z) {
        this.c.putBoolean("a_a_c_b", z);
        this.c.commit();
    }
}
