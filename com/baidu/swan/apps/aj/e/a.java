package com.baidu.swan.apps.aj.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.swan.apps.console.c;
/* loaded from: classes2.dex */
public class a {
    private static volatile a aXd;
    private SensorManager aWq;
    private SensorEventListener aWr;
    private Sensor aWs;
    private SensorEventListener aXe;
    private Sensor aXf;
    private InterfaceC0115a aXi;
    private Context mContext;
    private float[] aXg = new float[3];
    private float[] aXh = new float[3];
    private boolean aWv = false;
    private long aWw = 0;

    /* renamed from: com.baidu.swan.apps.aj.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0115a {
        void ac(float f);
    }

    private a() {
    }

    public static a NH() {
        if (aXd == null) {
            synchronized (a.class) {
                if (aXd == null) {
                    aXd = new a();
                }
            }
        }
        return aXd;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0115a interfaceC0115a) {
        this.aXi = interfaceC0115a;
    }

    public void NI() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.aWv) {
            c.w("compass", "has already start");
        } else {
            this.aWq = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aWq != null) {
                this.aWs = this.aWq.getDefaultSensor(1);
                this.aXf = this.aWq.getDefaultSensor(2);
                this.aWq.registerListener(NB(), this.aWs, 1);
                this.aWq.registerListener(NK(), this.aXf, 1);
                this.aWv = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void NJ() {
        if (!this.aWv) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.aWr != null && this.aWq != null) {
            this.aWq.unregisterListener(this.aWr);
            this.aWr = null;
        }
        if (this.aXe != null && this.aWq != null) {
            this.aWq.unregisterListener(this.aXe);
            this.aXe = null;
        }
        this.aWq = null;
        this.aXf = null;
        this.aWs = null;
        this.aWv = false;
    }

    public static void release() {
        if (aXd != null) {
            aXd.AX();
        }
    }

    private void AX() {
        c.i("compass", "release");
        if (this.aWv) {
            NJ();
        }
        this.aWq = null;
        this.aXf = null;
        this.aWs = null;
        this.aWr = null;
        this.aXe = null;
        this.aXi = null;
        this.mContext = null;
        aXd = null;
    }

    private SensorEventListener NB() {
        c.i("compass", "get Accelerometer listener");
        if (this.aWr != null) {
            return this.aWr;
        }
        this.aWr = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.aXg = sensorEvent.values;
                    c.i("compass", "accelerometer changed");
                    a.this.NM();
                    return;
                }
                c.w("compass", "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.aWr;
    }

    private SensorEventListener NK() {
        c.i("compass", "get MagneticFiled listener");
        if (this.aXe != null) {
            return this.aXe;
        }
        this.aXe = new SensorEventListener() { // from class: com.baidu.swan.apps.aj.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.aXh = sensorEvent.values;
                    c.i("compass", "magneticFiled changed");
                    a.this.NM();
                    return;
                }
                c.w("compass", "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.aXe;
    }

    private float NL() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.aXg, this.aXh);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NM() {
        if (this.aXi != null && System.currentTimeMillis() - this.aWw > 200) {
            float NL = NL();
            c.i("compass", "orientation changed, orientation : " + NL);
            this.aXi.ac(NL);
            this.aWw = System.currentTimeMillis();
        }
    }
}
