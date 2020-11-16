package com.baidu.swan.apps.al.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.swan.apps.console.c;
/* loaded from: classes7.dex */
public class a {
    private static volatile a dzY;
    private SensorManager bBc;
    private Sensor dAa;
    private InterfaceC0376a dAe;
    private SensorEventListener dzI;
    private Sensor dzJ;
    private SensorEventListener dzZ;
    private Context mContext;
    private float[] dAb = new float[3];
    private float[] dAc = new float[3];
    private int dAd = -100;
    private boolean dzM = false;
    private long dzN = 0;

    /* renamed from: com.baidu.swan.apps.al.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0376a {
        void b(float f, int i);
    }

    private a() {
    }

    public static a aKJ() {
        if (dzY == null) {
            synchronized (a.class) {
                if (dzY == null) {
                    dzY = new a();
                }
            }
        }
        return dzY;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0376a interfaceC0376a) {
        this.dAe = interfaceC0376a;
    }

    public void aKK() {
        if (this.mContext == null) {
            c.e(MapController.COMPASS_LAYER_TAG, "start error, none context");
        } else if (this.dzM) {
            c.w(MapController.COMPASS_LAYER_TAG, "has already start");
        } else {
            this.bBc = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.bBc != null) {
                this.dzJ = this.bBc.getDefaultSensor(1);
                this.dAa = this.bBc.getDefaultSensor(2);
                this.bBc.registerListener(aKF(), this.dzJ, 1);
                this.bBc.registerListener(aKM(), this.dAa, 1);
                this.dzM = true;
                c.i(MapController.COMPASS_LAYER_TAG, "start listen");
                return;
            }
            c.e(MapController.COMPASS_LAYER_TAG, "none sensorManager");
        }
    }

    public void aKL() {
        if (!this.dzM) {
            c.w(MapController.COMPASS_LAYER_TAG, "has already stop");
            return;
        }
        c.i(MapController.COMPASS_LAYER_TAG, "stop listen");
        if (this.dzI != null && this.bBc != null) {
            this.bBc.unregisterListener(this.dzI);
            this.dzI = null;
        }
        if (this.dzZ != null && this.bBc != null) {
            this.bBc.unregisterListener(this.dzZ);
            this.dzZ = null;
        }
        this.bBc = null;
        this.dAa = null;
        this.dzJ = null;
        this.dzM = false;
    }

    public static void release() {
        if (dzY != null) {
            dzY.aKE();
        }
    }

    private void aKE() {
        c.i(MapController.COMPASS_LAYER_TAG, "release");
        if (this.dzM) {
            aKL();
        }
        this.bBc = null;
        this.dAa = null;
        this.dzJ = null;
        this.dzI = null;
        this.dzZ = null;
        this.dAe = null;
        this.mContext = null;
        dzY = null;
    }

    private SensorEventListener aKF() {
        c.i(MapController.COMPASS_LAYER_TAG, "get Accelerometer listener");
        if (this.dzI != null) {
            return this.dzI;
        }
        this.dzI = new SensorEventListener() { // from class: com.baidu.swan.apps.al.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.dAb = sensorEvent.values;
                    a.this.dAd = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "accelerometer changed accuracy: " + a.this.dAd);
                    a.this.aKO();
                    return;
                }
                c.w(MapController.COMPASS_LAYER_TAG, "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dzI;
    }

    private SensorEventListener aKM() {
        c.i(MapController.COMPASS_LAYER_TAG, "get MagneticFiled listener");
        if (this.dzZ != null) {
            return this.dzZ;
        }
        this.dzZ = new SensorEventListener() { // from class: com.baidu.swan.apps.al.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.dAc = sensorEvent.values;
                    a.this.dAd = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "magneticFiled changed accuracy: " + a.this.dAd);
                    a.this.aKO();
                    return;
                }
                c.w(MapController.COMPASS_LAYER_TAG, "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dzZ;
    }

    private float aKN() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.dAb, this.dAc);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKO() {
        if (this.dAe != null && System.currentTimeMillis() - this.dzN > 200) {
            float aKN = aKN();
            c.d("SwanAppCompassManager", "orientation changed, orientation : " + aKN);
            this.dAe.b(aKN, this.dAd);
            this.dzN = System.currentTimeMillis();
        }
    }

    public static String kY(int i) {
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
