package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.annotation.AnimRes;
import androidx.annotation.NonNull;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.FragmentTransition;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class FragmentAnim {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @AnimRes
    public static int transitToAnimResourceId(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (i == 4097) {
                return z ? R.anim.obfuscated_res_0x7f010070 : R.anim.obfuscated_res_0x7f010071;
            } else if (i == 4099) {
                return z ? R.anim.obfuscated_res_0x7f01006d : R.anim.obfuscated_res_0x7f01006e;
            } else if (i != 8194) {
                return -1;
            } else {
                return z ? R.anim.obfuscated_res_0x7f01006b : R.anim.obfuscated_res_0x7f01006c;
            }
        }
        return invokeCommon.intValue;
    }

    /* loaded from: classes.dex */
    public static class AnimationOrAnimator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Animation animation;
        public final Animator animator;

        public AnimationOrAnimator(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {animator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.animation = null;
            this.animator = animator;
            if (animator != null) {
                return;
            }
            throw new IllegalStateException("Animator cannot be null");
        }

        public AnimationOrAnimator(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {animation};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.animation = animation;
            this.animator = null;
            if (animation != null) {
                return;
            }
            throw new IllegalStateException("Animation cannot be null");
        }
    }

    /* loaded from: classes.dex */
    public static class EndViewTransitionAnimation extends AnimationSet implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mAnimating;
        public final View mChild;
        public boolean mEnded;
        public final ViewGroup mParent;
        public boolean mTransitionEnded;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EndViewTransitionAnimation(@NonNull Animation animation, @NonNull ViewGroup viewGroup, @NonNull View view2) {
            super(false);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {animation, viewGroup, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mAnimating = true;
            this.mParent = viewGroup;
            this.mChild = view2;
            addAnimation(animation);
            this.mParent.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, @NonNull Transformation transformation) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, transformation)) == null) {
                this.mAnimating = true;
                if (this.mEnded) {
                    return !this.mTransitionEnded;
                }
                if (!super.getTransformation(j, transformation)) {
                    this.mEnded = true;
                    OneShotPreDrawListener.add(this.mParent, this);
                }
                return true;
            }
            return invokeJL.booleanValue;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, @NonNull Transformation transformation, float f) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), transformation, Float.valueOf(f)})) == null) {
                this.mAnimating = true;
                if (this.mEnded) {
                    return !this.mTransitionEnded;
                }
                if (!super.getTransformation(j, transformation, f)) {
                    this.mEnded = true;
                    OneShotPreDrawListener.add(this.mParent, this);
                }
                return true;
            }
            return invokeCommon.booleanValue;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (!this.mEnded && this.mAnimating) {
                    this.mAnimating = false;
                    this.mParent.post(this);
                    return;
                }
                this.mParent.endViewTransition(this.mChild);
                this.mTransitionEnded = true;
            }
        }
    }

    public FragmentAnim() {
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

    public static void animateRemoveFragment(@NonNull Fragment fragment, @NonNull AnimationOrAnimator animationOrAnimator, @NonNull FragmentTransition.Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, fragment, animationOrAnimator, callback) == null) {
            View view2 = fragment.mView;
            ViewGroup viewGroup = fragment.mContainer;
            viewGroup.startViewTransition(view2);
            CancellationSignal cancellationSignal = new CancellationSignal();
            cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener(fragment) { // from class: androidx.fragment.app.FragmentAnim.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Fragment val$fragment;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {fragment};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$fragment = fragment;
                }

                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                public void onCancel() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        if (this.val$fragment.getAnimatingAway() != null) {
                            View animatingAway = this.val$fragment.getAnimatingAway();
                            this.val$fragment.setAnimatingAway(null);
                            animatingAway.clearAnimation();
                        }
                        this.val$fragment.setAnimator(null);
                    }
                }
            });
            callback.onStart(fragment, cancellationSignal);
            if (animationOrAnimator.animation != null) {
                EndViewTransitionAnimation endViewTransitionAnimation = new EndViewTransitionAnimation(animationOrAnimator.animation, viewGroup, view2);
                fragment.setAnimatingAway(fragment.mView);
                endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener(viewGroup, fragment, callback, cancellationSignal) { // from class: androidx.fragment.app.FragmentAnim.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ FragmentTransition.Callback val$callback;
                    public final /* synthetic */ ViewGroup val$container;
                    public final /* synthetic */ Fragment val$fragment;
                    public final /* synthetic */ CancellationSignal val$signal;

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                        }
                    }

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {viewGroup, fragment, callback, cancellationSignal};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$container = viewGroup;
                        this.val$fragment = fragment;
                        this.val$callback = callback;
                        this.val$signal = cancellationSignal;
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) {
                            this.val$container.post(new Runnable(this) { // from class: androidx.fragment.app.FragmentAnim.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 this$0;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$0 = this;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if ((interceptable3 == null || interceptable3.invokeV(1048576, this) == null) && this.this$0.val$fragment.getAnimatingAway() != null) {
                                        this.this$0.val$fragment.setAnimatingAway(null);
                                        AnonymousClass2 anonymousClass2 = this.this$0;
                                        anonymousClass2.val$callback.onComplete(anonymousClass2.val$fragment, anonymousClass2.val$signal);
                                    }
                                }
                            });
                        }
                    }
                });
                fragment.mView.startAnimation(endViewTransitionAnimation);
                return;
            }
            Animator animator = animationOrAnimator.animator;
            fragment.setAnimator(animator);
            animator.addListener(new AnimatorListenerAdapter(viewGroup, view2, fragment, callback, cancellationSignal) { // from class: androidx.fragment.app.FragmentAnim.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ FragmentTransition.Callback val$callback;
                public final /* synthetic */ ViewGroup val$container;
                public final /* synthetic */ Fragment val$fragment;
                public final /* synthetic */ CancellationSignal val$signal;
                public final /* synthetic */ View val$viewToAnimate;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {viewGroup, view2, fragment, callback, cancellationSignal};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$container = viewGroup;
                    this.val$viewToAnimate = view2;
                    this.val$fragment = fragment;
                    this.val$callback = callback;
                    this.val$signal = cancellationSignal;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator2) == null) {
                        this.val$container.endViewTransition(this.val$viewToAnimate);
                        Animator animator3 = this.val$fragment.getAnimator();
                        this.val$fragment.setAnimator(null);
                        if (animator3 != null && this.val$container.indexOfChild(this.val$viewToAnimate) < 0) {
                            this.val$callback.onComplete(this.val$fragment, this.val$signal);
                        }
                    }
                }
            });
            animator.setTarget(fragment.mView);
            animator.start();
        }
    }

    public static AnimationOrAnimator loadAnimation(@NonNull Context context, @NonNull FragmentContainer fragmentContainer, @NonNull Fragment fragment, boolean z) {
        InterceptResult invokeCommon;
        int transitToAnimResourceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, fragmentContainer, fragment, Boolean.valueOf(z)})) == null) {
            int nextTransition = fragment.getNextTransition();
            int nextAnim = fragment.getNextAnim();
            boolean z2 = false;
            fragment.setNextAnim(0);
            View onFindViewById = fragmentContainer.onFindViewById(fragment.mContainerId);
            if (onFindViewById != null && onFindViewById.getTag(R.id.obfuscated_res_0x7f092765) != null) {
                onFindViewById.setTag(R.id.obfuscated_res_0x7f092765, null);
            }
            ViewGroup viewGroup = fragment.mContainer;
            if (viewGroup != null && viewGroup.getLayoutTransition() != null) {
                return null;
            }
            Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z, nextAnim);
            if (onCreateAnimation != null) {
                return new AnimationOrAnimator(onCreateAnimation);
            }
            Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z, nextAnim);
            if (onCreateAnimator != null) {
                return new AnimationOrAnimator(onCreateAnimator);
            }
            if (nextAnim != 0) {
                boolean equals = "anim".equals(context.getResources().getResourceTypeName(nextAnim));
                if (equals) {
                    try {
                        Animation loadAnimation = AnimationUtils.loadAnimation(context, nextAnim);
                        if (loadAnimation != null) {
                            return new AnimationOrAnimator(loadAnimation);
                        }
                        z2 = true;
                    } catch (Resources.NotFoundException e) {
                        throw e;
                    } catch (RuntimeException unused) {
                    }
                }
                if (!z2) {
                    try {
                        Animator loadAnimator = AnimatorInflater.loadAnimator(context, nextAnim);
                        if (loadAnimator != null) {
                            return new AnimationOrAnimator(loadAnimator);
                        }
                    } catch (RuntimeException e2) {
                        if (!equals) {
                            Animation loadAnimation2 = AnimationUtils.loadAnimation(context, nextAnim);
                            if (loadAnimation2 != null) {
                                return new AnimationOrAnimator(loadAnimation2);
                            }
                        } else {
                            throw e2;
                        }
                    }
                }
            }
            if (nextTransition == 0 || (transitToAnimResourceId = transitToAnimResourceId(nextTransition, z)) < 0) {
                return null;
            }
            return new AnimationOrAnimator(AnimationUtils.loadAnimation(context, transitToAnimResourceId));
        }
        return (AnimationOrAnimator) invokeCommon.objValue;
    }
}
