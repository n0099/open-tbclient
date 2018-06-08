package com.baidu.ar.algo.a.c;

import android.os.Bundle;
import com.baidu.ar.algo.ARAlgoJniClient;
/* loaded from: classes3.dex */
public class b {
    private c c;
    boolean a = false;
    private int d = -1;
    private boolean e = false;
    private boolean f = false;
    private Object g = new Object();
    private a b = new a();
    private com.baidu.ar.algo.c.a h = new com.baidu.ar.algo.c.a();

    public b(c cVar) {
        this.c = cVar;
    }

    private float a(int i, int i2, float f) {
        if (Float.isNaN(f)) {
            return f;
        }
        return (500.0f * f) / ((float) Math.sqrt((i * i) + (i2 * i2)));
    }

    private float a(boolean z, float[] fArr) {
        if (!z || fArr == null) {
            return Float.NaN;
        }
        return a(this.c.c, this.c.d, (float) Math.sqrt((fArr[9] * fArr[9]) + (fArr[10] * fArr[10]) + (fArr[11] * fArr[11])));
    }

    private void a(float[] fArr) {
        ARAlgoJniClient.arCameraIntrinsics(fArr, fArr.length, new float[9]);
    }

    private Bundle b(byte[] bArr, int i, int i2) {
        Bundle bundle = new Bundle();
        float[] fArr = new float[12];
        long currentTimeMillis = System.currentTimeMillis();
        int arTracking = ARAlgoJniClient.arTracking(bArr, i, i2, fArr, fArr.length);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        boolean z = this.d == 1 && arTracking == 1;
        int a = z ? this.h.a((int) currentTimeMillis2) : 0;
        boolean a2 = this.b.a(z);
        boolean a3 = this.b.a();
        boolean b = this.b.b();
        this.d = arTracking;
        this.e = z;
        float a4 = a(z, fArr);
        bundle.putInt("track2D_method_type", 1);
        bundle.putInt("result", arTracking);
        bundle.putLong("time", currentTimeMillis2);
        bundle.putFloat("distance", a4);
        bundle.putBoolean("isTracked", z);
        bundle.putBoolean("isTrackStatusValid", a2);
        bundle.putBoolean("trackedFromTrackLost", a3);
        bundle.putBoolean("trackLostFromTracked", b);
        bundle.putFloatArray("RTMatrix", fArr);
        bundle.putInt("averageTime", a);
        return bundle;
    }

    private boolean b(int i, int i2) {
        try {
            ARAlgoJniClient.arSetMatchTrackMode(0);
            a(c(i, i2));
            int a = a(i, i2);
            if (a != 1) {
                ARAlgoJniClient.arRelease();
            }
            return a == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private float[] c(int i, int i2) {
        float f = (600.0f * i) / 640.0f;
        return new float[]{f, 0.0f, i / 2.0f, 0.0f, f, i2 / 2.0f, 0.0f, 0.0f, 1.0f};
    }

    public int a(int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        int arInit = ARAlgoJniClient.arInit(new byte[1], com.baidu.sapi2.biometrics.liveness.camera.a.d, com.baidu.sapi2.biometrics.liveness.camera.a.d, i, i2, this.c.b, this.c.a);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        return arInit;
    }

    public Bundle a(byte[] bArr, int i, int i2) {
        Bundle bundle = null;
        if (!this.f && bArr != null) {
            synchronized (this.g) {
                if (this.a) {
                    bundle = b(bArr, i, i2);
                } else if (!this.f) {
                    if (this.c != null) {
                        this.a = b(i, i2);
                        bundle = new Bundle();
                        bundle.putInt("track2D_method_type", 0);
                        bundle.putBoolean("result", this.a);
                    }
                }
            }
        }
        return bundle;
    }

    public void a() {
        synchronized (this.g) {
            this.f = true;
            if (this.a) {
                ARAlgoJniClient.arRelease();
            }
            this.a = false;
        }
        this.b.c();
        this.d = -1;
        if (this.e) {
            this.e = false;
        }
        if (this.h != null) {
            this.h.a();
        }
    }
}
