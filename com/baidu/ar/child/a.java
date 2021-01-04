package com.baidu.ar.child;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes6.dex */
public class a {
    private CropAlgo lL;
    private Handler lN;
    private InterfaceC0076a lO;
    private boolean lQ;
    private d lR;
    private int mInputHeight;
    private int mInputWidth;
    private boolean lP = true;
    private HandlerThread lM = new HandlerThread("ChildAlgoController");

    /* renamed from: com.baidu.ar.child.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0076a {
        void a(long j, byte[] bArr, int i);
    }

    /* loaded from: classes6.dex */
    private static class b extends Handler {
        private c lS;

        public b(Looper looper, c cVar) {
            super(looper);
            this.lS = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.lS != null) {
                this.lS.handleMessage(message);
            }
        }
    }

    /* loaded from: classes6.dex */
    private interface c {
        void handleMessage(Message message);
    }

    /* loaded from: classes6.dex */
    class d implements c {
        d() {
        }

        @Override // com.baidu.ar.child.a.c
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1002:
                    com.baidu.ar.child.b bVar = (com.baidu.ar.child.b) message.obj;
                    if (bVar != null) {
                        com.baidu.ar.child.a.a cR = bVar.cR();
                        long cY = bVar.cT().cY();
                        com.baidu.ar.child.c cVar = new com.baidu.ar.child.c();
                        cVar.w(cR.getDegree());
                        cVar.f(cR.cW());
                        cVar.c(bVar.cT().cZ());
                        cVar.d(bVar.cT().cV());
                        cVar.c(bVar.cS());
                        cVar.setHandle(cY);
                        cVar.u(bVar.cR().cX());
                        cVar.setWidth(a.this.mInputWidth);
                        cVar.setHeight(a.this.mInputHeight);
                        byte[] a2 = a.this.a(cVar);
                        a.this.lQ = true;
                        if (a.this.lO != null) {
                            a.this.lO.a(cY, a2, cR.getDegree());
                            return;
                        }
                        return;
                    }
                    return;
                case 1003:
                    a.this.clear();
                    if (a.this.lN != null) {
                        a.this.lN.removeCallbacksAndMessages(null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public a(int i, int i2) {
        this.mInputHeight = i2;
        this.mInputWidth = i;
        this.lM.start();
        if (this.lR == null) {
            this.lR = new d();
        }
        this.lN = new b(this.lM.getLooper(), this.lR);
        if (this.lL == null) {
            this.lL = new CropAlgo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] a(com.baidu.ar.child.c cVar) {
        if (cVar.getHandle() <= 0 || b(cVar.cU()) || b(cVar.cV())) {
            return null;
        }
        return this.lL.nativeCorpFace(cVar);
    }

    private boolean b(float[] fArr) {
        return fArr == null || fArr.length <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clear() {
        if (this.lM != null) {
            this.lM.getLooper().quit();
            this.lM = null;
        }
        if (this.lQ && this.lL != null) {
            this.lL.nativeClear();
            this.lL = null;
        }
        this.lQ = false;
        this.lO = null;
        if (this.lN != null) {
            this.lN = null;
        }
    }

    public long a(long j, byte[] bArr) {
        if (j <= 0) {
            return 0L;
        }
        return this.lL.nativeWriteFaceDataToHandel(j, bArr);
    }

    public long a(long j, byte[] bArr, int i, int i2, float f) {
        if (j <= 0) {
            return 0L;
        }
        return this.lL.nativeWriteCameraDataToHandel(j, bArr, i, i2, f);
    }

    public void a(InterfaceC0076a interfaceC0076a) {
        this.lO = interfaceC0076a;
    }

    public void a(com.baidu.ar.child.b bVar) {
        if (this.lN == null || !this.lP) {
            return;
        }
        this.lN.removeMessages(1002);
        this.lN.sendMessage(this.lN.obtainMessage(1002, bVar));
    }

    public void cQ() {
        if (this.lN != null) {
            this.lN.removeMessages(1003);
            this.lN.sendMessage(this.lN.obtainMessage(1003));
        }
    }

    public float[] i(long j) {
        if (j <= 0) {
            return null;
        }
        return this.lL.nativeTrackingPoints(j);
    }

    public float[] j(long j) {
        if (j <= 0) {
            return null;
        }
        return this.lL.nativeGetFaceBoxList(j);
    }

    public void k(long j) {
        if (j <= 0) {
            return;
        }
        this.lL.nativeWriteTypeToHandle(j);
    }
}
