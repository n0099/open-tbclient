package com.baidu.ar.d;

import android.os.Handler;
import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
/* loaded from: classes10.dex */
public abstract class j extends a implements PixelReadListener {
    private static volatile boolean mV = true;
    private boolean O = false;
    private Handler mHandler;
    protected PixelReadParams mU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void x(boolean z) {
        mV = z;
    }

    public final void a(Handler handler) {
        this.mHandler = handler;
    }

    @Override // com.baidu.ar.d.a, com.baidu.ar.d.k
    public final void a(e eVar) {
        com.baidu.ar.g.b.c("FrameDetector", "setup callback is " + (eVar != null));
        super.a(eVar);
        am();
    }

    protected abstract void am();

    public boolean an() {
        return true;
    }

    protected abstract void ao();

    public void b(boolean z) {
        this.O = z;
    }

    protected abstract boolean c(FramePixels framePixels);

    public PixelReadParams dj() {
        return this.mU;
    }

    public boolean dk() {
        return this.O;
    }

    @Override // com.baidu.ar.arplay.core.engine.pixel.PixelReadListener
    public boolean onPixelRead(final FramePixels framePixels) {
        if (!this.O || mV) {
            if (this.mHandler != null) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.ar.d.j.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.c(framePixels);
                    }
                });
            } else {
                c(framePixels);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.ar.d.a, com.baidu.ar.d.k
    public final void release() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        ao();
        super.release();
    }
}
