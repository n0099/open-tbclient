package com.baidu.swan.apps.aj.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.swan.apps.console.c;
/* loaded from: classes2.dex */
public class a {
    private static volatile a brn;
    private SensorManager aoB;
    private SensorEventListener bqC;
    private Sensor bqD;
    private SensorEventListener bro;
    private Sensor brp;
    private InterfaceC0158a brs;
    private Context mContext;
    private float[] brq = new float[3];
    private float[] brr = new float[3];
    private boolean bqG = false;
    private long bqH = 0;

    /* renamed from: com.baidu.swan.apps.aj.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0158a {
        void R(float f);
    }

    private a() {
    }

    public static a Tq() {
        if (brn == null) {
            synchronized (a.class) {
                if (brn == null) {
                    brn = new a();
                }
            }
        }
        return brn;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0158a interfaceC0158a) {
        this.brs = interfaceC0158a;
    }

    public void Tr() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.bqG) {
            c.w("compass", "has already start");
        } else {
            this.aoB = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aoB != null) {
                this.bqD = this.aoB.getDefaultSensor(1);
                this.brp = this.aoB.getDefaultSensor(2);
                this.aoB.registerListener(Tk(), this.bqD, 1);
                this.aoB.registerListener(Tt(), this.brp, 1);
                this.bqG = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void Ts() {
        if (!this.bqG) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.bqC != null && this.aoB != null) {
            this.aoB.unregisterListener(this.bqC);
            this.bqC = null;
        }
        if (this.bro != null && this.aoB != null) {
            this.aoB.unregisterListener(this.bro);
            this.bro = null;
        }
        this.aoB = null;
        this.brp = null;
        this.bqD = null;
        this.bqG = false;
    }

    public static void release() {
        if (brn != null) {
            brn.GD();
        }
    }

    private void GD() {
        c.i("compass", "release");
        if (this.bqG) {
            Ts();
        }
        this.aoB = null;
        this.brp = null;
        this.bqD = null;
        this.bqC = null;
        this.bro = null;
        this.brs = null;
        this.mContext = null;
        brn = null;
    }

    private SensorEventListener Tk() {
        c.i("compass", "get Accelerometer listener");
        if (this.bqC != null) {
            return this.bqC;
        }
        this.bqC = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.brq = sensorEvent.values;
                    c.i("compass", "accelerometer changed");
                    a.this.Tv();
                    return;
                }
                c.w("compass", "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bqC;
    }

    private SensorEventListener Tt() {
        c.i("compass", "get MagneticFiled listener");
        if (this.bro != null) {
            return this.bro;
        }
        this.bro = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.brr = sensorEvent.values;
                    c.i("compass", "magneticFiled changed");
                    a.this.Tv();
                    return;
                }
                c.w("compass", "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bro;
    }

    private float Tu() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.brq, this.brr);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tv() {
        if (this.brs != null && System.currentTimeMillis() - this.bqH > 200) {
            float Tu = Tu();
            c.i("compass", "orientation changed, orientation : " + Tu);
            this.brs.R(Tu);
            this.bqH = System.currentTimeMillis();
        }
    }
}
