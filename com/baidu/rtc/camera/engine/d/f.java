package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES30;
import android.os.HandlerThread;
import android.view.Surface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class f extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback {
    private com.baidu.rtc.camera.engine.a.b chL;
    private d chM;
    private final Object chO;
    private final Object chV;
    private final Object chW;
    private boolean chX;
    private boolean chY;
    private boolean chZ;
    private com.baidu.rtc.camera.filter.a.a che;
    private int chn;
    private int cho;
    private boolean cia;
    private com.baidu.rtc.camera.filter.a.c cib;
    private int cic;
    private int cie;
    private final float[] cif;
    private int cig;
    private a cih;
    private e cii;
    private com.baidu.rtc.camera.a.a cij;
    private Context mContext;
    private SurfaceTexture mSurfaceTexture;
    private long time;

    public f(Context context, String str) {
        super(str);
        this.chO = new Object();
        this.chV = new Object();
        this.chW = new Object();
        this.chX = false;
        this.chY = false;
        this.chZ = false;
        this.cia = false;
        this.cif = new float[16];
        this.cig = 0;
        this.time = 0L;
        this.mContext = context;
        this.chL = com.baidu.rtc.camera.engine.a.b.abC();
        this.cii = e.abL();
        this.cih = new a();
    }

    public void a(d dVar) {
        this.chM = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this.chO) {
            if (this.chX || this.chY) {
                this.chM.sendMessage(this.chM.obtainMessage(17, bArr));
            }
        }
        if (this.chM != null && this.chL.chv) {
            this.chM.sendEmptyMessage(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(byte[] bArr) {
        if (this.chL.chG != null) {
            this.chL.chG.F(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Surface surface) {
        this.che = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.cib = new com.baidu.rtc.camera.filter.a.c(this.che, surface, false);
        this.cib.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.cii.init(this.mContext);
        if (this.cij == null) {
            this.cij = new com.baidu.rtc.camera.a.a(this.mContext, this.che);
        }
        this.cic = com.baidu.rtc.camera.filter.glfilter.utils.a.abZ();
        this.mSurfaceTexture = new SurfaceTexture(this.cic);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        openCamera();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.che = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.cib = new com.baidu.rtc.camera.filter.a.c(this.che, surfaceTexture);
        this.cib.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.cii.init(this.mContext);
        if (this.cij == null) {
            this.cij = new com.baidu.rtc.camera.a.a(this.mContext, this.che);
        }
        this.cic = com.baidu.rtc.camera.filter.glfilter.utils.a.abZ();
        this.mSurfaceTexture = new SurfaceTexture(this.cic);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        openCamera();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceChanged(int i, int i2) {
        this.cii.W(i, i2);
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceDestroyed() {
        this.cib.makeCurrent();
        this.cii.release();
        if (this.cij != null) {
            this.cij.release();
            this.cij = null;
        }
        releaseCamera();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        if (this.cib != null) {
            this.cib.release();
            this.cib = null;
        }
        if (this.che != null) {
            this.che.release();
            this.che = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void abR() {
        if (this.mSurfaceTexture != null && this.cib != null) {
            while (this.cig > 0) {
                this.cib.makeCurrent();
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.cif);
                this.cig--;
                this.cie = this.cii.a(this.cic, this.cif);
                this.cib.swapBuffers();
                if (this.chY && !this.chZ && this.cij != null) {
                    if (this.cia) {
                        this.cij.aby();
                        this.cia = false;
                    }
                    this.cij.g(this.cie, System.nanoTime());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void abS() {
        if (this.chL.chH != null) {
            this.cih.abG();
            this.chL.chH.F(this.cih.abH());
        }
    }

    private void abT() {
        if (this.chL.orientation == 90 || this.chL.orientation == 270) {
            this.chn = this.chL.chD;
            this.cho = this.chL.chC;
        } else {
            this.chn = this.chL.chC;
            this.cho = this.chL.chD;
        }
        this.cii.setTextureSize(this.chn, this.cho);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startRecording() {
        this.chY = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopRecording() {
        this.cia = true;
        this.chY = false;
    }

    public void requestRender() {
        synchronized (this.chV) {
            if (this.chX) {
                this.cig++;
                if (this.chM != null) {
                    this.chM.sendMessage(this.chM.obtainMessage(4));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openCamera() {
        releaseCamera();
        com.baidu.rtc.camera.engine.a.a.abB().aY(this.mContext);
        com.baidu.rtc.camera.engine.a.a.abB().b(this.mSurfaceTexture);
        abT();
        com.baidu.rtc.camera.engine.a.a.abB().b(this);
        if (this.chL.chG != null) {
            this.chL.chG.abD();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchCamera() {
        this.chL.chE = !this.chL.chE;
        if (this.chL.chE) {
            this.chL.cameraId = 0;
        } else {
            this.chL.cameraId = 1;
        }
        openCamera();
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPreview() {
        com.baidu.rtc.camera.engine.a.a.abB().startPreview();
        this.chX = true;
    }

    private void releaseCamera() {
        this.chX = false;
        com.baidu.rtc.camera.engine.a.a.abB().releaseCamera();
    }
}
