package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes4.dex */
public abstract class ah {
    private static ah aUU;

    protected abstract String GA();

    protected abstract void GB();

    protected abstract String GC();

    protected abstract void GD();

    protected abstract com.baidu.live.data.w Gz();

    protected abstract void a(BdPageContext bdPageContext, boolean z);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, String str14, boolean z2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j, String str12);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12);

    protected abstract g gM(String str);

    protected abstract void gN(String str);

    protected abstract String gO(String str);

    protected abstract boolean gP(String str);

    protected abstract boolean gQ(String str);

    protected abstract boolean gR(String str);

    protected abstract void gT(String str);

    protected abstract void onDestroy();

    protected abstract void setLiveShowData(com.baidu.live.data.w wVar);

    public static final void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, String str14, boolean z2) {
        if (aUU != null) {
            aUU.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13, j2, str14, z2);
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j, String str12) {
        if (aUU != null) {
            aUU.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9, str10, str11, j, str12);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        if (aUU != null) {
            aUU.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2, str12);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        if (aUU != null) {
            aUU.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2, str12);
        }
    }

    public static void gV(String str) {
        if (aUU != null) {
            aUU.gT(str);
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6) {
        if (aUU != null) {
            aUU.a(str, str2, str3, str4, i, i2, str5, str6);
        }
    }

    public static final g gW(String str) {
        if (aUU != null) {
            return aUU.gM(str);
        }
        return null;
    }

    public static final com.baidu.live.data.w GE() {
        if (aUU != null) {
            return aUU.Gz();
        }
        return null;
    }

    public static final void d(com.baidu.live.data.w wVar) {
        if (aUU != null) {
            aUU.setLiveShowData(wVar);
        }
    }

    public static final void b(BdPageContext bdPageContext, boolean z) {
        if (aUU != null) {
            aUU.a(bdPageContext, z);
        }
    }

    public static final String GF() {
        if (aUU != null) {
            return aUU.GA();
        }
        return null;
    }

    public static final void gX(String str) {
        if (aUU != null) {
            aUU.gN(str);
        }
    }

    public static final void GG() {
        if (aUU != null) {
            aUU.GB();
        }
    }

    public static final void GH() {
        if (aUU != null) {
            aUU.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(ah ahVar) {
        aUU = ahVar;
    }

    public static boolean gY(String str) {
        if (aUU != null) {
            return aUU.gP(str);
        }
        return false;
    }

    public static boolean gZ(String str) {
        if (aUU != null) {
            return aUU.gQ(str);
        }
        return false;
    }

    public static boolean ha(String str) {
        if (aUU != null) {
            return aUU.gR(str);
        }
        return false;
    }

    public static String GI() {
        return aUU != null ? aUU.GC() : "";
    }

    public static void GJ() {
        if (aUU != null) {
            aUU.GD();
        }
    }

    public static String hb(String str) {
        return aUU != null ? aUU.gO(str) : "";
    }
}
