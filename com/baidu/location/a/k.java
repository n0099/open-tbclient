package com.baidu.location.a;

import android.hardware.Sensor;
import android.hardware.SensorManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ f MO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.MO = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        SensorManager sensorManager3;
        f fVar;
        sensorManager = this.MO.Mx;
        if (sensorManager != null) {
            sensorManager2 = this.MO.Mx;
            Sensor defaultSensor = sensorManager2.getDefaultSensor(6);
            sensorManager3 = this.MO.Mx;
            fVar = f.My;
            sensorManager3.unregisterListener(fVar, defaultSensor);
        }
    }
}
