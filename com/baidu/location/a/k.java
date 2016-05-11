package com.baidu.location.a;

import android.hardware.Sensor;
import android.hardware.SensorManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ f GB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.GB = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        SensorManager sensorManager3;
        f fVar;
        sensorManager = this.GB.Gj;
        if (sensorManager != null) {
            sensorManager2 = this.GB.Gj;
            Sensor defaultSensor = sensorManager2.getDefaultSensor(6);
            sensorManager3 = this.GB.Gj;
            fVar = f.Gk;
            sensorManager3.unregisterListener(fVar, defaultSensor);
        }
    }
}
