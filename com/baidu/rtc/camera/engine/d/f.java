package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES30;
import android.os.HandlerThread;
import android.view.Surface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class f extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback {
    private com.baidu.rtc.camera.engine.a.b bPR;
    private d bPS;
    private final Object bPU;
    private com.baidu.rtc.camera.filter.a.a bPk;
    private int bPt;
    private int bPu;
    private final Object bQb;
    private final Object bQc;
    private boolean bQd;
    private boolean bQe;
    private boolean bQf;
    private boolean bQg;
    private com.baidu.rtc.camera.filter.a.c bQh;
    private int bQi;
    private int bQj;
    private final float[] bQk;
    private int bQl;
    private a bQm;
    private e bQn;
    private com.baidu.rtc.camera.a.a bQo;
    private Context mContext;
    private SurfaceTexture mSurfaceTexture;
    private long time;

    public f(Context context, String str) {
        super(str);
        this.bPU = new Object();
        this.bQb = new Object();
        this.bQc = new Object();
        this.bQd = false;
        this.bQe = false;
        this.bQf = false;
        this.bQg = false;
        this.bQk = new float[16];
        this.bQl = 0;
        this.time = 0L;
        this.mContext = context;
        this.bPR = com.baidu.rtc.camera.engine.a.b.Xq();
        this.bQn = e.Xz();
        this.bQm = new a();
    }

    public void a(d dVar) {
        this.bPS = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this.bPU) {
            if (this.bQd || this.bQe) {
                this.bPS.sendMessage(this.bPS.obtainMessage(17, bArr));
            }
        }
        if (this.bPS != null && this.bPR.bPB) {
            this.bPS.sendEmptyMessage(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(byte[] bArr) {
        if (this.bPR.bPM != null) {
            this.bPR.bPM.F(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Surface surface) {
        this.bPk = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.bQh = new com.baidu.rtc.camera.filter.a.c(this.bPk, surface, false);
        this.bQh.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.bQn.init(this.mContext);
        if (this.bQo == null) {
            this.bQo = new com.baidu.rtc.camera.a.a(this.mContext, this.bPk);
        }
        this.bQi = com.baidu.rtc.camera.filter.glfilter.utils.a.XO();
        this.mSurfaceTexture = new SurfaceTexture(this.bQi);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        XI();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.bPk = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.bQh = new com.baidu.rtc.camera.filter.a.c(this.bPk, surfaceTexture);
        this.bQh.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.bQn.init(this.mContext);
        if (this.bQo == null) {
            this.bQo = new com.baidu.rtc.camera.a.a(this.mContext, this.bPk);
        }
        this.bQi = com.baidu.rtc.camera.filter.glfilter.utils.a.XO();
        this.mSurfaceTexture = new SurfaceTexture(this.bQi);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        XI();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceChanged(int i, int i2) {
        this.bQn.W(i, i2);
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceDestroyed() {
        this.bQh.makeCurrent();
        this.bQn.release();
        if (this.bQo != null) {
            this.bQo.release();
            this.bQo = null;
        }
        releaseCamera();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        if (this.bQh != null) {
            this.bQh.release();
            this.bQh = null;
        }
        if (this.bPk != null) {
            this.bPk.release();
            this.bPk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void XF() {
        if (this.mSurfaceTexture != null && this.bQh != null) {
            while (this.bQl > 0) {
                this.bQh.makeCurrent();
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.bQk);
                this.bQl--;
                this.bQj = this.bQn.a(this.bQi, this.bQk);
                this.bQh.swapBuffers();
                if (this.bQe && !this.bQf && this.bQo != null) {
                    if (this.bQg) {
                        this.bQo.Xm();
                        this.bQg = false;
                    }
                    this.bQo.f(this.bQj, System.nanoTime());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void XG() {
        if (this.bPR.bPN != null) {
            this.bQm.Xu();
            this.bPR.bPN.B(this.bQm.Xv());
        }
    }

    private void XH() {
        if (this.bPR.orientation == 90 || this.bPR.orientation == 270) {
            this.bPt = this.bPR.bPJ;
            this.bPu = this.bPR.bPI;
        } else {
            this.bPt = this.bPR.bPI;
            this.bPu = this.bPR.bPJ;
        }
        this.bQn.V(this.bPt, this.bPu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startRecording() {
        this.bQe = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopRecording() {
        this.bQg = true;
        this.bQe = false;
    }

    public void requestRender() {
        synchronized (this.bQb) {
            if (this.bQd) {
                this.bQl++;
                if (this.bPS != null) {
                    this.bPS.sendMessage(this.bPS.obtainMessage(4));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void XI() {
        releaseCamera();
        com.baidu.rtc.camera.engine.a.a.Xp().aT(this.mContext);
        com.baidu.rtc.camera.engine.a.a.Xp().b(this.mSurfaceTexture);
        XH();
        com.baidu.rtc.camera.engine.a.a.Xp().b(this);
        if (this.bPR.bPM != null) {
            this.bPR.bPM.Xr();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchCamera() {
        this.bPR.bPK = !this.bPR.bPK;
        if (this.bPR.bPK) {
            this.bPR.cameraId = 0;
        } else {
            this.bPR.cameraId = 1;
        }
        XI();
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPreview() {
        com.baidu.rtc.camera.engine.a.a.Xp().startPreview();
        this.bQd = true;
    }

    private void releaseCamera() {
        this.bQd = false;
        com.baidu.rtc.camera.engine.a.a.Xp().releaseCamera();
    }
}
