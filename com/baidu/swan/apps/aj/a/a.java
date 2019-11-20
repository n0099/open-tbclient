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
    private static volatile a bqj;
    private SensorManager aoj;
    private SensorEventListener bqk;
    private Sensor bql;
    private InterfaceC0154a bqm;
    private double[] bqn = new double[3];
    private boolean bqo = false;
    private long bqp = 0;
    private int bqq;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aj.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0154a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a Tj() {
        if (bqj == null) {
            synchronized (a.class) {
                if (bqj == null) {
                    bqj = new a();
                }
            }
        }
        return bqj;
    }

    public void k(Context context, int i) {
        this.mContext = context;
        this.bqq = i;
    }

    public void a(InterfaceC0154a interfaceC0154a) {
        this.bqm = interfaceC0154a;
    }

    public void Tk() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.bqo) {
            c.w("accelerometer", "has already start");
        } else {
            this.aoj = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aoj != null) {
                this.bql = this.aoj.getDefaultSensor(1);
                this.aoj.registerListener(Tm(), this.bql, 1);
                this.bqo = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void Tl() {
        if (!this.bqo) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.bqk != null && this.aoj != null) {
            this.aoj.unregisterListener(this.bqk);
            this.bqk = null;
        }
        this.aoj = null;
        this.bql = null;
        this.bqo = false;
    }

    public static void release() {
        if (bqj != null) {
            bqj.GE();
        }
    }

    private void GE() {
        c.i("accelerometer", "release");
        if (this.bqo) {
            Tl();
        }
        this.aoj = null;
        this.bql = null;
        this.bqk = null;
        this.bqn = null;
        this.mContext = null;
        bqj = null;
    }

    private SensorEventListener Tm() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.bqk != null) {
            return this.bqk;
        }
        this.bqk = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.bqm != null && System.currentTimeMillis() - a.this.bqp > a.this.bqq) {
                            a.this.bqn[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.bqn[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.bqn[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.bqm.a(a.this.bqn);
                            a.this.bqp = System.currentTimeMillis();
                        }
                        if (b.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.bqp + "current Acc x : " + a.this.bqn[0] + "current Acc y : " + a.this.bqn[1] + "current Acc z : " + a.this.bqn[2]);
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
        return this.bqk;
    }
}
