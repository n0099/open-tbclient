package com.baidu.location.a;

import android.hardware.Sensor;
import android.hardware.SensorManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ f aAE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.aAE = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        SensorManager sensorManager3;
        f fVar;
        sensorManager = this.aAE.aAn;
        if (sensorManager != null) {
            sensorManager2 = this.aAE.aAn;
            Sensor defaultSensor = sensorManager2.getDefaultSensor(6);
            sensorManager3 = this.aAE.aAn;
            fVar = f.aAo;
            sensorManager3.unregisterListener(fVar, defaultSensor);
        }
    }
}
