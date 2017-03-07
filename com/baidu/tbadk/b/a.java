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
    private static b QG = null;
    private static a QH = null;
    private static boolean QI = false;
    private static String QJ = "";
    private static transient List<String> QK = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0029a {
        private static SparseIntArray QL = new SparseIntArray();

        static {
            QL.put(2, 1);
            QL.put(4, 2);
            QL.put(8, 3);
            QL.put(12, 4);
            QL.put(16, 5);
            QL.put(20, 6);
            QL.put(24, 7);
        }

        public static int aV(int i) {
            return QL.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (QH == null) {
            synchronized (a.class) {
                if (QH == null) {
                    QH = new a();
                    QG = b.b(baseFragmentActivity);
                }
            }
        } else if (QG != null) {
            QG.a(baseFragmentActivity.getPageContext());
        }
        if (QI && QG != null) {
            QG.nW();
            QG.nX();
            QI = false;
        }
        return QH;
    }

    public static a b(BaseActivity baseActivity) {
        if (QH == null) {
            synchronized (a.class) {
                if (QH == null) {
                    QH = new a();
                    QG = b.c(baseActivity);
                }
            }
        } else if (QG != null) {
            QG.a(baseActivity.getPageContext());
        }
        if (QI && QG != null) {
            QG.nW();
            QG.nX();
            QI = false;
        }
        return QH;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        nR();
        if (z) {
            nL();
        }
        if (z2) {
            nM();
        }
        ad(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        nR();
        if (QG != null) {
            QG.a(tbPageContext, str, str2, str3);
        }
    }

    public void nL() {
        nR();
        if (QG != null) {
            QG.nW();
            QI = false;
        }
    }

    public void nM() {
        nR();
        if (QG != null) {
            QG.nX();
            QI = false;
        }
    }

    public void ad(boolean z) {
        nR();
        if (QG != null) {
            QG.ad(z);
        }
    }

    public boolean nN() {
        nR();
        if (QG != null) {
            return QG.nN();
        }
        return false;
    }

    public void a(b.a aVar) {
        nR();
        if (QG != null) {
            QG.c(aVar);
        }
    }

    public void b(b.a aVar) {
        nR();
        if (QG != null) {
            if (QG.nT()) {
                QG.c(aVar);
            }
            QG.nV();
        }
    }

    public void a(int i, b.a aVar) {
        nR();
        if (QG != null) {
            if (QG.nT()) {
                QG.c(aVar);
            }
            QG.aW(i);
        }
    }

    public void nO() {
        nR();
        if (QG != null) {
            QG.nO();
            QI = true;
        }
    }

    public void nP() {
        nR();
        if (QG != null) {
            QG.nP();
        }
    }

    public void nQ() {
        nR();
        nP();
        nO();
    }

    private void nR() {
        if (QG == null) {
        }
    }

    public static void nS() {
        try {
            if (QG != null) {
                if (QH != null) {
                    QH.nQ();
                }
                QG.nU();
                QG.nY();
                QG = null;
            }
            if (QH != null) {
                QH = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
