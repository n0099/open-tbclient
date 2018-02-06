package com.baidu.ar.a.c;

import android.os.Bundle;
import com.baidu.ar.f;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes3.dex */
public class b {
    private d c;
    boolean a = false;
    private int d = -1;
    private boolean e = false;
    private boolean f = false;
    private Object g = new Object();
    private a b = new a();
    private com.baidu.ar.a.d.a h = new com.baidu.ar.a.d.a();

    public b(d dVar) {
        this.c = dVar;
    }

    private float a(int i, int i2, float f) {
        if (Float.isNaN(f)) {
            return f;
        }
        return (500.0f * f) / new com.baidu.ar.representation.c(i, i2, 0.0f).a(new com.baidu.ar.representation.c());
    }

    private float a(boolean z, float[] fArr) {
        if (!z || fArr == null) {
            return Float.NaN;
        }
        return a(this.c.c, this.c.d, new com.baidu.ar.representation.c(fArr[9], fArr[10], fArr[11]).a(new com.baidu.ar.representation.c()));
    }

    private void a(float[] fArr) {
        float[] fArr2 = new float[9];
        f.a(fArr, fArr.length, fArr2);
        if (Constants.DEBUG_LOG) {
            com.baidu.ar.util.b.a("ContentValues:jni optimize camera params");
            for (int i = 0; i < fArr2.length; i++) {
                com.baidu.ar.util.b.a("ContentValues:camera params after optimize is " + fArr2[i]);
            }
        }
    }

    private Bundle b(byte[] bArr, int i, int i2) {
        Bundle bundle = new Bundle();
        float[] fArr = new float[12];
        long currentTimeMillis = System.currentTimeMillis();
        int a = f.a(bArr, i, i2, fArr, fArr.length);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        com.baidu.ar.util.b.a("bdar:rdy tracking:spend time = " + (System.currentTimeMillis() - currentTimeMillis) + ", result = " + a);
        com.baidu.ar.util.b.a("ContentValues:result = " + a + ", mLastTrackResult = " + this.d);
        boolean z = this.d == 1 && a == 1;
        int a2 = z ? this.h.a((int) currentTimeMillis2) : 0;
        com.baidu.ar.util.b.a("ContentValues:isTrack = " + z);
        boolean a3 = this.b.a(z);
        boolean a4 = this.b.a();
        boolean b = this.b.b();
        this.d = a;
        this.e = z;
        float a5 = a(z, fArr);
        bundle.putInt("track2D_method_type", 1);
        bundle.putInt("result", a);
        bundle.putLong(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME, currentTimeMillis2);
        bundle.putFloat("distance", a5);
        bundle.putBoolean("isTracked", z);
        bundle.putBoolean("isTrackStatusValid", a3);
        bundle.putBoolean("trackedFromTrackLost", a4);
        bundle.putBoolean("trackLostFromTracked", b);
        bundle.putFloatArray("RTMatrix", fArr);
        bundle.putInt("averageTime", a2);
        return bundle;
    }

    private boolean b(int i, int i2) {
        try {
            f.a(0);
            a(c(i, i2));
            int a = a(i, i2);
            com.baidu.ar.util.b.b("ContentValues:init trackable result is " + a);
            com.baidu.ar.util.b.b("artracking init track algo");
            if (a != 1) {
                f.a();
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
        byte[] bArr = new byte[1];
        long currentTimeMillis = System.currentTimeMillis();
        String str = this.c.b;
        int[] iArr = this.c.a;
        com.baidu.ar.util.b.a("ContentValues:mRoi size = " + iArr[0] + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[1] + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[2] + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + iArr[3]);
        com.baidu.ar.util.b.a("ContentValues:JniClient.arInit imgBytes = " + ((int) bArr[0]) + ", tw = " + this.c.c + ", th = " + this.c.d + ", previewWidth = " + i + ", previewHeight = " + i2 + ", szModelFile = " + str);
        int a = f.a(bArr, this.c.c, this.c.d, i, i2, str, iArr);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (Constants.DEBUG_LOG) {
            com.baidu.ar.util.b.a("ContentValues:JniClient Init spend time is " + currentTimeMillis2);
        }
        return a;
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
                        com.baidu.ar.util.b.a("bdar:artracking JniClient.arInit");
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
        com.baidu.ar.util.b.b("bdar:artracking release track algo");
        synchronized (this.g) {
            this.f = true;
            if (this.a) {
                com.baidu.ar.util.b.d("bdar:artracking JniClient.arRelease");
                f.a();
            }
        }
        this.a = false;
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
