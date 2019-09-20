package com.baidu.swan.apps.aj.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.swan.apps.console.c;
/* loaded from: classes2.dex */
public class a {
    private static volatile a aYl;
    private Sensor aXA;
    private SensorManager aXy;
    private SensorEventListener aXz;
    private SensorEventListener aYm;
    private Sensor aYn;
    private InterfaceC0126a aYq;
    private Context mContext;
    private float[] aYo = new float[3];
    private float[] aYp = new float[3];
    private boolean aXD = false;
    private long aXE = 0;

    /* renamed from: com.baidu.swan.apps.aj.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0126a {
        void ac(float f);
    }

    private a() {
    }

    public static a OA() {
        if (aYl == null) {
            synchronized (a.class) {
                if (aYl == null) {
                    aYl = new a();
                }
            }
        }
        return aYl;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0126a interfaceC0126a) {
        this.aYq = interfaceC0126a;
    }

    public void OB() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.aXD) {
            c.w("compass", "has already start");
        } else {
            this.aXy = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aXy != null) {
                this.aXA = this.aXy.getDefaultSensor(1);
                this.aYn = this.aXy.getDefaultSensor(2);
                this.aXy.registerListener(Ou(), this.aXA, 1);
                this.aXy.registerListener(OD(), this.aYn, 1);
                this.aXD = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void OC() {
        if (!this.aXD) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.aXz != null && this.aXy != null) {
            this.aXy.unregisterListener(this.aXz);
            this.aXz = null;
        }
        if (this.aYm != null && this.aXy != null) {
            this.aXy.unregisterListener(this.aYm);
            this.aYm = null;
        }
        this.aXy = null;
        this.aYn = null;
        this.aXA = null;
        this.aXD = false;
    }

    public static void release() {
        if (aYl != null) {
            aYl.BJ();
        }
    }

    private void BJ() {
        c.i("compass", "release");
        if (this.aXD) {
            OC();
        }
        this.aXy = null;
        this.aYn = null;
        this.aXA = null;
        this.aXz = null;
        this.aYm = null;
        this.aYq = null;
        this.mContext = null;
        aYl = null;
    }

    private SensorEventListener Ou() {
        c.i("compass", "get Accelerometer listener");
        if (this.aXz != null) {
            return this.aXz;
        }
        this.aXz = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.aYo = sensorEvent.values;
                    c.i("compass", "accelerometer changed");
                    a.this.OF();
                    return;
                }
                c.w("compass", "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.aXz;
    }

    private SensorEventListener OD() {
        c.i("compass", "get MagneticFiled listener");
        if (this.aYm != null) {
            return this.aYm;
        }
        this.aYm = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.aYp = sensorEvent.values;
                    c.i("compass", "magneticFiled changed");
                    a.this.OF();
                    return;
                }
                c.w("compass", "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.aYm;
    }

    private float OE() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.aYo, this.aYp);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OF() {
        if (this.aYq != null && System.currentTimeMillis() - this.aXE > 200) {
            float OE = OE();
            c.i("compass", "orientation changed, orientation : " + OE);
            this.aYq.ac(OE);
            this.aXE = System.currentTimeMillis();
        }
    }
}
