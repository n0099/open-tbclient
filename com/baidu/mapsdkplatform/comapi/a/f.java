package com.baidu.mapsdkplatform.comapi.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.baidu.live.tbadk.img.effect.RotateImageAction;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;
/* loaded from: classes6.dex */
public class f extends c {

    /* renamed from: a  reason: collision with root package name */
    private Animator f3006a = null;

    /* renamed from: b  reason: collision with root package name */
    private long f3007b = 0;
    private Interpolator c = null;
    private Animation.AnimationListener d = null;
    private int e = 1;
    private int f = 0;
    private float[] g;

    public f(float... fArr) {
        this.g = fArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(marker, RotateImageAction.ACTION_NAME, this.g);
        if (ofFloat != null) {
            ofFloat.setRepeatCount(this.f);
            ofFloat.setRepeatMode(c());
            ofFloat.setDuration(this.f3007b);
            if (this.c != null) {
                ofFloat.setInterpolator(this.c);
            }
        }
        return ofFloat;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void a() {
        if (this.f3006a == null) {
            return;
        }
        this.f3006a.start();
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
        this.f3007b = j;
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    protected void a(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new g(this));
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
        this.f3006a = a(marker);
        a(this.f3006a);
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    @TargetApi(11)
    public void b() {
        if (this.f3006a != null) {
            this.f3006a.cancel();
            this.f3006a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.a.c
    public void b(int i) {
        if (i > 0) {
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
