package com.baidu.swan.apps.aj.d;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.swan.apps.console.c;
/* loaded from: classes2.dex */
public class a {
    private static volatile a aUl;
    private SensorEventListener aTA;
    private Sensor aTB;
    private SensorManager aTz;
    private SensorEventListener aUm;
    private Sensor aUn;
    private InterfaceC0113a aUq;
    private Context mContext;
    private float[] aUo = new float[3];
    private float[] aUp = new float[3];
    private boolean aTE = false;
    private long aTF = 0;

    /* renamed from: com.baidu.swan.apps.aj.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0113a {
        void ac(float f);
    }

    private a() {
    }

    public static a Li() {
        if (aUl == null) {
            synchronized (a.class) {
                if (aUl == null) {
                    aUl = new a();
                }
            }
        }
        return aUl;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0113a interfaceC0113a) {
        this.aUq = interfaceC0113a;
    }

    public void Lj() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.aTE) {
            c.w("compass", "has already start");
        } else {
            this.aTz = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aTz != null) {
                this.aTB = this.aTz.getDefaultSensor(1);
                this.aUn = this.aTz.getDefaultSensor(2);
                this.aTz.registerListener(Lc(), this.aTB, 1);
                this.aTz.registerListener(Ll(), this.aUn, 2);
                this.aTE = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void Lk() {
        if (!this.aTE) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.aTA != null && this.aTz != null) {
            this.aTz.unregisterListener(this.aTA);
            this.aTA = null;
        }
        if (this.aUm != null && this.aTz != null) {
            this.aTz.unregisterListener(this.aUm);
            this.aUm = null;
        }
        this.aTz = null;
        this.aUn = null;
        this.aTB = null;
        this.aTE = false;
    }

    public static void release() {
        if (aUl != null) {
            aUl.zO();
        }
    }

    private void zO() {
        c.i("compass", "release");
        if (this.aTE) {
            Lk();
        }
        this.aTz = null;
        this.aUn = null;
        this.aTB = null;
        this.aTA = null;
        this.aUm = null;
        this.aUq = null;
        this.mContext = null;
        aUl = null;
    }

    private SensorEventListener Lc() {
        c.i("compass", "get Accelerometer listener");
        if (this.aTA != null) {
            return this.aTA;
        }
        this.aTA = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.d.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.aUo = sensorEvent.values;
                    c.i("compass", "accelerometer changed");
                    a.this.Ln();
                    return;
                }
                c.w("compass", "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.aTA;
    }

    private SensorEventListener Ll() {
        c.i("compass", "get MagneticFiled listener");
        if (this.aUm != null) {
            return this.aUm;
        }
        this.aUm = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.d.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.aUp = sensorEvent.values;
                    c.i("compass", "magneticFiled changed");
                    a.this.Ln();
                    return;
                }
                c.w("compass", "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.aUm;
    }

    private float Lm() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.aUo, this.aUp);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ln() {
        if (this.aUq != null && System.currentTimeMillis() - this.aTF > 200) {
            float Lm = Lm();
            c.i("compass", "orientation changed, orientation : " + Lm);
            this.aUq.ac(Lm);
            this.aTF = System.currentTimeMillis();
        }
    }
}
