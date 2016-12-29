package com.baidu.location.a;

import android.hardware.Sensor;
import android.hardware.SensorManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ f Jf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.Jf = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        SensorManager sensorManager3;
        f fVar;
        sensorManager = this.Jf.IO;
        if (sensorManager != null) {
            sensorManager2 = this.Jf.IO;
            Sensor defaultSensor = sensorManager2.getDefaultSensor(6);
            sensorManager3 = this.Jf.IO;
            fVar = f.IP;
            sensorManager3.unregisterListener(fVar, defaultSensor);
        }
    }
}
