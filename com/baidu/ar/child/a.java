package com.baidu.ar.child;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public class a {
    public CropAlgo lL;
    public HandlerThread lM;
    public Handler lN;
    public InterfaceC0059a lO;
    public boolean lP = true;
    public boolean lQ;
    public d lR;
    public int mInputHeight;
    public int mInputWidth;

    /* renamed from: com.baidu.ar.child.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0059a {
        void a(long j, byte[] bArr, int i);
    }

    /* loaded from: classes.dex */
    public static class b extends Handler {
        public c lS;

        public b(Looper looper, c cVar) {
            super(looper);
            this.lS = cVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar = this.lS;
            if (cVar != null) {
                cVar.handleMessage(message);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void handleMessage(Message message);
    }

    /* loaded from: classes.dex */
    public class d implements c {
        public d() {
        }

        @Override // com.baidu.ar.child.a.c
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1002) {
                if (i != 1003) {
                    return;
                }
                a.this.clear();
                if (a.this.lN != null) {
                    a.this.lN.removeCallbacksAndMessages(null);
                    return;
                }
                return;
            }
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
                byte[] a = a.this.a(cVar);
                a.this.lQ = true;
                if (a.this.lO != null) {
                    a.this.lO.a(cY, a, cR.getDegree());
                }
            }
        }
    }

    public a(int i, int i2) {
        this.mInputHeight = i2;
        this.mInputWidth = i;
        HandlerThread handlerThread = new HandlerThread("ChildAlgoController");
        this.lM = handlerThread;
        handlerThread.start();
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
        CropAlgo cropAlgo;
        HandlerThread handlerThread = this.lM;
        if (handlerThread != null) {
            handlerThread.getLooper().quit();
            this.lM = null;
        }
        if (this.lQ && (cropAlgo = this.lL) != null) {
            cropAlgo.nativeClear();
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

    public void a(InterfaceC0059a interfaceC0059a) {
        this.lO = interfaceC0059a;
    }

    public void a(com.baidu.ar.child.b bVar) {
        Handler handler = this.lN;
        if (handler == null || !this.lP) {
            return;
        }
        handler.removeMessages(1002);
        Handler handler2 = this.lN;
        handler2.sendMessage(handler2.obtainMessage(1002, bVar));
    }

    public void cQ() {
        Handler handler = this.lN;
        if (handler != null) {
            handler.removeMessages(1003);
            Handler handler2 = this.lN;
            handler2.sendMessage(handler2.obtainMessage(1003));
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
