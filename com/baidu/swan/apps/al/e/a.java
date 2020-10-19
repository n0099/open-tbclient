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
    private static volatile a dnl;
    private SensorManager buw;
    private SensorEventListener dmV;
    private Sensor dmW;
    private SensorEventListener dnm;
    private Sensor dnn;
    private InterfaceC0352a dnr;
    private Context mContext;
    private float[] dno = new float[3];
    private float[] dnp = new float[3];
    private int dnq = -100;
    private boolean dmZ = false;
    private long dna = 0;

    /* renamed from: com.baidu.swan.apps.al.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0352a {
        void b(float f, int i);
    }

    private a() {
    }

    public static a aGX() {
        if (dnl == null) {
            synchronized (a.class) {
                if (dnl == null) {
                    dnl = new a();
                }
            }
        }
        return dnl;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0352a interfaceC0352a) {
        this.dnr = interfaceC0352a;
    }

    public void aGY() {
        if (this.mContext == null) {
            c.e(MapController.COMPASS_LAYER_TAG, "start error, none context");
        } else if (this.dmZ) {
            c.w(MapController.COMPASS_LAYER_TAG, "has already start");
        } else {
            this.buw = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.buw != null) {
                this.dmW = this.buw.getDefaultSensor(1);
                this.dnn = this.buw.getDefaultSensor(2);
                this.buw.registerListener(aGT(), this.dmW, 1);
                this.buw.registerListener(aHa(), this.dnn, 1);
                this.dmZ = true;
                c.i(MapController.COMPASS_LAYER_TAG, "start listen");
                return;
            }
            c.e(MapController.COMPASS_LAYER_TAG, "none sensorManager");
        }
    }

    public void aGZ() {
        if (!this.dmZ) {
            c.w(MapController.COMPASS_LAYER_TAG, "has already stop");
            return;
        }
        c.i(MapController.COMPASS_LAYER_TAG, "stop listen");
        if (this.dmV != null && this.buw != null) {
            this.buw.unregisterListener(this.dmV);
            this.dmV = null;
        }
        if (this.dnm != null && this.buw != null) {
            this.buw.unregisterListener(this.dnm);
            this.dnm = null;
        }
        this.buw = null;
        this.dnn = null;
        this.dmW = null;
        this.dmZ = false;
    }

    public static void release() {
        if (dnl != null) {
            dnl.aGS();
        }
    }

    private void aGS() {
        c.i(MapController.COMPASS_LAYER_TAG, "release");
        if (this.dmZ) {
            aGZ();
        }
        this.buw = null;
        this.dnn = null;
        this.dmW = null;
        this.dmV = null;
        this.dnm = null;
        this.dnr = null;
        this.mContext = null;
        dnl = null;
    }

    private SensorEventListener aGT() {
        c.i(MapController.COMPASS_LAYER_TAG, "get Accelerometer listener");
        if (this.dmV != null) {
            return this.dmV;
        }
        this.dmV = new SensorEventListener() { // from class: com.baidu.swan.apps.al.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.dno = sensorEvent.values;
                    a.this.dnq = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "accelerometer changed accuracy: " + a.this.dnq);
                    a.this.aHc();
                    return;
                }
                c.w(MapController.COMPASS_LAYER_TAG, "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dmV;
    }

    private SensorEventListener aHa() {
        c.i(MapController.COMPASS_LAYER_TAG, "get MagneticFiled listener");
        if (this.dnm != null) {
            return this.dnm;
        }
        this.dnm = new SensorEventListener() { // from class: com.baidu.swan.apps.al.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.dnp = sensorEvent.values;
                    a.this.dnq = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "magneticFiled changed accuracy: " + a.this.dnq);
                    a.this.aHc();
                    return;
                }
                c.w(MapController.COMPASS_LAYER_TAG, "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dnm;
    }

    private float aHb() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.dno, this.dnp);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHc() {
        if (this.dnr != null && System.currentTimeMillis() - this.dna > 200) {
            float aHb = aHb();
            c.d("SwanAppCompassManager", "orientation changed, orientation : " + aHb);
            this.dnr.b(aHb, this.dnq);
            this.dna = System.currentTimeMillis();
        }
    }

    public static String kH(int i) {
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
