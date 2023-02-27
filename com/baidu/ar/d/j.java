package com.baidu.ar.d;

import android.os.Handler;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadListener;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
/* loaded from: classes.dex */
public abstract class j extends a implements PixelReadListener {
    public static volatile boolean nl = true;
    public boolean P = false;
    public Handler mHandler;
    public PixelReadParams nk;

    public static void v(boolean z) {
        nl = z;
    }

    public final void a(Handler handler) {
        this.mHandler = handler;
    }

    @Override // com.baidu.ar.d.a, com.baidu.ar.d.k
    public final void a(e eVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("setup callback is ");
        sb.append(eVar != null);
        com.baidu.ar.h.b.c("FrameDetector", sb.toString());
        super.a(eVar);
        ao();
    }

    public abstract void ao();

    public boolean ap() {
        return true;
    }

    public abstract void aq();

    public void b(boolean z) {
        this.P = z;
    }

    public abstract boolean c(FramePixels framePixels);

    public PixelReadParams di() {
        return this.nk;
    }

    public boolean dj() {
        return this.P;
    }

    @Override // com.baidu.ar.arplay.core.pixel.PixelReadListener
    public boolean onPixelRead(final FramePixels framePixels) {
        if (!this.P || nl) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.baidu.ar.d.j.1
                    @Override // java.lang.Runnable
                    public void run() {
                        j.this.c(framePixels);
                    }
                });
                return true;
            }
            c(framePixels);
            return true;
        }
        return false;
    }

    @Override // com.baidu.ar.d.a, com.baidu.ar.d.k
    public final void release() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        aq();
        super.release();
    }
}
