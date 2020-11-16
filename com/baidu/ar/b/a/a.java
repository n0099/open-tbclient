package com.baidu.ar.b.a;

import android.os.Bundle;
import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.b.b.b;
import com.baidu.ar.c.c;
import com.baidu.ar.d.j;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleController;
/* loaded from: classes12.dex */
public abstract class a extends j {
    protected AlgoHandleController bY = null;

    public abstract b a(Bundle bundle);

    public void a(AlgoHandleController algoHandleController) {
        this.bY = algoHandleController;
    }

    @Override // com.baidu.ar.d.j
    protected void am() {
        if (this.mg != null) {
            this.mg.a(new l(getName(), true));
        }
    }

    @Override // com.baidu.ar.d.j
    public boolean an() {
        int at = at();
        return com.baidu.ar.b.a.ar().b(at) && !com.baidu.ar.b.a.ar().e(at);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.d.j
    public void ao() {
        if (this.mg != null) {
            this.mg.b(new l(getName(), true));
        }
    }

    public abstract com.baidu.ar.b.b.a as();

    protected abstract int at();

    public void au() {
        com.baidu.ar.b.b.a as = as();
        if (as == null) {
            return;
        }
        c.ce().O(as.getTag());
        c.ce().c((com.baidu.ar.c.a) as);
    }

    public void b(long j) {
        if (this.bY != null) {
            this.bY.destroyHandle(j);
        }
    }

    public final void b(Bundle bundle) {
        b a2 = a(bundle);
        if (a2 == null) {
            return;
        }
        c.ce().c((com.baidu.ar.c.a) a2);
    }

    @Override // com.baidu.ar.d.j
    protected boolean c(FramePixels framePixels) {
        com.baidu.ar.b.b.c e;
        if (!com.baidu.ar.b.a.ar().b(at()) || framePixels == null || (e = e(framePixels)) == null) {
            return false;
        }
        return c.ce().c((com.baidu.ar.c.a) e);
    }

    public abstract com.baidu.ar.b.b.c e(FramePixels framePixels);
}
