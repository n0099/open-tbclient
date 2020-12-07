package com.baidu.ar.imu;

import android.hardware.SensorManager;
import com.baidu.ar.arplay.representation.Matrix;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes10.dex */
public class h implements Observer {
    private static final String TAG = h.class.getSimpleName();
    private static final float[] sf = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private static final float[] sg = {0.0f, 0.0f, -1.0f, 0.0f};
    private i rO;
    private float sd;
    private j sh;
    private g si;
    private float[] sj = new float[16];
    private float sk = -1.0f;
    private float sl = 10000.0f;
    private float[] hp = new float[16];
    private boolean sm = true;
    private boolean sn = false;
    private float[] so = new float[4];
    private float[] sp = new float[16];

    public h() {
        Matrix.setIdentityM(this.hp, 0);
    }

    private j a(b bVar, SensorManager sensorManager) {
        j kVar;
        if (bVar != b.RELATIVE) {
            kVar = this.rO.fb() ? new k(sensorManager) : new d(sensorManager);
        } else if (this.rO.eY()) {
            kVar = new e(sensorManager);
            if (!this.sm) {
                kVar.sD = true;
                kVar.sE.matrix = this.hp;
            }
            this.sm = false;
        } else {
            kVar = new a(sensorManager);
        }
        kVar.addObserver(this);
        return kVar;
    }

    private void eV() {
        if (this.sh != null) {
            this.sh.release();
            this.sh = null;
        }
    }

    private void h(float[] fArr) {
        Matrix.invertM(this.sj, 0, fArr, 0);
        Matrix.multiplyMM(this.sp, 0, sf, 0, this.sj, 0);
        this.sk = j(this.sp);
        if (this.sk > 0.0f) {
            this.sl = (float) (600.0d + Math.pow(1.13d, this.sk));
            if (this.sl > 15000.0f) {
                this.sl = 15000.0f;
            }
        }
        Matrix.multiplyMV(this.so, 0, this.sp, 0, new float[]{0.0f, 0.0f, -this.sl, 1.0f}, 0);
        this.sp[12] = -this.so[0];
        this.sp[13] = -this.so[1];
        this.sp[14] = -this.so[2];
        Matrix.invertM(this.sj, 0, this.sp, 0);
        this.sd = i(this.so);
        Matrix.rotateM(this.sj, 0, this.sd, 0.0f, 0.0f, 1.0f);
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
        Matrix.multiplyMV(this.so, 0, fArr, 0, sg, 0);
        if (this.so[2] > 0.0f) {
            return -1.0f;
        }
        return 90.0f - ((float) ((Math.atan(Math.abs(this.so[2]) / ((float) Math.sqrt((this.so[0] * this.so[0]) + (this.so[1] * this.so[1])))) / 3.141592653589793d) * 180.0d));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(SensorManager sensorManager, i iVar, g gVar) {
        if (iVar == null) {
            return false;
        }
        this.rO = iVar;
        this.si = gVar;
        if (this.rO.eW() == b.RELATIVE && !this.rO.eY()) {
            this.sm = true;
        }
        try {
            if (this.sh == null) {
                this.sh = a(this.rO.eW(), sensorManager);
            }
            if (this.sh.fc()) {
                this.sh.start();
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.baidu.ar.h.b.b(TAG, "IMUController start: " + th.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stop() {
        if (this.sh != null && this.rO != null && this.rO.eW() == b.RELATIVE && !this.sn && this.rO.eY()) {
            this.hp = this.sh.sE.matrix;
            this.sn = true;
        }
        try {
            eV();
            this.si = null;
            this.rO = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        try {
            if (this.rO == null || this.si == null) {
                return;
            }
            float[] fArr = this.sh.fd().matrix;
            if (this.rO.fa() || this.rO.eZ()) {
                h(fArr);
            }
            float[] fe = this.sh.fe();
            f fVar = new f();
            if (this.rO.eZ()) {
                fVar.setMatrix(this.sj);
            } else {
                fVar.setMatrix(fArr);
            }
            fVar.e(this.sd);
            fVar.M(this.rO.eX());
            fVar.g(fe);
            this.si.onImuUpdate(fVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
