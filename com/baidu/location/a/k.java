package com.baidu.location.a;

import android.hardware.Sensor;
import android.hardware.SensorManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ f On;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.On = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        SensorManager sensorManager3;
        f fVar;
        sensorManager = this.On.NY;
        if (sensorManager != null) {
            sensorManager2 = this.On.NY;
            Sensor defaultSensor = sensorManager2.getDefaultSensor(6);
            sensorManager3 = this.On.NY;
            fVar = f.NZ;
            sensorManager3.unregisterListener(fVar, defaultSensor);
        }
    }
}
