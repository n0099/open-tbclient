package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes4.dex */
public abstract class ai {
    private static ai aVn;

    protected abstract com.baidu.live.data.w GH();

    protected abstract void GJ();

    protected abstract String GK();

    protected abstract void GL();

    protected abstract void a(BdPageContext bdPageContext, boolean z);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, String str14, boolean z2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j, String str12);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12);

    protected abstract void d(com.baidu.live.data.w wVar);

    protected abstract g gN(String str);

    protected abstract String gP(String str);

    protected abstract boolean gQ(String str);

    protected abstract boolean gR(String str);

    protected abstract boolean gS(String str);

    protected abstract void gT(String str);

    protected abstract void onDestroy();

    public static final void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, String str14, boolean z2) {
        if (aVn != null) {
            aVn.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13, j2, str14, z2);
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j, String str12) {
        if (aVn != null) {
            aVn.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9, str10, str11, j, str12);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        if (aVn != null) {
            aVn.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2, str12);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        if (aVn != null) {
            aVn.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2, str12);
        }
    }

    public static void gV(String str) {
        if (aVn != null) {
            aVn.gT(str);
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6) {
        if (aVn != null) {
            aVn.a(str, str2, str3, str4, i, i2, str5, str6);
        }
    }

    public static final g gW(String str) {
        if (aVn != null) {
            return aVn.gN(str);
        }
        return null;
    }

    public static final com.baidu.live.data.w GM() {
        if (aVn != null) {
            return aVn.GH();
        }
        return null;
    }

    public static final void e(com.baidu.live.data.w wVar) {
        if (aVn != null) {
            aVn.d(wVar);
        }
    }

    public static final void b(BdPageContext bdPageContext, boolean z) {
        if (aVn != null) {
            aVn.a(bdPageContext, z);
        }
    }

    public static final void GO() {
        if (aVn != null) {
            aVn.GJ();
        }
    }

    public static final void GP() {
        if (aVn != null) {
            aVn.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(ai aiVar) {
        aVn = aiVar;
    }

    public static boolean gY(String str) {
        if (aVn != null) {
            return aVn.gQ(str);
        }
        return false;
    }

    public static boolean gZ(String str) {
        if (aVn != null) {
            return aVn.gR(str);
        }
        return false;
    }

    public static boolean ha(String str) {
        if (aVn != null) {
            return aVn.gS(str);
        }
        return false;
    }

    public static String GQ() {
        return aVn != null ? aVn.GK() : "";
    }

    public static void GR() {
        if (aVn != null) {
            aVn.GL();
        }
    }

    public static String hb(String str) {
        return aVn != null ? aVn.gP(str) : "";
    }
}
