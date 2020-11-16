package com.baidu.ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import com.baidu.ar.arplay.representation.Quaternion;
/* loaded from: classes12.dex */
public class a extends j {
    private static final String TAG = a.class.getSimpleName();
    private final Quaternion rj;
    private int rk;
    private double rl;
    private long timestamp;

    public a(SensorManager sensorManager) {
        super(sensorManager);
        this.rj = new Quaternion();
        this.rk = 0;
        this.rl = 0.0d;
        com.baidu.ar.g.b.c(TAG, "sensorList size " + String.valueOf(this.si.size()));
        if (this.si.size() > 120) {
            this.si.clear();
        }
        this.si.add(sensorManager.getDefaultSensor(4));
    }

    private void eR() {
        if (this.sm) {
            a(this.sp.matrix, this.sj.matrix, this.sn.matrix);
            return;
        }
        System.arraycopy(this.sj.matrix, 0, this.sn.matrix, 0, this.sn.matrix.length);
        Matrix.setIdentityM(this.sp.matrix, 0);
        this.sm = true;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 4) {
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
                }
                double d = (this.rl * f) / 2.0d;
                double sin = Math.sin(d);
                double cos = Math.cos(d);
                this.rj.setX((float) (f2 * sin));
                this.rj.setY((float) (f3 * sin));
                this.rj.setZ((float) (f4 * sin));
                this.rj.setW(-((float) cos));
                synchronized (this.sh) {
                    this.rj.multiplyByQuat(this.sk, this.sk);
                }
                Quaternion m17clone = this.sk.m17clone();
                m17clone.w(-m17clone.w());
                synchronized (this.sh) {
                    SensorManager.getRotationMatrixFromVector(this.sj.matrix, m17clone.toArray());
                }
            }
            this.timestamp = sensorEvent.timestamp;
            this.rk++;
            if (this.rk > 20) {
                eR();
                setChanged();
                notifyObservers();
            }
        }
    }
}
