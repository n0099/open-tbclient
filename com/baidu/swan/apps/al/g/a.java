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
    private static volatile a dvY;
    private SensorManager bwC;
    private boolean dvB = false;
    private Sensor dvP;
    private float[] dvQ;
    private float[] dvR;
    private SensorEventListener dvZ;
    private Sensor dvy;
    private InterfaceC0367a dwa;

    /* renamed from: com.baidu.swan.apps.al.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0367a {
        void x(float[] fArr);
    }

    public static a aIX() {
        if (dvY == null) {
            synchronized (a.class) {
                if (dvY == null) {
                    dvY = new a();
                }
            }
        }
        return dvY;
    }

    public boolean a(int i, @NonNull InterfaceC0367a interfaceC0367a) {
        if (this.dvB) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.dwa = interfaceC0367a;
            return true;
        }
        this.bwC = (SensorManager) com.baidu.swan.apps.t.a.aua().getSystemService("sensor");
        if (this.bwC != null) {
            this.dwa = interfaceC0367a;
            this.dvy = this.bwC.getDefaultSensor(1);
            this.dvP = this.bwC.getDefaultSensor(2);
            if (this.dvy == null || this.dvP == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.bwC.registerListener(aIZ(), this.dvy, i);
            this.bwC.registerListener(aIZ(), this.dvP, i);
            this.dvB = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void aIY() {
        if (!this.dvB) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.dvB = false;
        if (this.dvZ != null && this.bwC != null) {
            this.bwC.unregisterListener(this.dvZ);
            this.dvZ = null;
        }
        this.dwa = null;
        this.bwC = null;
        this.dvy = null;
        this.dvP = null;
    }

    public static void release() {
        if (dvY != null) {
            dvY.aIM();
        }
    }

    private void aIM() {
        c.i("SwanAppOrientationManager", "release");
        if (this.dvB) {
            aIY();
        }
        this.bwC = null;
        this.dvy = null;
        this.dvP = null;
        this.dvZ = null;
        this.dvQ = null;
        this.dvR = null;
        dvY = null;
    }

    private SensorEventListener aIZ() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.dvZ != null) {
            return this.dvZ;
        }
        this.dvZ = new SensorEventListener() { // from class: com.baidu.swan.apps.al.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] aJa;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.dvQ = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.dvR = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.dwa != null && a.this.dvQ != null && a.this.dvR != null && (aJa = a.this.aJa()) != null) {
                        a.this.dwa.x(aJa);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dvZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] aJa() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.dvQ, this.dvR) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
