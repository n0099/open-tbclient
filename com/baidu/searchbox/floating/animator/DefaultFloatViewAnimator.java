package com.baidu.searchbox.floating.animator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\f\u001a\u0004\u0018\u00010\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/floating/animator/DefaultFloatViewAnimator;", "Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "viewRef", "Landroid/view/WindowManager$LayoutParams;", "params", "Landroid/view/WindowManager;", "windowManager", "Landroid/animation/Animator;", "enterAnim", "(Ljava/lang/ref/WeakReference;Landroid/view/WindowManager$LayoutParams;Landroid/view/WindowManager;)Landroid/animation/Animator;", "exitAnim", NativeConstants.TYPE_VIEW, "", "initValue", "(Landroid/view/View;Landroid/view/WindowManager$LayoutParams;Landroid/view/WindowManager;)I", "", "mDuration", "J", "<init>", "()V", "floating-view_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class DefaultFloatViewAnimator implements FloatViewAnimator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long mDuration;

    public DefaultFloatViewAnimator() {
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
        this.mDuration = 325L;
    }

    private final int initValue(View view2, WindowManager.LayoutParams layoutParams, WindowManager windowManager) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, view2, layoutParams, windowManager)) == null) {
            Rect rect = new Rect();
            windowManager.getDefaultDisplay().getRectSize(rect);
            int i = layoutParams.x;
            return i < rect.right - (view2.getRight() + i) ? -view2.getRight() : rect.right;
        }
        return invokeLLL.intValue;
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
                ValueAnimator duration = ValueAnimator.ofInt(initValue(view2, params, windowManager), params.x).setDuration(this.mDuration);
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(params, viewRef, windowManager) { // from class: com.baidu.searchbox.floating.animator.DefaultFloatViewAnimator$enterAnim$1
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
                            WindowManager.LayoutParams layoutParams = this.$params;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            Object animatedValue = it.getAnimatedValue();
                            if (animatedValue != null) {
                                layoutParams.x = ((Integer) animatedValue).intValue();
                                View view3 = (View) this.$viewRef.get();
                                if (view3 != null) {
                                    this.$windowManager.updateViewLayout(view3, this.$params);
                                    return;
                                }
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                        }
                    }
                });
                return duration;
            }
            return null;
        }
        return (Animator) invokeLLL.objValue;
    }

    @Override // com.baidu.searchbox.floating.animator.FloatViewAnimator
    public Animator exitAnim(final WeakReference<View> viewRef, final WindowManager.LayoutParams params, final WindowManager windowManager) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewRef, params, windowManager)) == null) {
            Intrinsics.checkNotNullParameter(viewRef, "viewRef");
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(windowManager, "windowManager");
            View view2 = viewRef.get();
            if (view2 != null) {
                Intrinsics.checkNotNullExpressionValue(view2, "viewRef.get() ?: return null");
                ValueAnimator duration = ValueAnimator.ofInt(params.x, initValue(view2, params, windowManager)).setDuration(this.mDuration);
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(params, viewRef, windowManager) { // from class: com.baidu.searchbox.floating.animator.DefaultFloatViewAnimator$exitAnim$1
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
                            WindowManager.LayoutParams layoutParams = this.$params;
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            Object animatedValue = it.getAnimatedValue();
                            if (animatedValue != null) {
                                layoutParams.x = ((Integer) animatedValue).intValue();
                                View view3 = (View) this.$viewRef.get();
                                if (view3 != null) {
                                    this.$windowManager.updateViewLayout(view3, this.$params);
                                    return;
                                }
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
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
