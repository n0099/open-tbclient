package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes3.dex */
public abstract class u {
    private static u aAk;

    protected abstract void a(BdPageContext bdPageContext);

    protected abstract void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j);

    protected abstract g ea(String str);

    protected abstract String eb(String str);

    protected abstract boolean ec(String str);

    protected abstract boolean ed(String str);

    protected abstract boolean ee(String str);

    protected abstract void onDestroy();

    protected abstract String xb();

    protected abstract void xc();

    protected abstract void xd();

    public static final void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2) {
        if (aAk != null) {
            aAk.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13, j2);
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j) {
        if (aAk != null) {
            aAk.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9, str10, str11, j);
        }
    }

    public static void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aAk != null) {
            aAk.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void xe() {
        if (aAk != null) {
            aAk.xc();
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (aAk != null) {
            aAk.a(str, str2, str3, str4, i, i2, str5);
        }
    }

    public static final g ef(String str) {
        if (aAk != null) {
            return aAk.ea(str);
        }
        return null;
    }

    public static final void b(BdPageContext bdPageContext) {
        if (aAk != null) {
            aAk.a(bdPageContext);
        }
    }

    public static final void xf() {
        if (aAk != null) {
            aAk.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(u uVar) {
        aAk = uVar;
    }

    public static boolean eg(String str) {
        if (aAk != null) {
            return aAk.ec(str);
        }
        return false;
    }

    public static boolean eh(String str) {
        if (aAk != null) {
            return aAk.ed(str);
        }
        return false;
    }

    public static boolean ei(String str) {
        if (aAk != null) {
            return aAk.ee(str);
        }
        return false;
    }

    public static String xg() {
        return aAk != null ? aAk.xb() : "";
    }

    public static void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        if (aAk != null) {
            aAk.a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2);
        }
    }

    public static void xh() {
        if (aAk != null) {
            aAk.xd();
        }
    }

    public static String ej(String str) {
        return aAk != null ? aAk.eb(str) : "";
    }
}
