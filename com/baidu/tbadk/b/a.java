package com.baidu.tbadk.b;

import com.baidu.tbadk.b.b;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static b aHK = null;
    private static a aHL = null;
    private static boolean aHM = false;
    private static String aHN = "";
    private static transient List<String> aHO = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (aHL == null) {
            synchronized (a.class) {
                if (aHL == null) {
                    aHL = new a();
                    aHK = b.c(baseFragmentActivity);
                }
            }
        } else if (aHK != null) {
            aHK.setContext(baseFragmentActivity.getPageContext());
        }
        if (aHM && aHK != null) {
            aHK.wl();
            aHK.wm();
            aHM = false;
        }
        return aHL;
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
        if (aHK != null) {
            aHK.wl();
            aHM = false;
        }
    }

    public void wc() {
        wg();
        if (aHK != null) {
            aHK.wm();
            aHM = false;
        }
    }

    public void aM(boolean z) {
        wg();
        if (aHK != null) {
            aHK.aM(z);
        }
    }

    public void a(b.a aVar) {
        wg();
        if (aHK != null) {
            aHK.c(aVar);
        }
    }

    public void b(b.a aVar) {
        wg();
        if (aHK != null) {
            if (aHK.wi()) {
                aHK.c(aVar);
            }
            aHK.wk();
        }
    }

    public void a(int i, b.a aVar) {
        wg();
        if (aHK != null) {
            if (aHK.wi()) {
                aHK.c(aVar);
            }
            aHK.ea(i);
        }
    }

    public void wd() {
        wg();
        if (aHK != null) {
            aHK.wd();
            aHM = true;
        }
    }

    public void we() {
        wg();
        if (aHK != null) {
            aHK.we();
        }
    }

    public void wf() {
        wg();
        we();
        wd();
    }

    private void wg() {
        if (aHK == null) {
        }
    }

    public static void wh() {
        try {
            if (aHK != null) {
                if (aHL != null) {
                    aHL.wf();
                }
                aHK.wj();
                aHK.wn();
                aHK = null;
            }
            if (aHL != null) {
                aHL = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
