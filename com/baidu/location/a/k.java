package com.baidu.location.a;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class k implements SensorEventListener {
    private SensorManager WW;
    private float[] c;
    private int d = 0;
    private List<Float> e = new ArrayList();
    private List<Float> f = new ArrayList();
    private boolean g = false;
    private boolean h;
    private static Object a = new Object();
    private static k WV = null;

    public k() {
        this.h = false;
        try {
            if (this.WW == null) {
                this.WW = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
            }
            if (this.WW.getDefaultSensor(6) != null) {
                this.h = true;
            }
        } catch (Exception e) {
            this.h = false;
        }
    }

    public static k qx() {
        k kVar;
        synchronized (a) {
            if (WV == null) {
                WV = new k();
            }
            kVar = WV;
        }
        return kVar;
    }

    public void b() {
        Sensor defaultSensor;
        if (this.h && !this.g) {
            try {
                this.d = 0;
                this.e.clear();
                this.f.clear();
                if (this.WW == null) {
                    this.WW = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
                }
                if (this.WW != null && (defaultSensor = this.WW.getDefaultSensor(6)) != null) {
                    this.WW.registerListener(this, defaultSensor, 2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.g = true;
        }
    }

    public void c() {
        if (this.g) {
            try {
                if (this.WW != null) {
                    this.WW.unregisterListener(this);
                    this.WW = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.g = false;
        }
    }

    public float d() {
        float f;
        synchronized (this.f) {
            if (Math.abs(((int) (System.currentTimeMillis() / 1000)) - this.d) > 5 || this.f.size() <= 0) {
                f = 0.0f;
            } else {
                try {
                    f = this.f.get(this.f.size() - 1).floatValue();
                } catch (Throwable th) {
                    f = 0.0f;
                }
            }
        }
        return f;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    @SuppressLint({"NewApi"})
    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
            case 6:
                if (!this.g) {
                    return;
                }
                this.c = (float[]) sensorEvent.values.clone();
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                if (currentTimeMillis == this.d) {
                    this.e.add(Float.valueOf(this.c[0]));
                    return;
                }
                this.d = currentTimeMillis;
                if (this.e.size() <= 0) {
                    return;
                }
                int size = this.e.size();
                float f = 0.0f;
                Iterator<Float> it = this.e.iterator();
                while (true) {
                    float f2 = f;
                    if (!it.hasNext()) {
                        float f3 = f2 / size;
                        synchronized (this.f) {
                            try {
                                this.f.add(Float.valueOf(f3));
                                if (this.f.size() >= 4) {
                                    this.f.remove(0);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                this.f.clear();
                            }
                        }
                        this.e.clear();
                        return;
                    }
                    f = it.next().floatValue() + f2;
                }
            default:
                return;
        }
    }
}
