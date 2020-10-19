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
    private com.baidu.rtc.camera.filter.a.a bYG;
    private int bYP;
    private int bYQ;
    private boolean bZA;
    private boolean bZB;
    private boolean bZC;
    private com.baidu.rtc.camera.filter.a.c bZD;
    private int bZE;
    private int bZF;
    private final float[] bZG;
    private int bZH;
    private a bZI;
    private e bZJ;
    private com.baidu.rtc.camera.a.a bZK;
    private com.baidu.rtc.camera.engine.a.b bZn;
    private d bZo;
    private final Object bZq;
    private final Object bZx;
    private final Object bZy;
    private boolean bZz;
    private Context mContext;
    private SurfaceTexture mSurfaceTexture;
    private long time;

    public f(Context context, String str) {
        super(str);
        this.bZq = new Object();
        this.bZx = new Object();
        this.bZy = new Object();
        this.bZz = false;
        this.bZA = false;
        this.bZB = false;
        this.bZC = false;
        this.bZG = new float[16];
        this.bZH = 0;
        this.time = 0L;
        this.mContext = context;
        this.bZn = com.baidu.rtc.camera.engine.a.b.ZI();
        this.bZJ = e.ZR();
        this.bZI = new a();
    }

    public void a(d dVar) {
        this.bZo = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this.bZq) {
            if (this.bZz || this.bZA) {
                this.bZo.sendMessage(this.bZo.obtainMessage(17, bArr));
            }
        }
        if (this.bZo != null && this.bZn.bYX) {
            this.bZo.sendEmptyMessage(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(byte[] bArr) {
        if (this.bZn.bZi != null) {
            this.bZn.bZi.F(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Surface surface) {
        this.bYG = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.bZD = new com.baidu.rtc.camera.filter.a.c(this.bYG, surface, false);
        this.bZD.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.bZJ.init(this.mContext);
        if (this.bZK == null) {
            this.bZK = new com.baidu.rtc.camera.a.a(this.mContext, this.bYG);
        }
        this.bZE = com.baidu.rtc.camera.filter.glfilter.utils.a.aaf();
        this.mSurfaceTexture = new SurfaceTexture(this.bZE);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        openCamera();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.bYG = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.bZD = new com.baidu.rtc.camera.filter.a.c(this.bYG, surfaceTexture);
        this.bZD.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.bZJ.init(this.mContext);
        if (this.bZK == null) {
            this.bZK = new com.baidu.rtc.camera.a.a(this.mContext, this.bYG);
        }
        this.bZE = com.baidu.rtc.camera.filter.glfilter.utils.a.aaf();
        this.mSurfaceTexture = new SurfaceTexture(this.bZE);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        openCamera();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceChanged(int i, int i2) {
        this.bZJ.V(i, i2);
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceDestroyed() {
        this.bZD.makeCurrent();
        this.bZJ.release();
        if (this.bZK != null) {
            this.bZK.release();
            this.bZK = null;
        }
        releaseCamera();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        if (this.bZD != null) {
            this.bZD.release();
            this.bZD = null;
        }
        if (this.bYG != null) {
            this.bYG.release();
            this.bYG = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ZX() {
        if (this.mSurfaceTexture != null && this.bZD != null) {
            while (this.bZH > 0) {
                this.bZD.makeCurrent();
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.bZG);
                this.bZH--;
                this.bZF = this.bZJ.a(this.bZE, this.bZG);
                this.bZD.swapBuffers();
                if (this.bZA && !this.bZB && this.bZK != null) {
                    if (this.bZC) {
                        this.bZK.ZE();
                        this.bZC = false;
                    }
                    this.bZK.g(this.bZF, System.nanoTime());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ZY() {
        if (this.bZn.bZj != null) {
            this.bZI.ZM();
            this.bZn.bZj.D(this.bZI.ZN());
        }
    }

    private void ZZ() {
        if (this.bZn.orientation == 90 || this.bZn.orientation == 270) {
            this.bYP = this.bZn.bZf;
            this.bYQ = this.bZn.bZe;
        } else {
            this.bYP = this.bZn.bZe;
            this.bYQ = this.bZn.bZf;
        }
        this.bZJ.setTextureSize(this.bYP, this.bYQ);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startRecording() {
        this.bZA = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopRecording() {
        this.bZC = true;
        this.bZA = false;
    }

    public void requestRender() {
        synchronized (this.bZx) {
            if (this.bZz) {
                this.bZH++;
                if (this.bZo != null) {
                    this.bZo.sendMessage(this.bZo.obtainMessage(4));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openCamera() {
        releaseCamera();
        com.baidu.rtc.camera.engine.a.a.ZH().aY(this.mContext);
        com.baidu.rtc.camera.engine.a.a.ZH().b(this.mSurfaceTexture);
        ZZ();
        com.baidu.rtc.camera.engine.a.a.ZH().b(this);
        if (this.bZn.bZi != null) {
            this.bZn.bZi.ZJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchCamera() {
        this.bZn.bZg = !this.bZn.bZg;
        if (this.bZn.bZg) {
            this.bZn.cameraId = 0;
        } else {
            this.bZn.cameraId = 1;
        }
        openCamera();
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPreview() {
        com.baidu.rtc.camera.engine.a.a.ZH().startPreview();
        this.bZz = true;
    }

    private void releaseCamera() {
        this.bZz = false;
        com.baidu.rtc.camera.engine.a.a.ZH().releaseCamera();
    }
}
