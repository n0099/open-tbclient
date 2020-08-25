package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes7.dex */
public abstract class v {
    private static v aON;

    protected abstract String EW();

    protected abstract void EX();

    protected abstract void a(BdPageContext bdPageContext, boolean z);

    protected abstract void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void b(String str, String str2, String str3, String str4, int i, int i2, String str5);

    protected abstract g gg(String str);

    protected abstract String gh(String str);

    protected abstract boolean gi(String str);

    protected abstract boolean gj(String str);

    protected abstract boolean gk(String str);

    protected abstract void gl(String str);

    protected abstract void onDestroy();

    public static final void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2) {
        if (aON != null) {
            aON.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13, j2);
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j) {
        if (aON != null) {
            aON.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9, str10, str11, j);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aON != null) {
            aON.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aON != null) {
            aON.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void gm(String str) {
        if (aON != null) {
            aON.gl(str);
        }
    }

    public static void c(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (aON != null) {
            aON.b(str, str2, str3, str4, i, i2, str5);
        }
    }

    public static final g gn(String str) {
        if (aON != null) {
            return aON.gg(str);
        }
        return null;
    }

    public static final void b(BdPageContext bdPageContext, boolean z) {
        if (aON != null) {
            aON.a(bdPageContext, z);
        }
    }

    public static final void EY() {
        if (aON != null) {
            aON.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(v vVar) {
        aON = vVar;
    }

    public static boolean go(String str) {
        if (aON != null) {
            return aON.gi(str);
        }
        return false;
    }

    public static boolean gp(String str) {
        if (aON != null) {
            return aON.gj(str);
        }
        return false;
    }

    public static boolean gq(String str) {
        if (aON != null) {
            return aON.gk(str);
        }
        return false;
    }

    public static String EZ() {
        return aON != null ? aON.EW() : "";
    }

    public static void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        if (aON != null) {
            aON.a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2);
        }
    }

    public static void Fa() {
        if (aON != null) {
            aON.EX();
        }
    }

    public static String gr(String str) {
        return aON != null ? aON.gh(str) : "";
    }
}
