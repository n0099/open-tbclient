package com.baidu.location.a;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class n implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    public static Object f6817a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static n f6818b;

    /* renamed from: c  reason: collision with root package name */
    public float[] f6819c;

    /* renamed from: d  reason: collision with root package name */
    public int f6820d = 0;

    /* renamed from: e  reason: collision with root package name */
    public List<Float> f6821e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<Float> f6822f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public boolean f6823g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6824h;

    /* renamed from: i  reason: collision with root package name */
    public SensorManager f6825i;

    public n() {
        this.f6824h = false;
        try {
            if (this.f6825i == null) {
                this.f6825i = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
            }
            if (this.f6825i.getDefaultSensor(6) != null) {
                this.f6824h = true;
            }
        } catch (Exception unused) {
            this.f6824h = false;
        }
    }

    public static n a() {
        n nVar;
        synchronized (f6817a) {
            if (f6818b == null) {
                f6818b = new n();
            }
            nVar = f6818b;
        }
        return nVar;
    }

    public void b() {
        Sensor defaultSensor;
        if (this.f6824h && !this.f6823g) {
            try {
                this.f6820d = 0;
                this.f6821e.clear();
                this.f6822f.clear();
                if (this.f6825i == null) {
                    this.f6825i = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
                }
                if (this.f6825i != null && (defaultSensor = this.f6825i.getDefaultSensor(6)) != null) {
                    this.f6825i.registerListener(this, defaultSensor, 2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f6823g = true;
        }
    }

    public void c() {
        if (this.f6823g) {
            try {
                if (this.f6825i != null) {
                    this.f6825i.unregisterListener(this);
                    this.f6825i = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f6823g = false;
        }
    }

    public float d() {
        float f2;
        synchronized (this.f6822f) {
            f2 = 0.0f;
            if (Math.abs(((int) (System.currentTimeMillis() / 1000)) - this.f6820d) <= 5 && this.f6822f.size() > 0) {
                try {
                    f2 = this.f6822f.get(this.f6822f.size() - 1).floatValue();
                } catch (Throwable unused) {
                }
            }
        }
        return f2;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    @SuppressLint({"NewApi"})
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 6 && this.f6823g) {
            this.f6819c = (float[]) sensorEvent.values.clone();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis == this.f6820d) {
                this.f6821e.add(Float.valueOf(this.f6819c[0]));
                return;
            }
            this.f6820d = currentTimeMillis;
            if (this.f6821e.size() > 0) {
                int size = this.f6821e.size();
                float f2 = 0.0f;
                for (Float f3 : this.f6821e) {
                    f2 += f3.floatValue();
                }
                float f4 = f2 / size;
                synchronized (this.f6822f) {
                    try {
                        this.f6822f.add(Float.valueOf(f4));
                        if (this.f6822f.size() >= 4) {
                            this.f6822f.remove(0);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        this.f6822f.clear();
                    }
                }
                this.f6821e.clear();
            }
        }
    }
}
