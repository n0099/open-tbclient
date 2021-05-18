package com.baidu.mapapi.animation;

import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapsdkplatform.comapi.a.c;
import com.baidu.mapsdkplatform.comapi.a.h;
/* loaded from: classes2.dex */
public class ScaleAnimation extends Animation {
    public ScaleAnimation(float... fArr) {
        if (fArr == null || fArr.length == 0) {
            throw new NullPointerException("BDMapSDKException: the scales is null");
        }
        this.bdAnimation = new h(fArr);
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
