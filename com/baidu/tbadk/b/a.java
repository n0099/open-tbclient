package com.baidu.tbadk.b;

import com.baidu.tbadk.b.b;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static b aHz = null;
    private static a aHA = null;
    private static boolean aHB = false;
    private static String aHC = "";
    private static transient List<String> aHD = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (aHA == null) {
            synchronized (a.class) {
                if (aHA == null) {
                    aHA = new a();
                    aHz = b.c(baseFragmentActivity);
                }
            }
        } else if (aHz != null) {
            aHz.setContext(baseFragmentActivity.getPageContext());
        }
        if (aHB && aHz != null) {
            aHz.wl();
            aHz.wm();
            aHB = false;
        }
        return aHA;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        wg();
        if (z) {
            wb();
        }
        if (z2) {
            wc();
        }
        aM(z3);
        a(aVar);
    }

    public void wb() {
        wg();
        if (aHz != null) {
            aHz.wl();
            aHB = false;
        }
    }

    public void wc() {
        wg();
        if (aHz != null) {
            aHz.wm();
            aHB = false;
        }
    }

    public void aM(boolean z) {
        wg();
        if (aHz != null) {
            aHz.aM(z);
        }
    }

    public void a(b.a aVar) {
        wg();
        if (aHz != null) {
            aHz.c(aVar);
        }
    }

    public void b(b.a aVar) {
        wg();
        if (aHz != null) {
            if (aHz.wi()) {
                aHz.c(aVar);
            }
            aHz.wk();
        }
    }

    public void a(int i, b.a aVar) {
        wg();
        if (aHz != null) {
            if (aHz.wi()) {
                aHz.c(aVar);
            }
            aHz.ea(i);
        }
    }

    public void wd() {
        wg();
        if (aHz != null) {
            aHz.wd();
            aHB = true;
        }
    }

    public void we() {
        wg();
        if (aHz != null) {
            aHz.we();
        }
    }

    public void wf() {
        wg();
        we();
        wd();
    }

    private void wg() {
        if (aHz == null) {
        }
    }

    public static void wh() {
        try {
            if (aHz != null) {
                if (aHA != null) {
                    aHA.wf();
                }
                aHz.wj();
                aHz.wn();
                aHz = null;
            }
            if (aHA != null) {
                aHA = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
