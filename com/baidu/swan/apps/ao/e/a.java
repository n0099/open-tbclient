package com.baidu.swan.apps.ao.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.swan.apps.console.c;
/* loaded from: classes11.dex */
public class a {
    private static volatile a bWS;
    private SensorManager aBy;
    private SensorEventListener bWC;
    private Sensor bWD;
    private SensorEventListener bWT;
    private Sensor bWU;
    private InterfaceC0207a bWX;
    private Context mContext;
    private float[] bWV = new float[3];
    private float[] bWW = new float[3];
    private boolean bWG = false;
    private long bWH = 0;

    /* renamed from: com.baidu.swan.apps.ao.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0207a {
        void R(float f);
    }

    private a() {
    }

    public static a afR() {
        if (bWS == null) {
            synchronized (a.class) {
                if (bWS == null) {
                    bWS = new a();
                }
            }
        }
        return bWS;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0207a interfaceC0207a) {
        this.bWX = interfaceC0207a;
    }

    public void afS() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.bWG) {
            c.w("compass", "has already start");
        } else {
            this.aBy = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aBy != null) {
                this.bWD = this.aBy.getDefaultSensor(1);
                this.bWU = this.aBy.getDefaultSensor(2);
                this.aBy.registerListener(afN(), this.bWD, 1);
                this.aBy.registerListener(afU(), this.bWU, 1);
                this.bWG = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void afT() {
        if (!this.bWG) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.bWC != null && this.aBy != null) {
            this.aBy.unregisterListener(this.bWC);
            this.bWC = null;
        }
        if (this.bWT != null && this.aBy != null) {
            this.aBy.unregisterListener(this.bWT);
            this.bWT = null;
        }
        this.aBy = null;
        this.bWU = null;
        this.bWD = null;
        this.bWG = false;
    }

    public static void release() {
        if (bWS != null) {
            bWS.PU();
        }
    }

    private void PU() {
        c.i("compass", "release");
        if (this.bWG) {
            afT();
        }
        this.aBy = null;
        this.bWU = null;
        this.bWD = null;
        this.bWC = null;
        this.bWT = null;
        this.bWX = null;
        this.mContext = null;
        bWS = null;
    }

    private SensorEventListener afN() {
        c.i("compass", "get Accelerometer listener");
        if (this.bWC != null) {
            return this.bWC;
        }
        this.bWC = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.bWV = sensorEvent.values;
                    c.i("compass", "accelerometer changed");
                    a.this.afW();
                    return;
                }
                c.w("compass", "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bWC;
    }

    private SensorEventListener afU() {
        c.i("compass", "get MagneticFiled listener");
        if (this.bWT != null) {
            return this.bWT;
        }
        this.bWT = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.bWW = sensorEvent.values;
                    c.i("compass", "magneticFiled changed");
                    a.this.afW();
                    return;
                }
                c.w("compass", "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bWT;
    }

    private float afV() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.bWV, this.bWW);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afW() {
        if (this.bWX != null && System.currentTimeMillis() - this.bWH > 200) {
            float afV = afV();
            c.i("compass", "orientation changed, orientation : " + afV);
            this.bWX.R(afV);
            this.bWH = System.currentTimeMillis();
        }
    }
}
