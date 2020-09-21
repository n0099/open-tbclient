package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes4.dex */
public abstract class w {
    private static w aQR;

    protected abstract com.baidu.live.data.u Fq();

    protected abstract String Fr();

    protected abstract void Fs();

    protected abstract String Ft();

    protected abstract void Fu();

    protected abstract void a(BdPageContext bdPageContext, boolean z);

    protected abstract void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, boolean z2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void d(com.baidu.live.data.u uVar);

    protected abstract g gp(String str);

    protected abstract void gq(String str);

    protected abstract String gr(String str);

    protected abstract boolean gt(String str);

    protected abstract boolean gu(String str);

    protected abstract boolean gv(String str);

    protected abstract void gw(String str);

    protected abstract void onDestroy();

    public static final void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2) {
        if (aQR != null) {
            aQR.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13, j2);
        }
    }

    public static final void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, String str14) {
        if (aQR != null) {
            if (str14.equals("1")) {
                aQR.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13, j2, true);
            } else {
                aQR.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13, j2, false);
            }
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j) {
        if (aQR != null) {
            aQR.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9, str10, str11, j);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aQR != null) {
            aQR.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aQR != null) {
            aQR.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void gx(String str) {
        if (aQR != null) {
            aQR.gw(str);
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (aQR != null) {
            aQR.a(str, str2, str3, str4, i, i2, str5);
        }
    }

    public static final g gy(String str) {
        if (aQR != null) {
            return aQR.gp(str);
        }
        return null;
    }

    public static final com.baidu.live.data.u Fv() {
        if (aQR != null) {
            return aQR.Fq();
        }
        return null;
    }

    public static final void e(com.baidu.live.data.u uVar) {
        if (aQR != null) {
            aQR.d(uVar);
        }
    }

    public static final String Fw() {
        if (aQR != null) {
            return aQR.Fr();
        }
        return null;
    }

    public static final void gz(String str) {
        if (aQR != null) {
            aQR.gq(str);
        }
    }

    public static final void b(BdPageContext bdPageContext, boolean z) {
        if (aQR != null) {
            aQR.a(bdPageContext, z);
        }
    }

    public static final void Fx() {
        if (aQR != null) {
            aQR.Fs();
        }
    }

    public static final void Fy() {
        if (aQR != null) {
            aQR.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(w wVar) {
        aQR = wVar;
    }

    public static boolean gA(String str) {
        if (aQR != null) {
            return aQR.gt(str);
        }
        return false;
    }

    public static boolean gB(String str) {
        if (aQR != null) {
            return aQR.gu(str);
        }
        return false;
    }

    public static boolean gC(String str) {
        if (aQR != null) {
            return aQR.gv(str);
        }
        return false;
    }

    public static String Fz() {
        return aQR != null ? aQR.Ft() : "";
    }

    public static void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        if (aQR != null) {
            aQR.a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2);
        }
    }

    public static void FA() {
        if (aQR != null) {
            aQR.Fu();
        }
    }

    public static String gD(String str) {
        return aQR != null ? aQR.gr(str) : "";
    }
}
