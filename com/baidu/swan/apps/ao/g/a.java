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
    private static volatile a bXc;
    private SensorManager aBy;
    private Sensor bWD;
    private boolean bWG = false;
    private Sensor bWU;
    private float[] bWV;
    private float[] bWW;
    private SensorEventListener bXd;
    private InterfaceC0208a bXe;

    /* renamed from: com.baidu.swan.apps.ao.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0208a {
        void i(float[] fArr);
    }

    public static a afX() {
        if (bXc == null) {
            synchronized (a.class) {
                if (bXc == null) {
                    bXc = new a();
                }
            }
        }
        return bXc;
    }

    public boolean a(int i, @NonNull InterfaceC0208a interfaceC0208a) {
        if (this.bWG) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.bXe = interfaceC0208a;
            return true;
        }
        this.aBy = (SensorManager) com.baidu.swan.apps.w.a.TZ().getSystemService("sensor");
        if (this.aBy != null) {
            this.bXe = interfaceC0208a;
            this.bWD = this.aBy.getDefaultSensor(1);
            this.bWU = this.aBy.getDefaultSensor(2);
            if (this.bWD == null || this.bWU == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.aBy.registerListener(afZ(), this.bWD, i);
            this.aBy.registerListener(afZ(), this.bWU, i);
            this.bWG = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void afY() {
        if (!this.bWG) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.bWG = false;
        if (this.bXd != null && this.aBy != null) {
            this.aBy.unregisterListener(this.bXd);
            this.bXd = null;
        }
        this.bXe = null;
        this.aBy = null;
        this.bWD = null;
        this.bWU = null;
    }

    public static void release() {
        if (bXc != null) {
            bXc.PU();
        }
    }

    private void PU() {
        c.i("SwanAppOrientationManager", "release");
        if (this.bWG) {
            afY();
        }
        this.aBy = null;
        this.bWD = null;
        this.bWU = null;
        this.bXd = null;
        this.bWV = null;
        this.bWW = null;
        bXc = null;
    }

    private SensorEventListener afZ() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.bXd != null) {
            return this.bXd;
        }
        this.bXd = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] aga;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.bWV = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.bWW = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.bXe != null && a.this.bWV != null && a.this.bWW != null && (aga = a.this.aga()) != null) {
                        a.this.bXe.i(aga);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bXd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] aga() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.bWV, this.bWW) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
