package com.baidu.ar.c;

import android.os.Handler;
import android.os.Looper;
import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
/* loaded from: classes3.dex */
public abstract class j extends a implements PixelReadListener {
    private static volatile boolean mn = true;
    private boolean O = false;
    private Handler mHandler;
    protected PixelReadParams mm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void w(boolean z) {
        mn = z;
    }

    public final void a(Looper looper) {
        if (this.mHandler == null) {
            this.mHandler = new Handler(looper);
        }
    }

    @Override // com.baidu.ar.c.a, com.baidu.ar.c.k
    public final void a(e eVar) {
        com.baidu.ar.f.b.c("FrameDetector", "setup callback is " + (eVar != null));
        super.a(eVar);
        al();
    }

    protected abstract void al();

    public boolean am() {
        return true;
    }

    protected abstract void an();

    public void b(boolean z) {
        this.O = z;
    }

    protected abstract boolean c(FramePixels framePixels);

    public PixelReadParams cJ() {
        return this.mm;
    }

    public boolean cK() {
        return this.O;
    }

    @Override // com.baidu.ar.arplay.core.engine.pixel.PixelReadListener
    public final boolean onPixelRead(final FramePixels framePixels) {
        if (!this.O || mn) {
            if (this.mHandler != null) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.ar.c.j.1
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

    @Override // com.baidu.ar.c.a, com.baidu.ar.c.k
    public final void release() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        an();
        super.release();
    }
}
