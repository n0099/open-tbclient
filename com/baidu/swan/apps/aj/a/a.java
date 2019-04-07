package com.baidu.swan.apps.aj.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.baidu.swan.apps.ae.b;
import com.baidu.swan.apps.console.c;
/* loaded from: classes2.dex */
public class a {
    private static volatile a aTy;
    private SensorEventListener aTA;
    private Sensor aTB;
    private InterfaceC0110a aTC;
    private double[] aTD = new double[3];
    private boolean aTE = false;
    private long aTF = 0;
    private int aTG;
    private SensorManager aTz;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aj.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0110a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a KZ() {
        if (aTy == null) {
            synchronized (a.class) {
                if (aTy == null) {
                    aTy = new a();
                }
            }
        }
        return aTy;
    }

    public void m(Context context, int i) {
        this.mContext = context;
        this.aTG = i;
    }

    public void a(InterfaceC0110a interfaceC0110a) {
        this.aTC = interfaceC0110a;
    }

    public void La() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.aTE) {
            c.w("accelerometer", "has already start");
        } else {
            this.aTz = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aTz != null) {
                this.aTB = this.aTz.getDefaultSensor(1);
                this.aTz.registerListener(Lc(), this.aTB, 1);
                this.aTE = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void Lb() {
        if (!this.aTE) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.aTA != null && this.aTz != null) {
            this.aTz.unregisterListener(this.aTA);
            this.aTA = null;
        }
        this.aTz = null;
        this.aTB = null;
        this.aTE = false;
    }

    public static void release() {
        if (aTy != null) {
            aTy.zO();
        }
    }

    private void zO() {
        c.i("accelerometer", "release");
        if (this.aTE) {
            Lb();
        }
        this.aTz = null;
        this.aTB = null;
        this.aTA = null;
        this.aTD = null;
        this.mContext = null;
        aTy = null;
    }

    private SensorEventListener Lc() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.aTA != null) {
            return this.aTA;
        }
        this.aTA = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.aTC != null && System.currentTimeMillis() - a.this.aTF > a.this.aTG) {
                            a.this.aTD[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.aTD[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.aTD[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.aTC.a(a.this.aTD);
                            a.this.aTF = System.currentTimeMillis();
                        }
                        if (b.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.aTF + "current Acc x : " + a.this.aTD[0] + "current Acc y : " + a.this.aTD[1] + "current Acc z : " + a.this.aTD[2]);
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
        return this.aTA;
    }
}
