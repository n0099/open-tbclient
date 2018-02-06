package com.baidu.ar.audio;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
/* loaded from: classes3.dex */
public class b implements e {
    private static final String a = b.class.getSimpleName();
    private static volatile b e;
    private c b;
    private HandlerThread c;
    private Handler d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends Handler {
        private e a;

        public a(Looper looper, e eVar) {
            super(looper);
            this.a = eVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.a.a(message);
        }
    }

    private b() {
    }

    public static b a() {
        if (e == null) {
            synchronized (b.class) {
                if (e == null) {
                    e = new b();
                }
            }
        }
        return e;
    }

    private void a(AudioParams audioParams) {
        if (this.b != null) {
            this.b.a(audioParams);
        }
    }

    private void f() {
        this.c = new HandlerThread("AudioHandlerThread");
        this.c.start();
        this.d = new a(this.c.getLooper(), this);
    }

    private void g() {
        if (this.b != null) {
            this.b.a();
        }
    }

    private void h() {
        if (this.b != null) {
            this.b.b();
        }
    }

    private void i() {
        if (this.b != null) {
            this.b.c();
        }
        this.b = null;
    }

    private void j() {
        this.c.getLooper().quit();
        this.c = null;
        this.d = null;
        e = null;
    }

    @Override // com.baidu.ar.audio.e
    public void a(Message message) {
        switch (message.what) {
            case 1001:
                a((AudioParams) message.obj);
                return;
            case 1002:
                g();
                return;
            case 1003:
                h();
                return;
            case 1004:
                i();
                return;
            case 1005:
                j();
                return;
            default:
                return;
        }
    }

    public boolean a(Context context) {
        return d.a(context);
    }

    public boolean a(AudioParams audioParams, com.baidu.ar.audio.a aVar) {
        if (b()) {
            Log.e(a, "setupAudioEngine error! As last audio thread is alive!");
            return false;
        }
        if (this.b == null) {
            this.b = new c();
        }
        this.b.a(aVar);
        f();
        this.d.sendMessage(this.d.obtainMessage(1001, audioParams));
        return true;
    }

    public boolean b() {
        return this.c != null && this.c.isAlive();
    }

    public void c() {
        if (this.d != null) {
            this.d.sendMessage(this.d.obtainMessage(1002));
        }
    }

    public void d() {
        h();
    }

    public void e() {
        if (this.d != null) {
            this.d.sendMessage(this.d.obtainMessage(1004));
            this.d.sendMessage(this.d.obtainMessage(1005));
        }
    }
}
