package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.AlphaAnimation;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.animation.RotateAnimation;
import com.baidu.mapapi.animation.ScaleAnimation;
import com.baidu.mapapi.animation.SingleScaleAnimation;
import com.baidu.mapapi.animation.Transformation;
import com.baidu.mapapi.map.Marker;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class d extends c {

    /* renamed from: a  reason: collision with root package name */
    public Animator f7484a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f7485b = 0;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f7486c = null;

    /* renamed from: d  reason: collision with root package name */
    public Animation.AnimationListener f7487d = null;

    /* renamed from: e  reason: collision with root package name */
    public int f7488e = 0;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Animation> f7489f = new ArrayList<>();

    @TargetApi(11)
    private ObjectAnimator b(Marker marker, Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return ((a) animation.bdAnimation).a(marker);
        }
        if (animation instanceof RotateAnimation) {
            return ((f) animation.bdAnimation).a(marker);
        }
        if (animation instanceof Transformation) {
            return ((l) animation.bdAnimation).a(marker);
        }
        if (animation instanceof ScaleAnimation) {
            return ((h) animation.bdAnimation).a(marker);
        }
        if (animation instanceof SingleScaleAnimation) {
            return ((j) animation.bdAnimation).a(marker);
        }
        return null;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a() {
        Animator animator = this.f7484a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f7485b = j;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new e(this));
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Interpolator interpolator) {
        this.f7486c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        this.f7487d = animationListener;
    }

    public void a(Animation animation) {
        if (this.f7489f.contains(animation)) {
            return;
        }
        this.f7489f.add(animation);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        ObjectAnimator b2;
        this.f7484a = new AnimatorSet();
        ArrayList<Animation> arrayList = this.f7489f;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.clear();
        for (int i = 0; i < arrayList.size(); i++) {
            Animation animation2 = arrayList.get(i);
            if (animation2 != null && (b2 = b(marker, animation2)) != null) {
                arrayList2.add(b2);
            }
        }
        long j = this.f7485b;
        if (j != 0) {
            this.f7484a.setDuration(j);
        }
        Interpolator interpolator = this.f7486c;
        if (interpolator != null) {
            this.f7484a.setInterpolator(interpolator);
        }
        if (arrayList2.size() != 0) {
            int i2 = this.f7488e;
            if (i2 == 0) {
                ((AnimatorSet) this.f7484a).playTogether(arrayList2);
            } else if (i2 == 1) {
                ((AnimatorSet) this.f7484a).playSequentially(arrayList2);
            }
        }
        a(this.f7484a);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        Animator animator = this.f7484a;
        if (animator != null) {
            animator.cancel();
            this.f7484a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i) {
        this.f7488e = i;
    }
}
