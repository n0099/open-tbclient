package com.baidu.swan.apps.ao.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.console.c;
/* loaded from: classes11.dex */
public class a {
    private static volatile a bWP;
    private SensorManager aBi;
    private Sensor bWH;
    private float[] bWI;
    private float[] bWJ;
    private SensorEventListener bWQ;
    private InterfaceC0208a bWR;
    private Sensor bWq;
    private boolean bWt = false;

    /* renamed from: com.baidu.swan.apps.ao.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0208a {
        void i(float[] fArr);
    }

    public static a afS() {
        if (bWP == null) {
            synchronized (a.class) {
                if (bWP == null) {
                    bWP = new a();
                }
            }
        }
        return bWP;
    }

    public boolean a(int i, @NonNull InterfaceC0208a interfaceC0208a) {
        if (this.bWt) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.bWR = interfaceC0208a;
            return true;
        }
        this.aBi = (SensorManager) com.baidu.swan.apps.w.a.TU().getSystemService("sensor");
        if (this.aBi != null) {
            this.bWR = interfaceC0208a;
            this.bWq = this.aBi.getDefaultSensor(1);
            this.bWH = this.aBi.getDefaultSensor(2);
            if (this.bWq == null || this.bWH == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.aBi.registerListener(afU(), this.bWq, i);
            this.aBi.registerListener(afU(), this.bWH, i);
            this.bWt = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void afT() {
        if (!this.bWt) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.bWt = false;
        if (this.bWQ != null && this.aBi != null) {
            this.aBi.unregisterListener(this.bWQ);
            this.bWQ = null;
        }
        this.bWR = null;
        this.aBi = null;
        this.bWq = null;
        this.bWH = null;
    }

    public static void release() {
        if (bWP != null) {
            bWP.PP();
        }
    }

    private void PP() {
        c.i("SwanAppOrientationManager", "release");
        if (this.bWt) {
            afT();
        }
        this.aBi = null;
        this.bWq = null;
        this.bWH = null;
        this.bWQ = null;
        this.bWI = null;
        this.bWJ = null;
        bWP = null;
    }

    private SensorEventListener afU() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.bWQ != null) {
            return this.bWQ;
        }
        this.bWQ = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] afV;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.bWI = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.bWJ = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.bWR != null && a.this.bWI != null && a.this.bWJ != null && (afV = a.this.afV()) != null) {
                        a.this.bWR.i(afV);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bWQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] afV() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.bWI, this.bWJ) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
