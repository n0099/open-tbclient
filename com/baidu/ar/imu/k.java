package com.baidu.ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
/* loaded from: classes11.dex */
public class k extends d {
    private float[] sq;
    private float[] sr;

    public k(SensorManager sensorManager) {
        super(sensorManager);
        this.sq = new float[3];
        this.sr = new float[3];
        this.si.add(sensorManager.getDefaultSensor(9));
        this.si.add(sensorManager.getDefaultSensor(2));
        this.si.add(sensorManager.getDefaultSensor(4));
        this.si.add(sensorManager.getDefaultSensor(11));
    }

    @Override // com.baidu.ar.imu.d, android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 11 || sensorEvent.sensor.getType() == 4) {
            super.onSensorChanged(sensorEvent);
        } else if (sensorEvent.sensor.getType() == 2) {
            this.sq = (float[]) sensorEvent.values.clone();
        } else if (sensorEvent.sensor.getType() == 9) {
            this.sr = (float[]) sensorEvent.values.clone();
            this.rN = this.sr;
        }
        if (this.sq == null || this.sr == null) {
            return;
        }
        SensorManager.getRotationMatrix(this.sj.matrix, new float[16], this.sr, this.sq);
        this.sk.setRowMajor(this.sj.matrix);
    }
}
