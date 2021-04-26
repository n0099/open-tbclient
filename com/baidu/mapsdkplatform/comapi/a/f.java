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
    public Animator f7793a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f7794b = 0;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f7795c = null;

    /* renamed from: d  reason: collision with root package name */
    public Animation.AnimationListener f7796d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f7797e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f7798f = 0;

    /* renamed from: g  reason: collision with root package name */
    public float[] f7799g;

    public f(float... fArr) {
        this.f7799g = fArr;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(marker, "rotate", this.f7799g);
        if (ofFloat != null) {
            ofFloat.setRepeatCount(this.f7798f);
            ofFloat.setRepeatMode(c());
            ofFloat.setDuration(this.f7794b);
            Interpolator interpolator = this.f7795c;
            if (interpolator != null) {
                ofFloat.setInterpolator(interpolator);
            }
        }
        return ofFloat;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a() {
        Animator animator = this.f7793a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i2) {
        this.f7797e = i2;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f7794b = j;
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
        this.f7795c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        this.f7796d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        ObjectAnimator a2 = a(marker);
        this.f7793a = a2;
        a(a2);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        Animator animator = this.f7793a;
        if (animator != null) {
            animator.cancel();
            this.f7793a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i2) {
        if (i2 > 0) {
            this.f7798f = i2;
        }
    }

    public int c() {
        return this.f7797e;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i2) {
    }
}
