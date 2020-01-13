package com.baidu.swan.apps.ao.a;

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
    private static volatile a bSk;
    private SensorManager awS;
    private SensorEventListener bSl;
    private Sensor bSm;
    private InterfaceC0194a bSn;
    private double[] bSo = new double[3];
    private boolean bSp = false;
    private long bSq = 0;
    private int bSr;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.ao.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0194a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a adr() {
        if (bSk == null) {
            synchronized (a.class) {
                if (bSk == null) {
                    bSk = new a();
                }
            }
        }
        return bSk;
    }

    public void init(Context context, int i) {
        this.mContext = context;
        this.bSr = i;
    }

    public void a(InterfaceC0194a interfaceC0194a) {
        this.bSn = interfaceC0194a;
    }

    public void ads() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.bSp) {
            c.w("accelerometer", "has already start");
        } else {
            this.awS = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.awS != null) {
                this.bSm = this.awS.getDefaultSensor(1);
                this.awS.registerListener(adu(), this.bSm, 1);
                this.bSp = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void adt() {
        if (!this.bSp) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.bSl != null && this.awS != null) {
            this.awS.unregisterListener(this.bSl);
            this.bSl = null;
        }
        this.awS = null;
        this.bSm = null;
        this.bSp = false;
    }

    public static void release() {
        if (bSk != null) {
            bSk.NB();
        }
    }

    private void NB() {
        c.i("accelerometer", "release");
        if (this.bSp) {
            adt();
        }
        this.awS = null;
        this.bSm = null;
        this.bSl = null;
        this.bSo = null;
        this.mContext = null;
        bSk = null;
    }

    private SensorEventListener adu() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.bSl != null) {
            return this.bSl;
        }
        this.bSl = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.bSn != null && System.currentTimeMillis() - a.this.bSq > a.this.bSr) {
                            a.this.bSo[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.bSo[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.bSo[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.bSn.a(a.this.bSo);
                            a.this.bSq = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.bSq + "current Acc x : " + a.this.bSo[0] + "current Acc y : " + a.this.bSo[1] + "current Acc z : " + a.this.bSo[2]);
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
        return this.bSl;
    }
}
