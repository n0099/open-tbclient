package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;
/* loaded from: classes2.dex */
public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    public Animator f7508a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f7509b = 0;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f7510c = null;

    /* renamed from: d  reason: collision with root package name */
    public Animation.AnimationListener f7511d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f7512e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f7513f = 0;

    /* renamed from: g  reason: collision with root package name */
    public float[] f7514g;

    public a(float... fArr) {
        this.f7514g = fArr;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(marker, "alpha", this.f7514g);
        if (ofFloat != null) {
            ofFloat.setRepeatCount(this.f7513f);
            ofFloat.setRepeatMode(c());
            ofFloat.setDuration(this.f7509b);
            Interpolator interpolator = this.f7510c;
            if (interpolator != null) {
                ofFloat.setInterpolator(interpolator);
            }
        }
        return ofFloat;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a() {
        Animator animator = this.f7508a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i2) {
        this.f7512e = i2;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f7509b = j;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new b(this));
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Interpolator interpolator) {
        this.f7510c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        this.f7511d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        ObjectAnimator a2 = a(marker);
        this.f7508a = a2;
        a(a2);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        Animator animator = this.f7508a;
        if (animator != null) {
            animator.cancel();
            this.f7508a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i2) {
        if (i2 > 0 || i2 == -1) {
            this.f7513f = i2;
        }
    }

    public int c() {
        return this.f7512e;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i2) {
    }
}
