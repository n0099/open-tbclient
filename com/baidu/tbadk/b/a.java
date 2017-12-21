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
    private static b RI = null;
    private static a RJ = null;
    private static boolean RK = false;
    private static String RL = "";
    private static transient List<String> RO = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0055a {
        private static SparseIntArray RP = new SparseIntArray();

        static {
            RP.put(2, 1);
            RP.put(4, 2);
            RP.put(8, 3);
            RP.put(12, 4);
            RP.put(16, 5);
            RP.put(20, 6);
            RP.put(24, 7);
        }

        public static int ba(int i) {
            return RP.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (RJ == null) {
            synchronized (a.class) {
                if (RJ == null) {
                    RJ = new a();
                    RI = b.b(baseFragmentActivity);
                }
            }
        } else if (RI != null) {
            RI.a(baseFragmentActivity.getPageContext());
        }
        if (RK && RI != null) {
            RI.nW();
            RI.nX();
            RK = false;
        }
        return RJ;
    }

    public static a b(BaseActivity baseActivity) {
        if (RJ == null) {
            synchronized (a.class) {
                if (RJ == null) {
                    RJ = new a();
                    RI = b.c(baseActivity);
                }
            }
        } else if (RI != null) {
            RI.a(baseActivity.getPageContext());
        }
        if (RK && RI != null) {
            RI.nW();
            RI.nX();
            RK = false;
        }
        return RJ;
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
        if (RI != null) {
            RI.a(tbPageContext, str, str2, str3);
        }
    }

    public void nL() {
        nR();
        if (RI != null) {
            RI.nW();
            RK = false;
        }
    }

    public void nM() {
        nR();
        if (RI != null) {
            RI.nX();
            RK = false;
        }
    }

    public void ac(boolean z) {
        nR();
        if (RI != null) {
            RI.ac(z);
        }
    }

    public boolean nN() {
        nR();
        if (RI != null) {
            return RI.nN();
        }
        return false;
    }

    public void a(b.a aVar) {
        nR();
        if (RI != null) {
            RI.c(aVar);
        }
    }

    public void b(b.a aVar) {
        nR();
        if (RI != null) {
            if (RI.nT()) {
                RI.c(aVar);
            }
            RI.nV();
        }
    }

    public void a(int i, b.a aVar) {
        nR();
        if (RI != null) {
            if (RI.nT()) {
                RI.c(aVar);
            }
            RI.bb(i);
        }
    }

    public void nO() {
        nR();
        if (RI != null) {
            RI.nO();
            RK = true;
        }
    }

    public void nP() {
        nR();
        if (RI != null) {
            RI.nP();
        }
    }

    public void nQ() {
        nR();
        nP();
        nO();
    }

    private void nR() {
        if (RI == null) {
        }
    }

    public static void nS() {
        try {
            if (RI != null) {
                if (RJ != null) {
                    RJ.nQ();
                }
                RI.nU();
                RI.nY();
                RI = null;
            }
            if (RJ != null) {
                RJ = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
