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
    protected c cP;
    private boolean cO = false;
    protected AlgoHandleController ch = null;

    public b() {
        this.mm = new PixelReadParams(PixelType.NV21);
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
        this.cP = cVar;
        this.mm.setOutputWidth(this.cP.ay());
        this.mm.setOutputHeight(this.cP.ax());
    }

    public void a(AlgoHandleController algoHandleController) {
        this.ch = algoHandleController;
    }

    @Override // com.baidu.ar.c.j
    protected void al() {
        if (this.cP == null) {
            com.baidu.ar.f.b.b(getName(), "setupFrameDetector mMdlParams is null or empty");
        } else if (this.ly != null) {
            this.ly.a(new l(getName(), true));
        }
    }

    @Override // com.baidu.ar.c.j
    public boolean am() {
        return !com.baidu.ar.b.a.aq().b(at());
    }

    @Override // com.baidu.ar.c.j
    protected void an() {
        if (this.ly != null) {
            this.ly.b(new l(getName(), true));
        }
    }

    protected abstract int at();

    public com.baidu.ar.b.b.a au() {
        com.baidu.ar.b.b.a av = av();
        if (av != null) {
            av.a(this);
        }
        return av;
    }

    public abstract com.baidu.ar.b.b.a av();

    public void aw() {
        com.baidu.ar.b.b.a au = au();
        if (au == null) {
            return;
        }
        com.baidu.ar.b.a.aq().a((d) au);
    }

    public abstract com.baidu.ar.b.b.c b(Bundle bundle);

    public void b(long j) {
        if (this.ch != null) {
            this.ch.destroyHandle(j);
        }
    }

    public final void c(Bundle bundle) {
        com.baidu.ar.b.b.c a = a(bundle);
        if (a == null) {
            return;
        }
        com.baidu.ar.b.a.aq().a((d) a);
    }

    @Override // com.baidu.ar.c.j
    protected final boolean c(FramePixels framePixels) {
        if (!com.baidu.ar.b.a.aq().d(at()) || framePixels == null) {
            return false;
        }
        com.baidu.ar.b.b.b a = a(framePixels.getPixelsAddress(), framePixels.getWidth(), framePixels.getHeight(), framePixels.getTimestamp(), framePixels.isFrontCamera(), framePixels.getOrientation().getDegree(), framePixels.getSegOrientation().getValue());
        if (a == null) {
            return false;
        }
        a.a(this);
        return com.baidu.ar.b.a.aq().a((d) a);
    }
}
