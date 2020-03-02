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
    private static volatile a bWQ;
    private SensorManager aBj;
    private Sensor bWI;
    private float[] bWJ;
    private float[] bWK;
    private SensorEventListener bWR;
    private InterfaceC0208a bWS;
    private Sensor bWr;
    private boolean bWu = false;

    /* renamed from: com.baidu.swan.apps.ao.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0208a {
        void i(float[] fArr);
    }

    public static a afU() {
        if (bWQ == null) {
            synchronized (a.class) {
                if (bWQ == null) {
                    bWQ = new a();
                }
            }
        }
        return bWQ;
    }

    public boolean a(int i, @NonNull InterfaceC0208a interfaceC0208a) {
        if (this.bWu) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.bWS = interfaceC0208a;
            return true;
        }
        this.aBj = (SensorManager) com.baidu.swan.apps.w.a.TW().getSystemService("sensor");
        if (this.aBj != null) {
            this.bWS = interfaceC0208a;
            this.bWr = this.aBj.getDefaultSensor(1);
            this.bWI = this.aBj.getDefaultSensor(2);
            if (this.bWr == null || this.bWI == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.aBj.registerListener(afW(), this.bWr, i);
            this.aBj.registerListener(afW(), this.bWI, i);
            this.bWu = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void afV() {
        if (!this.bWu) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.bWu = false;
        if (this.bWR != null && this.aBj != null) {
            this.aBj.unregisterListener(this.bWR);
            this.bWR = null;
        }
        this.bWS = null;
        this.aBj = null;
        this.bWr = null;
        this.bWI = null;
    }

    public static void release() {
        if (bWQ != null) {
            bWQ.PR();
        }
    }

    private void PR() {
        c.i("SwanAppOrientationManager", "release");
        if (this.bWu) {
            afV();
        }
        this.aBj = null;
        this.bWr = null;
        this.bWI = null;
        this.bWR = null;
        this.bWJ = null;
        this.bWK = null;
        bWQ = null;
    }

    private SensorEventListener afW() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.bWR != null) {
            return this.bWR;
        }
        this.bWR = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] afX;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.bWJ = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.bWK = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.bWS != null && a.this.bWJ != null && a.this.bWK != null && (afX = a.this.afX()) != null) {
                        a.this.bWS.i(afX);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bWR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] afX() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.bWJ, this.bWK) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
