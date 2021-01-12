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
    private static volatile a dKy;
    private Sensor dKA;
    private InterfaceC0360a dKB;
    private double[] dKC = new double[3];
    private boolean dKD = false;
    private long dKE = 0;
    private int dKF;
    private SensorEventListener dKz;
    private Context mContext;
    private SensorManager mSensorManager;

    /* renamed from: com.baidu.swan.apps.ak.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0360a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a aMf() {
        if (dKy == null) {
            synchronized (a.class) {
                if (dKy == null) {
                    dKy = new a();
                }
            }
        }
        return dKy;
    }

    public void w(Context context, int i) {
        this.mContext = context;
        this.dKF = i;
    }

    public void a(InterfaceC0360a interfaceC0360a) {
        this.dKB = interfaceC0360a;
    }

    public void aMg() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.dKD) {
            c.w("accelerometer", "has already start");
        } else {
            this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.mSensorManager != null) {
                this.dKA = this.mSensorManager.getDefaultSensor(1);
                this.mSensorManager.registerListener(aMj(), this.dKA, 1);
                this.dKD = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void aMh() {
        if (!this.dKD) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.dKz != null && this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.dKz);
            this.dKz = null;
        }
        this.mSensorManager = null;
        this.dKA = null;
        this.dKD = false;
    }

    public static void release() {
        if (dKy != null) {
            dKy.aMi();
        }
    }

    private void aMi() {
        c.i("accelerometer", "release");
        if (this.dKD) {
            aMh();
        }
        this.mSensorManager = null;
        this.dKA = null;
        this.dKz = null;
        this.dKC = null;
        this.mContext = null;
        dKy = null;
    }

    private SensorEventListener aMj() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.dKz != null) {
            return this.dKz;
        }
        this.dKz = new SensorEventListener() { // from class: com.baidu.swan.apps.ak.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.dKB != null && System.currentTimeMillis() - a.this.dKE > a.this.dKF) {
                            a.this.dKC[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.dKC[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.dKC[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.dKB.a(a.this.dKC);
                            a.this.dKE = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.dKE + "current Acc x : " + a.this.dKC[0] + "current Acc y : " + a.this.dKC[1] + "current Acc z : " + a.this.dKC[2]);
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
        return this.dKz;
    }
}
