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
    public static final String f9670g = "b";

    /* renamed from: h  reason: collision with root package name */
    public static long f9671h = 1000;

    /* renamed from: a  reason: collision with root package name */
    public Context f9672a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f9673b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f9674c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f9675d;

    /* renamed from: e  reason: collision with root package name */
    public long f9676e = 0;

    /* renamed from: f  reason: collision with root package name */
    public float f9677f = 2.1474836E9f;

    /* loaded from: classes2.dex */
    public class a implements SensorEventListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InterfaceC0116b f9678a;

        public a(InterfaceC0116b interfaceC0116b) {
            this.f9678a = interfaceC0116b;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            String str = b.f9670g;
            Log.w(str, "onAccuracyChanged" + i);
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            String str = b.f9670g;
            Log.w(str, "onSensorChanged() time:" + System.currentTimeMillis());
            float[] fArr = sensorEvent.values;
            if (fArr != null && fArr.length > 0) {
                b.this.f9677f = fArr[0];
                String str2 = b.f9670g;
                Log.w(str2, "onSensorChanged() event.values[0]:" + b.this.f9677f);
            }
            b.this.f9676e = System.currentTimeMillis();
            InterfaceC0116b interfaceC0116b = this.f9678a;
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
        this.f9672a = context;
    }

    @TargetApi(3)
    public void b() {
        Log.w(f9670g, "unRegisterSensorListener()");
        SensorManager sensorManager = this.f9673b;
        if (sensorManager == null || this.f9674c == null) {
            return;
        }
        sensorManager.unregisterListener(this.f9675d);
    }

    @TargetApi(3)
    public void a(InterfaceC0116b interfaceC0116b) {
        SensorManager sensorManager = (SensorManager) this.f9672a.getSystemService("sensor");
        this.f9673b = sensorManager;
        if (sensorManager == null) {
            Log.w(f9670g, "sensorManager|senserManager == null");
            return;
        }
        Sensor defaultSensor = sensorManager.getDefaultSensor(5);
        this.f9674c = defaultSensor;
        if (defaultSensor == null) {
            return;
        }
        a aVar = new a(interfaceC0116b);
        this.f9675d = aVar;
        this.f9673b.registerListener(aVar, this.f9674c, 3);
    }

    public float a() {
        if (this.f9676e != 0 && System.currentTimeMillis() - this.f9676e > f9671h) {
            this.f9677f = 0.0f;
        }
        return this.f9677f;
    }
}
