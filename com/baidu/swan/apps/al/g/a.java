package com.baidu.swan.apps.al.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.console.c;
/* loaded from: classes10.dex */
public class a {
    private static volatile a dnx;
    private SensorManager buw;
    private Sensor dmW;
    private boolean dmZ = false;
    private Sensor dnn;
    private float[] dno;
    private float[] dnp;
    private SensorEventListener dny;
    private InterfaceC0353a dnz;

    /* renamed from: com.baidu.swan.apps.al.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0353a {
        void x(float[] fArr);
    }

    public static a aHd() {
        if (dnx == null) {
            synchronized (a.class) {
                if (dnx == null) {
                    dnx = new a();
                }
            }
        }
        return dnx;
    }

    public boolean a(int i, @NonNull InterfaceC0353a interfaceC0353a) {
        if (this.dmZ) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.dnz = interfaceC0353a;
            return true;
        }
        this.buw = (SensorManager) com.baidu.swan.apps.t.a.asf().getSystemService("sensor");
        if (this.buw != null) {
            this.dnz = interfaceC0353a;
            this.dmW = this.buw.getDefaultSensor(1);
            this.dnn = this.buw.getDefaultSensor(2);
            if (this.dmW == null || this.dnn == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.buw.registerListener(aHf(), this.dmW, i);
            this.buw.registerListener(aHf(), this.dnn, i);
            this.dmZ = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void aHe() {
        if (!this.dmZ) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.dmZ = false;
        if (this.dny != null && this.buw != null) {
            this.buw.unregisterListener(this.dny);
            this.dny = null;
        }
        this.dnz = null;
        this.buw = null;
        this.dmW = null;
        this.dnn = null;
    }

    public static void release() {
        if (dnx != null) {
            dnx.aGS();
        }
    }

    private void aGS() {
        c.i("SwanAppOrientationManager", "release");
        if (this.dmZ) {
            aHe();
        }
        this.buw = null;
        this.dmW = null;
        this.dnn = null;
        this.dny = null;
        this.dno = null;
        this.dnp = null;
        dnx = null;
    }

    private SensorEventListener aHf() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.dny != null) {
            return this.dny;
        }
        this.dny = new SensorEventListener() { // from class: com.baidu.swan.apps.al.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] aHg;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.dno = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.dnp = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.dnz != null && a.this.dno != null && a.this.dnp != null && (aHg = a.this.aHg()) != null) {
                        a.this.dnz.x(aHg);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dny;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] aHg() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.dno, this.dnp) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
