package com.baidu.ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import com.baidu.ar.arplay.representation.Quaternion;
/* loaded from: classes3.dex */
public class e extends j {
    private static final String TAG = e.class.getSimpleName();
    private final Quaternion qf;
    private int qg;
    private double qh;
    private Quaternion qo;
    private Quaternion qp;
    private boolean qq;
    private int qr;
    private long timestamp;

    public e(SensorManager sensorManager) {
        super(sensorManager);
        this.qf = new Quaternion();
        this.qo = new Quaternion();
        this.qp = new Quaternion();
        this.qh = 0.0d;
        this.qq = false;
        this.qg = 0;
        this.rf.add(sensorManager.getDefaultSensor(4));
        this.rf.add(sensorManager.getDefaultSensor(11));
    }

    private void a(Quaternion quaternion) {
        Quaternion m18clone = quaternion.m18clone();
        m18clone.w(-m18clone.w());
        synchronized (this.re) {
            this.rh.copyVec4(quaternion);
            SensorManager.getRotationMatrixFromVector(this.rg.matrix, m18clone.toArray());
            this.qg++;
            if (this.qg > 20) {
                dr();
                setChanged();
                notifyObservers();
            }
        }
    }

    public static void getQuaternionFromVector(float[] fArr, float[] fArr2) {
        if (fArr2.length >= 4) {
            fArr[0] = fArr2[3];
        } else {
            fArr[0] = ((1.0f - (fArr2[0] * fArr2[0])) - (fArr2[1] * fArr2[1])) - (fArr2[2] * fArr2[2]);
            fArr[0] = fArr[0] > 0.0f ? (float) Math.sqrt(fArr[0]) : 0.0f;
        }
        fArr[1] = fArr2[0];
        fArr[2] = fArr2[1];
        fArr[3] = fArr2[2];
    }

    protected void dr() {
        if (this.rj) {
            a(this.rm.matrix, this.rg.matrix, this.rk.matrix);
            return;
        }
        this.rj = true;
        System.arraycopy(this.rg.matrix, 0, this.rk.matrix, 0, this.rg.matrix.length);
        Matrix.setIdentityM(this.rm.matrix, 0);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 11) {
            synchronized (this.rc) {
                for (int i = 0; i < sensorEvent.values.length; i++) {
                    if (Float.isNaN(sensorEvent.values[i])) {
                        this.rd = false;
                        return;
                    }
                }
                float[] fArr = new float[4];
                try {
                    SensorManager.getQuaternionFromVector(fArr, sensorEvent.values);
                } catch (Exception e) {
                    getQuaternionFromVector(fArr, sensorEvent.values);
                }
                this.qp.setXYZW(fArr[1], fArr[2], fArr[3], -fArr[0]);
                if (this.qq) {
                    return;
                }
                this.qo.set(this.qp);
                this.qq = true;
            }
        } else if (sensorEvent.sensor.getType() == 4) {
            synchronized (this.rc) {
                if (this.rd.booleanValue()) {
                    if (this.timestamp != 0) {
                        float f = ((float) (sensorEvent.timestamp - this.timestamp)) * 1.0E-9f;
                        float f2 = sensorEvent.values[0];
                        float f3 = sensorEvent.values[1];
                        float f4 = sensorEvent.values[2];
                        this.qh = Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
                        if (this.qh > 0.10000000149011612d) {
                            f2 = (float) (f2 / this.qh);
                            f3 = (float) (f3 / this.qh);
                            f4 = (float) (f4 / this.qh);
                        } else {
                            this.qh = 0.0d;
                        }
                        double d = (f * this.qh) / 2.0d;
                        double sin = Math.sin(d);
                        double cos = Math.cos(d);
                        this.qf.setX((float) (f2 * sin));
                        this.qf.setY((float) (f3 * sin));
                        this.qf.setZ((float) (sin * f4));
                        this.qf.setW(-((float) cos));
                        this.qf.multiplyByQuat(this.qo, this.qo);
                        float dotProduct = this.qo.dotProduct(this.qp);
                        if (Math.abs(dotProduct) < 0.0f) {
                            if (Math.abs(dotProduct) < 0.0f) {
                                this.qr++;
                            }
                            a(this.qo);
                        } else {
                            Quaternion quaternion = new Quaternion();
                            this.qo.slerp(this.qp, quaternion, (float) (0.009999999776482582d * this.qh));
                            a(quaternion);
                            this.qo.copyVec4(quaternion);
                            this.qr = 0;
                        }
                        if (this.qr > 60) {
                            com.baidu.ar.f.b.c(TAG, "Rotation VectorPanic counter is bigger than threshold; this indicates a Gyroscope failure. Panic reset is imminent.");
                            if (this.qh < 3.0d) {
                                com.baidu.ar.f.b.c(TAG, "Rotation VectorPerforming Panic-reset. Resetting orientation to rotation-vector value.");
                                a(this.qp);
                                this.qo.copyVec4(this.qp);
                                this.qr = 0;
                            } else {
                                com.baidu.ar.f.b.c(TAG, "Rotation Vector" + String.format("Panic reset delayed due to ongoing motion (user is still shaking the device). Gyroscope Velocity: %.2f > 3", Double.valueOf(this.qh)));
                            }
                        }
                    }
                    this.timestamp = sensorEvent.timestamp;
                }
            }
        }
    }
}
