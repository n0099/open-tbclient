package com.baidu.ar.arplay.d;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    public static volatile d gA;
    public List<c> gB = new ArrayList();

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
        List<c> list = this.gB;
        if (list != null) {
            for (c cVar : list) {
                if (cVar != null && cVar.mTextureId == i) {
                    cVar.f(i2, i3);
                    return cVar;
                }
            }
        }
        c cVar2 = new c();
        cVar2.a(i, i2, i3);
        List<c> list2 = this.gB;
        if (list2 != null) {
            list2.add(cVar2);
        }
        return cVar2;
    }

    public c p(int i) {
        List<c> list = this.gB;
        if (list != null) {
            for (c cVar : list) {
                if (cVar != null && cVar.mTextureId == i) {
                    return cVar;
                }
            }
            return null;
        }
        return null;
    }

    public void release() {
        List<c> list = this.gB;
        if (list != null) {
            for (c cVar : list) {
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
