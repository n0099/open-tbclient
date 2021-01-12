package com.baidu.swan.apps.ak.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.console.c;
/* loaded from: classes8.dex */
public class a {
    private static volatile a dKO;
    private Sensor dKA;
    private SensorEventListener dKP;
    private Sensor dKQ;
    private InterfaceC0363a dKU;
    private SensorEventListener dKz;
    private Context mContext;
    private SensorManager mSensorManager;
    private float[] dKR = new float[3];
    private float[] dKS = new float[3];
    private int dKT = -100;
    private boolean dKD = false;
    private long dKE = 0;

    /* renamed from: com.baidu.swan.apps.ak.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0363a {
        void b(float f, int i);
    }

    private a() {
    }

    public static a aMn() {
        if (dKO == null) {
            synchronized (a.class) {
                if (dKO == null) {
                    dKO = new a();
                }
            }
        }
        return dKO;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0363a interfaceC0363a) {
        this.dKU = interfaceC0363a;
    }

    public void aMo() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.dKD) {
            c.w("compass", "has already start");
        } else {
            this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.mSensorManager != null) {
                this.dKA = this.mSensorManager.getDefaultSensor(1);
                this.dKQ = this.mSensorManager.getDefaultSensor(2);
                this.mSensorManager.registerListener(aMj(), this.dKA, 1);
                this.mSensorManager.registerListener(aMq(), this.dKQ, 1);
                this.dKD = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void aMp() {
        if (!this.dKD) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.dKz != null && this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.dKz);
            this.dKz = null;
        }
        if (this.dKP != null && this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.dKP);
            this.dKP = null;
        }
        this.mSensorManager = null;
        this.dKQ = null;
        this.dKA = null;
        this.dKD = false;
    }

    public static void release() {
        if (dKO != null) {
            dKO.aMi();
        }
    }

    private void aMi() {
        c.i("compass", "release");
        if (this.dKD) {
            aMp();
        }
        this.mSensorManager = null;
        this.dKQ = null;
        this.dKA = null;
        this.dKz = null;
        this.dKP = null;
        this.dKU = null;
        this.mContext = null;
        dKO = null;
    }

    private SensorEventListener aMj() {
        c.i("compass", "get Accelerometer listener");
        if (this.dKz != null) {
            return this.dKz;
        }
        this.dKz = new SensorEventListener() { // from class: com.baidu.swan.apps.ak.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.dKR = sensorEvent.values;
                    a.this.dKT = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "accelerometer changed accuracy: " + a.this.dKT);
                    a.this.aMs();
                    return;
                }
                c.w("compass", "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dKz;
    }

    private SensorEventListener aMq() {
        c.i("compass", "get MagneticFiled listener");
        if (this.dKP != null) {
            return this.dKP;
        }
        this.dKP = new SensorEventListener() { // from class: com.baidu.swan.apps.ak.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.dKS = sensorEvent.values;
                    a.this.dKT = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "magneticFiled changed accuracy: " + a.this.dKT);
                    a.this.aMs();
                    return;
                }
                c.w("compass", "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dKP;
    }

    private float aMr() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.dKR, this.dKS);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMs() {
        if (this.dKU != null && System.currentTimeMillis() - this.dKE > 200) {
            float aMr = aMr();
            c.d("SwanAppCompassManager", "orientation changed, orientation : " + aMr);
            this.dKU.b(aMr, this.dKT);
            this.dKE = System.currentTimeMillis();
        }
    }

    public static String jV(int i) {
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
