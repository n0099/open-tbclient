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
    private static volatile a cYX;
    private SensorManager bnK;
    private SensorEventListener cYH;
    private Sensor cYI;
    private SensorEventListener cYY;
    private Sensor cYZ;
    private InterfaceC0340a cZd;
    private Context mContext;
    private float[] cZa = new float[3];
    private float[] cZb = new float[3];
    private int cZc = -100;
    private boolean cYL = false;
    private long cYM = 0;

    /* renamed from: com.baidu.swan.apps.al.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0340a {
        void b(float f, int i);
    }

    private a() {
    }

    public static a aDE() {
        if (cYX == null) {
            synchronized (a.class) {
                if (cYX == null) {
                    cYX = new a();
                }
            }
        }
        return cYX;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0340a interfaceC0340a) {
        this.cZd = interfaceC0340a;
    }

    public void aDF() {
        if (this.mContext == null) {
            c.e(MapController.COMPASS_LAYER_TAG, "start error, none context");
        } else if (this.cYL) {
            c.w(MapController.COMPASS_LAYER_TAG, "has already start");
        } else {
            this.bnK = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.bnK != null) {
                this.cYI = this.bnK.getDefaultSensor(1);
                this.cYZ = this.bnK.getDefaultSensor(2);
                this.bnK.registerListener(aDA(), this.cYI, 1);
                this.bnK.registerListener(aDH(), this.cYZ, 1);
                this.cYL = true;
                c.i(MapController.COMPASS_LAYER_TAG, "start listen");
                return;
            }
            c.e(MapController.COMPASS_LAYER_TAG, "none sensorManager");
        }
    }

    public void aDG() {
        if (!this.cYL) {
            c.w(MapController.COMPASS_LAYER_TAG, "has already stop");
            return;
        }
        c.i(MapController.COMPASS_LAYER_TAG, "stop listen");
        if (this.cYH != null && this.bnK != null) {
            this.bnK.unregisterListener(this.cYH);
            this.cYH = null;
        }
        if (this.cYY != null && this.bnK != null) {
            this.bnK.unregisterListener(this.cYY);
            this.cYY = null;
        }
        this.bnK = null;
        this.cYZ = null;
        this.cYI = null;
        this.cYL = false;
    }

    public static void release() {
        if (cYX != null) {
            cYX.aDz();
        }
    }

    private void aDz() {
        c.i(MapController.COMPASS_LAYER_TAG, "release");
        if (this.cYL) {
            aDG();
        }
        this.bnK = null;
        this.cYZ = null;
        this.cYI = null;
        this.cYH = null;
        this.cYY = null;
        this.cZd = null;
        this.mContext = null;
        cYX = null;
    }

    private SensorEventListener aDA() {
        c.i(MapController.COMPASS_LAYER_TAG, "get Accelerometer listener");
        if (this.cYH != null) {
            return this.cYH;
        }
        this.cYH = new SensorEventListener() { // from class: com.baidu.swan.apps.al.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.cZa = sensorEvent.values;
                    a.this.cZc = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "accelerometer changed accuracy: " + a.this.cZc);
                    a.this.aDJ();
                    return;
                }
                c.w(MapController.COMPASS_LAYER_TAG, "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cYH;
    }

    private SensorEventListener aDH() {
        c.i(MapController.COMPASS_LAYER_TAG, "get MagneticFiled listener");
        if (this.cYY != null) {
            return this.cYY;
        }
        this.cYY = new SensorEventListener() { // from class: com.baidu.swan.apps.al.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.cZb = sensorEvent.values;
                    a.this.cZc = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "magneticFiled changed accuracy: " + a.this.cZc);
                    a.this.aDJ();
                    return;
                }
                c.w(MapController.COMPASS_LAYER_TAG, "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cYY;
    }

    private float aDI() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.cZa, this.cZb);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDJ() {
        if (this.cZd != null && System.currentTimeMillis() - this.cYM > 200) {
            float aDI = aDI();
            c.d("SwanAppCompassManager", "orientation changed, orientation : " + aDI);
            this.cZd.b(aDI, this.cZc);
            this.cYM = System.currentTimeMillis();
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
