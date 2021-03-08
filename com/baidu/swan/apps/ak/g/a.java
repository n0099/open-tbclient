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
    private static volatile a dOE;
    private SensorEventListener dOF;
    private InterfaceC0367a dOG;
    private Sensor dOf;
    private boolean dOi = false;
    private Sensor dOv;
    private float[] dOw;
    private float[] dOx;
    private SensorManager mSensorManager;

    /* renamed from: com.baidu.swan.apps.ak.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0367a {
        void v(float[] fArr);
    }

    public static a aMP() {
        if (dOE == null) {
            synchronized (a.class) {
                if (dOE == null) {
                    dOE = new a();
                }
            }
        }
        return dOE;
    }

    public boolean a(int i, @NonNull InterfaceC0367a interfaceC0367a) {
        if (this.dOi) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.dOG = interfaceC0367a;
            return true;
        }
        this.mSensorManager = (SensorManager) com.baidu.swan.apps.t.a.awZ().getSystemService("sensor");
        if (this.mSensorManager != null) {
            this.dOG = interfaceC0367a;
            this.dOf = this.mSensorManager.getDefaultSensor(1);
            this.dOv = this.mSensorManager.getDefaultSensor(2);
            if (this.dOf == null || this.dOv == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.mSensorManager.registerListener(aMR(), this.dOf, i);
            this.mSensorManager.registerListener(aMR(), this.dOv, i);
            this.dOi = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void aMQ() {
        if (!this.dOi) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.dOi = false;
        if (this.dOF != null && this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.dOF);
            this.dOF = null;
        }
        this.dOG = null;
        this.mSensorManager = null;
        this.dOf = null;
        this.dOv = null;
    }

    public static void release() {
        if (dOE != null) {
            dOE.aME();
        }
    }

    private void aME() {
        c.i("SwanAppOrientationManager", "release");
        if (this.dOi) {
            aMQ();
        }
        this.mSensorManager = null;
        this.dOf = null;
        this.dOv = null;
        this.dOF = null;
        this.dOw = null;
        this.dOx = null;
        dOE = null;
    }

    private SensorEventListener aMR() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.dOF != null) {
            return this.dOF;
        }
        this.dOF = new SensorEventListener() { // from class: com.baidu.swan.apps.ak.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] aMS;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.dOw = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.dOx = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.dOG != null && a.this.dOw != null && a.this.dOx != null && (aMS = a.this.aMS()) != null) {
                        a.this.dOG.v(aMS);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dOF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] aMS() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.dOw, this.dOx) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
