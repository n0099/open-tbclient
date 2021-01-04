package com.baidu.cyberplayer.sdk;

import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
/* loaded from: classes6.dex */
public class f {
    private int j;

    /* renamed from: a  reason: collision with root package name */
    private int f1817a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f1818b = 0;
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
        this.j = 2;
    }

    public void a() {
        this.f1817a = 0;
        this.f1818b = 0;
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
        if (this.f1817a == i && this.f1818b == i2) {
            return false;
        }
        this.f1817a = i;
        this.f1818b = i2;
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
        if (this.f1817a == 0 || this.f1818b == 0 || this.h == 0 || this.i == 0) {
            return;
        }
        boolean z = this.j == 0 || this.j == 2;
        float f4 = (this.f1818b * 1.0f) / this.f1817a;
        float f5 = (this.i * 1.0f) / this.h;
        if ((this.g == 90 || this.g == 270) && this.i != 0) {
            f5 = (this.h * 1.0f) / this.i;
            if (z) {
                f = ((this.c * 1.0f) / this.d) * f5;
            }
            f = f5;
        } else {
            if (z) {
                f = ((this.d * 1.0f) / this.c) * f5;
            }
            f = f5;
        }
        CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called mVideoWidth:" + this.h + " mVideoHeight:" + this.i + " mVideoSarNum:" + this.c + " mVideoSarDen:" + this.d + " mSurfaceWidth:" + this.f1817a + " mSurfaceHeight:" + this.f1818b + " mDisplayMode:" + this.j);
        switch (this.j) {
            case 0:
                if (f <= f4) {
                    f2 = f4 / f;
                    f3 = 1.0f;
                    break;
                } else {
                    f3 = f / f4;
                    f2 = 1.0f;
                    break;
                }
            case 1:
                f3 = 1.0f;
                f2 = 1.0f;
                break;
            case 2:
                if (f <= f4) {
                    f3 = f / f4;
                    f2 = 1.0f;
                    break;
                } else {
                    f2 = f4 / f;
                    f3 = 1.0f;
                    break;
                }
            case 3:
                if (0.8f <= f4) {
                    f3 = 0.8f / f4;
                    f2 = 1.0f;
                    break;
                } else {
                    f2 = f4 / 0.8f;
                    f3 = 1.0f;
                    break;
                }
            case 4:
                if (0.75f <= f4) {
                    f3 = 0.75f / f4;
                    f2 = 1.0f;
                    break;
                } else {
                    f2 = f4 / 0.75f;
                    f3 = 1.0f;
                    break;
                }
            case 5:
                if (0.5625f <= f4) {
                    f3 = 0.5625f / f4;
                    f2 = 1.0f;
                    break;
                } else {
                    f2 = f4 / 0.5625f;
                    f3 = 1.0f;
                    break;
                }
            case 6:
                f2 = (this.h * 1.0f) / this.f1817a;
                f3 = (this.i * 1.0f) / this.f1818b;
                break;
            default:
                if (f <= f4) {
                    f3 = f / f4;
                    f2 = 1.0f;
                    break;
                } else {
                    f2 = f4 / f;
                    f3 = 1.0f;
                    break;
                }
        }
        this.k[0] = f2;
        this.k[1] = f3;
        CyberLog.d("CyberRenderSizeHelper", "updateDisplaySize called sx:" + f2 + " sy:" + f3);
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
        return this.g;
    }

    public int e() {
        return this.h;
    }

    public int f() {
        return this.i;
    }

    public int g() {
        return this.f1817a;
    }

    public int h() {
        return this.f1818b;
    }
}
