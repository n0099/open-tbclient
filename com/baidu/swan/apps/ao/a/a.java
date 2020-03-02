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
    private static volatile a bWp;
    private SensorManager aBj;
    private SensorEventListener bWq;
    private Sensor bWr;
    private InterfaceC0204a bWs;
    private double[] bWt = new double[3];
    private boolean bWu = false;
    private long bWv = 0;
    private int bWw;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.ao.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0204a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a afH() {
        if (bWp == null) {
            synchronized (a.class) {
                if (bWp == null) {
                    bWp = new a();
                }
            }
        }
        return bWp;
    }

    public void init(Context context, int i) {
        this.mContext = context;
        this.bWw = i;
    }

    public void a(InterfaceC0204a interfaceC0204a) {
        this.bWs = interfaceC0204a;
    }

    public void afI() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.bWu) {
            c.w("accelerometer", "has already start");
        } else {
            this.aBj = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aBj != null) {
                this.bWr = this.aBj.getDefaultSensor(1);
                this.aBj.registerListener(afK(), this.bWr, 1);
                this.bWu = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void afJ() {
        if (!this.bWu) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.bWq != null && this.aBj != null) {
            this.aBj.unregisterListener(this.bWq);
            this.bWq = null;
        }
        this.aBj = null;
        this.bWr = null;
        this.bWu = false;
    }

    public static void release() {
        if (bWp != null) {
            bWp.PR();
        }
    }

    private void PR() {
        c.i("accelerometer", "release");
        if (this.bWu) {
            afJ();
        }
        this.aBj = null;
        this.bWr = null;
        this.bWq = null;
        this.bWt = null;
        this.mContext = null;
        bWp = null;
    }

    private SensorEventListener afK() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.bWq != null) {
            return this.bWq;
        }
        this.bWq = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.bWs != null && System.currentTimeMillis() - a.this.bWv > a.this.bWw) {
                            a.this.bWt[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.bWt[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.bWt[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.bWs.a(a.this.bWt);
                            a.this.bWv = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.bWv + "current Acc x : " + a.this.bWt[0] + "current Acc y : " + a.this.bWt[1] + "current Acc z : " + a.this.bWt[2]);
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
        return this.bWq;
    }
}
