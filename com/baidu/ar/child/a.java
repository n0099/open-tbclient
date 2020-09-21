package com.baidu.ar.child;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes10.dex */
public class a {
    private int R;
    private int S;
    private boolean lB;
    private d lC;
    private CropAlgo lw;
    private Handler ly;
    private InterfaceC0081a lz;
    private boolean lA = true;
    private HandlerThread lx = new HandlerThread("ChildAlgoController");

    /* renamed from: com.baidu.ar.child.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0081a {
        void a(long j, byte[] bArr, int i);
    }

    /* loaded from: classes10.dex */
    private static class b extends Handler {
        private c lD;

        public b(Looper looper, c cVar) {
            super(looper);
            this.lD = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.lD != null) {
                this.lD.handleMessage(message);
            }
        }
    }

    /* loaded from: classes10.dex */
    private interface c {
        void handleMessage(Message message);
    }

    /* loaded from: classes10.dex */
    class d implements c {
        d() {
        }

        @Override // com.baidu.ar.child.a.c
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1002:
                    com.baidu.ar.child.b bVar = (com.baidu.ar.child.b) message.obj;
                    if (bVar != null) {
                        com.baidu.ar.child.a.a cS = bVar.cS();
                        long cZ = bVar.cU().cZ();
                        com.baidu.ar.child.c cVar = new com.baidu.ar.child.c();
                        cVar.u(cS.getDegree());
                        cVar.f(cS.cX());
                        cVar.d(bVar.cU().da());
                        cVar.e(bVar.cU().cW());
                        cVar.d(bVar.cT());
                        cVar.setHandle(cZ);
                        cVar.w(bVar.cS().cY());
                        cVar.setWidth(a.this.R);
                        cVar.setHeight(a.this.S);
                        byte[] a = a.this.a(cVar);
                        a.this.lB = true;
                        if (a.this.lz != null) {
                            a.this.lz.a(cZ, a, cS.getDegree());
                            return;
                        }
                        return;
                    }
                    return;
                case 1003:
                    a.this.clear();
                    if (a.this.ly != null) {
                        a.this.ly.removeCallbacksAndMessages(null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public a(int i, int i2) {
        this.S = i2;
        this.R = i;
        this.lx.start();
        if (this.lC == null) {
            this.lC = new d();
        }
        this.ly = new b(this.lx.getLooper(), this.lC);
        if (this.lw == null) {
            this.lw = new CropAlgo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] a(com.baidu.ar.child.c cVar) {
        if (cVar.getHandle() <= 0 || c(cVar.cV()) || c(cVar.cW())) {
            return null;
        }
        return this.lw.nativeCorpFace(cVar);
    }

    private boolean c(float[] fArr) {
        return fArr == null || fArr.length <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clear() {
        if (this.lx != null) {
            this.lx.getLooper().quit();
            this.lx = null;
        }
        if (this.lB && this.lw != null) {
            this.lw.nativeClear();
            this.lw = null;
        }
        this.lB = false;
        this.lz = null;
        if (this.ly != null) {
            this.ly = null;
        }
    }

    public long a(long j, byte[] bArr) {
        if (j <= 0) {
            return 0L;
        }
        return this.lw.nativeWriteFaceDataToHandel(j, bArr);
    }

    public long a(long j, byte[] bArr, int i, int i2, float f) {
        if (j <= 0) {
            return 0L;
        }
        return this.lw.nativeWriteCameraDataToHandel(j, bArr, i, i2, f);
    }

    public void a(InterfaceC0081a interfaceC0081a) {
        this.lz = interfaceC0081a;
    }

    public void a(com.baidu.ar.child.b bVar) {
        if (this.ly == null || !this.lA) {
            return;
        }
        this.ly.removeMessages(1002);
        this.ly.sendMessage(this.ly.obtainMessage(1002, bVar));
    }

    public void cR() {
        if (this.ly != null) {
            this.ly.removeMessages(1003);
            this.ly.sendMessage(this.ly.obtainMessage(1003));
        }
    }

    public float[] k(long j) {
        if (j <= 0) {
            return null;
        }
        return this.lw.nativeTrackingPoints(j);
    }

    public float[] l(long j) {
        if (j <= 0) {
            return null;
        }
        return this.lw.nativeGetFaceBoxList(j);
    }

    public void m(long j) {
        if (j <= 0) {
            return;
        }
        this.lw.nativeWriteTypeToHandle(j);
    }
}
