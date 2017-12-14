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
    private static b RH = null;
    private static a RI = null;
    private static boolean RJ = false;
    private static String RK = "";
    private static transient List<String> RL = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0056a {
        private static SparseIntArray RO = new SparseIntArray();

        static {
            RO.put(2, 1);
            RO.put(4, 2);
            RO.put(8, 3);
            RO.put(12, 4);
            RO.put(16, 5);
            RO.put(20, 6);
            RO.put(24, 7);
        }

        public static int ba(int i) {
            return RO.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (RI == null) {
            synchronized (a.class) {
                if (RI == null) {
                    RI = new a();
                    RH = b.b(baseFragmentActivity);
                }
            }
        } else if (RH != null) {
            RH.a(baseFragmentActivity.getPageContext());
        }
        if (RJ && RH != null) {
            RH.nW();
            RH.nX();
            RJ = false;
        }
        return RI;
    }

    public static a b(BaseActivity baseActivity) {
        if (RI == null) {
            synchronized (a.class) {
                if (RI == null) {
                    RI = new a();
                    RH = b.c(baseActivity);
                }
            }
        } else if (RH != null) {
            RH.a(baseActivity.getPageContext());
        }
        if (RJ && RH != null) {
            RH.nW();
            RH.nX();
            RJ = false;
        }
        return RI;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        nR();
        if (z) {
            nL();
        }
        if (z2) {
            nM();
        }
        ac(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        nR();
        if (RH != null) {
            RH.a(tbPageContext, str, str2, str3);
        }
    }

    public void nL() {
        nR();
        if (RH != null) {
            RH.nW();
            RJ = false;
        }
    }

    public void nM() {
        nR();
        if (RH != null) {
            RH.nX();
            RJ = false;
        }
    }

    public void ac(boolean z) {
        nR();
        if (RH != null) {
            RH.ac(z);
        }
    }

    public boolean nN() {
        nR();
        if (RH != null) {
            return RH.nN();
        }
        return false;
    }

    public void a(b.a aVar) {
        nR();
        if (RH != null) {
            RH.c(aVar);
        }
    }

    public void b(b.a aVar) {
        nR();
        if (RH != null) {
            if (RH.nT()) {
                RH.c(aVar);
            }
            RH.nV();
        }
    }

    public void a(int i, b.a aVar) {
        nR();
        if (RH != null) {
            if (RH.nT()) {
                RH.c(aVar);
            }
            RH.bb(i);
        }
    }

    public void nO() {
        nR();
        if (RH != null) {
            RH.nO();
            RJ = true;
        }
    }

    public void nP() {
        nR();
        if (RH != null) {
            RH.nP();
        }
    }

    public void nQ() {
        nR();
        nP();
        nO();
    }

    private void nR() {
        if (RH == null) {
        }
    }

    public static void nS() {
        try {
            if (RH != null) {
                if (RI != null) {
                    RI.nQ();
                }
                RH.nU();
                RH.nY();
                RH = null;
            }
            if (RI != null) {
                RI = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
