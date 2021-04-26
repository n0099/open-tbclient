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
    public static final String f9570g = "b";

    /* renamed from: h  reason: collision with root package name */
    public static long f9571h = 1000;

    /* renamed from: a  reason: collision with root package name */
    public Context f9572a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f9573b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f9574c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f9575d;

    /* renamed from: e  reason: collision with root package name */
    public long f9576e = 0;

    /* renamed from: f  reason: collision with root package name */
    public float f9577f = 2.1474836E9f;

    /* loaded from: classes2.dex */
    public class a implements SensorEventListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0116b f9578a;

        public a(InterfaceC0116b interfaceC0116b) {
            this.f9578a = interfaceC0116b;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
            String str = b.f9570g;
            Log.w(str, "onAccuracyChanged" + i2);
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            String str = b.f9570g;
            Log.w(str, "onSensorChanged() time:" + System.currentTimeMillis());
            float[] fArr = sensorEvent.values;
            if (fArr != null && fArr.length > 0) {
                b.this.f9577f = fArr[0];
                String str2 = b.f9570g;
                Log.w(str2, "onSensorChanged() event.values[0]:" + b.this.f9577f);
            }
            b.this.f9576e = System.currentTimeMillis();
            InterfaceC0116b interfaceC0116b = this.f9578a;
            if (interfaceC0116b != null) {
                interfaceC0116b.a(b.this.a());
            }
        }
    }

    /* renamed from: com.baidu.pass.biometrics.face.liveness.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0116b {
        void a(float f2);
    }

    public b(Context context) {
        this.f9572a = context;
    }

    @TargetApi(3)
    public void b() {
        Log.w(f9570g, "unRegisterSensorListener()");
        SensorManager sensorManager = this.f9573b;
        if (sensorManager == null || this.f9574c == null) {
            return;
        }
        sensorManager.unregisterListener(this.f9575d);
    }

    @TargetApi(3)
    public void a(InterfaceC0116b interfaceC0116b) {
        SensorManager sensorManager = (SensorManager) this.f9572a.getSystemService("sensor");
        this.f9573b = sensorManager;
        if (sensorManager == null) {
            Log.w(f9570g, "sensorManager|senserManager == null");
            return;
        }
        Sensor defaultSensor = sensorManager.getDefaultSensor(5);
        this.f9574c = defaultSensor;
        if (defaultSensor == null) {
            return;
        }
        a aVar = new a(interfaceC0116b);
        this.f9575d = aVar;
        this.f9573b.registerListener(aVar, this.f9574c, 3);
    }

    public float a() {
        if (this.f9576e != 0 && System.currentTimeMillis() - this.f9576e > f9571h) {
            this.f9577f = 0.0f;
        }
        return this.f9577f;
    }
}
