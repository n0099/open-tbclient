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
    private static volatile a dBF;
    private SensorManager bCN;
    private SensorEventListener dBG;
    private Sensor dBH;
    private InterfaceC0378a dBL;
    private SensorEventListener dBp;
    private Sensor dBq;
    private Context mContext;
    private float[] dBI = new float[3];
    private float[] dBJ = new float[3];
    private int dBK = -100;
    private boolean dBt = false;
    private long dBu = 0;

    /* renamed from: com.baidu.swan.apps.al.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0378a {
        void b(float f, int i);
    }

    private a() {
    }

    public static a aLr() {
        if (dBF == null) {
            synchronized (a.class) {
                if (dBF == null) {
                    dBF = new a();
                }
            }
        }
        return dBF;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0378a interfaceC0378a) {
        this.dBL = interfaceC0378a;
    }

    public void aLs() {
        if (this.mContext == null) {
            c.e(MapController.COMPASS_LAYER_TAG, "start error, none context");
        } else if (this.dBt) {
            c.w(MapController.COMPASS_LAYER_TAG, "has already start");
        } else {
            this.bCN = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.bCN != null) {
                this.dBq = this.bCN.getDefaultSensor(1);
                this.dBH = this.bCN.getDefaultSensor(2);
                this.bCN.registerListener(aLn(), this.dBq, 1);
                this.bCN.registerListener(aLu(), this.dBH, 1);
                this.dBt = true;
                c.i(MapController.COMPASS_LAYER_TAG, "start listen");
                return;
            }
            c.e(MapController.COMPASS_LAYER_TAG, "none sensorManager");
        }
    }

    public void aLt() {
        if (!this.dBt) {
            c.w(MapController.COMPASS_LAYER_TAG, "has already stop");
            return;
        }
        c.i(MapController.COMPASS_LAYER_TAG, "stop listen");
        if (this.dBp != null && this.bCN != null) {
            this.bCN.unregisterListener(this.dBp);
            this.dBp = null;
        }
        if (this.dBG != null && this.bCN != null) {
            this.bCN.unregisterListener(this.dBG);
            this.dBG = null;
        }
        this.bCN = null;
        this.dBH = null;
        this.dBq = null;
        this.dBt = false;
    }

    public static void release() {
        if (dBF != null) {
            dBF.aLm();
        }
    }

    private void aLm() {
        c.i(MapController.COMPASS_LAYER_TAG, "release");
        if (this.dBt) {
            aLt();
        }
        this.bCN = null;
        this.dBH = null;
        this.dBq = null;
        this.dBp = null;
        this.dBG = null;
        this.dBL = null;
        this.mContext = null;
        dBF = null;
    }

    private SensorEventListener aLn() {
        c.i(MapController.COMPASS_LAYER_TAG, "get Accelerometer listener");
        if (this.dBp != null) {
            return this.dBp;
        }
        this.dBp = new SensorEventListener() { // from class: com.baidu.swan.apps.al.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.dBI = sensorEvent.values;
                    a.this.dBK = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "accelerometer changed accuracy: " + a.this.dBK);
                    a.this.aLw();
                    return;
                }
                c.w(MapController.COMPASS_LAYER_TAG, "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dBp;
    }

    private SensorEventListener aLu() {
        c.i(MapController.COMPASS_LAYER_TAG, "get MagneticFiled listener");
        if (this.dBG != null) {
            return this.dBG;
        }
        this.dBG = new SensorEventListener() { // from class: com.baidu.swan.apps.al.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.dBJ = sensorEvent.values;
                    a.this.dBK = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "magneticFiled changed accuracy: " + a.this.dBK);
                    a.this.aLw();
                    return;
                }
                c.w(MapController.COMPASS_LAYER_TAG, "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dBG;
    }

    private float aLv() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.dBI, this.dBJ);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLw() {
        if (this.dBL != null && System.currentTimeMillis() - this.dBu > 200) {
            float aLv = aLv();
            c.d("SwanAppCompassManager", "orientation changed, orientation : " + aLv);
            this.dBL.b(aLv, this.dBK);
            this.dBu = System.currentTimeMillis();
        }
    }

    public static String lc(int i) {
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
