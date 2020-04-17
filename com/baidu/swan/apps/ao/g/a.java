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
    private static volatile a cvT;
    private SensorManager aVf;
    private Sensor cvL;
    private float[] cvM;
    private float[] cvN;
    private SensorEventListener cvU;
    private InterfaceC0238a cvV;
    private Sensor cvu;
    private boolean cvx = false;

    /* renamed from: com.baidu.swan.apps.ao.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0238a {
        void w(float[] fArr);
    }

    public static a aoc() {
        if (cvT == null) {
            synchronized (a.class) {
                if (cvT == null) {
                    cvT = new a();
                }
            }
        }
        return cvT;
    }

    public boolean a(int i, @NonNull InterfaceC0238a interfaceC0238a) {
        if (this.cvx) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.cvV = interfaceC0238a;
            return true;
        }
        this.aVf = (SensorManager) com.baidu.swan.apps.w.a.abO().getSystemService("sensor");
        if (this.aVf != null) {
            this.cvV = interfaceC0238a;
            this.cvu = this.aVf.getDefaultSensor(1);
            this.cvL = this.aVf.getDefaultSensor(2);
            if (this.cvu == null || this.cvL == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.aVf.registerListener(aoe(), this.cvu, i);
            this.aVf.registerListener(aoe(), this.cvL, i);
            this.cvx = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void aod() {
        if (!this.cvx) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.cvx = false;
        if (this.cvU != null && this.aVf != null) {
            this.aVf.unregisterListener(this.cvU);
            this.cvU = null;
        }
        this.cvV = null;
        this.aVf = null;
        this.cvu = null;
        this.cvL = null;
    }

    public static void release() {
        if (cvT != null) {
            cvT.XJ();
        }
    }

    private void XJ() {
        c.i("SwanAppOrientationManager", "release");
        if (this.cvx) {
            aod();
        }
        this.aVf = null;
        this.cvu = null;
        this.cvL = null;
        this.cvU = null;
        this.cvM = null;
        this.cvN = null;
        cvT = null;
    }

    private SensorEventListener aoe() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.cvU != null) {
            return this.cvU;
        }
        this.cvU = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] aof;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.cvM = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.cvN = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.cvV != null && a.this.cvM != null && a.this.cvN != null && (aof = a.this.aof()) != null) {
                        a.this.cvV.w(aof);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cvU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] aof() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.cvM, this.cvN) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
