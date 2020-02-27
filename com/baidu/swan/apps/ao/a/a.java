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
    private static volatile a bWo;
    private SensorManager aBi;
    private SensorEventListener bWp;
    private Sensor bWq;
    private InterfaceC0204a bWr;
    private double[] bWs = new double[3];
    private boolean bWt = false;
    private long bWu = 0;
    private int bWv;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.ao.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0204a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a afF() {
        if (bWo == null) {
            synchronized (a.class) {
                if (bWo == null) {
                    bWo = new a();
                }
            }
        }
        return bWo;
    }

    public void init(Context context, int i) {
        this.mContext = context;
        this.bWv = i;
    }

    public void a(InterfaceC0204a interfaceC0204a) {
        this.bWr = interfaceC0204a;
    }

    public void afG() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.bWt) {
            c.w("accelerometer", "has already start");
        } else {
            this.aBi = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aBi != null) {
                this.bWq = this.aBi.getDefaultSensor(1);
                this.aBi.registerListener(afI(), this.bWq, 1);
                this.bWt = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void afH() {
        if (!this.bWt) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.bWp != null && this.aBi != null) {
            this.aBi.unregisterListener(this.bWp);
            this.bWp = null;
        }
        this.aBi = null;
        this.bWq = null;
        this.bWt = false;
    }

    public static void release() {
        if (bWo != null) {
            bWo.PP();
        }
    }

    private void PP() {
        c.i("accelerometer", "release");
        if (this.bWt) {
            afH();
        }
        this.aBi = null;
        this.bWq = null;
        this.bWp = null;
        this.bWs = null;
        this.mContext = null;
        bWo = null;
    }

    private SensorEventListener afI() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.bWp != null) {
            return this.bWp;
        }
        this.bWp = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.bWr != null && System.currentTimeMillis() - a.this.bWu > a.this.bWv) {
                            a.this.bWs[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.bWs[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.bWs[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.bWr.a(a.this.bWs);
                            a.this.bWu = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.bWu + "current Acc x : " + a.this.bWs[0] + "current Acc y : " + a.this.bWs[1] + "current Acc z : " + a.this.bWs[2]);
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
        return this.bWp;
    }
}
