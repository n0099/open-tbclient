package com.baidu.ar.arplay.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class d {
    private static volatile d gA = null;
    private List<c> gB = new ArrayList();

    private d() {
    }

    public static d bp() {
        if (gA == null) {
            synchronized (d.class) {
                if (gA == null) {
                    gA = new d();
                }
            }
        }
        return gA;
    }

    public c b(int i, int i2, int i3) {
        c cVar;
        if (this.gB != null) {
            Iterator<c> it = this.gB.iterator();
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
        if (this.gB != null) {
            this.gB.add(cVar);
        }
        return cVar;
    }

    public c p(int i) {
        if (this.gB != null) {
            for (c cVar : this.gB) {
                if (cVar != null && cVar.mTextureId == i) {
                    return cVar;
                }
            }
        }
        return null;
    }

    public void release() {
        if (this.gB != null) {
            for (c cVar : this.gB) {
                if (cVar != null) {
                    cVar.release();
                }
            }
            this.gB.clear();
        }
        if (gA != null) {
            gA = null;
        }
    }
}
