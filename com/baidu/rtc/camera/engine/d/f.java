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
    private com.baidu.rtc.camera.engine.a.b aWJ;
    private d aWK;
    private final Object aWM;
    private final Object aWT;
    private final Object aWU;
    private boolean aWV;
    private boolean aWW;
    private boolean aWX;
    private boolean aWY;
    private com.baidu.rtc.camera.filter.a.c aWZ;
    private com.baidu.rtc.camera.filter.a.a aWd;
    private int aWn;
    private int aWo;
    private int aXa;
    private int aXb;
    private final float[] aXc;
    private a aXd;
    private e aXe;
    private com.baidu.rtc.camera.a.a aXf;
    private Context mContext;
    private int mFrameNum;
    private SurfaceTexture mSurfaceTexture;
    private long time;

    public f(Context context, String str) {
        super(str);
        this.aWM = new Object();
        this.aWT = new Object();
        this.aWU = new Object();
        this.aWV = false;
        this.aWW = false;
        this.aWX = false;
        this.aWY = false;
        this.aXc = new float[16];
        this.mFrameNum = 0;
        this.time = 0L;
        this.mContext = context;
        this.aWJ = com.baidu.rtc.camera.engine.a.b.Fn();
        this.aXe = e.Fw();
        this.aXd = new a();
    }

    public void a(d dVar) {
        this.aWK = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this.aWM) {
            if (this.aWV || this.aWW) {
                this.aWK.sendMessage(this.aWK.obtainMessage(17, bArr));
            }
        }
        if (this.aWK != null && this.aWJ.aWv) {
            this.aWK.sendEmptyMessage(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(byte[] bArr) {
        if (this.aWJ.aWE != null) {
            this.aWJ.aWE.t(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Surface surface) {
        this.aWd = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.aWZ = new com.baidu.rtc.camera.filter.a.c(this.aWd, surface, false);
        this.aWZ.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.aXe.init(this.mContext);
        if (this.aXf == null) {
            this.aXf = new com.baidu.rtc.camera.a.a(this.mContext, this.aWd);
        }
        this.aXa = com.baidu.rtc.camera.filter.glfilter.utils.a.FM();
        this.mSurfaceTexture = new SurfaceTexture(this.aXa);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        FF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.aWd = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.aWZ = new com.baidu.rtc.camera.filter.a.c(this.aWd, surfaceTexture);
        this.aWZ.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.aXe.init(this.mContext);
        if (this.aXf == null) {
            this.aXf = new com.baidu.rtc.camera.a.a(this.mContext, this.aWd);
        }
        this.aXa = com.baidu.rtc.camera.filter.glfilter.utils.a.FM();
        this.mSurfaceTexture = new SurfaceTexture(this.aXa);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        FF();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceChanged(int i, int i2) {
        this.aXe.M(i, i2);
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceDestroyed() {
        this.aWZ.makeCurrent();
        this.aXe.release();
        if (this.aXf != null) {
            this.aXf.release();
            this.aXf = null;
        }
        releaseCamera();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        if (this.aWZ != null) {
            this.aWZ.release();
            this.aWZ = null;
        }
        if (this.aWd != null) {
            this.aWd.release();
            this.aWd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void FC() {
        if (this.mSurfaceTexture != null && this.aWZ != null) {
            while (this.mFrameNum > 0) {
                this.aWZ.makeCurrent();
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.aXc);
                this.mFrameNum--;
                this.aXb = this.aXe.h(this.aXa, this.aXc);
                this.aWZ.swapBuffers();
                if (this.aWW && !this.aWX && this.aXf != null) {
                    if (this.aWY) {
                        this.aXf.Fj();
                        this.aWY = false;
                    }
                    this.aXf.e(this.aXb, System.nanoTime());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void FD() {
        if (this.aWJ.aWF != null) {
            this.aXd.Fr();
            this.aWJ.aWF.O(this.aXd.Fs());
        }
    }

    private void FE() {
        if (this.aWJ.orientation == 90 || this.aWJ.orientation == 270) {
            this.aWn = this.aWJ.previewHeight;
            this.aWo = this.aWJ.previewWidth;
        } else {
            this.aWn = this.aWJ.previewWidth;
            this.aWo = this.aWJ.previewHeight;
        }
        this.aXe.L(this.aWn, this.aWo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Dd() {
        this.aWW = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopRecording() {
        this.aWY = true;
        this.aWW = false;
    }

    public void requestRender() {
        synchronized (this.aWT) {
            if (this.aWV) {
                this.mFrameNum++;
                if (this.aWK != null) {
                    this.aWK.sendMessage(this.aWK.obtainMessage(4));
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
        if (this.aWJ.aWE != null) {
            this.aWJ.aWE.Fo();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchCamera() {
        this.aWJ.aWC = !this.aWJ.aWC;
        if (this.aWJ.aWC) {
            this.aWJ.cameraId = 0;
        } else {
            this.aWJ.cameraId = 1;
        }
        FF();
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPreview() {
        com.baidu.rtc.camera.engine.a.a.Fm().startPreview();
        this.aWV = true;
    }

    private void releaseCamera() {
        this.aWV = false;
        com.baidu.rtc.camera.engine.a.a.Fm().releaseCamera();
    }
}
