package com.baidu.pass.biometrics.face.liveness.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.pass.biometrics.base.debug.Log;
/* loaded from: classes4.dex */
public class b {
    public static final String a = "b";
    private static long b = 1000;
    private Context c;
    private SensorManager d;
    private Sensor e;
    private SensorEventListener f;
    private long g = 0;
    private float h = 2.1474836E9f;

    /* loaded from: classes4.dex */
    public interface a {
        void a(float f);
    }

    public b(Context context) {
        this.c = context;
    }

    @TargetApi(3)
    public void b() {
        Log.w(a, "unRegisterSensorListener()");
        SensorManager sensorManager = this.d;
        if (sensorManager == null || this.e == null) {
            return;
        }
        sensorManager.unregisterListener(this.f);
    }

    @TargetApi(3)
    public void a(a aVar) {
        this.d = (SensorManager) this.c.getSystemService("sensor");
        SensorManager sensorManager = this.d;
        if (sensorManager == null) {
            Log.w(a, "sensorManager|senserManager == null");
            return;
        }
        this.e = sensorManager.getDefaultSensor(5);
        if (this.e != null) {
            this.f = new com.baidu.pass.biometrics.face.liveness.d.a(this, aVar);
            this.d.registerListener(this.f, this.e, 3);
        }
    }

    public float a() {
        if (this.g != 0 && System.currentTimeMillis() - this.g > b) {
            this.h = 0.0f;
        }
        return this.h;
    }
}
