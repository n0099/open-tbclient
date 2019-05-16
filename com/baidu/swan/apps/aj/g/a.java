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
    private static volatile a aXn;
    private SensorManager aWq;
    private Sensor aWs;
    private boolean aWv = false;
    private Sensor aXf;
    private float[] aXg;
    private float[] aXh;
    private SensorEventListener aXo;
    private InterfaceC0116a aXp;

    /* renamed from: com.baidu.swan.apps.aj.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0116a {
        void h(float[] fArr);
    }

    public static a NN() {
        if (aXn == null) {
            synchronized (a.class) {
                if (aXn == null) {
                    aXn = new a();
                }
            }
        }
        return aXn;
    }

    public boolean a(int i, @NonNull InterfaceC0116a interfaceC0116a) {
        if (this.aWv) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.aXp = interfaceC0116a;
            return true;
        }
        this.aWq = (SensorManager) com.baidu.swan.apps.u.a.DB().getSystemService("sensor");
        if (this.aWq != null) {
            this.aXp = interfaceC0116a;
            this.aWs = this.aWq.getDefaultSensor(1);
            this.aXf = this.aWq.getDefaultSensor(2);
            if (this.aWs == null || this.aXf == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.aWq.registerListener(NP(), this.aWs, i);
            this.aWq.registerListener(NP(), this.aXf, i);
            this.aWv = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void NO() {
        if (!this.aWv) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.aWv = false;
        if (this.aXo != null && this.aWq != null) {
            this.aWq.unregisterListener(this.aXo);
            this.aXo = null;
        }
        this.aXp = null;
        this.aWq = null;
        this.aWs = null;
        this.aXf = null;
    }

    public static void release() {
        if (aXn != null) {
            aXn.AX();
        }
    }

    private void AX() {
        c.i("SwanAppOrientationManager", "release");
        if (this.aWv) {
            NO();
        }
        this.aWq = null;
        this.aWs = null;
        this.aXf = null;
        this.aXo = null;
        this.aXg = null;
        this.aXh = null;
        aXn = null;
    }

    private SensorEventListener NP() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.aXo != null) {
            return this.aXo;
        }
        this.aXo = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] NQ;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.aXg = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.aXh = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.aXp != null && a.this.aXg != null && a.this.aXh != null && (NQ = a.this.NQ()) != null) {
                        a.this.aXp.h(NQ);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.aXo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] NQ() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.aXg, this.aXh) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
