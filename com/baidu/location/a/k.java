package com.baidu.location.a;

import android.hardware.Sensor;
import android.hardware.SensorManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ f LX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.LX = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        SensorManager sensorManager3;
        f fVar;
        sensorManager = this.LX.LG;
        if (sensorManager != null) {
            sensorManager2 = this.LX.LG;
            Sensor defaultSensor = sensorManager2.getDefaultSensor(6);
            sensorManager3 = this.LX.LG;
            fVar = f.LH;
            sensorManager3.unregisterListener(fVar, defaultSensor);
        }
    }
}
