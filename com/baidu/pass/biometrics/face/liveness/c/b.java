package com.baidu.pass.biometrics.face.liveness.c;

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
    public static final String f9150g = "b";

    /* renamed from: h  reason: collision with root package name */
    public static long f9151h = 1000;

    /* renamed from: a  reason: collision with root package name */
    public Context f9152a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f9153b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f9154c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f9155d;

    /* renamed from: e  reason: collision with root package name */
    public long f9156e = 0;

    /* renamed from: f  reason: collision with root package name */
    public float f9157f = 2.1474836E9f;

    /* loaded from: classes2.dex */
    public class a implements SensorEventListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0115b f9158a;

        public a(InterfaceC0115b interfaceC0115b) {
            this.f9158a = interfaceC0115b;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
            String str = b.f9150g;
            Log.w(str, "onAccuracyChanged" + i2);
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            String str = b.f9150g;
            Log.w(str, "onSensorChanged() time:" + System.currentTimeMillis());
            float[] fArr = sensorEvent.values;
            if (fArr != null && fArr.length > 0) {
                b.this.f9157f = fArr[0];
                String str2 = b.f9150g;
                Log.w(str2, "onSensorChanged() event.values[0]:" + b.this.f9157f);
            }
            b.this.f9156e = System.currentTimeMillis();
            InterfaceC0115b interfaceC0115b = this.f9158a;
            if (interfaceC0115b != null) {
                interfaceC0115b.a(b.this.a());
            }
        }
    }

    /* renamed from: com.baidu.pass.biometrics.face.liveness.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0115b {
        void a(float f2);
    }

    public b(Context context) {
        this.f9152a = context;
    }

    @TargetApi(3)
    public void b() {
        Log.w(f9150g, "unRegisterSensorListener()");
        SensorManager sensorManager = this.f9153b;
        if (sensorManager == null || this.f9154c == null) {
            return;
        }
        sensorManager.unregisterListener(this.f9155d);
    }

    @TargetApi(3)
    public void a(InterfaceC0115b interfaceC0115b) {
        SensorManager sensorManager = (SensorManager) this.f9152a.getSystemService("sensor");
        this.f9153b = sensorManager;
        if (sensorManager == null) {
            Log.w(f9150g, "sensorManager|senserManager == null");
            return;
        }
        Sensor defaultSensor = sensorManager.getDefaultSensor(5);
        this.f9154c = defaultSensor;
        if (defaultSensor == null) {
            return;
        }
        a aVar = new a(interfaceC0115b);
        this.f9155d = aVar;
        this.f9153b.registerListener(aVar, this.f9154c, 3);
    }

    public float a() {
        if (this.f9156e != 0 && System.currentTimeMillis() - this.f9156e > f9151h) {
            this.f9157f = 0.0f;
        }
        return this.f9157f;
    }
}
