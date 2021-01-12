package com.baidu.pass.biometrics.face.liveness.d;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.baidu.pass.biometrics.base.debug.Log;
import com.baidu.pass.biometrics.face.liveness.d.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class a implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b.a f4041a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f4042b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, b.a aVar) {
        this.f4042b = bVar;
        this.f4041a = aVar;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        Log.w(b.f4043a, "onAccuracyChanged" + i);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f;
        Log.w(b.f4043a, "onSensorChanged() time:" + System.currentTimeMillis());
        float[] fArr = sensorEvent.values;
        if (fArr != null && fArr.length > 0) {
            this.f4042b.h = fArr[0];
            String str = b.f4043a;
            StringBuilder append = new StringBuilder().append("onSensorChanged() event.values[0]:");
            f = this.f4042b.h;
            Log.w(str, append.append(f).toString());
        }
        this.f4042b.g = System.currentTimeMillis();
        b.a aVar = this.f4041a;
        if (aVar != null) {
            aVar.a(this.f4042b.a());
        }
    }
}
