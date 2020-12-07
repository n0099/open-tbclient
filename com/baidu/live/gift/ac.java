package com.baidu.live.gift;

import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes4.dex */
public abstract class ac {
    private static ac aYe;

    protected abstract com.baidu.live.data.w Iq();

    protected abstract String Ir();

    protected abstract void Is();

    protected abstract String It();

    protected abstract void Iu();

    protected abstract void a(BdPageContext bdPageContext, boolean z);

    protected abstract void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, BdUniqueId bdUniqueId);

    protected abstract void a(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, String str5, String str6, long j);

    protected abstract void a(com.baidu.live.im.data.c cVar, com.baidu.live.data.a aVar, String str, String str2, boolean z, String str3, String str4, boolean z2, boolean z3, String str5, String str6, long j);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract g hh(String str);

    protected abstract void hi(String str);

    protected abstract String hj(String str);

    protected abstract boolean hk(String str);

    protected abstract boolean hl(String str);

    protected abstract boolean hm(String str);

    protected abstract void hn(String str);

    protected abstract void ho(String str);

    protected abstract c hp(String str);

    protected abstract void onDestroy();

    protected abstract void setLiveShowData(com.baidu.live.data.w wVar);

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

    public static void hq(String str) {
        if (aYe != null) {
            aYe.ho(str);
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (aYe != null) {
            aYe.a(str, str2, str3, str4, i, i2, str5);
        }
    }

    public static final g hr(String str) {
        if (aYe != null) {
            return aYe.hh(str);
        }
        return null;
    }

    public static final com.baidu.live.data.w Iv() {
        if (aYe != null) {
            return aYe.Iq();
        }
        return null;
    }

    public static final void d(com.baidu.live.data.w wVar) {
        if (aYe != null) {
            aYe.setLiveShowData(wVar);
        }
    }

    public static final String Iw() {
        if (aYe != null) {
            return aYe.Ir();
        }
        return null;
    }

    public static final void hs(String str) {
        if (aYe != null) {
            aYe.hi(str);
        }
    }

    public static final void b(BdPageContext bdPageContext, boolean z) {
        if (aYe != null) {
            aYe.a(bdPageContext, z);
        }
    }

    public static final void Ix() {
        if (aYe != null) {
            aYe.Is();
        }
    }

    public static final void Iy() {
        if (aYe != null) {
            aYe.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(ac acVar) {
        aYe = acVar;
    }

    public static boolean ht(String str) {
        if (aYe != null) {
            return aYe.hk(str);
        }
        return false;
    }

    public static boolean hu(String str) {
        if (aYe != null) {
            return aYe.hl(str);
        }
        return false;
    }

    public static boolean hv(String str) {
        if (aYe != null) {
            return aYe.hm(str);
        }
        return false;
    }

    public static String Iz() {
        return aYe != null ? aYe.It() : "";
    }

    public static void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        b(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, null);
    }

    public static void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2, BdUniqueId bdUniqueId) {
        if (aYe != null) {
            aYe.a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2, bdUniqueId);
        }
    }

    public static void IA() {
        if (aYe != null) {
            aYe.Iu();
        }
    }

    public static String hw(String str) {
        return aYe != null ? aYe.hj(str) : "";
    }

    public static c hx(String str) {
        if (aYe != null) {
            return aYe.hp(str);
        }
        return null;
    }

    public static void hy(String str) {
        if (aYe != null) {
            aYe.hn(str);
        }
    }
}
