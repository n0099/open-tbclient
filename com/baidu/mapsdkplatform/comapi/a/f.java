package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;
/* loaded from: classes2.dex */
public class f extends c {

    /* renamed from: a  reason: collision with root package name */
    public Animator f7491a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f7492b = 0;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f7493c = null;

    /* renamed from: d  reason: collision with root package name */
    public Animation.AnimationListener f7494d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f7495e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f7496f = 0;

    /* renamed from: g  reason: collision with root package name */
    public float[] f7497g;

    public f(float... fArr) {
        this.f7497g = fArr;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(marker, "rotate", this.f7497g);
        if (ofFloat != null) {
            ofFloat.setRepeatCount(this.f7496f);
            ofFloat.setRepeatMode(c());
            ofFloat.setDuration(this.f7492b);
            Interpolator interpolator = this.f7493c;
            if (interpolator != null) {
                ofFloat.setInterpolator(interpolator);
            }
        }
        return ofFloat;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a() {
        Animator animator = this.f7491a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i) {
        this.f7495e = i;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f7492b = j;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new g(this));
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Interpolator interpolator) {
        this.f7493c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        this.f7494d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        ObjectAnimator a2 = a(marker);
        this.f7491a = a2;
        a(a2);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        Animator animator = this.f7491a;
        if (animator != null) {
            animator.cancel();
            this.f7491a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i) {
        if (i > 0) {
            this.f7496f = i;
        }
    }

    public int c() {
        return this.f7495e;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i) {
    }
}
