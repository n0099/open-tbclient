package com.baidu.swan.apps.ak.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.swan.apps.console.c;
/* loaded from: classes9.dex */
public class a {
    private static volatile a dPA;
    private SensorEventListener dPB;
    private Sensor dPC;
    private InterfaceC0380a dPG;
    private SensorEventListener dPl;
    private Sensor dPm;
    private Context mContext;
    private SensorManager mSensorManager;
    private float[] dPD = new float[3];
    private float[] dPE = new float[3];
    private int dPF = -100;
    private boolean dPp = false;
    private long dPq = 0;

    /* renamed from: com.baidu.swan.apps.ak.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0380a {
        void b(float f, int i);
    }

    private a() {
    }

    public static a aQh() {
        if (dPA == null) {
            synchronized (a.class) {
                if (dPA == null) {
                    dPA = new a();
                }
            }
        }
        return dPA;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0380a interfaceC0380a) {
        this.dPG = interfaceC0380a;
    }

    public void aQi() {
        if (this.mContext == null) {
            c.e(MapController.COMPASS_LAYER_TAG, "start error, none context");
        } else if (this.dPp) {
            c.w(MapController.COMPASS_LAYER_TAG, "has already start");
        } else {
            this.mSensorManager = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.mSensorManager != null) {
                this.dPm = this.mSensorManager.getDefaultSensor(1);
                this.dPC = this.mSensorManager.getDefaultSensor(2);
                this.mSensorManager.registerListener(aQd(), this.dPm, 1);
                this.mSensorManager.registerListener(aQk(), this.dPC, 1);
                this.dPp = true;
                c.i(MapController.COMPASS_LAYER_TAG, "start listen");
                return;
            }
            c.e(MapController.COMPASS_LAYER_TAG, "none sensorManager");
        }
    }

    public void aQj() {
        if (!this.dPp) {
            c.w(MapController.COMPASS_LAYER_TAG, "has already stop");
            return;
        }
        c.i(MapController.COMPASS_LAYER_TAG, "stop listen");
        if (this.dPl != null && this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.dPl);
            this.dPl = null;
        }
        if (this.dPB != null && this.mSensorManager != null) {
            this.mSensorManager.unregisterListener(this.dPB);
            this.dPB = null;
        }
        this.mSensorManager = null;
        this.dPC = null;
        this.dPm = null;
        this.dPp = false;
    }

    public static void release() {
        if (dPA != null) {
            dPA.aQc();
        }
    }

    private void aQc() {
        c.i(MapController.COMPASS_LAYER_TAG, "release");
        if (this.dPp) {
            aQj();
        }
        this.mSensorManager = null;
        this.dPC = null;
        this.dPm = null;
        this.dPl = null;
        this.dPB = null;
        this.dPG = null;
        this.mContext = null;
        dPA = null;
    }

    private SensorEventListener aQd() {
        c.i(MapController.COMPASS_LAYER_TAG, "get Accelerometer listener");
        if (this.dPl != null) {
            return this.dPl;
        }
        this.dPl = new SensorEventListener() { // from class: com.baidu.swan.apps.ak.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.dPD = sensorEvent.values;
                    a.this.dPF = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "accelerometer changed accuracy: " + a.this.dPF);
                    a.this.aQm();
                    return;
                }
                c.w(MapController.COMPASS_LAYER_TAG, "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dPl;
    }

    private SensorEventListener aQk() {
        c.i(MapController.COMPASS_LAYER_TAG, "get MagneticFiled listener");
        if (this.dPB != null) {
            return this.dPB;
        }
        this.dPB = new SensorEventListener() { // from class: com.baidu.swan.apps.ak.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.dPE = sensorEvent.values;
                    a.this.dPF = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "magneticFiled changed accuracy: " + a.this.dPF);
                    a.this.aQm();
                    return;
                }
                c.w(MapController.COMPASS_LAYER_TAG, "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dPB;
    }

    private float aQl() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.dPD, this.dPE);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQm() {
        if (this.dPG != null && System.currentTimeMillis() - this.dPq > 200) {
            float aQl = aQl();
            c.d("SwanAppCompassManager", "orientation changed, orientation : " + aQl);
            this.dPG.b(aQl, this.dPF);
            this.dPq = System.currentTimeMillis();
        }
    }

    public static String lB(int i) {
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
