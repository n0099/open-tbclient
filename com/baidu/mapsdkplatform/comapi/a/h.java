package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;
/* loaded from: classes2.dex */
public class h extends c {

    /* renamed from: a  reason: collision with root package name */
    public Animator f7801a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f7802b = 0;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f7803c = null;

    /* renamed from: d  reason: collision with root package name */
    public Animation.AnimationListener f7804d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f7805e = 1;

    /* renamed from: f  reason: collision with root package name */
    public int f7806f = 0;

    /* renamed from: g  reason: collision with root package name */
    public float[] f7807g;

    public h(float... fArr) {
        this.f7807g = fArr;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(marker, "scale", this.f7807g);
        if (ofFloat != null) {
            ofFloat.setRepeatCount(this.f7806f);
            ofFloat.setRepeatMode(c());
            ofFloat.setDuration(this.f7802b);
            Interpolator interpolator = this.f7803c;
            if (interpolator != null) {
                ofFloat.setInterpolator(interpolator);
            }
        }
        return ofFloat;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a() {
        Animator animator = this.f7801a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i2) {
        this.f7805e = i2;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f7802b = j;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new i(this));
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Interpolator interpolator) {
        this.f7803c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        this.f7804d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        ObjectAnimator a2 = a(marker);
        this.f7801a = a2;
        a(a2);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        Animator animator = this.f7801a;
        if (animator != null) {
            animator.cancel();
            this.f7801a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i2) {
        if (i2 > 0) {
            this.f7806f = i2;
        }
    }

    public int c() {
        return this.f7805e;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i2) {
    }
}
