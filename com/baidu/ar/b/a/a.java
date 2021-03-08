package com.baidu.ar.b.a;

import android.os.Bundle;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.b.b.b;
import com.baidu.ar.c.c;
import com.baidu.ar.d.j;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleController;
/* loaded from: classes3.dex */
public abstract class a extends j {
    protected AlgoHandleController cb = null;

    public abstract b a(Bundle bundle);

    public void a(AlgoHandleController algoHandleController) {
        this.cb = algoHandleController;
    }

    @Override // com.baidu.ar.d.j
    protected void ao() {
        if (this.mv != null) {
            this.mv.a(new l(getName(), true));
        }
    }

    @Override // com.baidu.ar.d.j
    public boolean ap() {
        int au = au();
        return com.baidu.ar.b.a.as().c(au) && !com.baidu.ar.b.a.as().f(au);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.ar.d.j
    public void aq() {
        if (this.mv != null) {
            this.mv.b(new l(getName(), true));
        }
    }

    public abstract com.baidu.ar.b.b.a at();

    protected abstract int au();

    public void av() {
        com.baidu.ar.b.b.a at = at();
        if (at == null) {
            return;
        }
        c.cd().R(at.getTag());
        c.cd().c((com.baidu.ar.c.a) at);
    }

    public void b(long j) {
        if (this.cb != null) {
            this.cb.destroyHandle(j);
        }
    }

    public final void b(Bundle bundle) {
        b a2 = a(bundle);
        if (a2 == null) {
            return;
        }
        c.cd().c((com.baidu.ar.c.a) a2);
    }

    @Override // com.baidu.ar.d.j
    protected boolean c(FramePixels framePixels) {
        com.baidu.ar.b.b.c d;
        if (!com.baidu.ar.b.a.as().c(au()) || framePixels == null || (d = d(framePixels)) == null) {
            return false;
        }
        return c.cd().c((com.baidu.ar.c.a) d);
    }

    public abstract com.baidu.ar.b.b.c d(FramePixels framePixels);
}
