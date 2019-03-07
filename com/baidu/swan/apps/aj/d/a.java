package com.baidu.swan.apps.aj.d;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.swan.apps.console.c;
/* loaded from: classes2.dex */
public class a {
    private static volatile a aUh;
    private SensorManager aTv;
    private SensorEventListener aTw;
    private Sensor aTx;
    private SensorEventListener aUi;
    private Sensor aUj;
    private InterfaceC0083a aUm;
    private Context mContext;
    private float[] aUk = new float[3];
    private float[] aUl = new float[3];
    private boolean aTA = false;
    private long aTB = 0;

    /* renamed from: com.baidu.swan.apps.aj.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0083a {
        void ac(float f);
    }

    private a() {
    }

    public static a Lk() {
        if (aUh == null) {
            synchronized (a.class) {
                if (aUh == null) {
                    aUh = new a();
                }
            }
        }
        return aUh;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0083a interfaceC0083a) {
        this.aUm = interfaceC0083a;
    }

    public void Ll() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.aTA) {
            c.w("compass", "has already start");
        } else {
            this.aTv = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aTv != null) {
                this.aTx = this.aTv.getDefaultSensor(1);
                this.aUj = this.aTv.getDefaultSensor(2);
                this.aTv.registerListener(Le(), this.aTx, 1);
                this.aTv.registerListener(Ln(), this.aUj, 2);
                this.aTA = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void Lm() {
        if (!this.aTA) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.aTw != null && this.aTv != null) {
            this.aTv.unregisterListener(this.aTw);
            this.aTw = null;
        }
        if (this.aUi != null && this.aTv != null) {
            this.aTv.unregisterListener(this.aUi);
            this.aUi = null;
        }
        this.aTv = null;
        this.aUj = null;
        this.aTx = null;
        this.aTA = false;
    }

    public static void release() {
        if (aUh != null) {
            aUh.zP();
        }
    }

    private void zP() {
        c.i("compass", "release");
        if (this.aTA) {
            Lm();
        }
        this.aTv = null;
        this.aUj = null;
        this.aTx = null;
        this.aTw = null;
        this.aUi = null;
        this.aUm = null;
        this.mContext = null;
        aUh = null;
    }

    private SensorEventListener Le() {
        c.i("compass", "get Accelerometer listener");
        if (this.aTw != null) {
            return this.aTw;
        }
        this.aTw = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.d.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.aUk = sensorEvent.values;
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
        return this.aTw;
    }

    private SensorEventListener Ln() {
        c.i("compass", "get MagneticFiled listener");
        if (this.aUi != null) {
            return this.aUi;
        }
        this.aUi = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.d.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.aUl = sensorEvent.values;
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
        return this.aUi;
    }

    private float Lo() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.aUk, this.aUl);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lp() {
        if (this.aUm != null && System.currentTimeMillis() - this.aTB > 200) {
            float Lo = Lo();
            c.i("compass", "orientation changed, orientation : " + Lo);
            this.aUm.ac(Lo);
            this.aTB = System.currentTimeMillis();
        }
    }
}
