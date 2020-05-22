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
    private static volatile a cIb;
    private SensorManager bcy;
    private Sensor cHB;
    private boolean cHE = false;
    private Sensor cHS;
    private float[] cHT;
    private float[] cHU;
    private SensorEventListener cIc;
    private InterfaceC0293a cId;

    /* renamed from: com.baidu.swan.apps.am.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0293a {
        void w(float[] fArr);
    }

    public static a asu() {
        if (cIb == null) {
            synchronized (a.class) {
                if (cIb == null) {
                    cIb = new a();
                }
            }
        }
        return cIb;
    }

    public boolean a(int i, @NonNull InterfaceC0293a interfaceC0293a) {
        if (this.cHE) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.cId = interfaceC0293a;
            return true;
        }
        this.bcy = (SensorManager) com.baidu.swan.apps.u.a.aeR().getSystemService("sensor");
        if (this.bcy != null) {
            this.cId = interfaceC0293a;
            this.cHB = this.bcy.getDefaultSensor(1);
            this.cHS = this.bcy.getDefaultSensor(2);
            if (this.cHB == null || this.cHS == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.bcy.registerListener(asw(), this.cHB, i);
            this.bcy.registerListener(asw(), this.cHS, i);
            this.cHE = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void asv() {
        if (!this.cHE) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.cHE = false;
        if (this.cIc != null && this.bcy != null) {
            this.bcy.unregisterListener(this.cIc);
            this.cIc = null;
        }
        this.cId = null;
        this.bcy = null;
        this.cHB = null;
        this.cHS = null;
    }

    public static void release() {
        if (cIb != null) {
            cIb.asi();
        }
    }

    private void asi() {
        c.i("SwanAppOrientationManager", "release");
        if (this.cHE) {
            asv();
        }
        this.bcy = null;
        this.cHB = null;
        this.cHS = null;
        this.cIc = null;
        this.cHT = null;
        this.cHU = null;
        cIb = null;
    }

    private SensorEventListener asw() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.cIc != null) {
            return this.cIc;
        }
        this.cIc = new SensorEventListener() { // from class: com.baidu.swan.apps.am.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] asx;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.cHT = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.cHU = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.cId != null && a.this.cHT != null && a.this.cHU != null && (asx = a.this.asx()) != null) {
                        a.this.cId.w(asx);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cIc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] asx() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.cHT, this.cHU) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
