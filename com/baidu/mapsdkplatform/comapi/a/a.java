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
    public Animator f7778a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f7779b = 0;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f7780c = null;

    /* renamed from: d  reason: collision with root package name */
    public Animation.AnimationListener f7781d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f7782e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f7783f = 0;

    /* renamed from: g  reason: collision with root package name */
    public float[] f7784g;

    public a(float... fArr) {
        this.f7784g = fArr;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(marker, "alpha", this.f7784g);
        if (ofFloat != null) {
            ofFloat.setRepeatCount(this.f7783f);
            ofFloat.setRepeatMode(c());
            ofFloat.setDuration(this.f7779b);
            Interpolator interpolator = this.f7780c;
            if (interpolator != null) {
                ofFloat.setInterpolator(interpolator);
            }
        }
        return ofFloat;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a() {
        Animator animator = this.f7778a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i2) {
        this.f7782e = i2;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f7779b = j;
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
        this.f7780c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        this.f7781d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        ObjectAnimator a2 = a(marker);
        this.f7778a = a2;
        a(a2);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        Animator animator = this.f7778a;
        if (animator != null) {
            animator.cancel();
            this.f7778a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i2) {
        if (i2 > 0) {
            this.f7783f = i2;
        }
    }

    public int c() {
        return this.f7782e;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i2) {
    }
}
