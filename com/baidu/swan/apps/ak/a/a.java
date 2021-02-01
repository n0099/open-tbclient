package com.baidu.swan.apps.ak.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes9.dex */
public class a {
    private static volatile a dMC;
    private SensorEventListener dMD;
    private Sensor dME;
    private InterfaceC0357a dMF;
    private double[] dMG = new double[3];
    private boolean dMH = false;
    private long dMI = 0;
    private int dMJ;
    private Context mContext;
    private SensorManager mSensorManager;

    /* renamed from: com.baidu.swan.apps.ak.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0357a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a aMy() {
        if (dMC == null) {
            synchronized (a.class) {
                if (dMC == null) {
                    dMC = new a();
                }
            }
        }
        return dMC;
    }

    public void w(Context context, int i) {
        this.mContext = context;
        this.dMJ = i;
    }

    public void a(InterfaceC0357a interfaceC0357a) {
        this.dMF = interfaceC0357a;
    }

    public void aMz() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.dMH) {
            c.w("accelerometer", "has already start");
        } else {
            this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.mSensorManager != null) {
                this.dME = this.mSensorManager.getDefaultSensor(1);
                this.mSensorManager.registerListener(aMC(), this.dME, 1);
                this.dMH = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void aMA() {
        if (!this.dMH) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.dMD != null && this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.dMD);
            this.dMD = null;
        }
        this.mSensorManager = null;
        this.dME = null;
        this.dMH = false;
    }

    public static void release() {
        if (dMC != null) {
            dMC.aMB();
        }
    }

    private void aMB() {
        c.i("accelerometer", "release");
        if (this.dMH) {
            aMA();
        }
        this.mSensorManager = null;
        this.dME = null;
        this.dMD = null;
        this.dMG = null;
        this.mContext = null;
        dMC = null;
    }

    private SensorEventListener aMC() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.dMD != null) {
            return this.dMD;
        }
        this.dMD = new SensorEventListener() { // from class: com.baidu.swan.apps.ak.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.dMF != null && System.currentTimeMillis() - a.this.dMI > a.this.dMJ) {
                            a.this.dMG[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.dMG[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.dMG[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.dMF.a(a.this.dMG);
                            a.this.dMI = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.dMI + "current Acc x : " + a.this.dMG[0] + "current Acc y : " + a.this.dMG[1] + "current Acc z : " + a.this.dMG[2]);
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
        return this.dMD;
    }
}
