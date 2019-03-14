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
    private static volatile a aTv;
    private double[] aTA = new double[3];
    private boolean aTB = false;
    private long aTC = 0;
    private int aTD;
    private SensorManager aTw;
    private SensorEventListener aTx;
    private Sensor aTy;
    private InterfaceC0110a aTz;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aj.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0110a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a Lb() {
        if (aTv == null) {
            synchronized (a.class) {
                if (aTv == null) {
                    aTv = new a();
                }
            }
        }
        return aTv;
    }

    public void m(Context context, int i) {
        this.mContext = context;
        this.aTD = i;
    }

    public void a(InterfaceC0110a interfaceC0110a) {
        this.aTz = interfaceC0110a;
    }

    public void Lc() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.aTB) {
            c.w("accelerometer", "has already start");
        } else {
            this.aTw = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aTw != null) {
                this.aTy = this.aTw.getDefaultSensor(1);
                this.aTw.registerListener(Le(), this.aTy, 1);
                this.aTB = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void Ld() {
        if (!this.aTB) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.aTx != null && this.aTw != null) {
            this.aTw.unregisterListener(this.aTx);
            this.aTx = null;
        }
        this.aTw = null;
        this.aTy = null;
        this.aTB = false;
    }

    public static void release() {
        if (aTv != null) {
            aTv.zP();
        }
    }

    private void zP() {
        c.i("accelerometer", "release");
        if (this.aTB) {
            Ld();
        }
        this.aTw = null;
        this.aTy = null;
        this.aTx = null;
        this.aTA = null;
        this.mContext = null;
        aTv = null;
    }

    private SensorEventListener Le() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.aTx != null) {
            return this.aTx;
        }
        this.aTx = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.aTz != null && System.currentTimeMillis() - a.this.aTC > a.this.aTD) {
                            a.this.aTA[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.aTA[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.aTA[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.aTz.a(a.this.aTA);
                            a.this.aTC = System.currentTimeMillis();
                        }
                        if (b.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.aTC + "current Acc x : " + a.this.aTA[0] + "current Acc y : " + a.this.aTA[1] + "current Acc z : " + a.this.aTA[2]);
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
        return this.aTx;
    }
}
