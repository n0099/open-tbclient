package com.baidu.swan.apps.ao.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.swan.apps.console.c;
/* loaded from: classes11.dex */
public class a {
    private static volatile a cvP;
    private SensorManager aVk;
    private Sensor cvA;
    private SensorEventListener cvQ;
    private Sensor cvR;
    private InterfaceC0258a cvU;
    private SensorEventListener cvz;
    private Context mContext;
    private float[] cvS = new float[3];
    private float[] cvT = new float[3];
    private boolean cvD = false;
    private long cvE = 0;

    /* renamed from: com.baidu.swan.apps.ao.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0258a {
        void B(float f);
    }

    private a() {
    }

    public static a anV() {
        if (cvP == null) {
            synchronized (a.class) {
                if (cvP == null) {
                    cvP = new a();
                }
            }
        }
        return cvP;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0258a interfaceC0258a) {
        this.cvU = interfaceC0258a;
    }

    public void anW() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.cvD) {
            c.w("compass", "has already start");
        } else {
            this.aVk = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aVk != null) {
                this.cvA = this.aVk.getDefaultSensor(1);
                this.cvR = this.aVk.getDefaultSensor(2);
                this.aVk.registerListener(anR(), this.cvA, 1);
                this.aVk.registerListener(anY(), this.cvR, 1);
                this.cvD = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void anX() {
        if (!this.cvD) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.cvz != null && this.aVk != null) {
            this.aVk.unregisterListener(this.cvz);
            this.cvz = null;
        }
        if (this.cvQ != null && this.aVk != null) {
            this.aVk.unregisterListener(this.cvQ);
            this.cvQ = null;
        }
        this.aVk = null;
        this.cvR = null;
        this.cvA = null;
        this.cvD = false;
    }

    public static void release() {
        if (cvP != null) {
            cvP.XI();
        }
    }

    private void XI() {
        c.i("compass", "release");
        if (this.cvD) {
            anX();
        }
        this.aVk = null;
        this.cvR = null;
        this.cvA = null;
        this.cvz = null;
        this.cvQ = null;
        this.cvU = null;
        this.mContext = null;
        cvP = null;
    }

    private SensorEventListener anR() {
        c.i("compass", "get Accelerometer listener");
        if (this.cvz != null) {
            return this.cvz;
        }
        this.cvz = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.cvS = sensorEvent.values;
                    c.i("compass", "accelerometer changed");
                    a.this.aoa();
                    return;
                }
                c.w("compass", "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cvz;
    }

    private SensorEventListener anY() {
        c.i("compass", "get MagneticFiled listener");
        if (this.cvQ != null) {
            return this.cvQ;
        }
        this.cvQ = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.cvT = sensorEvent.values;
                    c.i("compass", "magneticFiled changed");
                    a.this.aoa();
                    return;
                }
                c.w("compass", "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cvQ;
    }

    private float anZ() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.cvS, this.cvT);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoa() {
        if (this.cvU != null && System.currentTimeMillis() - this.cvE > 200) {
            float anZ = anZ();
            c.i("compass", "orientation changed, orientation : " + anZ);
            this.cvU.B(anZ);
            this.cvE = System.currentTimeMillis();
        }
    }
}
