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
/* loaded from: classes11.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private e bnT;
    private HandlerThread bor;
    private Handler bos;
    private com.baidu.mario.gldraw2d.a bot;
    private g bou;
    private volatile boolean bom = false;
    private boolean bov = false;

    private void a(e eVar, c cVar) {
        this.bor = new HandlerThread("VideoRecorderThread");
        this.bor.start();
        this.bos = new HandlerC0203b(this.bor.getLooper());
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                this.bou = new g();
            } catch (VerifyError e) {
                Log.e(TAG, "initRecorder videorecorder verifyError");
                if (this.bou == null) {
                    return;
                }
            }
            this.bou.a(cVar);
            this.bnT = eVar;
        }
        if (Build.HARDWARE.toLowerCase().startsWith("kirin")) {
            this.bov = true;
        } else {
            this.bov = false;
        }
    }

    public long KQ() {
        if (this.bou != null) {
            return this.bou.KQ();
        }
        return 0L;
    }

    public boolean isRunning() {
        return this.bor != null && this.bor.isAlive();
    }

    public boolean a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last video recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.bos.sendMessage(this.bos.obtainMessage(1001, new a(arrayList, dVar)));
        this.bom = true;
        return true;
    }

    public void startRecording() {
        if (this.bos != null) {
            this.bos.sendMessage(this.bos.obtainMessage(1002));
        }
    }

    public void l(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (this.bos != null) {
            this.bos.sendMessage(this.bos.obtainMessage(1003, arrayList));
        }
    }

    public void aE(long j) {
        int i = (int) (j >> 32);
        int i2 = (int) j;
        if (this.bos != null && this.bom) {
            this.bos.sendMessage(this.bos.obtainMessage(1005, i, i2));
            synchronized (this.bot) {
                try {
                    if (this.bov) {
                        this.bot.wait(12L);
                    } else {
                        this.bot.wait(2L);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public void Ll() {
        if (this.bos != null && this.bom) {
            this.bos.removeMessages(1005);
        }
    }

    public void stopRecording() {
        if (this.bos != null && this.bom) {
            this.bom = false;
            this.bos.removeMessages(1005);
            this.bos.sendMessage(this.bos.obtainMessage(1006));
        }
    }

    public void Lg() {
        if (this.bos != null) {
            this.bos.removeCallbacksAndMessages(null);
            this.bos.sendMessage(this.bos.obtainMessage(1007));
            this.bos.sendMessage(this.bos.obtainMessage(1008));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.mario.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class HandlerC0203b extends Handler {
        public HandlerC0203b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a aVar = (a) message.obj;
                    b.this.a(aVar.boc, aVar.bnu);
                    return;
                case 1002:
                    b.this.Lh();
                    return;
                case 1003:
                    b.this.m((ArrayList) message.obj);
                    return;
                case 1004:
                    b.this.d((com.baidu.mario.gldraw2d.c.c) message.obj);
                    return;
                case 1005:
                    b.this.aI((message.arg1 << 32) | (message.arg2 & 4294967295L));
                    return;
                case 1006:
                    b.this.Lm();
                    return;
                case 1007:
                    b.this.Ln();
                    return;
                case 1008:
                    b.this.Lo();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.bou != null) {
            this.bou.a(dVar, this.bnT);
            if (this.bot == null) {
                this.bot = new com.baidu.mario.gldraw2d.a(this.bou.getInputSurface(), arrayList);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lh() {
        if (Build.VERSION.SDK_INT >= 18 && this.bou != null) {
            this.bou.Ls();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bot.Q(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.mario.gldraw2d.c.c cVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.bot.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(long j) {
        if (Build.VERSION.SDK_INT >= 18 && this.bou != null) {
            this.bou.cE(false);
            this.bot.aE(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lm() {
        if (Build.VERSION.SDK_INT >= 18 && this.bou != null) {
            this.bou.cE(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ln() {
        if (Build.VERSION.SDK_INT >= 18 && this.bou != null) {
            this.bou.Lr();
            this.bou.Lq();
            this.bou = null;
            this.bnT = null;
            this.bot.Kb();
            this.bot = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lo() {
        if (this.bos != null) {
            this.bos.removeCallbacksAndMessages(null);
            this.bos = null;
        }
        if (this.bor != null) {
            this.bor.quit();
            this.bor = null;
        }
    }

    /* loaded from: classes11.dex */
    class a {
        d bnu;
        ArrayList<com.baidu.mario.gldraw2d.params.c> boc;

        public a(ArrayList<com.baidu.mario.gldraw2d.params.c> arrayList, d dVar) {
            this.boc = arrayList;
            this.bnu = dVar;
        }
    }
}
