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
    private static b Kg = null;
    private static a Kh = null;
    private static boolean Ki = false;
    private static String Kj = "";
    private static transient List<String> Kk = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0031a {
        private static SparseIntArray Kl = new SparseIntArray();

        static {
            Kl.put(2, 1);
            Kl.put(4, 2);
            Kl.put(8, 3);
            Kl.put(12, 4);
            Kl.put(16, 5);
            Kl.put(20, 6);
            Kl.put(24, 7);
        }

        public static int aL(int i) {
            return Kl.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (Kh == null) {
            synchronized (a.class) {
                if (Kh == null) {
                    Kh = new a();
                    Kg = b.b(baseFragmentActivity);
                }
            }
        } else if (Kg != null) {
            Kg.a(baseFragmentActivity.getPageContext());
        }
        if (Ki && Kg != null) {
            Kg.mZ();
            Kg.na();
            Ki = false;
        }
        return Kh;
    }

    public static a b(BaseActivity baseActivity) {
        if (Kh == null) {
            synchronized (a.class) {
                if (Kh == null) {
                    Kh = new a();
                    Kg = b.c(baseActivity);
                }
            }
        } else if (Kg != null) {
            Kg.a(baseActivity.getPageContext());
        }
        if (Ki && Kg != null) {
            Kg.mZ();
            Kg.na();
            Ki = false;
        }
        return Kh;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        mU();
        if (z) {
            mO();
        }
        if (z2) {
            mP();
        }
        aa(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        mU();
        if (Kg != null) {
            Kg.a(tbPageContext, str, str2, str3);
        }
    }

    public void mO() {
        mU();
        if (Kg != null) {
            Kg.mZ();
            Ki = false;
        }
    }

    public void mP() {
        mU();
        if (Kg != null) {
            Kg.na();
            Ki = false;
        }
    }

    public void aa(boolean z) {
        mU();
        if (Kg != null) {
            Kg.aa(z);
        }
    }

    public boolean mQ() {
        mU();
        if (Kg != null) {
            return Kg.mQ();
        }
        return false;
    }

    public void a(b.a aVar) {
        mU();
        if (Kg != null) {
            Kg.c(aVar);
        }
    }

    public void b(b.a aVar) {
        mU();
        if (Kg != null) {
            if (Kg.mW()) {
                Kg.c(aVar);
            }
            Kg.mY();
        }
    }

    public void a(int i, b.a aVar) {
        mU();
        if (Kg != null) {
            if (Kg.mW()) {
                Kg.c(aVar);
            }
            Kg.aM(i);
        }
    }

    public void mR() {
        mU();
        if (Kg != null) {
            Kg.mR();
            Ki = true;
        }
    }

    public void mS() {
        mU();
        if (Kg != null) {
            Kg.mS();
        }
    }

    public void mT() {
        mU();
        mS();
        mR();
    }

    private void mU() {
        if (Kg == null) {
        }
    }

    public static void mV() {
        try {
            if (Kg != null) {
                if (Kh != null) {
                    Kh.mT();
                }
                Kg.mX();
                Kg.nb();
                Kg = null;
            }
            if (Kh != null) {
                Kh = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
