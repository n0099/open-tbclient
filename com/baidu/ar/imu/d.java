package com.baidu.ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.baidu.ar.arplay.representation.Quaternion;
/* loaded from: classes11.dex */
public class d extends j {
    private static final String TAG = d.class.getSimpleName();
    private final Quaternion rj;
    private int rk;
    private double rl;
    private Quaternion rs;
    private Quaternion rt;
    private boolean ru;
    private int rv;
    private long timestamp;

    public d(SensorManager sensorManager) {
        super(sensorManager);
        this.rj = new Quaternion();
        this.rs = new Quaternion();
        this.rt = new Quaternion();
        this.rl = 0.0d;
        this.ru = false;
        this.rk = 0;
        this.si.add(sensorManager.getDefaultSensor(4));
        this.si.add(sensorManager.getDefaultSensor(11));
    }

    private void a(Quaternion quaternion) {
        Quaternion m18clone = quaternion.m18clone();
        m18clone.w(-m18clone.w());
        synchronized (this.sh) {
            this.sk.copyVec4(quaternion);
            SensorManager.getRotationMatrixFromVector(this.sj.matrix, m18clone.toArray());
            eR();
            this.rk++;
            if (this.rk > 100) {
                setChanged();
                notifyObservers();
            } else if (!eS()) {
                setChanged();
                notifyObservers();
            }
        }
    }

    private boolean eS() {
        return ((double) Math.abs(1.0f - this.sp.matrix[0])) < 0.001d && ((double) Math.abs(1.0f - this.sp.matrix[5])) < 0.001d && ((double) Math.abs(1.0f - this.sp.matrix[10])) < 0.001d && ((double) Math.abs(1.0f - this.sp.matrix[15])) < 0.001d;
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

    protected void eR() {
        if (this.sm) {
            a(this.so.matrix, this.sj.matrix, this.sn.matrix);
            b(this.sp.matrix, this.so.matrix);
        } else if (a(this.sn.matrix, this.sj.matrix)) {
            this.sm = true;
            a(this.so.matrix, this.sj.matrix, this.sn.matrix);
            b(this.sp.matrix, this.so.matrix);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 11) {
            synchronized (this.sf) {
                for (int i = 0; i < sensorEvent.values.length; i++) {
                    if (Float.isNaN(sensorEvent.values[i])) {
                        this.sg = false;
                        return;
                    }
                }
                float[] fArr = new float[4];
                try {
                    SensorManager.getQuaternionFromVector(fArr, sensorEvent.values);
                } catch (Exception e) {
                    getQuaternionFromVector(fArr, sensorEvent.values);
                }
                this.rt.setXYZW(fArr[1], fArr[2], fArr[3], -fArr[0]);
                if (this.ru) {
                    return;
                }
                this.rs.set(this.rt);
                this.ru = true;
            }
        } else if (sensorEvent.sensor.getType() == 4) {
            synchronized (this.sf) {
                if (this.sg.booleanValue()) {
                    if (this.timestamp != 0) {
                        float f = ((float) (sensorEvent.timestamp - this.timestamp)) * 1.0E-9f;
                        float f2 = sensorEvent.values[0];
                        float f3 = sensorEvent.values[1];
                        float f4 = sensorEvent.values[2];
                        this.rl = Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
                        if (this.rl > 0.10000000149011612d) {
                            f2 = (float) (f2 / this.rl);
                            f3 = (float) (f3 / this.rl);
                            f4 = (float) (f4 / this.rl);
                        } else {
                            this.rl = 0.0d;
                        }
                        double d = (f * this.rl) / 2.0d;
                        double sin = Math.sin(d);
                        double cos = Math.cos(d);
                        this.rj.setX((float) (f2 * sin));
                        this.rj.setY((float) (f3 * sin));
                        this.rj.setZ((float) (sin * f4));
                        this.rj.setW(-((float) cos));
                        this.rj.multiplyByQuat(this.rs, this.rs);
                        float dotProduct = this.rs.dotProduct(this.rt);
                        if (Math.abs(dotProduct) < 0.0f) {
                            if (Math.abs(dotProduct) < 0.0f) {
                                this.rv++;
                            }
                            a(this.rs);
                        } else {
                            Quaternion quaternion = new Quaternion();
                            this.rs.slerp(this.rt, quaternion, (float) (0.009999999776482582d * this.rl));
                            a(quaternion);
                            this.rs.copyVec4(quaternion);
                            this.rv = 0;
                        }
                        if (this.rv > 60) {
                            com.baidu.ar.g.b.c(TAG, "Rotation VectorPanic counter is bigger than threshold; this indicates a Gyroscope failure. Panic reset is imminent.");
                            if (this.rl < 3.0d) {
                                com.baidu.ar.g.b.c(TAG, "Rotation VectorPerforming Panic-reset. Resetting orientation to rotation-vector value.");
                                a(this.rt);
                                this.rs.copyVec4(this.rt);
                                this.rv = 0;
                            } else {
                                com.baidu.ar.g.b.c(TAG, "Rotation Vector" + String.format("Panic reset delayed due to ongoing motion (user is still shaking the device). Gyroscope Velocity: %.2f > 3", Double.valueOf(this.rl)));
                            }
                        }
                    }
                    this.timestamp = sensorEvent.timestamp;
                }
            }
        }
    }
}
