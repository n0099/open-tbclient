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
    private static volatile a aTu;
    private int aTC;
    private SensorManager aTv;
    private SensorEventListener aTw;
    private Sensor aTx;
    private InterfaceC0080a aTy;
    private Context mContext;
    private double[] aTz = new double[3];
    private boolean aTA = false;
    private long aTB = 0;

    /* renamed from: com.baidu.swan.apps.aj.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0080a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a Lb() {
        if (aTu == null) {
            synchronized (a.class) {
                if (aTu == null) {
                    aTu = new a();
                }
            }
        }
        return aTu;
    }

    public void m(Context context, int i) {
        this.mContext = context;
        this.aTC = i;
    }

    public void a(InterfaceC0080a interfaceC0080a) {
        this.aTy = interfaceC0080a;
    }

    public void Lc() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.aTA) {
            c.w("accelerometer", "has already start");
        } else {
            this.aTv = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aTv != null) {
                this.aTx = this.aTv.getDefaultSensor(1);
                this.aTv.registerListener(Le(), this.aTx, 1);
                this.aTA = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void Ld() {
        if (!this.aTA) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.aTw != null && this.aTv != null) {
            this.aTv.unregisterListener(this.aTw);
            this.aTw = null;
        }
        this.aTv = null;
        this.aTx = null;
        this.aTA = false;
    }

    public static void release() {
        if (aTu != null) {
            aTu.zP();
        }
    }

    private void zP() {
        c.i("accelerometer", "release");
        if (this.aTA) {
            Ld();
        }
        this.aTv = null;
        this.aTx = null;
        this.aTw = null;
        this.aTz = null;
        this.mContext = null;
        aTu = null;
    }

    private SensorEventListener Le() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.aTw != null) {
            return this.aTw;
        }
        this.aTw = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.aTy != null && System.currentTimeMillis() - a.this.aTB > a.this.aTC) {
                            a.this.aTz[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.aTz[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.aTz[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.aTy.a(a.this.aTz);
                            a.this.aTB = System.currentTimeMillis();
                        }
                        if (b.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.aTB + "current Acc x : " + a.this.aTz[0] + "current Acc y : " + a.this.aTz[1] + "current Acc z : " + a.this.aTz[2]);
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
        return this.aTw;
    }
}
