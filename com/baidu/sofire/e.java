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
        }
    }

    public final void a(String str, long j) {
        new StringBuilder().append(str);
        try {
            this.c.putString("lsl", Base64.encodeToString(F.getInstance().ae(str.getBytes(), Base64.decode("MzAyMTIxMDJkaWN1ZGlhYg==", 0)), 0));
            this.c.putLong("lslt", j);
            this.c.commit();
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    public final String a() {
        try {
            String str = new String(F.getInstance().ad(Base64.decode(this.a.getString("lsl", ""), 0), Base64.decode("MzAyMTIxMDJkaWN1ZGlhYg==", 0)));
            new StringBuilder().append(str);
            return str;
        } catch (Throwable th) {
            return "";
        }
    }

    public final List<Integer> b() {
        String[] split;
        ArrayList arrayList = new ArrayList();
        String string = this.a.getString("hcpk", "");
        if (!TextUtils.isEmpty(string) && (split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != null && split.length > 0) {
            for (String str : split) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException e) {
                    e.getMessage();
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

    public final List<Integer> c() {
        String[] split;
        ArrayList arrayList = new ArrayList();
        String string = this.a.getString("glspk", "");
        if (!TextUtils.isEmpty(string) && (split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) != null && split.length > 0) {
            for (String str : split) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                } catch (NumberFormatException e) {
                    e.getMessage();
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

    public final void a(long j) {
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
            new StringBuilder().append(str);
            this.c.putString("pdcgts", str);
            this.c.commit();
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
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

    public final List<com.baidu.sofire.rp.a.a> d() {
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

    public final int e() {
        if ("com.baidu.BaiduMap.meizu".equals(this.g.getPackageName())) {
            return this.e.getInt("re_net_hr", 24);
        }
        int i = this.e.getInt("re_net_hr", 3);
        try {
            String[] e = com.baidu.sofire.b.e.e(this.g);
            if (e != null && e.length == 2 && !TextUtils.isEmpty(e[0]) && !TextUtils.isEmpty(e[1]) && "200080".equals(e[0])) {
                if ("com.baidu.BaiduMap".equals(this.g.getPackageName()) && i < 24) {
                    return 24;
                }
            }
        } catch (Throwable th) {
        }
        return i;
    }
}
