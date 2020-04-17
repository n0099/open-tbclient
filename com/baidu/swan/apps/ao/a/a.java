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
    private static volatile a cvs;
    private SensorManager aVf;
    private SensorEventListener cvt;
    private Sensor cvu;
    private InterfaceC0234a cvv;
    private double[] cvw = new double[3];
    private boolean cvx = false;
    private long cvy = 0;
    private int cvz;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.ao.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0234a {
        void a(double[] dArr);
    }

    private a() {
    }

    public static a anP() {
        if (cvs == null) {
            synchronized (a.class) {
                if (cvs == null) {
                    cvs = new a();
                }
            }
        }
        return cvs;
    }

    public void m(Context context, int i) {
        this.mContext = context;
        this.cvz = i;
    }

    public void a(InterfaceC0234a interfaceC0234a) {
        this.cvv = interfaceC0234a;
    }

    public void anQ() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.cvx) {
            c.w("accelerometer", "has already start");
        } else {
            this.aVf = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aVf != null) {
                this.cvu = this.aVf.getDefaultSensor(1);
                this.aVf.registerListener(anS(), this.cvu, 1);
                this.cvx = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void anR() {
        if (!this.cvx) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.cvt != null && this.aVf != null) {
            this.aVf.unregisterListener(this.cvt);
            this.cvt = null;
        }
        this.aVf = null;
        this.cvu = null;
        this.cvx = false;
    }

    public static void release() {
        if (cvs != null) {
            cvs.XJ();
        }
    }

    private void XJ() {
        c.i("accelerometer", "release");
        if (this.cvx) {
            anR();
        }
        this.aVf = null;
        this.cvu = null;
        this.cvt = null;
        this.cvw = null;
        this.mContext = null;
        cvs = null;
    }

    private SensorEventListener anS() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.cvt != null) {
            return this.cvt;
        }
        this.cvt = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.cvv != null && System.currentTimeMillis() - a.this.cvy > a.this.cvz) {
                            a.this.cvw[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.cvw[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.cvw[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.cvv.a(a.this.cvw);
                            a.this.cvy = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.cvy + "current Acc x : " + a.this.cvw[0] + "current Acc y : " + a.this.cvw[1] + "current Acc z : " + a.this.cvw[2]);
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
        return this.cvt;
    }
}
