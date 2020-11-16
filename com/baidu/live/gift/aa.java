package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class aa {
    private static aa aUT;

    protected abstract String GA();

    protected abstract void GB();

    protected abstract String GC();

    protected abstract void GD();

    protected abstract com.baidu.live.data.w Gz();

    protected abstract void a(BdPageContext bdPageContext, boolean z);

    protected abstract void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, String str12, String str13, long j2, boolean z4, boolean z5);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, String str12, String str13, long j2, boolean z4, boolean z5, JSONObject jSONObject);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j);

    protected abstract void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract g gM(String str);

    protected abstract void gN(String str);

    protected abstract String gO(String str);

    protected abstract boolean gP(String str);

    protected abstract boolean gQ(String str);

    protected abstract boolean gR(String str);

    protected abstract void gS(String str);

    protected abstract void gT(String str);

    protected abstract c gU(String str);

    protected abstract void onDestroy();

    protected abstract void setLiveShowData(com.baidu.live.data.w wVar);

    public static final void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, boolean z2, long j2, boolean z3) {
        if (aUT != null) {
            aUT.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, true, str12, str13, j2, z3, false);
        }
    }

    public static final void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, boolean z2, long j2, boolean z3, JSONObject jSONObject, String str14) {
        if (aUT != null) {
            if (str14.equals("1")) {
                aUT.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, true, str12, str13, j2, z3, true, jSONObject);
            } else {
                aUT.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, true, str12, str13, j2, z3, false, jSONObject);
            }
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j) {
        if (aUT != null) {
            aUT.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9, str10, str11, j);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aUT != null) {
            aUT.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aUT != null) {
            aUT.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void gV(String str) {
        if (aUT != null) {
            aUT.gT(str);
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (aUT != null) {
            aUT.a(str, str2, str3, str4, i, i2, str5);
        }
    }

    public static final g gW(String str) {
        if (aUT != null) {
            return aUT.gM(str);
        }
        return null;
    }

    public static final com.baidu.live.data.w GE() {
        if (aUT != null) {
            return aUT.Gz();
        }
        return null;
    }

    public static final void d(com.baidu.live.data.w wVar) {
        if (aUT != null) {
            aUT.setLiveShowData(wVar);
        }
    }

    public static final String GF() {
        if (aUT != null) {
            return aUT.GA();
        }
        return null;
    }

    public static final void gX(String str) {
        if (aUT != null) {
            aUT.gN(str);
        }
    }

    public static final void b(BdPageContext bdPageContext, boolean z) {
        if (aUT != null) {
            aUT.a(bdPageContext, z);
        }
    }

    public static final void GG() {
        if (aUT != null) {
            aUT.GB();
        }
    }

    public static final void GH() {
        if (aUT != null) {
            aUT.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(aa aaVar) {
        aUT = aaVar;
    }

    public static boolean gY(String str) {
        if (aUT != null) {
            return aUT.gP(str);
        }
        return false;
    }

    public static boolean gZ(String str) {
        if (aUT != null) {
            return aUT.gQ(str);
        }
        return false;
    }

    public static boolean ha(String str) {
        if (aUT != null) {
            return aUT.gR(str);
        }
        return false;
    }

    public static String GI() {
        return aUT != null ? aUT.GC() : "";
    }

    public static void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        if (aUT != null) {
            aUT.a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2);
        }
    }

    public static void GJ() {
        if (aUT != null) {
            aUT.GD();
        }
    }

    public static String hb(String str) {
        return aUT != null ? aUT.gO(str) : "";
    }

    public static c hc(String str) {
        if (aUT != null) {
            return aUT.gU(str);
        }
        return null;
    }

    public static void hd(String str) {
        if (aUT != null) {
            aUT.gS(str);
        }
    }
}
