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
    private static volatile a dmU;
    private SensorManager buw;
    private SensorEventListener dmV;
    private Sensor dmW;
    private InterfaceC0349a dmX;
    private double[] dmY = new double[3];
    private boolean dmZ = false;
    private long dna = 0;
    private int dnb;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.al.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0349a {
        void b(double[] dArr);
    }

    private a() {
    }

    public static a aGP() {
        if (dmU == null) {
            synchronized (a.class) {
                if (dmU == null) {
                    dmU = new a();
                }
            }
        }
        return dmU;
    }

    public void m(Context context, int i) {
        this.mContext = context;
        this.dnb = i;
    }

    public void a(InterfaceC0349a interfaceC0349a) {
        this.dmX = interfaceC0349a;
    }

    public void aGQ() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.dmZ) {
            c.w("accelerometer", "has already start");
        } else {
            this.buw = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.buw != null) {
                this.dmW = this.buw.getDefaultSensor(1);
                this.buw.registerListener(aGT(), this.dmW, 1);
                this.dmZ = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void aGR() {
        if (!this.dmZ) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.dmV != null && this.buw != null) {
            this.buw.unregisterListener(this.dmV);
            this.dmV = null;
        }
        this.buw = null;
        this.dmW = null;
        this.dmZ = false;
    }

    public static void release() {
        if (dmU != null) {
            dmU.aGS();
        }
    }

    private void aGS() {
        c.i("accelerometer", "release");
        if (this.dmZ) {
            aGR();
        }
        this.buw = null;
        this.dmW = null;
        this.dmV = null;
        this.dmY = null;
        this.mContext = null;
        dmU = null;
    }

    private SensorEventListener aGT() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.dmV != null) {
            return this.dmV;
        }
        this.dmV = new SensorEventListener() { // from class: com.baidu.swan.apps.al.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.dmX != null && System.currentTimeMillis() - a.this.dna > a.this.dnb) {
                            a.this.dmY[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.dmY[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.dmY[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.dmX.b(a.this.dmY);
                            a.this.dna = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.dna + "current Acc x : " + a.this.dmY[0] + "current Acc y : " + a.this.dmY[1] + "current Acc z : " + a.this.dmY[2]);
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
        return this.dmV;
    }
}
