package com.baidu.live.gift;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes11.dex */
public abstract class ac {
    private static ac aYe;

    protected abstract void EZ();

    protected abstract com.baidu.live.data.ab Fm();

    protected abstract String Fn();

    protected abstract void Fo();

    protected abstract String Fp();

    protected abstract void Fq();

    protected abstract void a(BdPageContext bdPageContext, boolean z, boolean z2);

    protected abstract void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, BdUniqueId bdUniqueId);

    protected abstract void a(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, String str5, String str6, long j);

    protected abstract void a(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, String str5, String str6, long j);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract g gb(String str);

    protected abstract void gc(String str);

    protected abstract String gd(String str);

    protected abstract boolean ge(String str);

    protected abstract boolean gf(String str);

    protected abstract boolean gg(String str);

    protected abstract void gh(String str);

    protected abstract b gi(String str);

    protected abstract void gj(String str);

    protected abstract c gk(String str);

    protected abstract void onDestroy();

    protected abstract void setLiveShowData(com.baidu.live.data.ab abVar);

    public static void b(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, String str5, String str6, long j) {
        if (aYe != null) {
            aYe.a(cVar, aVar, str, str2, z, str3, str4, z2, z3, str5, str6, j);
        }
    }

    public static final void b(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, String str5, String str6, long j) {
        if (aYe != null) {
            aYe.a(cVar, aVar, str, str2, z, str3, str4, str5, str6, j);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aYe != null) {
            aYe.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aYe != null) {
            aYe.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void gl(String str) {
        if (aYe != null) {
            aYe.gj(str);
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (aYe != null) {
            aYe.a(str, str2, str3, str4, i, i2, str5);
        }
    }

    public static final g gm(String str) {
        if (aYe != null) {
            return aYe.gb(str);
        }
        return null;
    }

    public static final com.baidu.live.data.ab Fr() {
        if (aYe != null) {
            return aYe.Fm();
        }
        return null;
    }

    public static final void e(com.baidu.live.data.ab abVar) {
        if (aYe != null) {
            aYe.setLiveShowData(abVar);
        }
    }

    public static final String Fs() {
        if (aYe != null) {
            return aYe.Fn();
        }
        return null;
    }

    public static final void gn(String str) {
        if (aYe != null) {
            aYe.gc(str);
        }
    }

    public static final void b(BdPageContext bdPageContext, boolean z, boolean z2) {
        if (aYe != null) {
            aYe.a(bdPageContext, z, z2);
        }
    }

    public static final void Ft() {
        if (aYe != null) {
            aYe.Fo();
        }
    }

    public static final void Fu() {
        if (aYe != null) {
            aYe.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(ac acVar) {
        aYe = acVar;
    }

    public static boolean go(String str) {
        if (aYe != null) {
            return aYe.ge(str);
        }
        return false;
    }

    public static boolean gp(String str) {
        if (aYe != null) {
            return aYe.gf(str);
        }
        return false;
    }

    public static boolean gq(String str) {
        if (aYe != null) {
            return aYe.gg(str);
        }
        return false;
    }

    public static String Fv() {
        return aYe != null ? aYe.Fp() : "";
    }

    public static void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        b(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, null);
    }

    public static void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, BdUniqueId bdUniqueId) {
        if (aYe != null) {
            aYe.a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, bdUniqueId);
        }
    }

    public static void Fw() {
        if (aYe != null) {
            aYe.Fq();
        }
    }

    public static String gr(String str) {
        return aYe != null ? aYe.gd(str) : "";
    }

    public static c gt(String str) {
        if (aYe != null) {
            return aYe.gk(str);
        }
        return null;
    }

    public static void Fx() {
        if (aYe != null) {
            aYe.EZ();
        }
    }

    public static void gu(String str) {
        if (aYe != null) {
            aYe.gh(str);
        }
    }

    public static b gv(String str) {
        if (aYe != null) {
            return aYe.gi(str);
        }
        return null;
    }
}
