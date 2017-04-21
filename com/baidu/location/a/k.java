package com.baidu.location.a;

import android.hardware.Sensor;
import android.hardware.SensorManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ f NI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.NI = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        SensorManager sensorManager3;
        f fVar;
        sensorManager = this.NI.Nr;
        if (sensorManager != null) {
            sensorManager2 = this.NI.Nr;
            Sensor defaultSensor = sensorManager2.getDefaultSensor(6);
            sensorManager3 = this.NI.Nr;
            fVar = f.Ns;
            sensorManager3.unregisterListener(fVar, defaultSensor);
        }
    }
}
