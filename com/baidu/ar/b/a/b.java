package com.baidu.ar.b.a;

import android.os.Bundle;
import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.b.b.d;
import com.baidu.ar.c.j;
import com.baidu.ar.c.l;
import com.baidu.ar.databasic.AlgoHandleController;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public abstract class b extends j implements a {
    private static final String TAG = b.class.getSimpleName();
    protected c cC;
    private boolean cB = false;
    protected AlgoHandleController bU = null;

    public b() {
        this.lP = new PixelReadParams(PixelType.NV21);
    }

    @Override // com.baidu.ar.c.j
    protected void X() {
        if (this.cC == null) {
            com.baidu.ar.f.b.b(getName(), "setupFrameDetector mMdlParams is null or empty");
        } else if (this.lb != null) {
            this.lb.a(new l(getName(), true));
        }
    }

    @Override // com.baidu.ar.c.j
    public boolean Y() {
        return !com.baidu.ar.b.a.ac().a(af());
    }

    @Override // com.baidu.ar.c.j
    protected void Z() {
        if (this.lb != null) {
            this.lb.b(new l(getName(), true));
        }
    }

    public abstract com.baidu.ar.b.b.b a(ByteBuffer byteBuffer, int i, int i2, long j, boolean z, int i3, int i4);

    public com.baidu.ar.b.b.c a(Bundle bundle) {
        com.baidu.ar.b.b.c b = b(bundle);
        if (b != null) {
            b.a(this);
        }
        return b;
    }

    public void a(c cVar) {
        this.cC = cVar;
        this.lP.setOutputWidth(this.cC.ak());
        this.lP.setOutputHeight(this.cC.aj());
    }

    public void a(AlgoHandleController algoHandleController) {
        this.bU = algoHandleController;
    }

    protected abstract int af();

    public com.baidu.ar.b.b.a ag() {
        com.baidu.ar.b.b.a ah = ah();
        if (ah != null) {
            ah.a(this);
        }
        return ah;
    }

    public abstract com.baidu.ar.b.b.a ah();

    public void ai() {
        com.baidu.ar.b.b.a ag = ag();
        if (ag == null) {
            return;
        }
        com.baidu.ar.b.a.ac().a((d) ag);
    }

    public abstract com.baidu.ar.b.b.c b(Bundle bundle);

    public void b(long j) {
        if (this.bU != null) {
            this.bU.destroyHandle(j);
        }
    }

    public final void c(Bundle bundle) {
        com.baidu.ar.b.b.c a = a(bundle);
        if (a == null) {
            return;
        }
        com.baidu.ar.b.a.ac().a((d) a);
    }

    @Override // com.baidu.ar.c.j
    protected final boolean c(FramePixels framePixels) {
        if (!com.baidu.ar.b.a.ac().c(af()) || framePixels == null) {
            return false;
        }
        com.baidu.ar.b.b.b a = a(framePixels.getPixelsAddress(), framePixels.getWidth(), framePixels.getHeight(), framePixels.getTimestamp(), framePixels.isFrontCamera(), framePixels.getOrientation().getDegree(), framePixels.getSegOrientation().getValue());
        if (a == null) {
            return false;
        }
        a.a(this);
        return com.baidu.ar.b.a.ac().a((d) a);
    }
}
