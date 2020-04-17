package com.baidu.ar.child;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.media.ExifInterface;
import com.baidu.ar.child.b.b;
/* loaded from: classes3.dex */
public class a implements com.baidu.a {
    private CropAlgo kt;
    private Handler kv;
    private InterfaceC0057a kw;
    private boolean ky;
    private com.baidu.ar.child.b.b kz;
    private boolean kx = true;
    private HandlerThread ku = new HandlerThread("ChildAlgoController");

    /* renamed from: com.baidu.ar.child.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0057a {
        void k(long j);
    }

    /* loaded from: classes3.dex */
    private static class b extends Handler {
        private com.baidu.a kC;

        public b(Looper looper, com.baidu.a aVar) {
            super(looper);
            this.kC = aVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.kC != null) {
                this.kC.handleMessage(message);
            }
        }
    }

    public a() {
        this.ku.start();
        this.kv = new b(this.ku.getLooper(), this);
        this.kz = new com.baidu.ar.child.b.b();
        if (this.kt == null) {
            this.kt = new CropAlgo();
        }
    }

    private byte[] a(long j, byte[] bArr, int i, float f, float[] fArr, float[] fArr2, boolean z) {
        if (j <= 0 || c(fArr) || c(fArr2)) {
            return null;
        }
        return this.kt.nativeCorpFace(j, bArr, i, f, fArr, fArr2, z);
    }

    private boolean c(float[] fArr) {
        return fArr == null || fArr.length <= 0;
    }

    private void clear() {
        if (this.ku != null) {
            this.ku.getLooper().quit();
            this.ku = null;
        }
        if (this.ky && this.kt != null) {
            this.kt.nativeClear();
            this.kt = null;
        }
        this.ky = false;
        this.kw = null;
        if (this.kv != null) {
            this.kv = null;
        }
    }

    public long a(long j, byte[] bArr) {
        if (j <= 0) {
            return 0L;
        }
        return this.kt.nativeWriteFaceDataToHandel(j, bArr);
    }

    public long a(long j, byte[] bArr, int i, int i2, int i3, float f) {
        if (j <= 0) {
            return 0L;
        }
        return this.kt.nativeWriteCameraDataToHandel(j, bArr, i, i2, i3, f);
    }

    public void a(InterfaceC0057a interfaceC0057a) {
        this.kw = interfaceC0057a;
    }

    public void a(com.baidu.ar.child.b bVar) {
        if (this.kv == null || !this.kx) {
            return;
        }
        this.kv.removeMessages(1002);
        this.kv.sendMessage(this.kv.obtainMessage(1002, bVar));
    }

    public void cb() {
        if (this.kv != null) {
            this.kv.removeMessages(1003);
            this.kv.sendMessage(this.kv.obtainMessage(1003));
        }
    }

    @Override // com.baidu.a
    public void handleMessage(Message message) {
        String str;
        switch (message.what) {
            case 1002:
                final com.baidu.ar.child.b bVar = (com.baidu.ar.child.b) message.obj;
                if (bVar != null) {
                    com.baidu.ar.child.a.a cc = bVar.cc();
                    byte[] a = a(bVar.ce().bv(), cc.cf(), cc.getDegree(), bVar.cd(), bVar.ce().ch(), bVar.ce().ci(), cc.cg());
                    this.ky = true;
                    if (a == null || a.length <= 0) {
                        return;
                    }
                    switch (cc.getDegree()) {
                        case -90:
                            str = "HR";
                            break;
                        case 0:
                            str = ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
                            break;
                        case 90:
                            str = "HL";
                            break;
                        case 180:
                            str = "FV";
                            break;
                        default:
                            str = ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
                            break;
                    }
                    this.kz.a(a, str, new b.a() { // from class: com.baidu.ar.child.a.1
                        @Override // com.baidu.ar.child.b.b.a
                        public void d(byte[] bArr) {
                            if (bArr == null) {
                                return;
                            }
                            a.this.a(bVar.ce().bv(), bArr);
                            if (a.this.kw != null) {
                                a.this.kw.k(bVar.ce().bv());
                            }
                        }
                    });
                    return;
                }
                return;
            case 1003:
                clear();
                if (this.kv != null) {
                    this.kv.removeCallbacksAndMessages(null);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public float[] l(long j) {
        if (j <= 0) {
            return null;
        }
        return this.kt.nativeTrackingPoints(j);
    }

    public float[] m(long j) {
        if (j <= 0) {
            return null;
        }
        return this.kt.nativeGetFaceBoxList(j);
    }

    public void n(long j) {
        if (j <= 0) {
            return;
        }
        this.kt.nativeWriteTypeToHandle(j);
    }
}
