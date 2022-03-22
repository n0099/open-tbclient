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
        public void onAnimationCancel(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationCancel(view);
                }
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        @SuppressLint({"WrongConstant"})
        public void onAnimationEnd(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) {
                int i = this.mVpa.mOldLayerType;
                if (i > -1) {
                    view.setLayerType(i, null);
                    this.mVpa.mOldLayerType = -1;
                }
                if (Build.VERSION.SDK_INT >= 16 || !this.mAnimEndCalled) {
                    ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVpa;
                    Runnable runnable = viewPropertyAnimatorCompat.mEndAction;
                    if (runnable != null) {
                        viewPropertyAnimatorCompat.mEndAction = null;
                        runnable.run();
                    }
                    Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                    ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
                    if (viewPropertyAnimatorListener != null) {
                        viewPropertyAnimatorListener.onAnimationEnd(view);
                    }
                    this.mAnimEndCalled = true;
                }
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
                this.mAnimEndCalled = false;
                if (this.mVpa.mOldLayerType > -1) {
                    view.setLayerType(2, null);
                }
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVpa;
                Runnable runnable = viewPropertyAnimatorCompat.mStartAction;
                if (runnable != null) {
                    viewPropertyAnimatorCompat.mStartAction = null;
                    runnable.run();
                }
                Object tag = view.getTag(ViewPropertyAnimatorCompat.LISTENER_TAG_ID);
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = tag instanceof ViewPropertyAnimatorListener ? (ViewPropertyAnimatorListener) tag : null;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationStart(view);
                }
            }
        }
    }

    public ViewPropertyAnimatorCompat(View view) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view};
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
        this.mView = new WeakReference<>(view);
    }

    private void setListenerInternal(View view, ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, view, viewPropertyAnimatorListener) == null) {
            if (viewPropertyAnimatorListener != null) {
                view.animate().setListener(new AnimatorListenerAdapter(this, viewPropertyAnimatorListener, view) { // from class: androidx.core.view.ViewPropertyAnimatorCompat.1
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
                            Object[] objArr = {this, viewPropertyAnimatorListener, view};
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
                        this.val$view = view;
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
                view.animate().setListener(null);
            }
        }
    }

    public ViewPropertyAnimatorCompat alpha(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().alpha(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat alphaBy(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().alphaBy(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public void cancel() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (view = this.mView.get()) == null) {
            return;
        }
        view.animate().cancel();
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            View view = this.mView.get();
            if (view != null) {
                return view.animate().getDuration();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public Interpolator getInterpolator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            View view = this.mView.get();
            if (view == null || Build.VERSION.SDK_INT < 18) {
                return null;
            }
            return (Interpolator) view.animate().getInterpolator();
        }
        return (Interpolator) invokeV.objValue;
    }

    public long getStartDelay() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            View view = this.mView.get();
            if (view != null) {
                return view.animate().getStartDelay();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public ViewPropertyAnimatorCompat rotation(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048582, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().rotation(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat rotationBy(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048583, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().rotationBy(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat rotationX(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().rotationX(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048585, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().rotationXBy(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat rotationY(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048586, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().rotationY(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048587, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().rotationYBy(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat scaleX(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048588, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().scaleX(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048589, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().scaleXBy(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat scaleY(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048590, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().scaleY(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048591, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().scaleYBy(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat setDuration(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048592, this, j)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().setDuration(j);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeJ.objValue;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, interpolator)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().setInterpolator(interpolator);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeL.objValue;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, viewPropertyAnimatorListener)) == null) {
            View view = this.mView.get();
            if (view != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    setListenerInternal(view, viewPropertyAnimatorListener);
                } else {
                    view.setTag(LISTENER_TAG_ID, viewPropertyAnimatorListener);
                    setListenerInternal(view, new ViewPropertyAnimatorListenerApi14(this));
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
            View view = this.mView.get();
            if (view != null) {
                view.animate().setStartDelay(j);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeJ.objValue;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, viewPropertyAnimatorUpdateListener)) == null) {
            View view = this.mView.get();
            if (view != null && Build.VERSION.SDK_INT >= 19) {
                view.animate().setUpdateListener(viewPropertyAnimatorUpdateListener != null ? new ValueAnimator.AnimatorUpdateListener(this, viewPropertyAnimatorUpdateListener, view) { // from class: androidx.core.view.ViewPropertyAnimatorCompat.2
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
                            Object[] objArr = {this, viewPropertyAnimatorUpdateListener, view};
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
                        this.val$view = view;
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
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (view = this.mView.get()) == null) {
            return;
        }
        view.animate().start();
    }

    public ViewPropertyAnimatorCompat translationX(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048598, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().translationX(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat translationXBy(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048599, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().translationXBy(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat translationY(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048600, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().translationY(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat translationYBy(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048601, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().translationYBy(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat translationZ(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048602, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null && Build.VERSION.SDK_INT >= 21) {
                view.animate().translationZ(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat translationZBy(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048603, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null && Build.VERSION.SDK_INT >= 21) {
                view.animate().translationZBy(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, runnable)) == null) {
            View view = this.mView.get();
            if (view != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    view.animate().withEndAction(runnable);
                } else {
                    setListenerInternal(view, new ViewPropertyAnimatorListenerApi14(this));
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
            View view = this.mView.get();
            if (view != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    view.animate().withLayer();
                } else {
                    this.mOldLayerType = view.getLayerType();
                    setListenerInternal(view, new ViewPropertyAnimatorListenerApi14(this));
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
            View view = this.mView.get();
            if (view != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    view.animate().withStartAction(runnable);
                } else {
                    setListenerInternal(view, new ViewPropertyAnimatorListenerApi14(this));
                    this.mStartAction = runnable;
                }
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeL.objValue;
    }

    public ViewPropertyAnimatorCompat x(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048607, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().x(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat xBy(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048608, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().xBy(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat y(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048609, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().y(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat yBy(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048610, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null) {
                view.animate().yBy(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat z(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048611, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null && Build.VERSION.SDK_INT >= 21) {
                view.animate().z(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }

    public ViewPropertyAnimatorCompat zBy(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048612, this, f2)) == null) {
            View view = this.mView.get();
            if (view != null && Build.VERSION.SDK_INT >= 21) {
                view.animate().zBy(f2);
            }
            return this;
        }
        return (ViewPropertyAnimatorCompat) invokeF.objValue;
    }
}
