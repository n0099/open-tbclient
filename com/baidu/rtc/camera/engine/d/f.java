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
    private com.baidu.rtc.camera.engine.a.b bNN;
    private d bNO;
    private final Object bNQ;
    private final Object bNX;
    private final Object bNY;
    private boolean bNZ;
    private com.baidu.rtc.camera.filter.a.a bNg;
    private int bNp;
    private int bNq;
    private boolean bOa;
    private boolean bOb;
    private boolean bOc;
    private com.baidu.rtc.camera.filter.a.c bOd;
    private int bOe;
    private int bOf;
    private final float[] bOg;
    private int bOh;
    private a bOi;
    private e bOj;
    private com.baidu.rtc.camera.a.a bOk;
    private Context mContext;
    private SurfaceTexture mSurfaceTexture;
    private long time;

    public f(Context context, String str) {
        super(str);
        this.bNQ = new Object();
        this.bNX = new Object();
        this.bNY = new Object();
        this.bNZ = false;
        this.bOa = false;
        this.bOb = false;
        this.bOc = false;
        this.bOg = new float[16];
        this.bOh = 0;
        this.time = 0L;
        this.mContext = context;
        this.bNN = com.baidu.rtc.camera.engine.a.b.WH();
        this.bOj = e.WQ();
        this.bOi = new a();
    }

    public void a(d dVar) {
        this.bNO = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this.bNQ) {
            if (this.bNZ || this.bOa) {
                this.bNO.sendMessage(this.bNO.obtainMessage(17, bArr));
            }
        }
        if (this.bNO != null && this.bNN.bNx) {
            this.bNO.sendEmptyMessage(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(byte[] bArr) {
        if (this.bNN.bNI != null) {
            this.bNN.bNI.F(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Surface surface) {
        this.bNg = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.bOd = new com.baidu.rtc.camera.filter.a.c(this.bNg, surface, false);
        this.bOd.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.bOj.init(this.mContext);
        if (this.bOk == null) {
            this.bOk = new com.baidu.rtc.camera.a.a(this.mContext, this.bNg);
        }
        this.bOe = com.baidu.rtc.camera.filter.glfilter.utils.a.Xf();
        this.mSurfaceTexture = new SurfaceTexture(this.bOe);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        WZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.bNg = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.bOd = new com.baidu.rtc.camera.filter.a.c(this.bNg, surfaceTexture);
        this.bOd.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.bOj.init(this.mContext);
        if (this.bOk == null) {
            this.bOk = new com.baidu.rtc.camera.a.a(this.mContext, this.bNg);
        }
        this.bOe = com.baidu.rtc.camera.filter.glfilter.utils.a.Xf();
        this.mSurfaceTexture = new SurfaceTexture(this.bOe);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        WZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceChanged(int i, int i2) {
        this.bOj.W(i, i2);
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceDestroyed() {
        this.bOd.makeCurrent();
        this.bOj.release();
        if (this.bOk != null) {
            this.bOk.release();
            this.bOk = null;
        }
        releaseCamera();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        if (this.bOd != null) {
            this.bOd.release();
            this.bOd = null;
        }
        if (this.bNg != null) {
            this.bNg.release();
            this.bNg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void WW() {
        if (this.mSurfaceTexture != null && this.bOd != null) {
            while (this.bOh > 0) {
                this.bOd.makeCurrent();
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.bOg);
                this.bOh--;
                this.bOf = this.bOj.a(this.bOe, this.bOg);
                this.bOd.swapBuffers();
                if (this.bOa && !this.bOb && this.bOk != null) {
                    if (this.bOc) {
                        this.bOk.WD();
                        this.bOc = false;
                    }
                    this.bOk.f(this.bOf, System.nanoTime());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void WX() {
        if (this.bNN.bNJ != null) {
            this.bOi.WL();
            this.bNN.bNJ.B(this.bOi.WM());
        }
    }

    private void WY() {
        if (this.bNN.orientation == 90 || this.bNN.orientation == 270) {
            this.bNp = this.bNN.bNF;
            this.bNq = this.bNN.bNE;
        } else {
            this.bNp = this.bNN.bNE;
            this.bNq = this.bNN.bNF;
        }
        this.bOj.V(this.bNp, this.bNq);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startRecording() {
        this.bOa = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopRecording() {
        this.bOc = true;
        this.bOa = false;
    }

    public void requestRender() {
        synchronized (this.bNX) {
            if (this.bNZ) {
                this.bOh++;
                if (this.bNO != null) {
                    this.bNO.sendMessage(this.bNO.obtainMessage(4));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void WZ() {
        releaseCamera();
        com.baidu.rtc.camera.engine.a.a.WG().aU(this.mContext);
        com.baidu.rtc.camera.engine.a.a.WG().b(this.mSurfaceTexture);
        WY();
        com.baidu.rtc.camera.engine.a.a.WG().b(this);
        if (this.bNN.bNI != null) {
            this.bNN.bNI.WI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchCamera() {
        this.bNN.bNG = !this.bNN.bNG;
        if (this.bNN.bNG) {
            this.bNN.cameraId = 0;
        } else {
            this.bNN.cameraId = 1;
        }
        WZ();
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPreview() {
        com.baidu.rtc.camera.engine.a.a.WG().startPreview();
        this.bNZ = true;
    }

    private void releaseCamera() {
        this.bNZ = false;
        com.baidu.rtc.camera.engine.a.a.WG().releaseCamera();
    }
}
