package com.baidu.live.gift;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes10.dex */
public abstract class ac {
    private static ac aZE;

    protected abstract void Fc();

    protected abstract com.baidu.live.data.ab Fp();

    protected abstract String Fq();

    protected abstract void Fr();

    protected abstract String Fs();

    protected abstract void Ft();

    protected abstract void a(BdPageContext bdPageContext, boolean z, boolean z2);

    protected abstract void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, BdUniqueId bdUniqueId);

    protected abstract void a(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, String str5, String str6, long j);

    protected abstract void a(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, String str5, String str6, long j);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract g gh(String str);

    protected abstract void gi(String str);

    protected abstract String gj(String str);

    protected abstract boolean gk(String str);

    protected abstract boolean gl(String str);

    protected abstract boolean gm(String str);

    protected abstract void gn(String str);

    protected abstract b go(String str);

    protected abstract void gp(String str);

    protected abstract c gq(String str);

    protected abstract void onDestroy();

    protected abstract void setLiveShowData(com.baidu.live.data.ab abVar);

    public static void b(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, String str5, String str6, long j) {
        if (aZE != null) {
            aZE.a(cVar, aVar, str, str2, z, str3, str4, z2, z3, str5, str6, j);
        }
    }

    public static final void b(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, String str5, String str6, long j) {
        if (aZE != null) {
            aZE.a(cVar, aVar, str, str2, z, str3, str4, str5, str6, j);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aZE != null) {
            aZE.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aZE != null) {
            aZE.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void gr(String str) {
        if (aZE != null) {
            aZE.gp(str);
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (aZE != null) {
            aZE.a(str, str2, str3, str4, i, i2, str5);
        }
    }

    public static final g gt(String str) {
        if (aZE != null) {
            return aZE.gh(str);
        }
        return null;
    }

    public static final com.baidu.live.data.ab Fu() {
        if (aZE != null) {
            return aZE.Fp();
        }
        return null;
    }

    public static final void e(com.baidu.live.data.ab abVar) {
        if (aZE != null) {
            aZE.setLiveShowData(abVar);
        }
    }

    public static final String Fv() {
        if (aZE != null) {
            return aZE.Fq();
        }
        return null;
    }

    public static final void gu(String str) {
        if (aZE != null) {
            aZE.gi(str);
        }
    }

    public static final void b(BdPageContext bdPageContext, boolean z, boolean z2) {
        if (aZE != null) {
            aZE.a(bdPageContext, z, z2);
        }
    }

    public static final void Fw() {
        if (aZE != null) {
            aZE.Fr();
        }
    }

    public static final void Fx() {
        if (aZE != null) {
            aZE.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(ac acVar) {
        aZE = acVar;
    }

    public static boolean gv(String str) {
        if (aZE != null) {
            return aZE.gk(str);
        }
        return false;
    }

    public static boolean gw(String str) {
        if (aZE != null) {
            return aZE.gl(str);
        }
        return false;
    }

    public static boolean gx(String str) {
        if (aZE != null) {
            return aZE.gm(str);
        }
        return false;
    }

    public static String Fy() {
        return aZE != null ? aZE.Fs() : "";
    }

    public static void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        b(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, null);
    }

    public static void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, BdUniqueId bdUniqueId) {
        if (aZE != null) {
            aZE.a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, bdUniqueId);
        }
    }

    public static void Fz() {
        if (aZE != null) {
            aZE.Ft();
        }
    }

    public static String gy(String str) {
        return aZE != null ? aZE.gj(str) : "";
    }

    public static c gz(String str) {
        if (aZE != null) {
            return aZE.gq(str);
        }
        return null;
    }

    public static void FA() {
        if (aZE != null) {
            aZE.Fc();
        }
    }

    public static void gA(String str) {
        if (aZE != null) {
            aZE.gn(str);
        }
    }

    public static b gB(String str) {
        if (aZE != null) {
            return aZE.go(str);
        }
        return null;
    }
}
