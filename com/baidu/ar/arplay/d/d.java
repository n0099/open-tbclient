package com.baidu.ar.arplay.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class d {
    private static d gM = null;
    private List<c> gN = new ArrayList();

    private d() {
    }

    public static d aW() {
        if (gM == null) {
            synchronized (d.class) {
                if (gM == null) {
                    gM = new d();
                }
            }
        }
        return gM;
    }

    public c b(int i, int i2, int i3) {
        c cVar;
        if (this.gN != null) {
            Iterator<c> it = this.gN.iterator();
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
        if (this.gN != null) {
            this.gN.add(cVar);
        }
        return cVar;
    }

    public c p(int i) {
        if (this.gN != null) {
            for (c cVar : this.gN) {
                if (cVar != null && cVar.mTextureId == i) {
                    return cVar;
                }
            }
        }
        return null;
    }

    public void release() {
        if (this.gN != null) {
            for (c cVar : this.gN) {
                if (cVar != null) {
                    cVar.release();
                }
            }
            this.gN.clear();
        }
        if (gM != null) {
            gM = null;
        }
    }
}
