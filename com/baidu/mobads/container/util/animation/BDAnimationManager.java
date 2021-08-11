package com.baidu.mobads.container.util.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AnimationSet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class BDAnimationManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "BDAnimationManager";
    public transient /* synthetic */ FieldHolder $fh;
    public long DURATION;
    public AnimationSet animationSet;
    public AnimatorSet animatorSet;
    public boolean fillAfter;
    public List<BDAnimation> mAnimations;
    public long mDuration;
    public int repeatCount;
    public int repeatMode;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1361204695, "Lcom/baidu/mobads/container/util/animation/BDAnimationManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1361204695, "Lcom/baidu/mobads/container/util/animation/BDAnimationManager;");
        }
    }

    public BDAnimationManager(List<BDAnimation> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.DURATION = 1000L;
        this.mDuration = 1000L;
        this.repeatCount = 0;
        this.repeatMode = 2;
        this.fillAfter = true;
        this.mAnimations = list;
    }

    public void cancelAnimations() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.animationSet.cancel();
            this.animationSet.reset();
        }
    }

    public void startAnimations(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
            try {
                this.animationSet = new AnimationSet(true);
                for (int i2 = 0; i2 < this.mAnimations.size(); i2++) {
                    this.animationSet.addAnimation(this.mAnimations.get(i2).animation);
                }
                view.startAnimation(this.animationSet);
            } catch (Throwable unused) {
            }
        }
    }

    public void startAnimators() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                this.animatorSet = new AnimatorSet();
                ObjectAnimator objectAnimator = null;
                for (int i2 = 0; i2 < this.mAnimations.size(); i2++) {
                    BDAnimation bDAnimation = this.mAnimations.get(i2);
                    if (i2 == 0) {
                        this.animatorSet.play(bDAnimation.animator);
                    } else {
                        this.animatorSet.play(bDAnimation.animator).with(objectAnimator);
                    }
                    objectAnimator = bDAnimation.animator;
                }
                this.animatorSet.start();
            } catch (Throwable unused) {
            }
        }
    }
}
