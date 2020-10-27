package com.baidu.ar.imu;

import android.hardware.SensorManager;
import com.baidu.ar.arplay.representation.Matrix;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes14.dex */
public class h implements Observer {
    private static final String TAG = h.class.getSimpleName();
    private static final float[] rO = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private static final float[] rP = {0.0f, 0.0f, -1.0f, 0.0f};
    private float rM;
    private j rQ;
    private g rR;

    /* renamed from: rx  reason: collision with root package name */
    private i f1192rx;
    private float[] rS = new float[16];
    private float rT = -1.0f;
    private float rU = 10000.0f;
    private float[] hj = new float[16];
    private boolean rV = true;
    private boolean rW = false;
    private float[] rX = new float[4];
    private float[] rY = new float[16];

    public h() {
        Matrix.setIdentityM(this.hj, 0);
    }

    private j a(b bVar, SensorManager sensorManager) {
        j kVar;
        if (bVar != b.RELATIVE) {
            kVar = this.f1192rx.fc() ? new k(sensorManager) : new d(sensorManager);
        } else if (this.f1192rx.eZ()) {
            kVar = new e(sensorManager);
            if (!this.rV) {
                kVar.sm = true;
                kVar.sn.matrix = this.hj;
            }
            this.rV = false;
        } else {
            kVar = new a(sensorManager);
        }
        kVar.addObserver(this);
        return kVar;
    }

    private void eW() {
        if (this.rQ != null) {
            this.rQ.release();
            this.rQ = null;
        }
    }

    private void i(float[] fArr) {
        Matrix.invertM(this.rS, 0, fArr, 0);
        Matrix.multiplyMM(this.rY, 0, rO, 0, this.rS, 0);
        this.rT = k(this.rY);
        if (this.rT > 0.0f) {
            this.rU = (float) (600.0d + Math.pow(1.13d, this.rT));
            if (this.rU > 15000.0f) {
                this.rU = 15000.0f;
            }
        }
        Matrix.multiplyMV(this.rX, 0, this.rY, 0, new float[]{0.0f, 0.0f, -this.rU, 1.0f}, 0);
        this.rY[12] = -this.rX[0];
        this.rY[13] = -this.rX[1];
        this.rY[14] = -this.rX[2];
        Matrix.invertM(this.rS, 0, this.rY, 0);
        this.rM = j(this.rX);
        Matrix.rotateM(this.rS, 0, this.rM, 0.0f, 0.0f, 1.0f);
    }

    private float j(float[] fArr) {
        float f = -fArr[0];
        float f2 = -fArr[1];
        if (f2 != 0.0f || f >= 0.0f) {
            if (f2 != 0.0f || f <= 0.0f) {
                if (f != 0.0f || f2 >= 0.0f) {
                    if (f != 0.0f || f2 <= 0.0f) {
                        float atan = (float) ((Math.atan(Math.abs(f2) / Math.abs(f)) / 3.141592653589793d) * 180.0d);
                        if (f > 0.0f && f2 < 0.0f) {
                            atan = 180.0f - atan;
                        }
                        float f3 = (f <= 0.0f || f2 <= 0.0f) ? atan : 180.0f + atan;
                        return (f >= 0.0f || f2 <= 0.0f) ? f3 : 360.0f - f3;
                    }
                    return 270.0f;
                }
                return 90.0f;
            }
            return 180.0f;
        }
        return 0.0f;
    }

    private float k(float[] fArr) {
        Matrix.multiplyMV(this.rX, 0, fArr, 0, rP, 0);
        if (this.rX[2] > 0.0f) {
            return -1.0f;
        }
        return 90.0f - ((float) ((Math.atan(Math.abs(this.rX[2]) / ((float) Math.sqrt((this.rX[0] * this.rX[0]) + (this.rX[1] * this.rX[1])))) / 3.141592653589793d) * 180.0d));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SensorManager sensorManager, i iVar, g gVar) {
        if (iVar == null) {
            return false;
        }
        this.f1192rx = iVar;
        this.rR = gVar;
        if (this.f1192rx.eX() == b.RELATIVE && !this.f1192rx.eZ()) {
            this.rV = true;
        }
        try {
            if (this.rQ == null) {
                this.rQ = a(this.f1192rx.eX(), sensorManager);
            }
            if (this.rQ.fd()) {
                this.rQ.start();
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.baidu.ar.g.b.b(TAG, "IMUController start: " + th.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stop() {
        if (this.rQ != null && this.f1192rx != null && this.f1192rx.eX() == b.RELATIVE && !this.rW && this.f1192rx.eZ()) {
            this.hj = this.rQ.sn.matrix;
            this.rW = true;
        }
        try {
            eW();
            this.rR = null;
            this.f1192rx = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        try {
            if (this.f1192rx == null || this.rR == null) {
                return;
            }
            float[] fArr = this.rQ.fe().matrix;
            if (this.f1192rx.fb() || this.f1192rx.fa()) {
                i(fArr);
            }
            float[] ff = this.rQ.ff();
            f fVar = new f();
            if (this.f1192rx.fa()) {
                fVar.setMatrix(this.rS);
            } else {
                fVar.setMatrix(fArr);
            }
            fVar.f(this.rM);
            fVar.K(this.f1192rx.eY());
            fVar.h(ff);
            this.rR.onImuUpdate(fVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
