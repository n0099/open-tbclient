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
    private static volatile a dBo;
    private SensorManager bCN;
    private SensorEventListener dBp;
    private Sensor dBq;
    private InterfaceC0375a dBr;
    private double[] dBs = new double[3];
    private boolean dBt = false;
    private long dBu = 0;
    private int dBv;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.al.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0375a {
        void b(double[] dArr);
    }

    private a() {
    }

    public static a aLj() {
        if (dBo == null) {
            synchronized (a.class) {
                if (dBo == null) {
                    dBo = new a();
                }
            }
        }
        return dBo;
    }

    public void m(Context context, int i) {
        this.mContext = context;
        this.dBv = i;
    }

    public void a(InterfaceC0375a interfaceC0375a) {
        this.dBr = interfaceC0375a;
    }

    public void aLk() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.dBt) {
            c.w("accelerometer", "has already start");
        } else {
            this.bCN = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.bCN != null) {
                this.dBq = this.bCN.getDefaultSensor(1);
                this.bCN.registerListener(aLn(), this.dBq, 1);
                this.dBt = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void aLl() {
        if (!this.dBt) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.dBp != null && this.bCN != null) {
            this.bCN.unregisterListener(this.dBp);
            this.dBp = null;
        }
        this.bCN = null;
        this.dBq = null;
        this.dBt = false;
    }

    public static void release() {
        if (dBo != null) {
            dBo.aLm();
        }
    }

    private void aLm() {
        c.i("accelerometer", "release");
        if (this.dBt) {
            aLl();
        }
        this.bCN = null;
        this.dBq = null;
        this.dBp = null;
        this.dBs = null;
        this.mContext = null;
        dBo = null;
    }

    private SensorEventListener aLn() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.dBp != null) {
            return this.dBp;
        }
        this.dBp = new SensorEventListener() { // from class: com.baidu.swan.apps.al.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.dBr != null && System.currentTimeMillis() - a.this.dBu > a.this.dBv) {
                            a.this.dBs[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.dBs[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.dBs[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.dBr.b(a.this.dBs);
                            a.this.dBu = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.dBu + "current Acc x : " + a.this.dBs[0] + "current Acc y : " + a.this.dBs[1] + "current Acc z : " + a.this.dBs[2]);
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
        return this.dBp;
    }
}
