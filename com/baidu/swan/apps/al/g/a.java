package com.baidu.swan.apps.al.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.console.c;
/* loaded from: classes7.dex */
public class a {
    private static volatile a dAj;
    private SensorManager bBc;
    private Sensor dAa;
    private float[] dAb;
    private float[] dAc;
    private SensorEventListener dAk;
    private InterfaceC0377a dAl;
    private Sensor dzJ;
    private boolean dzM = false;

    /* renamed from: com.baidu.swan.apps.al.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0377a {
        void x(float[] fArr);
    }

    public static a aKP() {
        if (dAj == null) {
            synchronized (a.class) {
                if (dAj == null) {
                    dAj = new a();
                }
            }
        }
        return dAj;
    }

    public boolean a(int i, @NonNull InterfaceC0377a interfaceC0377a) {
        if (this.dzM) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.dAl = interfaceC0377a;
            return true;
        }
        this.bBc = (SensorManager) com.baidu.swan.apps.t.a.avS().getSystemService("sensor");
        if (this.bBc != null) {
            this.dAl = interfaceC0377a;
            this.dzJ = this.bBc.getDefaultSensor(1);
            this.dAa = this.bBc.getDefaultSensor(2);
            if (this.dzJ == null || this.dAa == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.bBc.registerListener(aKR(), this.dzJ, i);
            this.bBc.registerListener(aKR(), this.dAa, i);
            this.dzM = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void aKQ() {
        if (!this.dzM) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.dzM = false;
        if (this.dAk != null && this.bBc != null) {
            this.bBc.unregisterListener(this.dAk);
            this.dAk = null;
        }
        this.dAl = null;
        this.bBc = null;
        this.dzJ = null;
        this.dAa = null;
    }

    public static void release() {
        if (dAj != null) {
            dAj.aKE();
        }
    }

    private void aKE() {
        c.i("SwanAppOrientationManager", "release");
        if (this.dzM) {
            aKQ();
        }
        this.bBc = null;
        this.dzJ = null;
        this.dAa = null;
        this.dAk = null;
        this.dAb = null;
        this.dAc = null;
        dAj = null;
    }

    private SensorEventListener aKR() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.dAk != null) {
            return this.dAk;
        }
        this.dAk = new SensorEventListener() { // from class: com.baidu.swan.apps.al.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] aKS;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.dAb = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.dAc = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.dAl != null && a.this.dAb != null && a.this.dAc != null && (aKS = a.this.aKS()) != null) {
                        a.this.dAl.x(aKS);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dAk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] aKS() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.dAb, this.dAc) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
