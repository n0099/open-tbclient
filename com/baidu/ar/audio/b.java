package com.baidu.ar.audio;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes11.dex */
public class b {
    private static final String TAG = b.class.getSimpleName();
    private static volatile b iq;
    private c in;

    /* renamed from: io  reason: collision with root package name */
    private HandlerThread f959io;
    private Handler ip;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
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
                    b.this.cl();
                    return;
                case 1003:
                    b.this.cm();
                    return;
                case 1004:
                    b.this.cn();
                    return;
                case 1005:
                    b.this.co();
                    return;
                default:
                    return;
            }
        }
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AudioParams audioParams) {
        if (this.in != null) {
            this.in.b(audioParams);
        }
    }

    public static b cg() {
        if (iq == null) {
            synchronized (b.class) {
                if (iq == null) {
                    iq = new b();
                }
            }
        }
        return iq;
    }

    private void ch() {
        this.f959io = new HandlerThread("AudioHandlerThread");
        this.f959io.start();
        this.ip = new a(this.f959io.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl() {
        if (this.in != null) {
            this.in.cp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm() {
        if (this.in != null) {
            this.in.cq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn() {
        if (this.in != null) {
            this.in.cr();
        }
        this.in = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co() {
        releaseInstance();
        if (this.ip != null) {
            this.ip.removeCallbacksAndMessages(null);
            this.ip = null;
        }
        if (this.f959io != null) {
            this.f959io.quit();
            this.f959io = null;
        }
    }

    private static void releaseInstance() {
        iq = null;
    }

    public boolean a(AudioParams audioParams, com.baidu.ar.audio.a aVar) {
        if (isRunning()) {
            com.baidu.ar.g.b.b(TAG, "setupAudio error! As last audio thread is alive!");
            return false;
        }
        if (this.in == null) {
            this.in = new c();
        }
        this.in.a(aVar);
        ch();
        this.ip.sendMessage(this.ip.obtainMessage(1001, audioParams));
        return true;
    }

    public void ci() {
        cm();
    }

    public void cj() {
        if (this.ip != null) {
            this.ip.removeCallbacksAndMessages(null);
            this.ip.sendMessage(this.ip.obtainMessage(1004));
            this.ip.sendMessage(this.ip.obtainMessage(1005));
        }
    }

    public AudioParams ck() {
        if (this.in != null) {
            return this.in.ck();
        }
        return null;
    }

    public boolean isRunning() {
        return this.f959io != null && this.f959io.isAlive();
    }

    public void setVolumeListener(VolumeListener volumeListener) {
        if (volumeListener != null) {
            if (this.in == null) {
                this.in = new c();
            }
            this.in.setVolumeListener(volumeListener);
        }
    }

    public void startAudio() {
        if (this.ip != null) {
            this.ip.sendMessage(this.ip.obtainMessage(1002));
        }
    }
}
