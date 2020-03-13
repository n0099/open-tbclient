package com.baidu.swan.apps.ao.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.swan.apps.console.c;
/* loaded from: classes11.dex */
public class a {
    private static volatile a bWH;
    private SensorManager aBk;
    private SensorEventListener bWI;
    private Sensor bWJ;
    private InterfaceC0207a bWM;
    private SensorEventListener bWr;
    private Sensor bWs;
    private Context mContext;
    private float[] bWK = new float[3];
    private float[] bWL = new float[3];
    private boolean bWv = false;
    private long bWw = 0;

    /* renamed from: com.baidu.swan.apps.ao.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0207a {
        void R(float f);
    }

    private a() {
    }

    public static a afO() {
        if (bWH == null) {
            synchronized (a.class) {
                if (bWH == null) {
                    bWH = new a();
                }
            }
        }
        return bWH;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0207a interfaceC0207a) {
        this.bWM = interfaceC0207a;
    }

    public void afP() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.bWv) {
            c.w("compass", "has already start");
        } else {
            this.aBk = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aBk != null) {
                this.bWs = this.aBk.getDefaultSensor(1);
                this.bWJ = this.aBk.getDefaultSensor(2);
                this.aBk.registerListener(afK(), this.bWs, 1);
                this.aBk.registerListener(afR(), this.bWJ, 1);
                this.bWv = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void afQ() {
        if (!this.bWv) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.bWr != null && this.aBk != null) {
            this.aBk.unregisterListener(this.bWr);
            this.bWr = null;
        }
        if (this.bWI != null && this.aBk != null) {
            this.aBk.unregisterListener(this.bWI);
            this.bWI = null;
        }
        this.aBk = null;
        this.bWJ = null;
        this.bWs = null;
        this.bWv = false;
    }

    public static void release() {
        if (bWH != null) {
            bWH.PR();
        }
    }

    private void PR() {
        c.i("compass", "release");
        if (this.bWv) {
            afQ();
        }
        this.aBk = null;
        this.bWJ = null;
        this.bWs = null;
        this.bWr = null;
        this.bWI = null;
        this.bWM = null;
        this.mContext = null;
        bWH = null;
    }

    private SensorEventListener afK() {
        c.i("compass", "get Accelerometer listener");
        if (this.bWr != null) {
            return this.bWr;
        }
        this.bWr = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.bWK = sensorEvent.values;
                    c.i("compass", "accelerometer changed");
                    a.this.afT();
                    return;
                }
                c.w("compass", "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bWr;
    }

    private SensorEventListener afR() {
        c.i("compass", "get MagneticFiled listener");
        if (this.bWI != null) {
            return this.bWI;
        }
        this.bWI = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.bWL = sensorEvent.values;
                    c.i("compass", "magneticFiled changed");
                    a.this.afT();
                    return;
                }
                c.w("compass", "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bWI;
    }

    private float afS() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.bWK, this.bWL);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afT() {
        if (this.bWM != null && System.currentTimeMillis() - this.bWw > 200) {
            float afS = afS();
            c.i("compass", "orientation changed, orientation : " + afS);
            this.bWM.R(afS);
            this.bWw = System.currentTimeMillis();
        }
    }
}
