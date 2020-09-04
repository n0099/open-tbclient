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
    private com.baidu.rtc.camera.engine.a.b bNR;
    private d bNS;
    private final Object bNU;
    private com.baidu.rtc.camera.filter.a.a bNk;
    private int bNt;
    private int bNu;
    private final Object bOb;
    private final Object bOc;
    private boolean bOd;
    private boolean bOe;
    private boolean bOf;
    private boolean bOg;
    private com.baidu.rtc.camera.filter.a.c bOh;
    private int bOi;
    private int bOj;
    private final float[] bOk;
    private int bOl;
    private a bOm;
    private e bOn;
    private com.baidu.rtc.camera.a.a bOo;
    private Context mContext;
    private SurfaceTexture mSurfaceTexture;
    private long time;

    public f(Context context, String str) {
        super(str);
        this.bNU = new Object();
        this.bOb = new Object();
        this.bOc = new Object();
        this.bOd = false;
        this.bOe = false;
        this.bOf = false;
        this.bOg = false;
        this.bOk = new float[16];
        this.bOl = 0;
        this.time = 0L;
        this.mContext = context;
        this.bNR = com.baidu.rtc.camera.engine.a.b.WH();
        this.bOn = e.WQ();
        this.bOm = new a();
    }

    public void a(d dVar) {
        this.bNS = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this.bNU) {
            if (this.bOd || this.bOe) {
                this.bNS.sendMessage(this.bNS.obtainMessage(17, bArr));
            }
        }
        if (this.bNS != null && this.bNR.bNB) {
            this.bNS.sendEmptyMessage(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(byte[] bArr) {
        if (this.bNR.bNM != null) {
            this.bNR.bNM.F(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Surface surface) {
        this.bNk = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.bOh = new com.baidu.rtc.camera.filter.a.c(this.bNk, surface, false);
        this.bOh.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.bOn.init(this.mContext);
        if (this.bOo == null) {
            this.bOo = new com.baidu.rtc.camera.a.a(this.mContext, this.bNk);
        }
        this.bOi = com.baidu.rtc.camera.filter.glfilter.utils.a.Xf();
        this.mSurfaceTexture = new SurfaceTexture(this.bOi);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        WZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.bNk = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.bOh = new com.baidu.rtc.camera.filter.a.c(this.bNk, surfaceTexture);
        this.bOh.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.bOn.init(this.mContext);
        if (this.bOo == null) {
            this.bOo = new com.baidu.rtc.camera.a.a(this.mContext, this.bNk);
        }
        this.bOi = com.baidu.rtc.camera.filter.glfilter.utils.a.Xf();
        this.mSurfaceTexture = new SurfaceTexture(this.bOi);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        WZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceChanged(int i, int i2) {
        this.bOn.W(i, i2);
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceDestroyed() {
        this.bOh.makeCurrent();
        this.bOn.release();
        if (this.bOo != null) {
            this.bOo.release();
            this.bOo = null;
        }
        releaseCamera();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        if (this.bOh != null) {
            this.bOh.release();
            this.bOh = null;
        }
        if (this.bNk != null) {
            this.bNk.release();
            this.bNk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void WW() {
        if (this.mSurfaceTexture != null && this.bOh != null) {
            while (this.bOl > 0) {
                this.bOh.makeCurrent();
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.bOk);
                this.bOl--;
                this.bOj = this.bOn.a(this.bOi, this.bOk);
                this.bOh.swapBuffers();
                if (this.bOe && !this.bOf && this.bOo != null) {
                    if (this.bOg) {
                        this.bOo.WD();
                        this.bOg = false;
                    }
                    this.bOo.f(this.bOj, System.nanoTime());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void WX() {
        if (this.bNR.bNN != null) {
            this.bOm.WL();
            this.bNR.bNN.B(this.bOm.WM());
        }
    }

    private void WY() {
        if (this.bNR.orientation == 90 || this.bNR.orientation == 270) {
            this.bNt = this.bNR.bNJ;
            this.bNu = this.bNR.bNI;
        } else {
            this.bNt = this.bNR.bNI;
            this.bNu = this.bNR.bNJ;
        }
        this.bOn.V(this.bNt, this.bNu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startRecording() {
        this.bOe = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopRecording() {
        this.bOg = true;
        this.bOe = false;
    }

    public void requestRender() {
        synchronized (this.bOb) {
            if (this.bOd) {
                this.bOl++;
                if (this.bNS != null) {
                    this.bNS.sendMessage(this.bNS.obtainMessage(4));
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
        if (this.bNR.bNM != null) {
            this.bNR.bNM.WI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchCamera() {
        this.bNR.bNK = !this.bNR.bNK;
        if (this.bNR.bNK) {
            this.bNR.cameraId = 0;
        } else {
            this.bNR.cameraId = 1;
        }
        WZ();
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPreview() {
        com.baidu.rtc.camera.engine.a.a.WG().startPreview();
        this.bOd = true;
    }

    private void releaseCamera() {
        this.bOd = false;
        com.baidu.rtc.camera.engine.a.a.WG().releaseCamera();
    }
}
