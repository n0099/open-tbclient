package com.baidu.ar.g;

import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class c extends d implements a {
    public WeakReference<a> mj;
    public b xS;

    @Override // com.baidu.ar.d
    public void a(com.baidu.ar.c cVar) {
        if (cVar instanceof a) {
            a aVar = (a) cVar;
            this.mj = new WeakReference<>(aVar);
            b bVar = this.xS;
            if (bVar != null) {
                aVar.a(bVar);
            }
        }
    }

    @Override // com.baidu.ar.g.a
    public void a(b bVar) {
        WeakReference<a> weakReference;
        this.xS = bVar;
        if (bVar == null || (weakReference = this.mj) == null || weakReference.get() == null) {
            return;
        }
        this.mj.get().a(this.xS);
    }

    @Override // com.baidu.ar.d
    public void release() {
        WeakReference<a> weakReference = this.mj;
        if (weakReference != null) {
            weakReference.clear();
            this.mj = null;
        }
        this.xS = null;
    }
}
