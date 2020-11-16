package com.baidu.rtc.camera.engine.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES30;
import android.os.HandlerThread;
import android.view.Surface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes16.dex */
public class f extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback {
    private com.baidu.rtc.camera.engine.a.b clV;
    private d clW;
    private final Object clY;
    private com.baidu.rtc.camera.filter.a.a clo;
    private int clx;
    private int cly;
    private final Object cmg;
    private final Object cmh;
    private boolean cmi;
    private boolean cmj;
    private boolean cmk;
    private boolean cml;
    private com.baidu.rtc.camera.filter.a.c cmm;
    private int cmn;
    private int cmo;
    private final float[] cmp;
    private int cmq;
    private a cmr;
    private e cms;
    private com.baidu.rtc.camera.a.a cmt;
    private Context mContext;
    private SurfaceTexture mSurfaceTexture;
    private long time;

    public f(Context context, String str) {
        super(str);
        this.clY = new Object();
        this.cmg = new Object();
        this.cmh = new Object();
        this.cmi = false;
        this.cmj = false;
        this.cmk = false;
        this.cml = false;
        this.cmp = new float[16];
        this.cmq = 0;
        this.time = 0L;
        this.mContext = context;
        this.clV = com.baidu.rtc.camera.engine.a.b.adu();
        this.cms = e.adD();
        this.cmr = new a();
    }

    public void a(d dVar) {
        this.clW = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this.clY) {
            if (this.cmi || this.cmj) {
                this.clW.sendMessage(this.clW.obtainMessage(17, bArr));
            }
        }
        if (this.clW != null && this.clV.clF) {
            this.clW.sendEmptyMessage(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(byte[] bArr) {
        if (this.clV.clQ != null) {
            this.clV.clQ.F(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Surface surface) {
        this.clo = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.cmm = new com.baidu.rtc.camera.filter.a.c(this.clo, surface, false);
        this.cmm.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.cms.init(this.mContext);
        if (this.cmt == null) {
            this.cmt = new com.baidu.rtc.camera.a.a(this.mContext, this.clo);
        }
        this.cmn = com.baidu.rtc.camera.filter.glfilter.utils.a.adR();
        this.mSurfaceTexture = new SurfaceTexture(this.cmn);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        openCamera();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.clo = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.cmm = new com.baidu.rtc.camera.filter.a.c(this.clo, surfaceTexture);
        this.cmm.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.cms.init(this.mContext);
        if (this.cmt == null) {
            this.cmt = new com.baidu.rtc.camera.a.a(this.mContext, this.clo);
        }
        this.cmn = com.baidu.rtc.camera.filter.glfilter.utils.a.adR();
        this.mSurfaceTexture = new SurfaceTexture(this.cmn);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        openCamera();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceChanged(int i, int i2) {
        this.cms.W(i, i2);
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceDestroyed() {
        this.cmm.makeCurrent();
        this.cms.release();
        if (this.cmt != null) {
            this.cmt.release();
            this.cmt = null;
        }
        releaseCamera();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        if (this.cmm != null) {
            this.cmm.release();
            this.cmm = null;
        }
        if (this.clo != null) {
            this.clo.release();
            this.clo = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void adJ() {
        if (this.mSurfaceTexture != null && this.cmm != null) {
            while (this.cmq > 0) {
                this.cmm.makeCurrent();
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.cmp);
                this.cmq--;
                this.cmo = this.cms.a(this.cmn, this.cmp);
                this.cmm.swapBuffers();
                if (this.cmj && !this.cmk && this.cmt != null) {
                    if (this.cml) {
                        this.cmt.adq();
                        this.cml = false;
                    }
                    this.cmt.f(this.cmo, System.nanoTime());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void adK() {
        if (this.clV.clR != null) {
            this.cmr.ady();
            this.clV.clR.G(this.cmr.adz());
        }
    }

    private void adL() {
        if (this.clV.orientation == 90 || this.clV.orientation == 270) {
            this.clx = this.clV.clN;
            this.cly = this.clV.clM;
        } else {
            this.clx = this.clV.clM;
            this.cly = this.clV.clN;
        }
        this.cms.setTextureSize(this.clx, this.cly);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startRecording() {
        this.cmj = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopRecording() {
        this.cml = true;
        this.cmj = false;
    }

    public void requestRender() {
        synchronized (this.cmg) {
            if (this.cmi) {
                this.cmq++;
                if (this.clW != null) {
                    this.clW.sendMessage(this.clW.obtainMessage(4));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openCamera() {
        releaseCamera();
        com.baidu.rtc.camera.engine.a.a.adt().aY(this.mContext);
        com.baidu.rtc.camera.engine.a.a.adt().b(this.mSurfaceTexture);
        adL();
        com.baidu.rtc.camera.engine.a.a.adt().b(this);
        if (this.clV.clQ != null) {
            this.clV.clQ.adv();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchCamera() {
        this.clV.clO = !this.clV.clO;
        if (this.clV.clO) {
            this.clV.cameraId = 0;
        } else {
            this.clV.cameraId = 1;
        }
        openCamera();
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPreview() {
        com.baidu.rtc.camera.engine.a.a.adt().startPreview();
        this.cmi = true;
    }

    private void releaseCamera() {
        this.cmi = false;
        com.baidu.rtc.camera.engine.a.a.adt().releaseCamera();
    }
}
