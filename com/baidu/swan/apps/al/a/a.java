package com.baidu.swan.apps.al.a;

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
    private static volatile a cYK;
    private SensorManager bnN;
    private SensorEventListener cYL;
    private Sensor cYM;
    private InterfaceC0337a cYN;
    private double[] cYO = new double[3];
    private boolean cYP = false;
    private long cYQ = 0;
    private int cYR;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.al.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0337a {
        void b(double[] dArr);
    }

    private a() {
    }

    public static a aDw() {
        if (cYK == null) {
            synchronized (a.class) {
                if (cYK == null) {
                    cYK = new a();
                }
            }
        }
        return cYK;
    }

    public void m(Context context, int i) {
        this.mContext = context;
        this.cYR = i;
    }

    public void a(InterfaceC0337a interfaceC0337a) {
        this.cYN = interfaceC0337a;
    }

    public void aDx() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.cYP) {
            c.w("accelerometer", "has already start");
        } else {
            this.bnN = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.bnN != null) {
                this.cYM = this.bnN.getDefaultSensor(1);
                this.bnN.registerListener(aDA(), this.cYM, 1);
                this.cYP = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void aDy() {
        if (!this.cYP) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.cYL != null && this.bnN != null) {
            this.bnN.unregisterListener(this.cYL);
            this.cYL = null;
        }
        this.bnN = null;
        this.cYM = null;
        this.cYP = false;
    }

    public static void release() {
        if (cYK != null) {
            cYK.aDz();
        }
    }

    private void aDz() {
        c.i("accelerometer", "release");
        if (this.cYP) {
            aDy();
        }
        this.bnN = null;
        this.cYM = null;
        this.cYL = null;
        this.cYO = null;
        this.mContext = null;
        cYK = null;
    }

    private SensorEventListener aDA() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.cYL != null) {
            return this.cYL;
        }
        this.cYL = new SensorEventListener() { // from class: com.baidu.swan.apps.al.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.cYN != null && System.currentTimeMillis() - a.this.cYQ > a.this.cYR) {
                            a.this.cYO[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.cYO[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.cYO[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.cYN.b(a.this.cYO);
                            a.this.cYQ = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.cYQ + "current Acc x : " + a.this.cYO[0] + "current Acc y : " + a.this.cYO[1] + "current Acc z : " + a.this.cYO[2]);
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
        return this.cYL;
    }
}
