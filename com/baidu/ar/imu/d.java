package com.baidu.ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.baidu.ar.arplay.representation.Quaternion;
/* loaded from: classes6.dex */
public class d extends j {
    private static final String TAG = d.class.getSimpleName();
    private final Quaternion rA;
    private int rB;
    private double rC;
    private Quaternion rJ;
    private Quaternion rK;
    private boolean rL;
    private int rM;
    private long timestamp;

    public d(SensorManager sensorManager) {
        super(sensorManager);
        this.rA = new Quaternion();
        this.rJ = new Quaternion();
        this.rK = new Quaternion();
        this.rC = 0.0d;
        this.rL = false;
        this.rB = 0;
        this.sz.add(sensorManager.getDefaultSensor(4));
        this.sz.add(sensorManager.getDefaultSensor(11));
    }

    private void a(Quaternion quaternion) {
        Quaternion m16clone = quaternion.m16clone();
        m16clone.w(-m16clone.w());
        synchronized (this.sy) {
            this.sB.copyVec4(quaternion);
            SensorManager.getRotationMatrixFromVector(this.sA.matrix, m16clone.toArray());
            eQ();
            this.rB++;
            if (this.rB > 100) {
                setChanged();
                notifyObservers();
            } else if (!eR()) {
                setChanged();
                notifyObservers();
            }
        }
    }

    private boolean eR() {
        return ((double) Math.abs(1.0f - this.sG.matrix[0])) < 0.001d && ((double) Math.abs(1.0f - this.sG.matrix[5])) < 0.001d && ((double) Math.abs(1.0f - this.sG.matrix[10])) < 0.001d && ((double) Math.abs(1.0f - this.sG.matrix[15])) < 0.001d;
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

    protected void eQ() {
        if (this.sD) {
            a(this.sF.matrix, this.sA.matrix, this.sE.matrix);
            b(this.sG.matrix, this.sF.matrix);
        } else if (a(this.sE.matrix, this.sA.matrix)) {
            this.sD = true;
            a(this.sF.matrix, this.sA.matrix, this.sE.matrix);
            b(this.sG.matrix, this.sF.matrix);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 11) {
            synchronized (this.sw) {
                for (int i = 0; i < sensorEvent.values.length; i++) {
                    if (Float.isNaN(sensorEvent.values[i])) {
                        this.sx = false;
                        return;
                    }
                }
                float[] fArr = new float[4];
                try {
                    SensorManager.getQuaternionFromVector(fArr, sensorEvent.values);
                } catch (Exception e) {
                    getQuaternionFromVector(fArr, sensorEvent.values);
                }
                this.rK.setXYZW(fArr[1], fArr[2], fArr[3], -fArr[0]);
                if (this.rL) {
                    return;
                }
                this.rJ.set(this.rK);
                this.rL = true;
            }
        } else if (sensorEvent.sensor.getType() == 4) {
            synchronized (this.sw) {
                if (this.sx.booleanValue()) {
                    if (this.timestamp != 0) {
                        float f = ((float) (sensorEvent.timestamp - this.timestamp)) * 1.0E-9f;
                        float f2 = sensorEvent.values[0];
                        float f3 = sensorEvent.values[1];
                        float f4 = sensorEvent.values[2];
                        this.rC = Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
                        if (this.rC > 0.10000000149011612d) {
                            f2 = (float) (f2 / this.rC);
                            f3 = (float) (f3 / this.rC);
                            f4 = (float) (f4 / this.rC);
                        } else {
                            this.rC = 0.0d;
                        }
                        double d = (f * this.rC) / 2.0d;
                        double sin = Math.sin(d);
                        double cos = Math.cos(d);
                        this.rA.setX((float) (f2 * sin));
                        this.rA.setY((float) (f3 * sin));
                        this.rA.setZ((float) (sin * f4));
                        this.rA.setW(-((float) cos));
                        this.rA.multiplyByQuat(this.rJ, this.rJ);
                        float dotProduct = this.rJ.dotProduct(this.rK);
                        if (Math.abs(dotProduct) < 0.0f) {
                            if (Math.abs(dotProduct) < 0.0f) {
                                this.rM++;
                            }
                            a(this.rJ);
                        } else {
                            Quaternion quaternion = new Quaternion();
                            this.rJ.slerp(this.rK, quaternion, (float) (0.009999999776482582d * this.rC));
                            a(quaternion);
                            this.rJ.copyVec4(quaternion);
                            this.rM = 0;
                        }
                        if (this.rM > 60) {
                            com.baidu.ar.h.b.c(TAG, "Rotation VectorPanic counter is bigger than threshold; this indicates a Gyroscope failure. Panic reset is imminent.");
                            if (this.rC < 3.0d) {
                                com.baidu.ar.h.b.c(TAG, "Rotation VectorPerforming Panic-reset. Resetting orientation to rotation-vector value.");
                                a(this.rK);
                                this.rJ.copyVec4(this.rK);
                                this.rM = 0;
                            } else {
                                com.baidu.ar.h.b.c(TAG, "Rotation Vector" + String.format("Panic reset delayed due to ongoing motion (user is still shaking the device). Gyroscope Velocity: %.2f > 3", Double.valueOf(this.rC)));
                            }
                        }
                    }
                    this.timestamp = sensorEvent.timestamp;
                }
            }
        }
    }
}
