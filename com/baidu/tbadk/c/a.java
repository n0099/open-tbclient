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
    private static b QZ = null;
    private static a Ra = null;
    private static boolean Rb = false;
    private static String Rc = "";
    private static transient List<String> Rd = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0029a {
        private static SparseIntArray Re = new SparseIntArray();

        static {
            Re.put(2, 1);
            Re.put(4, 2);
            Re.put(8, 3);
            Re.put(12, 4);
            Re.put(16, 5);
            Re.put(20, 6);
            Re.put(24, 7);
        }

        public static int aY(int i) {
            return Re.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (Ra == null) {
            synchronized (a.class) {
                if (Ra == null) {
                    Ra = new a();
                    QZ = b.b(baseFragmentActivity);
                }
            }
        } else if (QZ != null) {
            QZ.a(baseFragmentActivity.getPageContext());
        }
        if (Rb && QZ != null) {
            QZ.ot();
            QZ.ou();
            Rb = false;
        }
        return Ra;
    }

    public static a b(BaseActivity baseActivity) {
        if (Ra == null) {
            synchronized (a.class) {
                if (Ra == null) {
                    Ra = new a();
                    QZ = b.c(baseActivity);
                }
            }
        } else if (QZ != null) {
            QZ.a(baseActivity.getPageContext());
        }
        if (Rb && QZ != null) {
            QZ.ot();
            QZ.ou();
            Rb = false;
        }
        return Ra;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        oo();
        if (z) {
            oi();
        }
        if (z2) {
            oj();
        }
        af(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        oo();
        if (QZ != null) {
            QZ.a(tbPageContext, str, str2, str3);
        }
    }

    public void oi() {
        oo();
        if (QZ != null) {
            QZ.ot();
            Rb = false;
        }
    }

    public void oj() {
        oo();
        if (QZ != null) {
            QZ.ou();
            Rb = false;
        }
    }

    public void af(boolean z) {
        oo();
        if (QZ != null) {
            QZ.af(z);
        }
    }

    public boolean ok() {
        oo();
        if (QZ != null) {
            return QZ.ok();
        }
        return false;
    }

    public void a(b.a aVar) {
        oo();
        if (QZ != null) {
            QZ.c(aVar);
        }
    }

    public void b(b.a aVar) {
        oo();
        if (QZ != null) {
            if (QZ.oq()) {
                QZ.c(aVar);
            }
            QZ.os();
        }
    }

    public void a(int i, b.a aVar) {
        oo();
        if (QZ != null) {
            if (QZ.oq()) {
                QZ.c(aVar);
            }
            QZ.aZ(i);
        }
    }

    public void ol() {
        oo();
        if (QZ != null) {
            QZ.ol();
            Rb = true;
        }
    }

    public void om() {
        oo();
        if (QZ != null) {
            QZ.om();
        }
    }

    public void on() {
        oo();
        om();
        ol();
    }

    private void oo() {
        if (QZ == null) {
        }
    }

    public static void op() {
        try {
            if (QZ != null) {
                if (Ra != null) {
                    Ra.on();
                }
                QZ.or();
                QZ.ov();
                QZ = null;
            }
            if (Ra != null) {
                Ra = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
