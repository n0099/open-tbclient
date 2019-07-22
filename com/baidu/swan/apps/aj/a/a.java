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
    private static volatile a aWZ;
    private SensorManager aXa;
    private SensorEventListener aXb;
    private Sensor aXc;
    private InterfaceC0108a aXd;
    private double[] aXe = new double[3];
    private boolean aXf = false;
    private long aXg = 0;
    private int aXh;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aj.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0108a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a On() {
        if (aWZ == null) {
            synchronized (a.class) {
                if (aWZ == null) {
                    aWZ = new a();
                }
            }
        }
        return aWZ;
    }

    public void m(Context context, int i) {
        this.mContext = context;
        this.aXh = i;
    }

    public void a(InterfaceC0108a interfaceC0108a) {
        this.aXd = interfaceC0108a;
    }

    public void Oo() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.aXf) {
            c.w("accelerometer", "has already start");
        } else {
            this.aXa = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aXa != null) {
                this.aXc = this.aXa.getDefaultSensor(1);
                this.aXa.registerListener(Oq(), this.aXc, 1);
                this.aXf = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void Op() {
        if (!this.aXf) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.aXb != null && this.aXa != null) {
            this.aXa.unregisterListener(this.aXb);
            this.aXb = null;
        }
        this.aXa = null;
        this.aXc = null;
        this.aXf = false;
    }

    public static void release() {
        if (aWZ != null) {
            aWZ.BF();
        }
    }

    private void BF() {
        c.i("accelerometer", "release");
        if (this.aXf) {
            Op();
        }
        this.aXa = null;
        this.aXc = null;
        this.aXb = null;
        this.aXe = null;
        this.mContext = null;
        aWZ = null;
    }

    private SensorEventListener Oq() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.aXb != null) {
            return this.aXb;
        }
        this.aXb = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.aXd != null && System.currentTimeMillis() - a.this.aXg > a.this.aXh) {
                            a.this.aXe[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.aXe[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.aXe[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.aXd.a(a.this.aXe);
                            a.this.aXg = System.currentTimeMillis();
                        }
                        if (b.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.aXg + "current Acc x : " + a.this.aXe[0] + "current Acc y : " + a.this.aXe[1] + "current Acc z : " + a.this.aXe[2]);
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
        return this.aXb;
    }
}
