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
    private static b RL = null;
    private static a RO = null;
    private static boolean RP = false;
    private static String RQ = "";
    private static transient List<String> RR = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0042a {
        private static SparseIntArray RS = new SparseIntArray();

        static {
            RS.put(2, 1);
            RS.put(4, 2);
            RS.put(8, 3);
            RS.put(12, 4);
            RS.put(16, 5);
            RS.put(20, 6);
            RS.put(24, 7);
        }

        public static int ba(int i) {
            return RS.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (RO == null) {
            synchronized (a.class) {
                if (RO == null) {
                    RO = new a();
                    RL = b.b(baseFragmentActivity);
                }
            }
        } else if (RL != null) {
            RL.a(baseFragmentActivity.getPageContext());
        }
        if (RP && RL != null) {
            RL.nY();
            RL.nZ();
            RP = false;
        }
        return RO;
    }

    public static a b(BaseActivity baseActivity) {
        if (RO == null) {
            synchronized (a.class) {
                if (RO == null) {
                    RO = new a();
                    RL = b.c(baseActivity);
                }
            }
        } else if (RL != null) {
            RL.a(baseActivity.getPageContext());
        }
        if (RP && RL != null) {
            RL.nY();
            RL.nZ();
            RP = false;
        }
        return RO;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        nT();
        if (z) {
            nN();
        }
        if (z2) {
            nO();
        }
        ac(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        nT();
        if (RL != null) {
            RL.a(tbPageContext, str, str2, str3);
        }
    }

    public void nN() {
        nT();
        if (RL != null) {
            RL.nY();
            RP = false;
        }
    }

    public void nO() {
        nT();
        if (RL != null) {
            RL.nZ();
            RP = false;
        }
    }

    public void ac(boolean z) {
        nT();
        if (RL != null) {
            RL.ac(z);
        }
    }

    public boolean nP() {
        nT();
        if (RL != null) {
            return RL.nP();
        }
        return false;
    }

    public void a(b.a aVar) {
        nT();
        if (RL != null) {
            RL.c(aVar);
        }
    }

    public void b(b.a aVar) {
        nT();
        if (RL != null) {
            if (RL.nV()) {
                RL.c(aVar);
            }
            RL.nX();
        }
    }

    public void a(int i, b.a aVar) {
        nT();
        if (RL != null) {
            if (RL.nV()) {
                RL.c(aVar);
            }
            RL.bb(i);
        }
    }

    public void nQ() {
        nT();
        if (RL != null) {
            RL.nQ();
            RP = true;
        }
    }

    public void nR() {
        nT();
        if (RL != null) {
            RL.nR();
        }
    }

    public void nS() {
        nT();
        nR();
        nQ();
    }

    private void nT() {
        if (RL == null) {
        }
    }

    public static void nU() {
        try {
            if (RL != null) {
                if (RO != null) {
                    RO.nS();
                }
                RL.nW();
                RL.oa();
                RL = null;
            }
            if (RO != null) {
                RO = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
