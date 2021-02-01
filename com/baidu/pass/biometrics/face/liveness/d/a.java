package com.baidu.pass.biometrics.face.liveness.d;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.face.liveness.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class a implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b.a f4044a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f4045b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, b.a aVar) {
        this.f4045b = bVar;
        this.f4044a = aVar;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        Log.w(b.f4046a, "onAccuracyChanged" + i);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f;
        Log.w(b.f4046a, "onSensorChanged() time:" + System.currentTimeMillis());
        float[] fArr = sensorEvent.values;
        if (fArr != null && fArr.length > 0) {
            this.f4045b.h = fArr[0];
            String str = b.f4046a;
            StringBuilder append = new StringBuilder().append("onSensorChanged() event.values[0]:");
            f = this.f4045b.h;
            Log.w(str, append.append(f).toString());
        }
        this.f4045b.g = System.currentTimeMillis();
        b.a aVar = this.f4044a;
        if (aVar != null) {
            aVar.a(this.f4045b.a());
        }
    }
}
