package com.baidu.ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import com.baidu.ar.arplay.representation.Quaternion;
/* loaded from: classes3.dex */
public class a extends j {
    private static final String TAG = a.class.getSimpleName();
    private final Quaternion qE;
    private int qF;
    private double qG;
    private long timestamp;

    public a(SensorManager sensorManager) {
        super(sensorManager);
        this.qE = new Quaternion();
        this.qF = 0;
        this.qG = 0.0d;
        com.baidu.ar.f.b.c(TAG, "sensorList size " + String.valueOf(this.rE.size()));
        if (this.rE.size() > 120) {
            this.rE.clear();
        }
        this.rE.add(sensorManager.getDefaultSensor(4));
    }

    private void dH() {
        if (this.rI) {
            a(this.rL.matrix, this.rF.matrix, this.rJ.matrix);
            return;
        }
        System.arraycopy(this.rF.matrix, 0, this.rJ.matrix, 0, this.rJ.matrix.length);
        Matrix.setIdentityM(this.rL.matrix, 0);
        this.rI = true;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 4) {
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
                }
                double d = (this.qG * f) / 2.0d;
                double sin = Math.sin(d);
                double cos = Math.cos(d);
                this.qE.setX((float) (f2 * sin));
                this.qE.setY((float) (f3 * sin));
                this.qE.setZ((float) (f4 * sin));
                this.qE.setW(-((float) cos));
                synchronized (this.rD) {
                    this.qE.multiplyByQuat(this.rG, this.rG);
                }
                Quaternion m17clone = this.rG.m17clone();
                m17clone.w(-m17clone.w());
                synchronized (this.rD) {
                    SensorManager.getRotationMatrixFromVector(this.rF.matrix, m17clone.toArray());
                }
            }
            this.timestamp = sensorEvent.timestamp;
            this.qF++;
            if (this.qF > 20) {
                dH();
                setChanged();
                notifyObservers();
            }
        }
    }
}
