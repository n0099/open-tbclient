package com.baidu.ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import com.baidu.ar.arplay.representation.Quaternion;
/* loaded from: classes3.dex */
public class a extends j {
    private static final String TAG = a.class.getSimpleName();
    private final Quaternion qf;
    private int qg;
    private double qh;
    private long timestamp;

    public a(SensorManager sensorManager) {
        super(sensorManager);
        this.qf = new Quaternion();
        this.qg = 0;
        this.qh = 0.0d;
        com.baidu.ar.f.b.c(TAG, "sensorList size " + String.valueOf(this.rf.size()));
        if (this.rf.size() > 120) {
            this.rf.clear();
        }
        this.rf.add(sensorManager.getDefaultSensor(4));
    }

    private void dr() {
        if (this.rj) {
            a(this.rm.matrix, this.rg.matrix, this.rk.matrix);
            return;
        }
        System.arraycopy(this.rg.matrix, 0, this.rk.matrix, 0, this.rk.matrix.length);
        Matrix.setIdentityM(this.rm.matrix, 0);
        this.rj = true;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 4) {
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
                }
                double d = (this.qh * f) / 2.0d;
                double sin = Math.sin(d);
                double cos = Math.cos(d);
                this.qf.setX((float) (f2 * sin));
                this.qf.setY((float) (f3 * sin));
                this.qf.setZ((float) (f4 * sin));
                this.qf.setW(-((float) cos));
                synchronized (this.re) {
                    this.qf.multiplyByQuat(this.rh, this.rh);
                }
                Quaternion m18clone = this.rh.m18clone();
                m18clone.w(-m18clone.w());
                synchronized (this.re) {
                    SensorManager.getRotationMatrixFromVector(this.rg.matrix, m18clone.toArray());
                }
            }
            this.timestamp = sensorEvent.timestamp;
            this.qg++;
            if (this.qg > 20) {
                dr();
                setChanged();
                notifyObservers();
            }
        }
    }
}
