package com.baidu.pass.biometrics.face.liveness.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.pass.biometrics.base.debug.Log;
/* loaded from: classes3.dex */
public class b {
    public static final String g = "b";
    public static long h = 1000;
    public Context a;
    public SensorManager b;
    public Sensor c;
    public SensorEventListener d;
    public long e = 0;
    public float f = 2.1474836E9f;

    /* renamed from: com.baidu.pass.biometrics.face.liveness.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0121b {
        void a(float f);
    }

    /* loaded from: classes3.dex */
    public class a implements SensorEventListener {
        public final /* synthetic */ InterfaceC0121b a;

        public a(InterfaceC0121b interfaceC0121b) {
            this.a = interfaceC0121b;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            String str = b.g;
            Log.w(str, "onAccuracyChanged" + i);
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            String str = b.g;
            Log.w(str, "onSensorChanged() time:" + System.currentTimeMillis());
            float[] fArr = sensorEvent.values;
            if (fArr != null && fArr.length > 0) {
                b.this.f = fArr[0];
                String str2 = b.g;
                Log.w(str2, "onSensorChanged() event.values[0]:" + b.this.f);
            }
            b.this.e = System.currentTimeMillis();
            InterfaceC0121b interfaceC0121b = this.a;
            if (interfaceC0121b != null) {
                interfaceC0121b.a(b.this.a());
            }
        }
    }

    public b(Context context) {
        this.a = context;
    }

    public float a() {
        if (this.e != 0 && System.currentTimeMillis() - this.e > h) {
            this.f = 0.0f;
        }
        return this.f;
    }

    @TargetApi(3)
    public void b() {
        Log.w(g, "unRegisterSensorListener()");
        SensorManager sensorManager = this.b;
        if (sensorManager != null && this.c != null) {
            sensorManager.unregisterListener(this.d);
        }
    }

    @TargetApi(3)
    public void a(InterfaceC0121b interfaceC0121b) {
        SensorManager sensorManager = (SensorManager) this.a.getSystemService("sensor");
        this.b = sensorManager;
        if (sensorManager == null) {
            Log.w(g, "sensorManager|senserManager == null");
            return;
        }
        Sensor defaultSensor = sensorManager.getDefaultSensor(5);
        this.c = defaultSensor;
        if (defaultSensor == null) {
            return;
        }
        a aVar = new a(interfaceC0121b);
        this.d = aVar;
        this.b.registerListener(aVar, this.c, 3);
    }
}
