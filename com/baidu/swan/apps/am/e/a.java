package com.baidu.swan.apps.am.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.console.c;
/* loaded from: classes7.dex */
public class a {
    private static volatile a cPV;
    private SensorManager bic;
    private SensorEventListener cPF;
    private Sensor cPG;
    private SensorEventListener cPW;
    private Sensor cPX;
    private InterfaceC0298a cQb;
    private Context mContext;
    private float[] cPY = new float[3];
    private float[] cPZ = new float[3];
    private int cQa = -100;
    private boolean cPJ = false;
    private long cPK = 0;

    /* renamed from: com.baidu.swan.apps.am.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0298a {
        void b(float f, int i);
    }

    private a() {
    }

    public static a avv() {
        if (cPV == null) {
            synchronized (a.class) {
                if (cPV == null) {
                    cPV = new a();
                }
            }
        }
        return cPV;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0298a interfaceC0298a) {
        this.cQb = interfaceC0298a;
    }

    public void avw() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.cPJ) {
            c.w("compass", "has already start");
        } else {
            this.bic = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.bic != null) {
                this.cPG = this.bic.getDefaultSensor(1);
                this.cPX = this.bic.getDefaultSensor(2);
                this.bic.registerListener(avr(), this.cPG, 1);
                this.bic.registerListener(avy(), this.cPX, 1);
                this.cPJ = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void avx() {
        if (!this.cPJ) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.cPF != null && this.bic != null) {
            this.bic.unregisterListener(this.cPF);
            this.cPF = null;
        }
        if (this.cPW != null && this.bic != null) {
            this.bic.unregisterListener(this.cPW);
            this.cPW = null;
        }
        this.bic = null;
        this.cPX = null;
        this.cPG = null;
        this.cPJ = false;
    }

    public static void release() {
        if (cPV != null) {
            cPV.avq();
        }
    }

    private void avq() {
        c.i("compass", "release");
        if (this.cPJ) {
            avx();
        }
        this.bic = null;
        this.cPX = null;
        this.cPG = null;
        this.cPF = null;
        this.cPW = null;
        this.cQb = null;
        this.mContext = null;
        cPV = null;
    }

    private SensorEventListener avr() {
        c.i("compass", "get Accelerometer listener");
        if (this.cPF != null) {
            return this.cPF;
        }
        this.cPF = new SensorEventListener() { // from class: com.baidu.swan.apps.am.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.cPY = sensorEvent.values;
                    a.this.cQa = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "accelerometer changed accuracy: " + a.this.cQa);
                    a.this.avA();
                    return;
                }
                c.w("compass", "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cPF;
    }

    private SensorEventListener avy() {
        c.i("compass", "get MagneticFiled listener");
        if (this.cPW != null) {
            return this.cPW;
        }
        this.cPW = new SensorEventListener() { // from class: com.baidu.swan.apps.am.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.cPZ = sensorEvent.values;
                    a.this.cQa = sensorEvent.accuracy;
                    c.d("SwanAppCompassManager", "magneticFiled changed accuracy: " + a.this.cQa);
                    a.this.avA();
                    return;
                }
                c.w("compass", "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cPW;
    }

    private float avz() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.cPY, this.cPZ);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avA() {
        if (this.cQb != null && System.currentTimeMillis() - this.cPK > 200) {
            float avz = avz();
            c.d("SwanAppCompassManager", "orientation changed, orientation : " + avz);
            this.cQb.b(avz, this.cQa);
            this.cPK = System.currentTimeMillis();
        }
    }

    public static String hQ(int i) {
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
