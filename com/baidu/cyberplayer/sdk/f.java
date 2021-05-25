package com.baidu.cyberplayer.sdk;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public int f4847a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f4848b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f4849c = 1;

    /* renamed from: d  reason: collision with root package name */
    public int f4850d = 1;

    /* renamed from: e  reason: collision with root package name */
    public int f4851e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f4852f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f4853g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f4854h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f4855i = 0;
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
        this.f4847a = 0;
        this.f4848b = 0;
        this.f4849c = 1;
        this.f4850d = 1;
        this.f4851e = 0;
        this.f4852f = 0;
        this.f4853g = 0;
        this.f4854h = 0;
        this.f4855i = 0;
        float[] fArr = this.k;
        fArr[0] = 1.0f;
        fArr[1] = 1.0f;
        this.j = 2;
    }

    public boolean a(int i2) {
        if (this.f4852f != i2) {
            this.f4852f = i2;
            this.f4853g = ((this.f4851e + 360) - i2) % 360;
            return true;
        }
        return false;
    }

    public boolean a(int i2, int i3) {
        if (this.f4847a == i2 && this.f4848b == i3) {
            return false;
        }
        this.f4847a = i2;
        this.f4848b = i3;
        return true;
    }

    public boolean a(int i2, int i3, int i4, int i5) {
        if (this.f4854h == i2 && i3 == this.f4855i && this.f4849c == i4 && this.f4850d == i5) {
            return false;
        }
        this.f4854h = i2;
        this.f4855i = i3;
        if (i5 == 0 || i4 == 0) {
            this.f4849c = 1;
            this.f4850d = 1;
        } else {
            this.f4849c = i4;
            this.f4850d = i5;
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
        int i2;
        float f2;
        int i3;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        if (this.f4847a == 0 || this.f4848b == 0 || this.f4854h == 0 || this.f4855i == 0) {
            return;
        }
        int i4 = this.j;
        boolean z = i4 == 0 || i4 == 2;
        float f8 = 1.0f;
        float f9 = (this.f4848b * 1.0f) / this.f4847a;
        float f10 = (this.f4855i * 1.0f) / this.f4854h;
        int i5 = this.f4853g;
        if ((i5 != 90 && i5 != 270) || (i2 = this.f4855i) == 0) {
            if (z) {
                f2 = this.f4850d * 1.0f;
                i3 = this.f4849c;
                f10 *= f2 / i3;
            }
            CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called mVideoWidth:" + this.f4854h + " mVideoHeight:" + this.f4855i + " mVideoSarNum:" + this.f4849c + " mVideoSarDen:" + this.f4850d + " mSurfaceWidth:" + this.f4847a + " mSurfaceHeight:" + this.f4848b + " mDisplayMode:" + this.j);
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
        f10 = (this.f4854h * 1.0f) / i2;
        if (z) {
            f2 = this.f4849c * 1.0f;
            i3 = this.f4850d;
            f10 *= f2 / i3;
        }
        CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called mVideoWidth:" + this.f4854h + " mVideoHeight:" + this.f4855i + " mVideoSarNum:" + this.f4849c + " mVideoSarDen:" + this.f4850d + " mSurfaceWidth:" + this.f4847a + " mSurfaceHeight:" + this.f4848b + " mDisplayMode:" + this.j);
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
                float f12 = (this.f4854h * 1.0f) / this.f4847a;
                f4 = (this.f4855i * 1.0f) / this.f4848b;
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

    public boolean b(int i2) {
        if (this.f4851e != i2) {
            this.f4851e = i2;
            this.f4853g = ((360 - this.f4852f) + i2) % 360;
            return true;
        }
        return false;
    }

    public boolean c(int i2) {
        if (this.j != i2) {
            this.j = i2;
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
        int i2 = this.j;
        return i2 == 7 || i2 == 8 || i2 == 9 || i2 == 10;
    }

    public int g() {
        return this.f4853g;
    }

    public int h() {
        return this.f4854h;
    }

    public int i() {
        return this.f4855i;
    }

    public int j() {
        return this.f4847a;
    }

    public int k() {
        return this.f4848b;
    }
}
