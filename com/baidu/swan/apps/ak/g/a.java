package com.baidu.swan.apps.ak.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.console.c;
/* loaded from: classes8.dex */
public class a {
    private static volatile a dKZ;
    private Sensor dKA;
    private boolean dKD = false;
    private Sensor dKQ;
    private float[] dKR;
    private float[] dKS;
    private SensorEventListener dLa;
    private InterfaceC0364a dLb;
    private SensorManager mSensorManager;

    /* renamed from: com.baidu.swan.apps.ak.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0364a {
        void v(float[] fArr);
    }

    public static a aMt() {
        if (dKZ == null) {
            synchronized (a.class) {
                if (dKZ == null) {
                    dKZ = new a();
                }
            }
        }
        return dKZ;
    }

    public boolean a(int i, @NonNull InterfaceC0364a interfaceC0364a) {
        if (this.dKD) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.dLb = interfaceC0364a;
            return true;
        }
        this.mSensorManager = (SensorManager) com.baidu.swan.apps.t.a.awy().getSystemService("sensor");
        if (this.mSensorManager != null) {
            this.dLb = interfaceC0364a;
            this.dKA = this.mSensorManager.getDefaultSensor(1);
            this.dKQ = this.mSensorManager.getDefaultSensor(2);
            if (this.dKA == null || this.dKQ == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.mSensorManager.registerListener(aMv(), this.dKA, i);
            this.mSensorManager.registerListener(aMv(), this.dKQ, i);
            this.dKD = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void aMu() {
        if (!this.dKD) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.dKD = false;
        if (this.dLa != null && this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.dLa);
            this.dLa = null;
        }
        this.dLb = null;
        this.mSensorManager = null;
        this.dKA = null;
        this.dKQ = null;
    }

    public static void release() {
        if (dKZ != null) {
            dKZ.aMi();
        }
    }

    private void aMi() {
        c.i("SwanAppOrientationManager", "release");
        if (this.dKD) {
            aMu();
        }
        this.mSensorManager = null;
        this.dKA = null;
        this.dKQ = null;
        this.dLa = null;
        this.dKR = null;
        this.dKS = null;
        dKZ = null;
    }

    private SensorEventListener aMv() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.dLa != null) {
            return this.dLa;
        }
        this.dLa = new SensorEventListener() { // from class: com.baidu.swan.apps.ak.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] aMw;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.dKR = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.dKS = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.dLb != null && a.this.dKR != null && a.this.dKS != null && (aMw = a.this.aMw()) != null) {
                        a.this.dLb.v(aMw);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dLa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] aMw() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.dKR, this.dKS) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
