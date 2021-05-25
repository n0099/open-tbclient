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
    public static final String f9091g = "b";

    /* renamed from: h  reason: collision with root package name */
    public static long f9092h = 1000;

    /* renamed from: a  reason: collision with root package name */
    public Context f9093a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f9094b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f9095c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f9096d;

    /* renamed from: e  reason: collision with root package name */
    public long f9097e = 0;

    /* renamed from: f  reason: collision with root package name */
    public float f9098f = 2.1474836E9f;

    /* loaded from: classes2.dex */
    public class a implements SensorEventListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0115b f9099a;

        public a(InterfaceC0115b interfaceC0115b) {
            this.f9099a = interfaceC0115b;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
            String str = b.f9091g;
            Log.w(str, "onAccuracyChanged" + i2);
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            String str = b.f9091g;
            Log.w(str, "onSensorChanged() time:" + System.currentTimeMillis());
            float[] fArr = sensorEvent.values;
            if (fArr != null && fArr.length > 0) {
                b.this.f9098f = fArr[0];
                String str2 = b.f9091g;
                Log.w(str2, "onSensorChanged() event.values[0]:" + b.this.f9098f);
            }
            b.this.f9097e = System.currentTimeMillis();
            InterfaceC0115b interfaceC0115b = this.f9099a;
            if (interfaceC0115b != null) {
                interfaceC0115b.a(b.this.a());
            }
        }
    }

    /* renamed from: com.baidu.pass.biometrics.face.liveness.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0115b {
        void a(float f2);
    }

    public b(Context context) {
        this.f9093a = context;
    }

    @TargetApi(3)
    public void b() {
        Log.w(f9091g, "unRegisterSensorListener()");
        SensorManager sensorManager = this.f9094b;
        if (sensorManager == null || this.f9095c == null) {
            return;
        }
        sensorManager.unregisterListener(this.f9096d);
    }

    @TargetApi(3)
    public void a(InterfaceC0115b interfaceC0115b) {
        SensorManager sensorManager = (SensorManager) this.f9093a.getSystemService("sensor");
        this.f9094b = sensorManager;
        if (sensorManager == null) {
            Log.w(f9091g, "sensorManager|senserManager == null");
            return;
        }
        Sensor defaultSensor = sensorManager.getDefaultSensor(5);
        this.f9095c = defaultSensor;
        if (defaultSensor == null) {
            return;
        }
        a aVar = new a(interfaceC0115b);
        this.f9096d = aVar;
        this.f9094b.registerListener(aVar, this.f9095c, 3);
    }

    public float a() {
        if (this.f9097e != 0 && System.currentTimeMillis() - this.f9097e > f9092h) {
            this.f9098f = 0.0f;
        }
        return this.f9098f;
    }
}
