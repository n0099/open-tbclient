package com.baidu.ar.arplay.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class d {
    private static d gn = null;
    private List<c> go = new ArrayList();

    private d() {
    }

    public static d bs() {
        if (gn == null) {
            synchronized (d.class) {
                if (gn == null) {
                    gn = new d();
                }
            }
        }
        return gn;
    }

    public c b(int i, int i2, int i3) {
        c cVar;
        if (this.go != null) {
            Iterator<c> it = this.go.iterator();
            while (it.hasNext()) {
                cVar = it.next();
                if (cVar != null && cVar.mTextureId == i) {
                    cVar.f(i2, i3);
                    break;
                }
            }
        }
        cVar = new c();
        cVar.a(i, i2, i3);
        if (this.go != null) {
            this.go.add(cVar);
        }
        return cVar;
    }

    public c n(int i) {
        if (this.go != null) {
            for (c cVar : this.go) {
                if (cVar != null && cVar.mTextureId == i) {
                    return cVar;
                }
            }
        }
        return null;
    }

    public void release() {
        if (this.go != null) {
            for (c cVar : this.go) {
                if (cVar != null) {
                    cVar.release();
                }
            }
            this.go.clear();
        }
        if (gn != null) {
            gn = null;
        }
    }
}
