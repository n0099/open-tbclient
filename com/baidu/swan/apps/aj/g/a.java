package com.baidu.swan.apps.aj.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.console.c;
/* loaded from: classes2.dex */
public class a {
    private static volatile a bqG;
    private SensorManager aoj;
    private float[] bqA;
    private SensorEventListener bqH;
    private InterfaceC0154a bqI;
    private Sensor bql;
    private boolean bqo = false;
    private Sensor bqy;
    private float[] bqz;

    /* renamed from: com.baidu.swan.apps.aj.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0154a {
        void h(float[] fArr);
    }

    public static a Tu() {
        if (bqG == null) {
            synchronized (a.class) {
                if (bqG == null) {
                    bqG = new a();
                }
            }
        }
        return bqG;
    }

    public boolean a(int i, @NonNull InterfaceC0154a interfaceC0154a) {
        if (this.bqo) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.bqI = interfaceC0154a;
            return true;
        }
        this.aoj = (SensorManager) com.baidu.swan.apps.u.a.Jj().getSystemService("sensor");
        if (this.aoj != null) {
            this.bqI = interfaceC0154a;
            this.bql = this.aoj.getDefaultSensor(1);
            this.bqy = this.aoj.getDefaultSensor(2);
            if (this.bql == null || this.bqy == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.aoj.registerListener(Tw(), this.bql, i);
            this.aoj.registerListener(Tw(), this.bqy, i);
            this.bqo = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void Tv() {
        if (!this.bqo) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.bqo = false;
        if (this.bqH != null && this.aoj != null) {
            this.aoj.unregisterListener(this.bqH);
            this.bqH = null;
        }
        this.bqI = null;
        this.aoj = null;
        this.bql = null;
        this.bqy = null;
    }

    public static void release() {
        if (bqG != null) {
            bqG.GE();
        }
    }

    private void GE() {
        c.i("SwanAppOrientationManager", "release");
        if (this.bqo) {
            Tv();
        }
        this.aoj = null;
        this.bql = null;
        this.bqy = null;
        this.bqH = null;
        this.bqz = null;
        this.bqA = null;
        bqG = null;
    }

    private SensorEventListener Tw() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.bqH != null) {
            return this.bqH;
        }
        this.bqH = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] Tx;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.bqz = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.bqA = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.bqI != null && a.this.bqz != null && a.this.bqA != null && (Tx = a.this.Tx()) != null) {
                        a.this.bqI.h(Tx);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bqH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] Tx() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.bqz, this.bqA) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
