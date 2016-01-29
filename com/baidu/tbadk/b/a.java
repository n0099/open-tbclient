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
    private static b RU = null;
    private static a RV = null;
    private static boolean RW = false;
    private static String RX = "";
    private static transient List<String> RY = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0040a {
        private static SparseIntArray RZ = new SparseIntArray();

        static {
            RZ.put(2, 1);
            RZ.put(4, 2);
            RZ.put(8, 3);
            RZ.put(12, 4);
            RZ.put(16, 5);
            RZ.put(20, 6);
            RZ.put(24, 7);
        }

        public static int aX(int i) {
            return RZ.get(i);
        }
    }

    private a() {
    }

    public static a a(BaseFragmentActivity baseFragmentActivity) {
        if (RV == null) {
            synchronized (a.class) {
                if (RV == null) {
                    RV = new a();
                    RU = b.b(baseFragmentActivity);
                }
            }
        } else if (RU != null) {
            RU.a(baseFragmentActivity.getPageContext());
        }
        if (RW && RU != null) {
            RU.qv();
            RU.qw();
            RW = false;
        }
        return RV;
    }

    public static a b(BaseActivity baseActivity) {
        if (RV == null) {
            synchronized (a.class) {
                if (RV == null) {
                    RV = new a();
                    RU = b.c(baseActivity);
                }
            }
        } else if (RU != null) {
            RU.a(baseActivity.getPageContext());
        }
        if (RW && RU != null) {
            RU.qv();
            RU.qw();
            RW = false;
        }
        return RV;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        qq();
        if (z) {
            qk();
        }
        if (z2) {
            ql();
        }
        Z(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        qq();
        if (RU != null) {
            RU.a(tbPageContext, str, str2, str3);
        }
    }

    public void qk() {
        qq();
        if (RU != null) {
            RU.qv();
            RW = false;
        }
    }

    public void ql() {
        qq();
        if (RU != null) {
            RU.qw();
            RW = false;
        }
    }

    public void Z(boolean z) {
        qq();
        if (RU != null) {
            RU.Z(z);
        }
    }

    public boolean qm() {
        qq();
        if (RU != null) {
            return RU.qm();
        }
        return false;
    }

    public void a(b.a aVar) {
        qq();
        if (RU != null) {
            RU.c(aVar);
        }
    }

    public void b(b.a aVar) {
        qq();
        if (RU != null) {
            if (RU.qs()) {
                RU.c(aVar);
            }
            RU.qu();
        }
    }

    public void a(int i, b.a aVar) {
        qq();
        if (RU != null) {
            if (RU.qs()) {
                RU.c(aVar);
            }
            RU.aY(i);
        }
    }

    public void qn() {
        qq();
        if (RU != null) {
            RU.qn();
            RW = true;
        }
    }

    public void qo() {
        qq();
        if (RU != null) {
            RU.qo();
        }
    }

    public void qp() {
        qq();
        qo();
        qn();
    }

    private void qq() {
        if (RU == null) {
        }
    }

    public static void qr() {
        try {
            if (RU != null) {
                if (RV != null) {
                    RV.qp();
                }
                RU.qt();
                RU.resetValues();
                RU = null;
            }
            if (RV != null) {
                RV = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
