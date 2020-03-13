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
    private static volatile a bWq;
    private SensorManager aBk;
    private SensorEventListener bWr;
    private Sensor bWs;
    private InterfaceC0204a bWt;
    private double[] bWu = new double[3];
    private boolean bWv = false;
    private long bWw = 0;
    private int bWx;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.ao.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0204a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a afH() {
        if (bWq == null) {
            synchronized (a.class) {
                if (bWq == null) {
                    bWq = new a();
                }
            }
        }
        return bWq;
    }

    public void init(Context context, int i) {
        this.mContext = context;
        this.bWx = i;
    }

    public void a(InterfaceC0204a interfaceC0204a) {
        this.bWt = interfaceC0204a;
    }

    public void afI() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.bWv) {
            c.w("accelerometer", "has already start");
        } else {
            this.aBk = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aBk != null) {
                this.bWs = this.aBk.getDefaultSensor(1);
                this.aBk.registerListener(afK(), this.bWs, 1);
                this.bWv = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void afJ() {
        if (!this.bWv) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.bWr != null && this.aBk != null) {
            this.aBk.unregisterListener(this.bWr);
            this.bWr = null;
        }
        this.aBk = null;
        this.bWs = null;
        this.bWv = false;
    }

    public static void release() {
        if (bWq != null) {
            bWq.PR();
        }
    }

    private void PR() {
        c.i("accelerometer", "release");
        if (this.bWv) {
            afJ();
        }
        this.aBk = null;
        this.bWs = null;
        this.bWr = null;
        this.bWu = null;
        this.mContext = null;
        bWq = null;
    }

    private SensorEventListener afK() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.bWr != null) {
            return this.bWr;
        }
        this.bWr = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.bWt != null && System.currentTimeMillis() - a.this.bWw > a.this.bWx) {
                            a.this.bWu[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.bWu[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.bWu[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.bWt.a(a.this.bWu);
                            a.this.bWw = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.bWw + "current Acc x : " + a.this.bWu[0] + "current Acc y : " + a.this.bWu[1] + "current Acc z : " + a.this.bWu[2]);
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
        return this.bWr;
    }
}
