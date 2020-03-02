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
    private com.baidu.rtc.camera.engine.a.b aWI;
    private d aWJ;
    private final Object aWL;
    private final Object aWS;
    private final Object aWT;
    private boolean aWU;
    private boolean aWV;
    private boolean aWW;
    private boolean aWX;
    private com.baidu.rtc.camera.filter.a.c aWY;
    private int aWZ;
    private com.baidu.rtc.camera.filter.a.a aWc;
    private int aWm;
    private int aWn;
    private int aXa;
    private final float[] aXb;
    private a aXc;
    private e aXd;
    private com.baidu.rtc.camera.a.a aXe;
    private Context mContext;
    private int mFrameNum;
    private SurfaceTexture mSurfaceTexture;
    private long time;

    public f(Context context, String str) {
        super(str);
        this.aWL = new Object();
        this.aWS = new Object();
        this.aWT = new Object();
        this.aWU = false;
        this.aWV = false;
        this.aWW = false;
        this.aWX = false;
        this.aXb = new float[16];
        this.mFrameNum = 0;
        this.time = 0L;
        this.mContext = context;
        this.aWI = com.baidu.rtc.camera.engine.a.b.Fn();
        this.aXd = e.Fw();
        this.aXc = new a();
    }

    public void a(d dVar) {
        this.aWJ = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this.aWL) {
            if (this.aWU || this.aWV) {
                this.aWJ.sendMessage(this.aWJ.obtainMessage(17, bArr));
            }
        }
        if (this.aWJ != null && this.aWI.aWu) {
            this.aWJ.sendEmptyMessage(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(byte[] bArr) {
        if (this.aWI.aWD != null) {
            this.aWI.aWD.t(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Surface surface) {
        this.aWc = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.aWY = new com.baidu.rtc.camera.filter.a.c(this.aWc, surface, false);
        this.aWY.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.aXd.init(this.mContext);
        if (this.aXe == null) {
            this.aXe = new com.baidu.rtc.camera.a.a(this.mContext, this.aWc);
        }
        this.aWZ = com.baidu.rtc.camera.filter.glfilter.utils.a.FM();
        this.mSurfaceTexture = new SurfaceTexture(this.aWZ);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        FF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.aWc = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.aWY = new com.baidu.rtc.camera.filter.a.c(this.aWc, surfaceTexture);
        this.aWY.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.aXd.init(this.mContext);
        if (this.aXe == null) {
            this.aXe = new com.baidu.rtc.camera.a.a(this.mContext, this.aWc);
        }
        this.aWZ = com.baidu.rtc.camera.filter.glfilter.utils.a.FM();
        this.mSurfaceTexture = new SurfaceTexture(this.aWZ);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        FF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceChanged(int i, int i2) {
        this.aXd.M(i, i2);
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceDestroyed() {
        this.aWY.makeCurrent();
        this.aXd.release();
        if (this.aXe != null) {
            this.aXe.release();
            this.aXe = null;
        }
        releaseCamera();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        if (this.aWY != null) {
            this.aWY.release();
            this.aWY = null;
        }
        if (this.aWc != null) {
            this.aWc.release();
            this.aWc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void FC() {
        if (this.mSurfaceTexture != null && this.aWY != null) {
            while (this.mFrameNum > 0) {
                this.aWY.makeCurrent();
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.aXb);
                this.mFrameNum--;
                this.aXa = this.aXd.h(this.aWZ, this.aXb);
                this.aWY.swapBuffers();
                if (this.aWV && !this.aWW && this.aXe != null) {
                    if (this.aWX) {
                        this.aXe.Fj();
                        this.aWX = false;
                    }
                    this.aXe.e(this.aXa, System.nanoTime());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void FD() {
        if (this.aWI.aWE != null) {
            this.aXc.Fr();
            this.aWI.aWE.O(this.aXc.Fs());
        }
    }

    private void FE() {
        if (this.aWI.orientation == 90 || this.aWI.orientation == 270) {
            this.aWm = this.aWI.previewHeight;
            this.aWn = this.aWI.previewWidth;
        } else {
            this.aWm = this.aWI.previewWidth;
            this.aWn = this.aWI.previewHeight;
        }
        this.aXd.L(this.aWm, this.aWn);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Dd() {
        this.aWV = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopRecording() {
        this.aWX = true;
        this.aWV = false;
    }

    public void requestRender() {
        synchronized (this.aWS) {
            if (this.aWU) {
                this.mFrameNum++;
                if (this.aWJ != null) {
                    this.aWJ.sendMessage(this.aWJ.obtainMessage(4));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void FF() {
        releaseCamera();
        com.baidu.rtc.camera.engine.a.a.Fm().aY(this.mContext);
        com.baidu.rtc.camera.engine.a.a.Fm().c(this.mSurfaceTexture);
        FE();
        com.baidu.rtc.camera.engine.a.a.Fm().setPreviewCallback(this);
        if (this.aWI.aWD != null) {
            this.aWI.aWD.Fo();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchCamera() {
        this.aWI.aWB = !this.aWI.aWB;
        if (this.aWI.aWB) {
            this.aWI.cameraId = 0;
        } else {
            this.aWI.cameraId = 1;
        }
        FF();
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPreview() {
        com.baidu.rtc.camera.engine.a.a.Fm().startPreview();
        this.aWU = true;
    }

    private void releaseCamera() {
        this.aWU = false;
        com.baidu.rtc.camera.engine.a.a.Fm().releaseCamera();
    }
}
