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
    private static volatile a brx;
    private SensorManager aoB;
    private Sensor bqD;
    private boolean bqG = false;
    private Sensor brp;
    private float[] brq;
    private float[] brr;
    private SensorEventListener bry;
    private InterfaceC0159a brz;

    /* renamed from: com.baidu.swan.apps.aj.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0159a {
        void h(float[] fArr);
    }

    public static a Tw() {
        if (brx == null) {
            synchronized (a.class) {
                if (brx == null) {
                    brx = new a();
                }
            }
        }
        return brx;
    }

    public boolean a(int i, @NonNull InterfaceC0159a interfaceC0159a) {
        if (this.bqG) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.brz = interfaceC0159a;
            return true;
        }
        this.aoB = (SensorManager) com.baidu.swan.apps.u.a.Ji().getSystemService("sensor");
        if (this.aoB != null) {
            this.brz = interfaceC0159a;
            this.bqD = this.aoB.getDefaultSensor(1);
            this.brp = this.aoB.getDefaultSensor(2);
            if (this.bqD == null || this.brp == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.aoB.registerListener(Ty(), this.bqD, i);
            this.aoB.registerListener(Ty(), this.brp, i);
            this.bqG = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void Tx() {
        if (!this.bqG) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.bqG = false;
        if (this.bry != null && this.aoB != null) {
            this.aoB.unregisterListener(this.bry);
            this.bry = null;
        }
        this.brz = null;
        this.aoB = null;
        this.bqD = null;
        this.brp = null;
    }

    public static void release() {
        if (brx != null) {
            brx.GD();
        }
    }

    private void GD() {
        c.i("SwanAppOrientationManager", "release");
        if (this.bqG) {
            Tx();
        }
        this.aoB = null;
        this.bqD = null;
        this.brp = null;
        this.bry = null;
        this.brq = null;
        this.brr = null;
        brx = null;
    }

    private SensorEventListener Ty() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.bry != null) {
            return this.bry;
        }
        this.bry = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] Tz;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.brq = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.brr = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.brz != null && a.this.brq != null && a.this.brr != null && (Tz = a.this.Tz()) != null) {
                        a.this.brz.h(Tz);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] Tz() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.brq, this.brr) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
