package com.baidu.ar.imu;

import android.hardware.SensorManager;
import com.baidu.ar.arplay.representation.Matrix;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes3.dex */
public class h implements Observer {
    private static final String TAG = h.class.getSimpleName();
    private static final float[] rj = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private static final float[] rk = {0.0f, 0.0f, -1.0f, 0.0f};
    private i qS;
    private float rh;
    private j rl;
    private g rm;
    private float[] rn = new float[16];
    private float ro = -1.0f;
    private float rp = 10000.0f;
    private float[] rq = new float[16];
    private boolean rr = true;
    private boolean rs = false;
    private float[] rt = new float[4];
    private float[] ru = new float[16];

    public h() {
        Matrix.setIdentityM(this.rq, 0);
    }

    private j a(b bVar, SensorManager sensorManager) {
        j kVar;
        if (bVar != b.RELATIVE) {
            kVar = this.qS.dS() ? new k(sensorManager) : new d(sensorManager);
        } else if (this.qS.dP()) {
            kVar = new e(sensorManager);
            if (!this.rr) {
                kVar.rI = true;
                kVar.rJ.matrix = this.rq;
            }
            this.rr = false;
        } else {
            kVar = new a(sensorManager);
        }
        kVar.addObserver(this);
        return kVar;
    }

    private void dM() {
        if (this.rl != null) {
            this.rl.release();
            this.rl = null;
        }
    }

    private void i(float[] fArr) {
        Matrix.invertM(this.rn, 0, fArr, 0);
        Matrix.multiplyMM(this.ru, 0, rj, 0, this.rn, 0);
        this.ro = k(this.ru);
        if (this.ro > 0.0f) {
            this.rp = (float) (600.0d + Math.pow(1.13d, this.ro));
            if (this.rp > 15000.0f) {
                this.rp = 15000.0f;
            }
        }
        Matrix.multiplyMV(this.rt, 0, this.ru, 0, new float[]{0.0f, 0.0f, -this.rp, 1.0f}, 0);
        this.ru[12] = -this.rt[0];
        this.ru[13] = -this.rt[1];
        this.ru[14] = -this.rt[2];
        Matrix.invertM(this.rn, 0, this.ru, 0);
        this.rh = j(this.rt);
        Matrix.rotateM(this.rn, 0, this.rh, 0.0f, 0.0f, 1.0f);
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
        Matrix.multiplyMV(this.rt, 0, fArr, 0, rk, 0);
        if (this.rt[2] > 0.0f) {
            return -1.0f;
        }
        return 90.0f - ((float) ((Math.atan(Math.abs(this.rt[2]) / ((float) Math.sqrt((this.rt[0] * this.rt[0]) + (this.rt[1] * this.rt[1])))) / 3.141592653589793d) * 180.0d));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SensorManager sensorManager, i iVar, g gVar) {
        if (iVar == null) {
            return false;
        }
        this.qS = iVar;
        this.rm = gVar;
        if (this.qS.dN() == b.RELATIVE && !this.qS.dP()) {
            this.rr = true;
        }
        try {
            if (this.rl == null) {
                this.rl = a(this.qS.dN(), sensorManager);
            }
            if (this.rl.dT()) {
                this.rl.start();
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
        if (this.rl != null && this.qS != null && this.qS.dN() == b.RELATIVE && !this.rs && this.qS.dP()) {
            this.rq = this.rl.rJ.matrix;
            this.rs = true;
        }
        try {
            dM();
            this.rm = null;
            this.qS = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        try {
            if (this.qS == null || this.rm == null) {
                return;
            }
            float[] fArr = this.rl.dU().matrix;
            if (this.qS.dR() || this.qS.dQ()) {
                i(fArr);
            }
            float[] dV = this.rl.dV();
            f fVar = new f();
            if (this.qS.dQ()) {
                fVar.setMatrix(this.rn);
            } else {
                fVar.setMatrix(fArr);
            }
            fVar.f(this.rh);
            fVar.I(this.qS.dO());
            fVar.h(dV);
            this.rm.onImuUpdate(fVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
