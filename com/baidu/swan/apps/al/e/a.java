package com.baidu.swan.apps.al.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.swan.apps.console.c;
/* loaded from: classes3.dex */
public class a {
    private static volatile a dbd;
    private SensorManager bqI;
    private SensorEventListener daN;
    private Sensor daO;
    private SensorEventListener dbe;
    private Sensor dbf;
    private InterfaceC0335a dbj;
    private Context mContext;
    private float[] dbg = new float[3];
    private float[] dbh = new float[3];
    private int dbi = -100;
    private boolean daR = false;
    private long daS = 0;

    /* renamed from: com.baidu.swan.apps.al.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0335a {
        void b(float f, int i);
    }

    private a() {
    }

    public static a aEo() {
        if (dbd == null) {
            synchronized (a.class) {
                if (dbd == null) {
                    dbd = new a();
                }
            }
        }
        return dbd;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0335a interfaceC0335a) {
        this.dbj = interfaceC0335a;
    }

    public void aEp() {
        if (this.mContext == null) {
            c.e(MapController.COMPASS_LAYER_TAG, "start error, none context");
        } else if (this.daR) {
            c.w(MapController.COMPASS_LAYER_TAG, "has already start");
        } else {
            this.bqI = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.bqI != null) {
                this.daO = this.bqI.getDefaultSensor(1);
                this.dbf = this.bqI.getDefaultSensor(2);
                this.bqI.registerListener(aEk(), this.daO, 1);
                this.bqI.registerListener(aEr(), this.dbf, 1);
                this.daR = true;
                c.i(MapController.COMPASS_LAYER_TAG, "start listen");
                return;
            }
            c.e(MapController.COMPASS_LAYER_TAG, "none sensorManager");
        }
    }

    public void aEq() {
        if (!this.daR) {
            c.w(MapController.COMPASS_LAYER_TAG, "has already stop");
            return;
        }
        c.i(MapController.COMPASS_LAYER_TAG, "stop listen");
        if (this.daN != null && this.bqI != null) {
            this.bqI.unregisterListener(this.daN);
            this.daN = null;
        }
        if (this.dbe != null && this.bqI != null) {
            this.bqI.unregisterListener(this.dbe);
            this.dbe = null;
        }
        this.bqI = null;
        this.dbf = null;
        this.daO = null;
        this.daR = false;
    }

    public static void release() {
        if (dbd != null) {
            dbd.aEj();
        }
    }

    private void aEj() {
        c.i(MapController.COMPASS_LAYER_TAG, "release");
        if (this.daR) {
            aEq();
        }
        this.bqI = null;
        this.dbf = null;
        this.daO = null;
        this.daN = null;
        this.dbe = null;
        this.dbj = null;
        this.mContext = null;
        dbd = null;
    }

    private SensorEventListener aEk() {
        c.i(MapController.COMPASS_LAYER_TAG, "get Accelerometer listener");
        if (this.daN != null) {
            return this.daN;
        }
        this.daN = new SensorEventListener() { // from class: com.baidu.swan.apps.al.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.dbg = sensorEvent.values;
                    a.this.dbi = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "accelerometer changed accuracy: " + a.this.dbi);
                    a.this.aEt();
                    return;
                }
                c.w(MapController.COMPASS_LAYER_TAG, "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.daN;
    }

    private SensorEventListener aEr() {
        c.i(MapController.COMPASS_LAYER_TAG, "get MagneticFiled listener");
        if (this.dbe != null) {
            return this.dbe;
        }
        this.dbe = new SensorEventListener() { // from class: com.baidu.swan.apps.al.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.dbh = sensorEvent.values;
                    a.this.dbi = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "magneticFiled changed accuracy: " + a.this.dbi);
                    a.this.aEt();
                    return;
                }
                c.w(MapController.COMPASS_LAYER_TAG, "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dbe;
    }

    private float aEs() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.dbg, this.dbh);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEt() {
        if (this.dbj != null && System.currentTimeMillis() - this.daS > 200) {
            float aEs = aEs();
            c.d("SwanAppCompassManager", "orientation changed, orientation : " + aEs);
            this.dbj.b(aEs, this.dbi);
            this.daS = System.currentTimeMillis();
        }
    }

    public static String kk(int i) {
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
