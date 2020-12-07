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
    private com.baidu.rtc.camera.engine.a.b csR;
    private d csS;
    private final Object csU;
    private com.baidu.rtc.camera.filter.a.a csm;
    private int csv;
    private int csw;
    private final Object ctb;
    private final Object ctc;
    private boolean ctd;
    private boolean cte;
    private boolean ctf;
    private boolean ctg;
    private com.baidu.rtc.camera.filter.a.c cth;
    private int cti;
    private int ctj;
    private final float[] ctk;
    private int ctl;
    private a ctm;
    private e ctn;
    private com.baidu.rtc.camera.a.a cto;
    private Context mContext;
    private SurfaceTexture mSurfaceTexture;
    private long time;

    public f(Context context, String str) {
        super(str);
        this.csU = new Object();
        this.ctb = new Object();
        this.ctc = new Object();
        this.ctd = false;
        this.cte = false;
        this.ctf = false;
        this.ctg = false;
        this.ctk = new float[16];
        this.ctl = 0;
        this.time = 0L;
        this.mContext = context;
        this.csR = com.baidu.rtc.camera.engine.a.b.agC();
        this.ctn = e.agL();
        this.ctm = new a();
    }

    public void a(d dVar) {
        this.csS = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this.csU) {
            if (this.ctd || this.cte) {
                this.csS.sendMessage(this.csS.obtainMessage(17, bArr));
            }
        }
        if (this.csS != null && this.csR.csD) {
            this.csS.sendEmptyMessage(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(byte[] bArr) {
        if (this.csR.csM != null) {
            this.csR.csM.H(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Surface surface) {
        this.csm = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.cth = new com.baidu.rtc.camera.filter.a.c(this.csm, surface, false);
        this.cth.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.ctn.init(this.mContext);
        if (this.cto == null) {
            this.cto = new com.baidu.rtc.camera.a.a(this.mContext, this.csm);
        }
        this.cti = com.baidu.rtc.camera.filter.glfilter.utils.a.agZ();
        this.mSurfaceTexture = new SurfaceTexture(this.cti);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        openCamera();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.csm = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.cth = new com.baidu.rtc.camera.filter.a.c(this.csm, surfaceTexture);
        this.cth.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.ctn.init(this.mContext);
        if (this.cto == null) {
            this.cto = new com.baidu.rtc.camera.a.a(this.mContext, this.csm);
        }
        this.cti = com.baidu.rtc.camera.filter.glfilter.utils.a.agZ();
        this.mSurfaceTexture = new SurfaceTexture(this.cti);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        openCamera();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceChanged(int i, int i2) {
        this.ctn.Y(i, i2);
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceDestroyed() {
        this.cth.makeCurrent();
        this.ctn.release();
        if (this.cto != null) {
            this.cto.release();
            this.cto = null;
        }
        releaseCamera();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        if (this.cth != null) {
            this.cth.release();
            this.cth = null;
        }
        if (this.csm != null) {
            this.csm.release();
            this.csm = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void agR() {
        if (this.mSurfaceTexture != null && this.cth != null) {
            while (this.ctl > 0) {
                this.cth.makeCurrent();
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.ctk);
                this.ctl--;
                this.ctj = this.ctn.a(this.cti, this.ctk);
                this.cth.swapBuffers();
                if (this.cte && !this.ctf && this.cto != null) {
                    if (this.ctg) {
                        this.cto.agy();
                        this.ctg = false;
                    }
                    this.cto.f(this.ctj, System.nanoTime());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void agS() {
        if (this.csR.csN != null) {
            this.ctm.agG();
            this.csR.csN.G(this.ctm.agH());
        }
    }

    private void agT() {
        if (this.csR.orientation == 90 || this.csR.orientation == 270) {
            this.csv = this.csR.previewHeight;
            this.csw = this.csR.previewWidth;
        } else {
            this.csv = this.csR.previewWidth;
            this.csw = this.csR.previewHeight;
        }
        this.ctn.setTextureSize(this.csv, this.csw);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startRecording() {
        this.cte = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopRecording() {
        this.ctg = true;
        this.cte = false;
    }

    public void requestRender() {
        synchronized (this.ctb) {
            if (this.ctd) {
                this.ctl++;
                if (this.csS != null) {
                    this.csS.sendMessage(this.csS.obtainMessage(4));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openCamera() {
        releaseCamera();
        com.baidu.rtc.camera.engine.a.a.agB().bE(this.mContext);
        com.baidu.rtc.camera.engine.a.a.agB().b(this.mSurfaceTexture);
        agT();
        com.baidu.rtc.camera.engine.a.a.agB().b(this);
        if (this.csR.csM != null) {
            this.csR.csM.agD();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchCamera() {
        this.csR.csK = !this.csR.csK;
        if (this.csR.csK) {
            this.csR.cameraId = 0;
        } else {
            this.csR.cameraId = 1;
        }
        openCamera();
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPreview() {
        com.baidu.rtc.camera.engine.a.a.agB().startPreview();
        this.ctd = true;
    }

    private void releaseCamera() {
        this.ctd = false;
        com.baidu.rtc.camera.engine.a.a.agB().releaseCamera();
    }
}
