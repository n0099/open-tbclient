package com.baidu.swan.apps.al.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.swan.apps.console.c;
/* loaded from: classes25.dex */
public class a {
    private static volatile a dGW;
    private SensorManager bGk;
    private SensorEventListener dGH;
    private Sensor dGI;
    private SensorEventListener dGX;
    private Sensor dGY;
    private InterfaceC0388a dHc;
    private Context mContext;
    private float[] dGZ = new float[3];
    private float[] dHa = new float[3];
    private int dHb = -100;
    private boolean dGL = false;
    private long dGM = 0;

    /* renamed from: com.baidu.swan.apps.al.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0388a {
        void b(float f, int i);
    }

    private a() {
    }

    public static a aNQ() {
        if (dGW == null) {
            synchronized (a.class) {
                if (dGW == null) {
                    dGW = new a();
                }
            }
        }
        return dGW;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0388a interfaceC0388a) {
        this.dHc = interfaceC0388a;
    }

    public void aNR() {
        if (this.mContext == null) {
            c.e(MapController.COMPASS_LAYER_TAG, "start error, none context");
        } else if (this.dGL) {
            c.w(MapController.COMPASS_LAYER_TAG, "has already start");
        } else {
            this.bGk = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.bGk != null) {
                this.dGI = this.bGk.getDefaultSensor(1);
                this.dGY = this.bGk.getDefaultSensor(2);
                this.bGk.registerListener(aNM(), this.dGI, 1);
                this.bGk.registerListener(aNT(), this.dGY, 1);
                this.dGL = true;
                c.i(MapController.COMPASS_LAYER_TAG, "start listen");
                return;
            }
            c.e(MapController.COMPASS_LAYER_TAG, "none sensorManager");
        }
    }

    public void aNS() {
        if (!this.dGL) {
            c.w(MapController.COMPASS_LAYER_TAG, "has already stop");
            return;
        }
        c.i(MapController.COMPASS_LAYER_TAG, "stop listen");
        if (this.dGH != null && this.bGk != null) {
            this.bGk.unregisterListener(this.dGH);
            this.dGH = null;
        }
        if (this.dGX != null && this.bGk != null) {
            this.bGk.unregisterListener(this.dGX);
            this.dGX = null;
        }
        this.bGk = null;
        this.dGY = null;
        this.dGI = null;
        this.dGL = false;
    }

    public static void release() {
        if (dGW != null) {
            dGW.aNL();
        }
    }

    private void aNL() {
        c.i(MapController.COMPASS_LAYER_TAG, "release");
        if (this.dGL) {
            aNS();
        }
        this.bGk = null;
        this.dGY = null;
        this.dGI = null;
        this.dGH = null;
        this.dGX = null;
        this.dHc = null;
        this.mContext = null;
        dGW = null;
    }

    private SensorEventListener aNM() {
        c.i(MapController.COMPASS_LAYER_TAG, "get Accelerometer listener");
        if (this.dGH != null) {
            return this.dGH;
        }
        this.dGH = new SensorEventListener() { // from class: com.baidu.swan.apps.al.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.dGZ = sensorEvent.values;
                    a.this.dHb = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "accelerometer changed accuracy: " + a.this.dHb);
                    a.this.aNV();
                    return;
                }
                c.w(MapController.COMPASS_LAYER_TAG, "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dGH;
    }

    private SensorEventListener aNT() {
        c.i(MapController.COMPASS_LAYER_TAG, "get MagneticFiled listener");
        if (this.dGX != null) {
            return this.dGX;
        }
        this.dGX = new SensorEventListener() { // from class: com.baidu.swan.apps.al.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.dHa = sensorEvent.values;
                    a.this.dHb = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "magneticFiled changed accuracy: " + a.this.dHb);
                    a.this.aNV();
                    return;
                }
                c.w(MapController.COMPASS_LAYER_TAG, "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.dGX;
    }

    private float aNU() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.dGZ, this.dHa);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNV() {
        if (this.dHc != null && System.currentTimeMillis() - this.dGM > 200) {
            float aNU = aNU();
            c.d("SwanAppCompassManager", "orientation changed, orientation : " + aNU);
            this.dHc.b(aNU, this.dHb);
            this.dGM = System.currentTimeMillis();
        }
    }

    public static String lw(int i) {
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
