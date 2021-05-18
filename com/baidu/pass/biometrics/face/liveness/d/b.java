package com.baidu.pass.biometrics.face.liveness.d;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.pass.biometrics.base.debug.Log;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final String f9191g = "b";

    /* renamed from: h  reason: collision with root package name */
    public static long f9192h = 1000;

    /* renamed from: a  reason: collision with root package name */
    public Context f9193a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f9194b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f9195c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f9196d;

    /* renamed from: e  reason: collision with root package name */
    public long f9197e = 0;

    /* renamed from: f  reason: collision with root package name */
    public float f9198f = 2.1474836E9f;

    /* loaded from: classes2.dex */
    public class a implements SensorEventListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0114b f9199a;

        public a(InterfaceC0114b interfaceC0114b) {
            this.f9199a = interfaceC0114b;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
            String str = b.f9191g;
            Log.w(str, "onAccuracyChanged" + i2);
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            String str = b.f9191g;
            Log.w(str, "onSensorChanged() time:" + System.currentTimeMillis());
            float[] fArr = sensorEvent.values;
            if (fArr != null && fArr.length > 0) {
                b.this.f9198f = fArr[0];
                String str2 = b.f9191g;
                Log.w(str2, "onSensorChanged() event.values[0]:" + b.this.f9198f);
            }
            b.this.f9197e = System.currentTimeMillis();
            InterfaceC0114b interfaceC0114b = this.f9199a;
            if (interfaceC0114b != null) {
                interfaceC0114b.a(b.this.a());
            }
        }
    }

    /* renamed from: com.baidu.pass.biometrics.face.liveness.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0114b {
        void a(float f2);
    }

    public b(Context context) {
        this.f9193a = context;
    }

    @TargetApi(3)
    public void b() {
        Log.w(f9191g, "unRegisterSensorListener()");
        SensorManager sensorManager = this.f9194b;
        if (sensorManager == null || this.f9195c == null) {
            return;
        }
        sensorManager.unregisterListener(this.f9196d);
    }

    @TargetApi(3)
    public void a(InterfaceC0114b interfaceC0114b) {
        SensorManager sensorManager = (SensorManager) this.f9193a.getSystemService("sensor");
        this.f9194b = sensorManager;
        if (sensorManager == null) {
            Log.w(f9191g, "sensorManager|senserManager == null");
            return;
        }
        Sensor defaultSensor = sensorManager.getDefaultSensor(5);
        this.f9195c = defaultSensor;
        if (defaultSensor == null) {
            return;
        }
        a aVar = new a(interfaceC0114b);
        this.f9196d = aVar;
        this.f9194b.registerListener(aVar, this.f9195c, 3);
    }

    public float a() {
        if (this.f9197e != 0 && System.currentTimeMillis() - this.f9197e > f9192h) {
            this.f9198f = 0.0f;
        }
        return this.f9198f;
    }
}
