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
    private static volatile a bWR;
    private SensorManager aBk;
    private Sensor bWJ;
    private float[] bWK;
    private float[] bWL;
    private SensorEventListener bWS;
    private InterfaceC0208a bWT;
    private Sensor bWs;
    private boolean bWv = false;

    /* renamed from: com.baidu.swan.apps.ao.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0208a {
        void i(float[] fArr);
    }

    public static a afU() {
        if (bWR == null) {
            synchronized (a.class) {
                if (bWR == null) {
                    bWR = new a();
                }
            }
        }
        return bWR;
    }

    public boolean a(int i, @NonNull InterfaceC0208a interfaceC0208a) {
        if (this.bWv) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.bWT = interfaceC0208a;
            return true;
        }
        this.aBk = (SensorManager) com.baidu.swan.apps.w.a.TW().getSystemService("sensor");
        if (this.aBk != null) {
            this.bWT = interfaceC0208a;
            this.bWs = this.aBk.getDefaultSensor(1);
            this.bWJ = this.aBk.getDefaultSensor(2);
            if (this.bWs == null || this.bWJ == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.aBk.registerListener(afW(), this.bWs, i);
            this.aBk.registerListener(afW(), this.bWJ, i);
            this.bWv = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void afV() {
        if (!this.bWv) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.bWv = false;
        if (this.bWS != null && this.aBk != null) {
            this.aBk.unregisterListener(this.bWS);
            this.bWS = null;
        }
        this.bWT = null;
        this.aBk = null;
        this.bWs = null;
        this.bWJ = null;
    }

    public static void release() {
        if (bWR != null) {
            bWR.PR();
        }
    }

    private void PR() {
        c.i("SwanAppOrientationManager", "release");
        if (this.bWv) {
            afV();
        }
        this.aBk = null;
        this.bWs = null;
        this.bWJ = null;
        this.bWS = null;
        this.bWK = null;
        this.bWL = null;
        bWR = null;
    }

    private SensorEventListener afW() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.bWS != null) {
            return this.bWS;
        }
        this.bWS = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] afX;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.bWK = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.bWL = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.bWT != null && a.this.bWK != null && a.this.bWL != null && (afX = a.this.afX()) != null) {
                        a.this.bWT.i(afX);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bWS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] afX() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.bWK, this.bWL) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
