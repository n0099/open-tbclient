package com.baidu.swan.apps.ao.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class a {
    private static volatile a cvy;
    private SensorManager aVk;
    private Sensor cvA;
    private InterfaceC0255a cvB;
    private double[] cvC = new double[3];
    private boolean cvD = false;
    private long cvE = 0;
    private int cvF;
    private SensorEventListener cvz;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.ao.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0255a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a anO() {
        if (cvy == null) {
            synchronized (a.class) {
                if (cvy == null) {
                    cvy = new a();
                }
            }
        }
        return cvy;
    }

    public void m(Context context, int i) {
        this.mContext = context;
        this.cvF = i;
    }

    public void a(InterfaceC0255a interfaceC0255a) {
        this.cvB = interfaceC0255a;
    }

    public void anP() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.cvD) {
            c.w("accelerometer", "has already start");
        } else {
            this.aVk = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aVk != null) {
                this.cvA = this.aVk.getDefaultSensor(1);
                this.aVk.registerListener(anR(), this.cvA, 1);
                this.cvD = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void anQ() {
        if (!this.cvD) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.cvz != null && this.aVk != null) {
            this.aVk.unregisterListener(this.cvz);
            this.cvz = null;
        }
        this.aVk = null;
        this.cvA = null;
        this.cvD = false;
    }

    public static void release() {
        if (cvy != null) {
            cvy.XI();
        }
    }

    private void XI() {
        c.i("accelerometer", "release");
        if (this.cvD) {
            anQ();
        }
        this.aVk = null;
        this.cvA = null;
        this.cvz = null;
        this.cvC = null;
        this.mContext = null;
        cvy = null;
    }

    private SensorEventListener anR() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.cvz != null) {
            return this.cvz;
        }
        this.cvz = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.cvB != null && System.currentTimeMillis() - a.this.cvE > a.this.cvF) {
                            a.this.cvC[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.cvC[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.cvC[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.cvB.a(a.this.cvC);
                            a.this.cvE = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.cvE + "current Acc x : " + a.this.cvC[0] + "current Acc y : " + a.this.cvC[1] + "current Acc z : " + a.this.cvC[2]);
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
        return this.cvz;
    }
}
