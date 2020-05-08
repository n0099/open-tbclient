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
    private static volatile a cvZ;
    private SensorManager aVk;
    private Sensor cvA;
    private boolean cvD = false;
    private Sensor cvR;
    private float[] cvS;
    private float[] cvT;
    private SensorEventListener cwa;
    private InterfaceC0259a cwb;

    /* renamed from: com.baidu.swan.apps.ao.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0259a {
        void w(float[] fArr);
    }

    public static a aob() {
        if (cvZ == null) {
            synchronized (a.class) {
                if (cvZ == null) {
                    cvZ = new a();
                }
            }
        }
        return cvZ;
    }

    public boolean a(int i, @NonNull InterfaceC0259a interfaceC0259a) {
        if (this.cvD) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.cwb = interfaceC0259a;
            return true;
        }
        this.aVk = (SensorManager) com.baidu.swan.apps.w.a.abN().getSystemService("sensor");
        if (this.aVk != null) {
            this.cwb = interfaceC0259a;
            this.cvA = this.aVk.getDefaultSensor(1);
            this.cvR = this.aVk.getDefaultSensor(2);
            if (this.cvA == null || this.cvR == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.aVk.registerListener(aod(), this.cvA, i);
            this.aVk.registerListener(aod(), this.cvR, i);
            this.cvD = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void aoc() {
        if (!this.cvD) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.cvD = false;
        if (this.cwa != null && this.aVk != null) {
            this.aVk.unregisterListener(this.cwa);
            this.cwa = null;
        }
        this.cwb = null;
        this.aVk = null;
        this.cvA = null;
        this.cvR = null;
    }

    public static void release() {
        if (cvZ != null) {
            cvZ.XI();
        }
    }

    private void XI() {
        c.i("SwanAppOrientationManager", "release");
        if (this.cvD) {
            aoc();
        }
        this.aVk = null;
        this.cvA = null;
        this.cvR = null;
        this.cwa = null;
        this.cvS = null;
        this.cvT = null;
        cvZ = null;
    }

    private SensorEventListener aod() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.cwa != null) {
            return this.cwa;
        }
        this.cwa = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] aoe;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.cvS = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.cvT = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.cwb != null && a.this.cvS != null && a.this.cvT != null && (aoe = a.this.aoe()) != null) {
                        a.this.cwb.w(aoe);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cwa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] aoe() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.cvS, this.cvT) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
