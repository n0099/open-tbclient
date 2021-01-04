package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes11.dex */
public abstract class aj {
    private static aj aZK;

    protected abstract com.baidu.live.data.x HR();

    protected abstract String HS();

    protected abstract void HT();

    protected abstract String HU();

    protected abstract void HV();

    protected abstract void a(BdPageContext bdPageContext, boolean z, boolean z2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, String str14, boolean z2, boolean z3, long j3, int i, boolean z4);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, int i3, long j);

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

    protected abstract void setLiveShowData(com.baidu.live.data.x xVar);

    public static final void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, String str14, boolean z2, boolean z3, long j3, int i, boolean z4) {
        if (aZK != null) {
            aZK.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13, j2, str14, z2, z3, j3, i, z4);
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j, String str12) {
        if (aZK != null) {
            aZK.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9, str10, str11, j, str12);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        if (aZK != null) {
            aZK.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2, str12);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        if (aZK != null) {
            aZK.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2, str12);
        }
    }

    public static void hb(String str) {
        if (aZK != null) {
            aZK.gZ(str);
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, int i3, long j) {
        if (aZK != null) {
            aZK.a(str, str2, str3, str4, i, i2, str5, str6, i3, j);
        }
    }

    public static final g hc(String str) {
        if (aZK != null) {
            return aZK.gS(str);
        }
        return null;
    }

    public static final com.baidu.live.data.x HW() {
        if (aZK != null) {
            return aZK.HR();
        }
        return null;
    }

    public static final void e(com.baidu.live.data.x xVar) {
        if (aZK != null) {
            aZK.setLiveShowData(xVar);
        }
    }

    public static final void b(BdPageContext bdPageContext, boolean z, boolean z2) {
        if (aZK != null) {
            aZK.a(bdPageContext, z, z2);
        }
    }

    public static final String HX() {
        if (aZK != null) {
            return aZK.HS();
        }
        return null;
    }

    public static final void hd(String str) {
        if (aZK != null) {
            aZK.gT(str);
        }
    }

    public static final void HY() {
        if (aZK != null) {
            aZK.HT();
        }
    }

    public static final void HZ() {
        if (aZK != null) {
            aZK.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(aj ajVar) {
        aZK = ajVar;
    }

    public static boolean he(String str) {
        if (aZK != null) {
            return aZK.gV(str);
        }
        return false;
    }

    public static boolean hf(String str) {
        if (aZK != null) {
            return aZK.gW(str);
        }
        return false;
    }

    public static boolean hg(String str) {
        if (aZK != null) {
            return aZK.gX(str);
        }
        return false;
    }

    public static String Ia() {
        return aZK != null ? aZK.HU() : "";
    }

    public static void Ib() {
        if (aZK != null) {
            aZK.HV();
        }
    }

    public static String hh(String str) {
        return aZK != null ? aZK.gU(str) : "";
    }
}
