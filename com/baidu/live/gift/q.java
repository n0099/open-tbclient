package com.baidu.live.gift;

import com.baidu.live.adp.base.BdPageContext;
/* loaded from: classes6.dex */
public abstract class q {
    private static q Xx;

    protected abstract void a(BdPageContext bdPageContext);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11);

    protected abstract void a(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4);

    protected abstract g ch(String str);

    protected abstract boolean ci(String str);

    protected abstract boolean cj(String str);

    protected abstract boolean ck(String str);

    protected abstract void onDestroy();

    public static final void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11) {
        if (Xx != null) {
            Xx.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11);
        }
    }

    public static void b(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11, boolean z2, boolean z3, boolean z4) {
        if (Xx != null) {
            Xx.a(str, j, str2, str3, str4, str5, str6, str7, str8, z, str9, str10, str11, z2, z3, z4);
        }
    }

    public static final g cl(String str) {
        if (Xx != null) {
            return Xx.ch(str);
        }
        return null;
    }

    public static final void b(BdPageContext bdPageContext) {
        if (Xx != null) {
            Xx.a(bdPageContext);
        }
    }

    public static final void pO() {
        if (Xx != null) {
            Xx.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final void a(q qVar) {
        Xx = qVar;
    }

    public static boolean cm(String str) {
        if (Xx != null) {
            return Xx.ci(str);
        }
        return false;
    }

    public static boolean cn(String str) {
        if (Xx != null) {
            return Xx.cj(str);
        }
        return false;
    }

    public static boolean co(String str) {
        if (Xx != null) {
            return Xx.ck(str);
        }
        return false;
    }
}
