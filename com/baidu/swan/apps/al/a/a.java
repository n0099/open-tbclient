package com.baidu.swan.apps.al.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes25.dex */
public class a {
    private static volatile a dGG;
    private SensorManager bGk;
    private SensorEventListener dGH;
    private Sensor dGI;
    private InterfaceC0385a dGJ;
    private double[] dGK = new double[3];
    private boolean dGL = false;
    private long dGM = 0;
    private int dGN;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.al.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0385a {
        void b(double[] dArr);
    }

    private a() {
    }

    public static a aNI() {
        if (dGG == null) {
            synchronized (a.class) {
                if (dGG == null) {
                    dGG = new a();
                }
            }
        }
        return dGG;
    }

    public void v(Context context, int i) {
        this.mContext = context;
        this.dGN = i;
    }

    public void a(InterfaceC0385a interfaceC0385a) {
        this.dGJ = interfaceC0385a;
    }

    public void aNJ() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.dGL) {
            c.w("accelerometer", "has already start");
        } else {
            this.bGk = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.bGk != null) {
                this.dGI = this.bGk.getDefaultSensor(1);
                this.bGk.registerListener(aNM(), this.dGI, 1);
                this.dGL = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void aNK() {
        if (!this.dGL) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.dGH != null && this.bGk != null) {
            this.bGk.unregisterListener(this.dGH);
            this.dGH = null;
        }
        this.bGk = null;
        this.dGI = null;
        this.dGL = false;
    }

    public static void release() {
        if (dGG != null) {
            dGG.aNL();
        }
    }

    private void aNL() {
        c.i("accelerometer", "release");
        if (this.dGL) {
            aNK();
        }
        this.bGk = null;
        this.dGI = null;
        this.dGH = null;
        this.dGK = null;
        this.mContext = null;
        dGG = null;
    }

    private SensorEventListener aNM() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.dGH != null) {
            return this.dGH;
        }
        this.dGH = new SensorEventListener() { // from class: com.baidu.swan.apps.al.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.dGJ != null && System.currentTimeMillis() - a.this.dGM > a.this.dGN) {
                            a.this.dGK[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.dGK[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.dGK[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.dGJ.b(a.this.dGK);
                            a.this.dGM = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.dGM + "current Acc x : " + a.this.dGK[0] + "current Acc y : " + a.this.dGK[1] + "current Acc z : " + a.this.dGK[2]);
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
        return this.dGH;
    }
}
