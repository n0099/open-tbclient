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
import java.nio.ByteBuffer;
/* loaded from: classes14.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private e caN;
    private HandlerThread cbd;
    private Handler cbe;
    private com.baidu.mario.a.b.a cbf;
    private volatile boolean cbg = false;

    private void a(e eVar, c cVar) {
        this.cbd = new HandlerThread("AudioRecorderThread");
        this.cbd.start();
        this.cbe = new b(this.cbd.getLooper());
        try {
            this.cbf = new com.baidu.mario.a.b.a();
        } catch (VerifyError e) {
            Log.e(TAG, "initRecorder verifyError");
            if (this.cbf == null) {
                return;
            }
        }
        this.caN = eVar;
        if (Build.VERSION.SDK_INT >= 18) {
            this.cbf.a(cVar);
        }
    }

    public boolean isRunning() {
        return this.cbd != null && this.cbd.isAlive();
    }

    public boolean a(d dVar, e eVar, c cVar) {
        if (isRunning()) {
            Log.e(TAG, "setupRecorder error! As last audio recorder thread is alive!");
            return false;
        }
        a(eVar, cVar);
        this.cbe.sendMessage(this.cbe.obtainMessage(1001, dVar));
        this.cbg = true;
        return true;
    }

    public void startRecording() {
        if (this.cbe != null) {
            this.cbe.sendMessage(this.cbe.obtainMessage(1002));
        }
    }

    public void d(ByteBuffer byteBuffer, int i, long j) {
        if (byteBuffer != null && i > 0) {
            C0266a c0266a = new C0266a(byteBuffer, i, j);
            if (this.cbe != null && this.cbg) {
                this.cbe.sendMessage(this.cbe.obtainMessage(1003, c0266a));
            }
        }
    }

    public void stopRecording() {
        if (this.cbe != null && this.cbg) {
            this.cbg = false;
            this.cbe.sendMessage(this.cbe.obtainMessage(1004));
        }
    }

    public void abs() {
        if (this.cbe != null) {
            this.cbe.removeCallbacksAndMessages(null);
            this.cbe.sendMessage(this.cbe.obtainMessage(1005));
            this.cbe.sendMessage(this.cbe.obtainMessage(1006));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
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
                    a.this.abt();
                    return;
                case 1003:
                    C0266a c0266a = (C0266a) message.obj;
                    a.this.e(c0266a.cbh, c0266a.cbi, c0266a.cbj);
                    return;
                case 1004:
                    a.this.abu();
                    return;
                case 1005:
                    a.this.abv();
                    return;
                case 1006:
                    a.this.abw();
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(d dVar) {
        if (Build.VERSION.SDK_INT >= 18 && this.cbf != null) {
            this.cbf.a(dVar, this.caN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abt() {
        if (Build.VERSION.SDK_INT >= 18) {
            this.cbf.abE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ByteBuffer byteBuffer, int i, long j) {
        if (Build.VERSION.SDK_INT >= 18) {
            this.cbf.b(false, byteBuffer, i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abu() {
        if (Build.VERSION.SDK_INT >= 18 && this.cbf != null) {
            this.cbf.b(true, (ByteBuffer) null, 0, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abv() {
        if (Build.VERSION.SDK_INT >= 18) {
            if (this.cbf != null) {
                this.cbf.abD();
                this.cbf.abC();
            }
            this.cbf = null;
            this.caN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abw() {
        if (this.cbe != null) {
            this.cbe.removeCallbacksAndMessages(null);
            this.cbe = null;
        }
        if (this.cbd != null) {
            this.cbd.quit();
            this.cbd = null;
        }
    }

    /* renamed from: com.baidu.mario.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    private class C0266a {
        ByteBuffer cbh;
        int cbi;
        long cbj;

        public C0266a(ByteBuffer byteBuffer, int i, long j) {
            this.cbh = byteBuffer;
            this.cbi = i;
            this.cbj = j;
        }
    }
}
