package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes3.dex */
public abstract class v {
    private static v aIf;

    protected abstract void a(BdPageContext bdPageContext, boolean z);

    protected abstract void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void b(String str, String str2, String str3, String str4, int i, int i2, String str5);

    protected abstract g eN(String str);

    protected abstract String eO(String str);

    protected abstract boolean eP(String str);

    protected abstract boolean eQ(String str);

    protected abstract boolean eR(String str);

    protected abstract void eS(String str);

    protected abstract void onDestroy();

    protected abstract String yR();

    protected abstract void yS();

    public static final void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2) {
        if (aIf != null) {
            aIf.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13, j2);
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j) {
        if (aIf != null) {
            aIf.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9, str10, str11, j);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aIf != null) {
            aIf.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aIf != null) {
            aIf.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void eT(String str) {
        if (aIf != null) {
            aIf.eS(str);
        }
    }

    public static void c(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (aIf != null) {
            aIf.b(str, str2, str3, str4, i, i2, str5);
        }
    }

    public static final g eU(String str) {
        if (aIf != null) {
            return aIf.eN(str);
        }
        return null;
    }

    public static final void b(BdPageContext bdPageContext, boolean z) {
        if (aIf != null) {
            aIf.a(bdPageContext, z);
        }
    }

    public static final void yT() {
        if (aIf != null) {
            aIf.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(v vVar) {
        aIf = vVar;
    }

    public static boolean eV(String str) {
        if (aIf != null) {
            return aIf.eP(str);
        }
        return false;
    }

    public static boolean eW(String str) {
        if (aIf != null) {
            return aIf.eQ(str);
        }
        return false;
    }

    public static boolean eX(String str) {
        if (aIf != null) {
            return aIf.eR(str);
        }
        return false;
    }

    public static String yU() {
        return aIf != null ? aIf.yR() : "";
    }

    public static void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        if (aIf != null) {
            aIf.a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2);
        }
    }

    public static void yV() {
        if (aIf != null) {
            aIf.yS();
        }
    }

    public static String eY(String str) {
        return aIf != null ? aIf.eO(str) : "";
    }
}
