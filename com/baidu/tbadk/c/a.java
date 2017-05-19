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
    private static b Qs = null;
    private static a Qt = null;
    private static boolean Qu = false;
    private static String Qv = "";
    private static transient List<String> Qw = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0034a {
        private static SparseIntArray Qx = new SparseIntArray();

        static {
            Qx.put(2, 1);
            Qx.put(4, 2);
            Qx.put(8, 3);
            Qx.put(12, 4);
            Qx.put(16, 5);
            Qx.put(20, 6);
            Qx.put(24, 7);
        }

        public static int aV(int i) {
            return Qx.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (Qt == null) {
            synchronized (a.class) {
                if (Qt == null) {
                    Qt = new a();
                    Qs = b.b(baseFragmentActivity);
                }
            }
        } else if (Qs != null) {
            Qs.a(baseFragmentActivity.getPageContext());
        }
        if (Qu && Qs != null) {
            Qs.oa();
            Qs.ob();
            Qu = false;
        }
        return Qt;
    }

    public static a b(BaseActivity baseActivity) {
        if (Qt == null) {
            synchronized (a.class) {
                if (Qt == null) {
                    Qt = new a();
                    Qs = b.c(baseActivity);
                }
            }
        } else if (Qs != null) {
            Qs.a(baseActivity.getPageContext());
        }
        if (Qu && Qs != null) {
            Qs.oa();
            Qs.ob();
            Qu = false;
        }
        return Qt;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        nV();
        if (z) {
            nP();
        }
        if (z2) {
            nQ();
        }
        ae(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        nV();
        if (Qs != null) {
            Qs.a(tbPageContext, str, str2, str3);
        }
    }

    public void nP() {
        nV();
        if (Qs != null) {
            Qs.oa();
            Qu = false;
        }
    }

    public void nQ() {
        nV();
        if (Qs != null) {
            Qs.ob();
            Qu = false;
        }
    }

    public void ae(boolean z) {
        nV();
        if (Qs != null) {
            Qs.ae(z);
        }
    }

    public boolean nR() {
        nV();
        if (Qs != null) {
            return Qs.nR();
        }
        return false;
    }

    public void a(b.a aVar) {
        nV();
        if (Qs != null) {
            Qs.c(aVar);
        }
    }

    public void b(b.a aVar) {
        nV();
        if (Qs != null) {
            if (Qs.nX()) {
                Qs.c(aVar);
            }
            Qs.nZ();
        }
    }

    public void a(int i, b.a aVar) {
        nV();
        if (Qs != null) {
            if (Qs.nX()) {
                Qs.c(aVar);
            }
            Qs.aW(i);
        }
    }

    public void nS() {
        nV();
        if (Qs != null) {
            Qs.nS();
            Qu = true;
        }
    }

    public void nT() {
        nV();
        if (Qs != null) {
            Qs.nT();
        }
    }

    public void nU() {
        nV();
        nT();
        nS();
    }

    private void nV() {
        if (Qs == null) {
        }
    }

    public static void nW() {
        try {
            if (Qs != null) {
                if (Qt != null) {
                    Qt.nU();
                }
                Qs.nY();
                Qs.oc();
                Qs = null;
            }
            if (Qt != null) {
                Qt = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
