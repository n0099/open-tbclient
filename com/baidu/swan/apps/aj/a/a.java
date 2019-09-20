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
    private static volatile a aXx;
    private Sensor aXA;
    private InterfaceC0122a aXB;
    private double[] aXC = new double[3];
    private boolean aXD = false;
    private long aXE = 0;
    private int aXF;
    private SensorManager aXy;
    private SensorEventListener aXz;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aj.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0122a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a Or() {
        if (aXx == null) {
            synchronized (a.class) {
                if (aXx == null) {
                    aXx = new a();
                }
            }
        }
        return aXx;
    }

    public void m(Context context, int i) {
        this.mContext = context;
        this.aXF = i;
    }

    public void a(InterfaceC0122a interfaceC0122a) {
        this.aXB = interfaceC0122a;
    }

    public void Os() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.aXD) {
            c.w("accelerometer", "has already start");
        } else {
            this.aXy = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aXy != null) {
                this.aXA = this.aXy.getDefaultSensor(1);
                this.aXy.registerListener(Ou(), this.aXA, 1);
                this.aXD = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void Ot() {
        if (!this.aXD) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.aXz != null && this.aXy != null) {
            this.aXy.unregisterListener(this.aXz);
            this.aXz = null;
        }
        this.aXy = null;
        this.aXA = null;
        this.aXD = false;
    }

    public static void release() {
        if (aXx != null) {
            aXx.BJ();
        }
    }

    private void BJ() {
        c.i("accelerometer", "release");
        if (this.aXD) {
            Ot();
        }
        this.aXy = null;
        this.aXA = null;
        this.aXz = null;
        this.aXC = null;
        this.mContext = null;
        aXx = null;
    }

    private SensorEventListener Ou() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.aXz != null) {
            return this.aXz;
        }
        this.aXz = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.aXB != null && System.currentTimeMillis() - a.this.aXE > a.this.aXF) {
                            a.this.aXC[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.aXC[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.aXC[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.aXB.a(a.this.aXC);
                            a.this.aXE = System.currentTimeMillis();
                        }
                        if (b.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.aXE + "current Acc x : " + a.this.aXC[0] + "current Acc y : " + a.this.aXC[1] + "current Acc z : " + a.this.aXC[2]);
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
        return this.aXz;
    }
}
