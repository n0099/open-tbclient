package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes3.dex */
public abstract class v {
    private static v aFJ;

    protected abstract void a(BdPageContext bdPageContext, boolean z);

    protected abstract void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void b(String str, String str2, String str3, String str4, int i, int i2, String str5);

    protected abstract g eH(String str);

    protected abstract String eI(String str);

    protected abstract boolean eJ(String str);

    protected abstract boolean eK(String str);

    protected abstract boolean eL(String str);

    protected abstract void eM(String str);

    protected abstract void onDestroy();

    protected abstract String yr();

    protected abstract void ys();

    public static final void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2) {
        if (aFJ != null) {
            aFJ.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13, j2);
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j) {
        if (aFJ != null) {
            aFJ.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9, str10, str11, j);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aFJ != null) {
            aFJ.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aFJ != null) {
            aFJ.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void eN(String str) {
        if (aFJ != null) {
            aFJ.eM(str);
        }
    }

    public static void c(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (aFJ != null) {
            aFJ.b(str, str2, str3, str4, i, i2, str5);
        }
    }

    public static final g eO(String str) {
        if (aFJ != null) {
            return aFJ.eH(str);
        }
        return null;
    }

    public static final void b(BdPageContext bdPageContext, boolean z) {
        if (aFJ != null) {
            aFJ.a(bdPageContext, z);
        }
    }

    public static final void yt() {
        if (aFJ != null) {
            aFJ.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(v vVar) {
        aFJ = vVar;
    }

    public static boolean eP(String str) {
        if (aFJ != null) {
            return aFJ.eJ(str);
        }
        return false;
    }

    public static boolean eQ(String str) {
        if (aFJ != null) {
            return aFJ.eK(str);
        }
        return false;
    }

    public static boolean eR(String str) {
        if (aFJ != null) {
            return aFJ.eL(str);
        }
        return false;
    }

    public static String yu() {
        return aFJ != null ? aFJ.yr() : "";
    }

    public static void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        if (aFJ != null) {
            aFJ.a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2);
        }
    }

    public static void yv() {
        if (aFJ != null) {
            aFJ.ys();
        }
    }

    public static String eS(String str) {
        return aFJ != null ? aFJ.eI(str) : "";
    }
}
