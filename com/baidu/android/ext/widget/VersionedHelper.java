package com.baidu.android.ext.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class VersionedHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "VersionedHelper";
    public static VersionedHelper sHelper;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface VersionedAnimationListener {
        void onAnimationEnd();

        void onAnimationRepeat();

        void onAnimationStart();

        void onAnimationUpdate();
    }

    /* loaded from: classes.dex */
    public interface VersionedTransitionListener {
        void endTransition();

        void startTransition();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1869097989, "Lcom/baidu/android/ext/widget/VersionedHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1869097989, "Lcom/baidu/android/ext/widget/VersionedHelper;");
        }
    }

    public float getAlpha(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            return 1.0f;
        }
        return invokeL.floatValue;
    }

    public float getScaledPagingTouchSlop(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return 24.0f;
        }
        return invokeL.floatValue;
    }

    public void invalidateGlobalRegion(View view2, RectF rectF) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view2, rectF) == null) {
        }
    }

    public boolean isHardwareAccelerated(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isTransitionRunning(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setActivated(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, view2, z) == null) {
        }
    }

    public void setAlpha(View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, f) == null) {
        }
    }

    public void setLayoutTransitionCallback(Object obj, VersionedTransitionListener versionedTransitionListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, obj, versionedTransitionListener) == null) {
        }
    }

    public void startDisappearAnimation(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, viewGroup) == null) {
        }
    }

    @TargetApi(11)
    /* loaded from: classes.dex */
    public static class Versioned11Helper extends VersionedHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Versioned11Helper() {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.android.ext.widget.VersionedHelper
        public float getAlpha(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                return view2.getAlpha();
            }
            return invokeL.floatValue;
        }

        @Override // com.baidu.android.ext.widget.VersionedHelper
        public float getTranslationX(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
                return view2.getTranslationX();
            }
            return invokeL.floatValue;
        }

        @Override // com.baidu.android.ext.widget.VersionedHelper
        public float getTranslationY(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
                return view2.getTranslationY();
            }
            return invokeL.floatValue;
        }

        @Override // com.baidu.android.ext.widget.VersionedHelper
        public boolean isHardwareAccelerated(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
                return view2.isHardwareAccelerated();
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.android.ext.widget.VersionedHelper
        public boolean isTransitionRunning(ViewGroup viewGroup) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
                LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
                if (layoutTransition != null && layoutTransition.isRunning()) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.android.ext.widget.VersionedHelper
        public void startDisappearAnimation(ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048588, this, viewGroup) == null) {
                LayoutTransition layoutTransition = new LayoutTransition();
                viewGroup.setLayoutTransition(layoutTransition);
                layoutTransition.setDuration(200L);
                layoutTransition.setStartDelay(1, 0L);
                layoutTransition.setAnimator(3, null);
            }
        }

        @Override // com.baidu.android.ext.widget.VersionedHelper
        public void invalidateGlobalRegion(View view2, RectF rectF) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, view2, rectF) == null) {
                while (view2.getParent() != null && (view2.getParent() instanceof View)) {
                    view2 = (View) view2.getParent();
                    view2.getMatrix().mapRect(rectF);
                    view2.invalidate((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
                }
            }
        }

        @Override // com.baidu.android.ext.widget.VersionedHelper
        public void setActivated(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048582, this, view2, z) == null) {
                view2.setActivated(z);
            }
        }

        @Override // com.baidu.android.ext.widget.VersionedHelper
        public void setAlpha(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048583, this, view2, f) == null) {
                view2.setAlpha(f);
            }
        }

        @Override // com.baidu.android.ext.widget.VersionedHelper
        public void setLayoutTransitionCallback(Object obj, VersionedTransitionListener versionedTransitionListener) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, versionedTransitionListener) == null) && (obj instanceof LayoutTransition)) {
                ((LayoutTransition) obj).addTransitionListener(new LayoutTransition.TransitionListener(this, versionedTransitionListener) { // from class: com.baidu.android.ext.widget.VersionedHelper.Versioned11Helper.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Versioned11Helper this$0;
                    public final /* synthetic */ VersionedTransitionListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, versionedTransitionListener};
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
                        this.val$listener = versionedTransitionListener;
                    }

                    @Override // android.animation.LayoutTransition.TransitionListener
                    public void endTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view2, int i) {
                        VersionedTransitionListener versionedTransitionListener2;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeLLLI(1048576, this, layoutTransition, viewGroup, view2, i) == null) && (versionedTransitionListener2 = this.val$listener) != null) {
                            versionedTransitionListener2.endTransition();
                        }
                    }

                    @Override // android.animation.LayoutTransition.TransitionListener
                    public void startTransition(LayoutTransition layoutTransition, ViewGroup viewGroup, View view2, int i) {
                        VersionedTransitionListener versionedTransitionListener2;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeLLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, layoutTransition, viewGroup, view2, i) == null) && (versionedTransitionListener2 = this.val$listener) != null) {
                            versionedTransitionListener2.startTransition();
                        }
                    }
                });
            }
        }

        @Override // com.baidu.android.ext.widget.VersionedHelper
        public void setTranslationX(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048585, this, view2, f) == null) {
                view2.setTranslationX(f);
            }
        }

        @Override // com.baidu.android.ext.widget.VersionedHelper
        public void setTranslationY(View view2, float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLF(1048586, this, view2, f) == null) {
                view2.setTranslationY(f);
            }
        }

        @Override // com.baidu.android.ext.widget.VersionedHelper
        public void startAnimation(View view2, long j, String str, Object obj, VersionedAnimationListener versionedAnimationListener) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{view2, Long.valueOf(j), str, obj, versionedAnimationListener}) == null) {
                view2.setLayerType(2, null);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, str, ((Float) obj).floatValue());
                ofFloat.setDuration(j);
                ofFloat.addListener(new AnimatorListenerAdapter(this, versionedAnimationListener, view2) { // from class: com.baidu.android.ext.widget.VersionedHelper.Versioned11Helper.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Versioned11Helper this$0;
                    public final /* synthetic */ View val$animView;
                    public final /* synthetic */ VersionedAnimationListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, versionedAnimationListener, view2};
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
                        this.val$listener = versionedAnimationListener;
                        this.val$animView = view2;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                            VersionedAnimationListener versionedAnimationListener2 = this.val$listener;
                            if (versionedAnimationListener2 != null) {
                                versionedAnimationListener2.onAnimationEnd();
                            }
                            this.val$animView.setLayerType(0, null);
                        }
                    }
                });
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, versionedAnimationListener) { // from class: com.baidu.android.ext.widget.VersionedHelper.Versioned11Helper.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Versioned11Helper this$0;
                    public final /* synthetic */ VersionedAnimationListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, versionedAnimationListener};
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
                        this.val$listener = versionedAnimationListener;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VersionedAnimationListener versionedAnimationListener2;
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) && (versionedAnimationListener2 = this.val$listener) != null) {
                            versionedAnimationListener2.onAnimationUpdate();
                        }
                    }
                });
                ofFloat.start();
            }
        }
    }

    @TargetApi(8)
    /* loaded from: classes.dex */
    public static class Versioned8Helper extends VersionedHelper {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Versioned8Helper() {
            super();
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.baidu.android.ext.widget.VersionedHelper
        public float getScaledPagingTouchSlop(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
                return ViewConfiguration.get(context).getScaledPagingTouchSlop();
            }
            return invokeL.floatValue;
        }
    }

    public VersionedHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public float getTranslationX(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2)) == null) {
            return view2.getLeft();
        }
        return invokeL.floatValue;
    }

    public float getTranslationY(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
            return view2.getTop();
        }
        return invokeL.floatValue;
    }

    public static VersionedHelper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sHelper == null) {
                if (DeviceUtil.OSInfo.hasHoneycomb()) {
                    sHelper = new Versioned11Helper();
                } else if (DeviceUtil.OSInfo.hasHoneycomb()) {
                    sHelper = new Versioned8Helper();
                } else {
                    sHelper = new VersionedHelper() { // from class: com.baidu.android.ext.widget.VersionedHelper.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    AnonymousClass1 anonymousClass1 = (AnonymousClass1) newInitContext.callArgs[0];
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                }
                            }
                        }
                    };
                }
            }
            return sHelper;
        }
        return (VersionedHelper) invokeV.objValue;
    }

    public void setTranslationX(View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048586, this, view2, f) == null) {
            int i = (int) f;
            view2.layout(i, view2.getTop(), view2.getWidth() + i, view2.getBottom());
        }
    }

    public void setTranslationY(View view2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048587, this, view2, f) == null) {
            int i = (int) f;
            view2.layout(view2.getLeft(), i, view2.getRight(), view2.getHeight() + i);
        }
    }

    public void startAnimation(View view2, long j, String str, Object obj, VersionedAnimationListener versionedAnimationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{view2, Long.valueOf(j), str, obj, versionedAnimationListener}) == null) {
            float floatValue = ((Float) obj).floatValue();
            float left = view2.getLeft();
            int i = (int) floatValue;
            view2.layout(i, view2.getTop(), view2.getWidth() + i, view2.getBottom());
            if (Math.abs(left - floatValue) < 0.1f) {
                return;
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(left, floatValue, 0.0f, 0.0f);
            translateAnimation.setDuration(j);
            translateAnimation.setAnimationListener(new Animation.AnimationListener(this, versionedAnimationListener) { // from class: com.baidu.android.ext.widget.VersionedHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VersionedHelper this$0;
                public final /* synthetic */ VersionedAnimationListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, versionedAnimationListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$listener = versionedAnimationListener;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    VersionedAnimationListener versionedAnimationListener2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(1048576, this, animation) == null) && (versionedAnimationListener2 = this.val$listener) != null) {
                        versionedAnimationListener2.onAnimationEnd();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    VersionedAnimationListener versionedAnimationListener2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) && (versionedAnimationListener2 = this.val$listener) != null) {
                        versionedAnimationListener2.onAnimationRepeat();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    VersionedAnimationListener versionedAnimationListener2;
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) && (versionedAnimationListener2 = this.val$listener) != null) {
                        versionedAnimationListener2.onAnimationStart();
                    }
                }
            });
            view2.startAnimation(translateAnimation);
        }
    }
}
