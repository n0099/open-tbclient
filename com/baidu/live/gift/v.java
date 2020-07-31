package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes4.dex */
public abstract class v {
    private static v aJC;

    protected abstract void a(BdPageContext bdPageContext, boolean z);

    protected abstract void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void b(String str, String str2, String str3, String str4, int i, int i2, String str5);

    protected abstract g eM(String str);

    protected abstract String eN(String str);

    protected abstract boolean eO(String str);

    protected abstract boolean eP(String str);

    protected abstract boolean eQ(String str);

    protected abstract void eR(String str);

    protected abstract void onDestroy();

    protected abstract String zt();

    protected abstract void zu();

    public static final void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2) {
        if (aJC != null) {
            aJC.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13, j2);
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j) {
        if (aJC != null) {
            aJC.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9, str10, str11, j);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aJC != null) {
            aJC.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aJC != null) {
            aJC.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void eS(String str) {
        if (aJC != null) {
            aJC.eR(str);
        }
    }

    public static void c(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (aJC != null) {
            aJC.b(str, str2, str3, str4, i, i2, str5);
        }
    }

    public static final g eT(String str) {
        if (aJC != null) {
            return aJC.eM(str);
        }
        return null;
    }

    public static final void b(BdPageContext bdPageContext, boolean z) {
        if (aJC != null) {
            aJC.a(bdPageContext, z);
        }
    }

    public static final void zv() {
        if (aJC != null) {
            aJC.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(v vVar) {
        aJC = vVar;
    }

    public static boolean eU(String str) {
        if (aJC != null) {
            return aJC.eO(str);
        }
        return false;
    }

    public static boolean eV(String str) {
        if (aJC != null) {
            return aJC.eP(str);
        }
        return false;
    }

    public static boolean eW(String str) {
        if (aJC != null) {
            return aJC.eQ(str);
        }
        return false;
    }

    public static String zw() {
        return aJC != null ? aJC.zt() : "";
    }

    public static void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        if (aJC != null) {
            aJC.a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2);
        }
    }

    public static void zx() {
        if (aJC != null) {
            aJC.zu();
        }
    }

    public static String eX(String str) {
        return aJC != null ? aJC.eN(str) : "";
    }
}
