package com.baidu.swan.apps.ak.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.console.c;
/* loaded from: classes9.dex */
public class a {
    private static volatile a dMS;
    private SensorEventListener dMD;
    private Sensor dME;
    private SensorEventListener dMT;
    private Sensor dMU;
    private InterfaceC0360a dMY;
    private Context mContext;
    private SensorManager mSensorManager;
    private float[] dMV = new float[3];
    private float[] dMW = new float[3];
    private int dMX = -100;
    private boolean dMH = false;
    private long dMI = 0;

    /* renamed from: com.baidu.swan.apps.ak.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0360a {
        void b(float f, int i);
    }

    private a() {
    }

    public static a aMG() {
        if (dMS == null) {
            synchronized (a.class) {
                if (dMS == null) {
                    dMS = new a();
                }
            }
        }
        return dMS;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0360a interfaceC0360a) {
        this.dMY = interfaceC0360a;
    }

    public void aMH() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.dMH) {
            c.w("compass", "has already start");
        } else {
            this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.mSensorManager != null) {
                this.dME = this.mSensorManager.getDefaultSensor(1);
                this.dMU = this.mSensorManager.getDefaultSensor(2);
                this.mSensorManager.registerListener(aMC(), this.dME, 1);
                this.mSensorManager.registerListener(aMJ(), this.dMU, 1);
                this.dMH = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void aMI() {
        if (!this.dMH) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.dMD != null && this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.dMD);
            this.dMD = null;
        }
        if (this.dMT != null && this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.dMT);
            this.dMT = null;
        }
        this.mSensorManager = null;
        this.dMU = null;
        this.dME = null;
        this.dMH = false;
    }

    public static void release() {
        if (dMS != null) {
            dMS.aMB();
        }
    }

    private void aMB() {
        c.i("compass", "release");
        if (this.dMH) {
            aMI();
        }
        this.mSensorManager = null;
        this.dMU = null;
        this.dME = null;
        this.dMD = null;
        this.dMT = null;
        this.dMY = null;
        this.mContext = null;
        dMS = null;
    }

    private SensorEventListener aMC() {
        c.i("compass", "get Accelerometer listener");
        if (this.dMD != null) {
            return this.dMD;
        }
        this.dMD = new SensorEventListener() { // from class: com.baidu.swan.apps.ak.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.dMV = sensorEvent.values;
                    a.this.dMX = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "accelerometer changed accuracy: " + a.this.dMX);
                    a.this.aML();
                    return;
                }
                c.w("compass", "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dMD;
    }

    private SensorEventListener aMJ() {
        c.i("compass", "get MagneticFiled listener");
        if (this.dMT != null) {
            return this.dMT;
        }
        this.dMT = new SensorEventListener() { // from class: com.baidu.swan.apps.ak.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.dMW = sensorEvent.values;
                    a.this.dMX = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "magneticFiled changed accuracy: " + a.this.dMX);
                    a.this.aML();
                    return;
                }
                c.w("compass", "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dMT;
    }

    private float aMK() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.dMV, this.dMW);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aML() {
        if (this.dMY != null && System.currentTimeMillis() - this.dMI > 200) {
            float aMK = aMK();
            c.d("SwanAppCompassManager", "orientation changed, orientation : " + aMK);
            this.dMY.b(aMK, this.dMX);
            this.dMI = System.currentTimeMillis();
        }
    }

    public static String jY(int i) {
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
