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
    public Animator f7475a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f7476b = 0;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f7477c = null;

    /* renamed from: d  reason: collision with root package name */
    public Animation.AnimationListener f7478d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f7479e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f7480f = 0;

    /* renamed from: g  reason: collision with root package name */
    public float[] f7481g;

    public a(float... fArr) {
        this.f7481g = fArr;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(marker, "alpha", this.f7481g);
        if (ofFloat != null) {
            ofFloat.setRepeatCount(this.f7480f);
            ofFloat.setRepeatMode(c());
            ofFloat.setDuration(this.f7476b);
            Interpolator interpolator = this.f7477c;
            if (interpolator != null) {
                ofFloat.setInterpolator(interpolator);
            }
        }
        return ofFloat;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a() {
        Animator animator = this.f7475a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i) {
        this.f7479e = i;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f7476b = j;
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
        this.f7477c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        this.f7478d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        ObjectAnimator a2 = a(marker);
        this.f7475a = a2;
        a(a2);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        Animator animator = this.f7475a;
        if (animator != null) {
            animator.cancel();
            this.f7475a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i) {
        if (i > 0) {
            this.f7480f = i;
        }
    }

    public int c() {
        return this.f7479e;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i) {
    }
}
