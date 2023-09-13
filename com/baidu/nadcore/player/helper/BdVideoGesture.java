package com.baidu.nadcore.player.helper;

import android.content.Context;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.baidu.tieba.bu0;
import com.baidu.tieba.e81;
import com.baidu.tieba.g71;
import com.baidu.tieba.i21;
import com.baidu.tieba.tj0;
import com.baidu.tieba.tx0;
/* loaded from: classes3.dex */
public class BdVideoGesture {
    public static final int o = i21.b(tj0.b()) / 10;
    public float a;
    public float b;
    public int c;
    public int k;
    public tx0 l;
    public boolean d = true;
    public VideoPluginGesture e = VideoPluginGesture.InitChange;
    public boolean f = false;
    public boolean g = false;
    public int h = 0;
    public int i = 0;
    public int j = 0;
    public int m = bu0.a;
    public int n = bu0.b;

    /* loaded from: classes3.dex */
    public enum VideoPluginGesture {
        InitChange,
        VolumeChange,
        PlayTimeChange,
        BrightChange,
        VirtualKeyBoard
    }

    public void a(float f, int i) {
    }

    public abstract boolean c(MotionEvent motionEvent);

    public final boolean e(float f, float f2) {
        return f >= f2;
    }

    public abstract void f(Context context);

    public void g() {
        this.e = VideoPluginGesture.InitChange;
    }

    public void h() {
        this.l = null;
    }

    public BdVideoGesture(Context context, @NonNull tx0 tx0Var) {
        f(context);
        this.l = tx0Var;
    }

    public boolean b(MotionEvent motionEvent) {
        tx0 tx0Var = this.l;
        if (tx0Var == null) {
            return false;
        }
        if (tx0Var.p()) {
            this.l.m(this.e);
            return false;
        } else if (motionEvent.getAction() == 0) {
            this.f = false;
            this.g = false;
            this.e = VideoPluginGesture.InitChange;
            this.a = motionEvent.getX();
            this.b = motionEvent.getY();
            this.c = motionEvent.getPointerId(0);
            this.i = i21.c(tj0.b());
            this.j = this.l.getCurrentPosition();
            this.k = g71.a(this.l.o());
            this.l.m(this.e);
            return false;
        } else if (motionEvent.getAction() == 2) {
            if (c(motionEvent)) {
                this.e = VideoPluginGesture.InitChange;
                return false;
            } else if (motionEvent.getPointerId(0) != this.c) {
                return false;
            } else {
                d(this.a - motionEvent.getX(), this.b - motionEvent.getY(), this.a, this.b, this.m, this.n);
                return false;
            }
        } else {
            boolean z = true;
            if (motionEvent.getAction() == 1) {
                this.l.m(this.e);
                z = (this.f && this.g) ? false : false;
                VideoPluginGesture videoPluginGesture = this.e;
                if (videoPluginGesture == VideoPluginGesture.PlayTimeChange) {
                    this.l.l(this.j, this.h);
                } else if (videoPluginGesture == VideoPluginGesture.VolumeChange) {
                    this.l.b();
                }
                this.f = false;
                this.g = false;
                this.e = VideoPluginGesture.InitChange;
                return z;
            } else if (motionEvent.getAction() != 3) {
                return false;
            } else {
                this.l.m(this.e);
                this.f = false;
                this.g = false;
                this.e = VideoPluginGesture.InitChange;
                return false;
            }
        }
    }

    public void d(float f, float f2, float f3, float f4, int i, int i2) {
        if (this.l == null) {
            return;
        }
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f);
        this.g = true;
        if (!this.f) {
            if (e(f3, i)) {
                this.e = VideoPluginGesture.VirtualKeyBoard;
                this.f = true;
                return;
            }
            double d = abs;
            double d2 = abs2;
            if (d > d2 * 1.0d && abs > e81.a(30.0f) && this.d) {
                this.f = true;
                if (f3 <= i / 2) {
                    this.e = VideoPluginGesture.BrightChange;
                    return;
                } else {
                    this.e = VideoPluginGesture.VolumeChange;
                    return;
                }
            } else if (d * 1.0d < d2 && abs2 > e81.a(30.0f)) {
                this.e = VideoPluginGesture.PlayTimeChange;
                this.f = true;
                return;
            } else {
                return;
            }
        }
        VideoPluginGesture videoPluginGesture = this.e;
        if (videoPluginGesture == VideoPluginGesture.PlayTimeChange) {
            this.h = (int) (((-f) / 100.0f) * 15.0f);
            a(f, i);
            this.l.c(this.j, this.h);
            return;
        }
        float f5 = 0.0f;
        if (videoPluginGesture == VideoPluginGesture.VolumeChange) {
            float f6 = this.i + ((f2 / 100.0f) * o);
            if (f6 > 0.0f) {
                if (f6 > i21.b(tj0.b())) {
                    f5 = i21.b(tj0.b());
                } else {
                    f5 = f6;
                }
            }
            this.l.f(f5);
        } else if (videoPluginGesture == VideoPluginGesture.BrightChange) {
            float f7 = this.k + ((f2 / 100.0f) * 25.0f);
            if (f7 > 0.0f) {
                if (f7 > 255.0f) {
                    f5 = 255.0f;
                } else {
                    f5 = f7;
                }
            }
            this.l.i(f5);
        }
    }
}
