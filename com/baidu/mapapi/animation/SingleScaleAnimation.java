package com.baidu.mapapi.animation;

import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapsdkplatform.comapi.a.j;
/* loaded from: classes6.dex */
public class SingleScaleAnimation extends Animation {

    /* loaded from: classes6.dex */
    public enum ScaleType {
        SCALE_X,
        SCALE_Y
    }

    public SingleScaleAnimation(ScaleType scaleType, float... fArr) {
        if (fArr == null || fArr.length == 0) {
            throw new NullPointerException("the scales is null");
        }
        if (scaleType == ScaleType.SCALE_X) {
            this.bdAnimation = new j(1, fArr);
        } else if (scaleType == ScaleType.SCALE_Y) {
            this.bdAnimation = new j(2, fArr);
        }
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void cancel() {
        this.bdAnimation.b();
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.bdAnimation.a(animationListener);
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setDuration(long j) {
        this.bdAnimation.a(j);
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setInterpolator(Interpolator interpolator) {
        this.bdAnimation.a(interpolator);
    }

    public void setRepeatCount(int i) {
        this.bdAnimation.b(i);
    }

    public void setRepeatMode(Animation.RepeatMode repeatMode) {
        if (repeatMode == Animation.RepeatMode.RESTART) {
            this.bdAnimation.a(1);
        } else if (repeatMode == Animation.RepeatMode.REVERSE) {
            this.bdAnimation.a(2);
        }
    }
}
