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
    private int aWA;
    private int aWB;
    private com.baidu.rtc.camera.engine.a.b aWW;
    private d aWX;
    private final Object aWZ;
    private com.baidu.rtc.camera.filter.a.a aWq;
    private final Object aXg;
    private final Object aXh;
    private boolean aXi;
    private boolean aXj;
    private boolean aXk;
    private boolean aXl;
    private com.baidu.rtc.camera.filter.a.c aXm;
    private int aXn;
    private int aXo;
    private final float[] aXp;
    private a aXq;
    private e aXr;
    private com.baidu.rtc.camera.a.a aXs;
    private Context mContext;
    private int mFrameNum;
    private SurfaceTexture mSurfaceTexture;
    private long time;

    public f(Context context, String str) {
        super(str);
        this.aWZ = new Object();
        this.aXg = new Object();
        this.aXh = new Object();
        this.aXi = false;
        this.aXj = false;
        this.aXk = false;
        this.aXl = false;
        this.aXp = new float[16];
        this.mFrameNum = 0;
        this.time = 0L;
        this.mContext = context;
        this.aWW = com.baidu.rtc.camera.engine.a.b.Fs();
        this.aXr = e.FB();
        this.aXq = new a();
    }

    public void a(d dVar) {
        this.aWX = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this.aWZ) {
            if (this.aXi || this.aXj) {
                this.aWX.sendMessage(this.aWX.obtainMessage(17, bArr));
            }
        }
        if (this.aWX != null && this.aWW.aWI) {
            this.aWX.sendEmptyMessage(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(byte[] bArr) {
        if (this.aWW.aWR != null) {
            this.aWW.aWR.t(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Surface surface) {
        this.aWq = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.aXm = new com.baidu.rtc.camera.filter.a.c(this.aWq, surface, false);
        this.aXm.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.aXr.init(this.mContext);
        if (this.aXs == null) {
            this.aXs = new com.baidu.rtc.camera.a.a(this.mContext, this.aWq);
        }
        this.aXn = com.baidu.rtc.camera.filter.glfilter.utils.a.FR();
        this.mSurfaceTexture = new SurfaceTexture(this.aXn);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        FK();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.aWq = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.aXm = new com.baidu.rtc.camera.filter.a.c(this.aWq, surfaceTexture);
        this.aXm.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.aXr.init(this.mContext);
        if (this.aXs == null) {
            this.aXs = new com.baidu.rtc.camera.a.a(this.mContext, this.aWq);
        }
        this.aXn = com.baidu.rtc.camera.filter.glfilter.utils.a.FR();
        this.mSurfaceTexture = new SurfaceTexture(this.aXn);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        FK();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceChanged(int i, int i2) {
        this.aXr.M(i, i2);
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceDestroyed() {
        this.aXm.makeCurrent();
        this.aXr.release();
        if (this.aXs != null) {
            this.aXs.release();
            this.aXs = null;
        }
        releaseCamera();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        if (this.aXm != null) {
            this.aXm.release();
            this.aXm = null;
        }
        if (this.aWq != null) {
            this.aWq.release();
            this.aWq = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void FH() {
        if (this.mSurfaceTexture != null && this.aXm != null) {
            while (this.mFrameNum > 0) {
                this.aXm.makeCurrent();
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.aXp);
                this.mFrameNum--;
                this.aXo = this.aXr.h(this.aXn, this.aXp);
                this.aXm.swapBuffers();
                if (this.aXj && !this.aXk && this.aXs != null) {
                    if (this.aXl) {
                        this.aXs.Fo();
                        this.aXl = false;
                    }
                    this.aXs.e(this.aXo, System.nanoTime());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void FI() {
        if (this.aWW.aWS != null) {
            this.aXq.Fw();
            this.aWW.aWS.O(this.aXq.Fx());
        }
    }

    private void FJ() {
        if (this.aWW.orientation == 90 || this.aWW.orientation == 270) {
            this.aWA = this.aWW.previewHeight;
            this.aWB = this.aWW.previewWidth;
        } else {
            this.aWA = this.aWW.previewWidth;
            this.aWB = this.aWW.previewHeight;
        }
        this.aXr.L(this.aWA, this.aWB);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Dk() {
        this.aXj = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopRecording() {
        this.aXl = true;
        this.aXj = false;
    }

    public void requestRender() {
        synchronized (this.aXg) {
            if (this.aXi) {
                this.mFrameNum++;
                if (this.aWX != null) {
                    this.aWX.sendMessage(this.aWX.obtainMessage(4));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void FK() {
        releaseCamera();
        com.baidu.rtc.camera.engine.a.a.Fr().aX(this.mContext);
        com.baidu.rtc.camera.engine.a.a.Fr().c(this.mSurfaceTexture);
        FJ();
        com.baidu.rtc.camera.engine.a.a.Fr().setPreviewCallback(this);
        if (this.aWW.aWR != null) {
            this.aWW.aWR.Ft();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchCamera() {
        this.aWW.aWP = !this.aWW.aWP;
        if (this.aWW.aWP) {
            this.aWW.cameraId = 0;
        } else {
            this.aWW.cameraId = 1;
        }
        FK();
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPreview() {
        com.baidu.rtc.camera.engine.a.a.Fr().startPreview();
        this.aXi = true;
    }

    private void releaseCamera() {
        this.aXi = false;
        com.baidu.rtc.camera.engine.a.a.Fr().releaseCamera();
    }
}
