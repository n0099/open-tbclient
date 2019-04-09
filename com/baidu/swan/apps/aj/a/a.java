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
    private static volatile a aTz;
    private SensorManager aTA;
    private SensorEventListener aTB;
    private Sensor aTC;
    private InterfaceC0110a aTD;
    private double[] aTE = new double[3];
    private boolean aTF = false;
    private long aTG = 0;
    private int aTH;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aj.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0110a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a KZ() {
        if (aTz == null) {
            synchronized (a.class) {
                if (aTz == null) {
                    aTz = new a();
                }
            }
        }
        return aTz;
    }

    public void m(Context context, int i) {
        this.mContext = context;
        this.aTH = i;
    }

    public void a(InterfaceC0110a interfaceC0110a) {
        this.aTD = interfaceC0110a;
    }

    public void La() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.aTF) {
            c.w("accelerometer", "has already start");
        } else {
            this.aTA = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aTA != null) {
                this.aTC = this.aTA.getDefaultSensor(1);
                this.aTA.registerListener(Lc(), this.aTC, 1);
                this.aTF = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void Lb() {
        if (!this.aTF) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.aTB != null && this.aTA != null) {
            this.aTA.unregisterListener(this.aTB);
            this.aTB = null;
        }
        this.aTA = null;
        this.aTC = null;
        this.aTF = false;
    }

    public static void release() {
        if (aTz != null) {
            aTz.zO();
        }
    }

    private void zO() {
        c.i("accelerometer", "release");
        if (this.aTF) {
            Lb();
        }
        this.aTA = null;
        this.aTC = null;
        this.aTB = null;
        this.aTE = null;
        this.mContext = null;
        aTz = null;
    }

    private SensorEventListener Lc() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.aTB != null) {
            return this.aTB;
        }
        this.aTB = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.aTD != null && System.currentTimeMillis() - a.this.aTG > a.this.aTH) {
                            a.this.aTE[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.aTE[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.aTE[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.aTD.a(a.this.aTE);
                            a.this.aTG = System.currentTimeMillis();
                        }
                        if (b.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.aTG + "current Acc x : " + a.this.aTE[0] + "current Acc y : " + a.this.aTE[1] + "current Acc z : " + a.this.aTE[2]);
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
        return this.aTB;
    }
}
