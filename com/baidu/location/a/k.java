package com.baidu.location.a;

import android.hardware.Sensor;
import android.hardware.SensorManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ f aAB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.aAB = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        SensorManager sensorManager3;
        f fVar;
        sensorManager = this.aAB.aAk;
        if (sensorManager != null) {
            sensorManager2 = this.aAB.aAk;
            Sensor defaultSensor = sensorManager2.getDefaultSensor(6);
            sensorManager3 = this.aAB.aAk;
            fVar = f.aAl;
            sensorManager3.unregisterListener(fVar, defaultSensor);
        }
    }
}
