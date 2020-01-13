package com.baidu.platform.comapi.wnplatform.j;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class c extends a implements SensorEventListener {
    public static int a = 0;
    private SensorManager f;
    private Sensor g;
    private boolean h;
    private Handler j;
    private com.baidu.platform.comapi.wnplatform.model.datastruct.a r;
    private double s;
    private double t;
    private double u;
    private int c = -1;
    private float[] d = new float[3];
    private float[] e = new float[9];
    private Object i = new Object();
    private ArrayList<b> k = new ArrayList<>();
    private float[] l = new float[3];
    private float[] m = new float[3];
    private com.baidu.platform.comapi.wnplatform.model.datastruct.a n = new com.baidu.platform.comapi.wnplatform.model.datastruct.a();
    private com.baidu.platform.comapi.wnplatform.model.datastruct.a o = new com.baidu.platform.comapi.wnplatform.model.datastruct.a();
    private float[] p = new float[9];
    private float[] q = new float[3];
    private Context b = com.baidu.platform.comapi.wnplatform.o.b.a.a();

    public c() {
        this.f = null;
        this.g = null;
        try {
            this.f = (SensorManager) this.b.getSystemService("sensor");
            this.g = this.f.getDefaultSensor(11);
        } catch (Exception e) {
            this.f = null;
            this.g = null;
        }
        this.h = false;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        a();
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return false;
    }

    public void a(Context context, Handler handler) {
        b();
        this.j = handler;
    }

    public void a() {
        d();
    }

    public void a(b bVar) {
        this.k.add(bVar);
    }

    private boolean b() {
        boolean z;
        synchronized (this.i) {
            if (this.h) {
                z = true;
            } else if (((SensorManager) this.b.getSystemService("sensor")) == null) {
                z = false;
            } else {
                this.h = c();
                z = this.h;
            }
        }
        return z;
    }

    private boolean c() {
        SensorManager sensorManager;
        boolean z;
        try {
            sensorManager = (SensorManager) this.b.getSystemService("sensor");
        } catch (Exception e) {
            sensorManager = null;
        }
        if (sensorManager == null) {
            return false;
        }
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        Sensor defaultSensor2 = sensorManager.getDefaultSensor(1);
        Sensor defaultSensor3 = sensorManager.getDefaultSensor(2);
        if (defaultSensor != null) {
            try {
                z = sensorManager.registerListener(this, defaultSensor, 2);
            } catch (Exception e2) {
                z = false;
            }
        } else {
            z = false;
        }
        if (!z && defaultSensor2 != null && defaultSensor3 != null) {
            try {
                z = sensorManager.registerListener(this, defaultSensor2, 2) && sensorManager.registerListener(this, defaultSensor3, 2);
            } catch (Exception e3) {
            }
        }
        return z;
    }

    private void d() {
        if (this != null) {
            synchronized (this.i) {
                if (this.h) {
                    SensorManager sensorManager = (SensorManager) this.b.getSystemService("sensor");
                    if (sensorManager != null) {
                        this.h = false;
                        try {
                            sensorManager.unregisterListener(this);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        com.baidu.platform.comapi.wnplatform.model.datastruct.a a2;
        com.baidu.platform.comapi.wnplatform.d.a.b("onSensorChanged acc:" + sensorEvent.accuracy);
        if (this.f != null) {
            if (sensorEvent.sensor.getType() == 11) {
                a2 = b(sensorEvent);
            } else if (sensorEvent.sensor.getType() != 1 && sensorEvent.sensor.getType() != 2) {
                a2 = null;
            } else {
                a2 = a(sensorEvent);
            }
            Iterator<b> it = this.k.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (a2 != null) {
                    next.a(a2);
                }
            }
        }
    }

    private com.baidu.platform.comapi.wnplatform.model.datastruct.a a(SensorEvent sensorEvent) {
        com.baidu.platform.comapi.wnplatform.d.a.a("onSensorChanged type:" + sensorEvent.sensor.getType());
        float[] fArr = (float[]) sensorEvent.values.clone();
        int type = sensorEvent.sensor.getType();
        if (1 == type) {
            this.l = a((float[]) sensorEvent.values.clone(), this.l);
        }
        if (2 == type) {
            this.m = a((float[]) sensorEvent.values.clone(), this.m);
        }
        SensorManager.getRotationMatrix(this.p, null, this.l, this.m);
        SensorManager.getOrientation(this.p, this.q);
        synchronized (this.o) {
            this.o.a = this.l[0];
            this.o.b = this.l[1];
            this.o.c = this.l[2];
            float degrees = (float) Math.toDegrees(this.q[0]);
            if (degrees < 0.0f && degrees > -180.0f) {
                degrees += 360.0f;
            }
            this.o.d = degrees;
            this.o.e = (float) Math.toDegrees(this.q[1]);
            this.o.f = (float) Math.toDegrees(this.q[2]);
            this.n = this.o.clone();
        }
        return this.n;
    }

    private com.baidu.platform.comapi.wnplatform.model.datastruct.a b(SensorEvent sensorEvent) {
        WindowManager windowManager;
        Display defaultDisplay;
        int i;
        int degrees;
        int type = sensorEvent.sensor.getType();
        if (this.g != null && 11 == type) {
            try {
                SensorManager.getRotationMatrixFromVector(this.e, sensorEvent.values);
                SensorManager.getOrientation(this.e, this.d);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                windowManager = (WindowManager) this.b.getSystemService("window");
            } catch (Exception e2) {
                windowManager = null;
            }
            if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
                try {
                    int rotation = defaultDisplay.getRotation() * 90;
                    if (type == 11) {
                        if (rotation == 0) {
                            degrees = rotation + ((int) Math.toDegrees(this.d[0] - this.d[2]));
                        } else {
                            degrees = rotation + ((int) Math.toDegrees(this.d[0] - this.d[1]));
                        }
                        i = (degrees + 360) % 360;
                    } else {
                        i = 0;
                    }
                    this.c = i;
                    a(i, Math.toDegrees(this.d[1]), Math.toDegrees(this.d[2]));
                    this.r = new com.baidu.platform.comapi.wnplatform.model.datastruct.a();
                    this.r.d = i;
                    this.r.e = a(this.t - 90.0d);
                    this.r.f = 0.0d;
                    if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
                        if (this.j != null) {
                            Message message = new Message();
                            message.what = 2;
                            message.obj = this.r;
                            this.j.sendMessage(message);
                        }
                        a++;
                        if (a % 50 == 0) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("head:" + this.r.d);
                            sb.append("pitch:" + this.r.e);
                            com.baidu.platform.comapi.wnplatform.d.a.b("data:" + sb.toString());
                            com.baidu.platform.comapi.walknavi.b.a().b("data:" + sb.toString());
                        }
                    }
                } catch (ArrayIndexOutOfBoundsException e3) {
                    return null;
                }
            }
            return null;
        }
        return this.r;
    }

    private void a(double d, double d2, double d3) {
        double atan2;
        double atan22;
        double asin;
        double radians = Math.toRadians(d);
        double radians2 = 0.0d - Math.toRadians(d2);
        double radians3 = Math.toRadians(d3);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double cos2 = Math.cos(radians2);
        double sin2 = Math.sin(radians2);
        double cos3 = Math.cos(radians3);
        double sin3 = Math.sin(radians3);
        double[] dArr = {(sin * sin3) - ((cos * sin2) * cos3), (-cos) * cos2, (cos * sin2 * sin3) + (sin * cos3), cos2 * cos3, -sin2, (-cos2) * sin3, (sin * sin2 * cos3) + (cos * sin3), cos2 * sin, ((-sin) * sin2 * sin3) + (cos * cos3)};
        if (dArr[3] > 0.9999d) {
            atan2 = Math.atan2(dArr[2], dArr[8]);
            asin = 1.5707963267948966d;
            atan22 = 0.0d;
        } else if (dArr[3] < -0.9999d) {
            atan2 = Math.atan2(dArr[2], dArr[8]);
            asin = -1.5707963267948966d;
            atan22 = 0.0d;
        } else {
            atan2 = Math.atan2(-dArr[6], dArr[0]);
            atan22 = Math.atan2(-dArr[5], dArr[4]);
            asin = Math.asin(dArr[3]);
            if (Double.isNaN(asin)) {
                asin = 0.0d;
            }
        }
        this.s = (atan2 * 180.0d) / 3.141592653589793d;
        this.t = (asin * 180.0d) / 3.141592653589793d;
        this.u = (180.0d * atan22) / 3.141592653589793d;
    }

    private double a(double d) {
        return (((90.0d + d) / 90.0d) * (-30.0d)) + d;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        if ((i == 1 || i == 0) && com.baidu.platform.comapi.wnplatform.a.a().c() && this.j != null) {
            this.j.sendEmptyMessage(3);
        }
    }

    private float[] a(float[] fArr, float[] fArr2) {
        if (fArr2 == null || fArr == null) {
            return fArr;
        }
        int length = fArr2.length <= fArr.length ? fArr2.length : fArr.length;
        for (int i = 0; i < length; i++) {
            fArr2[i] = fArr2[i] + (0.1f * (fArr[i] - fArr2[i]));
        }
        return fArr2;
    }
}
