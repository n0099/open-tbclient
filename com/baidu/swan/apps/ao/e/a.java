package com.baidu.swan.apps.ao.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.swan.apps.console.c;
/* loaded from: classes10.dex */
public class a {
    private static volatile a bSB;
    private SensorManager awS;
    private SensorEventListener bSC;
    private Sensor bSD;
    private InterfaceC0197a bSG;
    private SensorEventListener bSl;
    private Sensor bSm;
    private Context mContext;
    private float[] bSE = new float[3];
    private float[] bSF = new float[3];
    private boolean bSp = false;
    private long bSq = 0;

    /* renamed from: com.baidu.swan.apps.ao.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0197a {
        void R(float f);
    }

    private a() {
    }

    public static a ady() {
        if (bSB == null) {
            synchronized (a.class) {
                if (bSB == null) {
                    bSB = new a();
                }
            }
        }
        return bSB;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0197a interfaceC0197a) {
        this.bSG = interfaceC0197a;
    }

    public void adz() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.bSp) {
            c.w("compass", "has already start");
        } else {
            this.awS = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.awS != null) {
                this.bSm = this.awS.getDefaultSensor(1);
                this.bSD = this.awS.getDefaultSensor(2);
                this.awS.registerListener(adu(), this.bSm, 1);
                this.awS.registerListener(adB(), this.bSD, 1);
                this.bSp = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void adA() {
        if (!this.bSp) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.bSl != null && this.awS != null) {
            this.awS.unregisterListener(this.bSl);
            this.bSl = null;
        }
        if (this.bSC != null && this.awS != null) {
            this.awS.unregisterListener(this.bSC);
            this.bSC = null;
        }
        this.awS = null;
        this.bSD = null;
        this.bSm = null;
        this.bSp = false;
    }

    public static void release() {
        if (bSB != null) {
            bSB.NB();
        }
    }

    private void NB() {
        c.i("compass", "release");
        if (this.bSp) {
            adA();
        }
        this.awS = null;
        this.bSD = null;
        this.bSm = null;
        this.bSl = null;
        this.bSC = null;
        this.bSG = null;
        this.mContext = null;
        bSB = null;
    }

    private SensorEventListener adu() {
        c.i("compass", "get Accelerometer listener");
        if (this.bSl != null) {
            return this.bSl;
        }
        this.bSl = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.bSE = sensorEvent.values;
                    c.i("compass", "accelerometer changed");
                    a.this.adD();
                    return;
                }
                c.w("compass", "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bSl;
    }

    private SensorEventListener adB() {
        c.i("compass", "get MagneticFiled listener");
        if (this.bSC != null) {
            return this.bSC;
        }
        this.bSC = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.bSF = sensorEvent.values;
                    c.i("compass", "magneticFiled changed");
                    a.this.adD();
                    return;
                }
                c.w("compass", "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bSC;
    }

    private float adC() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.bSE, this.bSF);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adD() {
        if (this.bSG != null && System.currentTimeMillis() - this.bSq > 200) {
            float adC = adC();
            c.i("compass", "orientation changed, orientation : " + adC);
            this.bSG.R(adC);
            this.bSq = System.currentTimeMillis();
        }
    }
}
