package com.baidu.live.gift;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes10.dex */
public abstract class ac {
    private static ac aUW;

    protected abstract void DJ();

    protected abstract com.baidu.live.data.x DW();

    protected abstract String DX();

    protected abstract void DY();

    protected abstract String DZ();

    protected abstract void Ea();

    protected abstract void a(BdPageContext bdPageContext, boolean z, boolean z2);

    protected abstract void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, BdUniqueId bdUniqueId);

    protected abstract void a(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, String str5, String str6, long j);

    protected abstract void a(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, String str5, String str6, long j);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract g fG(String str);

    protected abstract void fH(String str);

    protected abstract String fI(String str);

    protected abstract boolean fJ(String str);

    protected abstract boolean fK(String str);

    protected abstract boolean fL(String str);

    protected abstract void fM(String str);

    protected abstract void fN(String str);

    protected abstract c fO(String str);

    protected abstract void onDestroy();

    protected abstract void setLiveShowData(com.baidu.live.data.x xVar);

    public static void b(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, String str5, String str6, long j) {
        if (aUW != null) {
            aUW.a(cVar, aVar, str, str2, z, str3, str4, z2, z3, str5, str6, j);
        }
    }

    public static final void b(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, String str5, String str6, long j) {
        if (aUW != null) {
            aUW.a(cVar, aVar, str, str2, z, str3, str4, str5, str6, j);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aUW != null) {
            aUW.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aUW != null) {
            aUW.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void fP(String str) {
        if (aUW != null) {
            aUW.fN(str);
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (aUW != null) {
            aUW.a(str, str2, str3, str4, i, i2, str5);
        }
    }

    public static final g fQ(String str) {
        if (aUW != null) {
            return aUW.fG(str);
        }
        return null;
    }

    public static final com.baidu.live.data.x Eb() {
        if (aUW != null) {
            return aUW.DW();
        }
        return null;
    }

    public static final void e(com.baidu.live.data.x xVar) {
        if (aUW != null) {
            aUW.setLiveShowData(xVar);
        }
    }

    public static final String Ec() {
        if (aUW != null) {
            return aUW.DX();
        }
        return null;
    }

    public static final void fR(String str) {
        if (aUW != null) {
            aUW.fH(str);
        }
    }

    public static final void b(BdPageContext bdPageContext, boolean z, boolean z2) {
        if (aUW != null) {
            aUW.a(bdPageContext, z, z2);
        }
    }

    public static final void Ed() {
        if (aUW != null) {
            aUW.DY();
        }
    }

    public static final void Ee() {
        if (aUW != null) {
            aUW.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(ac acVar) {
        aUW = acVar;
    }

    public static boolean fS(String str) {
        if (aUW != null) {
            return aUW.fJ(str);
        }
        return false;
    }

    public static boolean fT(String str) {
        if (aUW != null) {
            return aUW.fK(str);
        }
        return false;
    }

    public static boolean fU(String str) {
        if (aUW != null) {
            return aUW.fL(str);
        }
        return false;
    }

    public static String Ef() {
        return aUW != null ? aUW.DZ() : "";
    }

    public static void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        b(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, null);
    }

    public static void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, BdUniqueId bdUniqueId) {
        if (aUW != null) {
            aUW.a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, bdUniqueId);
        }
    }

    public static void Eg() {
        if (aUW != null) {
            aUW.Ea();
        }
    }

    public static String fV(String str) {
        return aUW != null ? aUW.fI(str) : "";
    }

    public static c fW(String str) {
        if (aUW != null) {
            return aUW.fO(str);
        }
        return null;
    }

    public static void Eh() {
        if (aUW != null) {
            aUW.DJ();
        }
    }

    public static void fX(String str) {
        if (aUW != null) {
            aUW.fM(str);
        }
    }
}
