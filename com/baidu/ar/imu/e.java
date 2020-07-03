package com.baidu.ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import com.baidu.ar.arplay.representation.Quaternion;
/* loaded from: classes3.dex */
public class e extends j {
    private static final String TAG = e.class.getSimpleName();
    private final Quaternion qE;
    private int qF;
    private double qG;
    private Quaternion qN;
    private Quaternion qO;
    private boolean qP;
    private int qQ;
    private long timestamp;

    public e(SensorManager sensorManager) {
        super(sensorManager);
        this.qE = new Quaternion();
        this.qN = new Quaternion();
        this.qO = new Quaternion();
        this.qG = 0.0d;
        this.qP = false;
        this.qF = 0;
        this.rE.add(sensorManager.getDefaultSensor(4));
        this.rE.add(sensorManager.getDefaultSensor(11));
    }

    private void a(Quaternion quaternion) {
        Quaternion m17clone = quaternion.m17clone();
        m17clone.w(-m17clone.w());
        synchronized (this.rD) {
            this.rG.copyVec4(quaternion);
            SensorManager.getRotationMatrixFromVector(this.rF.matrix, m17clone.toArray());
            this.qF++;
            if (this.qF > 20) {
                dH();
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

    protected void dH() {
        if (this.rI) {
            a(this.rL.matrix, this.rF.matrix, this.rJ.matrix);
            return;
        }
        this.rI = true;
        System.arraycopy(this.rF.matrix, 0, this.rJ.matrix, 0, this.rF.matrix.length);
        Matrix.setIdentityM(this.rL.matrix, 0);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 11) {
            synchronized (this.rB) {
                for (int i = 0; i < sensorEvent.values.length; i++) {
                    if (Float.isNaN(sensorEvent.values[i])) {
                        this.rC = false;
                        return;
                    }
                }
                float[] fArr = new float[4];
                try {
                    SensorManager.getQuaternionFromVector(fArr, sensorEvent.values);
                } catch (Exception e) {
                    getQuaternionFromVector(fArr, sensorEvent.values);
                }
                this.qO.setXYZW(fArr[1], fArr[2], fArr[3], -fArr[0]);
                if (this.qP) {
                    return;
                }
                this.qN.set(this.qO);
                this.qP = true;
            }
        } else if (sensorEvent.sensor.getType() == 4) {
            synchronized (this.rB) {
                if (this.rC.booleanValue()) {
                    if (this.timestamp != 0) {
                        float f = ((float) (sensorEvent.timestamp - this.timestamp)) * 1.0E-9f;
                        float f2 = sensorEvent.values[0];
                        float f3 = sensorEvent.values[1];
                        float f4 = sensorEvent.values[2];
                        this.qG = Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
                        if (this.qG > 0.10000000149011612d) {
                            f2 = (float) (f2 / this.qG);
                            f3 = (float) (f3 / this.qG);
                            f4 = (float) (f4 / this.qG);
                        } else {
                            this.qG = 0.0d;
                        }
                        double d = (f * this.qG) / 2.0d;
                        double sin = Math.sin(d);
                        double cos = Math.cos(d);
                        this.qE.setX((float) (f2 * sin));
                        this.qE.setY((float) (f3 * sin));
                        this.qE.setZ((float) (sin * f4));
                        this.qE.setW(-((float) cos));
                        this.qE.multiplyByQuat(this.qN, this.qN);
                        float dotProduct = this.qN.dotProduct(this.qO);
                        if (Math.abs(dotProduct) < 0.0f) {
                            if (Math.abs(dotProduct) < 0.0f) {
                                this.qQ++;
                            }
                            a(this.qN);
                        } else {
                            Quaternion quaternion = new Quaternion();
                            this.qN.slerp(this.qO, quaternion, (float) (0.009999999776482582d * this.qG));
                            a(quaternion);
                            this.qN.copyVec4(quaternion);
                            this.qQ = 0;
                        }
                        if (this.qQ > 60) {
                            com.baidu.ar.f.b.c(TAG, "Rotation VectorPanic counter is bigger than threshold; this indicates a Gyroscope failure. Panic reset is imminent.");
                            if (this.qG < 3.0d) {
                                com.baidu.ar.f.b.c(TAG, "Rotation VectorPerforming Panic-reset. Resetting orientation to rotation-vector value.");
                                a(this.qO);
                                this.qN.copyVec4(this.qO);
                                this.qQ = 0;
                            } else {
                                com.baidu.ar.f.b.c(TAG, "Rotation Vector" + String.format("Panic reset delayed due to ongoing motion (user is still shaking the device). Gyroscope Velocity: %.2f > 3", Double.valueOf(this.qG)));
                            }
                        }
                    }
                    this.timestamp = sensorEvent.timestamp;
                }
            }
        }
    }
}
