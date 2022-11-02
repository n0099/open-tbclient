package com.baidu.searchbox.floating.animator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.floating.animator.RectEvaluator;
import com.baidu.searchbox.floating.utils.UtilsKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000e\u001a\u0004\u0018\u00010\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0010\u001a\u0004\u0018\u00010\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ'\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\nR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/floating/animator/ScaleFloatViewAnimator;", "Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;", "Landroid/view/View;", NativeConstants.TYPE_VIEW, "Landroid/view/WindowManager$LayoutParams;", "params", "Landroid/view/WindowManager;", "windowManager", "Lcom/baidu/searchbox/floating/animator/RectEvaluator$ViewRect;", "endValue", "(Landroid/view/View;Landroid/view/WindowManager$LayoutParams;Landroid/view/WindowManager;)Lcom/baidu/searchbox/floating/animator/RectEvaluator$ViewRect;", "Ljava/lang/ref/WeakReference;", "viewRef", "Landroid/animation/Animator;", "enterAnim", "(Ljava/lang/ref/WeakReference;Landroid/view/WindowManager$LayoutParams;Landroid/view/WindowManager;)Landroid/animation/Animator;", "exitAnim", "startValue", "", "mDuration", "J", "<init>", "()V", "floating-view_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class ScaleFloatViewAnimator implements FloatViewAnimator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long mDuration;

    @Override // com.baidu.searchbox.floating.animator.FloatViewAnimator
    public Animator exitAnim(WeakReference<View> viewRef, WindowManager.LayoutParams params, WindowManager windowManager) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewRef, params, windowManager)) == null) {
            Intrinsics.checkNotNullParameter(viewRef, "viewRef");
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(windowManager, "windowManager");
            return null;
        }
        return (Animator) invokeLLL.objValue;
    }

    public ScaleFloatViewAnimator() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDuration = 2000L;
    }

    private final RectEvaluator.ViewRect endValue(View view2, WindowManager.LayoutParams layoutParams, WindowManager windowManager) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, view2, layoutParams, windowManager)) == null) {
            return new RectEvaluator.ViewRect(layoutParams.x, layoutParams.y, view2.getLayoutParams().width, view2.getLayoutParams().height);
        }
        return (RectEvaluator.ViewRect) invokeLLL.objValue;
    }

    private final RectEvaluator.ViewRect startValue(View view2, WindowManager.LayoutParams layoutParams, WindowManager windowManager) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, this, view2, layoutParams, windowManager)) == null) {
            Context context = view2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            int screenWidth = UtilsKt.getScreenWidth(context);
            return new RectEvaluator.ViewRect(0, 0, screenWidth, (screenWidth / 16) * 9);
        }
        return (RectEvaluator.ViewRect) invokeLLL.objValue;
    }

    @Override // com.baidu.searchbox.floating.animator.FloatViewAnimator
    public Animator enterAnim(final WeakReference<View> viewRef, final WindowManager.LayoutParams params, final WindowManager windowManager) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, viewRef, params, windowManager)) == null) {
            Intrinsics.checkNotNullParameter(viewRef, "viewRef");
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(windowManager, "windowManager");
            View view2 = viewRef.get();
            if (view2 != null) {
                Intrinsics.checkNotNullExpressionValue(view2, "viewRef.get() ?: return null");
                ValueAnimator duration = ValueAnimator.ofObject(new RectEvaluator(), startValue(view2, params, windowManager), endValue(view2, params, windowManager)).setDuration(this.mDuration);
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(params, viewRef, windowManager) { // from class: com.baidu.searchbox.floating.animator.ScaleFloatViewAnimator$enterAnim$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ WindowManager.LayoutParams $params;
                    public final /* synthetic */ WeakReference $viewRef;
                    public final /* synthetic */ WindowManager $windowManager;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {params, viewRef, windowManager};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.$params = params;
                        this.$viewRef = viewRef;
                        this.$windowManager = windowManager;
                    }

                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator it) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, it) == null) {
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            Object animatedValue = it.getAnimatedValue();
                            if (animatedValue != null) {
                                RectEvaluator.ViewRect viewRect = (RectEvaluator.ViewRect) animatedValue;
                                this.$params.x = viewRect.getX();
                                this.$params.y = viewRect.getY();
                                this.$params.width = viewRect.getW();
                                this.$params.height = viewRect.getH();
                                View view3 = (View) this.$viewRef.get();
                                if (view3 != null) {
                                    this.$windowManager.updateViewLayout(view3, this.$params);
                                    return;
                                }
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.floating.animator.RectEvaluator.ViewRect");
                        }
                    }
                });
                return duration;
            }
            return null;
        }
        return (Animator) invokeLLL.objValue;
    }
}
