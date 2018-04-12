package com.baidu.tbadk.c;

import com.baidu.tbadk.c.b;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static b SS = null;
    private static a ST = null;
    private static boolean SU = false;
    private static String SV = "";
    private static transient List<String> SW = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (ST == null) {
            synchronized (a.class) {
                if (ST == null) {
                    ST = new a();
                    SS = b.c(baseFragmentActivity);
                }
            }
        } else if (SS != null) {
            SS.setContext(baseFragmentActivity.getPageContext());
        }
        if (SU && SS != null) {
            SS.oV();
            SS.oW();
            SU = false;
        }
        return ST;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        oR();
        if (z) {
            oM();
        }
        if (z2) {
            oN();
        }
        af(z3);
        a(aVar);
    }

    public void oM() {
        oR();
        if (SS != null) {
            SS.oV();
            SU = false;
        }
    }

    public void oN() {
        oR();
        if (SS != null) {
            SS.oW();
            SU = false;
        }
    }

    public void af(boolean z) {
        oR();
        if (SS != null) {
            SS.af(z);
        }
    }

    public void a(b.a aVar) {
        oR();
        if (SS != null) {
            SS.c(aVar);
        }
    }

    public void b(b.a aVar) {
        oR();
        if (SS != null) {
            if (SS.oS()) {
                SS.c(aVar);
            }
            SS.oU();
        }
    }

    public void a(int i, b.a aVar) {
        oR();
        if (SS != null) {
            if (SS.oS()) {
                SS.c(aVar);
            }
            SS.aZ(i);
        }
    }

    public void oO() {
        oR();
        if (SS != null) {
            SS.oO();
            SU = true;
        }
    }

    public void oP() {
        oR();
        if (SS != null) {
            SS.oP();
        }
    }

    public void oQ() {
        oR();
        oP();
        oO();
    }

    private void oR() {
        if (SS == null) {
        }
    }

    public static void resetAll() {
        try {
            if (SS != null) {
                if (ST != null) {
                    ST.oQ();
                }
                SS.oT();
                SS.oX();
                SS = null;
            }
            if (ST != null) {
                ST = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
