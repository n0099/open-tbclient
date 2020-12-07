package com.baidu.ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
/* loaded from: classes10.dex */
public class k extends d {
    private float[] sH;
    private float[] sI;

    public k(SensorManager sensorManager) {
        super(sensorManager);
        this.sH = new float[3];
        this.sI = new float[3];
        this.sz.add(sensorManager.getDefaultSensor(9));
        this.sz.add(sensorManager.getDefaultSensor(2));
        this.sz.add(sensorManager.getDefaultSensor(4));
        this.sz.add(sensorManager.getDefaultSensor(11));
    }

    @Override // com.baidu.ar.imu.d, android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 11 || sensorEvent.sensor.getType() == 4) {
            super.onSensorChanged(sensorEvent);
        } else if (sensorEvent.sensor.getType() == 2) {
            this.sH = (float[]) sensorEvent.values.clone();
        } else if (sensorEvent.sensor.getType() == 9) {
            this.sI = (float[]) sensorEvent.values.clone();
            this.se = this.sI;
        }
        if (this.sH == null || this.sI == null) {
            return;
        }
        SensorManager.getRotationMatrix(this.sA.matrix, new float[16], this.sI, this.sH);
        this.sB.setRowMajor(this.sA.matrix);
    }
}
