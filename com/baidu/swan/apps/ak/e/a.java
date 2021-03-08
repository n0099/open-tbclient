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
    private static volatile a dOt;
    private SensorEventListener dOe;
    private Sensor dOf;
    private SensorEventListener dOu;
    private Sensor dOv;
    private InterfaceC0366a dOz;
    private Context mContext;
    private SensorManager mSensorManager;
    private float[] dOw = new float[3];
    private float[] dOx = new float[3];
    private int dOy = -100;
    private boolean dOi = false;
    private long dOj = 0;

    /* renamed from: com.baidu.swan.apps.ak.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0366a {
        void b(float f, int i);
    }

    private a() {
    }

    public static a aMJ() {
        if (dOt == null) {
            synchronized (a.class) {
                if (dOt == null) {
                    dOt = new a();
                }
            }
        }
        return dOt;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0366a interfaceC0366a) {
        this.dOz = interfaceC0366a;
    }

    public void aMK() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.dOi) {
            c.w("compass", "has already start");
        } else {
            this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.mSensorManager != null) {
                this.dOf = this.mSensorManager.getDefaultSensor(1);
                this.dOv = this.mSensorManager.getDefaultSensor(2);
                this.mSensorManager.registerListener(aMF(), this.dOf, 1);
                this.mSensorManager.registerListener(aMM(), this.dOv, 1);
                this.dOi = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void aML() {
        if (!this.dOi) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.dOe != null && this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.dOe);
            this.dOe = null;
        }
        if (this.dOu != null && this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.dOu);
            this.dOu = null;
        }
        this.mSensorManager = null;
        this.dOv = null;
        this.dOf = null;
        this.dOi = false;
    }

    public static void release() {
        if (dOt != null) {
            dOt.aME();
        }
    }

    private void aME() {
        c.i("compass", "release");
        if (this.dOi) {
            aML();
        }
        this.mSensorManager = null;
        this.dOv = null;
        this.dOf = null;
        this.dOe = null;
        this.dOu = null;
        this.dOz = null;
        this.mContext = null;
        dOt = null;
    }

    private SensorEventListener aMF() {
        c.i("compass", "get Accelerometer listener");
        if (this.dOe != null) {
            return this.dOe;
        }
        this.dOe = new SensorEventListener() { // from class: com.baidu.swan.apps.ak.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.dOw = sensorEvent.values;
                    a.this.dOy = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "accelerometer changed accuracy: " + a.this.dOy);
                    a.this.aMO();
                    return;
                }
                c.w("compass", "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dOe;
    }

    private SensorEventListener aMM() {
        c.i("compass", "get MagneticFiled listener");
        if (this.dOu != null) {
            return this.dOu;
        }
        this.dOu = new SensorEventListener() { // from class: com.baidu.swan.apps.ak.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.dOx = sensorEvent.values;
                    a.this.dOy = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "magneticFiled changed accuracy: " + a.this.dOy);
                    a.this.aMO();
                    return;
                }
                c.w("compass", "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dOu;
    }

    private float aMN() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.dOw, this.dOx);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMO() {
        if (this.dOz != null && System.currentTimeMillis() - this.dOj > 200) {
            float aMN = aMN();
            c.d("SwanAppCompassManager", "orientation changed, orientation : " + aMN);
            this.dOz.b(aMN, this.dOy);
            this.dOj = System.currentTimeMillis();
        }
    }

    public static String jZ(int i) {
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
