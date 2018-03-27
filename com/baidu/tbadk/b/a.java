package com.baidu.tbadk.b;

import com.baidu.tbadk.b.b;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static b aHA = null;
    private static a aHB = null;
    private static boolean aHC = false;
    private static String aHD = "";
    private static transient List<String> aHE = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (aHB == null) {
            synchronized (a.class) {
                if (aHB == null) {
                    aHB = new a();
                    aHA = b.c(baseFragmentActivity);
                }
            }
        } else if (aHA != null) {
            aHA.setContext(baseFragmentActivity.getPageContext());
        }
        if (aHC && aHA != null) {
            aHA.wl();
            aHA.wm();
            aHC = false;
        }
        return aHB;
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
        if (aHA != null) {
            aHA.wl();
            aHC = false;
        }
    }

    public void wc() {
        wg();
        if (aHA != null) {
            aHA.wm();
            aHC = false;
        }
    }

    public void aM(boolean z) {
        wg();
        if (aHA != null) {
            aHA.aM(z);
        }
    }

    public void a(b.a aVar) {
        wg();
        if (aHA != null) {
            aHA.c(aVar);
        }
    }

    public void b(b.a aVar) {
        wg();
        if (aHA != null) {
            if (aHA.wi()) {
                aHA.c(aVar);
            }
            aHA.wk();
        }
    }

    public void a(int i, b.a aVar) {
        wg();
        if (aHA != null) {
            if (aHA.wi()) {
                aHA.c(aVar);
            }
            aHA.ea(i);
        }
    }

    public void wd() {
        wg();
        if (aHA != null) {
            aHA.wd();
            aHC = true;
        }
    }

    public void we() {
        wg();
        if (aHA != null) {
            aHA.we();
        }
    }

    public void wf() {
        wg();
        we();
        wd();
    }

    private void wg() {
        if (aHA == null) {
        }
    }

    public static void wh() {
        try {
            if (aHA != null) {
                if (aHB != null) {
                    aHB.wf();
                }
                aHA.wj();
                aHA.wn();
                aHA = null;
            }
            if (aHB != null) {
                aHB = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
