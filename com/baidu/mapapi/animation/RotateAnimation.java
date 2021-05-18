package com.baidu.mapapi.animation;

import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapsdkplatform.comapi.a.c;
import com.baidu.mapsdkplatform.comapi.a.f;
/* loaded from: classes2.dex */
public class RotateAnimation extends Animation {
    public RotateAnimation(float f2, float f3) {
        if (f2 < 0.0f || f3 < 0.0f) {
            throw new NullPointerException("BDMapSDKException: the degrees can't less than zero");
        }
        this.bdAnimation = new f(f2, f3);
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
