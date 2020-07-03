package com.baidu.swan.apps.am.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes11.dex */
public class a {
    private static volatile a cMj;
    private SensorManager bhI;
    private SensorEventListener cMk;
    private Sensor cMl;
    private InterfaceC0295a cMm;
    private double[] cMn = new double[3];
    private boolean cMo = false;
    private long cMp = 0;
    private int cMq;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.am.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0295a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a atm() {
        if (cMj == null) {
            synchronized (a.class) {
                if (cMj == null) {
                    cMj = new a();
                }
            }
        }
        return cMj;
    }

    public void m(Context context, int i) {
        this.mContext = context;
        this.cMq = i;
    }

    public void a(InterfaceC0295a interfaceC0295a) {
        this.cMm = interfaceC0295a;
    }

    public void atn() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.cMo) {
            c.w("accelerometer", "has already start");
        } else {
            this.bhI = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.bhI != null) {
                this.cMl = this.bhI.getDefaultSensor(1);
                this.bhI.registerListener(atq(), this.cMl, 1);
                this.cMo = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void ato() {
        if (!this.cMo) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.cMk != null && this.bhI != null) {
            this.bhI.unregisterListener(this.cMk);
            this.cMk = null;
        }
        this.bhI = null;
        this.cMl = null;
        this.cMo = false;
    }

    public static void release() {
        if (cMj != null) {
            cMj.atp();
        }
    }

    private void atp() {
        c.i("accelerometer", "release");
        if (this.cMo) {
            ato();
        }
        this.bhI = null;
        this.cMl = null;
        this.cMk = null;
        this.cMn = null;
        this.mContext = null;
        cMj = null;
    }

    private SensorEventListener atq() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.cMk != null) {
            return this.cMk;
        }
        this.cMk = new SensorEventListener() { // from class: com.baidu.swan.apps.am.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.cMm != null && System.currentTimeMillis() - a.this.cMp > a.this.cMq) {
                            a.this.cMn[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.cMn[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.cMn[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.cMm.a(a.this.cMn);
                            a.this.cMp = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.cMp + "current Acc x : " + a.this.cMn[0] + "current Acc y : " + a.this.cMn[1] + "current Acc z : " + a.this.cMn[2]);
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
        return this.cMk;
    }
}
