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
/* loaded from: classes15.dex */
public class d extends c {

    /* renamed from: a  reason: collision with root package name */
    private Animator f3122a = null;

    /* renamed from: b  reason: collision with root package name */
    private long f3123b = 0;
    private Interpolator c = null;
    private Animation.AnimationListener d = null;
    private int e = 0;
    private ArrayList<Animation> f = new ArrayList<>();

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
        if (this.f3122a == null) {
            return;
        }
        this.f3122a.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.f3123b = j;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    protected void a(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new e(this));
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Interpolator interpolator) {
        this.c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        this.d = animationListener;
    }

    public void a(Animation animation) {
        if (this.f.contains(animation)) {
            return;
        }
        this.f.add(animation);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        ObjectAnimator b2;
        this.f3122a = new AnimatorSet();
        ArrayList<Animation> arrayList = this.f;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                break;
            }
            Animation animation2 = arrayList.get(i2);
            if (animation2 != null && (b2 = b(marker, animation2)) != null) {
                arrayList2.add(b2);
            }
            i = i2 + 1;
        }
        if (this.f3123b != 0) {
            this.f3122a.setDuration(this.f3123b);
        }
        if (this.c != null) {
            this.f3122a.setInterpolator(this.c);
        }
        if (arrayList2.size() != 0) {
            if (this.e == 0) {
                ((AnimatorSet) this.f3122a).playTogether(arrayList2);
            } else if (this.e == 1) {
                ((AnimatorSet) this.f3122a).playSequentially(arrayList2);
            }
        }
        a(this.f3122a);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        if (this.f3122a != null) {
            this.f3122a.cancel();
            this.f3122a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i) {
        this.e = i;
    }
}
