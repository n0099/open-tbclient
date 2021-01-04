package com.baidu.ar.d;

import android.os.Handler;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
/* loaded from: classes6.dex */
public abstract class j extends a implements PixelReadListener {
    private static volatile boolean nl = true;
    private boolean P = false;
    private Handler mHandler;
    protected PixelReadParams nk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void v(boolean z) {
        nl = z;
    }

    public final void a(Handler handler) {
        this.mHandler = handler;
    }

    @Override // com.baidu.ar.d.a, com.baidu.ar.d.k
    public final void a(e eVar) {
        com.baidu.ar.h.b.c("FrameDetector", "setup callback is " + (eVar != null));
        super.a(eVar);
        ao();
    }

    protected abstract void ao();

    public boolean ap() {
        return true;
    }

    protected abstract void aq();

    public void b(boolean z) {
        this.P = z;
    }

    protected abstract boolean c(FramePixels framePixels);

    public PixelReadParams di() {
        return this.nk;
    }

    public boolean dj() {
        return this.P;
    }

    @Override // com.baidu.ar.arplay.core.pixel.PixelReadListener
    public boolean onPixelRead(final FramePixels framePixels) {
        if (!this.P || nl) {
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
        aq();
        super.release();
    }
}
