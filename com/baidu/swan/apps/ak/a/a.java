package com.baidu.swan.apps.ak.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes8.dex */
public class a {
    private static volatile a dOd;
    private SensorEventListener dOe;
    private Sensor dOf;
    private InterfaceC0363a dOg;
    private double[] dOh = new double[3];
    private boolean dOi = false;
    private long dOj = 0;
    private int dOk;
    private Context mContext;
    private SensorManager mSensorManager;

    /* renamed from: com.baidu.swan.apps.ak.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0363a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a aMB() {
        if (dOd == null) {
            synchronized (a.class) {
                if (dOd == null) {
                    dOd = new a();
                }
            }
        }
        return dOd;
    }

    public void w(Context context, int i) {
        this.mContext = context;
        this.dOk = i;
    }

    public void a(InterfaceC0363a interfaceC0363a) {
        this.dOg = interfaceC0363a;
    }

    public void aMC() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.dOi) {
            c.w("accelerometer", "has already start");
        } else {
            this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.mSensorManager != null) {
                this.dOf = this.mSensorManager.getDefaultSensor(1);
                this.mSensorManager.registerListener(aMF(), this.dOf, 1);
                this.dOi = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void aMD() {
        if (!this.dOi) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.dOe != null && this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.dOe);
            this.dOe = null;
        }
        this.mSensorManager = null;
        this.dOf = null;
        this.dOi = false;
    }

    public static void release() {
        if (dOd != null) {
            dOd.aME();
        }
    }

    private void aME() {
        c.i("accelerometer", "release");
        if (this.dOi) {
            aMD();
        }
        this.mSensorManager = null;
        this.dOf = null;
        this.dOe = null;
        this.dOh = null;
        this.mContext = null;
        dOd = null;
    }

    private SensorEventListener aMF() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.dOe != null) {
            return this.dOe;
        }
        this.dOe = new SensorEventListener() { // from class: com.baidu.swan.apps.ak.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.dOg != null && System.currentTimeMillis() - a.this.dOj > a.this.dOk) {
                            a.this.dOh[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.dOh[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.dOh[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.dOg.a(a.this.dOh);
                            a.this.dOj = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.dOj + "current Acc x : " + a.this.dOh[0] + "current Acc y : " + a.this.dOh[1] + "current Acc z : " + a.this.dOh[2]);
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
        return this.dOe;
    }
}
