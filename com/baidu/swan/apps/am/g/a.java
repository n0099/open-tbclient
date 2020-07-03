package com.baidu.swan.apps.am.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.console.c;
/* loaded from: classes11.dex */
public class a {
    private static volatile a cML;
    private SensorManager bhI;
    private Sensor cMC;
    private float[] cMD;
    private float[] cME;
    private SensorEventListener cMM;
    private InterfaceC0299a cMN;
    private Sensor cMl;
    private boolean cMo = false;

    /* renamed from: com.baidu.swan.apps.am.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0299a {
        void x(float[] fArr);
    }

    public static a atA() {
        if (cML == null) {
            synchronized (a.class) {
                if (cML == null) {
                    cML = new a();
                }
            }
        }
        return cML;
    }

    public boolean a(int i, @NonNull InterfaceC0299a interfaceC0299a) {
        if (this.cMo) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.cMN = interfaceC0299a;
            return true;
        }
        this.bhI = (SensorManager) com.baidu.swan.apps.u.a.afX().getSystemService("sensor");
        if (this.bhI != null) {
            this.cMN = interfaceC0299a;
            this.cMl = this.bhI.getDefaultSensor(1);
            this.cMC = this.bhI.getDefaultSensor(2);
            if (this.cMl == null || this.cMC == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.bhI.registerListener(atC(), this.cMl, i);
            this.bhI.registerListener(atC(), this.cMC, i);
            this.cMo = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void atB() {
        if (!this.cMo) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.cMo = false;
        if (this.cMM != null && this.bhI != null) {
            this.bhI.unregisterListener(this.cMM);
            this.cMM = null;
        }
        this.cMN = null;
        this.bhI = null;
        this.cMl = null;
        this.cMC = null;
    }

    public static void release() {
        if (cML != null) {
            cML.atp();
        }
    }

    private void atp() {
        c.i("SwanAppOrientationManager", "release");
        if (this.cMo) {
            atB();
        }
        this.bhI = null;
        this.cMl = null;
        this.cMC = null;
        this.cMM = null;
        this.cMD = null;
        this.cME = null;
        cML = null;
    }

    private SensorEventListener atC() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.cMM != null) {
            return this.cMM;
        }
        this.cMM = new SensorEventListener() { // from class: com.baidu.swan.apps.am.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] atD;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.cMD = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.cME = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.cMN != null && a.this.cMD != null && a.this.cME != null && (atD = a.this.atD()) != null) {
                        a.this.cMN.x(atD);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cMM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] atD() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.cMD, this.cME) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
