package com.baidu.swan.apps.al.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.console.c;
/* loaded from: classes8.dex */
public class a {
    private static volatile a cZm;
    private SensorManager bnN;
    private Sensor cYM;
    private boolean cYP = false;
    private Sensor cZd;
    private float[] cZe;
    private float[] cZf;
    private SensorEventListener cZn;
    private InterfaceC0341a cZo;

    /* renamed from: com.baidu.swan.apps.al.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0341a {
        void x(float[] fArr);
    }

    public static a aDK() {
        if (cZm == null) {
            synchronized (a.class) {
                if (cZm == null) {
                    cZm = new a();
                }
            }
        }
        return cZm;
    }

    public boolean a(int i, @NonNull InterfaceC0341a interfaceC0341a) {
        if (this.cYP) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.cZo = interfaceC0341a;
            return true;
        }
        this.bnN = (SensorManager) com.baidu.swan.apps.t.a.aoJ().getSystemService("sensor");
        if (this.bnN != null) {
            this.cZo = interfaceC0341a;
            this.cYM = this.bnN.getDefaultSensor(1);
            this.cZd = this.bnN.getDefaultSensor(2);
            if (this.cYM == null || this.cZd == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.bnN.registerListener(aDM(), this.cYM, i);
            this.bnN.registerListener(aDM(), this.cZd, i);
            this.cYP = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void aDL() {
        if (!this.cYP) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.cYP = false;
        if (this.cZn != null && this.bnN != null) {
            this.bnN.unregisterListener(this.cZn);
            this.cZn = null;
        }
        this.cZo = null;
        this.bnN = null;
        this.cYM = null;
        this.cZd = null;
    }

    public static void release() {
        if (cZm != null) {
            cZm.aDz();
        }
    }

    private void aDz() {
        c.i("SwanAppOrientationManager", "release");
        if (this.cYP) {
            aDL();
        }
        this.bnN = null;
        this.cYM = null;
        this.cZd = null;
        this.cZn = null;
        this.cZe = null;
        this.cZf = null;
        cZm = null;
    }

    private SensorEventListener aDM() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.cZn != null) {
            return this.cZn;
        }
        this.cZn = new SensorEventListener() { // from class: com.baidu.swan.apps.al.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] aDN;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.cZe = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.cZf = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.cZo != null && a.this.cZe != null && a.this.cZf != null && (aDN = a.this.aDN()) != null) {
                        a.this.cZo.x(aDN);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cZn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] aDN() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.cZe, this.cZf) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
