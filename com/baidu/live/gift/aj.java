package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes11.dex */
public abstract class aj {
    private static aj aYf;

    protected abstract com.baidu.live.data.ab Fm();

    protected abstract String Fn();

    protected abstract void Fo();

    protected abstract String Fp();

    protected abstract void Fq();

    protected abstract void a(BdPageContext bdPageContext, boolean z, boolean z2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, String str14, boolean z2, boolean z3, long j3, int i, boolean z4);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, int i3, long j);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j, String str12);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2, String str12);

    protected abstract g gb(String str);

    protected abstract void gc(String str);

    protected abstract String gd(String str);

    protected abstract boolean ge(String str);

    protected abstract boolean gf(String str);

    protected abstract boolean gg(String str);

    protected abstract void gj(String str);

    protected abstract void onDestroy();

    protected abstract void setLiveShowData(com.baidu.live.data.ab abVar);

    public static final void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, long j2, String str14, boolean z2, boolean z3, long j3, int i, boolean z4) {
        if (aYf != null) {
            aYf.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, str12, str13, j2, str14, z2, z3, j3, i, z4);
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

    public static void gl(String str) {
        if (aYf != null) {
            aYf.gj(str);
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, int i3, long j) {
        if (aYf != null) {
            aYf.a(str, str2, str3, str4, i, i2, str5, str6, i3, j);
        }
    }

    public static final g gm(String str) {
        if (aYf != null) {
            return aYf.gb(str);
        }
        return null;
    }

    public static final com.baidu.live.data.ab Fr() {
        if (aYf != null) {
            return aYf.Fm();
        }
        return null;
    }

    public static final void e(com.baidu.live.data.ab abVar) {
        if (aYf != null) {
            aYf.setLiveShowData(abVar);
        }
    }

    public static final void b(BdPageContext bdPageContext, boolean z, boolean z2) {
        if (aYf != null) {
            aYf.a(bdPageContext, z, z2);
        }
    }

    public static final String Fs() {
        if (aYf != null) {
            return aYf.Fn();
        }
        return null;
    }

    public static final void gn(String str) {
        if (aYf != null) {
            aYf.gc(str);
        }
    }

    public static final void Ft() {
        if (aYf != null) {
            aYf.Fo();
        }
    }

    public static final void Fu() {
        if (aYf != null) {
            aYf.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(aj ajVar) {
        aYf = ajVar;
    }

    public static boolean go(String str) {
        if (aYf != null) {
            return aYf.ge(str);
        }
        return false;
    }

    public static boolean gp(String str) {
        if (aYf != null) {
            return aYf.gf(str);
        }
        return false;
    }

    public static boolean gq(String str) {
        if (aYf != null) {
            return aYf.gg(str);
        }
        return false;
    }

    public static String Fv() {
        return aYf != null ? aYf.Fp() : "";
    }

    public static void Fw() {
        if (aYf != null) {
            aYf.Fq();
        }
    }

    public static String gr(String str) {
        return aYf != null ? aYf.gd(str) : "";
    }
}
