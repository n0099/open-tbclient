package com.baidu.cyberplayer.sdk;
/* loaded from: classes3.dex */
public class f {
    public int a = 0;
    public int b = 0;
    public int c = 1;
    public int d = 1;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j;
    public float[] k;
    public float[] l;

    public f() {
        this.j = 0;
        this.k = r3;
        float[] fArr = {1.0f, 1.0f};
        this.l = r3;
        float[] fArr2 = {0.0f, 0.0f};
        this.j = 2;
    }

    public void a() {
        this.a = 0;
        this.b = 0;
        this.c = 1;
        this.d = 1;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        float[] fArr = this.k;
        fArr[0] = 1.0f;
        fArr[1] = 1.0f;
        this.j = 2;
    }

    public boolean a(int i) {
        if (this.f != i) {
            this.f = i;
            this.g = ((this.e + 360) - i) % 360;
            return true;
        }
        return false;
    }

    public boolean a(int i, int i2) {
        if (this.a == i && this.b == i2) {
            return false;
        }
        this.a = i;
        this.b = i2;
        return true;
    }

    public boolean a(int i, int i2, int i3, int i4) {
        if (this.h == i && i2 == this.i && this.c == i3 && this.d == i4) {
            return false;
        }
        this.h = i;
        this.i = i2;
        if (i4 == 0 || i3 == 0) {
            this.c = 1;
            this.d = 1;
        } else {
            this.c = i3;
            this.d = i4;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bc, code lost:
        if (r5 > r3) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0100, code lost:
        if (0.5625f > r3) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0107, code lost:
        if (0.75f > r3) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x010f, code lost:
        if (0.8f > r3) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0111, code lost:
        r3 = r3 / r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0113, code lost:
        r5 = r0 / r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0118, code lost:
        if (r5 > r3) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0121, code lost:
        if (r5 > r3) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011b A[PHI: r4 r7 
      PHI: (r4v1 float) = (r4v0 float), (r4v6 float) binds: [B:31:0x00b7, B:70:0x0126] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r7v2 float) = (r7v1 float), (r7v4 float) binds: [B:31:0x00b7, B:70:0x0126] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        int i;
        float f;
        int i2;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        if (this.a == 0 || this.b == 0 || this.h == 0 || this.i == 0) {
            return;
        }
        int i3 = this.j;
        boolean z = i3 == 0 || i3 == 2;
        float f7 = 1.0f;
        float f8 = (this.b * 1.0f) / this.a;
        float f9 = (this.i * 1.0f) / this.h;
        int i4 = this.g;
        if ((i4 != 90 && i4 != 270) || (i = this.i) == 0) {
            if (z) {
                f = this.d * 1.0f;
                i2 = this.c;
                f9 *= f / i2;
            }
            CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called mVideoWidth:" + this.h + " mVideoHeight:" + this.i + " mVideoSarNum:" + this.c + " mVideoSarDen:" + this.d + " mSurfaceWidth:" + this.a + " mSurfaceHeight:" + this.b + " mDisplayMode:" + this.j);
            float f10 = 0.0f;
            switch (this.j) {
            }
            float[] fArr = this.k;
            fArr[0] = f7;
            fArr[1] = f3;
            float[] fArr2 = this.l;
            fArr2[0] = f10;
            fArr2[1] = f2;
            CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called sx:" + f7 + " sy:" + f3 + " translateX:" + f10 + " translateY:" + f2);
        }
        f9 = (this.h * 1.0f) / i;
        if (z) {
            f = this.c * 1.0f;
            i2 = this.d;
            f9 *= f / i2;
        }
        CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called mVideoWidth:" + this.h + " mVideoHeight:" + this.i + " mVideoSarNum:" + this.c + " mVideoSarDen:" + this.d + " mSurfaceWidth:" + this.a + " mSurfaceHeight:" + this.b + " mDisplayMode:" + this.j);
        float f102 = 0.0f;
        switch (this.j) {
            case 1:
                f2 = 0.0f;
                f3 = 1.0f;
                break;
            case 3:
                f4 = 0.8f;
                break;
            case 4:
                f4 = 0.75f;
                break;
            case 5:
                f4 = 0.5625f;
                break;
            case 6:
                float f11 = (this.h * 1.0f) / this.a;
                f3 = (this.i * 1.0f) / this.b;
                f7 = f11;
                f2 = 0.0f;
                break;
            case 7:
                if (f9 <= f8) {
                    f5 = f8 / f9;
                    f6 = 1.0f - f5;
                    f102 = f6;
                    f7 = f5;
                    f2 = 0.0f;
                    f3 = 1.0f;
                    break;
                }
                f3 = f9 / f8;
                f2 = 0.0f;
                break;
            case 8:
                if (f9 <= f8) {
                    f5 = f8 / f9;
                    f6 = f5 - 1.0f;
                    f102 = f6;
                    f7 = f5;
                    f2 = 0.0f;
                    f3 = 1.0f;
                    break;
                }
                f3 = f9 / f8;
                f2 = 0.0f;
                break;
            case 9:
                if (f9 > f8) {
                    f3 = f9 / f8;
                    f2 = f3 - 1.0f;
                    break;
                }
                f5 = f8 / f9;
                f7 = f5;
                f2 = 0.0f;
                f3 = 1.0f;
                break;
            case 10:
                if (f9 > f8) {
                    f3 = f9 / f8;
                    f2 = 1.0f - f3;
                    break;
                }
                f5 = f8 / f9;
                f7 = f5;
                f2 = 0.0f;
                f3 = 1.0f;
                break;
        }
        float[] fArr3 = this.k;
        fArr3[0] = f7;
        fArr3[1] = f3;
        float[] fArr22 = this.l;
        fArr22[0] = f102;
        fArr22[1] = f2;
        CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called sx:" + f7 + " sy:" + f3 + " translateX:" + f102 + " translateY:" + f2);
    }

    public boolean b(int i) {
        if (this.e != i) {
            this.e = i;
            this.g = ((360 - this.f) + i) % 360;
            return true;
        }
        return false;
    }

    public boolean c(int i) {
        if (this.j != i) {
            this.j = i;
            return true;
        }
        return false;
    }

    public float[] c() {
        return this.k;
    }

    public int d() {
        return this.j;
    }

    public float[] e() {
        return this.l;
    }

    public boolean f() {
        int i = this.j;
        return i == 7 || i == 8 || i == 9 || i == 10;
    }

    public int g() {
        return this.g;
    }

    public int h() {
        return this.h;
    }

    public int i() {
        return this.i;
    }

    public int j() {
        return this.a;
    }

    public int k() {
        return this.b;
    }
}
