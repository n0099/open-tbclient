package com.baidu.swan.apps.ak.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.console.c;
/* loaded from: classes9.dex */
public class a {
    private static volatile a dNd;
    private Sensor dME;
    private boolean dMH = false;
    private Sensor dMU;
    private float[] dMV;
    private float[] dMW;
    private SensorEventListener dNe;
    private InterfaceC0361a dNf;
    private SensorManager mSensorManager;

    /* renamed from: com.baidu.swan.apps.ak.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0361a {
        void v(float[] fArr);
    }

    public static a aMM() {
        if (dNd == null) {
            synchronized (a.class) {
                if (dNd == null) {
                    dNd = new a();
                }
            }
        }
        return dNd;
    }

    public boolean a(int i, @NonNull InterfaceC0361a interfaceC0361a) {
        if (this.dMH) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.dNf = interfaceC0361a;
            return true;
        }
        this.mSensorManager = (SensorManager) com.baidu.swan.apps.t.a.awW().getSystemService("sensor");
        if (this.mSensorManager != null) {
            this.dNf = interfaceC0361a;
            this.dME = this.mSensorManager.getDefaultSensor(1);
            this.dMU = this.mSensorManager.getDefaultSensor(2);
            if (this.dME == null || this.dMU == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.mSensorManager.registerListener(aMO(), this.dME, i);
            this.mSensorManager.registerListener(aMO(), this.dMU, i);
            this.dMH = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void aMN() {
        if (!this.dMH) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.dMH = false;
        if (this.dNe != null && this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.dNe);
            this.dNe = null;
        }
        this.dNf = null;
        this.mSensorManager = null;
        this.dME = null;
        this.dMU = null;
    }

    public static void release() {
        if (dNd != null) {
            dNd.aMB();
        }
    }

    private void aMB() {
        c.i("SwanAppOrientationManager", "release");
        if (this.dMH) {
            aMN();
        }
        this.mSensorManager = null;
        this.dME = null;
        this.dMU = null;
        this.dNe = null;
        this.dMV = null;
        this.dMW = null;
        dNd = null;
    }

    private SensorEventListener aMO() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.dNe != null) {
            return this.dNe;
        }
        this.dNe = new SensorEventListener() { // from class: com.baidu.swan.apps.ak.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] aMP;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.dMV = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.dMW = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.dNf != null && a.this.dMV != null && a.this.dMW != null && (aMP = a.this.aMP()) != null) {
                        a.this.dNf.v(aMP);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dNe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] aMP() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.dMV, this.dMW) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
