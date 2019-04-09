package com.baidu.swan.apps.aj.d;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.swan.apps.console.c;
/* loaded from: classes2.dex */
public class a {
    private static volatile a aUm;
    private SensorManager aTA;
    private SensorEventListener aTB;
    private Sensor aTC;
    private SensorEventListener aUn;
    private Sensor aUo;
    private InterfaceC0113a aUr;
    private Context mContext;
    private float[] aUp = new float[3];
    private float[] aUq = new float[3];
    private boolean aTF = false;
    private long aTG = 0;

    /* renamed from: com.baidu.swan.apps.aj.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0113a {
        void ac(float f);
    }

    private a() {
    }

    public static a Li() {
        if (aUm == null) {
            synchronized (a.class) {
                if (aUm == null) {
                    aUm = new a();
                }
            }
        }
        return aUm;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0113a interfaceC0113a) {
        this.aUr = interfaceC0113a;
    }

    public void Lj() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.aTF) {
            c.w("compass", "has already start");
        } else {
            this.aTA = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aTA != null) {
                this.aTC = this.aTA.getDefaultSensor(1);
                this.aUo = this.aTA.getDefaultSensor(2);
                this.aTA.registerListener(Lc(), this.aTC, 1);
                this.aTA.registerListener(Ll(), this.aUo, 2);
                this.aTF = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void Lk() {
        if (!this.aTF) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.aTB != null && this.aTA != null) {
            this.aTA.unregisterListener(this.aTB);
            this.aTB = null;
        }
        if (this.aUn != null && this.aTA != null) {
            this.aTA.unregisterListener(this.aUn);
            this.aUn = null;
        }
        this.aTA = null;
        this.aUo = null;
        this.aTC = null;
        this.aTF = false;
    }

    public static void release() {
        if (aUm != null) {
            aUm.zO();
        }
    }

    private void zO() {
        c.i("compass", "release");
        if (this.aTF) {
            Lk();
        }
        this.aTA = null;
        this.aUo = null;
        this.aTC = null;
        this.aTB = null;
        this.aUn = null;
        this.aUr = null;
        this.mContext = null;
        aUm = null;
    }

    private SensorEventListener Lc() {
        c.i("compass", "get Accelerometer listener");
        if (this.aTB != null) {
            return this.aTB;
        }
        this.aTB = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.d.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.aUp = sensorEvent.values;
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
        return this.aTB;
    }

    private SensorEventListener Ll() {
        c.i("compass", "get MagneticFiled listener");
        if (this.aUn != null) {
            return this.aUn;
        }
        this.aUn = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.d.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.aUq = sensorEvent.values;
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
        return this.aUn;
    }

    private float Lm() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.aUp, this.aUq);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ln() {
        if (this.aUr != null && System.currentTimeMillis() - this.aTG > 200) {
            float Lm = Lm();
            c.i("compass", "orientation changed, orientation : " + Lm);
            this.aUr.ac(Lm);
            this.aTG = System.currentTimeMillis();
        }
    }
}
