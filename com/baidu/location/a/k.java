package com.baidu.location.a;

import android.hardware.Sensor;
import android.hardware.SensorManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ f Gx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.Gx = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        SensorManager sensorManager3;
        f fVar;
        sensorManager = this.Gx.Gg;
        if (sensorManager != null) {
            sensorManager2 = this.Gx.Gg;
            Sensor defaultSensor = sensorManager2.getDefaultSensor(6);
            sensorManager3 = this.Gx.Gg;
            fVar = f.Gh;
            sensorManager3.unregisterListener(fVar, defaultSensor);
        }
    }
}
