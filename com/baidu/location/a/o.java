package com.baidu.location.a;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
/* loaded from: classes4.dex */
public class o implements SensorEventListener {
    private static o d;

    /* renamed from: a  reason: collision with root package name */
    private float[] f2574a;

    /* renamed from: b  reason: collision with root package name */
    private float[] f2575b;
    private SensorManager c;
    private float e;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;

    private o() {
    }

    public static synchronized o a() {
        o oVar;
        synchronized (o.class) {
            if (d == null) {
                d = new o();
            }
            oVar = d;
        }
        return oVar;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public synchronized void b() {
        if (!this.h && this.f) {
            if (this.c == null) {
                this.c = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
            }
            if (this.c != null) {
                Sensor defaultSensor = this.c.getDefaultSensor(11);
                if (defaultSensor != null && this.f) {
                    this.c.registerListener(this, defaultSensor, 3);
                }
                Sensor defaultSensor2 = this.c.getDefaultSensor(2);
                if (defaultSensor2 != null && this.f) {
                    this.c.registerListener(this, defaultSensor2, 3);
                }
            }
            this.h = true;
        }
    }

    public synchronized void c() {
        if (this.h) {
            if (this.c != null) {
                this.c.unregisterListener(this);
                this.c = null;
            }
            this.h = false;
        }
    }

    public boolean d() {
        return this.f;
    }

    public float e() {
        return this.e;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    @SuppressLint({"NewApi"})
    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
            case 2:
                this.f2575b = (float[]) sensorEvent.values.clone();
                Math.sqrt((this.f2575b[0] * this.f2575b[0]) + (this.f2575b[1] * this.f2575b[1]) + (this.f2575b[2] * this.f2575b[2]));
                if (this.f2575b != null) {
                }
                return;
            case 11:
                this.f2574a = (float[]) sensorEvent.values.clone();
                if (this.f2574a != null) {
                    float[] fArr = new float[9];
                    try {
                        SensorManager.getRotationMatrixFromVector(fArr, this.f2574a);
                        float[] fArr2 = new float[3];
                        SensorManager.getOrientation(fArr, fArr2);
                        this.e = (float) Math.toDegrees(fArr2[0]);
                        this.e = (float) Math.floor(this.e >= 0.0f ? this.e : this.e + 360.0f);
                        return;
                    } catch (Exception e) {
                        this.e = 0.0f;
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }
}
