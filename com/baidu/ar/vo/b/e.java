package com.baidu.ar.vo.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.ar.arplay.core.pixel.FramePixels;
import com.baidu.ar.arplay.core.pixel.PixelReadParams;
import com.baidu.ar.arplay.core.pixel.PixelType;
import com.baidu.ar.callback.ICallbackWith;
import com.baidu.ar.d.j;
import io.flutter.plugin.platform.PlatformPlugin;
/* loaded from: classes6.dex */
public class e extends j {
    private static final String TAG = e.class.getSimpleName();
    private HandlerThread lM;
    private a yT;
    private b yU;

    /* loaded from: classes6.dex */
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
        this.yU = bVar2;
        this.nk = new PixelReadParams(PixelType.NV21);
        this.nk.setOutputWidth(PlatformPlugin.DEFAULT_SYSTEM_UI);
        this.nk.setOutputHeight(720);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(FramePixels framePixels) {
        if (this.yU != null) {
            this.yU.a(framePixels, new ICallbackWith<f>() { // from class: com.baidu.ar.vo.b.e.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.ar.callback.ICallbackWith
                /* renamed from: a */
                public void run(f fVar) {
                    if (e.this.mv == null || e.this.yU == null) {
                        return;
                    }
                    if (fVar != null) {
                        fVar.W(e.this.getName());
                    }
                    e.this.mv.a(fVar);
                }
            });
        }
    }

    @Override // com.baidu.ar.d.j
    protected void ao() {
        this.lM = new HandlerThread(TAG);
        this.lM.start();
        this.yT = new a(this.lM.getLooper());
        this.yT.a(1001, new Runnable() { // from class: com.baidu.ar.vo.b.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.yU.init();
            }
        });
    }

    @Override // com.baidu.ar.d.j
    protected void aq() {
        if (this.yT != null) {
            this.yT.release();
            this.yT = null;
        }
        if (this.yU != null) {
            this.yU = null;
        }
        if (this.lM != null) {
            this.lM.quit();
            this.lM = null;
        }
    }

    @Override // com.baidu.ar.d.j
    protected boolean c(final FramePixels framePixels) {
        if (this.yU != null) {
            this.yT.a(1002, new Runnable() { // from class: com.baidu.ar.vo.b.e.2
                @Override // java.lang.Runnable
                public void run() {
                    e.this.m(framePixels);
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
