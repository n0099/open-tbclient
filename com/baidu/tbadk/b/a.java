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
    private static b Pp = null;
    private static a Pq = null;
    private static boolean Pr = false;
    private static String Ps = "";
    private static transient List<String> Pt = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0040a {
        private static SparseIntArray Pu = new SparseIntArray();

        static {
            Pu.put(2, 1);
            Pu.put(4, 2);
            Pu.put(8, 3);
            Pu.put(12, 4);
            Pu.put(16, 5);
            Pu.put(20, 6);
            Pu.put(24, 7);
        }

        public static int aW(int i) {
            return Pu.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (Pq == null) {
            synchronized (a.class) {
                if (Pq == null) {
                    Pq = new a();
                    Pp = b.b(baseFragmentActivity);
                }
            }
        } else if (Pp != null) {
            Pp.a(baseFragmentActivity.getPageContext());
        }
        if (Pr && Pp != null) {
            Pp.pJ();
            Pp.pK();
            Pr = false;
        }
        return Pq;
    }

    public static a b(BaseActivity baseActivity) {
        if (Pq == null) {
            synchronized (a.class) {
                if (Pq == null) {
                    Pq = new a();
                    Pp = b.c(baseActivity);
                }
            }
        } else if (Pp != null) {
            Pp.a(baseActivity.getPageContext());
        }
        if (Pr && Pp != null) {
            Pp.pJ();
            Pp.pK();
            Pr = false;
        }
        return Pq;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        pE();
        if (z) {
            py();
        }
        if (z2) {
            pz();
        }
        Y(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        pE();
        if (Pp != null) {
            Pp.a(tbPageContext, str, str2, str3);
        }
    }

    public void py() {
        pE();
        if (Pp != null) {
            Pp.pJ();
            Pr = false;
        }
    }

    public void pz() {
        pE();
        if (Pp != null) {
            Pp.pK();
            Pr = false;
        }
    }

    public void Y(boolean z) {
        pE();
        if (Pp != null) {
            Pp.Y(z);
        }
    }

    public boolean pA() {
        pE();
        if (Pp != null) {
            return Pp.pA();
        }
        return false;
    }

    public void a(b.a aVar) {
        pE();
        if (Pp != null) {
            Pp.c(aVar);
        }
    }

    public void b(b.a aVar) {
        pE();
        if (Pp != null) {
            if (Pp.pG()) {
                Pp.c(aVar);
            }
            Pp.pI();
        }
    }

    public void a(int i, b.a aVar) {
        pE();
        if (Pp != null) {
            if (Pp.pG()) {
                Pp.c(aVar);
            }
            Pp.aX(i);
        }
    }

    public void pB() {
        pE();
        if (Pp != null) {
            Pp.pB();
            Pr = true;
        }
    }

    public void pC() {
        pE();
        if (Pp != null) {
            Pp.pC();
        }
    }

    public void pD() {
        pE();
        pC();
        pB();
    }

    private void pE() {
        if (Pp == null) {
        }
    }

    public static void pF() {
        try {
            if (Pp != null) {
                if (Pq != null) {
                    Pq.pD();
                }
                Pp.pH();
                Pp.resetValues();
                Pp = null;
            }
            if (Pq != null) {
                Pq = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
