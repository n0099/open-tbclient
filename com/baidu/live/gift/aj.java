package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes10.dex */
public abstract class aj {
    private static aj aZF;

    protected abstract com.baidu.live.data.ab Fp();

    protected abstract String Fq();

    protected abstract void Fr();

    protected abstract String Fs();

    protected abstract void Ft();

    protected abstract void a(BdPageContext bdPageContext, boolean z, boolean z2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, String str14, boolean z2, boolean z3, long j3, int i, boolean z4);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, int i3, long j);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j, String str12);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12);

    protected abstract g gh(String str);

    protected abstract void gi(String str);

    protected abstract String gj(String str);

    protected abstract boolean gk(String str);

    protected abstract boolean gl(String str);

    protected abstract boolean gm(String str);

    protected abstract void gp(String str);

    protected abstract void onDestroy();

    protected abstract void setLiveShowData(com.baidu.live.data.ab abVar);

    public static final void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, String str14, boolean z2, boolean z3, long j3, int i, boolean z4) {
        if (aZF != null) {
            aZF.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13, j2, str14, z2, z3, j3, i, z4);
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j, String str12) {
        if (aZF != null) {
            aZF.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9, str10, str11, j, str12);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        if (aZF != null) {
            aZF.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2, str12);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        if (aZF != null) {
            aZF.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2, str12);
        }
    }

    public static void gr(String str) {
        if (aZF != null) {
            aZF.gp(str);
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, int i3, long j) {
        if (aZF != null) {
            aZF.a(str, str2, str3, str4, i, i2, str5, str6, i3, j);
        }
    }

    public static final g gt(String str) {
        if (aZF != null) {
            return aZF.gh(str);
        }
        return null;
    }

    public static final com.baidu.live.data.ab Fu() {
        if (aZF != null) {
            return aZF.Fp();
        }
        return null;
    }

    public static final void e(com.baidu.live.data.ab abVar) {
        if (aZF != null) {
            aZF.setLiveShowData(abVar);
        }
    }

    public static final void b(BdPageContext bdPageContext, boolean z, boolean z2) {
        if (aZF != null) {
            aZF.a(bdPageContext, z, z2);
        }
    }

    public static final String Fv() {
        if (aZF != null) {
            return aZF.Fq();
        }
        return null;
    }

    public static final void gu(String str) {
        if (aZF != null) {
            aZF.gi(str);
        }
    }

    public static final void Fw() {
        if (aZF != null) {
            aZF.Fr();
        }
    }

    public static final void Fx() {
        if (aZF != null) {
            aZF.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(aj ajVar) {
        aZF = ajVar;
    }

    public static boolean gv(String str) {
        if (aZF != null) {
            return aZF.gk(str);
        }
        return false;
    }

    public static boolean gw(String str) {
        if (aZF != null) {
            return aZF.gl(str);
        }
        return false;
    }

    public static boolean gx(String str) {
        if (aZF != null) {
            return aZF.gm(str);
        }
        return false;
    }

    public static String Fy() {
        return aZF != null ? aZF.Fs() : "";
    }

    public static void Fz() {
        if (aZF != null) {
            aZF.Ft();
        }
    }

    public static String gy(String str) {
        return aZF != null ? aZF.gj(str) : "";
    }
}
