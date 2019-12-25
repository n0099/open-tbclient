package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes2.dex */
public abstract class s {
    private static s aeQ;

    protected abstract void a(BdPageContext bdPageContext);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4);

    protected abstract void a(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9);

    protected abstract g cZ(String str);

    protected abstract boolean da(String str);

    protected abstract boolean db(String str);

    protected abstract boolean dc(String str);

    protected abstract void onDestroy();

    public static final void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11) {
        if (aeQ != null) {
            aeQ.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11);
        }
    }

    public static final void b(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7, String str8, String str9) {
        if (aeQ != null) {
            aeQ.a(str, str2, str3, str4, str5, str6, z, str7, str8, str9);
        }
    }

    public static void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4) {
        if (aeQ != null) {
            aeQ.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4);
        }
    }

    public static final g dd(String str) {
        if (aeQ != null) {
            return aeQ.cZ(str);
        }
        return null;
    }

    public static final void b(BdPageContext bdPageContext) {
        if (aeQ != null) {
            aeQ.a(bdPageContext);
        }
    }

    public static final void rq() {
        if (aeQ != null) {
            aeQ.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(s sVar) {
        aeQ = sVar;
    }

    public static boolean de(String str) {
        if (aeQ != null) {
            return aeQ.da(str);
        }
        return false;
    }

    public static boolean df(String str) {
        if (aeQ != null) {
            return aeQ.db(str);
        }
        return false;
    }

    public static boolean dg(String str) {
        if (aeQ != null) {
            return aeQ.dc(str);
        }
        return false;
    }
}
