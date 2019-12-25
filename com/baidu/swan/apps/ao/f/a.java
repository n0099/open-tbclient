package com.baidu.swan.apps.ao.f;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.swan.apps.console.c;
/* loaded from: classes9.dex */
public class a {
    private static volatile a bSp;
    private SensorManager awg;
    private SensorEventListener bRB;
    private Sensor bRC;
    private SensorEventListener bSq;
    private Sensor bSr;
    private InterfaceC0195a bSu;
    private Context mContext;
    private float[] bSs = new float[3];
    private float[] bSt = new float[3];
    private boolean bRF = false;
    private long bRG = 0;

    /* renamed from: com.baidu.swan.apps.ao.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0195a {
        void S(float f);
    }

    private a() {
    }

    public static a adf() {
        if (bSp == null) {
            synchronized (a.class) {
                if (bSp == null) {
                    bSp = new a();
                }
            }
        }
        return bSp;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0195a interfaceC0195a) {
        this.bSu = interfaceC0195a;
    }

    public void adg() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.bRF) {
            c.w("compass", "has already start");
        } else {
            this.awg = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.awg != null) {
                this.bRC = this.awg.getDefaultSensor(1);
                this.bSr = this.awg.getDefaultSensor(2);
                this.awg.registerListener(acX(), this.bRC, 1);
                this.awg.registerListener(adi(), this.bSr, 1);
                this.bRF = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void adh() {
        if (!this.bRF) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.bRB != null && this.awg != null) {
            this.awg.unregisterListener(this.bRB);
            this.bRB = null;
        }
        if (this.bSq != null && this.awg != null) {
            this.awg.unregisterListener(this.bSq);
            this.bSq = null;
        }
        this.awg = null;
        this.bSr = null;
        this.bRC = null;
        this.bRF = false;
    }

    public static void release() {
        if (bSp != null) {
            bSp.Nf();
        }
    }

    private void Nf() {
        c.i("compass", "release");
        if (this.bRF) {
            adh();
        }
        this.awg = null;
        this.bSr = null;
        this.bRC = null;
        this.bRB = null;
        this.bSq = null;
        this.bSu = null;
        this.mContext = null;
        bSp = null;
    }

    private SensorEventListener acX() {
        c.i("compass", "get Accelerometer listener");
        if (this.bRB != null) {
            return this.bRB;
        }
        this.bRB = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.f.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.bSs = sensorEvent.values;
                    c.i("compass", "accelerometer changed");
                    a.this.adk();
                    return;
                }
                c.w("compass", "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bRB;
    }

    private SensorEventListener adi() {
        c.i("compass", "get MagneticFiled listener");
        if (this.bSq != null) {
            return this.bSq;
        }
        this.bSq = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.f.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.bSt = sensorEvent.values;
                    c.i("compass", "magneticFiled changed");
                    a.this.adk();
                    return;
                }
                c.w("compass", "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bSq;
    }

    private float adj() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.bSs, this.bSt);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adk() {
        if (this.bSu != null && System.currentTimeMillis() - this.bRG > 200) {
            float adj = adj();
            c.i("compass", "orientation changed, orientation : " + adj);
            this.bSu.S(adj);
            this.bRG = System.currentTimeMillis();
        }
    }
}
