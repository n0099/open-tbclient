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
    private static b Mq = null;
    private static a Mr = null;
    private static boolean Ms = false;
    private static String Mt = "";
    private static transient List<String> Mu = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0031a {
        private static SparseIntArray Mv = new SparseIntArray();

        static {
            Mv.put(2, 1);
            Mv.put(4, 2);
            Mv.put(8, 3);
            Mv.put(12, 4);
            Mv.put(16, 5);
            Mv.put(20, 6);
            Mv.put(24, 7);
        }

        public static int bb(int i) {
            return Mv.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (Mr == null) {
            synchronized (a.class) {
                if (Mr == null) {
                    Mr = new a();
                    Mq = b.b(baseFragmentActivity);
                }
            }
        } else if (Mq != null) {
            Mq.a(baseFragmentActivity.getPageContext());
        }
        if (Ms && Mq != null) {
            Mq.nK();
            Mq.nL();
            Ms = false;
        }
        return Mr;
    }

    public static a b(BaseActivity baseActivity) {
        if (Mr == null) {
            synchronized (a.class) {
                if (Mr == null) {
                    Mr = new a();
                    Mq = b.c(baseActivity);
                }
            }
        } else if (Mq != null) {
            Mq.a(baseActivity.getPageContext());
        }
        if (Ms && Mq != null) {
            Mq.nK();
            Mq.nL();
            Ms = false;
        }
        return Mr;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        nF();
        if (z) {
            nz();
        }
        if (z2) {
            nA();
        }
        ae(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        nF();
        if (Mq != null) {
            Mq.a(tbPageContext, str, str2, str3);
        }
    }

    public void nz() {
        nF();
        if (Mq != null) {
            Mq.nK();
            Ms = false;
        }
    }

    public void nA() {
        nF();
        if (Mq != null) {
            Mq.nL();
            Ms = false;
        }
    }

    public void ae(boolean z) {
        nF();
        if (Mq != null) {
            Mq.ae(z);
        }
    }

    public boolean nB() {
        nF();
        if (Mq != null) {
            return Mq.nB();
        }
        return false;
    }

    public void a(b.a aVar) {
        nF();
        if (Mq != null) {
            Mq.c(aVar);
        }
    }

    public void b(b.a aVar) {
        nF();
        if (Mq != null) {
            if (Mq.nH()) {
                Mq.c(aVar);
            }
            Mq.nJ();
        }
    }

    public void a(int i, b.a aVar) {
        nF();
        if (Mq != null) {
            if (Mq.nH()) {
                Mq.c(aVar);
            }
            Mq.bc(i);
        }
    }

    public void nC() {
        nF();
        if (Mq != null) {
            Mq.nC();
            Ms = true;
        }
    }

    public void nD() {
        nF();
        if (Mq != null) {
            Mq.nD();
        }
    }

    public void nE() {
        nF();
        nD();
        nC();
    }

    private void nF() {
        if (Mq == null) {
        }
    }

    public static void nG() {
        try {
            if (Mq != null) {
                if (Mr != null) {
                    Mr.nE();
                }
                Mq.nI();
                Mq.nM();
                Mq = null;
            }
            if (Mr != null) {
                Mr = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
