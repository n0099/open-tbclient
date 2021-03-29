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
    public static final String f9671g = "b";

    /* renamed from: h  reason: collision with root package name */
    public static long f9672h = 1000;

    /* renamed from: a  reason: collision with root package name */
    public Context f9673a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f9674b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f9675c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f9676d;

    /* renamed from: e  reason: collision with root package name */
    public long f9677e = 0;

    /* renamed from: f  reason: collision with root package name */
    public float f9678f = 2.1474836E9f;

    /* loaded from: classes2.dex */
    public class a implements SensorEventListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0117b f9679a;

        public a(InterfaceC0117b interfaceC0117b) {
            this.f9679a = interfaceC0117b;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            String str = b.f9671g;
            Log.w(str, "onAccuracyChanged" + i);
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            String str = b.f9671g;
            Log.w(str, "onSensorChanged() time:" + System.currentTimeMillis());
            float[] fArr = sensorEvent.values;
            if (fArr != null && fArr.length > 0) {
                b.this.f9678f = fArr[0];
                String str2 = b.f9671g;
                Log.w(str2, "onSensorChanged() event.values[0]:" + b.this.f9678f);
            }
            b.this.f9677e = System.currentTimeMillis();
            InterfaceC0117b interfaceC0117b = this.f9679a;
            if (interfaceC0117b != null) {
                interfaceC0117b.a(b.this.a());
            }
        }
    }

    /* renamed from: com.baidu.pass.biometrics.face.liveness.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0117b {
        void a(float f2);
    }

    public b(Context context) {
        this.f9673a = context;
    }

    @TargetApi(3)
    public void b() {
        Log.w(f9671g, "unRegisterSensorListener()");
        SensorManager sensorManager = this.f9674b;
        if (sensorManager == null || this.f9675c == null) {
            return;
        }
        sensorManager.unregisterListener(this.f9676d);
    }

    @TargetApi(3)
    public void a(InterfaceC0117b interfaceC0117b) {
        SensorManager sensorManager = (SensorManager) this.f9673a.getSystemService("sensor");
        this.f9674b = sensorManager;
        if (sensorManager == null) {
            Log.w(f9671g, "sensorManager|senserManager == null");
            return;
        }
        Sensor defaultSensor = sensorManager.getDefaultSensor(5);
        this.f9675c = defaultSensor;
        if (defaultSensor == null) {
            return;
        }
        a aVar = new a(interfaceC0117b);
        this.f9676d = aVar;
        this.f9674b.registerListener(aVar, this.f9675c, 3);
    }

    public float a() {
        if (this.f9677e != 0 && System.currentTimeMillis() - this.f9677e > f9672h) {
            this.f9678f = 0.0f;
        }
        return this.f9678f;
    }
}
