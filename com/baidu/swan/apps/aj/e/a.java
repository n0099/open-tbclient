package com.baidu.swan.apps.aj.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.swan.apps.console.c;
/* loaded from: classes2.dex */
public class a {
    private static volatile a aXN;
    private SensorEventListener aXO;
    private Sensor aXP;
    private InterfaceC0117a aXS;
    private SensorManager aXa;
    private SensorEventListener aXb;
    private Sensor aXc;
    private Context mContext;
    private float[] aXQ = new float[3];
    private float[] aXR = new float[3];
    private boolean aXf = false;
    private long aXg = 0;

    /* renamed from: com.baidu.swan.apps.aj.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0117a {
        void ac(float f);
    }

    private a() {
    }

    public static a Ow() {
        if (aXN == null) {
            synchronized (a.class) {
                if (aXN == null) {
                    aXN = new a();
                }
            }
        }
        return aXN;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0117a interfaceC0117a) {
        this.aXS = interfaceC0117a;
    }

    public void Ox() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.aXf) {
            c.w("compass", "has already start");
        } else {
            this.aXa = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aXa != null) {
                this.aXc = this.aXa.getDefaultSensor(1);
                this.aXP = this.aXa.getDefaultSensor(2);
                this.aXa.registerListener(Oq(), this.aXc, 1);
                this.aXa.registerListener(Oz(), this.aXP, 1);
                this.aXf = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void Oy() {
        if (!this.aXf) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.aXb != null && this.aXa != null) {
            this.aXa.unregisterListener(this.aXb);
            this.aXb = null;
        }
        if (this.aXO != null && this.aXa != null) {
            this.aXa.unregisterListener(this.aXO);
            this.aXO = null;
        }
        this.aXa = null;
        this.aXP = null;
        this.aXc = null;
        this.aXf = false;
    }

    public static void release() {
        if (aXN != null) {
            aXN.BF();
        }
    }

    private void BF() {
        c.i("compass", "release");
        if (this.aXf) {
            Oy();
        }
        this.aXa = null;
        this.aXP = null;
        this.aXc = null;
        this.aXb = null;
        this.aXO = null;
        this.aXS = null;
        this.mContext = null;
        aXN = null;
    }

    private SensorEventListener Oq() {
        c.i("compass", "get Accelerometer listener");
        if (this.aXb != null) {
            return this.aXb;
        }
        this.aXb = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.aXQ = sensorEvent.values;
                    c.i("compass", "accelerometer changed");
                    a.this.OB();
                    return;
                }
                c.w("compass", "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.aXb;
    }

    private SensorEventListener Oz() {
        c.i("compass", "get MagneticFiled listener");
        if (this.aXO != null) {
            return this.aXO;
        }
        this.aXO = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.aXR = sensorEvent.values;
                    c.i("compass", "magneticFiled changed");
                    a.this.OB();
                    return;
                }
                c.w("compass", "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.aXO;
    }

    private float OA() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.aXQ, this.aXR);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OB() {
        if (this.aXS != null && System.currentTimeMillis() - this.aXg > 200) {
            float OA = OA();
            c.i("compass", "orientation changed, orientation : " + OA);
            this.aXS.ac(OA);
            this.aXg = System.currentTimeMillis();
        }
    }
}
