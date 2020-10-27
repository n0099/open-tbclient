package com.baidu.swan.apps.al.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes10.dex */
public class a {
    private static volatile a dvw;
    private SensorManager bwC;
    private double[] dvA = new double[3];
    private boolean dvB = false;
    private long dvC = 0;
    private int dvD;
    private SensorEventListener dvx;
    private Sensor dvy;
    private InterfaceC0363a dvz;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.al.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0363a {
        void b(double[] dArr);
    }

    private a() {
    }

    public static a aIJ() {
        if (dvw == null) {
            synchronized (a.class) {
                if (dvw == null) {
                    dvw = new a();
                }
            }
        }
        return dvw;
    }

    public void m(Context context, int i) {
        this.mContext = context;
        this.dvD = i;
    }

    public void a(InterfaceC0363a interfaceC0363a) {
        this.dvz = interfaceC0363a;
    }

    public void aIK() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.dvB) {
            c.w("accelerometer", "has already start");
        } else {
            this.bwC = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.bwC != null) {
                this.dvy = this.bwC.getDefaultSensor(1);
                this.bwC.registerListener(aIN(), this.dvy, 1);
                this.dvB = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void aIL() {
        if (!this.dvB) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.dvx != null && this.bwC != null) {
            this.bwC.unregisterListener(this.dvx);
            this.dvx = null;
        }
        this.bwC = null;
        this.dvy = null;
        this.dvB = false;
    }

    public static void release() {
        if (dvw != null) {
            dvw.aIM();
        }
    }

    private void aIM() {
        c.i("accelerometer", "release");
        if (this.dvB) {
            aIL();
        }
        this.bwC = null;
        this.dvy = null;
        this.dvx = null;
        this.dvA = null;
        this.mContext = null;
        dvw = null;
    }

    private SensorEventListener aIN() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.dvx != null) {
            return this.dvx;
        }
        this.dvx = new SensorEventListener() { // from class: com.baidu.swan.apps.al.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.dvz != null && System.currentTimeMillis() - a.this.dvC > a.this.dvD) {
                            a.this.dvA[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.dvA[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.dvA[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.dvz.b(a.this.dvA);
                            a.this.dvC = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.dvC + "current Acc x : " + a.this.dvA[0] + "current Acc y : " + a.this.dvA[1] + "current Acc z : " + a.this.dvA[2]);
                            return;
                        }
                        return;
                    }
                    c.w("accelerometer", "illegal accelerometer event");
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dvx;
    }
}
