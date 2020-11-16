package com.baidu.swan.apps.al.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes7.dex */
public class a {
    private static volatile a dzH;
    private SensorManager bBc;
    private SensorEventListener dzI;
    private Sensor dzJ;
    private InterfaceC0373a dzK;
    private double[] dzL = new double[3];
    private boolean dzM = false;
    private long dzN = 0;
    private int dzO;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.al.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0373a {
        void b(double[] dArr);
    }

    private a() {
    }

    public static a aKB() {
        if (dzH == null) {
            synchronized (a.class) {
                if (dzH == null) {
                    dzH = new a();
                }
            }
        }
        return dzH;
    }

    public void m(Context context, int i) {
        this.mContext = context;
        this.dzO = i;
    }

    public void a(InterfaceC0373a interfaceC0373a) {
        this.dzK = interfaceC0373a;
    }

    public void aKC() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.dzM) {
            c.w("accelerometer", "has already start");
        } else {
            this.bBc = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.bBc != null) {
                this.dzJ = this.bBc.getDefaultSensor(1);
                this.bBc.registerListener(aKF(), this.dzJ, 1);
                this.dzM = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void aKD() {
        if (!this.dzM) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.dzI != null && this.bBc != null) {
            this.bBc.unregisterListener(this.dzI);
            this.dzI = null;
        }
        this.bBc = null;
        this.dzJ = null;
        this.dzM = false;
    }

    public static void release() {
        if (dzH != null) {
            dzH.aKE();
        }
    }

    private void aKE() {
        c.i("accelerometer", "release");
        if (this.dzM) {
            aKD();
        }
        this.bBc = null;
        this.dzJ = null;
        this.dzI = null;
        this.dzL = null;
        this.mContext = null;
        dzH = null;
    }

    private SensorEventListener aKF() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.dzI != null) {
            return this.dzI;
        }
        this.dzI = new SensorEventListener() { // from class: com.baidu.swan.apps.al.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.dzK != null && System.currentTimeMillis() - a.this.dzN > a.this.dzO) {
                            a.this.dzL[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.dzL[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.dzL[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.dzK.b(a.this.dzL);
                            a.this.dzN = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.dzN + "current Acc x : " + a.this.dzL[0] + "current Acc y : " + a.this.dzL[1] + "current Acc z : " + a.this.dzL[2]);
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
        return this.dzI;
    }
}
