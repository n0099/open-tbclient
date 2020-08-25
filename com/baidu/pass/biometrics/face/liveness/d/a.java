package com.baidu.pass.biometrics.face.liveness.d;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.face.liveness.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class a implements SensorEventListener {
    final /* synthetic */ b.a a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, b.a aVar) {
        this.b = bVar;
        this.a = aVar;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        Log.w(b.a, "onAccuracyChanged" + i);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f;
        Log.w(b.a, "onSensorChanged() time:" + System.currentTimeMillis());
        float[] fArr = sensorEvent.values;
        if (fArr != null && fArr.length > 0) {
            this.b.h = fArr[0];
            String str = b.a;
            StringBuilder append = new StringBuilder().append("onSensorChanged() event.values[0]:");
            f = this.b.h;
            Log.w(str, append.append(f).toString());
        }
        this.b.g = System.currentTimeMillis();
        b.a aVar = this.a;
        if (aVar != null) {
            aVar.a(this.b.a());
        }
    }
}
