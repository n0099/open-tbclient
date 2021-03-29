package com.baidu.cyberplayer.sdk;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public int f4935a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f4936b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f4937c = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f4938d = 1;

    /* renamed from: e  reason: collision with root package name */
    public int f4939e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f4940f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f4941g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f4942h = 0;
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
        this.f4935a = 0;
        this.f4936b = 0;
        this.f4937c = 1;
        this.f4938d = 1;
        this.f4939e = 0;
        this.f4940f = 0;
        this.f4941g = 0;
        this.f4942h = 0;
        this.i = 0;
        float[] fArr = this.k;
        fArr[0] = 1.0f;
        fArr[1] = 1.0f;
        this.j = 2;
    }

    public boolean a(int i) {
        if (this.f4940f != i) {
            this.f4940f = i;
            this.f4941g = ((this.f4939e + 360) - i) % 360;
            return true;
        }
        return false;
    }

    public boolean a(int i, int i2) {
        if (this.f4935a == i && this.f4936b == i2) {
            return false;
        }
        this.f4935a = i;
        this.f4936b = i2;
        return true;
    }

    public boolean a(int i, int i2, int i3, int i4) {
        if (this.f4942h == i && i2 == this.i && this.f4937c == i3 && this.f4938d == i4) {
            return false;
        }
        this.f4942h = i;
        this.i = i2;
        if (i4 == 0 || i3 == 0) {
            this.f4937c = 1;
            this.f4938d = 1;
        } else {
            this.f4937c = i3;
            this.f4938d = i4;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bb, code lost:
        if (r5 > r3) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ff, code lost:
        if (0.5625f > r3) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0106, code lost:
        if (0.75f > r3) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x010e, code lost:
        if (0.8f > r3) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0110, code lost:
        r3 = r3 / r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0112, code lost:
        r5 = r0 / r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0117, code lost:
        if (r5 > r3) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0120, code lost:
        if (r5 > r3) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011a A[PHI: r4 r7 
      PHI: (r4v1 float) = (r4v0 float), (r4v6 float) binds: [B:31:0x00b6, B:70:0x0125] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r7v2 float) = (r7v1 float), (r7v4 float) binds: [B:31:0x00b6, B:70:0x0125] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        int i;
        float f2;
        int i2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        if (this.f4935a == 0 || this.f4936b == 0 || this.f4942h == 0 || this.i == 0) {
            return;
        }
        int i3 = this.j;
        boolean z = i3 == 0 || i3 == 2;
        float f8 = 1.0f;
        float f9 = (this.f4936b * 1.0f) / this.f4935a;
        float f10 = (this.i * 1.0f) / this.f4942h;
        int i4 = this.f4941g;
        if ((i4 != 90 && i4 != 270) || (i = this.i) == 0) {
            if (z) {
                f2 = this.f4938d * 1.0f;
                i2 = this.f4937c;
                f10 *= f2 / i2;
            }
            CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called mVideoWidth:" + this.f4942h + " mVideoHeight:" + this.i + " mVideoSarNum:" + this.f4937c + " mVideoSarDen:" + this.f4938d + " mSurfaceWidth:" + this.f4935a + " mSurfaceHeight:" + this.f4936b + " mDisplayMode:" + this.j);
            float f11 = 0.0f;
            switch (this.j) {
            }
            float[] fArr = this.k;
            fArr[0] = f8;
            fArr[1] = f4;
            float[] fArr2 = this.l;
            fArr2[0] = f11;
            fArr2[1] = f3;
            CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called sx:" + f8 + " sy:" + f4 + " translateX:" + f11 + " translateY:" + f3);
        }
        f10 = (this.f4942h * 1.0f) / i;
        if (z) {
            f2 = this.f4937c * 1.0f;
            i2 = this.f4938d;
            f10 *= f2 / i2;
        }
        CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called mVideoWidth:" + this.f4942h + " mVideoHeight:" + this.i + " mVideoSarNum:" + this.f4937c + " mVideoSarDen:" + this.f4938d + " mSurfaceWidth:" + this.f4935a + " mSurfaceHeight:" + this.f4936b + " mDisplayMode:" + this.j);
        float f112 = 0.0f;
        switch (this.j) {
            case 1:
                f3 = 0.0f;
                f4 = 1.0f;
                break;
            case 3:
                f5 = 0.8f;
                break;
            case 4:
                f5 = 0.75f;
                break;
            case 5:
                f5 = 0.5625f;
                break;
            case 6:
                float f12 = (this.f4942h * 1.0f) / this.f4935a;
                f4 = (this.i * 1.0f) / this.f4936b;
                f8 = f12;
                f3 = 0.0f;
                break;
            case 7:
                if (f10 <= f9) {
                    f6 = f9 / f10;
                    f7 = 1.0f - f6;
                    f112 = f7;
                    f8 = f6;
                    f3 = 0.0f;
                    f4 = 1.0f;
                    break;
                }
                f4 = f10 / f9;
                f3 = 0.0f;
                break;
            case 8:
                if (f10 <= f9) {
                    f6 = f9 / f10;
                    f7 = f6 - 1.0f;
                    f112 = f7;
                    f8 = f6;
                    f3 = 0.0f;
                    f4 = 1.0f;
                    break;
                }
                f4 = f10 / f9;
                f3 = 0.0f;
                break;
            case 9:
                if (f10 > f9) {
                    f4 = f10 / f9;
                    f3 = f4 - 1.0f;
                    break;
                }
                f6 = f9 / f10;
                f8 = f6;
                f3 = 0.0f;
                f4 = 1.0f;
                break;
            case 10:
                if (f10 > f9) {
                    f4 = f10 / f9;
                    f3 = 1.0f - f4;
                    break;
                }
                f6 = f9 / f10;
                f8 = f6;
                f3 = 0.0f;
                f4 = 1.0f;
                break;
        }
        float[] fArr3 = this.k;
        fArr3[0] = f8;
        fArr3[1] = f4;
        float[] fArr22 = this.l;
        fArr22[0] = f112;
        fArr22[1] = f3;
        CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called sx:" + f8 + " sy:" + f4 + " translateX:" + f112 + " translateY:" + f3);
    }

    public boolean b(int i) {
        if (this.f4939e != i) {
            this.f4939e = i;
            this.f4941g = ((360 - this.f4940f) + i) % 360;
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
        return this.f4941g;
    }

    public int h() {
        return this.f4942h;
    }

    public int i() {
        return this.i;
    }

    public int j() {
        return this.f4935a;
    }

    public int k() {
        return this.f4936b;
    }
}
