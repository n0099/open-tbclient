package com.baidu.swan.apps.aj.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.swan.apps.console.c;
/* loaded from: classes2.dex */
public class a {
    private static volatile a bqw;
    private SensorManager aoj;
    private InterfaceC0158a bqB;
    private SensorEventListener bqk;
    private Sensor bql;
    private SensorEventListener bqx;
    private Sensor bqy;
    private Context mContext;
    private float[] bqz = new float[3];
    private float[] bqA = new float[3];
    private boolean bqo = false;
    private long bqp = 0;

    /* renamed from: com.baidu.swan.apps.aj.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0158a {
        void R(float f);
    }

    private a() {
    }

    public static a To() {
        if (bqw == null) {
            synchronized (a.class) {
                if (bqw == null) {
                    bqw = new a();
                }
            }
        }
        return bqw;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0158a interfaceC0158a) {
        this.bqB = interfaceC0158a;
    }

    public void Tp() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.bqo) {
            c.w("compass", "has already start");
        } else {
            this.aoj = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aoj != null) {
                this.bql = this.aoj.getDefaultSensor(1);
                this.bqy = this.aoj.getDefaultSensor(2);
                this.aoj.registerListener(Tm(), this.bql, 1);
                this.aoj.registerListener(Tr(), this.bqy, 1);
                this.bqo = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void Tq() {
        if (!this.bqo) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.bqk != null && this.aoj != null) {
            this.aoj.unregisterListener(this.bqk);
            this.bqk = null;
        }
        if (this.bqx != null && this.aoj != null) {
            this.aoj.unregisterListener(this.bqx);
            this.bqx = null;
        }
        this.aoj = null;
        this.bqy = null;
        this.bql = null;
        this.bqo = false;
    }

    public static void release() {
        if (bqw != null) {
            bqw.GE();
        }
    }

    private void GE() {
        c.i("compass", "release");
        if (this.bqo) {
            Tq();
        }
        this.aoj = null;
        this.bqy = null;
        this.bql = null;
        this.bqk = null;
        this.bqx = null;
        this.bqB = null;
        this.mContext = null;
        bqw = null;
    }

    private SensorEventListener Tm() {
        c.i("compass", "get Accelerometer listener");
        if (this.bqk != null) {
            return this.bqk;
        }
        this.bqk = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.bqz = sensorEvent.values;
                    c.i("compass", "accelerometer changed");
                    a.this.Tt();
                    return;
                }
                c.w("compass", "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bqk;
    }

    private SensorEventListener Tr() {
        c.i("compass", "get MagneticFiled listener");
        if (this.bqx != null) {
            return this.bqx;
        }
        this.bqx = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.bqA = sensorEvent.values;
                    c.i("compass", "magneticFiled changed");
                    a.this.Tt();
                    return;
                }
                c.w("compass", "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bqx;
    }

    private float Ts() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.bqz, this.bqA);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tt() {
        if (this.bqB != null && System.currentTimeMillis() - this.bqp > 200) {
            float Ts = Ts();
            c.i("compass", "orientation changed, orientation : " + Ts);
            this.bqB.R(Ts);
            this.bqp = System.currentTimeMillis();
        }
    }
}
