package com.baidu.swan.apps.ao.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.swan.apps.console.c;
/* loaded from: classes11.dex */
public class a {
    private static volatile a cvJ;
    private SensorManager aVf;
    private SensorEventListener cvK;
    private Sensor cvL;
    private InterfaceC0237a cvO;
    private SensorEventListener cvt;
    private Sensor cvu;
    private Context mContext;
    private float[] cvM = new float[3];
    private float[] cvN = new float[3];
    private boolean cvx = false;
    private long cvy = 0;

    /* renamed from: com.baidu.swan.apps.ao.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0237a {
        void B(float f);
    }

    private a() {
    }

    public static a anW() {
        if (cvJ == null) {
            synchronized (a.class) {
                if (cvJ == null) {
                    cvJ = new a();
                }
            }
        }
        return cvJ;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0237a interfaceC0237a) {
        this.cvO = interfaceC0237a;
    }

    public void anX() {
        if (this.mContext == null) {
            c.e("compass", "start error, none context");
        } else if (this.cvx) {
            c.w("compass", "has already start");
        } else {
            this.aVf = (SensorManager) this.mContext.getSystemService("sensor");
            if (this.aVf != null) {
                this.cvu = this.aVf.getDefaultSensor(1);
                this.cvL = this.aVf.getDefaultSensor(2);
                this.aVf.registerListener(anS(), this.cvu, 1);
                this.aVf.registerListener(anZ(), this.cvL, 1);
                this.cvx = true;
                c.i("compass", "start listen");
                return;
            }
            c.e("compass", "none sensorManager");
        }
    }

    public void anY() {
        if (!this.cvx) {
            c.w("compass", "has already stop");
            return;
        }
        c.i("compass", "stop listen");
        if (this.cvt != null && this.aVf != null) {
            this.aVf.unregisterListener(this.cvt);
            this.cvt = null;
        }
        if (this.cvK != null && this.aVf != null) {
            this.aVf.unregisterListener(this.cvK);
            this.cvK = null;
        }
        this.aVf = null;
        this.cvL = null;
        this.cvu = null;
        this.cvx = false;
    }

    public static void release() {
        if (cvJ != null) {
            cvJ.XJ();
        }
    }

    private void XJ() {
        c.i("compass", "release");
        if (this.cvx) {
            anY();
        }
        this.aVf = null;
        this.cvL = null;
        this.cvu = null;
        this.cvt = null;
        this.cvK = null;
        this.cvO = null;
        this.mContext = null;
        cvJ = null;
    }

    private SensorEventListener anS() {
        c.i("compass", "get Accelerometer listener");
        if (this.cvt != null) {
            return this.cvt;
        }
        this.cvt = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.e.a.1
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 1) {
                    a.this.cvM = sensorEvent.values;
                    c.i("compass", "accelerometer changed");
                    a.this.aob();
                    return;
                }
                c.w("compass", "illegal accelerometer event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cvt;
    }

    private SensorEventListener anZ() {
        c.i("compass", "get MagneticFiled listener");
        if (this.cvK != null) {
            return this.cvK;
        }
        this.cvK = new SensorEventListener() { // from class: com.baidu.swan.apps.ao.e.a.2
            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null && sensorEvent.sensor != null && sensorEvent.sensor.getType() == 2) {
                    a.this.cvN = sensorEvent.values;
                    c.i("compass", "magneticFiled changed");
                    a.this.aob();
                    return;
                }
                c.w("compass", "illegal magnetic filed event");
            }

            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };
        return this.cvK;
    }

    private float aoa() {
        float[] fArr = new float[3];
        float[] fArr2 = new float[9];
        SensorManager.getRotationMatrix(fArr2, null, this.cvM, this.cvN);
        SensorManager.getOrientation(fArr2, fArr);
        return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aob() {
        if (this.cvO != null && System.currentTimeMillis() - this.cvy > 200) {
            float aoa = aoa();
            c.i("compass", "orientation changed, orientation : " + aoa);
            this.cvO.B(aoa);
            this.cvy = System.currentTimeMillis();
        }
    }
}
