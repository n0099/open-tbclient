package com.baidu.ar.d;

import android.content.Context;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import com.baidu.ar.slam.SlamStateMachine;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes3.dex */
public class b implements Observer {
    public static float l;
    d a;
    Context b;
    boolean c = false;
    float[] d = new float[16];
    float[] e = new float[4];
    float[] f = new float[16];
    float[] g = {0.0f, 0.0f, -1.0f, 0.0f};
    float h = 10000.0f;
    float i = -1.0f;
    float[] j = new float[16];
    float[] k = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private List<a> m = new ArrayList();

    /* loaded from: classes3.dex */
    public interface a {
        void a(float[] fArr);
    }

    public b(Context context) {
        this.b = context;
        Matrix.setIdentityM(this.d, 0);
    }

    private float b(float[] fArr) {
        float f = -fArr[0];
        float f2 = -fArr[1];
        if (f2 != 0.0f || f >= 0.0f) {
            if (f2 != 0.0f || f <= 0.0f) {
                if (f != 0.0f || f2 >= 0.0f) {
                    if (f != 0.0f || f2 <= 0.0f) {
                        float atan = (float) ((Math.atan(Math.abs(f2) / Math.abs(f)) / 3.141592653589793d) * 180.0d);
                        if (f >= 0.0f || f2 < 0.0f) {
                        }
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
        Matrix.multiplyMV(this.e, 0, fArr, 0, this.g, 0);
        if (this.e[2] > 0.0f) {
            return -1.0f;
        }
        return 90.0f - ((float) ((Math.atan(Math.abs(this.e[2]) / ((float) Math.sqrt((this.e[0] * this.e[0]) + (this.e[1] * this.e[1])))) / 3.141592653589793d) * 180.0d));
    }

    public void a() {
        if (this.a != null) {
            this.a.deleteObservers();
            this.a.d();
            this.a = null;
        }
    }

    public void a(a aVar) {
        this.m.add(aVar);
    }

    public boolean a(int i) {
        if (this.a == null) {
            SensorManager sensorManager = (SensorManager) this.b.getSystemService("sensor");
            if (i == 1) {
                this.a = new com.baidu.ar.d.a(sensorManager);
            } else {
                this.a = new c(sensorManager);
            }
            this.a.addObserver(this);
        }
        if (this.a.c()) {
            this.a.b();
            return true;
        }
        return false;
    }

    public float[] a(float[] fArr) {
        Matrix.invertM(this.f, 0, fArr, 0);
        Matrix.multiplyMM(this.j, 0, this.k, 0, this.f, 0);
        this.i = c(this.j);
        if (this.i > 0.0f) {
            this.h = (float) (600.0d + Math.pow(1.13d, this.i));
            if (this.h > 15000.0f) {
                this.h = 15000.0f;
            }
        }
        Matrix.multiplyMV(this.e, 0, this.j, 0, new float[]{0.0f, 0.0f, -this.h, 1.0f}, 0);
        this.j[12] = -this.e[0];
        this.j[13] = -this.e[1];
        this.j[14] = -this.e[2];
        Matrix.invertM(this.f, 0, this.j, 0);
        l = b(this.e);
        Matrix.rotateM(this.f, 0, l, 0.0f, 0.0f, 1.0f);
        return this.f;
    }

    public void b() {
        if (this.m != null) {
            this.m.clear();
        }
        if (this.a != null) {
            this.a.deleteObservers();
            this.a.d();
            this.a = null;
        }
    }

    public void c() {
        this.c = true;
    }

    public float[] d() {
        if (this.a == null) {
            return null;
        }
        return this.d;
    }

    public float[] e() {
        if (this.a == null) {
            return null;
        }
        return this.a.e().g;
    }

    public float f() {
        return this.h;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (this.c) {
            this.d = a(this.a.e().g);
            if (this.i <= 0.0f || this.i >= 90.0f) {
                SlamStateMachine.a().a(SlamStateMachine.EVENT.SLAM_ELEVATION_ANGLE_BIG);
            } else {
                SlamStateMachine.a().a(SlamStateMachine.EVENT.SLAM_ELEVATION_ANGLE_NORMAL);
            }
        }
        for (a aVar : this.m) {
            aVar.a(this.a.e().g);
        }
    }
}
