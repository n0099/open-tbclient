package com.baidu.ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import com.baidu.ar.arplay.representation.Quaternion;
/* loaded from: classes10.dex */
public class a extends j {
    private static final String TAG = a.class.getSimpleName();
    private final Quaternion rA;
    private int rB;
    private double rC;
    private long timestamp;

    public a(SensorManager sensorManager) {
        super(sensorManager);
        this.rA = new Quaternion();
        this.rB = 0;
        this.rC = 0.0d;
        com.baidu.ar.h.b.c(TAG, "sensorList size " + String.valueOf(this.sz.size()));
        if (this.sz.size() > 120) {
            this.sz.clear();
        }
        this.sz.add(sensorManager.getDefaultSensor(4));
    }

    private void eQ() {
        if (this.sD) {
            a(this.sG.matrix, this.sA.matrix, this.sE.matrix);
            return;
        }
        System.arraycopy(this.sA.matrix, 0, this.sE.matrix, 0, this.sE.matrix.length);
        Matrix.setIdentityM(this.sG.matrix, 0);
        this.sD = true;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 4) {
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
                }
                double d = (this.rC * f) / 2.0d;
                double sin = Math.sin(d);
                double cos = Math.cos(d);
                this.rA.setX((float) (f2 * sin));
                this.rA.setY((float) (f3 * sin));
                this.rA.setZ((float) (f4 * sin));
                this.rA.setW(-((float) cos));
                synchronized (this.sy) {
                    this.rA.multiplyByQuat(this.sB, this.sB);
                }
                Quaternion m16clone = this.sB.m16clone();
                m16clone.w(-m16clone.w());
                synchronized (this.sy) {
                    SensorManager.getRotationMatrixFromVector(this.sA.matrix, m16clone.toArray());
                }
            }
            this.timestamp = sensorEvent.timestamp;
            this.rB++;
            if (this.rB > 20) {
                eQ();
                setChanged();
                notifyObservers();
            }
        }
    }
}
