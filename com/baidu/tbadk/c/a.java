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
    private static b Rb = null;
    private static a Rc = null;
    private static boolean Rd = false;
    private static String Re = "";
    private static transient List<String> Rf = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0043a {
        private static SparseIntArray Rg = new SparseIntArray();

        static {
            Rg.put(2, 1);
            Rg.put(4, 2);
            Rg.put(8, 3);
            Rg.put(12, 4);
            Rg.put(16, 5);
            Rg.put(20, 6);
            Rg.put(24, 7);
        }

        public static int bb(int i) {
            return Rg.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (Rc == null) {
            synchronized (a.class) {
                if (Rc == null) {
                    Rc = new a();
                    Rb = b.b(baseFragmentActivity);
                }
            }
        } else if (Rb != null) {
            Rb.a(baseFragmentActivity.getPageContext());
        }
        if (Rd && Rb != null) {
            Rb.nV();
            Rb.nW();
            Rd = false;
        }
        return Rc;
    }

    public static a b(BaseActivity baseActivity) {
        if (Rc == null) {
            synchronized (a.class) {
                if (Rc == null) {
                    Rc = new a();
                    Rb = b.c(baseActivity);
                }
            }
        } else if (Rb != null) {
            Rb.a(baseActivity.getPageContext());
        }
        if (Rd && Rb != null) {
            Rb.nV();
            Rb.nW();
            Rd = false;
        }
        return Rc;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        nQ();
        if (z) {
            nK();
        }
        if (z2) {
            nL();
        }
        ae(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        nQ();
        if (Rb != null) {
            Rb.a(tbPageContext, str, str2, str3);
        }
    }

    public void nK() {
        nQ();
        if (Rb != null) {
            Rb.nV();
            Rd = false;
        }
    }

    public void nL() {
        nQ();
        if (Rb != null) {
            Rb.nW();
            Rd = false;
        }
    }

    public void ae(boolean z) {
        nQ();
        if (Rb != null) {
            Rb.ae(z);
        }
    }

    public boolean nM() {
        nQ();
        if (Rb != null) {
            return Rb.nM();
        }
        return false;
    }

    public void a(b.a aVar) {
        nQ();
        if (Rb != null) {
            Rb.c(aVar);
        }
    }

    public void b(b.a aVar) {
        nQ();
        if (Rb != null) {
            if (Rb.nS()) {
                Rb.c(aVar);
            }
            Rb.nU();
        }
    }

    public void a(int i, b.a aVar) {
        nQ();
        if (Rb != null) {
            if (Rb.nS()) {
                Rb.c(aVar);
            }
            Rb.bc(i);
        }
    }

    public void nN() {
        nQ();
        if (Rb != null) {
            Rb.nN();
            Rd = true;
        }
    }

    public void nO() {
        nQ();
        if (Rb != null) {
            Rb.nO();
        }
    }

    public void nP() {
        nQ();
        nO();
        nN();
    }

    private void nQ() {
        if (Rb == null) {
        }
    }

    public static void nR() {
        try {
            if (Rb != null) {
                if (Rc != null) {
                    Rc.nP();
                }
                Rb.nT();
                Rb.nX();
                Rb = null;
            }
            if (Rc != null) {
                Rc = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
