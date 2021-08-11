package com.baidu.mobads.container.util.animation;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class BDAnimation {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long DURATION;
    public Animation animation;
    public ObjectAnimator animator;
    public boolean fillAfter;
    public long mDuration;
    public int repeatCount;

    public BDAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.DURATION = 1000L;
        this.mDuration = 1000L;
        this.repeatCount = 0;
        this.fillAfter = true;
    }

    public void alphaAnimation(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
            this.animation = alphaAnimation;
            alphaAnimation.setDuration(this.mDuration);
            this.animation.setRepeatCount(this.repeatCount);
            this.animation.setFillAfter(this.fillAfter);
        }
    }

    public void cancelAnimations() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.animation.cancel();
            this.animation.reset();
        }
    }

    public void rotateAnimation(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, f2, 1, 0.5f, 1, 0.5f);
            this.animation = rotateAnimation;
            rotateAnimation.setDuration(this.mDuration);
            this.animation.setRepeatCount(this.repeatCount);
            this.animation.setFillAfter(this.fillAfter);
        }
    }

    public void scaleAnimation(float f2, float f3, float f4, float f5, float f6, float f7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)}) == null) {
            ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f4, f5, f6, f7);
            this.animation = scaleAnimation;
            scaleAnimation.setDuration(this.mDuration);
            this.animation.setRepeatCount(this.repeatCount);
            this.animation.setFillAfter(false);
            this.animation.setFillEnabled(true);
        }
    }

    public void startAnimations(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            view.startAnimation(this.animation);
        }
    }

    public void translateAnimation(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 0, f2, 1, 0.0f, 0, f3);
            this.animation = translateAnimation;
            translateAnimation.setDuration(this.mDuration);
            this.animation.setRepeatCount(this.repeatCount);
            this.animation.setFillAfter(this.fillAfter);
        }
    }
}
