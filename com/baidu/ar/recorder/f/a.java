package com.baidu.ar.recorder.f;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.ar.recorder.d.c;
import com.baidu.ar.recorder.d.d;
import com.baidu.ar.recorder.d.e;
import com.baidu.baiduarsdk.ArBridge;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class a implements com.baidu.ar.recorder.a.a {
    private static final String a = a.class.getSimpleName();
    private static volatile a g;
    private HandlerThread b;
    private Handler c;
    private com.baidu.ar.recorder.d.a d;
    private e e;
    private volatile boolean f = false;

    /* renamed from: com.baidu.ar.recorder.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class C0040a {
        ByteBuffer a;
        int b;
        long c;

        public C0040a(ByteBuffer byteBuffer, int i, long j) {
            this.a = byteBuffer;
            this.b = i;
            this.c = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b extends Handler {
        private com.baidu.ar.recorder.a.a a;

        public b(Looper looper, com.baidu.ar.recorder.a.a aVar) {
            super(looper);
            this.a = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.a.a(message);
        }
    }

    private a() {
    }

    public static a a() {
        if (g == null) {
            synchronized (a.class) {
                if (g == null) {
                    g = new a();
                }
            }
        }
        return g;
    }

    private void a(d dVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.d.a(dVar, this.e);
        }
    }

    private void a(e eVar, c cVar) {
        this.b = new HandlerThread("AudioRecorderThread");
        this.b.start();
        this.c = new b(this.b.getLooper(), this);
        this.d = new com.baidu.ar.recorder.d.a();
        this.e = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.d.a(cVar);
        }
    }

    private void b(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.d.a(false, byteBuffer, i, j);
        }
    }

    private void f() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.d.d();
        }
    }

    private void g() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.d.a(true, (ByteBuffer) null, 0, 0L);
        }
    }

    private void h() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.d.c();
            this.d.b();
            this.d = null;
            this.e = null;
        }
    }

    private void i() {
        this.b.quit();
        this.b = null;
        this.c = null;
        g = null;
    }

    @Override // com.baidu.ar.recorder.a.a
    public void a(Message message) {
        switch (message.what) {
            case 1001:
                a((d) message.obj);
                return;
            case 1002:
                f();
                return;
            case 1003:
                C0040a c0040a = (C0040a) message.obj;
                b(c0040a.a, c0040a.b, c0040a.c);
                return;
            case 1004:
                g();
                return;
            case ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC /* 1005 */:
                h();
                return;
            case 1006:
                i();
                return;
            default:
                return;
        }
    }

    public void a(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer == null || i <= 0) {
            return;
        }
        C0040a c0040a = new C0040a(byteBuffer, i, j);
        if (this.c == null || !this.f) {
            return;
        }
        this.c.sendMessage(this.c.obtainMessage(1003, c0040a));
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (b()) {
            Log.e(a, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.c.sendMessage(this.c.obtainMessage(1001, dVar));
        this.f = true;
        return true;
    }

    public boolean b() {
        return this.b != null && this.b.isAlive();
    }

    public void c() {
        if (this.c != null) {
            this.c.sendMessage(this.c.obtainMessage(1002));
        }
    }

    public void d() {
        if (this.c == null || !this.f) {
            return;
        }
        this.f = false;
        this.c.sendMessage(this.c.obtainMessage(1004));
    }

    public void e() {
        if (this.c != null) {
            this.c.sendMessage(this.c.obtainMessage(ArBridge.MessageType.MSG_TYPE_RESUME_MUSIC));
            this.c.sendMessage(this.c.obtainMessage(1006));
        }
    }
}
