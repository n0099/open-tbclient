package com.baidu.swan.apps.am.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.console.c;
/* loaded from: classes11.dex */
public class a {
    private static volatile a cHQ;
    private SensorManager bcy;
    private SensorEventListener cHA;
    private Sensor cHB;
    private SensorEventListener cHR;
    private Sensor cHS;
    private InterfaceC0292a cHW;
    private Context mContext;
    private float[] cHT = new float[3];
    private float[] cHU = new float[3];
    private int cHV = -100;
    private boolean cHE = false;
    private long cHF = 0;

    /* renamed from: com.baidu.swan.apps.am.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0292a {
        void b(float f, int i);
    }

    private a() {
    }

    public static a aso() {
        if (cHQ == null) {
            synchronized (a.class) {
                if (cHQ == null) {
                    cHQ = new a();
                }
            }
        }
        return cHQ;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0292a interfaceC0292a) {
        this.cHW = interfaceC0292a;
    }

    public void asp() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.cHE) {
            c.w("compass", "has already start");
        } else {
            this.bcy = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.bcy != null) {
                this.cHB = this.bcy.getDefaultSensor(1);
                this.cHS = this.bcy.getDefaultSensor(2);
                this.bcy.registerListener(asj(), this.cHB, 1);
                this.bcy.registerListener(asr(), this.cHS, 1);
                this.cHE = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void asq() {
        if (!this.cHE) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.cHA != null && this.bcy != null) {
            this.bcy.unregisterListener(this.cHA);
            this.cHA = null;
        }
        if (this.cHR != null && this.bcy != null) {
            this.bcy.unregisterListener(this.cHR);
            this.cHR = null;
        }
        this.bcy = null;
        this.cHS = null;
        this.cHB = null;
        this.cHE = false;
    }

    public static void release() {
        if (cHQ != null) {
            cHQ.asi();
        }
    }

    private void asi() {
        c.i("compass", "release");
        if (this.cHE) {
            asq();
        }
        this.bcy = null;
        this.cHS = null;
        this.cHB = null;
        this.cHA = null;
        this.cHR = null;
        this.cHW = null;
        this.mContext = null;
        cHQ = null;
    }

    private SensorEventListener asj() {
        c.i("compass", "get Accelerometer listener");
        if (this.cHA != null) {
            return this.cHA;
        }
        this.cHA = new SensorEventListener() { // from class: com.baidu.swan.apps.am.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.cHT = sensorEvent.values;
                    a.this.cHV = sensorEvent.accuracy;
                    c.i("compass", "accelerometer changed accuracy: " + a.this.cHV);
                    a.this.ast();
                    return;
                }
                c.w("compass", "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cHA;
    }

    private SensorEventListener asr() {
        c.i("compass", "get MagneticFiled listener");
        if (this.cHR != null) {
            return this.cHR;
        }
        this.cHR = new SensorEventListener() { // from class: com.baidu.swan.apps.am.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.cHU = sensorEvent.values;
                    a.this.cHV = sensorEvent.accuracy;
                    c.i("compass", "magneticFiled changed accuracy: " + a.this.cHV);
                    a.this.ast();
                    return;
                }
                c.w("compass", "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cHR;
    }

    private float ass() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.cHT, this.cHU);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ast() {
        if (this.cHW != null && System.currentTimeMillis() - this.cHF > 200) {
            float ass = ass();
            c.i("compass", "orientation changed, orientation : " + ass);
            this.cHW.b(ass, this.cHV);
            this.cHF = System.currentTimeMillis();
        }
    }

    public static String hw(int i) {
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
