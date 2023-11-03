package com.baidu.ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.baidu.ar.arplay.representation.Quaternion;
/* loaded from: classes.dex */
public class d extends j {
    public static final String TAG = d.class.getSimpleName();
    public final Quaternion rA;
    public int rB;
    public double rC;
    public Quaternion rJ;
    public Quaternion rK;
    public boolean rL;
    public int rM;
    public long timestamp;

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
        Quaternion m46clone = quaternion.m46clone();
        m46clone.w(-m46clone.w());
        synchronized (this.sy) {
            this.sB.copyVec4(quaternion);
            SensorManager.getRotationMatrixFromVector(this.sA.matrix, m46clone.toArray());
            eQ();
            int i = this.rB + 1;
            this.rB = i;
            if (i > 100) {
                setChanged();
            } else if (!eR()) {
                setChanged();
            }
            notifyObservers();
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

    public void eQ() {
        if (this.sD) {
            j.a(this.sF.matrix, this.sA.matrix, this.sE.matrix);
            j.b(this.sG.matrix, this.sF.matrix);
        } else if (j.a(this.sE.matrix, this.sA.matrix)) {
            this.sD = true;
            j.a(this.sF.matrix, this.sA.matrix, this.sE.matrix);
            j.b(this.sG.matrix, this.sF.matrix);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 11) {
            synchronized (this.sw) {
                for (int i = 0; i < sensorEvent.values.length; i++) {
                    if (Float.isNaN(sensorEvent.values[i])) {
                        this.sx = Boolean.FALSE;
                        return;
                    }
                }
                float[] fArr = new float[4];
                try {
                    SensorManager.getQuaternionFromVector(fArr, sensorEvent.values);
                } catch (Exception unused) {
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
                    long j = this.timestamp;
                    if (j != 0) {
                        float f = ((float) (sensorEvent.timestamp - j)) * 1.0E-9f;
                        float[] fArr2 = sensorEvent.values;
                        float f2 = fArr2[0];
                        float f3 = fArr2[1];
                        float f4 = fArr2[2];
                        double sqrt = Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
                        this.rC = sqrt;
                        if (sqrt > 0.10000000149011612d) {
                            f2 = (float) (f2 / sqrt);
                            f3 = (float) (f3 / sqrt);
                            f4 = (float) (f4 / sqrt);
                        } else {
                            this.rC = 0.0d;
                        }
                        double d = (this.rC * f) / 2.0d;
                        double sin = Math.sin(d);
                        double cos = Math.cos(d);
                        this.rA.setX((float) (f2 * sin));
                        this.rA.setY((float) (f3 * sin));
                        this.rA.setZ((float) (sin * f4));
                        this.rA.setW(-((float) cos));
                        Quaternion quaternion = this.rA;
                        Quaternion quaternion2 = this.rJ;
                        quaternion.multiplyByQuat(quaternion2, quaternion2);
                        float dotProduct = this.rJ.dotProduct(this.rK);
                        if (Math.abs(dotProduct) < 0.0f) {
                            if (Math.abs(dotProduct) < 0.0f) {
                                this.rM++;
                            }
                            a(this.rJ);
                        } else {
                            Quaternion quaternion3 = new Quaternion();
                            this.rJ.slerp(this.rK, quaternion3, (float) (this.rC * 0.009999999776482582d));
                            a(quaternion3);
                            this.rJ.copyVec4(quaternion3);
                            this.rM = 0;
                        }
                        if (this.rM > 60) {
                            com.baidu.ar.h.b.c(TAG, "Rotation VectorPanic counter is bigger than threshold; this indicates a Gyroscope failure. Panic reset is imminent.");
                            double d2 = this.rC;
                            if (d2 < 3.0d) {
                                com.baidu.ar.h.b.c(TAG, "Rotation VectorPerforming Panic-reset. Resetting orientation to rotation-vector value.");
                                a(this.rK);
                                this.rJ.copyVec4(this.rK);
                                this.rM = 0;
                            } else {
                                String format = String.format("Panic reset delayed due to ongoing motion (user is still shaking the device). Gyroscope Velocity: %.2f > 3", Double.valueOf(d2));
                                com.baidu.ar.h.b.c(TAG, "Rotation Vector" + format);
                            }
                        }
                    }
                    this.timestamp = sensorEvent.timestamp;
                }
            }
        }
    }
}
