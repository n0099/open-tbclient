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
    private com.baidu.rtc.camera.filter.a.a buQ;
    private final Object bvG;
    private final Object bvH;
    private boolean bvI;
    private boolean bvJ;
    private boolean bvK;
    private boolean bvL;
    private com.baidu.rtc.camera.filter.a.c bvM;
    private int bvN;
    private int bvO;
    private final float[] bvP;
    private int bvQ;
    private a bvR;
    private e bvS;
    private com.baidu.rtc.camera.a.a bvT;
    private int bva;
    private int bvb;
    private com.baidu.rtc.camera.engine.a.b bvw;
    private d bvx;
    private final Object bvz;
    private Context mContext;
    private SurfaceTexture mSurfaceTexture;
    private long time;

    public f(Context context, String str) {
        super(str);
        this.bvz = new Object();
        this.bvG = new Object();
        this.bvH = new Object();
        this.bvI = false;
        this.bvJ = false;
        this.bvK = false;
        this.bvL = false;
        this.bvP = new float[16];
        this.bvQ = 0;
        this.time = 0L;
        this.mContext = context;
        this.bvw = com.baidu.rtc.camera.engine.a.b.Nd();
        this.bvS = e.Nm();
        this.bvR = new a();
    }

    public void a(d dVar) {
        this.bvx = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this.bvz) {
            if (this.bvI || this.bvJ) {
                this.bvx.sendMessage(this.bvx.obtainMessage(17, bArr));
            }
        }
        if (this.bvx != null && this.bvw.bvi) {
            this.bvx.sendEmptyMessage(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(byte[] bArr) {
        if (this.bvw.bvr != null) {
            this.bvw.bvr.v(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Surface surface) {
        this.buQ = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.bvM = new com.baidu.rtc.camera.filter.a.c(this.buQ, surface, false);
        this.bvM.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.bvS.init(this.mContext);
        if (this.bvT == null) {
            this.bvT = new com.baidu.rtc.camera.a.a(this.mContext, this.buQ);
        }
        this.bvN = com.baidu.rtc.camera.filter.glfilter.utils.a.NC();
        this.mSurfaceTexture = new SurfaceTexture(this.bvN);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        Nv();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.buQ = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.bvM = new com.baidu.rtc.camera.filter.a.c(this.buQ, surfaceTexture);
        this.bvM.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.bvS.init(this.mContext);
        if (this.bvT == null) {
            this.bvT = new com.baidu.rtc.camera.a.a(this.mContext, this.buQ);
        }
        this.bvN = com.baidu.rtc.camera.filter.glfilter.utils.a.NC();
        this.mSurfaceTexture = new SurfaceTexture(this.bvN);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        Nv();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceChanged(int i, int i2) {
        this.bvS.O(i, i2);
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceDestroyed() {
        this.bvM.makeCurrent();
        this.bvS.release();
        if (this.bvT != null) {
            this.bvT.release();
            this.bvT = null;
        }
        releaseCamera();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        if (this.bvM != null) {
            this.bvM.release();
            this.bvM = null;
        }
        if (this.buQ != null) {
            this.buQ.release();
            this.buQ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ns() {
        if (this.mSurfaceTexture != null && this.bvM != null) {
            while (this.bvQ > 0) {
                this.bvM.makeCurrent();
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.bvP);
                this.bvQ--;
                this.bvO = this.bvS.a(this.bvN, this.bvP);
                this.bvM.swapBuffers();
                if (this.bvJ && !this.bvK && this.bvT != null) {
                    if (this.bvL) {
                        this.bvT.MZ();
                        this.bvL = false;
                    }
                    this.bvT.e(this.bvO, System.nanoTime());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Nt() {
        if (this.bvw.bvs != null) {
            this.bvR.Nh();
            this.bvw.bvs.u(this.bvR.Ni());
        }
    }

    private void Nu() {
        if (this.bvw.orientation == 90 || this.bvw.orientation == 270) {
            this.bva = this.bvw.previewHeight;
            this.bvb = this.bvw.previewWidth;
        } else {
            this.bva = this.bvw.previewWidth;
            this.bvb = this.bvw.previewHeight;
        }
        this.bvS.N(this.bva, this.bvb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startRecording() {
        this.bvJ = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopRecording() {
        this.bvL = true;
        this.bvJ = false;
    }

    public void requestRender() {
        synchronized (this.bvG) {
            if (this.bvI) {
                this.bvQ++;
                if (this.bvx != null) {
                    this.bvx.sendMessage(this.bvx.obtainMessage(4));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Nv() {
        releaseCamera();
        com.baidu.rtc.camera.engine.a.a.Nc().aD(this.mContext);
        com.baidu.rtc.camera.engine.a.a.Nc().b(this.mSurfaceTexture);
        Nu();
        com.baidu.rtc.camera.engine.a.a.Nc().setPreviewCallback(this);
        if (this.bvw.bvr != null) {
            this.bvw.bvr.Ne();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchCamera() {
        this.bvw.bvp = !this.bvw.bvp;
        if (this.bvw.bvp) {
            this.bvw.cameraId = 0;
        } else {
            this.bvw.cameraId = 1;
        }
        Nv();
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPreview() {
        com.baidu.rtc.camera.engine.a.a.Nc().startPreview();
        this.bvI = true;
    }

    private void releaseCamera() {
        this.bvI = false;
        com.baidu.rtc.camera.engine.a.a.Nc().releaseCamera();
    }
}
