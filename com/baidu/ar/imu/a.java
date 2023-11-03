package com.baidu.ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import com.baidu.ar.arplay.representation.Quaternion;
/* loaded from: classes.dex */
public class a extends j {
    public static final String TAG = a.class.getSimpleName();
    public final Quaternion rA;
    public int rB;
    public double rC;
    public long timestamp;

    public a(SensorManager sensorManager) {
        super(sensorManager);
        this.rA = new Quaternion();
        this.rB = 0;
        this.rC = 0.0d;
        String str = TAG;
        com.baidu.ar.h.b.c(str, "sensorList size " + String.valueOf(this.sz.size()));
        if (this.sz.size() > 120) {
            this.sz.clear();
        }
        this.sz.add(sensorManager.getDefaultSensor(4));
    }

    private void eQ() {
        if (this.sD) {
            j.a(this.sG.matrix, this.sA.matrix, this.sE.matrix);
            return;
        }
        float[] fArr = this.sA.matrix;
        float[] fArr2 = this.sE.matrix;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.setIdentityM(this.sG.matrix, 0);
        this.sD = true;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 4) {
            long j = this.timestamp;
            if (j != 0) {
                float f = ((float) (sensorEvent.timestamp - j)) * 1.0E-9f;
                float[] fArr = sensorEvent.values;
                float f2 = fArr[0];
                float f3 = fArr[1];
                float f4 = fArr[2];
                double sqrt = Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4));
                this.rC = sqrt;
                if (sqrt > 0.10000000149011612d) {
                    f2 = (float) (f2 / sqrt);
                    f3 = (float) (f3 / sqrt);
                    f4 = (float) (f4 / sqrt);
                }
                double d = (this.rC * f) / 2.0d;
                double sin = Math.sin(d);
                double cos = Math.cos(d);
                this.rA.setX((float) (f2 * sin));
                this.rA.setY((float) (f3 * sin));
                this.rA.setZ((float) (sin * f4));
                this.rA.setW(-((float) cos));
                synchronized (this.sy) {
                    this.rA.multiplyByQuat(this.sB, this.sB);
                }
                Quaternion m46clone = this.sB.m46clone();
                m46clone.w(-m46clone.w());
                synchronized (this.sy) {
                    SensorManager.getRotationMatrixFromVector(this.sA.matrix, m46clone.toArray());
                }
            }
            this.timestamp = sensorEvent.timestamp;
            int i = this.rB + 1;
            this.rB = i;
            if (i > 20) {
                eQ();
                setChanged();
                notifyObservers();
            }
        }
    }
}
