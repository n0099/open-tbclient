package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public final class WindowInsetsAnimationCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "WindowInsetsAnimCompat";
    public transient /* synthetic */ FieldHolder $fh;
    public Impl mImpl;

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static class Impl21 extends Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @RequiresApi(21)
        /* loaded from: classes.dex */
        public static class Impl21OnApplyWindowInsetsListener implements View.OnApplyWindowInsetsListener {
            public static /* synthetic */ Interceptable $ic = null;
            public static final int COMPAT_ANIMATION_DURATION = 160;
            public transient /* synthetic */ FieldHolder $fh;
            public final Callback mCallback;
            public WindowInsetsCompat mLastInsets;

            public Impl21OnApplyWindowInsetsListener(@NonNull View view2, @NonNull Callback callback) {
                WindowInsetsCompat windowInsetsCompat;
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view2, callback};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mCallback = callback;
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(view2);
                if (rootWindowInsets != null) {
                    windowInsetsCompat = new WindowInsetsCompat.Builder(rootWindowInsets).build();
                } else {
                    windowInsetsCompat = null;
                }
                this.mLastInsets = windowInsetsCompat;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, windowInsets)) == null) {
                    if (!view2.isLaidOut()) {
                        this.mLastInsets = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view2);
                        return Impl21.forwardToViewIfNeeded(view2, windowInsets);
                    }
                    WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets, view2);
                    if (this.mLastInsets == null) {
                        this.mLastInsets = ViewCompat.getRootWindowInsets(view2);
                    }
                    if (this.mLastInsets == null) {
                        this.mLastInsets = windowInsetsCompat;
                        return Impl21.forwardToViewIfNeeded(view2, windowInsets);
                    }
                    Callback callback = Impl21.getCallback(view2);
                    if (callback != null && Objects.equals(callback.mDispachedInsets, windowInsets)) {
                        return Impl21.forwardToViewIfNeeded(view2, windowInsets);
                    }
                    int buildAnimationMask = Impl21.buildAnimationMask(windowInsetsCompat, this.mLastInsets);
                    if (buildAnimationMask == 0) {
                        return Impl21.forwardToViewIfNeeded(view2, windowInsets);
                    }
                    WindowInsetsCompat windowInsetsCompat2 = this.mLastInsets;
                    WindowInsetsAnimationCompat windowInsetsAnimationCompat = new WindowInsetsAnimationCompat(buildAnimationMask, new DecelerateInterpolator(), 160L);
                    windowInsetsAnimationCompat.setFraction(0.0f);
                    ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(windowInsetsAnimationCompat.getDurationMillis());
                    BoundsCompat computeAnimationBounds = Impl21.computeAnimationBounds(windowInsetsCompat, windowInsetsCompat2, buildAnimationMask);
                    Impl21.dispatchOnPrepare(view2, windowInsetsAnimationCompat, windowInsets, false);
                    duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, windowInsetsAnimationCompat, windowInsetsCompat, windowInsetsCompat2, buildAnimationMask, view2) { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Impl21OnApplyWindowInsetsListener this$0;
                        public final /* synthetic */ WindowInsetsAnimationCompat val$anim;
                        public final /* synthetic */ int val$animationMask;
                        public final /* synthetic */ WindowInsetsCompat val$startingInsets;
                        public final /* synthetic */ WindowInsetsCompat val$targetInsets;
                        public final /* synthetic */ View val$v;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, windowInsetsAnimationCompat, windowInsetsCompat, windowInsetsCompat2, Integer.valueOf(buildAnimationMask), view2};
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
                            this.val$anim = windowInsetsAnimationCompat;
                            this.val$targetInsets = windowInsetsCompat;
                            this.val$startingInsets = windowInsetsCompat2;
                            this.val$animationMask = buildAnimationMask;
                            this.val$v = view2;
                        }

                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                                this.val$anim.setFraction(valueAnimator.getAnimatedFraction());
                                Impl21.dispatchOnProgress(this.val$v, Impl21.interpolateInsets(this.val$targetInsets, this.val$startingInsets, this.val$anim.getInterpolatedFraction(), this.val$animationMask), Collections.singletonList(this.val$anim));
                            }
                        }
                    });
                    duration.addListener(new AnimatorListenerAdapter(this, windowInsetsAnimationCompat, view2) { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Impl21OnApplyWindowInsetsListener this$0;
                        public final /* synthetic */ WindowInsetsAnimationCompat val$anim;
                        public final /* synthetic */ View val$v;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, windowInsetsAnimationCompat, view2};
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
                            this.val$anim = windowInsetsAnimationCompat;
                            this.val$v = view2;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                                this.val$anim.setFraction(1.0f);
                                Impl21.dispatchOnEnd(this.val$v, this.val$anim);
                            }
                        }
                    });
                    OneShotPreDrawListener.add(view2, new Runnable(this, view2, windowInsetsAnimationCompat, computeAnimationBounds, duration) { // from class: androidx.core.view.WindowInsetsAnimationCompat.Impl21.Impl21OnApplyWindowInsetsListener.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ Impl21OnApplyWindowInsetsListener this$0;
                        public final /* synthetic */ WindowInsetsAnimationCompat val$anim;
                        public final /* synthetic */ BoundsCompat val$animationBounds;
                        public final /* synthetic */ ValueAnimator val$animator;
                        public final /* synthetic */ View val$v;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, view2, windowInsetsAnimationCompat, computeAnimationBounds, duration};
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
                            this.val$v = view2;
                            this.val$anim = windowInsetsAnimationCompat;
                            this.val$animationBounds = computeAnimationBounds;
                            this.val$animator = duration;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                Impl21.dispatchOnStart(this.val$v, this.val$anim, this.val$animationBounds);
                                this.val$animator.start();
                            }
                        }
                    });
                    this.mLastInsets = windowInsetsCompat;
                    return Impl21.forwardToViewIfNeeded(view2, windowInsets);
                }
                return (WindowInsets) invokeLL.objValue;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Impl21(int i, @Nullable Interpolator interpolator, long j) {
            super(i, interpolator, j);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), interpolator, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (Interpolator) objArr2[1], ((Long) objArr2[2]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @SuppressLint({"WrongConstant"})
        public static int buildAnimationMask(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsetsCompat windowInsetsCompat2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, windowInsetsCompat, windowInsetsCompat2)) == null) {
                int i = 0;
                for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                    if (!windowInsetsCompat.getInsets(i2).equals(windowInsetsCompat2.getInsets(i2))) {
                        i |= i2;
                    }
                }
                return i;
            }
            return invokeLL.intValue;
        }

        @NonNull
        public static View.OnApplyWindowInsetsListener createProxyListener(@NonNull View view2, @NonNull Callback callback) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, view2, callback)) == null) {
                return new Impl21OnApplyWindowInsetsListener(view2, callback);
            }
            return (View.OnApplyWindowInsetsListener) invokeLL.objValue;
        }

        @NonNull
        public static WindowInsets forwardToViewIfNeeded(@NonNull View view2, @NonNull WindowInsets windowInsets) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, view2, windowInsets)) == null) {
                if (view2.getTag(R.id.obfuscated_res_0x7f09216f) != null) {
                    return windowInsets;
                }
                return view2.onApplyWindowInsets(windowInsets);
            }
            return (WindowInsets) invokeLL.objValue;
        }

        @NonNull
        public static BoundsCompat computeAnimationBounds(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsetsCompat windowInsetsCompat2, int i) {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, windowInsetsCompat, windowInsetsCompat2, i)) == null) {
                Insets insets = windowInsetsCompat.getInsets(i);
                Insets insets2 = windowInsetsCompat2.getInsets(i);
                return new BoundsCompat(Insets.of(Math.min(insets.left, insets2.left), Math.min(insets.top, insets2.top), Math.min(insets.right, insets2.right), Math.min(insets.bottom, insets2.bottom)), Insets.of(Math.max(insets.left, insets2.left), Math.max(insets.top, insets2.top), Math.max(insets.right, insets2.right), Math.max(insets.bottom, insets2.bottom)));
            }
            return (BoundsCompat) invokeLLI.objValue;
        }

        public static void dispatchOnEnd(@NonNull View view2, @NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2, windowInsetsAnimationCompat) == null) {
                Callback callback = getCallback(view2);
                if (callback != null) {
                    callback.onEnd(windowInsetsAnimationCompat);
                    if (callback.getDispatchMode() == 0) {
                        return;
                    }
                }
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        dispatchOnEnd(viewGroup.getChildAt(i), windowInsetsAnimationCompat);
                    }
                }
            }
        }

        public static void setCallback(@NonNull View view2, @Nullable Callback callback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65547, null, view2, callback) == null) {
                Object tag = view2.getTag(R.id.obfuscated_res_0x7f09216f);
                if (callback == null) {
                    view2.setTag(R.id.obfuscated_res_0x7f0921aa, null);
                    if (tag == null) {
                        view2.setOnApplyWindowInsetsListener(null);
                        return;
                    }
                    return;
                }
                View.OnApplyWindowInsetsListener createProxyListener = createProxyListener(view2, callback);
                view2.setTag(R.id.obfuscated_res_0x7f0921aa, createProxyListener);
                if (tag == null) {
                    view2.setOnApplyWindowInsetsListener(createProxyListener);
                }
            }
        }

        public static void dispatchOnPrepare(View view2, WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsets windowInsets, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{view2, windowInsetsAnimationCompat, windowInsets, Boolean.valueOf(z)}) == null) {
                Callback callback = getCallback(view2);
                if (callback != null) {
                    callback.mDispachedInsets = windowInsets;
                    if (!z) {
                        callback.onPrepare(windowInsetsAnimationCompat);
                        if (callback.getDispatchMode() == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                }
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        dispatchOnPrepare(viewGroup.getChildAt(i), windowInsetsAnimationCompat, windowInsets, z);
                    }
                }
            }
        }

        public static void dispatchOnProgress(@NonNull View view2, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull List<WindowInsetsAnimationCompat> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65542, null, view2, windowInsetsCompat, list) == null) {
                Callback callback = getCallback(view2);
                if (callback != null) {
                    windowInsetsCompat = callback.onProgress(windowInsetsCompat, list);
                    if (callback.getDispatchMode() == 0) {
                        return;
                    }
                }
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        dispatchOnProgress(viewGroup.getChildAt(i), windowInsetsCompat, list);
                    }
                }
            }
        }

        public static void dispatchOnStart(View view2, WindowInsetsAnimationCompat windowInsetsAnimationCompat, BoundsCompat boundsCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(65543, null, view2, windowInsetsAnimationCompat, boundsCompat) == null) {
                Callback callback = getCallback(view2);
                if (callback != null) {
                    callback.onStart(windowInsetsAnimationCompat, boundsCompat);
                    if (callback.getDispatchMode() == 0) {
                        return;
                    }
                }
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        dispatchOnStart(viewGroup.getChildAt(i), windowInsetsAnimationCompat, boundsCompat);
                    }
                }
            }
        }

        @Nullable
        public static Callback getCallback(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, view2)) == null) {
                Object tag = view2.getTag(R.id.obfuscated_res_0x7f0921aa);
                if (tag instanceof Impl21OnApplyWindowInsetsListener) {
                    return ((Impl21OnApplyWindowInsetsListener) tag).mCallback;
                }
                return null;
            }
            return (Callback) invokeL.objValue;
        }

        @SuppressLint({"WrongConstant"})
        public static WindowInsetsCompat interpolateInsets(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat windowInsetsCompat2, float f, int i) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{windowInsetsCompat, windowInsetsCompat2, Float.valueOf(f), Integer.valueOf(i)})) == null) {
                WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder(windowInsetsCompat);
                for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                    if ((i & i2) == 0) {
                        builder.setInsets(i2, windowInsetsCompat.getInsets(i2));
                    } else {
                        Insets insets = windowInsetsCompat.getInsets(i2);
                        Insets insets2 = windowInsetsCompat2.getInsets(i2);
                        float f2 = 1.0f - f;
                        builder.setInsets(i2, WindowInsetsCompat.insetInsets(insets, (int) (((insets.left - insets2.left) * f2) + 0.5d), (int) (((insets.top - insets2.top) * f2) + 0.5d), (int) (((insets.right - insets2.right) * f2) + 0.5d), (int) (((insets.bottom - insets2.bottom) * f2) + 0.5d)));
                    }
                }
                return builder.build();
            }
            return (WindowInsetsCompat) invokeCommon.objValue;
        }
    }

    @RequiresApi(30)
    /* loaded from: classes.dex */
    public static class Impl30 extends Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final WindowInsetsAnimation mWrapped;

        @RequiresApi(30)
        /* loaded from: classes.dex */
        public static class ProxyCallback extends WindowInsetsAnimation.Callback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final HashMap<WindowInsetsAnimation, WindowInsetsAnimationCompat> mAnimations;
            public final Callback mCompat;
            public List<WindowInsetsAnimationCompat> mRORunningAnimations;
            public ArrayList<WindowInsetsAnimationCompat> mTmpRunningAnimations;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ProxyCallback(@NonNull Callback callback) {
                super(callback.getDispatchMode());
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {callback};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super(((Integer) newInitContext.callArgs[0]).intValue());
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mAnimations = new HashMap<>();
                this.mCompat = callback;
            }

            @NonNull
            private WindowInsetsAnimationCompat getWindowInsetsAnimationCompat(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, windowInsetsAnimation)) == null) {
                    WindowInsetsAnimationCompat windowInsetsAnimationCompat = this.mAnimations.get(windowInsetsAnimation);
                    if (windowInsetsAnimationCompat == null) {
                        WindowInsetsAnimationCompat windowInsetsAnimationCompat2 = WindowInsetsAnimationCompat.toWindowInsetsAnimationCompat(windowInsetsAnimation);
                        this.mAnimations.put(windowInsetsAnimation, windowInsetsAnimationCompat2);
                        return windowInsetsAnimationCompat2;
                    }
                    return windowInsetsAnimationCompat;
                }
                return (WindowInsetsAnimationCompat) invokeL.objValue;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onEnd(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, windowInsetsAnimation) == null) {
                    this.mCompat.onEnd(getWindowInsetsAnimationCompat(windowInsetsAnimation));
                    this.mAnimations.remove(windowInsetsAnimation);
                }
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            public void onPrepare(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, windowInsetsAnimation) == null) {
                    this.mCompat.onPrepare(getWindowInsetsAnimationCompat(windowInsetsAnimation));
                }
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            @NonNull
            public WindowInsets onProgress(@NonNull WindowInsets windowInsets, @NonNull List<WindowInsetsAnimation> list) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, windowInsets, list)) == null) {
                    ArrayList<WindowInsetsAnimationCompat> arrayList = this.mTmpRunningAnimations;
                    if (arrayList == null) {
                        ArrayList<WindowInsetsAnimationCompat> arrayList2 = new ArrayList<>(list.size());
                        this.mTmpRunningAnimations = arrayList2;
                        this.mRORunningAnimations = Collections.unmodifiableList(arrayList2);
                    } else {
                        arrayList.clear();
                    }
                    for (int size = list.size() - 1; size >= 0; size--) {
                        WindowInsetsAnimation windowInsetsAnimation = list.get(size);
                        WindowInsetsAnimationCompat windowInsetsAnimationCompat = getWindowInsetsAnimationCompat(windowInsetsAnimation);
                        windowInsetsAnimationCompat.setFraction(windowInsetsAnimation.getFraction());
                        this.mTmpRunningAnimations.add(windowInsetsAnimationCompat);
                    }
                    return this.mCompat.onProgress(WindowInsetsCompat.toWindowInsetsCompat(windowInsets), this.mRORunningAnimations).toWindowInsets();
                }
                return (WindowInsets) invokeLL.objValue;
            }

            @Override // android.view.WindowInsetsAnimation.Callback
            @NonNull
            public WindowInsetsAnimation.Bounds onStart(@NonNull WindowInsetsAnimation windowInsetsAnimation, @NonNull WindowInsetsAnimation.Bounds bounds) {
                InterceptResult invokeLL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, windowInsetsAnimation, bounds)) == null) {
                    return this.mCompat.onStart(getWindowInsetsAnimationCompat(windowInsetsAnimation), BoundsCompat.toBoundsCompat(bounds)).toBounds();
                }
                return (WindowInsetsAnimation.Bounds) invokeLL.objValue;
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Impl30(int i, Interpolator interpolator, long j) {
            this(new WindowInsetsAnimation(i, interpolator, j));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), interpolator, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this((WindowInsetsAnimation) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Impl30(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {windowInsetsAnimation};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (Interpolator) objArr2[1], ((Long) objArr2[2]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mWrapped = windowInsetsAnimation;
        }

        @NonNull
        public static WindowInsetsAnimation.Bounds createPlatformBounds(@NonNull BoundsCompat boundsCompat) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, boundsCompat)) == null) {
                return new WindowInsetsAnimation.Bounds(boundsCompat.getLowerBound().toPlatformInsets(), boundsCompat.getUpperBound().toPlatformInsets());
            }
            return (WindowInsetsAnimation.Bounds) invokeL.objValue;
        }

        @NonNull
        public static Insets getHigherBounds(@NonNull WindowInsetsAnimation.Bounds bounds) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bounds)) == null) {
                return Insets.toCompatInsets(bounds.getUpperBound());
            }
            return (Insets) invokeL.objValue;
        }

        @NonNull
        public static Insets getLowerBounds(@NonNull WindowInsetsAnimation.Bounds bounds) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bounds)) == null) {
                return Insets.toCompatInsets(bounds.getLowerBound());
            }
            return (Insets) invokeL.objValue;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public void setFraction(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
                this.mWrapped.setFraction(f);
            }
        }

        public static void setCallback(@NonNull View view2, @Nullable Callback callback) {
            ProxyCallback proxyCallback;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65541, null, view2, callback) == null) {
                if (callback != null) {
                    proxyCallback = new ProxyCallback(callback);
                } else {
                    proxyCallback = null;
                }
                view2.setWindowInsetsAnimationCallback(proxyCallback);
            }
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public long getDurationMillis() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mWrapped.getDurationMillis();
            }
            return invokeV.longValue;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public float getFraction() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mWrapped.getFraction();
            }
            return invokeV.floatValue;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public float getInterpolatedFraction() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mWrapped.getInterpolatedFraction();
            }
            return invokeV.floatValue;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        @Nullable
        public Interpolator getInterpolator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mWrapped.getInterpolator();
            }
            return (Interpolator) invokeV.objValue;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Impl
        public int getTypeMask() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mWrapped.getTypeMask();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class BoundsCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Insets mLowerBound;
        public final Insets mUpperBound;

        @RequiresApi(30)
        public BoundsCompat(@NonNull WindowInsetsAnimation.Bounds bounds) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bounds};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mLowerBound = Impl30.getLowerBounds(bounds);
            this.mUpperBound = Impl30.getHigherBounds(bounds);
        }

        @NonNull
        public BoundsCompat inset(@NonNull Insets insets) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, insets)) == null) {
                return new BoundsCompat(WindowInsetsCompat.insetInsets(this.mLowerBound, insets.left, insets.top, insets.right, insets.bottom), WindowInsetsCompat.insetInsets(this.mUpperBound, insets.left, insets.top, insets.right, insets.bottom));
            }
            return (BoundsCompat) invokeL.objValue;
        }

        public BoundsCompat(@NonNull Insets insets, @NonNull Insets insets2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {insets, insets2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mLowerBound = insets;
            this.mUpperBound = insets2;
        }

        @NonNull
        @RequiresApi(30)
        public static BoundsCompat toBoundsCompat(@NonNull WindowInsetsAnimation.Bounds bounds) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bounds)) == null) {
                return new BoundsCompat(bounds);
            }
            return (BoundsCompat) invokeL.objValue;
        }

        @NonNull
        public Insets getLowerBound() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mLowerBound;
            }
            return (Insets) invokeV.objValue;
        }

        @NonNull
        public Insets getUpperBound() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mUpperBound;
            }
            return (Insets) invokeV.objValue;
        }

        @NonNull
        @RequiresApi(30)
        public WindowInsetsAnimation.Bounds toBounds() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return Impl30.createPlatformBounds(this);
            }
            return (WindowInsetsAnimation.Bounds) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return "Bounds{lower=" + this.mLowerBound + " upper=" + this.mUpperBound + "}";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
        public static final int DISPATCH_MODE_STOP = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public WindowInsets mDispachedInsets;
        public final int mDispatchMode;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        /* loaded from: classes.dex */
        public @interface DispatchMode {
        }

        public void onEnd(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, windowInsetsAnimationCompat) == null) {
            }
        }

        public void onPrepare(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, windowInsetsAnimationCompat) == null) {
            }
        }

        @NonNull
        public abstract WindowInsetsCompat onProgress(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull List<WindowInsetsAnimationCompat> list);

        @NonNull
        public BoundsCompat onStart(@NonNull WindowInsetsAnimationCompat windowInsetsAnimationCompat, @NonNull BoundsCompat boundsCompat) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, windowInsetsAnimationCompat, boundsCompat)) == null) ? boundsCompat : (BoundsCompat) invokeLL.objValue;
        }

        public Callback(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mDispatchMode = i;
        }

        public final int getDispatchMode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mDispatchMode;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static class Impl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float mAlpha;
        public final long mDurationMillis;
        public float mFraction;
        @Nullable
        public final Interpolator mInterpolator;
        public final int mTypeMask;

        public Impl(int i, @Nullable Interpolator interpolator, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), interpolator, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTypeMask = i;
            this.mInterpolator = interpolator;
            this.mDurationMillis = j;
        }

        public float getAlpha() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mAlpha;
            }
            return invokeV.floatValue;
        }

        public long getDurationMillis() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mDurationMillis;
            }
            return invokeV.longValue;
        }

        public float getFraction() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mFraction;
            }
            return invokeV.floatValue;
        }

        public float getInterpolatedFraction() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Interpolator interpolator = this.mInterpolator;
                if (interpolator != null) {
                    return interpolator.getInterpolation(this.mFraction);
                }
                return this.mFraction;
            }
            return invokeV.floatValue;
        }

        @Nullable
        public Interpolator getInterpolator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mInterpolator;
            }
            return (Interpolator) invokeV.objValue;
        }

        public int getTypeMask() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.mTypeMask;
            }
            return invokeV.intValue;
        }

        public void setAlpha(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
                this.mAlpha = f;
            }
        }

        public void setFraction(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
                this.mFraction = f;
            }
        }
    }

    public WindowInsetsAnimationCompat(int i, @Nullable Interpolator interpolator, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), interpolator, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 30) {
            this.mImpl = new Impl30(i, interpolator, j);
        } else if (i4 >= 21) {
            this.mImpl = new Impl21(i, interpolator, j);
        } else {
            this.mImpl = new Impl(0, interpolator, j);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RequiresApi(30)
    public WindowInsetsAnimationCompat(@NonNull WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {windowInsetsAnimation};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), (Interpolator) objArr2[1], ((Long) objArr2[2]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(windowInsetsAnimation);
        }
    }

    public static void setCallback(@NonNull View view2, @Nullable Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, view2, callback) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                Impl30.setCallback(view2, callback);
            } else if (i >= 21) {
                Impl21.setCallback(view2, callback);
            }
        }
    }

    @RequiresApi(30)
    public static WindowInsetsAnimationCompat toWindowInsetsAnimationCompat(WindowInsetsAnimation windowInsetsAnimation) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, windowInsetsAnimation)) == null) {
            return new WindowInsetsAnimationCompat(windowInsetsAnimation);
        }
        return (WindowInsetsAnimationCompat) invokeL.objValue;
    }

    public void setAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
            this.mImpl.setAlpha(f);
        }
    }

    public void setFraction(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048583, this, f) == null) {
            this.mImpl.setFraction(f);
        }
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mImpl.getAlpha();
        }
        return invokeV.floatValue;
    }

    public long getDurationMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mImpl.getDurationMillis();
        }
        return invokeV.longValue;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getFraction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mImpl.getFraction();
        }
        return invokeV.floatValue;
    }

    public float getInterpolatedFraction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mImpl.getInterpolatedFraction();
        }
        return invokeV.floatValue;
    }

    @Nullable
    public Interpolator getInterpolator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mImpl.getInterpolator();
        }
        return (Interpolator) invokeV.objValue;
    }

    public int getTypeMask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mImpl.getTypeMask();
        }
        return invokeV.intValue;
    }
}
