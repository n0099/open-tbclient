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

        public static int aK(int i) {
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
            Kg.ne();
            Kg.nf();
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
            Kg.ne();
            Kg.nf();
            Ki = false;
        }
        return Kh;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        mZ();
        if (z) {
            mT();
        }
        if (z2) {
            mU();
        }
        ab(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        mZ();
        if (Kg != null) {
            Kg.a(tbPageContext, str, str2, str3);
        }
    }

    public void mT() {
        mZ();
        if (Kg != null) {
            Kg.ne();
            Ki = false;
        }
    }

    public void mU() {
        mZ();
        if (Kg != null) {
            Kg.nf();
            Ki = false;
        }
    }

    public void ab(boolean z) {
        mZ();
        if (Kg != null) {
            Kg.ab(z);
        }
    }

    public boolean mV() {
        mZ();
        if (Kg != null) {
            return Kg.mV();
        }
        return false;
    }

    public void a(b.a aVar) {
        mZ();
        if (Kg != null) {
            Kg.c(aVar);
        }
    }

    public void b(b.a aVar) {
        mZ();
        if (Kg != null) {
            if (Kg.nb()) {
                Kg.c(aVar);
            }
            Kg.nd();
        }
    }

    public void a(int i, b.a aVar) {
        mZ();
        if (Kg != null) {
            if (Kg.nb()) {
                Kg.c(aVar);
            }
            Kg.aL(i);
        }
    }

    public void mW() {
        mZ();
        if (Kg != null) {
            Kg.mW();
            Ki = true;
        }
    }

    public void mX() {
        mZ();
        if (Kg != null) {
            Kg.mX();
        }
    }

    public void mY() {
        mZ();
        mX();
        mW();
    }

    private void mZ() {
        if (Kg == null) {
        }
    }

    public static void na() {
        try {
            if (Kg != null) {
                if (Kh != null) {
                    Kh.mY();
                }
                Kg.nc();
                Kg.ng();
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
