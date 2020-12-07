package com.baidu.swan.apps.al.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.console.c;
/* loaded from: classes25.dex */
public class a {
    private static volatile a dHh;
    private SensorManager bGk;
    private Sensor dGI;
    private boolean dGL = false;
    private Sensor dGY;
    private float[] dGZ;
    private float[] dHa;
    private SensorEventListener dHi;
    private InterfaceC0389a dHj;

    /* renamed from: com.baidu.swan.apps.al.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0389a {
        void w(float[] fArr);
    }

    public static a aNW() {
        if (dHh == null) {
            synchronized (a.class) {
                if (dHh == null) {
                    dHh = new a();
                }
            }
        }
        return dHh;
    }

    public boolean a(int i, @NonNull InterfaceC0389a interfaceC0389a) {
        if (this.dGL) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.dHj = interfaceC0389a;
            return true;
        }
        this.bGk = (SensorManager) com.baidu.swan.apps.t.a.aza().getSystemService("sensor");
        if (this.bGk != null) {
            this.dHj = interfaceC0389a;
            this.dGI = this.bGk.getDefaultSensor(1);
            this.dGY = this.bGk.getDefaultSensor(2);
            if (this.dGI == null || this.dGY == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.bGk.registerListener(aNY(), this.dGI, i);
            this.bGk.registerListener(aNY(), this.dGY, i);
            this.dGL = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void aNX() {
        if (!this.dGL) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.dGL = false;
        if (this.dHi != null && this.bGk != null) {
            this.bGk.unregisterListener(this.dHi);
            this.dHi = null;
        }
        this.dHj = null;
        this.bGk = null;
        this.dGI = null;
        this.dGY = null;
    }

    public static void release() {
        if (dHh != null) {
            dHh.aNL();
        }
    }

    private void aNL() {
        c.i("SwanAppOrientationManager", "release");
        if (this.dGL) {
            aNX();
        }
        this.bGk = null;
        this.dGI = null;
        this.dGY = null;
        this.dHi = null;
        this.dGZ = null;
        this.dHa = null;
        dHh = null;
    }

    private SensorEventListener aNY() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.dHi != null) {
            return this.dHi;
        }
        this.dHi = new SensorEventListener() { // from class: com.baidu.swan.apps.al.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] aNZ;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.dGZ = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.dHa = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.dHj != null && a.this.dGZ != null && a.this.dHa != null && (aNZ = a.this.aNZ()) != null) {
                        a.this.dHj.w(aNZ);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dHi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] aNZ() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.dGZ, this.dHa) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
