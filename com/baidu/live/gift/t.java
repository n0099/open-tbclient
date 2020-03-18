package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes3.dex */
public abstract class t {
    private static t ahQ;

    protected abstract void a(BdPageContext bdPageContext);

    protected abstract void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11);

    protected abstract g dj(String str);

    protected abstract String dk(String str);

    protected abstract boolean dl(String str);

    protected abstract boolean dm(String str);

    protected abstract boolean dn(String str);

    protected abstract void onDestroy();

    protected abstract String sI();

    protected abstract void sJ();

    protected abstract void sK();

    public static final void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13) {
        if (ahQ != null) {
            ahQ.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13);
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11) {
        if (ahQ != null) {
            ahQ.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9, str10, str11);
        }
    }

    public static void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4) {
        if (ahQ != null) {
            ahQ.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4);
        }
    }

    public static void sL() {
        if (ahQ != null) {
            ahQ.sJ();
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (ahQ != null) {
            ahQ.a(str, str2, str3, str4, i, i2, str5);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static final g m19do(String str) {
        if (ahQ != null) {
            return ahQ.dj(str);
        }
        return null;
    }

    public static final void b(BdPageContext bdPageContext) {
        if (ahQ != null) {
            ahQ.a(bdPageContext);
        }
    }

    public static final void sM() {
        if (ahQ != null) {
            ahQ.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(t tVar) {
        ahQ = tVar;
    }

    public static boolean dp(String str) {
        if (ahQ != null) {
            return ahQ.dl(str);
        }
        return false;
    }

    public static boolean dq(String str) {
        if (ahQ != null) {
            return ahQ.dm(str);
        }
        return false;
    }

    public static boolean dr(String str) {
        if (ahQ != null) {
            return ahQ.dn(str);
        }
        return false;
    }

    public static String sN() {
        return ahQ != null ? ahQ.sI() : "";
    }

    public static void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (ahQ != null) {
            ahQ.a(gVar, j, str, str2, str3, str4, str5, str6, str7);
        }
    }

    public static void sO() {
        if (ahQ != null) {
            ahQ.sK();
        }
    }

    public static String ds(String str) {
        return ahQ != null ? ahQ.dk(str) : "";
    }
}
