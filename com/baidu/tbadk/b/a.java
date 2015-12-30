package com.baidu.tbadk.b;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.b.b;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static b SC = null;
    private static a SD = null;
    private static boolean SE = false;
    private static String SF = "";
    private static transient List<String> SG = new ArrayList(5);

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (SD == null) {
            synchronized (a.class) {
                if (SD == null) {
                    SD = new a();
                    SC = b.b(baseFragmentActivity);
                }
            }
        } else if (SC != null) {
            SC.a(baseFragmentActivity.getPageContext());
        }
        if (SE && SC != null) {
            SC.qc();
            SC.qd();
            SE = false;
        }
        return SD;
    }

    public static a b(BaseActivity baseActivity) {
        if (SD == null) {
            synchronized (a.class) {
                if (SD == null) {
                    SD = new a();
                    SC = b.c(baseActivity);
                }
            }
        } else if (SC != null) {
            SC.a(baseActivity.getPageContext());
        }
        if (SE && SC != null) {
            SC.qc();
            SC.qd();
            SE = false;
        }
        return SD;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        pX();
        if (z) {
            pR();
        }
        if (z2) {
            pS();
        }
        Z(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        pX();
        if (SC != null) {
            SC.a(tbPageContext, str, str2, str3);
        }
    }

    public void pR() {
        pX();
        if (SC != null) {
            SC.qc();
            SE = false;
        }
    }

    public void pS() {
        pX();
        if (SC != null) {
            SC.qd();
            SE = false;
        }
    }

    public void Z(boolean z) {
        pX();
        if (SC != null) {
            SC.Z(z);
        }
    }

    public boolean pT() {
        pX();
        if (SC != null) {
            return SC.pT();
        }
        return false;
    }

    public void a(b.a aVar) {
        pX();
        if (SC != null) {
            SC.c(aVar);
        }
    }

    public void b(b.a aVar) {
        pX();
        if (SC != null) {
            if (SC.pZ()) {
                SC.c(aVar);
            }
            SC.qb();
        }
    }

    public void a(int i, b.a aVar) {
        pX();
        if (SC != null) {
            if (SC.pZ()) {
                SC.c(aVar);
            }
            SC.aN(i);
        }
    }

    public void pU() {
        pX();
        if (SC != null) {
            SC.pU();
            SE = true;
        }
    }

    public void pV() {
        pX();
        if (SC != null) {
            SC.pV();
        }
    }

    public void pW() {
        pX();
        pV();
        pU();
    }

    private void pX() {
        if (SC == null) {
        }
    }

    public static void pY() {
        try {
            if (SC != null) {
                if (SD != null) {
                    SD.pW();
                }
                SC.qa();
                SC.qe();
                SC = null;
            }
            if (SD != null) {
                SD = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
