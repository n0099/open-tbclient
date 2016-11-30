package com.baidu.tbadk.b;

import android.util.SparseIntArray;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.b.b;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static b Mt = null;
    private static a Mu = null;
    private static boolean Mv = false;
    private static String Mw = "";
    private static transient List<String> Mx = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0031a {
        private static SparseIntArray My = new SparseIntArray();

        static {
            My.put(2, 1);
            My.put(4, 2);
            My.put(8, 3);
            My.put(12, 4);
            My.put(16, 5);
            My.put(20, 6);
            My.put(24, 7);
        }

        public static int bb(int i) {
            return My.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (Mu == null) {
            synchronized (a.class) {
                if (Mu == null) {
                    Mu = new a();
                    Mt = b.b(baseFragmentActivity);
                }
            }
        } else if (Mt != null) {
            Mt.a(baseFragmentActivity.getPageContext());
        }
        if (Mv && Mt != null) {
            Mt.nO();
            Mt.nP();
            Mv = false;
        }
        return Mu;
    }

    public static a b(BaseActivity baseActivity) {
        if (Mu == null) {
            synchronized (a.class) {
                if (Mu == null) {
                    Mu = new a();
                    Mt = b.c(baseActivity);
                }
            }
        } else if (Mt != null) {
            Mt.a(baseActivity.getPageContext());
        }
        if (Mv && Mt != null) {
            Mt.nO();
            Mt.nP();
            Mv = false;
        }
        return Mu;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        nJ();
        if (z) {
            nD();
        }
        if (z2) {
            nE();
        }
        ae(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        nJ();
        if (Mt != null) {
            Mt.a(tbPageContext, str, str2, str3);
        }
    }

    public void nD() {
        nJ();
        if (Mt != null) {
            Mt.nO();
            Mv = false;
        }
    }

    public void nE() {
        nJ();
        if (Mt != null) {
            Mt.nP();
            Mv = false;
        }
    }

    public void ae(boolean z) {
        nJ();
        if (Mt != null) {
            Mt.ae(z);
        }
    }

    public boolean nF() {
        nJ();
        if (Mt != null) {
            return Mt.nF();
        }
        return false;
    }

    public void a(b.a aVar) {
        nJ();
        if (Mt != null) {
            Mt.c(aVar);
        }
    }

    public void b(b.a aVar) {
        nJ();
        if (Mt != null) {
            if (Mt.nL()) {
                Mt.c(aVar);
            }
            Mt.nN();
        }
    }

    public void a(int i, b.a aVar) {
        nJ();
        if (Mt != null) {
            if (Mt.nL()) {
                Mt.c(aVar);
            }
            Mt.bc(i);
        }
    }

    public void nG() {
        nJ();
        if (Mt != null) {
            Mt.nG();
            Mv = true;
        }
    }

    public void nH() {
        nJ();
        if (Mt != null) {
            Mt.nH();
        }
    }

    public void nI() {
        nJ();
        nH();
        nG();
    }

    private void nJ() {
        if (Mt == null) {
        }
    }

    public static void nK() {
        try {
            if (Mt != null) {
                if (Mu != null) {
                    Mu.nI();
                }
                Mt.nM();
                Mt.nQ();
                Mt = null;
            }
            if (Mu != null) {
                Mu = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
