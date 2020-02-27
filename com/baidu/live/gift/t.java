package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes3.dex */
public abstract class t {
    private static t ahG;

    protected abstract void a(BdPageContext bdPageContext);

    protected abstract void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11);

    protected abstract g dk(String str);

    protected abstract String dl(String str);

    protected abstract boolean dm(String str);

    protected abstract boolean dn(String str);

    /* renamed from: do */
    protected abstract boolean mo19do(String str);

    protected abstract void onDestroy();

    protected abstract String sD();

    protected abstract void sE();

    protected abstract void sF();

    public static final void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13) {
        if (ahG != null) {
            ahG.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13);
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11) {
        if (ahG != null) {
            ahG.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9, str10, str11);
        }
    }

    public static void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4) {
        if (ahG != null) {
            ahG.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4);
        }
    }

    public static void sG() {
        if (ahG != null) {
            ahG.sE();
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (ahG != null) {
            ahG.a(str, str2, str3, str4, i, i2, str5);
        }
    }

    public static final g dp(String str) {
        if (ahG != null) {
            return ahG.dk(str);
        }
        return null;
    }

    public static final void b(BdPageContext bdPageContext) {
        if (ahG != null) {
            ahG.a(bdPageContext);
        }
    }

    public static final void sH() {
        if (ahG != null) {
            ahG.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(t tVar) {
        ahG = tVar;
    }

    public static boolean dq(String str) {
        if (ahG != null) {
            return ahG.dm(str);
        }
        return false;
    }

    public static boolean dr(String str) {
        if (ahG != null) {
            return ahG.dn(str);
        }
        return false;
    }

    public static boolean ds(String str) {
        if (ahG != null) {
            return ahG.mo19do(str);
        }
        return false;
    }

    public static String sI() {
        return ahG != null ? ahG.sD() : "";
    }

    public static void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (ahG != null) {
            ahG.a(gVar, j, str, str2, str3, str4, str5, str6, str7);
        }
    }

    public static void sJ() {
        if (ahG != null) {
            ahG.sF();
        }
    }

    public static String dt(String str) {
        return ahG != null ? ahG.dl(str) : "";
    }
}
