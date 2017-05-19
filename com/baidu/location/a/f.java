package com.baidu.location.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class f implements SensorEventListener {
    private static f MK;
    private float[] MH;
    private float[] MI;
    private SensorManager MJ;
    private float e;
    private boolean i;
    private double ML = Double.MIN_VALUE;
    private boolean g = false;
    private boolean h = false;
    private float j = 0.0f;
    private long k = 0;
    private boolean l = false;
    private long m = 0;

    private f() {
        this.i = false;
        try {
            if (this.MJ == null) {
                this.MJ = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
            }
            if (this.MJ.getDefaultSensor(6) != null) {
                this.i = true;
            }
        } catch (Exception e) {
            this.i = false;
        }
    }

    private void k() {
        if (this.MJ != null) {
            Sensor defaultSensor = this.MJ.getDefaultSensor(6);
            if (defaultSensor != null) {
                this.MJ.registerListener(MK, defaultSensor, 3);
            }
            com.baidu.location.g.a.a().postDelayed(new k(this), 2000L);
        }
    }

    public static synchronized f mz() {
        f fVar;
        synchronized (f.class) {
            if (MK == null) {
                MK = new f();
            }
            fVar = MK;
        }
        return fVar;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public synchronized void b() {
        if (!this.l && (this.g || this.h)) {
            if (this.MJ == null) {
                this.MJ = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
            }
            if (this.MJ != null) {
                Sensor defaultSensor = this.MJ.getDefaultSensor(11);
                if (defaultSensor != null && this.g) {
                    this.MJ.registerListener(this, defaultSensor, 3);
                }
                Sensor defaultSensor2 = this.MJ.getDefaultSensor(6);
                if (defaultSensor2 != null && this.h) {
                    this.MJ.registerListener(this, defaultSensor2, 3);
                }
            }
            this.l = true;
        }
    }

    public void b(boolean z) {
        this.h = z;
    }

    public synchronized void c() {
        if (this.l) {
            if (this.MJ != null) {
                this.MJ.unregisterListener(this);
                this.MJ = null;
            }
            this.l = false;
            this.j = 0.0f;
        }
    }

    public void d() {
        if (this.h || !this.i || System.currentTimeMillis() - this.m <= TbConfig.USE_TIME_INTERVAL) {
            return;
        }
        this.m = System.currentTimeMillis();
        k();
    }

    public float e() {
        if (!this.i || this.k <= 0 || Math.abs(System.currentTimeMillis() - this.k) >= TbConfig.NOTIFY_SOUND_INTERVAL || this.j <= 0.0f) {
            return 0.0f;
        }
        return this.j;
    }

    public boolean f() {
        return this.g;
    }

    public boolean g() {
        return this.h;
    }

    public float h() {
        return this.e;
    }

    public double mA() {
        return this.ML;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
            case 6:
                try {
                    this.MI = (float[]) sensorEvent.values.clone();
                    this.j = this.MI[0];
                    this.k = System.currentTimeMillis();
                    this.ML = SensorManager.getAltitude(1013.25f, this.MI[0]);
                    return;
                } catch (Exception e) {
                    return;
                }
            case 11:
                this.MH = (float[]) sensorEvent.values.clone();
                if (this.MH != null) {
                    float[] fArr = new float[9];
                    try {
                        SensorManager.getRotationMatrixFromVector(fArr, this.MH);
                        float[] fArr2 = new float[3];
                        SensorManager.getOrientation(fArr, fArr2);
                        this.e = (float) Math.toDegrees(fArr2[0]);
                        this.e = (float) Math.floor(this.e >= 0.0f ? this.e : this.e + 360.0f);
                        return;
                    } catch (Exception e2) {
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
