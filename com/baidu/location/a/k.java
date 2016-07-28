package com.baidu.location.a;

import android.hardware.Sensor;
import android.hardware.SensorManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ f GR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.GR = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        SensorManager sensorManager3;
        f fVar;
        sensorManager = this.GR.GB;
        if (sensorManager != null) {
            sensorManager2 = this.GR.GB;
            Sensor defaultSensor = sensorManager2.getDefaultSensor(6);
            sensorManager3 = this.GR.GB;
            fVar = f.GC;
            sensorManager3.unregisterListener(fVar, defaultSensor);
        }
    }
}
