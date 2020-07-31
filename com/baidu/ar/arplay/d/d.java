package com.baidu.ar.arplay.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class d {
    private static d gY = null;
    private List<c> gZ = new ArrayList();

    private d() {
    }

    public static d bk() {
        if (gY == null) {
            synchronized (d.class) {
                if (gY == null) {
                    gY = new d();
                }
            }
        }
        return gY;
    }

    public c b(int i, int i2, int i3) {
        c cVar;
        if (this.gZ != null) {
            Iterator<c> it = this.gZ.iterator();
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
        if (this.gZ != null) {
            this.gZ.add(cVar);
        }
        return cVar;
    }

    public c q(int i) {
        if (this.gZ != null) {
            for (c cVar : this.gZ) {
                if (cVar != null && cVar.mTextureId == i) {
                    return cVar;
                }
            }
        }
        return null;
    }

    public void release() {
        if (this.gZ != null) {
            for (c cVar : this.gZ) {
                if (cVar != null) {
                    cVar.release();
                }
            }
            this.gZ.clear();
        }
        if (gY != null) {
            gY = null;
        }
    }
}
