package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes4.dex */
public abstract class w {
    private static w aUc;

    protected abstract com.baidu.live.data.u Gm();

    protected abstract String Gn();

    protected abstract void Go();

    protected abstract String Gp();

    protected abstract void Gq();

    protected abstract void a(BdPageContext bdPageContext, boolean z);

    protected abstract void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, boolean z2, boolean z3);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, boolean z2, long j2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void d(com.baidu.live.data.u uVar);

    protected abstract g gE(String str);

    protected abstract void gF(String str);

    protected abstract String gG(String str);

    protected abstract boolean gH(String str);

    protected abstract boolean gI(String str);

    protected abstract boolean gJ(String str);

    protected abstract void gK(String str);

    protected abstract void onDestroy();

    public static final void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, boolean z2, long j2) {
        if (aUc != null) {
            aUc.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13, z2, j2);
        }
    }

    public static final void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, boolean z2, String str14) {
        if (aUc != null) {
            if (str14.equals("1")) {
                aUc.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13, j2, z2, true);
            } else {
                aUc.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13, j2, z2, false);
            }
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j) {
        if (aUc != null) {
            aUc.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9, str10, str11, j);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aUc != null) {
            aUc.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aUc != null) {
            aUc.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void gL(String str) {
        if (aUc != null) {
            aUc.gK(str);
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (aUc != null) {
            aUc.a(str, str2, str3, str4, i, i2, str5);
        }
    }

    public static final g gM(String str) {
        if (aUc != null) {
            return aUc.gE(str);
        }
        return null;
    }

    public static final com.baidu.live.data.u Gr() {
        if (aUc != null) {
            return aUc.Gm();
        }
        return null;
    }

    public static final void e(com.baidu.live.data.u uVar) {
        if (aUc != null) {
            aUc.d(uVar);
        }
    }

    public static final String Gs() {
        if (aUc != null) {
            return aUc.Gn();
        }
        return null;
    }

    public static final void gN(String str) {
        if (aUc != null) {
            aUc.gF(str);
        }
    }

    public static final void b(BdPageContext bdPageContext, boolean z) {
        if (aUc != null) {
            aUc.a(bdPageContext, z);
        }
    }

    public static final void Gt() {
        if (aUc != null) {
            aUc.Go();
        }
    }

    public static final void Gu() {
        if (aUc != null) {
            aUc.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(w wVar) {
        aUc = wVar;
    }

    public static boolean gO(String str) {
        if (aUc != null) {
            return aUc.gH(str);
        }
        return false;
    }

    public static boolean gP(String str) {
        if (aUc != null) {
            return aUc.gI(str);
        }
        return false;
    }

    public static boolean gQ(String str) {
        if (aUc != null) {
            return aUc.gJ(str);
        }
        return false;
    }

    public static String Gv() {
        return aUc != null ? aUc.Gp() : "";
    }

    public static void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        if (aUc != null) {
            aUc.a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2);
        }
    }

    public static void Gw() {
        if (aUc != null) {
            aUc.Gq();
        }
    }

    public static String gR(String str) {
        return aUc != null ? aUc.gG(str) : "";
    }
}
