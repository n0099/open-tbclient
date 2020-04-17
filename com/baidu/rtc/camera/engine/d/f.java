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
    private com.baidu.rtc.camera.filter.a.a buL;
    private int buV;
    private int buW;
    private final Object bvB;
    private final Object bvC;
    private boolean bvD;
    private boolean bvE;
    private boolean bvF;
    private boolean bvG;
    private com.baidu.rtc.camera.filter.a.c bvH;
    private int bvI;
    private int bvJ;
    private final float[] bvK;
    private int bvL;
    private a bvM;
    private e bvN;
    private com.baidu.rtc.camera.a.a bvO;
    private com.baidu.rtc.camera.engine.a.b bvr;
    private d bvs;
    private final Object bvu;
    private Context mContext;
    private SurfaceTexture mSurfaceTexture;
    private long time;

    public f(Context context, String str) {
        super(str);
        this.bvu = new Object();
        this.bvB = new Object();
        this.bvC = new Object();
        this.bvD = false;
        this.bvE = false;
        this.bvF = false;
        this.bvG = false;
        this.bvK = new float[16];
        this.bvL = 0;
        this.time = 0L;
        this.mContext = context;
        this.bvr = com.baidu.rtc.camera.engine.a.b.Ne();
        this.bvN = e.Nn();
        this.bvM = new a();
    }

    public void a(d dVar) {
        this.bvs = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this.bvu) {
            if (this.bvD || this.bvE) {
                this.bvs.sendMessage(this.bvs.obtainMessage(17, bArr));
            }
        }
        if (this.bvs != null && this.bvr.bvd) {
            this.bvs.sendEmptyMessage(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(byte[] bArr) {
        if (this.bvr.bvm != null) {
            this.bvr.bvm.v(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Surface surface) {
        this.buL = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.bvH = new com.baidu.rtc.camera.filter.a.c(this.buL, surface, false);
        this.bvH.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.bvN.init(this.mContext);
        if (this.bvO == null) {
            this.bvO = new com.baidu.rtc.camera.a.a(this.mContext, this.buL);
        }
        this.bvI = com.baidu.rtc.camera.filter.glfilter.utils.a.ND();
        this.mSurfaceTexture = new SurfaceTexture(this.bvI);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        Nw();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.buL = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.bvH = new com.baidu.rtc.camera.filter.a.c(this.buL, surfaceTexture);
        this.bvH.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.bvN.init(this.mContext);
        if (this.bvO == null) {
            this.bvO = new com.baidu.rtc.camera.a.a(this.mContext, this.buL);
        }
        this.bvI = com.baidu.rtc.camera.filter.glfilter.utils.a.ND();
        this.mSurfaceTexture = new SurfaceTexture(this.bvI);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        Nw();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceChanged(int i, int i2) {
        this.bvN.O(i, i2);
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceDestroyed() {
        this.bvH.makeCurrent();
        this.bvN.release();
        if (this.bvO != null) {
            this.bvO.release();
            this.bvO = null;
        }
        releaseCamera();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        if (this.bvH != null) {
            this.bvH.release();
            this.bvH = null;
        }
        if (this.buL != null) {
            this.buL.release();
            this.buL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Nt() {
        if (this.mSurfaceTexture != null && this.bvH != null) {
            while (this.bvL > 0) {
                this.bvH.makeCurrent();
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.bvK);
                this.bvL--;
                this.bvJ = this.bvN.a(this.bvI, this.bvK);
                this.bvH.swapBuffers();
                if (this.bvE && !this.bvF && this.bvO != null) {
                    if (this.bvG) {
                        this.bvO.Na();
                        this.bvG = false;
                    }
                    this.bvO.e(this.bvJ, System.nanoTime());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Nu() {
        if (this.bvr.bvn != null) {
            this.bvM.Ni();
            this.bvr.bvn.u(this.bvM.Nj());
        }
    }

    private void Nv() {
        if (this.bvr.orientation == 90 || this.bvr.orientation == 270) {
            this.buV = this.bvr.previewHeight;
            this.buW = this.bvr.previewWidth;
        } else {
            this.buV = this.bvr.previewWidth;
            this.buW = this.bvr.previewHeight;
        }
        this.bvN.N(this.buV, this.buW);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startRecording() {
        this.bvE = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopRecording() {
        this.bvG = true;
        this.bvE = false;
    }

    public void requestRender() {
        synchronized (this.bvB) {
            if (this.bvD) {
                this.bvL++;
                if (this.bvs != null) {
                    this.bvs.sendMessage(this.bvs.obtainMessage(4));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Nw() {
        releaseCamera();
        com.baidu.rtc.camera.engine.a.a.Nd().aP(this.mContext);
        com.baidu.rtc.camera.engine.a.a.Nd().b(this.mSurfaceTexture);
        Nv();
        com.baidu.rtc.camera.engine.a.a.Nd().setPreviewCallback(this);
        if (this.bvr.bvm != null) {
            this.bvr.bvm.Nf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchCamera() {
        this.bvr.bvk = !this.bvr.bvk;
        if (this.bvr.bvk) {
            this.bvr.cameraId = 0;
        } else {
            this.bvr.cameraId = 1;
        }
        Nw();
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPreview() {
        com.baidu.rtc.camera.engine.a.a.Nd().startPreview();
        this.bvD = true;
    }

    private void releaseCamera() {
        this.bvD = false;
        com.baidu.rtc.camera.engine.a.a.Nd().releaseCamera();
    }
}
