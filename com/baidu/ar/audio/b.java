package com.baidu.ar.audio;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public class b {
    public static final String TAG = "b";
    public static volatile b iF;
    public c iC;
    public HandlerThread iD;
    public Handler iE;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    b.this.a((AudioParams) message.obj);
                    return;
                case 1002:
                    b.this.ck();
                    return;
                case 1003:
                    b.this.cl();
                    return;
                case 1004:
                    b.this.cm();
                    return;
                case 1005:
                    b.this.cn();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AudioParams audioParams) {
        c cVar = this.iC;
        if (cVar != null) {
            cVar.b(audioParams);
        }
    }

    public static b cf() {
        if (iF == null) {
            synchronized (b.class) {
                if (iF == null) {
                    iF = new b();
                }
            }
        }
        return iF;
    }

    private void cg() {
        HandlerThread handlerThread = new HandlerThread("AudioHandlerThread");
        this.iD = handlerThread;
        handlerThread.start();
        this.iE = new a(this.iD.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck() {
        c cVar = this.iC;
        if (cVar != null) {
            cVar.co();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl() {
        c cVar = this.iC;
        if (cVar != null) {
            cVar.cp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm() {
        c cVar = this.iC;
        if (cVar != null) {
            cVar.cq();
        }
        this.iC = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn() {
        releaseInstance();
        Handler handler = this.iE;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.iE = null;
        }
        HandlerThread handlerThread = this.iD;
        if (handlerThread != null) {
            handlerThread.quit();
            this.iD = null;
        }
    }

    public static void releaseInstance() {
        iF = null;
    }

    public boolean a(AudioParams audioParams, com.baidu.ar.audio.a aVar) {
        if (isRunning()) {
            com.baidu.ar.h.b.b(TAG, "setupAudio error! As last audio thread is alive!");
            return false;
        }
        if (this.iC == null) {
            this.iC = new c();
        }
        this.iC.a(aVar);
        cg();
        Handler handler = this.iE;
        handler.sendMessage(handler.obtainMessage(1001, audioParams));
        return true;
    }

    public void ch() {
        cl();
    }

    public void ci() {
        Handler handler = this.iE;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            Handler handler2 = this.iE;
            handler2.sendMessage(handler2.obtainMessage(1004));
            Handler handler3 = this.iE;
            handler3.sendMessage(handler3.obtainMessage(1005));
        }
    }

    public AudioParams cj() {
        c cVar = this.iC;
        if (cVar != null) {
            return cVar.cj();
        }
        return null;
    }

    public boolean isRunning() {
        HandlerThread handlerThread = this.iD;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void setVolumeListener(VolumeListener volumeListener) {
        if (volumeListener != null) {
            if (this.iC == null) {
                this.iC = new c();
            }
            this.iC.setVolumeListener(volumeListener);
        }
    }

    public void startAudio() {
        Handler handler = this.iE;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(1002));
        }
    }
}
