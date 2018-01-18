package com.baidu.tbadk.b;

import com.baidu.tbadk.b.b;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static b aGo = null;
    private static a aGp = null;
    private static boolean aGq = false;
    private static String aGr = "";
    private static transient List<String> aGs = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (aGp == null) {
            synchronized (a.class) {
                if (aGp == null) {
                    aGp = new a();
                    aGo = b.c(baseFragmentActivity);
                }
            }
        } else if (aGo != null) {
            aGo.a(baseFragmentActivity.getPageContext());
        }
        if (aGq && aGo != null) {
            aGo.vy();
            aGo.vz();
            aGq = false;
        }
        return aGp;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        vt();
        if (z) {
            vo();
        }
        if (z2) {
            vp();
        }
        aI(z3);
        a(aVar);
    }

    public void vo() {
        vt();
        if (aGo != null) {
            aGo.vy();
            aGq = false;
        }
    }

    public void vp() {
        vt();
        if (aGo != null) {
            aGo.vz();
            aGq = false;
        }
    }

    public void aI(boolean z) {
        vt();
        if (aGo != null) {
            aGo.aI(z);
        }
    }

    public void a(b.a aVar) {
        vt();
        if (aGo != null) {
            aGo.c(aVar);
        }
    }

    public void b(b.a aVar) {
        vt();
        if (aGo != null) {
            if (aGo.vv()) {
                aGo.c(aVar);
            }
            aGo.vx();
        }
    }

    public void a(int i, b.a aVar) {
        vt();
        if (aGo != null) {
            if (aGo.vv()) {
                aGo.c(aVar);
            }
            aGo.ea(i);
        }
    }

    public void vq() {
        vt();
        if (aGo != null) {
            aGo.vq();
            aGq = true;
        }
    }

    public void vr() {
        vt();
        if (aGo != null) {
            aGo.vr();
        }
    }

    public void vs() {
        vt();
        vr();
        vq();
    }

    private void vt() {
        if (aGo == null) {
        }
    }

    public static void vu() {
        try {
            if (aGo != null) {
                if (aGp != null) {
                    aGp.vs();
                }
                aGo.vw();
                aGo.vA();
                aGo = null;
            }
            if (aGp != null) {
                aGp = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
