package com.baidu.ar.vo.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.c.j;
import com.baidu.ar.callback.ICallbackWith;
/* loaded from: classes3.dex */
public class e extends j {
    private static final String TAG = e.class.getSimpleName();
    private HandlerThread ku;
    private a xf;
    private b xg;

    /* loaded from: classes3.dex */
    private static final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void a(int i, Runnable runnable) {
            removeMessages(i);
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = runnable;
            sendMessage(obtain);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Runnable runnable = (Runnable) message.obj;
            if (runnable != null) {
                runnable.run();
            }
        }

        public void release() {
            removeMessages(1001);
            removeMessages(1002);
            Thread.currentThread().interrupt();
        }
    }

    public e(com.baidu.ar.vo.a.b bVar, b bVar2) {
        this.xg = bVar2;
        this.lP = new PixelReadParams(PixelType.NV21);
        this.lP.setOutputWidth(1280);
        this.lP.setOutputHeight(720);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(FramePixels framePixels) {
        if (this.xg != null) {
            this.xg.a(framePixels, new ICallbackWith<f>() { // from class: com.baidu.ar.vo.b.e.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.ar.callback.ICallbackWith
                /* renamed from: a */
                public void run(f fVar) {
                    if (e.this.lb == null || e.this.xg == null) {
                        return;
                    }
                    if (fVar != null) {
                        fVar.S(e.this.getName());
                    }
                    e.this.lb.a(fVar);
                }
            });
        }
    }

    @Override // com.baidu.ar.c.j
    protected void X() {
        this.ku = new HandlerThread(TAG);
        this.ku.start();
        this.xf = new a(this.ku.getLooper());
        this.xf.a(1001, new Runnable() { // from class: com.baidu.ar.vo.b.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.xg.aH();
            }
        });
    }

    @Override // com.baidu.ar.c.j
    protected void Z() {
        if (this.xf != null) {
            this.xf.release();
            this.xf = null;
        }
        if (this.xg != null) {
            this.xg = null;
        }
        if (this.ku != null) {
            this.ku.quit();
            this.ku = null;
        }
    }

    @Override // com.baidu.ar.c.j
    protected boolean c(final FramePixels framePixels) {
        if (this.xg != null) {
            this.xf.a(1002, new Runnable() { // from class: com.baidu.ar.vo.b.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.e(framePixels);
                }
            });
            return true;
        }
        return true;
    }

    @Override // com.baidu.ar.c.k
    public String getName() {
        return TAG;
    }
}
