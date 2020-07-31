package com.baidu.swan.apps.am.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.console.c;
/* loaded from: classes7.dex */
public class a {
    private static volatile a cQg;
    private SensorManager bic;
    private Sensor cPG;
    private boolean cPJ = false;
    private Sensor cPX;
    private float[] cPY;
    private float[] cPZ;
    private SensorEventListener cQh;
    private InterfaceC0299a cQi;

    /* renamed from: com.baidu.swan.apps.am.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0299a {
        void x(float[] fArr);
    }

    public static a avB() {
        if (cQg == null) {
            synchronized (a.class) {
                if (cQg == null) {
                    cQg = new a();
                }
            }
        }
        return cQg;
    }

    public boolean a(int i, @NonNull InterfaceC0299a interfaceC0299a) {
        if (this.cPJ) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.cQi = interfaceC0299a;
            return true;
        }
        this.bic = (SensorManager) com.baidu.swan.apps.t.a.ahj().getSystemService("sensor");
        if (this.bic != null) {
            this.cQi = interfaceC0299a;
            this.cPG = this.bic.getDefaultSensor(1);
            this.cPX = this.bic.getDefaultSensor(2);
            if (this.cPG == null || this.cPX == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.bic.registerListener(avD(), this.cPG, i);
            this.bic.registerListener(avD(), this.cPX, i);
            this.cPJ = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void avC() {
        if (!this.cPJ) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.cPJ = false;
        if (this.cQh != null && this.bic != null) {
            this.bic.unregisterListener(this.cQh);
            this.cQh = null;
        }
        this.cQi = null;
        this.bic = null;
        this.cPG = null;
        this.cPX = null;
    }

    public static void release() {
        if (cQg != null) {
            cQg.avq();
        }
    }

    private void avq() {
        c.i("SwanAppOrientationManager", "release");
        if (this.cPJ) {
            avC();
        }
        this.bic = null;
        this.cPG = null;
        this.cPX = null;
        this.cQh = null;
        this.cPY = null;
        this.cPZ = null;
        cQg = null;
    }

    private SensorEventListener avD() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.cQh != null) {
            return this.cQh;
        }
        this.cQh = new SensorEventListener() { // from class: com.baidu.swan.apps.am.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] avE;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.cPY = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.cPZ = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.cQi != null && a.this.cPY != null && a.this.cPZ != null && (avE = a.this.avE()) != null) {
                        a.this.cQi.x(avE);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cQh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] avE() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.cPY, this.cPZ) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
