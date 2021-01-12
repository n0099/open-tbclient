package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes10.dex */
public abstract class aj {
    private static aj aUX;

    protected abstract com.baidu.live.data.x DW();

    protected abstract String DX();

    protected abstract void DY();

    protected abstract String DZ();

    protected abstract void Ea();

    protected abstract void a(BdPageContext bdPageContext, boolean z, boolean z2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, String str14, boolean z2, boolean z3, long j3, int i, boolean z4);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, int i3, long j);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j, String str12);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12);

    protected abstract g fG(String str);

    protected abstract void fH(String str);

    protected abstract String fI(String str);

    protected abstract boolean fJ(String str);

    protected abstract boolean fK(String str);

    protected abstract boolean fL(String str);

    protected abstract void fN(String str);

    protected abstract void onDestroy();

    protected abstract void setLiveShowData(com.baidu.live.data.x xVar);

    public static final void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, String str14, boolean z2, boolean z3, long j3, int i, boolean z4) {
        if (aUX != null) {
            aUX.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13, j2, str14, z2, z3, j3, i, z4);
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j, String str12) {
        if (aUX != null) {
            aUX.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9, str10, str11, j, str12);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        if (aUX != null) {
            aUX.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2, str12);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        if (aUX != null) {
            aUX.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2, str12);
        }
    }

    public static void fP(String str) {
        if (aUX != null) {
            aUX.fN(str);
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, int i3, long j) {
        if (aUX != null) {
            aUX.a(str, str2, str3, str4, i, i2, str5, str6, i3, j);
        }
    }

    public static final g fQ(String str) {
        if (aUX != null) {
            return aUX.fG(str);
        }
        return null;
    }

    public static final com.baidu.live.data.x Eb() {
        if (aUX != null) {
            return aUX.DW();
        }
        return null;
    }

    public static final void e(com.baidu.live.data.x xVar) {
        if (aUX != null) {
            aUX.setLiveShowData(xVar);
        }
    }

    public static final void b(BdPageContext bdPageContext, boolean z, boolean z2) {
        if (aUX != null) {
            aUX.a(bdPageContext, z, z2);
        }
    }

    public static final String Ec() {
        if (aUX != null) {
            return aUX.DX();
        }
        return null;
    }

    public static final void fR(String str) {
        if (aUX != null) {
            aUX.fH(str);
        }
    }

    public static final void Ed() {
        if (aUX != null) {
            aUX.DY();
        }
    }

    public static final void Ee() {
        if (aUX != null) {
            aUX.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(aj ajVar) {
        aUX = ajVar;
    }

    public static boolean fS(String str) {
        if (aUX != null) {
            return aUX.fJ(str);
        }
        return false;
    }

    public static boolean fT(String str) {
        if (aUX != null) {
            return aUX.fK(str);
        }
        return false;
    }

    public static boolean fU(String str) {
        if (aUX != null) {
            return aUX.fL(str);
        }
        return false;
    }

    public static String Ef() {
        return aUX != null ? aUX.DZ() : "";
    }

    public static void Eg() {
        if (aUX != null) {
            aUX.Ea();
        }
    }

    public static String fV(String str) {
        return aUX != null ? aUX.fI(str) : "";
    }
}
