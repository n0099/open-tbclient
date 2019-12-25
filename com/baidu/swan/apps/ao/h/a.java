package com.baidu.swan.apps.ao.h;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.console.c;
/* loaded from: classes9.dex */
public class a {
    private static volatile a bSz;
    private SensorManager awg;
    private Sensor bRC;
    private boolean bRF = false;
    private SensorEventListener bSA;
    private InterfaceC0196a bSB;
    private Sensor bSr;
    private float[] bSs;
    private float[] bSt;

    /* renamed from: com.baidu.swan.apps.ao.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0196a {
        void i(float[] fArr);
    }

    public static a adl() {
        if (bSz == null) {
            synchronized (a.class) {
                if (bSz == null) {
                    bSz = new a();
                }
            }
        }
        return bSz;
    }

    public boolean a(int i, @NonNull InterfaceC0196a interfaceC0196a) {
        if (this.bRF) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.bSB = interfaceC0196a;
            return true;
        }
        this.awg = (SensorManager) com.baidu.swan.apps.w.a.Rk().getSystemService("sensor");
        if (this.awg != null) {
            this.bSB = interfaceC0196a;
            this.bRC = this.awg.getDefaultSensor(1);
            this.bSr = this.awg.getDefaultSensor(2);
            if (this.bRC == null || this.bSr == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.awg.registerListener(adn(), this.bRC, i);
            this.awg.registerListener(adn(), this.bSr, i);
            this.bRF = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void adm() {
        if (!this.bRF) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.bRF = false;
        if (this.bSA != null && this.awg != null) {
            this.awg.unregisterListener(this.bSA);
            this.bSA = null;
        }
        this.bSB = null;
        this.awg = null;
        this.bRC = null;
        this.bSr = null;
    }

    public static void release() {
        if (bSz != null) {
            bSz.Nf();
        }
    }

    private void Nf() {
        c.i("SwanAppOrientationManager", "release");
        if (this.bRF) {
            adm();
        }
        this.awg = null;
        this.bRC = null;
        this.bSr = null;
        this.bSA = null;
        this.bSs = null;
        this.bSt = null;
        bSz = null;
    }

    private SensorEventListener adn() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.bSA != null) {
            return this.bSA;
        }
        this.bSA = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.h.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] ado;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.bSs = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.bSt = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.bSB != null && a.this.bSs != null && a.this.bSt != null && (ado = a.this.ado()) != null) {
                        a.this.bSB.i(ado);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bSA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] ado() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.bSs, this.bSt) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
