package com.baidu.sofire;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.searchbox.ng.ai.apps.network.BaseRequestAction;
import com.baidu.sofire.ac.F;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e {
    private SharedPreferences a;
    private SharedPreferences b;
    private SharedPreferences.Editor c;
    private SharedPreferences.Editor d;
    private SharedPreferences e;
    private SharedPreferences.Editor f;
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
            b.a(th.getMessage(), th);
        }
    }

    public long a() {
        return this.a.getLong("npuct", 0L);
    }

    public void a(long j) {
        this.c.putLong("npuct", j);
        this.c.commit();
    }

    public boolean b() {
        return this.a.getBoolean("iio", false);
    }

    public void a(boolean z) {
        this.c.putBoolean("iio", z);
        this.c.commit();
    }

    public String c() {
        return this.a.getString("svi_n", "");
    }

    public void a(String str, String str2) {
        this.c.putString("svi_n", str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2);
        this.c.commit();
    }

    public String d() {
        return this.a.getString("svi", "");
    }

    public void b(String str, String str2) {
        this.c.putString("svi", str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2);
        this.c.commit();
    }

    public String e() {
        return this.a.getString("ses_ic", "");
    }

    public void a(String str) {
        this.c.putString("ses_ic", str);
        this.c.commit();
    }

    public boolean f() {
        return this.a.getBoolean("bka", true);
    }

    public void a(int i) {
        if (i > this.a.getInt("opi", 0)) {
            this.c.putInt("opi", i);
            this.c.commit();
        }
    }

    public int g() {
        return this.a.getInt("opi", 0);
    }

    public void a(String str, long j) {
        b.a("setLocalSupportListAndTime:" + str);
        try {
            this.c.putString("lsl", Base64.encodeToString(F.getInstance().ae(str.getBytes(), Base64.decode("MzAyMTIxMDJkaWN1ZGlhYg==", 0)), 0));
            this.c.putLong("lslt", j);
            this.c.commit();
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    public String h() {
        try {
            String str = new String(F.getInstance().ad(Base64.decode(this.a.getString("lsl", ""), 0), Base64.decode("MzAyMTIxMDJkaWN1ZGlhYg==", 0)));
            b.a("getLocalSupportList:" + str);
            return str;
        } catch (Throwable th) {
            return "";
        }
    }

    public long i() {
        return this.a.getLong("lslt", 0L);
    }

    public long j() {
        long j = this.a.getLong("pu_ap_fd", 0L);
        if (j == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            k();
            return currentTimeMillis;
        }
        return j;
    }

    public void k() {
        this.c.putLong("pu_ap_fd", System.currentTimeMillis());
        this.c.commit();
    }

    public int l() {
        return this.a.getInt("wi_fa_pu_ap", 0);
    }

    public void b(int i) {
        this.c.putInt("wi_fa_pu_ap", i);
        this.c.commit();
    }

    public int m() {
        return this.a.getInt("mo_fa_pu_ap", 0);
    }

    public void c(int i) {
        this.c.putInt("mo_fa_pu_ap", i);
        this.c.commit();
    }

    public long n() {
        long j = this.a.getLong("pu_cl_fd", 0L);
        if (j == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            o();
            return currentTimeMillis;
        }
        return j;
    }

    public void o() {
        this.c.putLong("pu_cl_fd", System.currentTimeMillis());
        this.c.commit();
    }

    public long p() {
        long j = this.a.getLong("se_ae_fd", 0L);
        if (j == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            q();
            return currentTimeMillis;
        }
        return j;
    }

    public void q() {
        this.c.putLong("se_ae_fd", System.currentTimeMillis());
        this.c.commit();
    }

    public int r() {
        return this.a.getInt("wi_fa_pu_cl", 0);
    }

    public void d(int i) {
        this.c.putInt("wi_fa_pu_cl", i);
        this.c.commit();
    }

    public int s() {
        return this.a.getInt("mo_fa_pu_cl", 0);
    }

    public void e(int i) {
        this.c.putInt("mo_fa_pu_cl", i);
        this.c.commit();
    }

    public int t() {
        return this.a.getInt("mo_ae_fa_ct", 0);
    }

    public void f(int i) {
        this.c.putInt("mo_ae_fa_ct", i);
        this.c.commit();
    }

    public boolean u() {
        return this.a.getBoolean("hac", false);
    }

    public void b(boolean z) {
        this.c.putBoolean("hac", z);
        this.c.commit();
    }

    public String v() {
        return this.b.getString("xyus", "");
    }

    public void b(String str) {
        this.d.putString("xyus", str);
        this.d.commit();
    }

    public String w() {
        return this.b.getString("xygls", "");
    }

    public void c(String str) {
        this.d.putString("xygls", str);
        this.d.commit();
    }

    public String x() {
        return this.b.getString("rpiiem", "");
    }

    public void d(String str) {
        this.d.putString("rpiiem", str);
        this.d.commit();
    }

    public String y() {
        return this.b.getString("rpandid", "");
    }

    public void e(String str) {
        this.d.putString("rpandid", str);
        this.d.commit();
    }

    public String z() {
        return this.b.getString("rpmacadd", "");
    }

    public void f(String str) {
        this.d.putString("rpmacadd", str);
        this.d.commit();
    }

    public String A() {
        return this.b.getString("rpnewuid", "");
    }

    public void g(String str) {
        this.d.putString("rpnewuid", str);
        this.d.commit();
    }

    public List<Integer> B() {
        String[] split;
        ArrayList arrayList = new ArrayList();
        String string = this.a.getString("hcpk", "");
        if (!TextUtils.isEmpty(string) && (split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != null && split.length > 0) {
            for (String str : split) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException e) {
                    b.a(e.getMessage(), e);
                }
            }
        }
        return arrayList;
    }

    public void a(int... iArr) {
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

    public List<Integer> C() {
        String[] split;
        ArrayList arrayList = new ArrayList();
        String string = this.a.getString("glspk", "");
        if (!TextUtils.isEmpty(string) && (split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != null && split.length > 0) {
            for (String str : split) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException e) {
                    b.a(e.getMessage(), e);
                }
            }
        }
        return arrayList;
    }

    public void a(List<Integer> list) {
        if (list == null || list.size() == 0) {
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

    public void g(int i) {
        this.c.putInt("rtqe", i);
        this.c.commit();
    }

    public int D() {
        return this.a.getInt("rtqe", 0);
    }

    public void c(boolean z) {
        this.c.putBoolean("lpcf", z);
        this.c.commit();
    }

    public boolean E() {
        return this.a.getBoolean("lpcf", false);
    }

    public void h(int i) {
        this.c.putInt("pdcg", i);
        this.c.commit();
    }

    public int F() {
        return this.a.getInt("pdcg", 0);
    }

    public void b(long j) {
        String str;
        try {
            if (j == 0) {
                this.c.putString("pdcgts", "");
                this.c.commit();
                return;
            }
            String string = this.a.getString("pdcgts", "");
            if (TextUtils.isEmpty(string)) {
                str = String.valueOf(j);
            } else if (string.split(BaseRequestAction.SPLITE).length < 20) {
                str = string + BaseRequestAction.SPLITE + String.valueOf(j);
            } else {
                return;
            }
            b.a("setPidChangeTimeStamp:" + str);
            this.c.putString("pdcgts", str);
            this.c.commit();
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    public void h(String str) {
        this.c.putString("ssv", str);
        this.c.commit();
    }

    public void i(int i) {
        this.c.putInt("appinv_t", i);
        this.c.commit();
    }

    public int G() {
        return this.a.getInt("appinv_t", 0);
    }

    public void j(int i) {
        this.c.putInt("appinv_js", i);
        this.c.commit();
    }

    public void k(int i) {
        this.c.putInt("appinv_ky", i);
        this.c.commit();
    }

    public int H() {
        return this.a.getInt("appinv_ky", 1);
    }

    public void l(int i) {
        this.c.putInt("appal_daa", i);
        this.c.commit();
    }

    public void m(int i) {
        this.c.putInt("appal_te", i);
        this.c.commit();
    }

    public int I() {
        return this.a.getInt("appal_te", 24);
    }

    public void n(int i) {
        this.c.putInt("appplg_te", i);
        this.c.commit();
    }

    public int J() {
        return this.a.getInt("appplg_te", 360);
    }

    public void c(long j) {
        this.c.putLong("plla_tm", j);
        this.c.commit();
    }

    public long K() {
        return this.a.getLong("plla_tm", 0L);
    }

    public void o(int i) {
        this.c.putInt("sustfd", i);
        this.c.commit();
    }

    public int L() {
        return this.a.getInt("sustfd", 0);
    }

    public void p(int i) {
        this.c.putInt("sufzfd", i);
        this.c.commit();
    }

    public int M() {
        return this.a.getInt("sufzfd", 0);
    }

    public void d(long j) {
        this.c.putLong("slruct", j);
        this.c.commit();
    }

    public long N() {
        return this.a.getLong("slruct", 0L);
    }

    public void a(int i, int i2, int i3) {
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

    public int a(int i, int i2) {
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

    public String O() {
        return this.b.getString("sgud", "");
    }

    public void i(String str) {
        this.d.putString("sgud", str);
        this.d.commit();
    }

    public void a(com.baidu.sofire.rp.a.a aVar) {
        if (aVar != null) {
            this.f.putString("re_con", this.e.getString("re_con", "") + "||" + com.baidu.sofire.rp.a.a.a(aVar));
            this.f.commit();
        }
    }

    public void a(List<com.baidu.sofire.rp.a.a> list, com.baidu.sofire.rp.a.a aVar) {
        int indexOf;
        com.baidu.sofire.rp.a.a aVar2;
        if (aVar != null && list != null && (indexOf = list.indexOf(aVar)) != -1 && (aVar2 = list.get(indexOf)) != null) {
            this.f.putString("re_con", this.e.getString("re_con", "").replace(com.baidu.sofire.rp.a.a.a(aVar2), com.baidu.sofire.rp.a.a.a(aVar)));
            this.f.commit();
        }
    }

    public List<com.baidu.sofire.rp.a.a> P() {
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

    public void q(int i) {
        this.f.putInt("re_net_ty", i);
        this.f.commit();
    }

    public int Q() {
        return this.e.getInt("re_net_ty", 2);
    }

    public void r(int i) {
        this.f.putInt("re_net_hr", i);
        this.f.commit();
    }

    public int R() {
        if ("com.baidu.BaiduMap.meizu".equals(this.g.getPackageName())) {
            return this.e.getInt("re_net_hr", 24);
        }
        int i = this.e.getInt("re_net_hr", 3);
        try {
            String[] h = com.baidu.sofire.b.e.h(this.g);
            if (h != null && h.length == 2 && !TextUtils.isEmpty(h[0]) && !TextUtils.isEmpty(h[1]) && "200080".equals(h[0])) {
                if ("com.baidu.BaiduMap".equals(this.g.getPackageName()) && i < 24) {
                    return 24;
                }
            }
            return i;
        } catch (Throwable th) {
            return i;
        }
    }

    public void s(int i) {
        this.f.putInt("re_net_hr_bc", i);
        this.f.commit();
    }

    public void e(long j) {
        this.f.putLong("re_last_ofline_time", j);
        this.f.commit();
    }

    public long S() {
        return this.e.getLong("re_last_ofline_time", 0L);
    }

    public void t(int i) {
        this.f.putInt("re_net_wt", i);
        this.f.commit();
    }

    public int T() {
        return this.e.getInt("re_net_wt", 3);
    }

    public void u(int i) {
        this.f.putInt("re_net_over", i);
        this.f.commit();
    }

    public int U() {
        return this.e.getInt("re_net_over", 7);
    }

    public void v(int i) {
        this.f.putInt("up_nu_li", i);
        this.f.commit();
    }

    public int V() {
        return this.e.getInt("up_nu_li", 100);
    }

    public void w(int i) {
        this.f.putInt("up_nu_co", i);
        this.f.commit();
    }

    public int W() {
        return this.e.getInt("up_nu_co", 50);
    }

    public void x(int i) {
        this.f.putInt("re_net_one_lt", i);
        this.f.commit();
    }

    public int X() {
        return this.e.getInt("re_net_one_lt", 5);
    }

    public void y(int i) {
        this.f.putInt("re_net_dy_lt", i);
        this.f.commit();
    }

    public int Y() {
        return this.e.getInt("re_net_dy_lt", 50);
    }

    public void c(String str, String str2) {
        this.f.putString("re_net_ali2_" + str, str2);
        this.f.commit();
    }

    public String j(String str) {
        return this.e.getString("re_net_ali2_" + str, "");
    }

    public void a(String str, boolean z) {
        this.f.putBoolean("re_net_ins_" + str, z);
        this.f.commit();
    }

    public boolean k(String str) {
        return this.e.getBoolean("re_net_ins_" + str, false);
    }

    public void f(long j) {
        this.f.putLong("re_net_pu_de", j);
        this.f.commit();
    }

    public long Z() {
        return this.e.getLong("re_net_pu_de", 0L);
    }

    public void g(long j) {
        this.f.putLong("re_day_len", j);
        this.f.commit();
    }

    public long aa() {
        return this.e.getLong("re_day_len", 0L);
    }

    public void h(long j) {
        this.f.putLong("re_day_b_t", j);
        this.f.commit();
    }

    public long ab() {
        return this.e.getLong("re_day_b_t", 0L);
    }

    public void d(String str, String str2) {
        this.f.putString("al_da" + str, str2);
        this.f.commit();
    }

    public String l(String str) {
        return this.e.getString("al_da" + str, "");
    }

    public void e(String str, String str2) {
        this.f.putString("in_da" + str, str2);
        this.f.commit();
    }

    public void m(String str) {
        this.f.putString("li_pk_s", str);
        this.f.commit();
    }

    public String ac() {
        return this.e.getString("li_pk_s", "");
    }

    public String ad() {
        return this.e.getString("re_a_lc", "");
    }

    public String ae() {
        return this.e.getString("re_a_cv", "");
    }

    public int af() {
        return this.e.getInt("g_r_d_d_n", 0);
    }

    public void z(int i) {
        this.f.putInt("g_r_d_d_n", i);
        this.f.commit();
    }
}
