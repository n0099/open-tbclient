package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes4.dex */
public abstract class aj {
    private static aj aYf;

    protected abstract com.baidu.live.data.w Iq();

    protected abstract String Ir();

    protected abstract void Is();

    protected abstract String It();

    protected abstract void Iu();

    protected abstract void a(BdPageContext bdPageContext, boolean z);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, String str14, boolean z2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j, String str12);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12);

    protected abstract g hh(String str);

    protected abstract void hi(String str);

    protected abstract String hj(String str);

    protected abstract boolean hk(String str);

    protected abstract boolean hl(String str);

    protected abstract boolean hm(String str);

    protected abstract void ho(String str);

    protected abstract void onDestroy();

    protected abstract void setLiveShowData(com.baidu.live.data.w wVar);

    public static final void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, String str14, boolean z2) {
        if (aYf != null) {
            aYf.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13, j2, str14, z2);
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j, String str12) {
        if (aYf != null) {
            aYf.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9, str10, str11, j, str12);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        if (aYf != null) {
            aYf.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2, str12);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12) {
        if (aYf != null) {
            aYf.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2, str12);
        }
    }

    public static void hq(String str) {
        if (aYf != null) {
            aYf.ho(str);
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6) {
        if (aYf != null) {
            aYf.a(str, str2, str3, str4, i, i2, str5, str6);
        }
    }

    public static final g hr(String str) {
        if (aYf != null) {
            return aYf.hh(str);
        }
        return null;
    }

    public static final com.baidu.live.data.w Iv() {
        if (aYf != null) {
            return aYf.Iq();
        }
        return null;
    }

    public static final void d(com.baidu.live.data.w wVar) {
        if (aYf != null) {
            aYf.setLiveShowData(wVar);
        }
    }

    public static final void b(BdPageContext bdPageContext, boolean z) {
        if (aYf != null) {
            aYf.a(bdPageContext, z);
        }
    }

    public static final String Iw() {
        if (aYf != null) {
            return aYf.Ir();
        }
        return null;
    }

    public static final void hs(String str) {
        if (aYf != null) {
            aYf.hi(str);
        }
    }

    public static final void Ix() {
        if (aYf != null) {
            aYf.Is();
        }
    }

    public static final void Iy() {
        if (aYf != null) {
            aYf.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(aj ajVar) {
        aYf = ajVar;
    }

    public static boolean ht(String str) {
        if (aYf != null) {
            return aYf.hk(str);
        }
        return false;
    }

    public static boolean hu(String str) {
        if (aYf != null) {
            return aYf.hl(str);
        }
        return false;
    }

    public static boolean hv(String str) {
        if (aYf != null) {
            return aYf.hm(str);
        }
        return false;
    }

    public static String Iz() {
        return aYf != null ? aYf.It() : "";
    }

    public static void IA() {
        if (aYf != null) {
            aYf.Iu();
        }
    }

    public static String hw(String str) {
        return aYf != null ? aYf.hj(str) : "";
    }
}
