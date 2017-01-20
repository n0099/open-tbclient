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
    private static b LE = null;
    private static a LF = null;
    private static boolean LG = false;
    private static String LH = "";
    private static transient List<String> LI = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0030a {
        private static SparseIntArray LJ = new SparseIntArray();

        static {
            LJ.put(2, 1);
            LJ.put(4, 2);
            LJ.put(8, 3);
            LJ.put(12, 4);
            LJ.put(16, 5);
            LJ.put(20, 6);
            LJ.put(24, 7);
        }

        public static int bb(int i) {
            return LJ.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (LF == null) {
            synchronized (a.class) {
                if (LF == null) {
                    LF = new a();
                    LE = b.b(baseFragmentActivity);
                }
            }
        } else if (LE != null) {
            LE.a(baseFragmentActivity.getPageContext());
        }
        if (LG && LE != null) {
            LE.nI();
            LE.nJ();
            LG = false;
        }
        return LF;
    }

    public static a b(BaseActivity baseActivity) {
        if (LF == null) {
            synchronized (a.class) {
                if (LF == null) {
                    LF = new a();
                    LE = b.c(baseActivity);
                }
            }
        } else if (LE != null) {
            LE.a(baseActivity.getPageContext());
        }
        if (LG && LE != null) {
            LE.nI();
            LE.nJ();
            LG = false;
        }
        return LF;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        nD();
        if (z) {
            nx();
        }
        if (z2) {
            ny();
        }
        ae(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        nD();
        if (LE != null) {
            LE.a(tbPageContext, str, str2, str3);
        }
    }

    public void nx() {
        nD();
        if (LE != null) {
            LE.nI();
            LG = false;
        }
    }

    public void ny() {
        nD();
        if (LE != null) {
            LE.nJ();
            LG = false;
        }
    }

    public void ae(boolean z) {
        nD();
        if (LE != null) {
            LE.ae(z);
        }
    }

    public boolean nz() {
        nD();
        if (LE != null) {
            return LE.nz();
        }
        return false;
    }

    public void a(b.a aVar) {
        nD();
        if (LE != null) {
            LE.c(aVar);
        }
    }

    public void b(b.a aVar) {
        nD();
        if (LE != null) {
            if (LE.nF()) {
                LE.c(aVar);
            }
            LE.nH();
        }
    }

    public void a(int i, b.a aVar) {
        nD();
        if (LE != null) {
            if (LE.nF()) {
                LE.c(aVar);
            }
            LE.bc(i);
        }
    }

    public void nA() {
        nD();
        if (LE != null) {
            LE.nA();
            LG = true;
        }
    }

    public void nB() {
        nD();
        if (LE != null) {
            LE.nB();
        }
    }

    public void nC() {
        nD();
        nB();
        nA();
    }

    private void nD() {
        if (LE == null) {
        }
    }

    public static void nE() {
        try {
            if (LE != null) {
                if (LF != null) {
                    LF.nC();
                }
                LE.nG();
                LE.nK();
                LE = null;
            }
            if (LF != null) {
                LF = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
