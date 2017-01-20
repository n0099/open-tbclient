package com.baidu.location.a;

import android.hardware.Sensor;
import android.hardware.SensorManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ f Im;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.Im = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        SensorManager sensorManager3;
        f fVar;
        sensorManager = this.Im.HW;
        if (sensorManager != null) {
            sensorManager2 = this.Im.HW;
            Sensor defaultSensor = sensorManager2.getDefaultSensor(6);
            sensorManager3 = this.Im.HW;
            fVar = f.HX;
            sensorManager3.unregisterListener(fVar, defaultSensor);
        }
    }
}
