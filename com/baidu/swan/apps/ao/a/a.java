package com.baidu.swan.apps.ao.a;

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
    private static volatile a bRA;
    private SensorManager awg;
    private SensorEventListener bRB;
    private Sensor bRC;
    private InterfaceC0192a bRD;
    private double[] bRE = new double[3];
    private boolean bRF = false;
    private long bRG = 0;
    private int bRH;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.ao.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0192a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a acU() {
        if (bRA == null) {
            synchronized (a.class) {
                if (bRA == null) {
                    bRA = new a();
                }
            }
        }
        return bRA;
    }

    public void init(Context context, int i) {
        this.mContext = context;
        this.bRH = i;
    }

    public void a(InterfaceC0192a interfaceC0192a) {
        this.bRD = interfaceC0192a;
    }

    public void acV() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.bRF) {
            c.w("accelerometer", "has already start");
        } else {
            this.awg = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.awg != null) {
                this.bRC = this.awg.getDefaultSensor(1);
                this.awg.registerListener(acX(), this.bRC, 1);
                this.bRF = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void acW() {
        if (!this.bRF) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.bRB != null && this.awg != null) {
            this.awg.unregisterListener(this.bRB);
            this.bRB = null;
        }
        this.awg = null;
        this.bRC = null;
        this.bRF = false;
    }

    public static void release() {
        if (bRA != null) {
            bRA.Nf();
        }
    }

    private void Nf() {
        c.i("accelerometer", "release");
        if (this.bRF) {
            acW();
        }
        this.awg = null;
        this.bRC = null;
        this.bRB = null;
        this.bRE = null;
        this.mContext = null;
        bRA = null;
    }

    private SensorEventListener acX() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.bRB != null) {
            return this.bRB;
        }
        this.bRB = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.bRD != null && System.currentTimeMillis() - a.this.bRG > a.this.bRH) {
                            a.this.bRE[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.bRE[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.bRE[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.bRD.a(a.this.bRE);
                            a.this.bRG = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.bRG + "current Acc x : " + a.this.bRE[0] + "current Acc y : " + a.this.bRE[1] + "current Acc z : " + a.this.bRE[2]);
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
        return this.bRB;
    }
}
