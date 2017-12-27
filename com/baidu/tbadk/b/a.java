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
    private static b aGp = null;
    private static a aGq = null;
    private static boolean aGr = false;
    private static String aGs = "";
    private static transient List<String> aGt = new ArrayList(5);

    /* renamed from: com.baidu.tbadk.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0069a {
        private static SparseIntArray aGu = new SparseIntArray();

        static {
            aGu.put(2, 1);
            aGu.put(4, 2);
            aGu.put(8, 3);
            aGu.put(12, 4);
            aGu.put(16, 5);
            aGu.put(20, 6);
            aGu.put(24, 7);
        }

        public static int ea(int i) {
            return aGu.get(i);
        }
    }

    private a() {
    }

    public static a b(BaseFragmentActivity baseFragmentActivity) {
        if (aGq == null) {
            synchronized (a.class) {
                if (aGq == null) {
                    aGq = new a();
                    aGp = b.c(baseFragmentActivity);
                }
            }
        } else if (aGp != null) {
            aGp.a(baseFragmentActivity.getPageContext());
        }
        if (aGr && aGp != null) {
            aGp.vz();
            aGp.vA();
            aGr = false;
        }
        return aGq;
    }

    public static a b(BaseActivity baseActivity) {
        if (aGq == null) {
            synchronized (a.class) {
                if (aGq == null) {
                    aGq = new a();
                    aGp = b.c(baseActivity);
                }
            }
        } else if (aGp != null) {
            aGp.a(baseActivity.getPageContext());
        }
        if (aGr && aGp != null) {
            aGp.vz();
            aGp.vA();
            aGr = false;
        }
        return aGq;
    }

    public void a(boolean z, boolean z2, boolean z3, b.a aVar) {
        vu();
        if (z) {
            vo();
        }
        if (z2) {
            vp();
        }
        aI(z3);
        a(aVar);
    }

    public void a(TbPageContext tbPageContext, String str, String str2, String str3) {
        vu();
        if (aGp != null) {
            aGp.a(tbPageContext, str, str2, str3);
        }
    }

    public void vo() {
        vu();
        if (aGp != null) {
            aGp.vz();
            aGr = false;
        }
    }

    public void vp() {
        vu();
        if (aGp != null) {
            aGp.vA();
            aGr = false;
        }
    }

    public void aI(boolean z) {
        vu();
        if (aGp != null) {
            aGp.aI(z);
        }
    }

    public boolean vq() {
        vu();
        if (aGp != null) {
            return aGp.vq();
        }
        return false;
    }

    public void a(b.a aVar) {
        vu();
        if (aGp != null) {
            aGp.c(aVar);
        }
    }

    public void b(b.a aVar) {
        vu();
        if (aGp != null) {
            if (aGp.vw()) {
                aGp.c(aVar);
            }
            aGp.vy();
        }
    }

    public void a(int i, b.a aVar) {
        vu();
        if (aGp != null) {
            if (aGp.vw()) {
                aGp.c(aVar);
            }
            aGp.eb(i);
        }
    }

    public void vr() {
        vu();
        if (aGp != null) {
            aGp.vr();
            aGr = true;
        }
    }

    public void vs() {
        vu();
        if (aGp != null) {
            aGp.vs();
        }
    }

    public void vt() {
        vu();
        vs();
        vr();
    }

    private void vu() {
        if (aGp == null) {
        }
    }

    public static void vv() {
        try {
            if (aGp != null) {
                if (aGq != null) {
                    aGq.vt();
                }
                aGp.vx();
                aGp.vB();
                aGp = null;
            }
            if (aGq != null) {
                aGq = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
