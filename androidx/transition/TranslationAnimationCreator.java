package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Transition;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class TranslationAnimationCreator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class TransitionPositionListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final View mMovingView;
        public float mPausedX;
        public float mPausedY;
        public final int mStartX;
        public final int mStartY;
        public final float mTerminalX;
        public final float mTerminalY;
        public int[] mTransitionPosition;
        public final View mViewInHierarchy;

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, transition) == null) {
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, transition) == null) {
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, transition) == null) {
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, transition) == null) {
            }
        }

        public TransitionPositionListener(View view2, View view3, int i, int i2, float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, view3, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mMovingView = view2;
            this.mViewInHierarchy = view3;
            this.mStartX = i - Math.round(view2.getTranslationX());
            this.mStartY = i2 - Math.round(this.mMovingView.getTranslationY());
            this.mTerminalX = f;
            this.mTerminalY = f2;
            int[] iArr = (int[]) this.mViewInHierarchy.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f092378);
            this.mTransitionPosition = iArr;
            if (iArr != null) {
                this.mViewInHierarchy.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f092378, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                if (this.mTransitionPosition == null) {
                    this.mTransitionPosition = new int[2];
                }
                this.mTransitionPosition[0] = Math.round(this.mStartX + this.mMovingView.getTranslationX());
                this.mTransitionPosition[1] = Math.round(this.mStartY + this.mMovingView.getTranslationY());
                this.mViewInHierarchy.setTag(com.baidu.tieba.R.id.obfuscated_res_0x7f092378, this.mTransitionPosition);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.mPausedX = this.mMovingView.getTranslationX();
                this.mPausedY = this.mMovingView.getTranslationY();
                this.mMovingView.setTranslationX(this.mTerminalX);
                this.mMovingView.setTranslationY(this.mTerminalY);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                this.mMovingView.setTranslationX(this.mPausedX);
                this.mMovingView.setTranslationY(this.mPausedY);
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, transition) == null) {
                this.mMovingView.setTranslationX(this.mTerminalX);
                this.mMovingView.setTranslationY(this.mTerminalY);
                transition.removeListener(this);
            }
        }
    }

    public TranslationAnimationCreator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Nullable
    public static Animator createAnimation(@NonNull View view2, @NonNull TransitionValues transitionValues, int i, int i2, float f, float f2, float f3, float f4, @Nullable TimeInterpolator timeInterpolator, @NonNull Transition transition) {
        InterceptResult invokeCommon;
        float f5;
        float f6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{view2, transitionValues, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), timeInterpolator, transition})) == null) {
            float translationX = view2.getTranslationX();
            float translationY = view2.getTranslationY();
            int[] iArr = (int[]) transitionValues.f1028view.getTag(com.baidu.tieba.R.id.obfuscated_res_0x7f092378);
            if (iArr != null) {
                f5 = (iArr[0] - i) + translationX;
                f6 = (iArr[1] - i2) + translationY;
            } else {
                f5 = f;
                f6 = f2;
            }
            int round = i + Math.round(f5 - translationX);
            int round2 = i2 + Math.round(f6 - translationY);
            view2.setTranslationX(f5);
            view2.setTranslationY(f6);
            if (f5 == f3 && f6 == f4) {
                return null;
            }
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view2, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f5, f3), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f6, f4));
            TransitionPositionListener transitionPositionListener = new TransitionPositionListener(view2, transitionValues.f1028view, round, round2, translationX, translationY);
            transition.addListener(transitionPositionListener);
            ofPropertyValuesHolder.addListener(transitionPositionListener);
            AnimatorUtils.addPauseListener(ofPropertyValuesHolder, transitionPositionListener);
            ofPropertyValuesHolder.setInterpolator(timeInterpolator);
            return ofPropertyValuesHolder;
        }
        return (Animator) invokeCommon.objValue;
    }
}
