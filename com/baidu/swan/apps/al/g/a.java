package com.baidu.swan.apps.al.g;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.swan.apps.console.c;
/* loaded from: classes3.dex */
public class a {
    private static volatile a dbo;
    private SensorManager bqI;
    private Sensor daO;
    private boolean daR = false;
    private Sensor dbf;
    private float[] dbg;
    private float[] dbh;
    private SensorEventListener dbp;
    private InterfaceC0336a dbq;

    /* renamed from: com.baidu.swan.apps.al.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0336a {
        void x(float[] fArr);
    }

    public static a aEu() {
        if (dbo == null) {
            synchronized (a.class) {
                if (dbo == null) {
                    dbo = new a();
                }
            }
        }
        return dbo;
    }

    public boolean a(int i, @NonNull InterfaceC0336a interfaceC0336a) {
        if (this.daR) {
            c.w("SwanAppOrientationManager", "has already start, change new listener");
            this.dbq = interfaceC0336a;
            return true;
        }
        this.bqI = (SensorManager) com.baidu.swan.apps.t.a.apu().getSystemService("sensor");
        if (this.bqI != null) {
            this.dbq = interfaceC0336a;
            this.daO = this.bqI.getDefaultSensor(1);
            this.dbf = this.bqI.getDefaultSensor(2);
            if (this.daO == null || this.dbf == null) {
                c.e("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            this.bqI.registerListener(aEw(), this.daO, i);
            this.bqI.registerListener(aEw(), this.dbf, i);
            this.daR = true;
            c.i("SwanAppOrientationManager", "start listen");
            return true;
        }
        c.e("SwanAppOrientationManager", "none sensorManager");
        return false;
    }

    public void aEv() {
        if (!this.daR) {
            c.w("SwanAppOrientationManager", "has already stop");
            return;
        }
        this.daR = false;
        if (this.dbp != null && this.bqI != null) {
            this.bqI.unregisterListener(this.dbp);
            this.dbp = null;
        }
        this.dbq = null;
        this.bqI = null;
        this.daO = null;
        this.dbf = null;
    }

    public static void release() {
        if (dbo != null) {
            dbo.aEj();
        }
    }

    private void aEj() {
        c.i("SwanAppOrientationManager", "release");
        if (this.daR) {
            aEv();
        }
        this.bqI = null;
        this.daO = null;
        this.dbf = null;
        this.dbp = null;
        this.dbg = null;
        this.dbh = null;
        dbo = null;
    }

    private SensorEventListener aEw() {
        c.i("SwanAppOrientationManager", "get System Sensor listener");
        if (this.dbp != null) {
            return this.dbp;
        }
        this.dbp = new SensorEventListener() { // from class: com.baidu.swan.apps.al.g.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                float[] aEx;
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.dbg = (float[]) sensorEvent.values.clone();
                    }
                } else if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    if (sensorEvent.values != null && sensorEvent.values.length == 3) {
                        a.this.dbh = (float[]) sensorEvent.values.clone();
                    }
                    if (a.this.dbq != null && a.this.dbg != null && a.this.dbh != null && (aEx = a.this.aEx()) != null) {
                        a.this.dbq.x(aEx);
                    }
                }
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dbp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public float[] aEx() {
        float[] fArr = new float[9];
        float[] fArr2 = new float[9];
        float[] fArr3 = new float[3];
        if (SensorManager.getRotationMatrix(fArr, null, this.dbg, this.dbh) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
            SensorManager.getOrientation(fArr2, fArr3);
            return fArr3;
        }
        return null;
    }
}
