package com.baidu.ar.vo.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.ar.arplay.core.engine.pixel.FramePixels;
import com.baidu.ar.arplay.core.engine.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.engine.pixel.PixelType;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.d.j;
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes12.dex */
public class e extends j {
    private static final String TAG = e.class.getSimpleName();
    private HandlerThread lx;
    private a ye;
    private b yf;

    /* loaded from: classes12.dex */
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
        this.yf = bVar2;
        this.mU = new PixelReadParams(PixelType.NV21);
        this.mU.setOutputWidth(PlatformPlugin.DEFAULT_SYSTEM_UI);
        this.mU.setOutputHeight(720);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(FramePixels framePixels) {
        if (this.yf != null) {
            this.yf.a(framePixels, new ICallbackWith<f>() { // from class: com.baidu.ar.vo.b.e.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.ar.callback.ICallbackWith
                /* renamed from: a */
                public void run(f fVar) {
                    if (e.this.mg == null || e.this.yf == null) {
                        return;
                    }
                    if (fVar != null) {
                        fVar.T(e.this.getName());
                    }
                    e.this.mg.a(fVar);
                }
            });
        }
    }

    @Override // com.baidu.ar.d.j
    protected void am() {
        this.lx = new HandlerThread(TAG);
        this.lx.start();
        this.ye = new a(this.lx.getLooper());
        this.ye.a(1001, new Runnable() { // from class: com.baidu.ar.vo.b.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.yf.init();
            }
        });
    }

    @Override // com.baidu.ar.d.j
    protected void ao() {
        if (this.ye != null) {
            this.ye.release();
            this.ye = null;
        }
        if (this.yf != null) {
            this.yf = null;
        }
        if (this.lx != null) {
            this.lx.quit();
            this.lx = null;
        }
    }

    @Override // com.baidu.ar.d.j
    protected boolean c(final FramePixels framePixels) {
        if (this.yf != null) {
            this.ye.a(1002, new Runnable() { // from class: com.baidu.ar.vo.b.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.n(framePixels);
                }
            });
            return true;
        }
        return true;
    }

    @Override // com.baidu.ar.d.k
    public String getName() {
        return TAG;
    }
}
