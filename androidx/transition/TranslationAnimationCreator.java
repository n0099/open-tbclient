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

        public TransitionPositionListener(View view, View view2, int i2, int i3, float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, view2, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mMovingView = view;
            this.mViewInHierarchy = view2;
            this.mStartX = i2 - Math.round(view.getTranslationX());
            this.mStartY = i3 - Math.round(this.mMovingView.getTranslationY());
            this.mTerminalX = f2;
            this.mTerminalY = f3;
            int[] iArr = (int[]) this.mViewInHierarchy.getTag(R$id.transition_position);
            this.mTransitionPosition = iArr;
            if (iArr != null) {
                this.mViewInHierarchy.setTag(R$id.transition_position, null);
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
                this.mViewInHierarchy.setTag(R$id.transition_position, this.mTransitionPosition);
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
        public void onTransitionCancel(@NonNull Transition transition) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, transition) == null) {
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
    }

    public TranslationAnimationCreator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Nullable
    public static Animator createAnimation(@NonNull View view, @NonNull TransitionValues transitionValues, int i2, int i3, float f2, float f3, float f4, float f5, @Nullable TimeInterpolator timeInterpolator, @NonNull Transition transition) {
        InterceptResult invokeCommon;
        float f6;
        float f7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{view, transitionValues, Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), timeInterpolator, transition})) == null) {
            float translationX = view.getTranslationX();
            float translationY = view.getTranslationY();
            int[] iArr = (int[]) transitionValues.view.getTag(R$id.transition_position);
            if (iArr != null) {
                f6 = (iArr[0] - i2) + translationX;
                f7 = (iArr[1] - i3) + translationY;
            } else {
                f6 = f2;
                f7 = f3;
            }
            int round = i2 + Math.round(f6 - translationX);
            int round2 = i3 + Math.round(f7 - translationY);
            view.setTranslationX(f6);
            view.setTranslationY(f7);
            if (f6 == f4 && f7 == f5) {
                return null;
            }
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f6, f4), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f7, f5));
            TransitionPositionListener transitionPositionListener = new TransitionPositionListener(view, transitionValues.view, round, round2, translationX, translationY);
            transition.addListener(transitionPositionListener);
            ofPropertyValuesHolder.addListener(transitionPositionListener);
            AnimatorUtils.addPauseListener(ofPropertyValuesHolder, transitionPositionListener);
            ofPropertyValuesHolder.setInterpolator(timeInterpolator);
            return ofPropertyValuesHolder;
        }
        return (Animator) invokeCommon.objValue;
    }
}
