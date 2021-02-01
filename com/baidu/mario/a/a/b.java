package com.baidu.mario.a.a;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.mario.a.b.c;
import com.baidu.mario.a.b.d;
import com.baidu.mario.a.b.e;
import com.baidu.mario.a.b.g;
import java.util.ArrayList;
/* loaded from: classes15.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private e cgT;
    private HandlerThread chr;
    private Handler chs;
    private com.baidu.mario.gldraw2d.a cht;
    private g chu;
    private volatile boolean chm = false;
    private boolean chv = false;

    private void a(e eVar, c cVar) {
        this.chr = new HandlerThread("VideoRecorderThread");
        this.chr.start();
        this.chs = new HandlerC0257b(this.chr.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.chu = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.chu == null) {
                    return;
                }
            }
            this.chu.a(cVar);
            this.cgT = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.chv = true;
        } else {
            this.chv = false;
        }
    }

    public long aaO() {
        if (this.chu != null) {
            return this.chu.aaO();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.chr != null && this.chr.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.chs.sendMessage(this.chs.obtainMessage(1001, new a(arrayList, dVar)));
        this.chm = true;
        return true;
    }

    public void startRecording() {
        if (this.chs != null) {
            this.chs.sendMessage(this.chs.obtainMessage(1002));
        }
    }

    public void l(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.chs != null) {
            this.chs.sendMessage(this.chs.obtainMessage(1003, arrayList));
        }
    }

    public void bH(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.chs != null && this.chm) {
            this.chs.sendMessage(this.chs.obtainMessage(1005, i, i2));
            synchronized (this.cht) {
                try {
                    if (this.chv) {
                        this.cht.wait(12L);
                    } else {
                        this.cht.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void abi() {
        if (this.chs != null && this.chm) {
            this.chs.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.chs != null && this.chm) {
            this.chm = false;
            this.chs.removeMessages(1005);
            this.chs.sendMessage(this.chs.obtainMessage(1006));
        }
    }

    public void abe() {
        if (this.chs != null) {
            this.chs.removeCallbacksAndMessages(null);
            this.chs.sendMessage(this.chs.obtainMessage(1007));
            this.chs.sendMessage(this.chs.obtainMessage(1008));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class HandlerC0257b extends Handler {
        public HandlerC0257b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.chc, aVar.cgu);
                    return;
                case 1002:
                    b.this.abf();
                    return;
                case 1003:
                    b.this.m((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.d((com.baidu.mario.gldraw2d.c.c) message.obj);
                    return;
                case 1005:
                    b.this.bL((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1006:
                    b.this.abj();
                    return;
                case 1007:
                    b.this.abk();
                    return;
                case 1008:
                    b.this.abl();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.chu != null) {
            this.chu.a(dVar, this.cgT);
            if (this.cht == null) {
                this.cht = new com.baidu.mario.gldraw2d.a(this.chu.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abf() {
        if (Build.VERSION.SDK_INT >= 18 && this.chu != null) {
            this.chu.startEncoder();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.cht.ax(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.cht.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bL(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.chu != null) {
            this.chu.dZ(false);
            this.cht.bH(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abj() {
        if (Build.VERSION.SDK_INT >= 18 && this.chu != null) {
            this.chu.dZ(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abk() {
        if (Build.VERSION.SDK_INT >= 18 && this.chu != null) {
            this.chu.stopEncoder();
            this.chu.releaseEncoder();
            this.chu = null;
            this.cgT = null;
            this.cht.aad();
            this.cht = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abl() {
        if (this.chs != null) {
            this.chs.removeCallbacksAndMessages(null);
            this.chs = null;
        }
        if (this.chr != null) {
            this.chr.quit();
            this.chr = null;
        }
    }

    /* loaded from: classes15.dex */
    class a {
        d cgu;
        ArrayList<com.baidu.mario.gldraw2d.params.c> chc;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.chc = arrayList;
            this.cgu = dVar;
        }
    }
}
