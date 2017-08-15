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
        sensorManager = this.On.NW;
        if (sensorManager != null) {
            sensorManager2 = this.On.NW;
            Sensor defaultSensor = sensorManager2.getDefaultSensor(6);
            sensorManager3 = this.On.NW;
            fVar = f.NX;
            sensorManager3.unregisterListener(fVar, defaultSensor);
        }
    }
}
