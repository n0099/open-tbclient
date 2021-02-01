package com.baidu.cyberplayer.sdk;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
/* loaded from: classes4.dex */
public class f {
    private int j;
    private float[] l;

    /* renamed from: a  reason: collision with root package name */
    private int f1766a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f1767b = 0;
    private int c = 1;
    private int d = 1;
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private float[] k = new float[2];

    public f() {
        this.j = 0;
        this.k[0] = 1.0f;
        this.k[1] = 1.0f;
        this.l = new float[2];
        this.l[0] = 0.0f;
        this.l[1] = 0.0f;
        this.j = 2;
    }

    public void a() {
        this.f1766a = 0;
        this.f1767b = 0;
        this.c = 1;
        this.d = 1;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.k[0] = 1.0f;
        this.k[1] = 1.0f;
        this.j = 2;
    }

    public boolean a(int i) {
        if (this.f != i) {
            this.f = i;
            this.g = ((this.e + EncoderTextureDrawer.X264_WIDTH) - i) % EncoderTextureDrawer.X264_WIDTH;
            return true;
        }
        return false;
    }

    public boolean a(int i, int i2) {
        if (this.f1766a == i && this.f1767b == i2) {
            return false;
        }
        this.f1766a = i;
        this.f1767b = i2;
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
            return true;
        }
        this.c = i3;
        this.d = i4;
        return true;
    }

    public void b() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        if (this.f1766a == 0 || this.f1767b == 0 || this.h == 0 || this.i == 0) {
            return;
        }
        boolean z = this.j == 0 || this.j == 2;
        float f6 = (this.f1767b * 1.0f) / this.f1766a;
        float f7 = (this.i * 1.0f) / this.h;
        if ((this.g == 90 || this.g == 270) && this.i != 0) {
            f7 = (this.h * 1.0f) / this.i;
            if (z) {
                f = ((this.c * 1.0f) / this.d) * f7;
            }
            f = f7;
        } else {
            if (z) {
                f = ((this.d * 1.0f) / this.c) * f7;
            }
            f = f7;
        }
        CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called mVideoWidth:" + this.h + " mVideoHeight:" + this.i + " mVideoSarNum:" + this.c + " mVideoSarDen:" + this.d + " mSurfaceWidth:" + this.f1766a + " mSurfaceHeight:" + this.f1767b + " mDisplayMode:" + this.j);
        switch (this.j) {
            case 0:
                if (f <= f6) {
                    f2 = f6 / f;
                    f3 = 0.0f;
                    f4 = 0.0f;
                    f5 = 1.0f;
                    break;
                } else {
                    f5 = f / f6;
                    f3 = 0.0f;
                    f4 = 0.0f;
                    f2 = 1.0f;
                    break;
                }
            case 1:
                f3 = 0.0f;
                f4 = 0.0f;
                f5 = 1.0f;
                f2 = 1.0f;
                break;
            case 2:
                if (f <= f6) {
                    f5 = f / f6;
                    f3 = 0.0f;
                    f4 = 0.0f;
                    f2 = 1.0f;
                    break;
                } else {
                    f2 = f6 / f;
                    f3 = 0.0f;
                    f4 = 0.0f;
                    f5 = 1.0f;
                    break;
                }
            case 3:
                if (0.8f <= f6) {
                    f5 = 0.8f / f6;
                    f3 = 0.0f;
                    f4 = 0.0f;
                    f2 = 1.0f;
                    break;
                } else {
                    f2 = f6 / 0.8f;
                    f3 = 0.0f;
                    f4 = 0.0f;
                    f5 = 1.0f;
                    break;
                }
            case 4:
                if (0.75f <= f6) {
                    f5 = 0.75f / f6;
                    f3 = 0.0f;
                    f4 = 0.0f;
                    f2 = 1.0f;
                    break;
                } else {
                    f2 = f6 / 0.75f;
                    f3 = 0.0f;
                    f4 = 0.0f;
                    f5 = 1.0f;
                    break;
                }
            case 5:
                if (0.5625f <= f6) {
                    f5 = 0.5625f / f6;
                    f3 = 0.0f;
                    f4 = 0.0f;
                    f2 = 1.0f;
                    break;
                } else {
                    f2 = f6 / 0.5625f;
                    f3 = 0.0f;
                    f4 = 0.0f;
                    f5 = 1.0f;
                    break;
                }
            case 6:
                f2 = (this.h * 1.0f) / this.f1766a;
                f5 = (this.i * 1.0f) / this.f1767b;
                f3 = 0.0f;
                f4 = 0.0f;
                break;
            case 7:
                if (f <= f6) {
                    f2 = f6 / f;
                    f4 = 1.0f - f2;
                    f3 = 0.0f;
                    f5 = 1.0f;
                    break;
                } else {
                    f5 = f / f6;
                    f3 = 0.0f;
                    f4 = 0.0f;
                    f2 = 1.0f;
                    break;
                }
            case 8:
                if (f <= f6) {
                    f2 = f6 / f;
                    f4 = f2 - 1.0f;
                    f3 = 0.0f;
                    f5 = 1.0f;
                    break;
                } else {
                    f5 = f / f6;
                    f3 = 0.0f;
                    f4 = 0.0f;
                    f2 = 1.0f;
                    break;
                }
            case 9:
                if (f <= f6) {
                    f2 = f6 / f;
                    f3 = 0.0f;
                    f4 = 0.0f;
                    f5 = 1.0f;
                    break;
                } else {
                    f5 = f / f6;
                    f3 = f5 - 1.0f;
                    f4 = 0.0f;
                    f2 = 1.0f;
                    break;
                }
            case 10:
                if (f <= f6) {
                    f2 = f6 / f;
                    f3 = 0.0f;
                    f4 = 0.0f;
                    f5 = 1.0f;
                    break;
                } else {
                    f5 = f / f6;
                    f3 = 1.0f - f5;
                    f4 = 0.0f;
                    f2 = 1.0f;
                    break;
                }
            default:
                if (f <= f6) {
                    f5 = f / f6;
                    f3 = 0.0f;
                    f4 = 0.0f;
                    f2 = 1.0f;
                    break;
                } else {
                    f2 = f6 / f;
                    f3 = 0.0f;
                    f4 = 0.0f;
                    f5 = 1.0f;
                    break;
                }
        }
        this.k[0] = f2;
        this.k[1] = f5;
        this.l[0] = f4;
        this.l[1] = f3;
        CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called sx:" + f2 + " sy:" + f5 + " translateX:" + f4 + " translateY:" + f3);
    }

    public boolean b(int i) {
        if (this.e != i) {
            this.e = i;
            this.g = ((360 - this.f) + i) % EncoderTextureDrawer.X264_WIDTH;
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
        return this.j == 7 || this.j == 8 || this.j == 9 || this.j == 10;
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
        return this.f1766a;
    }

    public int k() {
        return this.f1767b;
    }
}
