package com.baidu.swan.apps.ak.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes9.dex */
public class a {
    private static volatile a dPk;
    private SensorEventListener dPl;
    private Sensor dPm;
    private InterfaceC0377a dPn;
    private double[] dPo = new double[3];
    private boolean dPp = false;
    private long dPq = 0;
    private int dPr;
    private Context mContext;
    private SensorManager mSensorManager;

    /* renamed from: com.baidu.swan.apps.ak.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0377a {
        void b(double[] dArr);
    }

    private a() {
    }

    public static a aPZ() {
        if (dPk == null) {
            synchronized (a.class) {
                if (dPk == null) {
                    dPk = new a();
                }
            }
        }
        return dPk;
    }

    public void w(Context context, int i) {
        this.mContext = context;
        this.dPr = i;
    }

    public void a(InterfaceC0377a interfaceC0377a) {
        this.dPn = interfaceC0377a;
    }

    public void aQa() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.dPp) {
            c.w("accelerometer", "has already start");
        } else {
            this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.mSensorManager != null) {
                this.dPm = this.mSensorManager.getDefaultSensor(1);
                this.mSensorManager.registerListener(aQd(), this.dPm, 1);
                this.dPp = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void aQb() {
        if (!this.dPp) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.dPl != null && this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.dPl);
            this.dPl = null;
        }
        this.mSensorManager = null;
        this.dPm = null;
        this.dPp = false;
    }

    public static void release() {
        if (dPk != null) {
            dPk.aQc();
        }
    }

    private void aQc() {
        c.i("accelerometer", "release");
        if (this.dPp) {
            aQb();
        }
        this.mSensorManager = null;
        this.dPm = null;
        this.dPl = null;
        this.dPo = null;
        this.mContext = null;
        dPk = null;
    }

    private SensorEventListener aQd() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.dPl != null) {
            return this.dPl;
        }
        this.dPl = new SensorEventListener() { // from class: com.baidu.swan.apps.ak.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.dPn != null && System.currentTimeMillis() - a.this.dPq > a.this.dPr) {
                            a.this.dPo[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.dPo[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.dPo[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.dPn.b(a.this.dPo);
                            a.this.dPq = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.dPq + "current Acc x : " + a.this.dPo[0] + "current Acc y : " + a.this.dPo[1] + "current Acc z : " + a.this.dPo[2]);
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
        return this.dPl;
    }
}
