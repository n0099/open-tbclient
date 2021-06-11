package com.baidu.location.b;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
/* loaded from: classes2.dex */
public class n implements SensorEventListener {

    /* renamed from: d  reason: collision with root package name */
    public static n f6594d;

    /* renamed from: a  reason: collision with root package name */
    public float[] f6595a;

    /* renamed from: b  reason: collision with root package name */
    public float[] f6596b;

    /* renamed from: c  reason: collision with root package name */
    public SensorManager f6597c;

    /* renamed from: e  reason: collision with root package name */
    public float f6598e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6599f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6600g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6601h = false;

    public static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            if (f6594d == null) {
                f6594d = new n();
            }
            nVar = f6594d;
        }
        return nVar;
    }

    public void a(boolean z) {
        this.f6599f = z;
    }

    public synchronized void b() {
        if (this.f6601h) {
            return;
        }
        if (this.f6599f) {
            if (this.f6597c == null) {
                this.f6597c = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
            }
            if (this.f6597c != null) {
                Sensor defaultSensor = this.f6597c.getDefaultSensor(11);
                if (defaultSensor != null && this.f6599f) {
                    this.f6597c.registerListener(this, defaultSensor, 3);
                }
                Sensor defaultSensor2 = this.f6597c.getDefaultSensor(2);
                if (defaultSensor2 != null && this.f6599f) {
                    this.f6597c.registerListener(this, defaultSensor2, 3);
                }
            }
            this.f6601h = true;
        }
    }

    public synchronized void c() {
        if (this.f6601h) {
            if (this.f6597c != null) {
                this.f6597c.unregisterListener(this);
                this.f6597c = null;
            }
            this.f6601h = false;
        }
    }

    public boolean d() {
        return this.f6599f;
    }

    public float e() {
        return this.f6598e;
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
            this.f6596b = fArr;
            Math.sqrt((fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2]));
            float[] fArr2 = this.f6596b;
        } else if (type != 11) {
        } else {
            float[] fArr3 = (float[]) sensorEvent.values.clone();
            this.f6595a = fArr3;
            if (fArr3 != null) {
                float[] fArr4 = new float[9];
                try {
                    SensorManager.getRotationMatrixFromVector(fArr4, fArr3);
                    float[] fArr5 = new float[3];
                    SensorManager.getOrientation(fArr4, fArr5);
                    float degrees = (float) Math.toDegrees(fArr5[0]);
                    this.f6598e = degrees;
                    if (degrees < 0.0f) {
                        degrees += 360.0f;
                    }
                    this.f6598e = (float) Math.floor(degrees);
                } catch (Exception unused) {
                    this.f6598e = 0.0f;
                }
            }
        }
    }
}
