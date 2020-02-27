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
    private com.baidu.rtc.camera.engine.a.b aWH;
    private d aWI;
    private final Object aWK;
    private final Object aWR;
    private final Object aWS;
    private boolean aWT;
    private boolean aWU;
    private boolean aWV;
    private boolean aWW;
    private com.baidu.rtc.camera.filter.a.c aWX;
    private int aWY;
    private int aWZ;
    private com.baidu.rtc.camera.filter.a.a aWb;
    private int aWl;
    private int aWm;
    private final float[] aXa;
    private a aXb;
    private e aXc;
    private com.baidu.rtc.camera.a.a aXd;
    private Context mContext;
    private int mFrameNum;
    private SurfaceTexture mSurfaceTexture;
    private long time;

    public f(Context context, String str) {
        super(str);
        this.aWK = new Object();
        this.aWR = new Object();
        this.aWS = new Object();
        this.aWT = false;
        this.aWU = false;
        this.aWV = false;
        this.aWW = false;
        this.aXa = new float[16];
        this.mFrameNum = 0;
        this.time = 0L;
        this.mContext = context;
        this.aWH = com.baidu.rtc.camera.engine.a.b.Fl();
        this.aXc = e.Fu();
        this.aXb = new a();
    }

    public void a(d dVar) {
        this.aWI = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this.aWK) {
            if (this.aWT || this.aWU) {
                this.aWI.sendMessage(this.aWI.obtainMessage(17, bArr));
            }
        }
        if (this.aWI != null && this.aWH.aWt) {
            this.aWI.sendEmptyMessage(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(byte[] bArr) {
        if (this.aWH.aWC != null) {
            this.aWH.aWC.t(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Surface surface) {
        this.aWb = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.aWX = new com.baidu.rtc.camera.filter.a.c(this.aWb, surface, false);
        this.aWX.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.aXc.init(this.mContext);
        if (this.aXd == null) {
            this.aXd = new com.baidu.rtc.camera.a.a(this.mContext, this.aWb);
        }
        this.aWY = com.baidu.rtc.camera.filter.glfilter.utils.a.FK();
        this.mSurfaceTexture = new SurfaceTexture(this.aWY);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        FD();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.aWb = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.aWX = new com.baidu.rtc.camera.filter.a.c(this.aWb, surfaceTexture);
        this.aWX.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.aXc.init(this.mContext);
        if (this.aXd == null) {
            this.aXd = new com.baidu.rtc.camera.a.a(this.mContext, this.aWb);
        }
        this.aWY = com.baidu.rtc.camera.filter.glfilter.utils.a.FK();
        this.mSurfaceTexture = new SurfaceTexture(this.aWY);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        FD();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceChanged(int i, int i2) {
        this.aXc.M(i, i2);
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceDestroyed() {
        this.aWX.makeCurrent();
        this.aXc.release();
        if (this.aXd != null) {
            this.aXd.release();
            this.aXd = null;
        }
        releaseCamera();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        if (this.aWX != null) {
            this.aWX.release();
            this.aWX = null;
        }
        if (this.aWb != null) {
            this.aWb.release();
            this.aWb = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void FA() {
        if (this.mSurfaceTexture != null && this.aWX != null) {
            while (this.mFrameNum > 0) {
                this.aWX.makeCurrent();
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.aXa);
                this.mFrameNum--;
                this.aWZ = this.aXc.h(this.aWY, this.aXa);
                this.aWX.swapBuffers();
                if (this.aWU && !this.aWV && this.aXd != null) {
                    if (this.aWW) {
                        this.aXd.Fh();
                        this.aWW = false;
                    }
                    this.aXd.e(this.aWZ, System.nanoTime());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void FB() {
        if (this.aWH.aWD != null) {
            this.aXb.Fp();
            this.aWH.aWD.O(this.aXb.Fq());
        }
    }

    private void FC() {
        if (this.aWH.orientation == 90 || this.aWH.orientation == 270) {
            this.aWl = this.aWH.previewHeight;
            this.aWm = this.aWH.previewWidth;
        } else {
            this.aWl = this.aWH.previewWidth;
            this.aWm = this.aWH.previewHeight;
        }
        this.aXc.L(this.aWl, this.aWm);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Db() {
        this.aWU = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopRecording() {
        this.aWW = true;
        this.aWU = false;
    }

    public void requestRender() {
        synchronized (this.aWR) {
            if (this.aWT) {
                this.mFrameNum++;
                if (this.aWI != null) {
                    this.aWI.sendMessage(this.aWI.obtainMessage(4));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void FD() {
        releaseCamera();
        com.baidu.rtc.camera.engine.a.a.Fk().aY(this.mContext);
        com.baidu.rtc.camera.engine.a.a.Fk().c(this.mSurfaceTexture);
        FC();
        com.baidu.rtc.camera.engine.a.a.Fk().setPreviewCallback(this);
        if (this.aWH.aWC != null) {
            this.aWH.aWC.Fm();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchCamera() {
        this.aWH.aWA = !this.aWH.aWA;
        if (this.aWH.aWA) {
            this.aWH.cameraId = 0;
        } else {
            this.aWH.cameraId = 1;
        }
        FD();
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPreview() {
        com.baidu.rtc.camera.engine.a.a.Fk().startPreview();
        this.aWT = true;
    }

    private void releaseCamera() {
        this.aWT = false;
        com.baidu.rtc.camera.engine.a.a.Fk().releaseCamera();
    }
}
