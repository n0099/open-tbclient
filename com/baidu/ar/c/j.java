package com.baidu.ar.c;

import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
/* loaded from: classes3.dex */
public abstract class j extends a implements PixelReadListener {
    private static volatile boolean lQ = true;
    private boolean P = false;
    protected PixelReadParams lP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void x(boolean z) {
        lQ = z;
    }

    protected abstract void X();

    public boolean Y() {
        return true;
    }

    protected abstract void Z();

    @Override // com.baidu.ar.c.a, com.baidu.ar.c.k
    public final void a(e eVar) {
        com.baidu.ar.f.b.c("FrameDetector", "setup callback is " + (eVar != null));
        super.a(eVar);
        X();
    }

    public void b(boolean z) {
        this.P = z;
    }

    protected abstract boolean c(FramePixels framePixels);

    public PixelReadParams ct() {
        return this.lP;
    }

    public boolean cu() {
        return this.P;
    }

    @Override // com.baidu.ar.arplay.core.engine.pixel.PixelReadListener
    public boolean onPixelRead(FramePixels framePixels) {
        if (!this.P || lQ) {
            return c(framePixels);
        }
        return false;
    }

    @Override // com.baidu.ar.c.a, com.baidu.ar.c.k
    public final void release() {
        Z();
        super.release();
    }
}
