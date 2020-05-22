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
    private int bCD;
    private int bCE;
    private com.baidu.rtc.camera.engine.a.b bCZ;
    private com.baidu.rtc.camera.filter.a.a bCt;
    private d bDa;
    private final Object bDc;
    private final Object bDj;
    private final Object bDk;
    private boolean bDl;
    private boolean bDm;
    private boolean bDn;
    private boolean bDo;
    private com.baidu.rtc.camera.filter.a.c bDp;
    private int bDq;
    private int bDr;
    private final float[] bDs;
    private int bDt;
    private a bDu;
    private e bDv;
    private com.baidu.rtc.camera.a.a bDw;
    private Context mContext;
    private SurfaceTexture mSurfaceTexture;
    private long time;

    public f(Context context, String str) {
        super(str);
        this.bDc = new Object();
        this.bDj = new Object();
        this.bDk = new Object();
        this.bDl = false;
        this.bDm = false;
        this.bDn = false;
        this.bDo = false;
        this.bDs = new float[16];
        this.bDt = 0;
        this.time = 0L;
        this.mContext = context;
        this.bCZ = com.baidu.rtc.camera.engine.a.b.Pq();
        this.bDv = e.Pz();
        this.bDu = new a();
    }

    public void a(d dVar) {
        this.bDa = dVar;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this.bDc) {
            if (this.bDl || this.bDm) {
                this.bDa.sendMessage(this.bDa.obtainMessage(17, bArr));
            }
        }
        if (this.bDa != null && this.bCZ.bCL) {
            this.bDa.sendEmptyMessage(19);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(byte[] bArr) {
        if (this.bCZ.bCU != null) {
            this.bCZ.bCU.C(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Surface surface) {
        this.bCt = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.bDp = new com.baidu.rtc.camera.filter.a.c(this.bCt, surface, false);
        this.bDp.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.bDv.init(this.mContext);
        if (this.bDw == null) {
            this.bDw = new com.baidu.rtc.camera.a.a(this.mContext, this.bCt);
        }
        this.bDq = com.baidu.rtc.camera.filter.glfilter.utils.a.PP();
        this.mSurfaceTexture = new SurfaceTexture(this.bDq);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        PI();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceCreated(SurfaceTexture surfaceTexture) {
        this.bCt = new com.baidu.rtc.camera.filter.a.a(null, 1);
        this.bDp = new com.baidu.rtc.camera.filter.a.c(this.bCt, surfaceTexture);
        this.bDp.makeCurrent();
        GLES30.glDisable(2929);
        GLES30.glDisable(2884);
        this.bDv.init(this.mContext);
        if (this.bDw == null) {
            this.bDw = new com.baidu.rtc.camera.a.a(this.mContext, this.bCt);
        }
        this.bDq = com.baidu.rtc.camera.filter.glfilter.utils.a.PP();
        this.mSurfaceTexture = new SurfaceTexture(this.bDq);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        PI();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceChanged(int i, int i2) {
        this.bDv.R(i, i2);
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void surfaceDestroyed() {
        this.bDp.makeCurrent();
        this.bDv.release();
        if (this.bDw != null) {
            this.bDw.release();
            this.bDw = null;
        }
        releaseCamera();
        if (this.mSurfaceTexture != null) {
            this.mSurfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        if (this.bDp != null) {
            this.bDp.release();
            this.bDp = null;
        }
        if (this.bCt != null) {
            this.bCt.release();
            this.bCt = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void PF() {
        if (this.mSurfaceTexture != null && this.bDp != null) {
            while (this.bDt > 0) {
                this.bDp.makeCurrent();
                this.mSurfaceTexture.updateTexImage();
                this.mSurfaceTexture.getTransformMatrix(this.bDs);
                this.bDt--;
                this.bDr = this.bDv.a(this.bDq, this.bDs);
                this.bDp.swapBuffers();
                if (this.bDm && !this.bDn && this.bDw != null) {
                    if (this.bDo) {
                        this.bDw.Pm();
                        this.bDo = false;
                    }
                    this.bDw.e(this.bDr, System.nanoTime());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void PG() {
        if (this.bCZ.bCV != null) {
            this.bDu.Pu();
            this.bCZ.bCV.u(this.bDu.Pv());
        }
    }

    private void PH() {
        if (this.bCZ.orientation == 90 || this.bCZ.orientation == 270) {
            this.bCD = this.bCZ.previewHeight;
            this.bCE = this.bCZ.previewWidth;
        } else {
            this.bCD = this.bCZ.previewWidth;
            this.bCE = this.bCZ.previewHeight;
        }
        this.bDv.Q(this.bCD, this.bCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startRecording() {
        this.bDm = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopRecording() {
        this.bDo = true;
        this.bDm = false;
    }

    public void requestRender() {
        synchronized (this.bDj) {
            if (this.bDl) {
                this.bDt++;
                if (this.bDa != null) {
                    this.bDa.sendMessage(this.bDa.obtainMessage(4));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void PI() {
        releaseCamera();
        com.baidu.rtc.camera.engine.a.a.Pp().aN(this.mContext);
        com.baidu.rtc.camera.engine.a.a.Pp().b(this.mSurfaceTexture);
        PH();
        com.baidu.rtc.camera.engine.a.a.Pp().setPreviewCallback(this);
        if (this.bCZ.bCU != null) {
            this.bCZ.bCU.Pr();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void switchCamera() {
        this.bCZ.bCS = !this.bCZ.bCS;
        if (this.bCZ.bCS) {
            this.bCZ.cameraId = 0;
        } else {
            this.bCZ.cameraId = 1;
        }
        PI();
        startPreview();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startPreview() {
        com.baidu.rtc.camera.engine.a.a.Pp().startPreview();
        this.bDl = true;
    }

    private void releaseCamera() {
        this.bDl = false;
        com.baidu.rtc.camera.engine.a.a.Pp().releaseCamera();
    }
}
