package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes7.dex */
public abstract class v {
    private static v aOP;

    protected abstract String EW();

    protected abstract void EX();

    protected abstract void a(BdPageContext bdPageContext, boolean z);

    protected abstract void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void b(String str, String str2, String str3, String str4, int i, int i2, String str5);

    protected abstract g gh(String str);

    protected abstract String gi(String str);

    protected abstract boolean gj(String str);

    protected abstract boolean gk(String str);

    protected abstract boolean gl(String str);

    protected abstract void gm(String str);

    protected abstract void onDestroy();

    public static final void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2) {
        if (aOP != null) {
            aOP.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13, j2);
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j) {
        if (aOP != null) {
            aOP.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9, str10, str11, j);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aOP != null) {
            aOP.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aOP != null) {
            aOP.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void gn(String str) {
        if (aOP != null) {
            aOP.gm(str);
        }
    }

    public static void c(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (aOP != null) {
            aOP.b(str, str2, str3, str4, i, i2, str5);
        }
    }

    public static final g go(String str) {
        if (aOP != null) {
            return aOP.gh(str);
        }
        return null;
    }

    public static final void b(BdPageContext bdPageContext, boolean z) {
        if (aOP != null) {
            aOP.a(bdPageContext, z);
        }
    }

    public static final void EY() {
        if (aOP != null) {
            aOP.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(v vVar) {
        aOP = vVar;
    }

    public static boolean gp(String str) {
        if (aOP != null) {
            return aOP.gj(str);
        }
        return false;
    }

    public static boolean gq(String str) {
        if (aOP != null) {
            return aOP.gk(str);
        }
        return false;
    }

    public static boolean gr(String str) {
        if (aOP != null) {
            return aOP.gl(str);
        }
        return false;
    }

    public static String EZ() {
        return aOP != null ? aOP.EW() : "";
    }

    public static void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        if (aOP != null) {
            aOP.a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2);
        }
    }

    public static void Fa() {
        if (aOP != null) {
            aOP.EX();
        }
    }

    public static String gt(String str) {
        return aOP != null ? aOP.gi(str) : "";
    }
}
