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
    private static volatile a aXX;
    private Sensor aXP;
    private float[] aXQ;
    private float[] aXR;
    private SensorEventListener aXY;
    private InterfaceC0113a aXZ;
    private SensorManager aXa;
    private Sensor aXc;
    private boolean aXf = false;

    /* renamed from: com.baidu.swan.apps.aj.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0113a {
        void h(float[] fArr);
    }

    public static a OC() {
        if (aXX == null) {
            synchronized (a.class) {
                if (aXX == null) {
                    aXX = new a();
                }
            }
        }
        return aXX;
    }

    public boolean a(int i, @NonNull InterfaceC0113a interfaceC0113a) {
        if (this.aXf) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.aXZ = interfaceC0113a;
            return true;
        }
        this.aXa = (SensorManager) com.baidu.swan.apps.u.a.Ek().getSystemService("sensor");
        if (this.aXa != null) {
            this.aXZ = interfaceC0113a;
            this.aXc = this.aXa.getDefaultSensor(1);
            this.aXP = this.aXa.getDefaultSensor(2);
            if (this.aXc == null || this.aXP == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.aXa.registerListener(OE(), this.aXc, i);
            this.aXa.registerListener(OE(), this.aXP, i);
            this.aXf = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void OD() {
        if (!this.aXf) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.aXf = false;
        if (this.aXY != null && this.aXa != null) {
            this.aXa.unregisterListener(this.aXY);
            this.aXY = null;
        }
        this.aXZ = null;
        this.aXa = null;
        this.aXc = null;
        this.aXP = null;
    }

    public static void release() {
        if (aXX != null) {
            aXX.BF();
        }
    }

    private void BF() {
        c.i("SwanAppOrientationManager", "release");
        if (this.aXf) {
            OD();
        }
        this.aXa = null;
        this.aXc = null;
        this.aXP = null;
        this.aXY = null;
        this.aXQ = null;
        this.aXR = null;
        aXX = null;
    }

    private SensorEventListener OE() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.aXY != null) {
            return this.aXY;
        }
        this.aXY = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] OF;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.aXQ = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.aXR = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.aXZ != null && a.this.aXQ != null && a.this.aXR != null && (OF = a.this.OF()) != null) {
                        a.this.aXZ.h(OF);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.aXY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] OF() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.aXQ, this.aXR) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
