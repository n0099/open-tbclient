package com.baidu.ar.imu;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Bundle;
import com.baidu.ar.util.ARLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes3.dex */
public class b implements Observer {
    public static float k;
    f a;
    Context b;
    private a p;
    float[] c = new float[16];
    float[] d = new float[4];
    float[] e = new float[16];
    float[] f = {0.0f, 0.0f, -1.0f, 0.0f};
    float g = 10000.0f;
    float h = -1.0f;
    float[] i = new float[16];
    float[] j = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float[] l = new float[16];
    private boolean m = false;
    private boolean n = true;
    private boolean o = false;
    private int q = 1;
    private List<InterfaceC0036b> r = new ArrayList();

    /* loaded from: classes3.dex */
    public interface a {
        void a(float f);
    }

    /* renamed from: com.baidu.ar.imu.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0036b {
        void a(float[] fArr);
    }

    public b(Context context) {
        this.b = context;
        com.baidu.ar.representation.a.a(this.c, 0);
        com.baidu.ar.representation.a.a(this.l, 0);
    }

    private float b(float[] fArr) {
        float f = -fArr[0];
        float f2 = -fArr[1];
        if (f2 != 0.0f || f >= 0.0f) {
            if (f2 != 0.0f || f <= 0.0f) {
                if (f != 0.0f || f2 >= 0.0f) {
                    if (f != 0.0f || f2 <= 0.0f) {
                        float atan = (float) ((Math.atan(Math.abs(f2) / Math.abs(f)) / 3.141592653589793d) * 180.0d);
                        if (f > 0.0f && f2 < 0.0f) {
                            atan = 180.0f - atan;
                        }
                        float f3 = (f <= 0.0f || f2 <= 0.0f) ? atan : 180.0f + atan;
                        return (f >= 0.0f || f2 <= 0.0f) ? f3 : 360.0f - f3;
                    }
                    return 270.0f;
                }
                return 90.0f;
            }
            return 180.0f;
        }
        return 0.0f;
    }

    private float c(float[] fArr) {
        com.baidu.ar.representation.a.b(this.d, 0, fArr, 0, this.f, 0);
        if (this.d[2] > 0.0f) {
            return -1.0f;
        }
        return 90.0f - ((float) ((Math.atan(Math.abs(this.d[2]) / ((float) Math.sqrt((this.d[0] * this.d[0]) + (this.d[1] * this.d[1])))) / 3.141592653589793d) * 180.0d));
    }

    public void a() {
        try {
            if (this.a != null) {
                if (this.q == 1 && !this.o && this.m) {
                    this.l = this.a.i.g;
                    this.o = true;
                }
                this.a.deleteObservers();
                this.a.d();
                this.a = null;
            }
        } catch (Error e) {
            e.printStackTrace();
        }
    }

    public void a(Bundle bundle) {
        if (bundle != null) {
            this.q = bundle.getInt("type");
            boolean z = bundle.getInt("resume_original_position", 0) == 1;
            if (this.q == 1) {
                if (!z) {
                    this.n = true;
                }
                this.m = z;
            }
        }
    }

    public void a(InterfaceC0036b interfaceC0036b) {
        try {
            this.r.add(interfaceC0036b);
        } catch (Error e) {
            e.printStackTrace();
        }
    }

    public boolean a(int i) {
        try {
            this.q = i;
            if (this.a == null) {
                SensorManager sensorManager = (SensorManager) this.b.getSystemService("sensor");
                if (i != 1) {
                    this.a = new c(sensorManager);
                } else if (this.m) {
                    this.a = new d(sensorManager);
                    if (!this.n) {
                        this.a.h = true;
                        this.a.i.g = this.l;
                    }
                    this.n = false;
                } else {
                    this.a = new com.baidu.ar.imu.a(sensorManager);
                }
                this.a.addObserver(this);
            }
            if (this.a.c()) {
                this.a.b();
                return true;
            }
            return false;
        } catch (Exception e) {
            ARLog.e("IMUController start: " + e.getMessage());
            return false;
        }
    }

    public float[] a(float[] fArr) {
        com.baidu.ar.representation.a.a(this.e, 0, fArr, 0);
        com.baidu.ar.representation.a.a(this.i, 0, this.j, 0, this.e, 0);
        this.h = c(this.i);
        if (this.h > 0.0f) {
            this.g = (float) (600.0d + Math.pow(1.13d, this.h));
            if (this.g > 15000.0f) {
                this.g = 15000.0f;
            }
        }
        com.baidu.ar.representation.a.b(this.d, 0, this.i, 0, new float[]{0.0f, 0.0f, -this.g, 1.0f}, 0);
        this.i[12] = -this.d[0];
        this.i[13] = -this.d[1];
        this.i[14] = -this.d[2];
        com.baidu.ar.representation.a.a(this.e, 0, this.i, 0);
        k = b(this.d);
        com.baidu.ar.representation.a.a(this.e, 0, k, 0.0f, 0.0f, 1.0f);
        return this.e;
    }

    public void b() {
        if (this.r != null) {
            this.r.clear();
        }
        if (this.a != null) {
            this.a.deleteObservers();
            this.a.d();
            this.a = null;
        }
        if (this.p != null) {
            this.p = null;
        }
    }

    public float[] c() {
        if (this.a == null) {
            float[] fArr = new float[16];
            com.baidu.ar.representation.a.a(fArr, 0);
            return fArr;
        }
        return this.a.e().g;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        try {
            float[] fArr = this.a.e().g;
            this.c = a(fArr);
            if (this.p != null) {
                this.p.a(this.h);
            }
            for (InterfaceC0036b interfaceC0036b : this.r) {
                interfaceC0036b.a(fArr);
            }
        } catch (Error e) {
            e.printStackTrace();
        }
    }
}
