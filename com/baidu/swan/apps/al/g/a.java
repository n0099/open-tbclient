package com.baidu.swan.apps.al.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.console.c;
/* loaded from: classes8.dex */
public class a {
    private static volatile a cZi;
    private SensorManager bnK;
    private Sensor cYI;
    private boolean cYL = false;
    private Sensor cYZ;
    private float[] cZa;
    private float[] cZb;
    private SensorEventListener cZj;
    private InterfaceC0341a cZk;

    /* renamed from: com.baidu.swan.apps.al.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0341a {
        void x(float[] fArr);
    }

    public static a aDK() {
        if (cZi == null) {
            synchronized (a.class) {
                if (cZi == null) {
                    cZi = new a();
                }
            }
        }
        return cZi;
    }

    public boolean a(int i, @NonNull InterfaceC0341a interfaceC0341a) {
        if (this.cYL) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.cZk = interfaceC0341a;
            return true;
        }
        this.bnK = (SensorManager) com.baidu.swan.apps.t.a.aoJ().getSystemService("sensor");
        if (this.bnK != null) {
            this.cZk = interfaceC0341a;
            this.cYI = this.bnK.getDefaultSensor(1);
            this.cYZ = this.bnK.getDefaultSensor(2);
            if (this.cYI == null || this.cYZ == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.bnK.registerListener(aDM(), this.cYI, i);
            this.bnK.registerListener(aDM(), this.cYZ, i);
            this.cYL = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void aDL() {
        if (!this.cYL) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.cYL = false;
        if (this.cZj != null && this.bnK != null) {
            this.bnK.unregisterListener(this.cZj);
            this.cZj = null;
        }
        this.cZk = null;
        this.bnK = null;
        this.cYI = null;
        this.cYZ = null;
    }

    public static void release() {
        if (cZi != null) {
            cZi.aDz();
        }
    }

    private void aDz() {
        c.i("SwanAppOrientationManager", "release");
        if (this.cYL) {
            aDL();
        }
        this.bnK = null;
        this.cYI = null;
        this.cYZ = null;
        this.cZj = null;
        this.cZa = null;
        this.cZb = null;
        cZi = null;
    }

    private SensorEventListener aDM() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.cZj != null) {
            return this.cZj;
        }
        this.cZj = new SensorEventListener() { // from class: com.baidu.swan.apps.al.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] aDN;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.cZa = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.cZb = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.cZk != null && a.this.cZa != null && a.this.cZb != null && (aDN = a.this.aDN()) != null) {
                        a.this.cZk.x(aDN);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cZj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] aDN() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.cZa, this.cZb) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
