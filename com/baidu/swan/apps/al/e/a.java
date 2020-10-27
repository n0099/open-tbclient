package com.baidu.swan.apps.al.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.swan.apps.console.c;
/* loaded from: classes10.dex */
public class a {
    private static volatile a dvN;
    private SensorManager bwC;
    private SensorEventListener dvO;
    private Sensor dvP;
    private InterfaceC0366a dvT;
    private SensorEventListener dvx;
    private Sensor dvy;
    private Context mContext;
    private float[] dvQ = new float[3];
    private float[] dvR = new float[3];
    private int dvS = -100;
    private boolean dvB = false;
    private long dvC = 0;

    /* renamed from: com.baidu.swan.apps.al.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0366a {
        void b(float f, int i);
    }

    private a() {
    }

    public static a aIR() {
        if (dvN == null) {
            synchronized (a.class) {
                if (dvN == null) {
                    dvN = new a();
                }
            }
        }
        return dvN;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0366a interfaceC0366a) {
        this.dvT = interfaceC0366a;
    }

    public void aIS() {
        if (this.mContext == null) {
            c.e(MapController.COMPASS_LAYER_TAG, "start error, none context");
        } else if (this.dvB) {
            c.w(MapController.COMPASS_LAYER_TAG, "has already start");
        } else {
            this.bwC = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.bwC != null) {
                this.dvy = this.bwC.getDefaultSensor(1);
                this.dvP = this.bwC.getDefaultSensor(2);
                this.bwC.registerListener(aIN(), this.dvy, 1);
                this.bwC.registerListener(aIU(), this.dvP, 1);
                this.dvB = true;
                c.i(MapController.COMPASS_LAYER_TAG, "start listen");
                return;
            }
            c.e(MapController.COMPASS_LAYER_TAG, "none sensorManager");
        }
    }

    public void aIT() {
        if (!this.dvB) {
            c.w(MapController.COMPASS_LAYER_TAG, "has already stop");
            return;
        }
        c.i(MapController.COMPASS_LAYER_TAG, "stop listen");
        if (this.dvx != null && this.bwC != null) {
            this.bwC.unregisterListener(this.dvx);
            this.dvx = null;
        }
        if (this.dvO != null && this.bwC != null) {
            this.bwC.unregisterListener(this.dvO);
            this.dvO = null;
        }
        this.bwC = null;
        this.dvP = null;
        this.dvy = null;
        this.dvB = false;
    }

    public static void release() {
        if (dvN != null) {
            dvN.aIM();
        }
    }

    private void aIM() {
        c.i(MapController.COMPASS_LAYER_TAG, "release");
        if (this.dvB) {
            aIT();
        }
        this.bwC = null;
        this.dvP = null;
        this.dvy = null;
        this.dvx = null;
        this.dvO = null;
        this.dvT = null;
        this.mContext = null;
        dvN = null;
    }

    private SensorEventListener aIN() {
        c.i(MapController.COMPASS_LAYER_TAG, "get Accelerometer listener");
        if (this.dvx != null) {
            return this.dvx;
        }
        this.dvx = new SensorEventListener() { // from class: com.baidu.swan.apps.al.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.dvQ = sensorEvent.values;
                    a.this.dvS = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "accelerometer changed accuracy: " + a.this.dvS);
                    a.this.aIW();
                    return;
                }
                c.w(MapController.COMPASS_LAYER_TAG, "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dvx;
    }

    private SensorEventListener aIU() {
        c.i(MapController.COMPASS_LAYER_TAG, "get MagneticFiled listener");
        if (this.dvO != null) {
            return this.dvO;
        }
        this.dvO = new SensorEventListener() { // from class: com.baidu.swan.apps.al.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.dvR = sensorEvent.values;
                    a.this.dvS = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "magneticFiled changed accuracy: " + a.this.dvS);
                    a.this.aIW();
                    return;
                }
                c.w(MapController.COMPASS_LAYER_TAG, "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dvO;
    }

    private float aIV() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.dvQ, this.dvR);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIW() {
        if (this.dvT != null && System.currentTimeMillis() - this.dvC > 200) {
            float aIV = aIV();
            c.d("SwanAppCompassManager", "orientation changed, orientation : " + aIV);
            this.dvT.b(aIV, this.dvS);
            this.dvC = System.currentTimeMillis();
        }
    }

    public static String kS(int i) {
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
