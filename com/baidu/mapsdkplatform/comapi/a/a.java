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
    public Animator f7511a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f7512b = 0;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f7513c = null;

    /* renamed from: d  reason: collision with root package name */
    public Animation.AnimationListener f7514d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f7515e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f7516f = 0;

    /* renamed from: g  reason: collision with root package name */
    public float[] f7517g;

    public a(float... fArr) {
        this.f7517g = fArr;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(marker, "alpha", this.f7517g);
        if (ofFloat != null) {
            ofFloat.setRepeatCount(this.f7516f);
            ofFloat.setRepeatMode(c());
            ofFloat.setDuration(this.f7512b);
            Interpolator interpolator = this.f7513c;
            if (interpolator != null) {
                ofFloat.setInterpolator(interpolator);
            }
        }
        return ofFloat;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a() {
        Animator animator = this.f7511a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i) {
        this.f7515e = i;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f7512b = j;
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
        this.f7513c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        this.f7514d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        ObjectAnimator a2 = a(marker);
        this.f7511a = a2;
        a(a2);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        Animator animator = this.f7511a;
        if (animator != null) {
            animator.cancel();
            this.f7511a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i) {
        if (i > 0) {
            this.f7516f = i;
        }
    }

    public int c() {
        return this.f7515e;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i) {
    }
}
