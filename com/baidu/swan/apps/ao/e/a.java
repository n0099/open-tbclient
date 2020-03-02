package com.baidu.swan.apps.ao.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.swan.apps.console.c;
/* loaded from: classes11.dex */
public class a {
    private static volatile a bWG;
    private SensorManager aBj;
    private SensorEventListener bWH;
    private Sensor bWI;
    private InterfaceC0207a bWL;
    private SensorEventListener bWq;
    private Sensor bWr;
    private Context mContext;
    private float[] bWJ = new float[3];
    private float[] bWK = new float[3];
    private boolean bWu = false;
    private long bWv = 0;

    /* renamed from: com.baidu.swan.apps.ao.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0207a {
        void R(float f);
    }

    private a() {
    }

    public static a afO() {
        if (bWG == null) {
            synchronized (a.class) {
                if (bWG == null) {
                    bWG = new a();
                }
            }
        }
        return bWG;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0207a interfaceC0207a) {
        this.bWL = interfaceC0207a;
    }

    public void afP() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.bWu) {
            c.w("compass", "has already start");
        } else {
            this.aBj = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aBj != null) {
                this.bWr = this.aBj.getDefaultSensor(1);
                this.bWI = this.aBj.getDefaultSensor(2);
                this.aBj.registerListener(afK(), this.bWr, 1);
                this.aBj.registerListener(afR(), this.bWI, 1);
                this.bWu = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void afQ() {
        if (!this.bWu) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.bWq != null && this.aBj != null) {
            this.aBj.unregisterListener(this.bWq);
            this.bWq = null;
        }
        if (this.bWH != null && this.aBj != null) {
            this.aBj.unregisterListener(this.bWH);
            this.bWH = null;
        }
        this.aBj = null;
        this.bWI = null;
        this.bWr = null;
        this.bWu = false;
    }

    public static void release() {
        if (bWG != null) {
            bWG.PR();
        }
    }

    private void PR() {
        c.i("compass", "release");
        if (this.bWu) {
            afQ();
        }
        this.aBj = null;
        this.bWI = null;
        this.bWr = null;
        this.bWq = null;
        this.bWH = null;
        this.bWL = null;
        this.mContext = null;
        bWG = null;
    }

    private SensorEventListener afK() {
        c.i("compass", "get Accelerometer listener");
        if (this.bWq != null) {
            return this.bWq;
        }
        this.bWq = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.bWJ = sensorEvent.values;
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
        return this.bWq;
    }

    private SensorEventListener afR() {
        c.i("compass", "get MagneticFiled listener");
        if (this.bWH != null) {
            return this.bWH;
        }
        this.bWH = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.bWK = sensorEvent.values;
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
        return this.bWH;
    }

    private float afS() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.bWJ, this.bWK);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afT() {
        if (this.bWL != null && System.currentTimeMillis() - this.bWv > 200) {
            float afS = afS();
            c.i("compass", "orientation changed, orientation : " + afS);
            this.bWL.R(afS);
            this.bWv = System.currentTimeMillis();
        }
    }
}
