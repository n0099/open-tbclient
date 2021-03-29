package com.baidu.location.a;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
/* loaded from: classes2.dex */
public class o implements SensorEventListener {

    /* renamed from: d  reason: collision with root package name */
    public static o f6565d;

    /* renamed from: a  reason: collision with root package name */
    public float[] f6566a;

    /* renamed from: b  reason: collision with root package name */
    public float[] f6567b;

    /* renamed from: c  reason: collision with root package name */
    public SensorManager f6568c;

    /* renamed from: e  reason: collision with root package name */
    public float f6569e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6570f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6571g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6572h = false;

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            if (f6565d == null) {
                f6565d = new o();
            }
            oVar = f6565d;
        }
        return oVar;
    }

    public void a(boolean z) {
        this.f6570f = z;
    }

    public synchronized void b() {
        if (this.f6572h) {
            return;
        }
        if (this.f6570f) {
            if (this.f6568c == null) {
                this.f6568c = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
            }
            if (this.f6568c != null) {
                Sensor defaultSensor = this.f6568c.getDefaultSensor(11);
                if (defaultSensor != null && this.f6570f) {
                    this.f6568c.registerListener(this, defaultSensor, 3);
                }
                Sensor defaultSensor2 = this.f6568c.getDefaultSensor(2);
                if (defaultSensor2 != null && this.f6570f) {
                    this.f6568c.registerListener(this, defaultSensor2, 3);
                }
            }
            this.f6572h = true;
        }
    }

    public synchronized void c() {
        if (this.f6572h) {
            if (this.f6568c != null) {
                this.f6568c.unregisterListener(this);
                this.f6568c = null;
            }
            this.f6572h = false;
        }
    }

    public boolean d() {
        return this.f6570f;
    }

    public float e() {
        return this.f6569e;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    @SuppressLint({"NewApi"})
    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 2) {
            float[] fArr = (float[]) sensorEvent.values.clone();
            this.f6567b = fArr;
            Math.sqrt((fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2]));
            float[] fArr2 = this.f6567b;
        } else if (type != 11) {
        } else {
            float[] fArr3 = (float[]) sensorEvent.values.clone();
            this.f6566a = fArr3;
            if (fArr3 != null) {
                float[] fArr4 = new float[9];
                try {
                    SensorManager.getRotationMatrixFromVector(fArr4, fArr3);
                    float[] fArr5 = new float[3];
                    SensorManager.getOrientation(fArr4, fArr5);
                    float degrees = (float) Math.toDegrees(fArr5[0]);
                    this.f6569e = degrees;
                    if (degrees < 0.0f) {
                        degrees += 360.0f;
                    }
                    this.f6569e = (float) Math.floor(degrees);
                } catch (Exception unused) {
                    this.f6569e = 0.0f;
                }
            }
        }
    }
}
