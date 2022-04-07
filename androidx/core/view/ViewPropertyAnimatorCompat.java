package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class ViewPropertyAnimatorCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int LISTENER_TAG_ID = 2113929216;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable mEndAction;
    public int mOldLayerType;
    public Runnable mStartAction;
    public WeakReference<View> mView;

    /* loaded from: classes.dex */
    public static class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mAnimEndCalled;
        public ViewPropertyAnimatorCompat mVpa;

        public ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewPropertyAnimatorCompat};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mVpa = viewPropertyAnimatorCompat;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Object tag = view2.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationCancel(view2);
                }
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        @SuppressLint({"WrongConstant"})
        public void onAnimationEnd(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                int i = this.mVpa.mOldLayerType;
                if (i > -1) {
                    view2.setLayerType(i, null);
                    this.mVpa.mOldLayerType = -1;
                }
                if (Build.VERSION.SDK_INT >= 16 || !this.mAnimEndCalled) {
                    ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVpa;
                    Runnable runnable = viewPropertyAnimatorCompat.mEndAction;
                    if (runnable != null) {
                        viewPropertyAnimatorCompat.mEndAction = null;
                        runnable.run();
                    }
                    Object tag = view2.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                    ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
                    if (viewPropertyAnimatorListener != null) {
                        viewPropertyAnimatorListener.onAnimationEnd(view2);
                    }
                    this.mAnimEndCalled = true;
                }
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
                this.mAnimEndCalled = false;
                if (this.mVpa.mOldLayerType > -1) {
                    view2.setLayerType(2, null);
                }
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVpa;
                Runnable runnable = viewPropertyAnimatorCompat.mStartAction;
                if (runnable != null) {
                    viewPropertyAnimatorCompat.mStartAction = null;
                    runnable.run();
                }
                Object tag = view2.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationStart(view2);
                }
            }
        }
    }

    public ViewPropertyAnimatorCompat(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mStartAction = null;
        this.mEndAction = null;
        this.mOldLayerType = -1;
        this.mView = new WeakReference<>(view2);
    }

    private void setListenerInternal(View view2, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, view2, viewPropertyAnimatorListener) == null) {
            if (viewPropertyAnimatorListener != null) {
                view2.animate().setListener(new AnimatorListenerAdapter(this, viewPropertyAnimatorListener, view2) { // from class: androidx.core.view.ViewPropertyAnimatorCompat.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ViewPropertyAnimatorCompat this$0;
                    public final /* synthetic */ ViewPropertyAnimatorListener val$listener;
                    public final /* synthetic */ View val$view;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, viewPropertyAnimatorListener, view2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$listener = viewPropertyAnimatorListener;
                        this.val$view = view2;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                            this.val$listener.onAnimationCancel(this.val$view);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                            this.val$listener.onAnimationEnd(this.val$view);
                        }
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                            this.val$listener.onAnimationStart(this.val$view);
                        }
                    }
                });
            } else {
                view2.animate().setListener(null);
            }
        }
    }

    public ViewPropertyAnimatorCompat alpha(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().alpha(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat alphaBy(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().alphaBy(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public void cancel() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (view2 = this.mView.get()) == null) {
            return;
        }
        view2.animate().cancel();
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                return view2.animate().getDuration();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public Interpolator getInterpolator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            View view2 = this.mView.get();
            if (view2 == null || Build.VERSION.SDK_INT < 18) {
                return null;
            }
            return (Interpolator) view2.animate().getInterpolator();
        }
        return (Interpolator) invokeV.objValue;
    }

    public long getStartDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                return view2.animate().getStartDelay();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public ViewPropertyAnimatorCompat rotation(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048582, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().rotation(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat rotationBy(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048583, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().rotationBy(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat rotationX(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().rotationX(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048585, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().rotationXBy(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat rotationY(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048586, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().rotationY(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048587, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().rotationYBy(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat scaleX(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048588, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().scaleX(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048589, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().scaleXBy(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat scaleY(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048590, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().scaleY(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048591, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().scaleYBy(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat setDuration(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().setDuration(j);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeJ.objValue;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, interpolator)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().setInterpolator(interpolator);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeL.objValue;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, viewPropertyAnimatorListener)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    setListenerInternal(view2, viewPropertyAnimatorListener);
                } else {
                    view2.setTag(LISTENER_TAG_ID, viewPropertyAnimatorListener);
                    setListenerInternal(view2, new ViewPropertyAnimatorListenerApi14(this));
                }
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeL.objValue;
    }

    public ViewPropertyAnimatorCompat setStartDelay(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048595, this, j)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().setStartDelay(j);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeJ.objValue;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, viewPropertyAnimatorUpdateListener)) == null) {
            View view2 = this.mView.get();
            if (view2 != null && Build.VERSION.SDK_INT >= 19) {
                view2.animate().setUpdateListener(viewPropertyAnimatorUpdateListener != null ? new ValueAnimator.AnimatorUpdateListener(this, viewPropertyAnimatorUpdateListener, view2) { // from class: androidx.core.view.ViewPropertyAnimatorCompat.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ViewPropertyAnimatorCompat this$0;
                    public final /* synthetic */ ViewPropertyAnimatorUpdateListener val$listener;
                    public final /* synthetic */ View val$view;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, viewPropertyAnimatorUpdateListener, view2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$listener = viewPropertyAnimatorUpdateListener;
                        this.val$view = view2;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                            this.val$listener.onAnimationUpdate(this.val$view);
                        }
                    }
                } : null);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeL.objValue;
    }

    public void start() {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (view2 = this.mView.get()) == null) {
            return;
        }
        view2.animate().start();
    }

    public ViewPropertyAnimatorCompat translationX(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048598, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().translationX(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat translationXBy(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048599, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().translationXBy(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat translationY(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048600, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().translationY(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat translationYBy(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048601, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().translationYBy(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat translationZ(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048602, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null && Build.VERSION.SDK_INT >= 21) {
                view2.animate().translationZ(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat translationZBy(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048603, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null && Build.VERSION.SDK_INT >= 21) {
                view2.animate().translationZBy(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, runnable)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    view2.animate().withEndAction(runnable);
                } else {
                    setListenerInternal(view2, new ViewPropertyAnimatorListenerApi14(this));
                    this.mEndAction = runnable;
                }
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeL.objValue;
    }

    @SuppressLint({"WrongConstant"})
    public ViewPropertyAnimatorCompat withLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    view2.animate().withLayer();
                } else {
                    this.mOldLayerType = view2.getLayerType();
                    setListenerInternal(view2, new ViewPropertyAnimatorListenerApi14(this));
                }
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeV.objValue;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, runnable)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    view2.animate().withStartAction(runnable);
                } else {
                    setListenerInternal(view2, new ViewPropertyAnimatorListenerApi14(this));
                    this.mStartAction = runnable;
                }
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeL.objValue;
    }

    public ViewPropertyAnimatorCompat x(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048607, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().x(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat xBy(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048608, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().xBy(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat y(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048609, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().y(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat yBy(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048610, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null) {
                view2.animate().yBy(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat z(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048611, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null && Build.VERSION.SDK_INT >= 21) {
                view2.animate().z(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat zBy(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048612, this, f)) == null) {
            View view2 = this.mView.get();
            if (view2 != null && Build.VERSION.SDK_INT >= 21) {
                view2.animate().zBy(f);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }
}
