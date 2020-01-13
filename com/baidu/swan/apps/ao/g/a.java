package com.baidu.swan.apps.ao.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.console.c;
/* loaded from: classes10.dex */
public class a {
    private static volatile a bSL;
    private SensorManager awS;
    private Sensor bSD;
    private float[] bSE;
    private float[] bSF;
    private SensorEventListener bSM;
    private InterfaceC0198a bSN;
    private Sensor bSm;
    private boolean bSp = false;

    /* renamed from: com.baidu.swan.apps.ao.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0198a {
        void i(float[] fArr);
    }

    public static a adE() {
        if (bSL == null) {
            synchronized (a.class) {
                if (bSL == null) {
                    bSL = new a();
                }
            }
        }
        return bSL;
    }

    public boolean a(int i, @NonNull InterfaceC0198a interfaceC0198a) {
        if (this.bSp) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.bSN = interfaceC0198a;
            return true;
        }
        this.awS = (SensorManager) com.baidu.swan.apps.w.a.RG().getSystemService("sensor");
        if (this.awS != null) {
            this.bSN = interfaceC0198a;
            this.bSm = this.awS.getDefaultSensor(1);
            this.bSD = this.awS.getDefaultSensor(2);
            if (this.bSm == null || this.bSD == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.awS.registerListener(adG(), this.bSm, i);
            this.awS.registerListener(adG(), this.bSD, i);
            this.bSp = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void adF() {
        if (!this.bSp) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.bSp = false;
        if (this.bSM != null && this.awS != null) {
            this.awS.unregisterListener(this.bSM);
            this.bSM = null;
        }
        this.bSN = null;
        this.awS = null;
        this.bSm = null;
        this.bSD = null;
    }

    public static void release() {
        if (bSL != null) {
            bSL.NB();
        }
    }

    private void NB() {
        c.i("SwanAppOrientationManager", "release");
        if (this.bSp) {
            adF();
        }
        this.awS = null;
        this.bSm = null;
        this.bSD = null;
        this.bSM = null;
        this.bSE = null;
        this.bSF = null;
        bSL = null;
    }

    private SensorEventListener adG() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.bSM != null) {
            return this.bSM;
        }
        this.bSM = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] adH;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.bSE = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.bSF = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.bSN != null && a.this.bSE != null && a.this.bSF != null && (adH = a.this.adH()) != null) {
                        a.this.bSN.i(adH);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bSM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] adH() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.bSE, this.bSF) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
