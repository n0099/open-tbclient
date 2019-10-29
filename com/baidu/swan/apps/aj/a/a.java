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
    private static volatile a bqB;
    private SensorManager aoB;
    private SensorEventListener bqC;
    private Sensor bqD;
    private InterfaceC0154a bqE;
    private double[] bqF = new double[3];
    private boolean bqG = false;
    private long bqH = 0;
    private int bqI;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.aj.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0154a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a Th() {
        if (bqB == null) {
            synchronized (a.class) {
                if (bqB == null) {
                    bqB = new a();
                }
            }
        }
        return bqB;
    }

    public void k(Context context, int i) {
        this.mContext = context;
        this.bqI = i;
    }

    public void a(InterfaceC0154a interfaceC0154a) {
        this.bqE = interfaceC0154a;
    }

    public void Ti() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.bqG) {
            c.w("accelerometer", "has already start");
        } else {
            this.aoB = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aoB != null) {
                this.bqD = this.aoB.getDefaultSensor(1);
                this.aoB.registerListener(Tk(), this.bqD, 1);
                this.bqG = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void Tj() {
        if (!this.bqG) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.bqC != null && this.aoB != null) {
            this.aoB.unregisterListener(this.bqC);
            this.bqC = null;
        }
        this.aoB = null;
        this.bqD = null;
        this.bqG = false;
    }

    public static void release() {
        if (bqB != null) {
            bqB.GD();
        }
    }

    private void GD() {
        c.i("accelerometer", "release");
        if (this.bqG) {
            Tj();
        }
        this.aoB = null;
        this.bqD = null;
        this.bqC = null;
        this.bqF = null;
        this.mContext = null;
        bqB = null;
    }

    private SensorEventListener Tk() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.bqC != null) {
            return this.bqC;
        }
        this.bqC = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.bqE != null && System.currentTimeMillis() - a.this.bqH > a.this.bqI) {
                            a.this.bqF[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.bqF[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.bqF[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.bqE.a(a.this.bqF);
                            a.this.bqH = System.currentTimeMillis();
                        }
                        if (b.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.bqH + "current Acc x : " + a.this.bqF[0] + "current Acc y : " + a.this.bqF[1] + "current Acc z : " + a.this.bqF[2]);
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
        return this.bqC;
    }
}
