package com.baidu.mapapi.animation;

import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapsdkplatform.comapi.a.c;
import com.baidu.mapsdkplatform.comapi.a.j;
/* loaded from: classes2.dex */
public class SingleScaleAnimation extends Animation {

    /* loaded from: classes2.dex */
    public enum ScaleType {
        SCALE_X,
        SCALE_Y
    }

    public SingleScaleAnimation(ScaleType scaleType, float... fArr) {
        j jVar;
        if (fArr == null || fArr.length == 0) {
            throw new NullPointerException("the scales is null");
        }
        if (scaleType == ScaleType.SCALE_X) {
            jVar = new j(1, fArr);
        } else if (scaleType != ScaleType.SCALE_Y) {
            return;
        } else {
            jVar = new j(2, fArr);
        }
        this.bdAnimation = jVar;
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

    public void setRepeatCount(int i2) {
        this.bdAnimation.b(i2);
    }

    public void setRepeatMode(Animation.RepeatMode repeatMode) {
        c cVar;
        int i2;
        if (repeatMode == Animation.RepeatMode.RESTART) {
            cVar = this.bdAnimation;
            i2 = 1;
        } else if (repeatMode != Animation.RepeatMode.REVERSE) {
            return;
        } else {
            cVar = this.bdAnimation;
            i2 = 2;
        }
        cVar.a(i2);
    }
}
