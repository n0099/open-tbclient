package com.baidu.ar.child;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes11.dex */
public class a {
    private int R;
    private int S;
    private CropAlgo kN;
    private Handler kP;
    private InterfaceC0082a kQ;
    private boolean kS;
    private d kT;
    private boolean kR = true;
    private HandlerThread kO = new HandlerThread("ChildAlgoController");

    /* renamed from: com.baidu.ar.child.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0082a {
        void a(long j, byte[] bArr, int i);
    }

    /* loaded from: classes11.dex */
    private static class b extends Handler {
        private c kU;

        public b(Looper looper, c cVar) {
            super(looper);
            this.kU = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.kU != null) {
                this.kU.handleMessage(message);
            }
        }
    }

    /* loaded from: classes11.dex */
    private interface c {
        void handleMessage(Message message);
    }

    /* loaded from: classes11.dex */
    class d implements c {
        d() {
        }

        @Override // com.baidu.ar.child.a.c
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1002:
                    com.baidu.ar.child.b bVar = (com.baidu.ar.child.b) message.obj;
                    if (bVar != null) {
                        com.baidu.ar.child.a.a cs = bVar.cs();
                        long cz = bVar.cu().cz();
                        com.baidu.ar.child.c cVar = new com.baidu.ar.child.c();
                        cVar.x(cs.getDegree());
                        cVar.f(cs.cx());
                        cVar.d(bVar.cu().cA());
                        cVar.e(bVar.cu().cw());
                        cVar.d(bVar.ct());
                        cVar.setHandle(cz);
                        cVar.v(bVar.cs().cy());
                        cVar.setWidth(a.this.R);
                        cVar.setHeight(a.this.S);
                        byte[] a = a.this.a(cVar);
                        a.this.kS = true;
                        if (a.this.kQ != null) {
                            a.this.kQ.a(cz, a, cs.getDegree());
                            return;
                        }
                        return;
                    }
                    return;
                case 1003:
                    a.this.clear();
                    if (a.this.kP != null) {
                        a.this.kP.removeCallbacksAndMessages(null);
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
        this.kO.start();
        if (this.kT == null) {
            this.kT = new d();
        }
        this.kP = new b(this.kO.getLooper(), this.kT);
        if (this.kN == null) {
            this.kN = new CropAlgo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] a(com.baidu.ar.child.c cVar) {
        if (cVar.getHandle() <= 0 || c(cVar.cv()) || c(cVar.cw())) {
            return null;
        }
        return this.kN.nativeCorpFace(cVar);
    }

    private boolean c(float[] fArr) {
        return fArr == null || fArr.length <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clear() {
        if (this.kO != null) {
            this.kO.getLooper().quit();
            this.kO = null;
        }
        if (this.kS && this.kN != null) {
            this.kN.nativeClear();
            this.kN = null;
        }
        this.kS = false;
        this.kQ = null;
        if (this.kP != null) {
            this.kP = null;
        }
    }

    public long a(long j, byte[] bArr) {
        if (j <= 0) {
            return 0L;
        }
        return this.kN.nativeWriteFaceDataToHandel(j, bArr);
    }

    public long a(long j, byte[] bArr, int i, int i2, float f) {
        if (j <= 0) {
            return 0L;
        }
        return this.kN.nativeWriteCameraDataToHandel(j, bArr, i, i2, f);
    }

    public void a(InterfaceC0082a interfaceC0082a) {
        this.kQ = interfaceC0082a;
    }

    public void a(com.baidu.ar.child.b bVar) {
        if (this.kP == null || !this.kR) {
            return;
        }
        this.kP.removeMessages(1002);
        this.kP.sendMessage(this.kP.obtainMessage(1002, bVar));
    }

    public void cr() {
        if (this.kP != null) {
            this.kP.removeMessages(1003);
            this.kP.sendMessage(this.kP.obtainMessage(1003));
        }
    }

    public float[] k(long j) {
        if (j <= 0) {
            return null;
        }
        return this.kN.nativeTrackingPoints(j);
    }

    public float[] l(long j) {
        if (j <= 0) {
            return null;
        }
        return this.kN.nativeGetFaceBoxList(j);
    }

    public void m(long j) {
        if (j <= 0) {
            return;
        }
        this.kN.nativeWriteTypeToHandle(j);
    }
}
