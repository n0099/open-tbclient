package com.baidu.ar.algo.a.b;

import android.opengl.Matrix;
import com.baidu.ar.algo.ARAlgoJniClient;
import com.baidu.ar.algo.TrackModel;
import com.baidu.ar.algo.TrackParams;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b {
    com.baidu.ar.algo.a.b.a a;
    float[] c;
    private boolean e;
    private float f;
    private com.baidu.ar.algo.c.a g;
    private a h;
    private int i;
    private int j;
    private boolean k;
    float b = 0.0f;
    private Object l = new Object();
    private int m = 0;
    float[] d = {-1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* loaded from: classes3.dex */
    public interface a {
        float[] a();

        float b();
    }

    public b(int i, int i2, boolean z) {
        this.a = com.baidu.ar.algo.a.b.a.a(i, i2, z);
        this.a.b = i2;
        this.a.a = i;
        this.g = new com.baidu.ar.algo.c.a();
        this.i = i;
        this.j = i2;
    }

    private TrackParams a(byte[] bArr, float[] fArr) {
        this.c = fArr;
        return ARAlgoJniClient.slamTrack(bArr, a(fArr));
    }

    private void a(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[16];
        float[] fArr4 = new float[16];
        Matrix.invertM(fArr3, 0, fArr2, 0);
        Matrix.multiplyMM(fArr4, 0, this.d, 0, fArr3, 0);
        Matrix.invertM(fArr3, 0, fArr4, 0);
        fArr[0] = fArr3[0];
        fArr[1] = fArr3[1];
        fArr[2] = fArr3[2];
        fArr[4] = fArr3[4];
        fArr[5] = fArr3[5];
        fArr[6] = fArr3[6];
        fArr[8] = fArr3[8];
        fArr[9] = fArr3[9];
        fArr[10] = fArr3[10];
        float a2 = this.a.a();
        float f = fArr[12] * this.f * a2;
        float f2 = fArr[13] * this.f * a2;
        fArr[12] = f;
        fArr[13] = f2;
        fArr[14] = a2 * fArr[14] * this.f;
        Matrix.rotateM(fArr, 0, this.b - 90.0f, 0.0f, 0.0f, 1.0f);
    }

    private float[] a(float[] fArr) {
        if (this.b == 0.0f && this.h != null) {
            this.b = this.h.b();
        }
        float[] fArr2 = new float[16];
        float[] fArr3 = new float[16];
        Matrix.invertM(fArr2, 0, fArr, 0);
        Matrix.multiplyMM(fArr3, 0, this.d, 0, fArr2, 0);
        return new float[]{-fArr3[4], -fArr3[5], -fArr3[6], -fArr3[0], -fArr3[1], -fArr3[2], -fArr3[8], -fArr3[9], -fArr3[10], 0.0f, 0.0f, 0.0f};
    }

    public int a(int i) {
        return this.g.a(i);
    }

    public int a(String str, int i, int i2, float[] fArr, float f) {
        int insertModel;
        this.f = f;
        synchronized (this.l) {
            insertModel = this.k ? -1 : ARAlgoJniClient.insertModel(str, i, i2, null, 1.0f);
        }
        return insertModel;
    }

    public TrackParams a(byte[] bArr) {
        TrackParams trackParams = null;
        if (this.e) {
            synchronized (this.l) {
                if (!this.k) {
                    float[] a2 = this.h != null ? this.h.a() : null;
                    if (a2 != null) {
                        trackParams = a(bArr, a2);
                    }
                }
            }
        }
        return trackParams;
    }

    public void a(a aVar) {
        this.h = aVar;
    }

    public boolean a() {
        boolean z;
        if (this.e) {
            return this.e;
        }
        synchronized (this.l) {
            if (this.k) {
                z = false;
            } else {
                this.e = ARAlgoJniClient.slamStart(this.a.a, this.a.b, this.a.b(), this.a.c());
                z = this.e;
            }
        }
        return z;
    }

    public float[] a(float f, float[] fArr) {
        float[] fArr2;
        synchronized (this.l) {
            if (this.k) {
                fArr2 = null;
            } else {
                float[] fArr3 = new float[2];
                fArr2 = new float[]{ARAlgoJniClient.calModelPosition(f, a(fArr), fArr3), fArr3[0], fArr3[1]};
            }
        }
        return fArr2;
    }

    public ArrayList<TrackModel> b() {
        if (this.e) {
            ArrayList<TrackModel> fetchModelPose = ARAlgoJniClient.fetchModelPose();
            Iterator<TrackModel> it = fetchModelPose.iterator();
            while (it.hasNext()) {
                a(it.next().pose, this.c);
            }
            return fetchModelPose;
        }
        return null;
    }

    public void c() {
        if (this.e) {
            synchronized (this.l) {
                this.k = true;
                ARAlgoJniClient.slamStop();
                this.g.a();
                this.e = false;
            }
        }
    }

    public int d() {
        int removeAllModel;
        synchronized (this.l) {
            removeAllModel = this.k ? 0 : ARAlgoJniClient.removeAllModel();
        }
        return removeAllModel;
    }
}
