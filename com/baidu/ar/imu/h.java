package com.baidu.ar.imu;

import android.hardware.SensorManager;
import com.baidu.ar.arplay.representation.Matrix;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes.dex */
public class h implements Observer {
    public static final String TAG = h.class.getSimpleName();
    public static final float[] sf = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    public static final float[] sg = {0.0f, 0.0f, -1.0f, 0.0f};
    public float[] hp;
    public i rO;
    public float sd;
    public j sh;
    public g si;
    public float[] sj = new float[16];
    public float sk = -1.0f;
    public float sl = 10000.0f;
    public boolean sm = true;
    public boolean sn = false;
    public float[] so = new float[4];
    public float[] sp = new float[16];

    public h() {
        float[] fArr = new float[16];
        this.hp = fArr;
        Matrix.setIdentityM(fArr, 0);
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
        j jVar = this.sh;
        if (jVar != null) {
            jVar.release();
            this.sh = null;
        }
    }

    private void h(float[] fArr) {
        Matrix.invertM(this.sj, 0, fArr, 0);
        Matrix.multiplyMM(this.sp, 0, sf, 0, this.sj, 0);
        float j = j(this.sp);
        this.sk = j;
        if (j > 0.0f) {
            float pow = (float) (Math.pow(1.13d, j) + 600.0d);
            this.sl = pow;
            if (pow > 15000.0f) {
                this.sl = 15000.0f;
            }
        }
        Matrix.multiplyMV(this.so, 0, this.sp, 0, new float[]{0.0f, 0.0f, -this.sl, 1.0f}, 0);
        float[] fArr2 = this.sp;
        float[] fArr3 = this.so;
        fArr2[12] = -fArr3[0];
        fArr2[13] = -fArr3[1];
        fArr2[14] = -fArr3[2];
        Matrix.invertM(this.sj, 0, fArr2, 0);
        float i = i(this.so);
        this.sd = i;
        Matrix.rotateM(this.sj, 0, i, 0.0f, 0.0f, 1.0f);
    }

    private float i(float[] fArr) {
        float f = -fArr[0];
        float f2 = -fArr[1];
        int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i != 0 || f >= 0.0f) {
            if (i != 0 || f <= 0.0f) {
                int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i2 != 0 || f2 >= 0.0f) {
                    if (i2 != 0 || i <= 0) {
                        float atan = (float) ((Math.atan(Math.abs(f2) / Math.abs(f)) / 3.141592653589793d) * 180.0d);
                        if (i2 > 0 && f2 < 0.0f) {
                            atan = 180.0f - atan;
                        }
                        if (i2 > 0 && i > 0) {
                            atan += 180.0f;
                        }
                        return (f >= 0.0f || i <= 0) ? atan : 360.0f - atan;
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
        float[] fArr2 = this.so;
        if (fArr2[2] > 0.0f) {
            return -1.0f;
        }
        return 90.0f - ((float) ((Math.atan(Math.abs(this.so[2]) / ((float) Math.sqrt((fArr2[0] * fArr2[0]) + (fArr2[1] * fArr2[1])))) / 3.141592653589793d) * 180.0d));
    }

    public boolean a(SensorManager sensorManager, i iVar, g gVar) {
        if (iVar == null) {
            return false;
        }
        this.rO = iVar;
        this.si = gVar;
        if (iVar.eW() == b.RELATIVE && !this.rO.eY()) {
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
            String str = TAG;
            com.baidu.ar.h.b.b(str, "IMUController start: " + th.getMessage());
            return false;
        }
    }

    public void stop() {
        i iVar;
        if (this.sh != null && (iVar = this.rO) != null && iVar.eW() == b.RELATIVE && !this.sn && this.rO.eY()) {
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
            if (this.rO != null && this.si != null) {
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
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
