package com.baidu.location.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class f implements SensorEventListener {
    private static f Gk;
    private float[] Gh;
    private float[] Gi;
    private SensorManager Gj;
    private float e;
    private boolean i;
    private double Gl = Double.MIN_VALUE;
    private boolean g = false;
    private boolean h = false;
    private float j = 0.0f;
    private long Gm = 0;
    private boolean l = false;
    private long Gn = 0;

    private f() {
        this.i = false;
        try {
            if (this.Gj == null) {
                this.Gj = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
            }
            if (this.Gj.getDefaultSensor(6) != null) {
                this.i = true;
            }
        } catch (Exception e) {
            this.i = false;
        }
    }

    private void k() {
        if (this.Gj != null) {
            Sensor defaultSensor = this.Gj.getDefaultSensor(6);
            if (defaultSensor != null) {
                this.Gj.registerListener(Gk, defaultSensor, 3);
            }
            com.baidu.location.g.a.a().postDelayed(new k(this), 2000L);
        }
    }

    public static synchronized f lE() {
        f fVar;
        synchronized (f.class) {
            if (Gk == null) {
                Gk = new f();
            }
            fVar = Gk;
        }
        return fVar;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public synchronized void b() {
        if (!this.l && (this.g || this.h)) {
            if (this.Gj == null) {
                this.Gj = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
            }
            if (this.Gj != null) {
                Sensor defaultSensor = this.Gj.getDefaultSensor(11);
                if (defaultSensor != null && this.g) {
                    this.Gj.registerListener(this, defaultSensor, 3);
                }
                Sensor defaultSensor2 = this.Gj.getDefaultSensor(6);
                if (defaultSensor2 != null && this.h) {
                    this.Gj.registerListener(this, defaultSensor2, 3);
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
            if (this.Gj != null) {
                this.Gj.unregisterListener(this);
                this.Gj = null;
            }
            this.l = false;
            this.j = 0.0f;
        }
    }

    public void d() {
        if (this.h || !this.i || System.currentTimeMillis() - this.Gn <= TbConfig.USE_TIME_INTERVAL) {
            return;
        }
        this.Gn = System.currentTimeMillis();
        k();
    }

    public boolean f() {
        return this.g;
    }

    public boolean g() {
        return this.h;
    }

    public float lF() {
        if (!this.i || this.Gm <= 0 || Math.abs(System.currentTimeMillis() - this.Gm) >= TbConfig.NOTIFY_SOUND_INTERVAL || this.j <= 0.0f) {
            return 0.0f;
        }
        return this.j;
    }

    public float lG() {
        return this.e;
    }

    public double lH() {
        return this.Gl;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
            case 6:
                try {
                    this.Gi = (float[]) sensorEvent.values.clone();
                    this.j = this.Gi[0];
                    this.Gm = System.currentTimeMillis();
                    this.Gl = SensorManager.getAltitude(1013.25f, this.Gi[0]);
                    return;
                } catch (Exception e) {
                    return;
                }
            case 11:
                this.Gh = (float[]) sensorEvent.values.clone();
                if (this.Gh != null) {
                    float[] fArr = new float[9];
                    try {
                        SensorManager.getRotationMatrixFromVector(fArr, this.Gh);
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
