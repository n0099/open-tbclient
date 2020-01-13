package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES30;
import android.os.HandlerThread;
import android.view.Surface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class f extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback {
    private com.baidu.rtc.camera.filter.a.a aRC;
    private int aRM;
    private int aRN;
    private int aSA;
    private final float[] aSB;
    private a aSC;
    private e aSD;
    private com.baidu.rtc.camera.a.a aSE;
    private com.baidu.rtc.camera.engine.a.b aSi;
    private d aSj;
    private final Object aSl;
    private final Object aSs;
    private final Object aSt;
    private boolean aSu;
    private boolean aSv;
    private boolean aSw;
    private boolean aSx;
    private com.baidu.rtc.camera.filter.a.c aSy;
    private int aSz;
    private Context mContext;
    private int mFrameNum;
    private SurfaceTexture mSurfaceTexture;
    private long time;

    public f(Context context, String str) {
        super(str);
        this.aSl = new Object();
        this.aSs = new Object();
        this.aSt = new Object();
        this.aSu = false;
        this.aSv = false;
        this.aSw = false;
        this.aSx = false;
        this.aSB = new float[16];
        this.mFrameNum = 0;
        this.time = 0L;
        this.mContext = context;
        this.aSi = com.baidu.rtc.camera.engine.a.b.CP();
        this.aSD = e.CY();
        this.aSC = new a();
    }

    public void a(d dVar) {
        this.aSj = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this.aSl) {
            if (this.aSu || this.aSv) {
                this.aSj.sendMessage(this.aSj.obtainMessage(17, bArr));
            }
        }
        if (this.aSj != null && this.aSi.aRU) {
            this.aSj.sendEmptyMessage(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(byte[] bArr) {
        if (this.aSi.aSd != null) {
            this.aSi.aSd.o(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Surface surface) {
        this.aRC = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.aSy = new com.baidu.rtc.camera.filter.a.c(this.aRC, surface, false);
        this.aSy.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.aSD.init(this.mContext);
        if (this.aSE == null) {
            this.aSE = new com.baidu.rtc.camera.a.a(this.mContext, this.aRC);
        }
        this.aSz = com.baidu.rtc.camera.filter.glfilter.utils.a.Do();
        this.mSurfaceTexture = new SurfaceTexture(this.aSz);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        Dh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(SurfaceTexture surfaceTexture) {
        this.aRC = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.aSy = new com.baidu.rtc.camera.filter.a.c(this.aRC, surfaceTexture);
        this.aSy.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.aSD.init(this.mContext);
        if (this.aSE == null) {
            this.aSE = new com.baidu.rtc.camera.a.a(this.mContext, this.aRC);
        }
        this.aSz = com.baidu.rtc.camera.filter.glfilter.utils.a.Do();
        this.mSurfaceTexture = new SurfaceTexture(this.aSz);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        Dh();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceChanged(int i, int i2) {
        this.aSD.L(i, i2);
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceDestroyed() {
        this.aSy.makeCurrent();
        this.aSD.release();
        if (this.aSE != null) {
            this.aSE.release();
            this.aSE = null;
        }
        releaseCamera();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        if (this.aSy != null) {
            this.aSy.release();
            this.aSy = null;
        }
        if (this.aRC != null) {
            this.aRC.release();
            this.aRC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void De() {
        if (this.mSurfaceTexture != null && this.aSy != null) {
            while (this.mFrameNum > 0) {
                this.aSy.makeCurrent();
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.aSB);
                this.mFrameNum--;
                this.aSA = this.aSD.h(this.aSz, this.aSB);
                this.aSy.swapBuffers();
                if (this.aSv && !this.aSw && this.aSE != null) {
                    if (this.aSx) {
                        this.aSE.CL();
                        this.aSx = false;
                    }
                    this.aSE.e(this.aSA, System.nanoTime());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Df() {
        if (this.aSi.aSe != null) {
            this.aSC.CT();
            this.aSi.aSe.O(this.aSC.CU());
        }
    }

    private void Dg() {
        if (this.aSi.orientation == 90 || this.aSi.orientation == 270) {
            this.aRM = this.aSi.previewHeight;
            this.aRN = this.aSi.previewWidth;
        } else {
            this.aRM = this.aSi.previewWidth;
            this.aRN = this.aSi.previewHeight;
        }
        this.aSD.K(this.aRM, this.aRN);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void AL() {
        this.aSv = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopRecording() {
        this.aSx = true;
        this.aSv = false;
    }

    public void requestRender() {
        synchronized (this.aSs) {
            if (this.aSu) {
                this.mFrameNum++;
                if (this.aSj != null) {
                    this.aSj.sendMessage(this.aSj.obtainMessage(4));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Dh() {
        releaseCamera();
        com.baidu.rtc.camera.engine.a.a.CO().aU(this.mContext);
        com.baidu.rtc.camera.engine.a.a.CO().c(this.mSurfaceTexture);
        Dg();
        com.baidu.rtc.camera.engine.a.a.CO().setPreviewCallback(this);
        if (this.aSi.aSd != null) {
            this.aSi.aSd.CQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchCamera() {
        this.aSi.aSb = !this.aSi.aSb;
        if (this.aSi.aSb) {
            this.aSi.cameraId = 0;
        } else {
            this.aSi.cameraId = 1;
        }
        Dh();
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPreview() {
        com.baidu.rtc.camera.engine.a.a.CO().startPreview();
        this.aSu = true;
    }

    private void releaseCamera() {
        this.aSu = false;
        com.baidu.rtc.camera.engine.a.a.CO().releaseCamera();
    }
}
