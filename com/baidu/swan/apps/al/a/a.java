package com.baidu.swan.apps.al.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes8.dex */
public class a {
    private static volatile a cYG;
    private SensorManager bnK;
    private SensorEventListener cYH;
    private Sensor cYI;
    private InterfaceC0337a cYJ;
    private double[] cYK = new double[3];
    private boolean cYL = false;
    private long cYM = 0;
    private int cYN;
    private Context mContext;

    /* renamed from: com.baidu.swan.apps.al.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0337a {
        void b(double[] dArr);
    }

    private a() {
    }

    public static a aDw() {
        if (cYG == null) {
            synchronized (a.class) {
                if (cYG == null) {
                    cYG = new a();
                }
            }
        }
        return cYG;
    }

    public void m(Context context, int i) {
        this.mContext = context;
        this.cYN = i;
    }

    public void a(InterfaceC0337a interfaceC0337a) {
        this.cYJ = interfaceC0337a;
    }

    public void aDx() {
        if (this.mContext == null) {
            c.e("accelerometer", "start error, none context");
        } else if (this.cYL) {
            c.w("accelerometer", "has already start");
        } else {
            this.bnK = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.bnK != null) {
                this.cYI = this.bnK.getDefaultSensor(1);
                this.bnK.registerListener(aDA(), this.cYI, 1);
                this.cYL = true;
                c.i("accelerometer", "start listen");
                return;
            }
            c.e("accelerometer", "none sensorManager");
        }
    }

    public void aDy() {
        if (!this.cYL) {
            c.w("accelerometer", "has already stop");
            return;
        }
        if (this.cYH != null && this.bnK != null) {
            this.bnK.unregisterListener(this.cYH);
            this.cYH = null;
        }
        this.bnK = null;
        this.cYI = null;
        this.cYL = false;
    }

    public static void release() {
        if (cYG != null) {
            cYG.aDz();
        }
    }

    private void aDz() {
        c.i("accelerometer", "release");
        if (this.cYL) {
            aDy();
        }
        this.bnK = null;
        this.cYI = null;
        this.cYH = null;
        this.cYK = null;
        this.mContext = null;
        cYG = null;
    }

    private SensorEventListener aDA() {
        c.i("accelerometer", "get Accelerometer listener");
        if (this.cYH != null) {
            return this.cYH;
        }
        this.cYH = new SensorEventListener() { // from class: com.baidu.swan.apps.al.a.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        if (a.this.cYJ != null && System.currentTimeMillis() - a.this.cYM > a.this.cYN) {
                            a.this.cYK[0] = (-sensorEvent.values[0]) / 9.8d;
                            a.this.cYK[1] = (-sensorEvent.values[1]) / 9.8d;
                            a.this.cYK[2] = (-sensorEvent.values[2]) / 9.8d;
                            a.this.cYJ.b(a.this.cYK);
                            a.this.cYM = System.currentTimeMillis();
                        }
                        if (e.DEBUG) {
                            Log.d("AccelerometerManager", "current Time : " + a.this.cYM + "current Acc x : " + a.this.cYK[0] + "current Acc y : " + a.this.cYK[1] + "current Acc z : " + a.this.cYK[2]);
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
        return this.cYH;
    }
}
