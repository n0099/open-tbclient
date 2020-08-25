package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;
/* loaded from: classes20.dex */
public class j extends c {
    private Animator a = null;
    private long b = 0;
    private Interpolator c = null;
    private Animation.AnimationListener d = null;
    private int e = 1;
    private int f = 0;
    private float[] g;
    private int h;

    public j(int i, float... fArr) {
        this.h = 1;
        this.g = fArr;
        this.h = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        ObjectAnimator objectAnimator = null;
        if (this.h == 1) {
            objectAnimator = ObjectAnimator.ofFloat(marker, "scaleX", this.g);
        } else if (this.h == 2) {
            objectAnimator = ObjectAnimator.ofFloat(marker, "scaleY", this.g);
        }
        if (objectAnimator != null) {
            objectAnimator.setRepeatCount(this.f);
            objectAnimator.setRepeatMode(c());
            objectAnimator.setDuration(this.b);
            if (this.c != null) {
                objectAnimator.setInterpolator(this.c);
            }
        }
        return objectAnimator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a() {
        if (this.a == null) {
            return;
        }
        this.a.start();
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(int i) {
        this.e = i;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(long j) {
        if (j < 0) {
            j = 0;
        }
        this.b = j;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    protected void a(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new k(this));
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Interpolator interpolator) {
        this.c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void a(Animation.AnimationListener animationListener) {
        this.d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a(Marker marker, Animation animation) {
        this.a = a(marker);
        a(this.a);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        if (this.a != null) {
            this.a.cancel();
            this.a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i) {
        if (i > 0 || i == -1) {
            this.f = i;
        }
    }

    public int c() {
        return this.e;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void c(int i) {
    }
}
