package com.baidu.mario.b.a;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import android.util.Log;
import com.baidu.mario.b.b.c;
import com.baidu.mario.b.b.d;
import com.baidu.mario.b.b.e;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private e adU;
    private HandlerThread aek;
    private Handler ael;
    private com.baidu.mario.b.b.a aem;
    private volatile boolean aen = false;

    private void a(e eVar, c cVar) {
        this.aek = new HandlerThread("AudioRecorderThread");
        this.aek.start();
        this.ael = new b(this.aek.getLooper());
        this.aem = new com.baidu.mario.b.b.a();
        this.adU = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.aem.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.aek != null && this.aek.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.ael.sendMessage(this.ael.obtainMessage(1001, dVar));
        this.aen = true;
        return true;
    }

    public void startRecording() {
        if (this.ael != null) {
            this.ael.sendMessage(this.ael.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0060a c0060a = new C0060a(byteBuffer, i, j);
            if (this.ael != null && this.aen) {
                this.ael.sendMessage(this.ael.obtainMessage(1003, c0060a));
            }
        }
    }

    public void stopRecording() {
        if (this.ael != null && this.aen) {
            this.aen = false;
            this.ael.sendMessage(this.ael.obtainMessage(1004));
        }
    }

    public void tf() {
        if (this.ael != null) {
            this.ael.removeCallbacksAndMessages(null);
            this.ael.sendMessage(this.ael.obtainMessage(1005));
            this.ael.sendMessage(this.ael.obtainMessage(PointerIconCompat.TYPE_CELL));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    a.this.b((d) message.obj);
                    return;
                case 1002:
                    a.this.tg();
                    return;
                case 1003:
                    C0060a c0060a = (C0060a) message.obj;
                    a.this.e(c0060a.aeo, c0060a.aep, c0060a.aeq);
                    return;
                case 1004:
                    a.this.th();
                    return;
                case 1005:
                    a.this.ti();
                    return;
                case PointerIconCompat.TYPE_CELL /* 1006 */:
                    a.this.tj();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aem.a(dVar, this.adU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tg() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aem.tr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aem.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aem.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ti() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.aem.tq();
            this.aem.tp();
            this.aem = null;
            this.adU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj() {
        if (this.ael != null) {
            this.ael.removeCallbacksAndMessages(null);
            this.ael = null;
        }
        if (this.aek != null) {
            this.aek.quit();
            this.aek = null;
        }
    }

    /* renamed from: com.baidu.mario.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0060a {
        ByteBuffer aeo;
        int aep;
        long aeq;

        public C0060a(ByteBuffer byteBuffer, int i, long j) {
            this.aeo = byteBuffer;
            this.aep = i;
            this.aeq = j;
        }
    }
}
