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
    private com.baidu.rtc.camera.filter.a.a cmZ;
    private com.baidu.rtc.camera.engine.a.b cnH;
    private d cnI;
    private final Object cnK;
    private final Object cnR;
    private final Object cnS;
    private boolean cnT;
    private boolean cnU;
    private boolean cnV;
    private boolean cnW;
    private com.baidu.rtc.camera.filter.a.c cnX;
    private int cnY;
    private int cnZ;
    private int cni;
    private int cnj;
    private final float[] coa;
    private int cob;
    private a coc;
    private e cod;
    private com.baidu.rtc.camera.a.a coe;
    private Context mContext;
    private SurfaceTexture mSurfaceTexture;
    private long time;

    public f(Context context, String str) {
        super(str);
        this.cnK = new Object();
        this.cnR = new Object();
        this.cnS = new Object();
        this.cnT = false;
        this.cnU = false;
        this.cnV = false;
        this.cnW = false;
        this.coa = new float[16];
        this.cob = 0;
        this.time = 0L;
        this.mContext = context;
        this.cnH = com.baidu.rtc.camera.engine.a.b.aec();
        this.cod = e.ael();
        this.coc = new a();
    }

    public void a(d dVar) {
        this.cnI = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this.cnK) {
            if (this.cnT || this.cnU) {
                this.cnI.sendMessage(this.cnI.obtainMessage(17, bArr));
            }
        }
        if (this.cnI != null && this.cnH.cnq) {
            this.cnI.sendEmptyMessage(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(byte[] bArr) {
        if (this.cnH.cnC != null) {
            this.cnH.cnC.F(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Surface surface) {
        this.cmZ = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.cnX = new com.baidu.rtc.camera.filter.a.c(this.cmZ, surface, false);
        this.cnX.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.cod.init(this.mContext);
        if (this.coe == null) {
            this.coe = new com.baidu.rtc.camera.a.a(this.mContext, this.cmZ);
        }
        this.cnY = com.baidu.rtc.camera.filter.glfilter.utils.a.aez();
        this.mSurfaceTexture = new SurfaceTexture(this.cnY);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        openCamera();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.cmZ = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.cnX = new com.baidu.rtc.camera.filter.a.c(this.cmZ, surfaceTexture);
        this.cnX.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.cod.init(this.mContext);
        if (this.coe == null) {
            this.coe = new com.baidu.rtc.camera.a.a(this.mContext, this.cmZ);
        }
        this.cnY = com.baidu.rtc.camera.filter.glfilter.utils.a.aez();
        this.mSurfaceTexture = new SurfaceTexture(this.cnY);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        openCamera();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceChanged(int i, int i2) {
        this.cod.W(i, i2);
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceDestroyed() {
        this.cnX.makeCurrent();
        this.cod.release();
        if (this.coe != null) {
            this.coe.release();
            this.coe = null;
        }
        releaseCamera();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        if (this.cnX != null) {
            this.cnX.release();
            this.cnX = null;
        }
        if (this.cmZ != null) {
            this.cmZ.release();
            this.cmZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aer() {
        if (this.mSurfaceTexture != null && this.cnX != null) {
            while (this.cob > 0) {
                this.cnX.makeCurrent();
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.coa);
                this.cob--;
                this.cnZ = this.cod.a(this.cnY, this.coa);
                this.cnX.swapBuffers();
                if (this.cnU && !this.cnV && this.coe != null) {
                    if (this.cnW) {
                        this.coe.adY();
                        this.cnW = false;
                    }
                    this.coe.f(this.cnZ, System.nanoTime());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void aes() {
        if (this.cnH.cnD != null) {
            this.coc.aeg();
            this.cnH.cnD.H(this.coc.aeh());
        }
    }

    private void aet() {
        if (this.cnH.orientation == 90 || this.cnH.orientation == 270) {
            this.cni = this.cnH.cnz;
            this.cnj = this.cnH.cny;
        } else {
            this.cni = this.cnH.cny;
            this.cnj = this.cnH.cnz;
        }
        this.cod.setTextureSize(this.cni, this.cnj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startRecording() {
        this.cnU = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopRecording() {
        this.cnW = true;
        this.cnU = false;
    }

    public void requestRender() {
        synchronized (this.cnR) {
            if (this.cnT) {
                this.cob++;
                if (this.cnI != null) {
                    this.cnI.sendMessage(this.cnI.obtainMessage(4));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void openCamera() {
        releaseCamera();
        com.baidu.rtc.camera.engine.a.a.aeb().aY(this.mContext);
        com.baidu.rtc.camera.engine.a.a.aeb().b(this.mSurfaceTexture);
        aet();
        com.baidu.rtc.camera.engine.a.a.aeb().b(this);
        if (this.cnH.cnC != null) {
            this.cnH.cnC.aed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchCamera() {
        this.cnH.cnA = !this.cnH.cnA;
        if (this.cnH.cnA) {
            this.cnH.cameraId = 0;
        } else {
            this.cnH.cameraId = 1;
        }
        openCamera();
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPreview() {
        com.baidu.rtc.camera.engine.a.a.aeb().startPreview();
        this.cnT = true;
    }

    private void releaseCamera() {
        this.cnT = false;
        com.baidu.rtc.camera.engine.a.a.aeb().releaseCamera();
    }
}
