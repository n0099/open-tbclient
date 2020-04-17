package com.baidu.ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
/* loaded from: classes3.dex */
public class k extends d {
    private float[] rn;
    private float[] ro;

    public k(SensorManager sensorManager) {
        super(sensorManager);
        this.rn = new float[3];
        this.ro = new float[3];
        this.rf.add(sensorManager.getDefaultSensor(9));
        this.rf.add(sensorManager.getDefaultSensor(2));
        this.rf.add(sensorManager.getDefaultSensor(4));
        this.rf.add(sensorManager.getDefaultSensor(11));
    }

    @Override // com.baidu.ar.imu.d, android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 11 || sensorEvent.sensor.getType() == 4) {
            super.onSensorChanged(sensorEvent);
        } else if (sensorEvent.sensor.getType() == 2) {
            this.rn = (float[]) sensorEvent.values.clone();
        } else if (sensorEvent.sensor.getType() == 9) {
            this.ro = (float[]) sensorEvent.values.clone();
            this.qJ = this.ro;
        }
        if (this.rn == null || this.ro == null) {
            return;
        }
        SensorManager.getRotationMatrix(this.rg.matrix, new float[16], this.ro, this.rn);
        this.rh.setRowMajor(this.rg.matrix);
    }
}
