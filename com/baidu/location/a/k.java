package com.baidu.location.a;

import android.hardware.Sensor;
import android.hardware.SensorManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ f Jg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.Jg = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        SensorManager sensorManager3;
        f fVar;
        sensorManager = this.Jg.IP;
        if (sensorManager != null) {
            sensorManager2 = this.Jg.IP;
            Sensor defaultSensor = sensorManager2.getDefaultSensor(6);
            sensorManager3 = this.Jg.IP;
            fVar = f.IQ;
            sensorManager3.unregisterListener(fVar, defaultSensor);
        }
    }
}
