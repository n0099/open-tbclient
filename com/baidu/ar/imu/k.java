package com.baidu.ar.imu;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
/* loaded from: classes.dex */
public class k extends d {
    public float[] sH;
    public float[] sI;

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
        float[] fArr;
        if (sensorEvent.sensor.getType() == 11 || sensorEvent.sensor.getType() == 4) {
            super.onSensorChanged(sensorEvent);
        } else if (sensorEvent.sensor.getType() == 2) {
            this.sH = (float[]) sensorEvent.values.clone();
        } else if (sensorEvent.sensor.getType() == 9) {
            float[] fArr2 = (float[]) sensorEvent.values.clone();
            this.sI = fArr2;
            this.se = fArr2;
        }
        float[] fArr3 = this.sH;
        if (fArr3 == null || (fArr = this.sI) == null) {
            return;
        }
        SensorManager.getRotationMatrix(this.sA.matrix, new float[16], fArr, fArr3);
        this.sB.setRowMajor(this.sA.matrix);
    }
}
