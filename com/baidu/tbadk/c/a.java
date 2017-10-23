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
    private static b QO = null;
    private static a QP = null;
    private static boolean QR = false;
    private static String QS = "";
    private static transient List<String> QT = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0043a {
        private static SparseIntArray QU = new SparseIntArray();

        static {
            QU.put(2, 1);
            QU.put(4, 2);
            QU.put(8, 3);
            QU.put(12, 4);
            QU.put(16, 5);
            QU.put(20, 6);
            QU.put(24, 7);
        }

        public static int ba(int i) {
            return QU.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (QP == null) {
            synchronized (a.class) {
                if (QP == null) {
                    QP = new a();
                    QO = b.b(baseFragmentActivity);
                }
            }
        } else if (QO != null) {
            QO.a(baseFragmentActivity.getPageContext());
        }
        if (QR && QO != null) {
            QO.nO();
            QO.nP();
            QR = false;
        }
        return QP;
    }

    public static a b(BaseActivity baseActivity) {
        if (QP == null) {
            synchronized (a.class) {
                if (QP == null) {
                    QP = new a();
                    QO = b.c(baseActivity);
                }
            }
        } else if (QO != null) {
            QO.a(baseActivity.getPageContext());
        }
        if (QR && QO != null) {
            QO.nO();
            QO.nP();
            QR = false;
        }
        return QP;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        nJ();
        if (z) {
            nD();
        }
        if (z2) {
            nE();
        }
        ad(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        nJ();
        if (QO != null) {
            QO.a(tbPageContext, str, str2, str3);
        }
    }

    public void nD() {
        nJ();
        if (QO != null) {
            QO.nO();
            QR = false;
        }
    }

    public void nE() {
        nJ();
        if (QO != null) {
            QO.nP();
            QR = false;
        }
    }

    public void ad(boolean z) {
        nJ();
        if (QO != null) {
            QO.ad(z);
        }
    }

    public boolean nF() {
        nJ();
        if (QO != null) {
            return QO.nF();
        }
        return false;
    }

    public void a(b.a aVar) {
        nJ();
        if (QO != null) {
            QO.c(aVar);
        }
    }

    public void b(b.a aVar) {
        nJ();
        if (QO != null) {
            if (QO.nL()) {
                QO.c(aVar);
            }
            QO.nN();
        }
    }

    public void a(int i, b.a aVar) {
        nJ();
        if (QO != null) {
            if (QO.nL()) {
                QO.c(aVar);
            }
            QO.bb(i);
        }
    }

    public void nG() {
        nJ();
        if (QO != null) {
            QO.nG();
            QR = true;
        }
    }

    public void nH() {
        nJ();
        if (QO != null) {
            QO.nH();
        }
    }

    public void nI() {
        nJ();
        nH();
        nG();
    }

    private void nJ() {
        if (QO == null) {
        }
    }

    public static void nK() {
        try {
            if (QO != null) {
                if (QP != null) {
                    QP.nI();
                }
                QO.nM();
                QO.nQ();
                QO = null;
            }
            if (QP != null) {
                QP = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
