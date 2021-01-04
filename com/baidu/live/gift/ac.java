package com.baidu.live.gift;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes11.dex */
public abstract class ac {
    private static ac aZJ;

    protected abstract void HE();

    protected abstract com.baidu.live.data.x HR();

    protected abstract String HS();

    protected abstract void HT();

    protected abstract String HU();

    protected abstract void HV();

    protected abstract void a(BdPageContext bdPageContext, boolean z, boolean z2);

    protected abstract void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, BdUniqueId bdUniqueId);

    protected abstract void a(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, String str5, String str6, long j);

    protected abstract void a(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, String str5, String str6, long j);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract g gS(String str);

    protected abstract void gT(String str);

    protected abstract String gU(String str);

    protected abstract boolean gV(String str);

    protected abstract boolean gW(String str);

    protected abstract boolean gX(String str);

    protected abstract void gY(String str);

    protected abstract void gZ(String str);

    protected abstract c ha(String str);

    protected abstract void onDestroy();

    protected abstract void setLiveShowData(com.baidu.live.data.x xVar);

    public static void b(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, String str5, String str6, long j) {
        if (aZJ != null) {
            aZJ.a(cVar, aVar, str, str2, z, str3, str4, z2, z3, str5, str6, j);
        }
    }

    public static final void b(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, String str5, String str6, long j) {
        if (aZJ != null) {
            aZJ.a(cVar, aVar, str, str2, z, str3, str4, str5, str6, j);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aZJ != null) {
            aZJ.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aZJ != null) {
            aZJ.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void hb(String str) {
        if (aZJ != null) {
            aZJ.gZ(str);
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (aZJ != null) {
            aZJ.a(str, str2, str3, str4, i, i2, str5);
        }
    }

    public static final g hc(String str) {
        if (aZJ != null) {
            return aZJ.gS(str);
        }
        return null;
    }

    public static final com.baidu.live.data.x HW() {
        if (aZJ != null) {
            return aZJ.HR();
        }
        return null;
    }

    public static final void e(com.baidu.live.data.x xVar) {
        if (aZJ != null) {
            aZJ.setLiveShowData(xVar);
        }
    }

    public static final String HX() {
        if (aZJ != null) {
            return aZJ.HS();
        }
        return null;
    }

    public static final void hd(String str) {
        if (aZJ != null) {
            aZJ.gT(str);
        }
    }

    public static final void b(BdPageContext bdPageContext, boolean z, boolean z2) {
        if (aZJ != null) {
            aZJ.a(bdPageContext, z, z2);
        }
    }

    public static final void HY() {
        if (aZJ != null) {
            aZJ.HT();
        }
    }

    public static final void HZ() {
        if (aZJ != null) {
            aZJ.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(ac acVar) {
        aZJ = acVar;
    }

    public static boolean he(String str) {
        if (aZJ != null) {
            return aZJ.gV(str);
        }
        return false;
    }

    public static boolean hf(String str) {
        if (aZJ != null) {
            return aZJ.gW(str);
        }
        return false;
    }

    public static boolean hg(String str) {
        if (aZJ != null) {
            return aZJ.gX(str);
        }
        return false;
    }

    public static String Ia() {
        return aZJ != null ? aZJ.HU() : "";
    }

    public static void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        b(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, null);
    }

    public static void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, BdUniqueId bdUniqueId) {
        if (aZJ != null) {
            aZJ.a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, bdUniqueId);
        }
    }

    public static void Ib() {
        if (aZJ != null) {
            aZJ.HV();
        }
    }

    public static String hh(String str) {
        return aZJ != null ? aZJ.gU(str) : "";
    }

    public static c hi(String str) {
        if (aZJ != null) {
            return aZJ.ha(str);
        }
        return null;
    }

    public static void Ic() {
        if (aZJ != null) {
            aZJ.HE();
        }
    }

    public static void hj(String str) {
        if (aZJ != null) {
            aZJ.gY(str);
        }
    }
}
