package com.baidu.swan.apps.al.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.swan.apps.console.c;
/* loaded from: classes8.dex */
public class a {
    private static volatile a cZb;
    private SensorManager bnN;
    private SensorEventListener cYL;
    private Sensor cYM;
    private SensorEventListener cZc;
    private Sensor cZd;
    private InterfaceC0340a cZh;
    private Context mContext;
    private float[] cZe = new float[3];
    private float[] cZf = new float[3];
    private int cZg = -100;
    private boolean cYP = false;
    private long cYQ = 0;

    /* renamed from: com.baidu.swan.apps.al.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0340a {
        void b(float f, int i);
    }

    private a() {
    }

    public static a aDE() {
        if (cZb == null) {
            synchronized (a.class) {
                if (cZb == null) {
                    cZb = new a();
                }
            }
        }
        return cZb;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0340a interfaceC0340a) {
        this.cZh = interfaceC0340a;
    }

    public void aDF() {
        if (this.mContext == null) {
            c.e(MapController.COMPASS_LAYER_TAG, "start error, none context");
        } else if (this.cYP) {
            c.w(MapController.COMPASS_LAYER_TAG, "has already start");
        } else {
            this.bnN = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.bnN != null) {
                this.cYM = this.bnN.getDefaultSensor(1);
                this.cZd = this.bnN.getDefaultSensor(2);
                this.bnN.registerListener(aDA(), this.cYM, 1);
                this.bnN.registerListener(aDH(), this.cZd, 1);
                this.cYP = true;
                c.i(MapController.COMPASS_LAYER_TAG, "start listen");
                return;
            }
            c.e(MapController.COMPASS_LAYER_TAG, "none sensorManager");
        }
    }

    public void aDG() {
        if (!this.cYP) {
            c.w(MapController.COMPASS_LAYER_TAG, "has already stop");
            return;
        }
        c.i(MapController.COMPASS_LAYER_TAG, "stop listen");
        if (this.cYL != null && this.bnN != null) {
            this.bnN.unregisterListener(this.cYL);
            this.cYL = null;
        }
        if (this.cZc != null && this.bnN != null) {
            this.bnN.unregisterListener(this.cZc);
            this.cZc = null;
        }
        this.bnN = null;
        this.cZd = null;
        this.cYM = null;
        this.cYP = false;
    }

    public static void release() {
        if (cZb != null) {
            cZb.aDz();
        }
    }

    private void aDz() {
        c.i(MapController.COMPASS_LAYER_TAG, "release");
        if (this.cYP) {
            aDG();
        }
        this.bnN = null;
        this.cZd = null;
        this.cYM = null;
        this.cYL = null;
        this.cZc = null;
        this.cZh = null;
        this.mContext = null;
        cZb = null;
    }

    private SensorEventListener aDA() {
        c.i(MapController.COMPASS_LAYER_TAG, "get Accelerometer listener");
        if (this.cYL != null) {
            return this.cYL;
        }
        this.cYL = new SensorEventListener() { // from class: com.baidu.swan.apps.al.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.cZe = sensorEvent.values;
                    a.this.cZg = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "accelerometer changed accuracy: " + a.this.cZg);
                    a.this.aDJ();
                    return;
                }
                c.w(MapController.COMPASS_LAYER_TAG, "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cYL;
    }

    private SensorEventListener aDH() {
        c.i(MapController.COMPASS_LAYER_TAG, "get MagneticFiled listener");
        if (this.cZc != null) {
            return this.cZc;
        }
        this.cZc = new SensorEventListener() { // from class: com.baidu.swan.apps.al.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.cZf = sensorEvent.values;
                    a.this.cZg = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "magneticFiled changed accuracy: " + a.this.cZg);
                    a.this.aDJ();
                    return;
                }
                c.w(MapController.COMPASS_LAYER_TAG, "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cZc;
    }

    private float aDI() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.cZe, this.cZf);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDJ() {
        if (this.cZh != null && System.currentTimeMillis() - this.cYQ > 200) {
            float aDI = aDI();
            c.d("SwanAppCompassManager", "orientation changed, orientation : " + aDI);
            this.cZh.b(aDI, this.cZg);
            this.cYQ = System.currentTimeMillis();
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
