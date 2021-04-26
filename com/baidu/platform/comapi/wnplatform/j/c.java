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
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class c extends a implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    public static int f10216a;

    /* renamed from: b  reason: collision with root package name */
    public Context f10217b;

    /* renamed from: f  reason: collision with root package name */
    public SensorManager f10221f;

    /* renamed from: g  reason: collision with root package name */
    public Sensor f10222g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10223h;
    public Handler j;
    public com.baidu.platform.comapi.wnplatform.model.datastruct.a r;
    public double s;
    public double t;
    public double u;

    /* renamed from: c  reason: collision with root package name */
    public int f10218c = -1;

    /* renamed from: d  reason: collision with root package name */
    public float[] f10219d = new float[3];

    /* renamed from: e  reason: collision with root package name */
    public float[] f10220e = new float[9];

    /* renamed from: i  reason: collision with root package name */
    public Object f10224i = new Object();
    public ArrayList<b> k = new ArrayList<>();
    public float[] l = new float[3];
    public float[] m = new float[3];
    public com.baidu.platform.comapi.wnplatform.model.datastruct.a n = new com.baidu.platform.comapi.wnplatform.model.datastruct.a();
    public com.baidu.platform.comapi.wnplatform.model.datastruct.a o = new com.baidu.platform.comapi.wnplatform.model.datastruct.a();
    public float[] p = new float[9];
    public float[] q = new float[3];

    public c() {
        this.f10221f = null;
        this.f10222g = null;
        Context a2 = com.baidu.platform.comapi.wnplatform.o.b.a.a();
        this.f10217b = a2;
        try {
            SensorManager sensorManager = (SensorManager) a2.getSystemService("sensor");
            this.f10221f = sensorManager;
            this.f10222g = sensorManager.getDefaultSensor(11);
        } catch (Exception unused) {
            this.f10221f = null;
            this.f10222g = null;
        }
        this.f10223h = false;
    }

    private double a(double d2) {
        return (((d2 + 90.0d) / 90.0d) * (-30.0d)) + d2;
    }

    private boolean b() {
        synchronized (this.f10224i) {
            if (this.f10223h) {
                return true;
            }
            if (((SensorManager) this.f10217b.getSystemService("sensor")) == null) {
                return false;
            }
            boolean c2 = c();
            this.f10223h = c2;
            return c2;
        }
    }

    private boolean c() {
        SensorManager sensorManager;
        boolean registerListener;
        try {
            sensorManager = (SensorManager) this.f10217b.getSystemService("sensor");
        } catch (Exception unused) {
            sensorManager = null;
        }
        boolean z = false;
        if (sensorManager == null) {
            return false;
        }
        Sensor defaultSensor = sensorManager.getDefaultSensor(11);
        Sensor defaultSensor2 = sensorManager.getDefaultSensor(1);
        Sensor defaultSensor3 = sensorManager.getDefaultSensor(2);
        if (defaultSensor != null) {
            try {
                registerListener = sensorManager.registerListener(this, defaultSensor, 2);
            } catch (Exception unused2) {
            }
            if (!registerListener || defaultSensor2 == null || defaultSensor3 == null) {
                return registerListener;
            }
            try {
                boolean registerListener2 = sensorManager.registerListener(this, defaultSensor2, 2);
                boolean registerListener3 = sensorManager.registerListener(this, defaultSensor3, 2);
                if (registerListener2 && registerListener3) {
                    z = true;
                }
                return z;
            } catch (Exception unused3) {
                return registerListener;
            }
        }
        registerListener = false;
        return registerListener ? registerListener : registerListener;
    }

    private void d() {
        synchronized (this.f10224i) {
            if (this.f10223h) {
                SensorManager sensorManager = (SensorManager) this.f10217b.getSystemService("sensor");
                if (sensorManager == null) {
                    return;
                }
                this.f10223h = false;
                try {
                    sensorManager.unregisterListener(this);
                } catch (Exception unused) {
                }
            }
        }
    }

    public void a(Context context, Handler handler) {
        b();
        this.j = handler;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        Handler handler;
        if ((i2 == 1 || i2 == 0) && com.baidu.platform.comapi.wnplatform.a.a().c() && (handler = this.j) != null) {
            handler.sendEmptyMessage(3);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        com.baidu.platform.comapi.wnplatform.d.a.b("onSensorChanged acc:" + sensorEvent.accuracy);
        if (this.f10221f == null) {
            return;
        }
        com.baidu.platform.comapi.wnplatform.model.datastruct.a aVar = null;
        if (sensorEvent.sensor.getType() == 11) {
            aVar = b(sensorEvent);
        } else if (sensorEvent.sensor.getType() == 1 || sensorEvent.sensor.getType() == 2) {
            aVar = a(sensorEvent);
        }
        Iterator<b> it = this.k.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (aVar != null) {
                next.a(aVar);
            }
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return false;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public void release() {
        a();
    }

    public void a() {
        d();
    }

    public void a(b bVar) {
        this.k.add(bVar);
    }

    private com.baidu.platform.comapi.wnplatform.model.datastruct.a a(SensorEvent sensorEvent) {
        com.baidu.platform.comapi.wnplatform.model.datastruct.a clone;
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
            this.o.f10249a = this.l[0];
            this.o.f10250b = this.l[1];
            this.o.f10251c = this.l[2];
            float degrees = (float) Math.toDegrees(this.q[0]);
            if (degrees < 0.0f && degrees > -180.0f) {
                degrees += 360.0f;
            }
            this.o.f10252d = degrees;
            this.o.f10253e = (float) Math.toDegrees(this.q[1]);
            this.o.f10254f = (float) Math.toDegrees(this.q[2]);
            clone = this.o.clone();
            this.n = clone;
        }
        return clone;
    }

    private com.baidu.platform.comapi.wnplatform.model.datastruct.a b(SensorEvent sensorEvent) {
        WindowManager windowManager;
        Display defaultDisplay;
        double degrees;
        int type = sensorEvent.sensor.getType();
        if (this.f10222g != null && 11 == type) {
            try {
                SensorManager.getRotationMatrixFromVector(this.f10220e, sensorEvent.values);
                SensorManager.getOrientation(this.f10220e, this.f10219d);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                windowManager = (WindowManager) this.f10217b.getSystemService("window");
            } catch (Exception unused) {
                windowManager = null;
            }
            if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
                return null;
            }
            try {
                int rotation = defaultDisplay.getRotation() * 90;
                int i2 = 0;
                if (type == 11) {
                    if (rotation == 0) {
                        float[] fArr = this.f10219d;
                        degrees = Math.toDegrees(fArr[0] - fArr[2]);
                    } else {
                        float[] fArr2 = this.f10219d;
                        degrees = Math.toDegrees(fArr2[0] - fArr2[1]);
                    }
                    i2 = ((((int) degrees) + rotation) + 360) % 360;
                }
                this.f10218c = i2;
                double d2 = i2;
                a(d2, Math.toDegrees(this.f10219d[1]), Math.toDegrees(this.f10219d[2]));
                com.baidu.platform.comapi.wnplatform.model.datastruct.a aVar = new com.baidu.platform.comapi.wnplatform.model.datastruct.a();
                this.r = aVar;
                aVar.f10252d = d2;
                aVar.f10253e = a(this.t - 90.0d);
                this.r.f10254f = 0.0d;
                if (com.baidu.platform.comapi.wnplatform.a.a().c()) {
                    if (this.j != null) {
                        Message message = new Message();
                        message.what = 2;
                        message.obj = this.r;
                        this.j.sendMessage(message);
                    }
                    int i3 = f10216a + 1;
                    f10216a = i3;
                    if (i3 % 50 == 0) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("head:" + this.r.f10252d);
                        sb.append("pitch:" + this.r.f10253e);
                        com.baidu.platform.comapi.wnplatform.d.a.b(WebGLImageLoader.DATA_URL + sb.toString());
                        com.baidu.platform.comapi.walknavi.b.a().b(WebGLImageLoader.DATA_URL + sb.toString());
                    }
                }
            } catch (ArrayIndexOutOfBoundsException unused2) {
                return null;
            }
        }
        return this.r;
    }

    private void a(double d2, double d3, double d4) {
        double atan2;
        double atan22;
        double asin;
        double d5;
        double radians = Math.toRadians(d2);
        double radians2 = 0.0d - Math.toRadians(d3);
        double radians3 = Math.toRadians(d4);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double cos2 = Math.cos(radians2);
        double sin2 = Math.sin(radians2);
        double cos3 = Math.cos(radians3);
        double sin3 = Math.sin(radians3);
        double d6 = cos * sin2;
        double[] dArr = {(sin * sin3) - (d6 * cos3), (-cos) * cos2, (d6 * sin3) + (sin * cos3), cos2 * cos3, -sin2, (-cos2) * sin3, (sin * sin2 * cos3) + (cos * sin3), cos2 * sin, ((-sin) * sin2 * sin3) + (cos * cos3)};
        if (dArr[3] > 0.9999d) {
            atan2 = Math.atan2(dArr[2], dArr[8]);
            d5 = 1.5707963267948966d;
        } else if (dArr[3] < -0.9999d) {
            atan2 = Math.atan2(dArr[2], dArr[8]);
            d5 = -1.5707963267948966d;
        } else {
            atan2 = Math.atan2(-dArr[6], dArr[0]);
            atan22 = Math.atan2(-dArr[5], dArr[4]);
            asin = Math.asin(dArr[3]);
            if (Double.isNaN(asin)) {
                asin = 0.0d;
            }
            this.s = (atan2 * 180.0d) / 3.141592653589793d;
            this.t = (asin * 180.0d) / 3.141592653589793d;
            this.u = (atan22 * 180.0d) / 3.141592653589793d;
        }
        asin = d5;
        atan22 = 0.0d;
        this.s = (atan2 * 180.0d) / 3.141592653589793d;
        this.t = (asin * 180.0d) / 3.141592653589793d;
        this.u = (atan22 * 180.0d) / 3.141592653589793d;
    }

    private float[] a(float[] fArr, float[] fArr2) {
        if (fArr2 == null || fArr == null) {
            return fArr;
        }
        int length = fArr2.length <= fArr.length ? fArr2.length : fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            fArr2[i2] = fArr2[i2] + ((fArr[i2] - fArr2[i2]) * 0.1f);
        }
        return fArr2;
    }
}
