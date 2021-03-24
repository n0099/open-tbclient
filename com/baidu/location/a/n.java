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
    public static Object f6556a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static n f6557b;

    /* renamed from: c  reason: collision with root package name */
    public float[] f6558c;

    /* renamed from: d  reason: collision with root package name */
    public int f6559d = 0;

    /* renamed from: e  reason: collision with root package name */
    public List<Float> f6560e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<Float> f6561f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public boolean f6562g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6563h;
    public SensorManager i;

    public n() {
        this.f6563h = false;
        try {
            if (this.i == null) {
                this.i = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
            }
            if (this.i.getDefaultSensor(6) != null) {
                this.f6563h = true;
            }
        } catch (Exception unused) {
            this.f6563h = false;
        }
    }

    public static n a() {
        n nVar;
        synchronized (f6556a) {
            if (f6557b == null) {
                f6557b = new n();
            }
            nVar = f6557b;
        }
        return nVar;
    }

    public void b() {
        Sensor defaultSensor;
        if (this.f6563h && !this.f6562g) {
            try {
                this.f6559d = 0;
                this.f6560e.clear();
                this.f6561f.clear();
                if (this.i == null) {
                    this.i = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
                }
                if (this.i != null && (defaultSensor = this.i.getDefaultSensor(6)) != null) {
                    this.i.registerListener(this, defaultSensor, 2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f6562g = true;
        }
    }

    public void c() {
        if (this.f6562g) {
            try {
                if (this.i != null) {
                    this.i.unregisterListener(this);
                    this.i = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f6562g = false;
        }
    }

    public float d() {
        float f2;
        synchronized (this.f6561f) {
            f2 = 0.0f;
            if (Math.abs(((int) (System.currentTimeMillis() / 1000)) - this.f6559d) <= 5 && this.f6561f.size() > 0) {
                try {
                    f2 = this.f6561f.get(this.f6561f.size() - 1).floatValue();
                } catch (Throwable unused) {
                }
            }
        }
        return f2;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    @SuppressLint({"NewApi"})
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 6 && this.f6562g) {
            this.f6558c = (float[]) sensorEvent.values.clone();
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            if (currentTimeMillis == this.f6559d) {
                this.f6560e.add(Float.valueOf(this.f6558c[0]));
                return;
            }
            this.f6559d = currentTimeMillis;
            if (this.f6560e.size() > 0) {
                int size = this.f6560e.size();
                float f2 = 0.0f;
                for (Float f3 : this.f6560e) {
                    f2 += f3.floatValue();
                }
                float f4 = f2 / size;
                synchronized (this.f6561f) {
                    try {
                        this.f6561f.add(Float.valueOf(f4));
                        if (this.f6561f.size() >= 4) {
                            this.f6561f.remove(0);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        this.f6561f.clear();
                    }
                }
                this.f6560e.clear();
            }
        }
    }
}
