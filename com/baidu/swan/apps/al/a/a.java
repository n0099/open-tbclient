package com.baidu.swan.apps.al.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes3.dex */
public class a {
    private static volatile a daM;
    private SensorManager bqI;
    private SensorEventListener daN;
    private Sensor daO;
    private InterfaceC0332a daP;
    private double[] daQ = new double[3];
    private boolean daR = false;
    private long daS = 0;
    private int daT;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.al.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0332a {
        void b(double[] dArr);
    }

    private a() {
    }

    public static a aEg() {
        if (daM == null) {
            synchronized (a.class) {
                if (daM == null) {
                    daM = new a();
                }
            }
        }
        return daM;
    }

    public void m(Context context, int i) {
        this.mContext = context;
        this.daT = i;
    }

    public void a(InterfaceC0332a interfaceC0332a) {
        this.daP = interfaceC0332a;
    }

    public void aEh() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.daR) {
            c.w("accelerometer", "has already start");
        } else {
            this.bqI = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.bqI != null) {
                this.daO = this.bqI.getDefaultSensor(1);
                this.bqI.registerListener(aEk(), this.daO, 1);
                this.daR = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void aEi() {
        if (!this.daR) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.daN != null && this.bqI != null) {
            this.bqI.unregisterListener(this.daN);
            this.daN = null;
        }
        this.bqI = null;
        this.daO = null;
        this.daR = false;
    }

    public static void release() {
        if (daM != null) {
            daM.aEj();
        }
    }

    private void aEj() {
        c.i("accelerometer", "release");
        if (this.daR) {
            aEi();
        }
        this.bqI = null;
        this.daO = null;
        this.daN = null;
        this.daQ = null;
        this.mContext = null;
        daM = null;
    }

    private SensorEventListener aEk() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.daN != null) {
            return this.daN;
        }
        this.daN = new SensorEventListener() { // from class: com.baidu.swan.apps.al.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.daP != null && System.currentTimeMillis() - a.this.daS > a.this.daT) {
                            a.this.daQ[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.daQ[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.daQ[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.daP.b(a.this.daQ);
                            a.this.daS = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.daS + "current Acc x : " + a.this.daQ[0] + "current Acc y : " + a.this.daQ[1] + "current Acc z : " + a.this.daQ[2]);
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
        return this.daN;
    }
}
