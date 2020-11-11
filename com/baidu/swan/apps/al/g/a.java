package com.baidu.swan.apps.al.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.console.c;
/* loaded from: classes10.dex */
public class a {
    private static volatile a dBQ;
    private SensorManager bCN;
    private Sensor dBH;
    private float[] dBI;
    private float[] dBJ;
    private SensorEventListener dBR;
    private InterfaceC0379a dBS;
    private Sensor dBq;
    private boolean dBt = false;

    /* renamed from: com.baidu.swan.apps.al.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0379a {
        void x(float[] fArr);
    }

    public static a aLx() {
        if (dBQ == null) {
            synchronized (a.class) {
                if (dBQ == null) {
                    dBQ = new a();
                }
            }
        }
        return dBQ;
    }

    public boolean a(int i, @NonNull InterfaceC0379a interfaceC0379a) {
        if (this.dBt) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.dBS = interfaceC0379a;
            return true;
        }
        this.bCN = (SensorManager) com.baidu.swan.apps.t.a.awA().getSystemService("sensor");
        if (this.bCN != null) {
            this.dBS = interfaceC0379a;
            this.dBq = this.bCN.getDefaultSensor(1);
            this.dBH = this.bCN.getDefaultSensor(2);
            if (this.dBq == null || this.dBH == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.bCN.registerListener(aLz(), this.dBq, i);
            this.bCN.registerListener(aLz(), this.dBH, i);
            this.dBt = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void aLy() {
        if (!this.dBt) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.dBt = false;
        if (this.dBR != null && this.bCN != null) {
            this.bCN.unregisterListener(this.dBR);
            this.dBR = null;
        }
        this.dBS = null;
        this.bCN = null;
        this.dBq = null;
        this.dBH = null;
    }

    public static void release() {
        if (dBQ != null) {
            dBQ.aLm();
        }
    }

    private void aLm() {
        c.i("SwanAppOrientationManager", "release");
        if (this.dBt) {
            aLy();
        }
        this.bCN = null;
        this.dBq = null;
        this.dBH = null;
        this.dBR = null;
        this.dBI = null;
        this.dBJ = null;
        dBQ = null;
    }

    private SensorEventListener aLz() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.dBR != null) {
            return this.dBR;
        }
        this.dBR = new SensorEventListener() { // from class: com.baidu.swan.apps.al.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] aLA;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.dBI = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.dBJ = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.dBS != null && a.this.dBI != null && a.this.dBJ != null && (aLA = a.this.aLA()) != null) {
                        a.this.dBS.x(aLA);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dBR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] aLA() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.dBI, this.dBJ) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
