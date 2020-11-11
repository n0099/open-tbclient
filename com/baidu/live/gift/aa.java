package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class aa {
    private static aa aWE;

    protected abstract com.baidu.live.data.w Hi();

    protected abstract String Hj();

    protected abstract void Hk();

    protected abstract String Hl();

    protected abstract void Hm();

    protected abstract void a(BdPageContext bdPageContext, boolean z);

    protected abstract void a(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, String str12, String str13, long j2, boolean z4, boolean z5);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, String str12, String str13, long j2, boolean z4, boolean z5, JSONObject jSONObject);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2);

    protected abstract void a(String str, String str2, String str3, String str4, int i, int i2, String str5);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j);

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

    protected abstract void setLiveShowData(com.baidu.live.data.w wVar);

    public static final void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, boolean z2, long j2, boolean z3) {
        if (aWE != null) {
            aWE.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, true, str12, str13, j2, z3, false);
        }
    }

    public static final void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, String str12, String str13, boolean z2, long j2, boolean z3, JSONObject jSONObject, String str14) {
        if (aWE != null) {
            if (str14.equals("1")) {
                aWE.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, true, str12, str13, j2, z3, true, jSONObject);
            } else {
                aWE.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, true, str12, str13, j2, z3, false, jSONObject);
            }
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9, String str10, String str11, long j) {
        if (aWE != null) {
            aWE.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9, str10, str11, j);
        }
    }

    public static void c(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aWE != null) {
            aWE.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void d(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4, long j2) {
        if (aWE != null) {
            aWE.b(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4, j2);
        }
    }

    public static void hb(String str) {
        if (aWE != null) {
            aWE.gZ(str);
        }
    }

    public static void b(String str, String str2, String str3, String str4, int i, int i2, String str5) {
        if (aWE != null) {
            aWE.a(str, str2, str3, str4, i, i2, str5);
        }
    }

    public static final g hc(String str) {
        if (aWE != null) {
            return aWE.gS(str);
        }
        return null;
    }

    public static final com.baidu.live.data.w Hn() {
        if (aWE != null) {
            return aWE.Hi();
        }
        return null;
    }

    public static final void d(com.baidu.live.data.w wVar) {
        if (aWE != null) {
            aWE.setLiveShowData(wVar);
        }
    }

    public static final String Ho() {
        if (aWE != null) {
            return aWE.Hj();
        }
        return null;
    }

    public static final void hd(String str) {
        if (aWE != null) {
            aWE.gT(str);
        }
    }

    public static final void b(BdPageContext bdPageContext, boolean z) {
        if (aWE != null) {
            aWE.a(bdPageContext, z);
        }
    }

    public static final void Hp() {
        if (aWE != null) {
            aWE.Hk();
        }
    }

    public static final void Hq() {
        if (aWE != null) {
            aWE.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(aa aaVar) {
        aWE = aaVar;
    }

    public static boolean he(String str) {
        if (aWE != null) {
            return aWE.gV(str);
        }
        return false;
    }

    public static boolean hf(String str) {
        if (aWE != null) {
            return aWE.gW(str);
        }
        return false;
    }

    public static boolean hg(String str) {
        if (aWE != null) {
            return aWE.gX(str);
        }
        return false;
    }

    public static String Hr() {
        return aWE != null ? aWE.Hl() : "";
    }

    public static void b(g gVar, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, long j2) {
        if (aWE != null) {
            aWE.a(gVar, j, str, str2, str3, str4, str5, str6, str7, j2);
        }
    }

    public static void Hs() {
        if (aWE != null) {
            aWE.Hm();
        }
    }

    public static String hh(String str) {
        return aWE != null ? aWE.gU(str) : "";
    }

    public static c hi(String str) {
        if (aWE != null) {
            return aWE.ha(str);
        }
        return null;
    }

    public static void hj(String str) {
        if (aWE != null) {
            aWE.gY(str);
        }
    }
}
