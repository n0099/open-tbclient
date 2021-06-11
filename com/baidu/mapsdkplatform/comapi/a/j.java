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
    public Animator f7539a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f7540b = 0;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f7541c = null;

    /* renamed from: d  reason: collision with root package name */
    public Animation.AnimationListener f7542d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f7543e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f7544f = 0;

    /* renamed from: g  reason: collision with root package name */
    public float[] f7545g;

    /* renamed from: h  reason: collision with root package name */
    public int f7546h;

    public j(int i2, float... fArr) {
        this.f7546h = 1;
        this.f7545g = fArr;
        this.f7546h = i2;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        int i2 = this.f7546h;
        ObjectAnimator ofFloat = i2 == 1 ? ObjectAnimator.ofFloat(marker, "scaleX", this.f7545g) : i2 == 2 ? ObjectAnimator.ofFloat(marker, "scaleY", this.f7545g) : null;
        if (ofFloat != null) {
            ofFloat.setRepeatCount(this.f7544f);
            ofFloat.setRepeatMode(c());
            ofFloat.setDuration(this.f7540b);
            Interpolator interpolator = this.f7541c;
            if (interpolator != null) {
                ofFloat.setInterpolator(interpolator);
            }
        }
        return ofFloat;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a() {
        Animator animator = this.f7539a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i2) {
        this.f7543e = i2;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f7540b = j;
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
        this.f7541c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        this.f7542d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        ObjectAnimator a2 = a(marker);
        this.f7539a = a2;
        a(a2);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        Animator animator = this.f7539a;
        if (animator != null) {
            animator.cancel();
            this.f7539a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i2) {
        if (i2 > 0 || i2 == -1) {
            this.f7544f = i2;
        }
    }

    public int c() {
        return this.f7543e;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i2) {
    }
}
