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
    private static b Rb = null;
    private static a Rc = null;
    private static boolean Rd = false;
    private static String Re = "";
    private static transient List<String> Rf = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0029a {
        private static SparseIntArray Rg = new SparseIntArray();

        static {
            Rg.put(2, 1);
            Rg.put(4, 2);
            Rg.put(8, 3);
            Rg.put(12, 4);
            Rg.put(16, 5);
            Rg.put(20, 6);
            Rg.put(24, 7);
        }

        public static int aY(int i) {
            return Rg.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (Rc == null) {
            synchronized (a.class) {
                if (Rc == null) {
                    Rc = new a();
                    Rb = b.b(baseFragmentActivity);
                }
            }
        } else if (Rb != null) {
            Rb.a(baseFragmentActivity.getPageContext());
        }
        if (Rd && Rb != null) {
            Rb.ot();
            Rb.ou();
            Rd = false;
        }
        return Rc;
    }

    public static a b(BaseActivity baseActivity) {
        if (Rc == null) {
            synchronized (a.class) {
                if (Rc == null) {
                    Rc = new a();
                    Rb = b.c(baseActivity);
                }
            }
        } else if (Rb != null) {
            Rb.a(baseActivity.getPageContext());
        }
        if (Rd && Rb != null) {
            Rb.ot();
            Rb.ou();
            Rd = false;
        }
        return Rc;
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
        if (Rb != null) {
            Rb.a(tbPageContext, str, str2, str3);
        }
    }

    public void oi() {
        oo();
        if (Rb != null) {
            Rb.ot();
            Rd = false;
        }
    }

    public void oj() {
        oo();
        if (Rb != null) {
            Rb.ou();
            Rd = false;
        }
    }

    public void af(boolean z) {
        oo();
        if (Rb != null) {
            Rb.af(z);
        }
    }

    public boolean ok() {
        oo();
        if (Rb != null) {
            return Rb.ok();
        }
        return false;
    }

    public void a(b.a aVar) {
        oo();
        if (Rb != null) {
            Rb.c(aVar);
        }
    }

    public void b(b.a aVar) {
        oo();
        if (Rb != null) {
            if (Rb.oq()) {
                Rb.c(aVar);
            }
            Rb.os();
        }
    }

    public void a(int i, b.a aVar) {
        oo();
        if (Rb != null) {
            if (Rb.oq()) {
                Rb.c(aVar);
            }
            Rb.aZ(i);
        }
    }

    public void ol() {
        oo();
        if (Rb != null) {
            Rb.ol();
            Rd = true;
        }
    }

    public void om() {
        oo();
        if (Rb != null) {
            Rb.om();
        }
    }

    public void on() {
        oo();
        om();
        ol();
    }

    private void oo() {
        if (Rb == null) {
        }
    }

    public static void op() {
        try {
            if (Rb != null) {
                if (Rc != null) {
                    Rc.on();
                }
                Rb.or();
                Rb.ov();
                Rb = null;
            }
            if (Rc != null) {
                Rc = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
