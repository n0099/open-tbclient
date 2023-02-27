package com.baidu.ar.b.a;

import android.os.Bundle;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.b.b.b;
import com.baidu.ar.c.c;
import com.baidu.ar.d.e;
import com.baidu.ar.d.j;
import com.baidu.ar.d.l;
import com.baidu.ar.databasic.AlgoHandleController;
/* loaded from: classes.dex */
public abstract class a extends j {
    public AlgoHandleController cb = null;

    public abstract b a(Bundle bundle);

    public void a(AlgoHandleController algoHandleController) {
        this.cb = algoHandleController;
    }

    @Override // com.baidu.ar.d.j
    public void ao() {
        e eVar = this.mv;
        if (eVar != null) {
            eVar.a(new l(getName(), true));
        }
    }

    @Override // com.baidu.ar.d.j
    public boolean ap() {
        int au = au();
        if (com.baidu.ar.b.a.as().c(au)) {
            return !com.baidu.ar.b.a.as().f(au);
        }
        return false;
    }

    @Override // com.baidu.ar.d.j
    public void aq() {
        e eVar = this.mv;
        if (eVar != null) {
            eVar.b(new l(getName(), true));
        }
    }

    public abstract com.baidu.ar.b.b.a at();

    public abstract int au();

    public void av() {
        com.baidu.ar.b.b.a at = at();
        if (at == null) {
            return;
        }
        c.cd().R(at.getTag());
        c.cd().c((com.baidu.ar.c.a) at);
    }

    public void b(long j) {
        AlgoHandleController algoHandleController = this.cb;
        if (algoHandleController != null) {
            algoHandleController.destroyHandle(j);
        }
    }

    public final void b(Bundle bundle) {
        b a = a(bundle);
        if (a == null) {
            return;
        }
        c.cd().c((com.baidu.ar.c.a) a);
    }

    @Override // com.baidu.ar.d.j
    public boolean c(FramePixels framePixels) {
        com.baidu.ar.b.b.c d;
        if (!com.baidu.ar.b.a.as().c(au()) || framePixels == null || (d = d(framePixels)) == null) {
            return false;
        }
        return c.cd().c((com.baidu.ar.c.a) d);
    }

    public abstract com.baidu.ar.b.b.c d(FramePixels framePixels);
}
