package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES30;
import android.os.HandlerThread;
import android.view.Surface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class f extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback {
    private com.baidu.rtc.camera.filter.a.a aQK;
    private int aQU;
    private int aQV;
    private final Object aRA;
    private final Object aRB;
    private boolean aRC;
    private boolean aRD;
    private boolean aRE;
    private boolean aRF;
    private com.baidu.rtc.camera.filter.a.c aRG;
    private int aRH;
    private int aRI;
    private final float[] aRJ;
    private a aRK;
    private e aRL;
    private com.baidu.rtc.camera.a.a aRM;
    private com.baidu.rtc.camera.engine.a.b aRq;
    private d aRr;
    private final Object aRt;
    private Context mContext;
    private int mFrameNum;
    private SurfaceTexture mSurfaceTexture;
    private long time;

    public f(Context context, String str) {
        super(str);
        this.aRt = new Object();
        this.aRA = new Object();
        this.aRB = new Object();
        this.aRC = false;
        this.aRD = false;
        this.aRE = false;
        this.aRF = false;
        this.aRJ = new float[16];
        this.mFrameNum = 0;
        this.time = 0L;
        this.mContext = context;
        this.aRq = com.baidu.rtc.camera.engine.a.b.Ct();
        this.aRL = e.CC();
        this.aRK = new a();
    }

    public void a(d dVar) {
        this.aRr = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this.aRt) {
            if (this.aRC || this.aRD) {
                this.aRr.sendMessage(this.aRr.obtainMessage(17, bArr));
            }
        }
        if (this.aRr != null && this.aRq.aRc) {
            this.aRr.sendEmptyMessage(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(byte[] bArr) {
        if (this.aRq.aRl != null) {
            this.aRq.aRl.o(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Surface surface) {
        this.aQK = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.aRG = new com.baidu.rtc.camera.filter.a.c(this.aQK, surface, false);
        this.aRG.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.aRL.init(this.mContext);
        if (this.aRM == null) {
            this.aRM = new com.baidu.rtc.camera.a.a(this.mContext, this.aQK);
        }
        this.aRH = com.baidu.rtc.camera.filter.glfilter.utils.a.CS();
        this.mSurfaceTexture = new SurfaceTexture(this.aRH);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        CL();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(SurfaceTexture surfaceTexture) {
        this.aQK = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.aRG = new com.baidu.rtc.camera.filter.a.c(this.aQK, surfaceTexture);
        this.aRG.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.aRL.init(this.mContext);
        if (this.aRM == null) {
            this.aRM = new com.baidu.rtc.camera.a.a(this.mContext, this.aQK);
        }
        this.aRH = com.baidu.rtc.camera.filter.glfilter.utils.a.CS();
        this.mSurfaceTexture = new SurfaceTexture(this.aRH);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        CL();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceChanged(int i, int i2) {
        this.aRL.H(i, i2);
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceDestroyed() {
        this.aRG.makeCurrent();
        this.aRL.release();
        if (this.aRM != null) {
            this.aRM.release();
            this.aRM = null;
        }
        releaseCamera();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        if (this.aRG != null) {
            this.aRG.release();
            this.aRG = null;
        }
        if (this.aQK != null) {
            this.aQK.release();
            this.aQK = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void CI() {
        if (this.mSurfaceTexture != null && this.aRG != null) {
            while (this.mFrameNum > 0) {
                this.aRG.makeCurrent();
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.aRJ);
                this.mFrameNum--;
                this.aRI = this.aRL.h(this.aRH, this.aRJ);
                this.aRG.swapBuffers();
                if (this.aRD && !this.aRE && this.aRM != null) {
                    if (this.aRF) {
                        this.aRM.Cp();
                        this.aRF = false;
                    }
                    this.aRM.e(this.aRI, System.nanoTime());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void CJ() {
        if (this.aRq.aRm != null) {
            this.aRK.Cx();
            this.aRq.aRm.P(this.aRK.Cy());
        }
    }

    private void CK() {
        if (this.aRq.orientation == 90 || this.aRq.orientation == 270) {
            this.aQU = this.aRq.previewHeight;
            this.aQV = this.aRq.previewWidth;
        } else {
            this.aQU = this.aRq.previewWidth;
            this.aQV = this.aRq.previewHeight;
        }
        this.aRL.G(this.aQU, this.aQV);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ap() {
        this.aRD = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopRecording() {
        this.aRF = true;
        this.aRD = false;
    }

    public void requestRender() {
        synchronized (this.aRA) {
            if (this.aRC) {
                this.mFrameNum++;
                if (this.aRr != null) {
                    this.aRr.sendMessage(this.aRr.obtainMessage(4));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void CL() {
        releaseCamera();
        com.baidu.rtc.camera.engine.a.a.Cs().aU(this.mContext);
        com.baidu.rtc.camera.engine.a.a.Cs().c(this.mSurfaceTexture);
        CK();
        com.baidu.rtc.camera.engine.a.a.Cs().setPreviewCallback(this);
        if (this.aRq.aRl != null) {
            this.aRq.aRl.Cu();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchCamera() {
        this.aRq.aRj = !this.aRq.aRj;
        if (this.aRq.aRj) {
            this.aRq.cameraId = 0;
        } else {
            this.aRq.cameraId = 1;
        }
        CL();
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPreview() {
        com.baidu.rtc.camera.engine.a.a.Cs().startPreview();
        this.aRC = true;
    }

    private void releaseCamera() {
        this.aRC = false;
        com.baidu.rtc.camera.engine.a.a.Cs().releaseCamera();
    }
}
