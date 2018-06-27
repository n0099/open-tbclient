package com.baidu.location.a;

import android.hardware.Sensor;
import android.hardware.SensorManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k implements Runnable {
    final /* synthetic */ f Ws;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.Ws = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        SensorManager sensorManager3;
        f fVar;
        sensorManager = this.Ws.We;
        if (sensorManager != null) {
            sensorManager2 = this.Ws.We;
            Sensor defaultSensor = sensorManager2.getDefaultSensor(6);
            sensorManager3 = this.Ws.We;
            fVar = f.Wf;
            sensorManager3.unregisterListener(fVar, defaultSensor);
        }
    }
}
