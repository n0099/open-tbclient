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
    private static volatile a aWp;
    private SensorManager aWq;
    private SensorEventListener aWr;
    private Sensor aWs;
    private InterfaceC0111a aWt;
    private double[] aWu = new double[3];
    private boolean aWv = false;
    private long aWw = 0;
    private int aWx;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aj.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0111a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a Ny() {
        if (aWp == null) {
            synchronized (a.class) {
                if (aWp == null) {
                    aWp = new a();
                }
            }
        }
        return aWp;
    }

    public void m(Context context, int i) {
        this.mContext = context;
        this.aWx = i;
    }

    public void a(InterfaceC0111a interfaceC0111a) {
        this.aWt = interfaceC0111a;
    }

    public void Nz() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.aWv) {
            c.w("accelerometer", "has already start");
        } else {
            this.aWq = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aWq != null) {
                this.aWs = this.aWq.getDefaultSensor(1);
                this.aWq.registerListener(NB(), this.aWs, 1);
                this.aWv = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void NA() {
        if (!this.aWv) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.aWr != null && this.aWq != null) {
            this.aWq.unregisterListener(this.aWr);
            this.aWr = null;
        }
        this.aWq = null;
        this.aWs = null;
        this.aWv = false;
    }

    public static void release() {
        if (aWp != null) {
            aWp.AX();
        }
    }

    private void AX() {
        c.i("accelerometer", "release");
        if (this.aWv) {
            NA();
        }
        this.aWq = null;
        this.aWs = null;
        this.aWr = null;
        this.aWu = null;
        this.mContext = null;
        aWp = null;
    }

    private SensorEventListener NB() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.aWr != null) {
            return this.aWr;
        }
        this.aWr = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.aWt != null && System.currentTimeMillis() - a.this.aWw > a.this.aWx) {
                            a.this.aWu[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.aWu[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.aWu[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.aWt.a(a.this.aWu);
                            a.this.aWw = System.currentTimeMillis();
                        }
                        if (b.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.aWw + "current Acc x : " + a.this.aWu[0] + "current Acc y : " + a.this.aWu[1] + "current Acc z : " + a.this.aWu[2]);
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
        return this.aWr;
    }
}
