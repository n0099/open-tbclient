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
    private static volatile a cHz;
    private SensorManager bcy;
    private SensorEventListener cHA;
    private Sensor cHB;
    private InterfaceC0289a cHC;
    private double[] cHD = new double[3];
    private boolean cHE = false;
    private long cHF = 0;
    private int cHG;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.am.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0289a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a asf() {
        if (cHz == null) {
            synchronized (a.class) {
                if (cHz == null) {
                    cHz = new a();
                }
            }
        }
        return cHz;
    }

    public void m(Context context, int i) {
        this.mContext = context;
        this.cHG = i;
    }

    public void a(InterfaceC0289a interfaceC0289a) {
        this.cHC = interfaceC0289a;
    }

    public void asg() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.cHE) {
            c.w("accelerometer", "has already start");
        } else {
            this.bcy = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.bcy != null) {
                this.cHB = this.bcy.getDefaultSensor(1);
                this.bcy.registerListener(asj(), this.cHB, 1);
                this.cHE = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void ash() {
        if (!this.cHE) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.cHA != null && this.bcy != null) {
            this.bcy.unregisterListener(this.cHA);
            this.cHA = null;
        }
        this.bcy = null;
        this.cHB = null;
        this.cHE = false;
    }

    public static void release() {
        if (cHz != null) {
            cHz.asi();
        }
    }

    private void asi() {
        c.i("accelerometer", "release");
        if (this.cHE) {
            ash();
        }
        this.bcy = null;
        this.cHB = null;
        this.cHA = null;
        this.cHD = null;
        this.mContext = null;
        cHz = null;
    }

    private SensorEventListener asj() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.cHA != null) {
            return this.cHA;
        }
        this.cHA = new SensorEventListener() { // from class: com.baidu.swan.apps.am.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.cHC != null && System.currentTimeMillis() - a.this.cHF > a.this.cHG) {
                            a.this.cHD[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.cHD[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.cHD[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.cHC.a(a.this.cHD);
                            a.this.cHF = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.cHF + "current Acc x : " + a.this.cHD[0] + "current Acc y : " + a.this.cHD[1] + "current Acc z : " + a.this.cHD[2]);
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
        return this.cHA;
    }
}
