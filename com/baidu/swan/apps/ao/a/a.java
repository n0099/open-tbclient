package com.baidu.swan.apps.ao.a;

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
    private static volatile a bWB;
    private SensorManager aBy;
    private SensorEventListener bWC;
    private Sensor bWD;
    private InterfaceC0204a bWE;
    private double[] bWF = new double[3];
    private boolean bWG = false;
    private long bWH = 0;
    private int bWI;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.ao.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0204a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a afK() {
        if (bWB == null) {
            synchronized (a.class) {
                if (bWB == null) {
                    bWB = new a();
                }
            }
        }
        return bWB;
    }

    public void init(Context context, int i) {
        this.mContext = context;
        this.bWI = i;
    }

    public void a(InterfaceC0204a interfaceC0204a) {
        this.bWE = interfaceC0204a;
    }

    public void afL() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.bWG) {
            c.w("accelerometer", "has already start");
        } else {
            this.aBy = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aBy != null) {
                this.bWD = this.aBy.getDefaultSensor(1);
                this.aBy.registerListener(afN(), this.bWD, 1);
                this.bWG = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void afM() {
        if (!this.bWG) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.bWC != null && this.aBy != null) {
            this.aBy.unregisterListener(this.bWC);
            this.bWC = null;
        }
        this.aBy = null;
        this.bWD = null;
        this.bWG = false;
    }

    public static void release() {
        if (bWB != null) {
            bWB.PU();
        }
    }

    private void PU() {
        c.i("accelerometer", "release");
        if (this.bWG) {
            afM();
        }
        this.aBy = null;
        this.bWD = null;
        this.bWC = null;
        this.bWF = null;
        this.mContext = null;
        bWB = null;
    }

    private SensorEventListener afN() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.bWC != null) {
            return this.bWC;
        }
        this.bWC = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.bWE != null && System.currentTimeMillis() - a.this.bWH > a.this.bWI) {
                            a.this.bWF[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.bWF[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.bWF[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.bWE.a(a.this.bWF);
                            a.this.bWH = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.bWH + "current Acc x : " + a.this.bWF[0] + "current Acc y : " + a.this.bWF[1] + "current Acc z : " + a.this.bWF[2]);
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
        return this.bWC;
    }
}
