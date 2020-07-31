package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES30;
import android.os.HandlerThread;
import android.view.Surface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback {
    private com.baidu.rtc.camera.filter.a.a bHG;
    private int bHQ;
    private int bHR;
    private boolean bIA;
    private boolean bIB;
    private com.baidu.rtc.camera.filter.a.c bIC;
    private int bID;
    private int bIE;
    private final float[] bIF;
    private int bIG;
    private a bIH;
    private e bII;
    private com.baidu.rtc.camera.a.a bIJ;
    private com.baidu.rtc.camera.engine.a.b bIm;
    private d bIn;
    private final Object bIp;
    private final Object bIw;
    private final Object bIx;
    private boolean bIy;
    private boolean bIz;
    private Context mContext;
    private SurfaceTexture mSurfaceTexture;
    private long time;

    public f(Context context, String str) {
        super(str);
        this.bIp = new Object();
        this.bIw = new Object();
        this.bIx = new Object();
        this.bIy = false;
        this.bIz = false;
        this.bIA = false;
        this.bIB = false;
        this.bIF = new float[16];
        this.bIG = 0;
        this.time = 0L;
        this.mContext = context;
        this.bIm = com.baidu.rtc.camera.engine.a.b.QL();
        this.bII = e.QU();
        this.bIH = new a();
    }

    public void a(d dVar) {
        this.bIn = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this.bIp) {
            if (this.bIy || this.bIz) {
                this.bIn.sendMessage(this.bIn.obtainMessage(17, bArr));
            }
        }
        if (this.bIn != null && this.bIm.bHY) {
            this.bIn.sendEmptyMessage(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(byte[] bArr) {
        if (this.bIm.bIh != null) {
            this.bIm.bIh.E(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Surface surface) {
        this.bHG = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.bIC = new com.baidu.rtc.camera.filter.a.c(this.bHG, surface, false);
        this.bIC.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.bII.init(this.mContext);
        if (this.bIJ == null) {
            this.bIJ = new com.baidu.rtc.camera.a.a(this.mContext, this.bHG);
        }
        this.bID = com.baidu.rtc.camera.filter.glfilter.utils.a.Rk();
        this.mSurfaceTexture = new SurfaceTexture(this.bID);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        Rd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.bHG = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.bIC = new com.baidu.rtc.camera.filter.a.c(this.bHG, surfaceTexture);
        this.bIC.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.bII.init(this.mContext);
        if (this.bIJ == null) {
            this.bIJ = new com.baidu.rtc.camera.a.a(this.mContext, this.bHG);
        }
        this.bID = com.baidu.rtc.camera.filter.glfilter.utils.a.Rk();
        this.mSurfaceTexture = new SurfaceTexture(this.bID);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        Rd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceChanged(int i, int i2) {
        this.bII.T(i, i2);
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceDestroyed() {
        this.bIC.makeCurrent();
        this.bII.release();
        if (this.bIJ != null) {
            this.bIJ.release();
            this.bIJ = null;
        }
        releaseCamera();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        if (this.bIC != null) {
            this.bIC.release();
            this.bIC = null;
        }
        if (this.bHG != null) {
            this.bHG.release();
            this.bHG = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ra() {
        if (this.mSurfaceTexture != null && this.bIC != null) {
            while (this.bIG > 0) {
                this.bIC.makeCurrent();
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.bIF);
                this.bIG--;
                this.bIE = this.bII.a(this.bID, this.bIF);
                this.bIC.swapBuffers();
                if (this.bIz && !this.bIA && this.bIJ != null) {
                    if (this.bIB) {
                        this.bIJ.QH();
                        this.bIB = false;
                    }
                    this.bIJ.f(this.bIE, System.nanoTime());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Rb() {
        if (this.bIm.bIi != null) {
            this.bIH.QP();
            this.bIm.bIi.A(this.bIH.QQ());
        }
    }

    private void Rc() {
        if (this.bIm.orientation == 90 || this.bIm.orientation == 270) {
            this.bHQ = this.bIm.previewHeight;
            this.bHR = this.bIm.previewWidth;
        } else {
            this.bHQ = this.bIm.previewWidth;
            this.bHR = this.bIm.previewHeight;
        }
        this.bII.S(this.bHQ, this.bHR);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startRecording() {
        this.bIz = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopRecording() {
        this.bIB = true;
        this.bIz = false;
    }

    public void requestRender() {
        synchronized (this.bIw) {
            if (this.bIy) {
                this.bIG++;
                if (this.bIn != null) {
                    this.bIn.sendMessage(this.bIn.obtainMessage(4));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Rd() {
        releaseCamera();
        com.baidu.rtc.camera.engine.a.a.QK().aP(this.mContext);
        com.baidu.rtc.camera.engine.a.a.QK().b(this.mSurfaceTexture);
        Rc();
        com.baidu.rtc.camera.engine.a.a.QK().setPreviewCallback(this);
        if (this.bIm.bIh != null) {
            this.bIm.bIh.QM();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchCamera() {
        this.bIm.bIf = !this.bIm.bIf;
        if (this.bIm.bIf) {
            this.bIm.cameraId = 0;
        } else {
            this.bIm.cameraId = 1;
        }
        Rd();
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPreview() {
        com.baidu.rtc.camera.engine.a.a.QK().startPreview();
        this.bIy = true;
    }

    private void releaseCamera() {
        this.bIy = false;
        com.baidu.rtc.camera.engine.a.a.QK().releaseCamera();
    }
}
