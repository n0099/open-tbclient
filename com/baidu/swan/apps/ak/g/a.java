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
    private static volatile a dPL;
    private Sensor dPC;
    private float[] dPD;
    private float[] dPE;
    private SensorEventListener dPM;
    private InterfaceC0381a dPN;
    private Sensor dPm;
    private boolean dPp = false;
    private SensorManager mSensorManager;

    /* renamed from: com.baidu.swan.apps.ak.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0381a {
        void v(float[] fArr);
    }

    public static a aQn() {
        if (dPL == null) {
            synchronized (a.class) {
                if (dPL == null) {
                    dPL = new a();
                }
            }
        }
        return dPL;
    }

    public boolean a(int i, @NonNull InterfaceC0381a interfaceC0381a) {
        if (this.dPp) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.dPN = interfaceC0381a;
            return true;
        }
        this.mSensorManager = (SensorManager) com.baidu.swan.apps.t.a.aAs().getSystemService("sensor");
        if (this.mSensorManager != null) {
            this.dPN = interfaceC0381a;
            this.dPm = this.mSensorManager.getDefaultSensor(1);
            this.dPC = this.mSensorManager.getDefaultSensor(2);
            if (this.dPm == null || this.dPC == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.mSensorManager.registerListener(aQp(), this.dPm, i);
            this.mSensorManager.registerListener(aQp(), this.dPC, i);
            this.dPp = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void aQo() {
        if (!this.dPp) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.dPp = false;
        if (this.dPM != null && this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.dPM);
            this.dPM = null;
        }
        this.dPN = null;
        this.mSensorManager = null;
        this.dPm = null;
        this.dPC = null;
    }

    public static void release() {
        if (dPL != null) {
            dPL.aQc();
        }
    }

    private void aQc() {
        c.i("SwanAppOrientationManager", "release");
        if (this.dPp) {
            aQo();
        }
        this.mSensorManager = null;
        this.dPm = null;
        this.dPC = null;
        this.dPM = null;
        this.dPD = null;
        this.dPE = null;
        dPL = null;
    }

    private SensorEventListener aQp() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.dPM != null) {
            return this.dPM;
        }
        this.dPM = new SensorEventListener() { // from class: com.baidu.swan.apps.ak.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] aQq;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.dPD = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.dPE = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.dPN != null && a.this.dPD != null && a.this.dPE != null && (aQq = a.this.aQq()) != null) {
                        a.this.dPN.v(aQq);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dPM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] aQq() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.dPD, this.dPE) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
