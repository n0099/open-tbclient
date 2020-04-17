package com.baidu.ar.imu;

import android.hardware.SensorManager;
import com.baidu.ar.arplay.representation.Matrix;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes3.dex */
public class h implements Observer {
    private static final String TAG = h.class.getSimpleName();
    private static final float[] qK = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private static final float[] qL = {0.0f, 0.0f, -1.0f, 0.0f};
    private float qI;
    private j qM;
    private g qN;
    private float[] qO = new float[16];
    private float qP = -1.0f;
    private float qQ = 10000.0f;
    private float[] qR = new float[16];
    private boolean qS = true;
    private boolean qT = false;
    private float[] qU = new float[4];
    private float[] qV = new float[16];
    private i qt;

    public h() {
        Matrix.setIdentityM(this.qR, 0);
    }

    private j a(b bVar, SensorManager sensorManager) {
        j kVar;
        if (bVar != b.RELATIVE) {
            kVar = this.qt.dC() ? new k(sensorManager) : new d(sensorManager);
        } else if (this.qt.dz()) {
            kVar = new e(sensorManager);
            if (!this.qS) {
                kVar.rj = true;
                kVar.rk.matrix = this.qR;
            }
            this.qS = false;
        } else {
            kVar = new a(sensorManager);
        }
        kVar.addObserver(this);
        return kVar;
    }

    private void dw() {
        if (this.qM != null) {
            this.qM.release();
            this.qM = null;
        }
    }

    private void h(float[] fArr) {
        Matrix.invertM(this.qO, 0, fArr, 0);
        Matrix.multiplyMM(this.qV, 0, qK, 0, this.qO, 0);
        this.qP = j(this.qV);
        if (this.qP > 0.0f) {
            this.qQ = (float) (600.0d + Math.pow(1.13d, this.qP));
            if (this.qQ > 15000.0f) {
                this.qQ = 15000.0f;
            }
        }
        Matrix.multiplyMV(this.qU, 0, this.qV, 0, new float[]{0.0f, 0.0f, -this.qQ, 1.0f}, 0);
        this.qV[12] = -this.qU[0];
        this.qV[13] = -this.qU[1];
        this.qV[14] = -this.qU[2];
        Matrix.invertM(this.qO, 0, this.qV, 0);
        this.qI = i(this.qU);
        Matrix.rotateM(this.qO, 0, this.qI, 0.0f, 0.0f, 1.0f);
    }

    private float i(float[] fArr) {
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

    private float j(float[] fArr) {
        Matrix.multiplyMV(this.qU, 0, fArr, 0, qL, 0);
        if (this.qU[2] > 0.0f) {
            return -1.0f;
        }
        return 90.0f - ((float) ((Math.atan(Math.abs(this.qU[2]) / ((float) Math.sqrt((this.qU[0] * this.qU[0]) + (this.qU[1] * this.qU[1])))) / 3.141592653589793d) * 180.0d));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SensorManager sensorManager, i iVar, g gVar) {
        if (iVar == null) {
            return false;
        }
        this.qt = iVar;
        this.qN = gVar;
        if (this.qt.dx() == b.RELATIVE && !this.qt.dz()) {
            this.qS = true;
        }
        try {
            if (this.qM == null) {
                this.qM = a(this.qt.dx(), sensorManager);
            }
            if (this.qM.dD()) {
                this.qM.start();
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.baidu.ar.f.b.b(TAG, "IMUController start: " + th.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stop() {
        if (this.qM != null && this.qt != null && this.qt.dx() == b.RELATIVE && !this.qT && this.qt.dz()) {
            this.qR = this.qM.rk.matrix;
            this.qT = true;
        }
        try {
            dw();
            this.qN = null;
            this.qt = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        try {
            if (this.qt == null || this.qN == null) {
                return;
            }
            float[] fArr = this.qM.dE().matrix;
            if (this.qt.dB() || this.qt.dA()) {
                h(fArr);
            }
            float[] dF = this.qM.dF();
            f fVar = new f();
            if (this.qt.dA()) {
                fVar.setMatrix(this.qO);
            } else {
                fVar.setMatrix(fArr);
            }
            fVar.d(this.qI);
            fVar.C(this.qt.dy());
            fVar.g(dF);
            this.qN.onImuUpdate(fVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
