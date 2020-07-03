package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES30;
import android.os.HandlerThread;
import android.view.Surface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class f extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback {
    private com.baidu.rtc.camera.engine.a.b bHN;
    private d bHO;
    private final Object bHQ;
    private final Object bHX;
    private final Object bHY;
    private boolean bHZ;
    private com.baidu.rtc.camera.filter.a.a bHh;
    private int bHr;
    private int bHs;
    private boolean bIa;
    private boolean bIb;
    private boolean bIc;
    private com.baidu.rtc.camera.filter.a.c bId;
    private int bIe;
    private int bIf;
    private final float[] bIg;
    private int bIh;
    private a bIi;
    private e bIj;
    private com.baidu.rtc.camera.a.a bIk;
    private Context mContext;
    private SurfaceTexture mSurfaceTexture;
    private long time;

    public f(Context context, String str) {
        super(str);
        this.bHQ = new Object();
        this.bHX = new Object();
        this.bHY = new Object();
        this.bHZ = false;
        this.bIa = false;
        this.bIb = false;
        this.bIc = false;
        this.bIg = new float[16];
        this.bIh = 0;
        this.time = 0L;
        this.mContext = context;
        this.bHN = com.baidu.rtc.camera.engine.a.b.Qw();
        this.bIj = e.QF();
        this.bIi = new a();
    }

    public void a(d dVar) {
        this.bHO = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this.bHQ) {
            if (this.bHZ || this.bIa) {
                this.bHO.sendMessage(this.bHO.obtainMessage(17, bArr));
            }
        }
        if (this.bHO != null && this.bHN.bHz) {
            this.bHO.sendEmptyMessage(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(byte[] bArr) {
        if (this.bHN.bHI != null) {
            this.bHN.bHI.E(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Surface surface) {
        this.bHh = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.bId = new com.baidu.rtc.camera.filter.a.c(this.bHh, surface, false);
        this.bId.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.bIj.init(this.mContext);
        if (this.bIk == null) {
            this.bIk = new com.baidu.rtc.camera.a.a(this.mContext, this.bHh);
        }
        this.bIe = com.baidu.rtc.camera.filter.glfilter.utils.a.QV();
        this.mSurfaceTexture = new SurfaceTexture(this.bIe);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        QO();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.bHh = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.bId = new com.baidu.rtc.camera.filter.a.c(this.bHh, surfaceTexture);
        this.bId.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.bIj.init(this.mContext);
        if (this.bIk == null) {
            this.bIk = new com.baidu.rtc.camera.a.a(this.mContext, this.bHh);
        }
        this.bIe = com.baidu.rtc.camera.filter.glfilter.utils.a.QV();
        this.mSurfaceTexture = new SurfaceTexture(this.bIe);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        QO();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceChanged(int i, int i2) {
        this.bIj.T(i, i2);
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceDestroyed() {
        this.bId.makeCurrent();
        this.bIj.release();
        if (this.bIk != null) {
            this.bIk.release();
            this.bIk = null;
        }
        releaseCamera();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        if (this.bId != null) {
            this.bId.release();
            this.bId = null;
        }
        if (this.bHh != null) {
            this.bHh.release();
            this.bHh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void QL() {
        if (this.mSurfaceTexture != null && this.bId != null) {
            while (this.bIh > 0) {
                this.bId.makeCurrent();
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.bIg);
                this.bIh--;
                this.bIf = this.bIj.a(this.bIe, this.bIg);
                this.bId.swapBuffers();
                if (this.bIa && !this.bIb && this.bIk != null) {
                    if (this.bIc) {
                        this.bIk.Qs();
                        this.bIc = false;
                    }
                    this.bIk.f(this.bIf, System.nanoTime());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void QM() {
        if (this.bHN.bHJ != null) {
            this.bIi.QA();
            this.bHN.bHJ.A(this.bIi.QB());
        }
    }

    private void QN() {
        if (this.bHN.orientation == 90 || this.bHN.orientation == 270) {
            this.bHr = this.bHN.previewHeight;
            this.bHs = this.bHN.previewWidth;
        } else {
            this.bHr = this.bHN.previewWidth;
            this.bHs = this.bHN.previewHeight;
        }
        this.bIj.S(this.bHr, this.bHs);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startRecording() {
        this.bIa = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopRecording() {
        this.bIc = true;
        this.bIa = false;
    }

    public void requestRender() {
        synchronized (this.bHX) {
            if (this.bHZ) {
                this.bIh++;
                if (this.bHO != null) {
                    this.bHO.sendMessage(this.bHO.obtainMessage(4));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void QO() {
        releaseCamera();
        com.baidu.rtc.camera.engine.a.a.Qv().aO(this.mContext);
        com.baidu.rtc.camera.engine.a.a.Qv().b(this.mSurfaceTexture);
        QN();
        com.baidu.rtc.camera.engine.a.a.Qv().setPreviewCallback(this);
        if (this.bHN.bHI != null) {
            this.bHN.bHI.Qx();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchCamera() {
        this.bHN.bHG = !this.bHN.bHG;
        if (this.bHN.bHG) {
            this.bHN.cameraId = 0;
        } else {
            this.bHN.cameraId = 1;
        }
        QO();
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPreview() {
        com.baidu.rtc.camera.engine.a.a.Qv().startPreview();
        this.bHZ = true;
    }

    private void releaseCamera() {
        this.bHZ = false;
        com.baidu.rtc.camera.engine.a.a.Qv().releaseCamera();
    }
}
