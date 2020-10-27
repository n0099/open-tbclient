package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class ab {
    private static ab aVm;

    protected abstract com.baidu.live.data.w GH();

    protected abstract String GI();

    protected abstract void GJ();

    protected abstract String GK();

    protected abstract void GL();

    protected abstract void a(BdPageContext bdPageContext, boolean z);

    protected abstract void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, String str12, String str13, long j2, boolean z4, boolean z5);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, String str12, String str13, long j2, boolean z4, boolean z5, JSONObject jSONObject);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void d(com.baidu.live.data.w wVar);

    protected abstract g gN(String str);

    protected abstract void gO(String str);

    protected abstract String gP(String str);

    protected abstract boolean gQ(String str);

    protected abstract boolean gR(String str);

    protected abstract boolean gS(String str);

    protected abstract void gT(String str);

    protected abstract c gU(String str);

    protected abstract void onDestroy();

    public static final void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, boolean z2, long j2, boolean z3) {
        if (aVm != null) {
            aVm.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, true, str12, str13, j2, z3, false);
        }
    }

    public static final void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, boolean z2, long j2, boolean z3, JSONObject jSONObject, String str14) {
        if (aVm != null) {
            if (str14.equals("1")) {
                aVm.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, true, str12, str13, j2, z3, true, jSONObject);
            } else {
                aVm.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, true, str12, str13, j2, z3, false, jSONObject);
            }
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j) {
        if (aVm != null) {
            aVm.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9, str10, str11, j);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aVm != null) {
            aVm.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aVm != null) {
            aVm.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void gV(String str) {
        if (aVm != null) {
            aVm.gT(str);
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (aVm != null) {
            aVm.a(str, str2, str3, str4, i, i2, str5);
        }
    }

    public static final g gW(String str) {
        if (aVm != null) {
            return aVm.gN(str);
        }
        return null;
    }

    public static final com.baidu.live.data.w GM() {
        if (aVm != null) {
            return aVm.GH();
        }
        return null;
    }

    public static final void e(com.baidu.live.data.w wVar) {
        if (aVm != null) {
            aVm.d(wVar);
        }
    }

    public static final String GN() {
        if (aVm != null) {
            return aVm.GI();
        }
        return null;
    }

    public static final void gX(String str) {
        if (aVm != null) {
            aVm.gO(str);
        }
    }

    public static final void b(BdPageContext bdPageContext, boolean z) {
        if (aVm != null) {
            aVm.a(bdPageContext, z);
        }
    }

    public static final void GO() {
        if (aVm != null) {
            aVm.GJ();
        }
    }

    public static final void GP() {
        if (aVm != null) {
            aVm.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(ab abVar) {
        aVm = abVar;
    }

    public static boolean gY(String str) {
        if (aVm != null) {
            return aVm.gQ(str);
        }
        return false;
    }

    public static boolean gZ(String str) {
        if (aVm != null) {
            return aVm.gR(str);
        }
        return false;
    }

    public static boolean ha(String str) {
        if (aVm != null) {
            return aVm.gS(str);
        }
        return false;
    }

    public static String GQ() {
        return aVm != null ? aVm.GK() : "";
    }

    public static void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        if (aVm != null) {
            aVm.a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2);
        }
    }

    public static void GR() {
        if (aVm != null) {
            aVm.GL();
        }
    }

    public static String hb(String str) {
        return aVm != null ? aVm.gP(str) : "";
    }

    public static c hc(String str) {
        if (aVm != null) {
            return aVm.gU(str);
        }
        return null;
    }
}
