package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes4.dex */
public abstract class ah {
    private static ah aWF;

    protected abstract com.baidu.live.data.w Hi();

    protected abstract String Hj();

    protected abstract void Hk();

    protected abstract String Hl();

    protected abstract void Hm();

    protected abstract void a(BdPageContext bdPageContext, boolean z);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, String str14, boolean z2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j, String str12);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12);

    protected abstract g gS(String str);

    protected abstract void gT(String str);

    protected abstract String gU(String str);

    protected abstract boolean gV(String str);

    protected abstract boolean gW(String str);

    protected abstract boolean gX(String str);

    protected abstract void gZ(String str);

    protected abstract void onDestroy();

    protected abstract void setLiveShowData(com.baidu.live.data.w wVar);

    public static final void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, String str14, boolean z2) {
        if (aWF != null) {
            aWF.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13, j2, str14, z2);
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j, String str12) {
        if (aWF != null) {
            aWF.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9, str10, str11, j, str12);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        if (aWF != null) {
            aWF.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2, str12);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        if (aWF != null) {
            aWF.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2, str12);
        }
    }

    public static void hb(String str) {
        if (aWF != null) {
            aWF.gZ(str);
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6) {
        if (aWF != null) {
            aWF.a(str, str2, str3, str4, i, i2, str5, str6);
        }
    }

    public static final g hc(String str) {
        if (aWF != null) {
            return aWF.gS(str);
        }
        return null;
    }

    public static final com.baidu.live.data.w Hn() {
        if (aWF != null) {
            return aWF.Hi();
        }
        return null;
    }

    public static final void d(com.baidu.live.data.w wVar) {
        if (aWF != null) {
            aWF.setLiveShowData(wVar);
        }
    }

    public static final void b(BdPageContext bdPageContext, boolean z) {
        if (aWF != null) {
            aWF.a(bdPageContext, z);
        }
    }

    public static final String Ho() {
        if (aWF != null) {
            return aWF.Hj();
        }
        return null;
    }

    public static final void hd(String str) {
        if (aWF != null) {
            aWF.gT(str);
        }
    }

    public static final void Hp() {
        if (aWF != null) {
            aWF.Hk();
        }
    }

    public static final void Hq() {
        if (aWF != null) {
            aWF.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(ah ahVar) {
        aWF = ahVar;
    }

    public static boolean he(String str) {
        if (aWF != null) {
            return aWF.gV(str);
        }
        return false;
    }

    public static boolean hf(String str) {
        if (aWF != null) {
            return aWF.gW(str);
        }
        return false;
    }

    public static boolean hg(String str) {
        if (aWF != null) {
            return aWF.gX(str);
        }
        return false;
    }

    public static String Hr() {
        return aWF != null ? aWF.Hl() : "";
    }

    public static void Hs() {
        if (aWF != null) {
            aWF.Hm();
        }
    }

    public static String hh(String str) {
        return aWF != null ? aWF.gU(str) : "";
    }
}
