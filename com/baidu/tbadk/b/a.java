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
    private static b Mr = null;
    private static a Ms = null;
    private static boolean Mt = false;
    private static String Mu = "";
    private static transient List<String> Mv = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0031a {
        private static SparseIntArray Mw = new SparseIntArray();

        static {
            Mw.put(2, 1);
            Mw.put(4, 2);
            Mw.put(8, 3);
            Mw.put(12, 4);
            Mw.put(16, 5);
            Mw.put(20, 6);
            Mw.put(24, 7);
        }

        public static int bb(int i) {
            return Mw.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (Ms == null) {
            synchronized (a.class) {
                if (Ms == null) {
                    Ms = new a();
                    Mr = b.b(baseFragmentActivity);
                }
            }
        } else if (Mr != null) {
            Mr.a(baseFragmentActivity.getPageContext());
        }
        if (Mt && Mr != null) {
            Mr.nK();
            Mr.nL();
            Mt = false;
        }
        return Ms;
    }

    public static a b(BaseActivity baseActivity) {
        if (Ms == null) {
            synchronized (a.class) {
                if (Ms == null) {
                    Ms = new a();
                    Mr = b.c(baseActivity);
                }
            }
        } else if (Mr != null) {
            Mr.a(baseActivity.getPageContext());
        }
        if (Mt && Mr != null) {
            Mr.nK();
            Mr.nL();
            Mt = false;
        }
        return Ms;
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
        if (Mr != null) {
            Mr.a(tbPageContext, str, str2, str3);
        }
    }

    public void nz() {
        nF();
        if (Mr != null) {
            Mr.nK();
            Mt = false;
        }
    }

    public void nA() {
        nF();
        if (Mr != null) {
            Mr.nL();
            Mt = false;
        }
    }

    public void ae(boolean z) {
        nF();
        if (Mr != null) {
            Mr.ae(z);
        }
    }

    public boolean nB() {
        nF();
        if (Mr != null) {
            return Mr.nB();
        }
        return false;
    }

    public void a(b.a aVar) {
        nF();
        if (Mr != null) {
            Mr.c(aVar);
        }
    }

    public void b(b.a aVar) {
        nF();
        if (Mr != null) {
            if (Mr.nH()) {
                Mr.c(aVar);
            }
            Mr.nJ();
        }
    }

    public void a(int i, b.a aVar) {
        nF();
        if (Mr != null) {
            if (Mr.nH()) {
                Mr.c(aVar);
            }
            Mr.bc(i);
        }
    }

    public void nC() {
        nF();
        if (Mr != null) {
            Mr.nC();
            Mt = true;
        }
    }

    public void nD() {
        nF();
        if (Mr != null) {
            Mr.nD();
        }
    }

    public void nE() {
        nF();
        nD();
        nC();
    }

    private void nF() {
        if (Mr == null) {
        }
    }

    public static void nG() {
        try {
            if (Mr != null) {
                if (Ms != null) {
                    Ms.nE();
                }
                Mr.nI();
                Mr.nM();
                Mr = null;
            }
            if (Ms != null) {
                Ms = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
