package com.baidu.tbadk.c;

import android.util.SparseIntArray;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.c.b;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static b PZ = null;
    private static a Qa = null;
    private static boolean Qb = false;
    private static String Qc = "";
    private static transient List<String> Qd = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0036a {
        private static SparseIntArray Qe = new SparseIntArray();

        static {
            Qe.put(2, 1);
            Qe.put(4, 2);
            Qe.put(8, 3);
            Qe.put(12, 4);
            Qe.put(16, 5);
            Qe.put(20, 6);
            Qe.put(24, 7);
        }

        public static int aW(int i) {
            return Qe.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (Qa == null) {
            synchronized (a.class) {
                if (Qa == null) {
                    Qa = new a();
                    PZ = b.b(baseFragmentActivity);
                }
            }
        } else if (PZ != null) {
            PZ.a(baseFragmentActivity.getPageContext());
        }
        if (Qb && PZ != null) {
            PZ.nO();
            PZ.nP();
            Qb = false;
        }
        return Qa;
    }

    public static a b(BaseActivity baseActivity) {
        if (Qa == null) {
            synchronized (a.class) {
                if (Qa == null) {
                    Qa = new a();
                    PZ = b.c(baseActivity);
                }
            }
        } else if (PZ != null) {
            PZ.a(baseActivity.getPageContext());
        }
        if (Qb && PZ != null) {
            PZ.nO();
            PZ.nP();
            Qb = false;
        }
        return Qa;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        nJ();
        if (z) {
            nD();
        }
        if (z2) {
            nE();
        }
        ad(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        nJ();
        if (PZ != null) {
            PZ.a(tbPageContext, str, str2, str3);
        }
    }

    public void nD() {
        nJ();
        if (PZ != null) {
            PZ.nO();
            Qb = false;
        }
    }

    public void nE() {
        nJ();
        if (PZ != null) {
            PZ.nP();
            Qb = false;
        }
    }

    public void ad(boolean z) {
        nJ();
        if (PZ != null) {
            PZ.ad(z);
        }
    }

    public boolean nF() {
        nJ();
        if (PZ != null) {
            return PZ.nF();
        }
        return false;
    }

    public void a(b.a aVar) {
        nJ();
        if (PZ != null) {
            PZ.c(aVar);
        }
    }

    public void b(b.a aVar) {
        nJ();
        if (PZ != null) {
            if (PZ.nL()) {
                PZ.c(aVar);
            }
            PZ.nN();
        }
    }

    public void a(int i, b.a aVar) {
        nJ();
        if (PZ != null) {
            if (PZ.nL()) {
                PZ.c(aVar);
            }
            PZ.aX(i);
        }
    }

    public void nG() {
        nJ();
        if (PZ != null) {
            PZ.nG();
            Qb = true;
        }
    }

    public void nH() {
        nJ();
        if (PZ != null) {
            PZ.nH();
        }
    }

    public void nI() {
        nJ();
        nH();
        nG();
    }

    private void nJ() {
        if (PZ == null) {
        }
    }

    public static void nK() {
        try {
            if (PZ != null) {
                if (Qa != null) {
                    Qa.nI();
                }
                PZ.nM();
                PZ.nQ();
                PZ = null;
            }
            if (Qa != null) {
                Qa = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
