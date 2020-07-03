package com.baidu.ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
/* loaded from: classes3.dex */
public class k extends d {
    private float[] rM;
    private float[] rN;

    public k(SensorManager sensorManager) {
        super(sensorManager);
        this.rM = new float[3];
        this.rN = new float[3];
        this.rE.add(sensorManager.getDefaultSensor(9));
        this.rE.add(sensorManager.getDefaultSensor(2));
        this.rE.add(sensorManager.getDefaultSensor(4));
        this.rE.add(sensorManager.getDefaultSensor(11));
    }

    @Override // com.baidu.ar.imu.d, android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 11 || sensorEvent.sensor.getType() == 4) {
            super.onSensorChanged(sensorEvent);
        } else if (sensorEvent.sensor.getType() == 2) {
            this.rM = (float[]) sensorEvent.values.clone();
        } else if (sensorEvent.sensor.getType() == 9) {
            this.rN = (float[]) sensorEvent.values.clone();
            this.ri = this.rN;
        }
        if (this.rM == null || this.rN == null) {
            return;
        }
        SensorManager.getRotationMatrix(this.rF.matrix, new float[16], this.rN, this.rM);
        this.rG.setRowMajor(this.rF.matrix);
    }
}
