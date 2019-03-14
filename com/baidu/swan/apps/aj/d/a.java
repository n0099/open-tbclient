package com.baidu.swan.apps.aj.d;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.swan.apps.console.c;
/* loaded from: classes2.dex */
public class a {
    private static volatile a aUi;
    private SensorManager aTw;
    private SensorEventListener aTx;
    private Sensor aTy;
    private SensorEventListener aUj;
    private Sensor aUk;
    private InterfaceC0113a aUn;
    private Context mContext;
    private float[] aUl = new float[3];
    private float[] aUm = new float[3];
    private boolean aTB = false;
    private long aTC = 0;

    /* renamed from: com.baidu.swan.apps.aj.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0113a {
        void ac(float f);
    }

    private a() {
    }

    public static a Lk() {
        if (aUi == null) {
            synchronized (a.class) {
                if (aUi == null) {
                    aUi = new a();
                }
            }
        }
        return aUi;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0113a interfaceC0113a) {
        this.aUn = interfaceC0113a;
    }

    public void Ll() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.aTB) {
            c.w("compass", "has already start");
        } else {
            this.aTw = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aTw != null) {
                this.aTy = this.aTw.getDefaultSensor(1);
                this.aUk = this.aTw.getDefaultSensor(2);
                this.aTw.registerListener(Le(), this.aTy, 1);
                this.aTw.registerListener(Ln(), this.aUk, 2);
                this.aTB = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void Lm() {
        if (!this.aTB) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.aTx != null && this.aTw != null) {
            this.aTw.unregisterListener(this.aTx);
            this.aTx = null;
        }
        if (this.aUj != null && this.aTw != null) {
            this.aTw.unregisterListener(this.aUj);
            this.aUj = null;
        }
        this.aTw = null;
        this.aUk = null;
        this.aTy = null;
        this.aTB = false;
    }

    public static void release() {
        if (aUi != null) {
            aUi.zP();
        }
    }

    private void zP() {
        c.i("compass", "release");
        if (this.aTB) {
            Lm();
        }
        this.aTw = null;
        this.aUk = null;
        this.aTy = null;
        this.aTx = null;
        this.aUj = null;
        this.aUn = null;
        this.mContext = null;
        aUi = null;
    }

    private SensorEventListener Le() {
        c.i("compass", "get Accelerometer listener");
        if (this.aTx != null) {
            return this.aTx;
        }
        this.aTx = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.d.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.aUl = sensorEvent.values;
                    c.i("compass", "accelerometer changed");
                    a.this.Lp();
                    return;
                }
                c.w("compass", "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.aTx;
    }

    private SensorEventListener Ln() {
        c.i("compass", "get MagneticFiled listener");
        if (this.aUj != null) {
            return this.aUj;
        }
        this.aUj = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.d.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.aUm = sensorEvent.values;
                    c.i("compass", "magneticFiled changed");
                    a.this.Lp();
                    return;
                }
                c.w("compass", "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.aUj;
    }

    private float Lo() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.aUl, this.aUm);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lp() {
        if (this.aUn != null && System.currentTimeMillis() - this.aTC > 200) {
            float Lo = Lo();
            c.i("compass", "orientation changed, orientation : " + Lo);
            this.aUn.ac(Lo);
            this.aTC = System.currentTimeMillis();
        }
    }
}
