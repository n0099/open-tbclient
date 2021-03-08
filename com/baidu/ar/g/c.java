package com.baidu.ar.g;

import com.baidu.ar.d;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class c extends d implements a {
    private WeakReference<a> mj;
    private b xS;

    @Override // com.baidu.ar.d
    public void a(com.baidu.ar.c cVar) {
        if (cVar instanceof a) {
            this.mj = new WeakReference<>((a) cVar);
            if (this.xS != null) {
                ((a) cVar).a(this.xS);
            }
        }
    }

    @Override // com.baidu.ar.g.a
    public void a(b bVar) {
        this.xS = bVar;
        if (this.xS == null || this.mj == null || this.mj.get() == null) {
            return;
        }
        this.mj.get().a(this.xS);
    }

    @Override // com.baidu.ar.d
    public void release() {
        if (this.mj != null) {
            this.mj.clear();
            this.mj = null;
        }
        this.xS = null;
    }
}
