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
    private static b Kf = null;
    private static a Kg = null;
    private static boolean Kh = false;
    private static String Ki = "";
    private static transient List<String> Kj = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0031a {
        private static SparseIntArray Kk = new SparseIntArray();

        static {
            Kk.put(2, 1);
            Kk.put(4, 2);
            Kk.put(8, 3);
            Kk.put(12, 4);
            Kk.put(16, 5);
            Kk.put(20, 6);
            Kk.put(24, 7);
        }

        public static int aO(int i) {
            return Kk.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (Kg == null) {
            synchronized (a.class) {
                if (Kg == null) {
                    Kg = new a();
                    Kf = b.b(baseFragmentActivity);
                }
            }
        } else if (Kf != null) {
            Kf.a(baseFragmentActivity.getPageContext());
        }
        if (Kh && Kf != null) {
            Kf.mP();
            Kf.mQ();
            Kh = false;
        }
        return Kg;
    }

    public static a b(BaseActivity baseActivity) {
        if (Kg == null) {
            synchronized (a.class) {
                if (Kg == null) {
                    Kg = new a();
                    Kf = b.c(baseActivity);
                }
            }
        } else if (Kf != null) {
            Kf.a(baseActivity.getPageContext());
        }
        if (Kh && Kf != null) {
            Kf.mP();
            Kf.mQ();
            Kh = false;
        }
        return Kg;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        mK();
        if (z) {
            mE();
        }
        if (z2) {
            mF();
        }
        ac(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        mK();
        if (Kf != null) {
            Kf.a(tbPageContext, str, str2, str3);
        }
    }

    public void mE() {
        mK();
        if (Kf != null) {
            Kf.mP();
            Kh = false;
        }
    }

    public void mF() {
        mK();
        if (Kf != null) {
            Kf.mQ();
            Kh = false;
        }
    }

    public void ac(boolean z) {
        mK();
        if (Kf != null) {
            Kf.ac(z);
        }
    }

    public boolean mG() {
        mK();
        if (Kf != null) {
            return Kf.mG();
        }
        return false;
    }

    public void a(b.a aVar) {
        mK();
        if (Kf != null) {
            Kf.c(aVar);
        }
    }

    public void b(b.a aVar) {
        mK();
        if (Kf != null) {
            if (Kf.mM()) {
                Kf.c(aVar);
            }
            Kf.mO();
        }
    }

    public void a(int i, b.a aVar) {
        mK();
        if (Kf != null) {
            if (Kf.mM()) {
                Kf.c(aVar);
            }
            Kf.aP(i);
        }
    }

    public void mH() {
        mK();
        if (Kf != null) {
            Kf.mH();
            Kh = true;
        }
    }

    public void mI() {
        mK();
        if (Kf != null) {
            Kf.mI();
        }
    }

    public void mJ() {
        mK();
        mI();
        mH();
    }

    private void mK() {
        if (Kf == null) {
        }
    }

    public static void mL() {
        try {
            if (Kf != null) {
                if (Kg != null) {
                    Kg.mJ();
                }
                Kf.mN();
                Kf.mR();
                Kf = null;
            }
            if (Kg != null) {
                Kg = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
