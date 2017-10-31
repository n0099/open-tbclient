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
    private static b Re = null;
    private static a Rf = null;
    private static boolean Rg = false;
    private static String Rh = "";
    private static transient List<String> Ri = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0043a {
        private static SparseIntArray Rj = new SparseIntArray();

        static {
            Rj.put(2, 1);
            Rj.put(4, 2);
            Rj.put(8, 3);
            Rj.put(12, 4);
            Rj.put(16, 5);
            Rj.put(20, 6);
            Rj.put(24, 7);
        }

        public static int aZ(int i) {
            return Rj.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (Rf == null) {
            synchronized (a.class) {
                if (Rf == null) {
                    Rf = new a();
                    Re = b.b(baseFragmentActivity);
                }
            }
        } else if (Re != null) {
            Re.a(baseFragmentActivity.getPageContext());
        }
        if (Rg && Re != null) {
            Re.nR();
            Re.nS();
            Rg = false;
        }
        return Rf;
    }

    public static a b(BaseActivity baseActivity) {
        if (Rf == null) {
            synchronized (a.class) {
                if (Rf == null) {
                    Rf = new a();
                    Re = b.c(baseActivity);
                }
            }
        } else if (Re != null) {
            Re.a(baseActivity.getPageContext());
        }
        if (Rg && Re != null) {
            Re.nR();
            Re.nS();
            Rg = false;
        }
        return Rf;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        nM();
        if (z) {
            nG();
        }
        if (z2) {
            nH();
        }
        ac(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        nM();
        if (Re != null) {
            Re.a(tbPageContext, str, str2, str3);
        }
    }

    public void nG() {
        nM();
        if (Re != null) {
            Re.nR();
            Rg = false;
        }
    }

    public void nH() {
        nM();
        if (Re != null) {
            Re.nS();
            Rg = false;
        }
    }

    public void ac(boolean z) {
        nM();
        if (Re != null) {
            Re.ac(z);
        }
    }

    public boolean nI() {
        nM();
        if (Re != null) {
            return Re.nI();
        }
        return false;
    }

    public void a(b.a aVar) {
        nM();
        if (Re != null) {
            Re.c(aVar);
        }
    }

    public void b(b.a aVar) {
        nM();
        if (Re != null) {
            if (Re.nO()) {
                Re.c(aVar);
            }
            Re.nQ();
        }
    }

    public void a(int i, b.a aVar) {
        nM();
        if (Re != null) {
            if (Re.nO()) {
                Re.c(aVar);
            }
            Re.ba(i);
        }
    }

    public void nJ() {
        nM();
        if (Re != null) {
            Re.nJ();
            Rg = true;
        }
    }

    public void nK() {
        nM();
        if (Re != null) {
            Re.nK();
        }
    }

    public void nL() {
        nM();
        nK();
        nJ();
    }

    private void nM() {
        if (Re == null) {
        }
    }

    public static void nN() {
        try {
            if (Re != null) {
                if (Rf != null) {
                    Rf.nL();
                }
                Re.nP();
                Re.nT();
                Re = null;
            }
            if (Rf != null) {
                Rf = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
