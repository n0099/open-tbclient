package com.baidu.swan.apps.am.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes7.dex */
public class a {
    private static volatile a cPE;
    private SensorManager bic;
    private SensorEventListener cPF;
    private Sensor cPG;
    private InterfaceC0295a cPH;
    private double[] cPI = new double[3];
    private boolean cPJ = false;
    private long cPK = 0;
    private int cPL;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.am.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0295a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a avn() {
        if (cPE == null) {
            synchronized (a.class) {
                if (cPE == null) {
                    cPE = new a();
                }
            }
        }
        return cPE;
    }

    public void m(Context context, int i) {
        this.mContext = context;
        this.cPL = i;
    }

    public void a(InterfaceC0295a interfaceC0295a) {
        this.cPH = interfaceC0295a;
    }

    public void avo() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.cPJ) {
            c.w("accelerometer", "has already start");
        } else {
            this.bic = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.bic != null) {
                this.cPG = this.bic.getDefaultSensor(1);
                this.bic.registerListener(avr(), this.cPG, 1);
                this.cPJ = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void avp() {
        if (!this.cPJ) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.cPF != null && this.bic != null) {
            this.bic.unregisterListener(this.cPF);
            this.cPF = null;
        }
        this.bic = null;
        this.cPG = null;
        this.cPJ = false;
    }

    public static void release() {
        if (cPE != null) {
            cPE.avq();
        }
    }

    private void avq() {
        c.i("accelerometer", "release");
        if (this.cPJ) {
            avp();
        }
        this.bic = null;
        this.cPG = null;
        this.cPF = null;
        this.cPI = null;
        this.mContext = null;
        cPE = null;
    }

    private SensorEventListener avr() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.cPF != null) {
            return this.cPF;
        }
        this.cPF = new SensorEventListener() { // from class: com.baidu.swan.apps.am.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.cPH != null && System.currentTimeMillis() - a.this.cPK > a.this.cPL) {
                            a.this.cPI[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.cPI[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.cPI[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.cPH.a(a.this.cPI);
                            a.this.cPK = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.cPK + "current Acc x : " + a.this.cPI[0] + "current Acc y : " + a.this.cPI[1] + "current Acc z : " + a.this.cPI[2]);
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
        return this.cPF;
    }
}
