package com.baidu.tbadk.c;

import com.baidu.tbadk.c.b;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private static b aaY = null;
    private static a aaZ = null;
    private static boolean aba = false;
    private static String abb = "";
    private static transient List<String> abd = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (aaZ == null) {
            synchronized (a.class) {
                if (aaZ == null) {
                    aaZ = new a();
                    aaY = b.c(baseFragmentActivity);
                }
            }
        } else if (aaY != null) {
            aaY.setContext(baseFragmentActivity.getPageContext());
        }
        if (aba && aaY != null) {
            aaY.sp();
            aaY.sq();
            aba = false;
        }
        return aaZ;
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
        if (aaY != null) {
            aaY.sp();
            aba = false;
        }
    }

    public void sh() {
        sl();
        if (aaY != null) {
            aaY.sq();
            aba = false;
        }
    }

    public void ai(boolean z) {
        sl();
        if (aaY != null) {
            aaY.ai(z);
        }
    }

    public void a(b.a aVar) {
        sl();
        if (aaY != null) {
            aaY.c(aVar);
        }
    }

    public void b(b.a aVar) {
        sl();
        if (aaY != null) {
            if (aaY.sm()) {
                aaY.c(aVar);
            }
            aaY.so();
        }
    }

    public void a(int i, b.a aVar) {
        sl();
        if (aaY != null) {
            if (aaY.sm()) {
                aaY.c(aVar);
            }
            aaY.ba(i);
        }
    }

    public void si() {
        sl();
        if (aaY != null) {
            aaY.si();
            aba = true;
        }
    }

    public void sj() {
        sl();
        if (aaY != null) {
            aaY.sj();
        }
    }

    public void sk() {
        sl();
        sj();
        si();
    }

    private void sl() {
        if (aaY == null) {
        }
    }

    public static void resetAll() {
        try {
            if (aaY != null) {
                if (aaZ != null) {
                    aaZ.sk();
                }
                aaY.sn();
                aaY.sr();
                aaY = null;
            }
            if (aaZ != null) {
                aaZ = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
