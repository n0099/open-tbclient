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
    private static b Qf = null;
    private static a Qg = null;
    private static boolean Qh = false;
    private static String Qi = "";
    private static transient List<String> Qj = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0034a {
        private static SparseIntArray Qk = new SparseIntArray();

        static {
            Qk.put(2, 1);
            Qk.put(4, 2);
            Qk.put(8, 3);
            Qk.put(12, 4);
            Qk.put(16, 5);
            Qk.put(20, 6);
            Qk.put(24, 7);
        }

        public static int aW(int i) {
            return Qk.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (Qg == null) {
            synchronized (a.class) {
                if (Qg == null) {
                    Qg = new a();
                    Qf = b.b(baseFragmentActivity);
                }
            }
        } else if (Qf != null) {
            Qf.a(baseFragmentActivity.getPageContext());
        }
        if (Qh && Qf != null) {
            Qf.nS();
            Qf.nT();
            Qh = false;
        }
        return Qg;
    }

    public static a b(BaseActivity baseActivity) {
        if (Qg == null) {
            synchronized (a.class) {
                if (Qg == null) {
                    Qg = new a();
                    Qf = b.c(baseActivity);
                }
            }
        } else if (Qf != null) {
            Qf.a(baseActivity.getPageContext());
        }
        if (Qh && Qf != null) {
            Qf.nS();
            Qf.nT();
            Qh = false;
        }
        return Qg;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        nN();
        if (z) {
            nH();
        }
        if (z2) {
            nI();
        }
        ad(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        nN();
        if (Qf != null) {
            Qf.a(tbPageContext, str, str2, str3);
        }
    }

    public void nH() {
        nN();
        if (Qf != null) {
            Qf.nS();
            Qh = false;
        }
    }

    public void nI() {
        nN();
        if (Qf != null) {
            Qf.nT();
            Qh = false;
        }
    }

    public void ad(boolean z) {
        nN();
        if (Qf != null) {
            Qf.ad(z);
        }
    }

    public boolean nJ() {
        nN();
        if (Qf != null) {
            return Qf.nJ();
        }
        return false;
    }

    public void a(b.a aVar) {
        nN();
        if (Qf != null) {
            Qf.c(aVar);
        }
    }

    public void b(b.a aVar) {
        nN();
        if (Qf != null) {
            if (Qf.nP()) {
                Qf.c(aVar);
            }
            Qf.nR();
        }
    }

    public void a(int i, b.a aVar) {
        nN();
        if (Qf != null) {
            if (Qf.nP()) {
                Qf.c(aVar);
            }
            Qf.aX(i);
        }
    }

    public void nK() {
        nN();
        if (Qf != null) {
            Qf.nK();
            Qh = true;
        }
    }

    public void nL() {
        nN();
        if (Qf != null) {
            Qf.nL();
        }
    }

    public void nM() {
        nN();
        nL();
        nK();
    }

    private void nN() {
        if (Qf == null) {
        }
    }

    public static void nO() {
        try {
            if (Qf != null) {
                if (Qg != null) {
                    Qg.nM();
                }
                Qf.nQ();
                Qf.nU();
                Qf = null;
            }
            if (Qg != null) {
                Qg = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
