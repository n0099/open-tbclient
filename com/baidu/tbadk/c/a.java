package com.baidu.tbadk.c;

import com.baidu.tbadk.c.b;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static b aaV = null;
    private static a aaW = null;
    private static boolean aaX = false;
    private static String aaY = "";
    private static transient List<String> aaZ = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (aaW == null) {
            synchronized (a.class) {
                if (aaW == null) {
                    aaW = new a();
                    aaV = b.c(baseFragmentActivity);
                }
            }
        } else if (aaV != null) {
            aaV.setContext(baseFragmentActivity.getPageContext());
        }
        if (aaX && aaV != null) {
            aaV.sp();
            aaV.sq();
            aaX = false;
        }
        return aaW;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        sl();
        if (z) {
            sg();
        }
        if (z2) {
            sh();
        }
        ai(z3);
        a(aVar);
    }

    public void sg() {
        sl();
        if (aaV != null) {
            aaV.sp();
            aaX = false;
        }
    }

    public void sh() {
        sl();
        if (aaV != null) {
            aaV.sq();
            aaX = false;
        }
    }

    public void ai(boolean z) {
        sl();
        if (aaV != null) {
            aaV.ai(z);
        }
    }

    public void a(b.a aVar) {
        sl();
        if (aaV != null) {
            aaV.c(aVar);
        }
    }

    public void b(b.a aVar) {
        sl();
        if (aaV != null) {
            if (aaV.sm()) {
                aaV.c(aVar);
            }
            aaV.so();
        }
    }

    public void a(int i, b.a aVar) {
        sl();
        if (aaV != null) {
            if (aaV.sm()) {
                aaV.c(aVar);
            }
            aaV.ba(i);
        }
    }

    public void si() {
        sl();
        if (aaV != null) {
            aaV.si();
            aaX = true;
        }
    }

    public void sj() {
        sl();
        if (aaV != null) {
            aaV.sj();
        }
    }

    public void sk() {
        sl();
        sj();
        si();
    }

    private void sl() {
        if (aaV == null) {
        }
    }

    public static void resetAll() {
        try {
            if (aaV != null) {
                if (aaW != null) {
                    aaW.sk();
                }
                aaV.sn();
                aaV.sr();
                aaV = null;
            }
            if (aaW != null) {
                aaW = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
