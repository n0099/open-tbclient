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
    private static volatile a aYv;
    private Sensor aXA;
    private boolean aXD = false;
    private SensorManager aXy;
    private Sensor aYn;
    private float[] aYo;
    private float[] aYp;
    private SensorEventListener aYw;
    private InterfaceC0127a aYx;

    /* renamed from: com.baidu.swan.apps.aj.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0127a {
        void h(float[] fArr);
    }

    public static a OG() {
        if (aYv == null) {
            synchronized (a.class) {
                if (aYv == null) {
                    aYv = new a();
                }
            }
        }
        return aYv;
    }

    public boolean a(int i, @NonNull InterfaceC0127a interfaceC0127a) {
        if (this.aXD) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.aYx = interfaceC0127a;
            return true;
        }
        this.aXy = (SensorManager) com.baidu.swan.apps.u.a.Eo().getSystemService("sensor");
        if (this.aXy != null) {
            this.aYx = interfaceC0127a;
            this.aXA = this.aXy.getDefaultSensor(1);
            this.aYn = this.aXy.getDefaultSensor(2);
            if (this.aXA == null || this.aYn == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.aXy.registerListener(OI(), this.aXA, i);
            this.aXy.registerListener(OI(), this.aYn, i);
            this.aXD = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void OH() {
        if (!this.aXD) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.aXD = false;
        if (this.aYw != null && this.aXy != null) {
            this.aXy.unregisterListener(this.aYw);
            this.aYw = null;
        }
        this.aYx = null;
        this.aXy = null;
        this.aXA = null;
        this.aYn = null;
    }

    public static void release() {
        if (aYv != null) {
            aYv.BJ();
        }
    }

    private void BJ() {
        c.i("SwanAppOrientationManager", "release");
        if (this.aXD) {
            OH();
        }
        this.aXy = null;
        this.aXA = null;
        this.aYn = null;
        this.aYw = null;
        this.aYo = null;
        this.aYp = null;
        aYv = null;
    }

    private SensorEventListener OI() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.aYw != null) {
            return this.aYw;
        }
        this.aYw = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] OJ;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.aYo = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.aYp = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.aYx != null && a.this.aYo != null && a.this.aYp != null && (OJ = a.this.OJ()) != null) {
                        a.this.aYx.h(OJ);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.aYw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] OJ() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.aYo, this.aYp) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
