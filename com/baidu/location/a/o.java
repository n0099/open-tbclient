package com.baidu.location.a;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
/* loaded from: classes2.dex */
public class o implements SensorEventListener {

    /* renamed from: d  reason: collision with root package name */
    public static o f6826d;

    /* renamed from: a  reason: collision with root package name */
    public float[] f6827a;

    /* renamed from: b  reason: collision with root package name */
    public float[] f6828b;

    /* renamed from: c  reason: collision with root package name */
    public SensorManager f6829c;

    /* renamed from: e  reason: collision with root package name */
    public float f6830e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6831f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6832g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6833h = false;

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            if (f6826d == null) {
                f6826d = new o();
            }
            oVar = f6826d;
        }
        return oVar;
    }

    public void a(boolean z) {
        this.f6831f = z;
    }

    public synchronized void b() {
        if (this.f6833h) {
            return;
        }
        if (this.f6831f) {
            if (this.f6829c == null) {
                this.f6829c = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
            }
            if (this.f6829c != null) {
                Sensor defaultSensor = this.f6829c.getDefaultSensor(11);
                if (defaultSensor != null && this.f6831f) {
                    this.f6829c.registerListener(this, defaultSensor, 3);
                }
                Sensor defaultSensor2 = this.f6829c.getDefaultSensor(2);
                if (defaultSensor2 != null && this.f6831f) {
                    this.f6829c.registerListener(this, defaultSensor2, 3);
                }
            }
            this.f6833h = true;
        }
    }

    public synchronized void c() {
        if (this.f6833h) {
            if (this.f6829c != null) {
                this.f6829c.unregisterListener(this);
                this.f6829c = null;
            }
            this.f6833h = false;
        }
    }

    public boolean d() {
        return this.f6831f;
    }

    public float e() {
        return this.f6830e;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    @SuppressLint({"NewApi"})
    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 2) {
            float[] fArr = (float[]) sensorEvent.values.clone();
            this.f6828b = fArr;
            Math.sqrt((fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2]));
            float[] fArr2 = this.f6828b;
        } else if (type != 11) {
        } else {
            float[] fArr3 = (float[]) sensorEvent.values.clone();
            this.f6827a = fArr3;
            if (fArr3 != null) {
                float[] fArr4 = new float[9];
                try {
                    SensorManager.getRotationMatrixFromVector(fArr4, fArr3);
                    float[] fArr5 = new float[3];
                    SensorManager.getOrientation(fArr4, fArr5);
                    float degrees = (float) Math.toDegrees(fArr5[0]);
                    this.f6830e = degrees;
                    if (degrees < 0.0f) {
                        degrees += 360.0f;
                    }
                    this.f6830e = (float) Math.floor(degrees);
                } catch (Exception unused) {
                    this.f6830e = 0.0f;
                }
            }
        }
    }
}
