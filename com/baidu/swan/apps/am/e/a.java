package com.baidu.swan.apps.am.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.console.c;
/* loaded from: classes11.dex */
public class a {
    private static volatile a cMA;
    private SensorManager bhI;
    private SensorEventListener cMB;
    private Sensor cMC;
    private InterfaceC0298a cMG;
    private SensorEventListener cMk;
    private Sensor cMl;
    private Context mContext;
    private float[] cMD = new float[3];
    private float[] cME = new float[3];
    private int cMF = -100;
    private boolean cMo = false;
    private long cMp = 0;

    /* renamed from: com.baidu.swan.apps.am.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0298a {
        void b(float f, int i);
    }

    private a() {
    }

    public static a atu() {
        if (cMA == null) {
            synchronized (a.class) {
                if (cMA == null) {
                    cMA = new a();
                }
            }
        }
        return cMA;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0298a interfaceC0298a) {
        this.cMG = interfaceC0298a;
    }

    public void atv() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.cMo) {
            c.w("compass", "has already start");
        } else {
            this.bhI = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.bhI != null) {
                this.cMl = this.bhI.getDefaultSensor(1);
                this.cMC = this.bhI.getDefaultSensor(2);
                this.bhI.registerListener(atq(), this.cMl, 1);
                this.bhI.registerListener(atx(), this.cMC, 1);
                this.cMo = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void atw() {
        if (!this.cMo) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.cMk != null && this.bhI != null) {
            this.bhI.unregisterListener(this.cMk);
            this.cMk = null;
        }
        if (this.cMB != null && this.bhI != null) {
            this.bhI.unregisterListener(this.cMB);
            this.cMB = null;
        }
        this.bhI = null;
        this.cMC = null;
        this.cMl = null;
        this.cMo = false;
    }

    public static void release() {
        if (cMA != null) {
            cMA.atp();
        }
    }

    private void atp() {
        c.i("compass", "release");
        if (this.cMo) {
            atw();
        }
        this.bhI = null;
        this.cMC = null;
        this.cMl = null;
        this.cMk = null;
        this.cMB = null;
        this.cMG = null;
        this.mContext = null;
        cMA = null;
    }

    private SensorEventListener atq() {
        c.i("compass", "get Accelerometer listener");
        if (this.cMk != null) {
            return this.cMk;
        }
        this.cMk = new SensorEventListener() { // from class: com.baidu.swan.apps.am.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.cMD = sensorEvent.values;
                    a.this.cMF = sensorEvent.accuracy;
                    c.i("compass", "accelerometer changed accuracy: " + a.this.cMF);
                    a.this.atz();
                    return;
                }
                c.w("compass", "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cMk;
    }

    private SensorEventListener atx() {
        c.i("compass", "get MagneticFiled listener");
        if (this.cMB != null) {
            return this.cMB;
        }
        this.cMB = new SensorEventListener() { // from class: com.baidu.swan.apps.am.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.cME = sensorEvent.values;
                    a.this.cMF = sensorEvent.accuracy;
                    c.i("compass", "magneticFiled changed accuracy: " + a.this.cMF);
                    a.this.atz();
                    return;
                }
                c.w("compass", "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cMB;
    }

    private float aty() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.cMD, this.cME);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atz() {
        if (this.cMG != null && System.currentTimeMillis() - this.cMp > 200) {
            float aty = aty();
            c.i("compass", "orientation changed, orientation : " + aty);
            this.cMG.b(aty, this.cMF);
            this.cMp = System.currentTimeMillis();
        }
    }

    public static String hH(int i) {
        switch (i) {
            case -1:
                return "no-contact";
            case 0:
                return "unreliable";
            case 1:
                return Config.EXCEPTION_MEMORY_LOW;
            case 2:
                return "medium";
            case 3:
                return "high";
            default:
                return "unknow";
        }
    }
}
