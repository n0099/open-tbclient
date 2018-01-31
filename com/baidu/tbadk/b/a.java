package com.baidu.tbadk.b;

import com.baidu.tbadk.b.b;
import com.baidu.tbadk.core.BaseFragmentActivity;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static b aGr = null;
    private static a aGs = null;
    private static boolean aGt = false;
    private static String aGu = "";
    private static transient List<String> aGv = new ArrayList(5);

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (aGs == null) {
            synchronized (a.class) {
                if (aGs == null) {
                    aGs = new a();
                    aGr = b.c(baseFragmentActivity);
                }
            }
        } else if (aGr != null) {
            aGr.a(baseFragmentActivity.getPageContext());
        }
        if (aGt && aGr != null) {
            aGr.vz();
            aGr.vA();
            aGt = false;
        }
        return aGs;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        vu();
        if (z) {
            vp();
        }
        if (z2) {
            vq();
        }
        aJ(z3);
        a(aVar);
    }

    public void vp() {
        vu();
        if (aGr != null) {
            aGr.vz();
            aGt = false;
        }
    }

    public void vq() {
        vu();
        if (aGr != null) {
            aGr.vA();
            aGt = false;
        }
    }

    public void aJ(boolean z) {
        vu();
        if (aGr != null) {
            aGr.aJ(z);
        }
    }

    public void a(b.a aVar) {
        vu();
        if (aGr != null) {
            aGr.c(aVar);
        }
    }

    public void b(b.a aVar) {
        vu();
        if (aGr != null) {
            if (aGr.vw()) {
                aGr.c(aVar);
            }
            aGr.vy();
        }
    }

    public void a(int i, b.a aVar) {
        vu();
        if (aGr != null) {
            if (aGr.vw()) {
                aGr.c(aVar);
            }
            aGr.ea(i);
        }
    }

    public void vr() {
        vu();
        if (aGr != null) {
            aGr.vr();
            aGt = true;
        }
    }

    public void vs() {
        vu();
        if (aGr != null) {
            aGr.vs();
        }
    }

    public void vt() {
        vu();
        vs();
        vr();
    }

    private void vu() {
        if (aGr == null) {
        }
    }

    public static void vv() {
        try {
            if (aGr != null) {
                if (aGs != null) {
                    aGs.vt();
                }
                aGr.vx();
                aGr.vB();
                aGr = null;
            }
            if (aGs != null) {
                aGs = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
