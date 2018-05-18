package com.baidu.tbadk.c;

import com.baidu.tbadk.c.b;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static b SM = null;
    private static a SO = null;
    private static boolean SQ = false;
    private static String SR = "";
    private static transient List<String> SS = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (SO == null) {
            synchronized (a.class) {
                if (SO == null) {
                    SO = new a();
                    SM = b.c(baseFragmentActivity);
                }
            }
        } else if (SM != null) {
            SM.setContext(baseFragmentActivity.getPageContext());
        }
        if (SQ && SM != null) {
            SM.oU();
            SM.oV();
            SQ = false;
        }
        return SO;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        oQ();
        if (z) {
            oL();
        }
        if (z2) {
            oM();
        }
        af(z3);
        a(aVar);
    }

    public void oL() {
        oQ();
        if (SM != null) {
            SM.oU();
            SQ = false;
        }
    }

    public void oM() {
        oQ();
        if (SM != null) {
            SM.oV();
            SQ = false;
        }
    }

    public void af(boolean z) {
        oQ();
        if (SM != null) {
            SM.af(z);
        }
    }

    public void a(b.a aVar) {
        oQ();
        if (SM != null) {
            SM.c(aVar);
        }
    }

    public void b(b.a aVar) {
        oQ();
        if (SM != null) {
            if (SM.oR()) {
                SM.c(aVar);
            }
            SM.oT();
        }
    }

    public void a(int i, b.a aVar) {
        oQ();
        if (SM != null) {
            if (SM.oR()) {
                SM.c(aVar);
            }
            SM.aY(i);
        }
    }

    public void oN() {
        oQ();
        if (SM != null) {
            SM.oN();
            SQ = true;
        }
    }

    public void oO() {
        oQ();
        if (SM != null) {
            SM.oO();
        }
    }

    public void oP() {
        oQ();
        oO();
        oN();
    }

    private void oQ() {
        if (SM == null) {
        }
    }

    public static void resetAll() {
        try {
            if (SM != null) {
                if (SO != null) {
                    SO.oP();
                }
                SM.oS();
                SM.oW();
                SM = null;
            }
            if (SO != null) {
                SO = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
