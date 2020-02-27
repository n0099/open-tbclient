package com.baidu.swan.apps.ao.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.swan.apps.console.c;
/* loaded from: classes11.dex */
public class a {
    private static volatile a bWF;
    private SensorManager aBi;
    private SensorEventListener bWG;
    private Sensor bWH;
    private InterfaceC0207a bWK;
    private SensorEventListener bWp;
    private Sensor bWq;
    private Context mContext;
    private float[] bWI = new float[3];
    private float[] bWJ = new float[3];
    private boolean bWt = false;
    private long bWu = 0;

    /* renamed from: com.baidu.swan.apps.ao.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0207a {
        void R(float f);
    }

    private a() {
    }

    public static a afM() {
        if (bWF == null) {
            synchronized (a.class) {
                if (bWF == null) {
                    bWF = new a();
                }
            }
        }
        return bWF;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0207a interfaceC0207a) {
        this.bWK = interfaceC0207a;
    }

    public void afN() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.bWt) {
            c.w("compass", "has already start");
        } else {
            this.aBi = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aBi != null) {
                this.bWq = this.aBi.getDefaultSensor(1);
                this.bWH = this.aBi.getDefaultSensor(2);
                this.aBi.registerListener(afI(), this.bWq, 1);
                this.aBi.registerListener(afP(), this.bWH, 1);
                this.bWt = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void afO() {
        if (!this.bWt) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.bWp != null && this.aBi != null) {
            this.aBi.unregisterListener(this.bWp);
            this.bWp = null;
        }
        if (this.bWG != null && this.aBi != null) {
            this.aBi.unregisterListener(this.bWG);
            this.bWG = null;
        }
        this.aBi = null;
        this.bWH = null;
        this.bWq = null;
        this.bWt = false;
    }

    public static void release() {
        if (bWF != null) {
            bWF.PP();
        }
    }

    private void PP() {
        c.i("compass", "release");
        if (this.bWt) {
            afO();
        }
        this.aBi = null;
        this.bWH = null;
        this.bWq = null;
        this.bWp = null;
        this.bWG = null;
        this.bWK = null;
        this.mContext = null;
        bWF = null;
    }

    private SensorEventListener afI() {
        c.i("compass", "get Accelerometer listener");
        if (this.bWp != null) {
            return this.bWp;
        }
        this.bWp = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.bWI = sensorEvent.values;
                    c.i("compass", "accelerometer changed");
                    a.this.afR();
                    return;
                }
                c.w("compass", "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bWp;
    }

    private SensorEventListener afP() {
        c.i("compass", "get MagneticFiled listener");
        if (this.bWG != null) {
            return this.bWG;
        }
        this.bWG = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.bWJ = sensorEvent.values;
                    c.i("compass", "magneticFiled changed");
                    a.this.afR();
                    return;
                }
                c.w("compass", "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.bWG;
    }

    private float afQ() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.bWI, this.bWJ);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afR() {
        if (this.bWK != null && System.currentTimeMillis() - this.bWu > 200) {
            float afQ = afQ();
            c.i("compass", "orientation changed, orientation : " + afQ);
            this.bWK.R(afQ);
            this.bWu = System.currentTimeMillis();
        }
    }
}
