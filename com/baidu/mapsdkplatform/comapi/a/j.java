package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;
/* loaded from: classes2.dex */
public class j extends c {

    /* renamed from: a  reason: collision with root package name */
    public Animator f7542a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f7543b = 0;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f7544c = null;

    /* renamed from: d  reason: collision with root package name */
    public Animation.AnimationListener f7545d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f7546e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f7547f = 0;

    /* renamed from: g  reason: collision with root package name */
    public float[] f7548g;

    /* renamed from: h  reason: collision with root package name */
    public int f7549h;

    public j(int i, float... fArr) {
        this.f7549h = 1;
        this.f7548g = fArr;
        this.f7549h = i;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        int i = this.f7549h;
        ObjectAnimator ofFloat = i == 1 ? ObjectAnimator.ofFloat(marker, "scaleX", this.f7548g) : i == 2 ? ObjectAnimator.ofFloat(marker, "scaleY", this.f7548g) : null;
        if (ofFloat != null) {
            ofFloat.setRepeatCount(this.f7547f);
            ofFloat.setRepeatMode(c());
            ofFloat.setDuration(this.f7543b);
            Interpolator interpolator = this.f7544c;
            if (interpolator != null) {
                ofFloat.setInterpolator(interpolator);
            }
        }
        return ofFloat;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a() {
        Animator animator = this.f7542a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i) {
        this.f7546e = i;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f7543b = j;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new k(this));
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Interpolator interpolator) {
        this.f7544c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        this.f7545d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        ObjectAnimator a2 = a(marker);
        this.f7542a = a2;
        a(a2);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        Animator animator = this.f7542a;
        if (animator != null) {
            animator.cancel();
            this.f7542a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i) {
        if (i > 0) {
            this.f7547f = i;
        }
    }

    public int c() {
        return this.f7546e;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i) {
    }
}
