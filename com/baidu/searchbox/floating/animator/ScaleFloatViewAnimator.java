package com.baidu.searchbox.floating.animator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.baidu.searchbox.floating.animator.RectEvaluator;
import com.baidu.searchbox.floating.animator.ScaleFloatViewAnimator;
import com.baidu.searchbox.floating.utils.UtilsKt;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J(\u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/floating/animator/ScaleFloatViewAnimator;", "Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;", "()V", "mDuration", "", "endValue", "Lcom/baidu/searchbox/floating/animator/RectEvaluator$ViewRect;", "view", "Landroid/view/View;", "params", "Landroid/view/WindowManager$LayoutParams;", "windowManager", "Landroid/view/WindowManager;", "enterAnim", "Landroid/animation/Animator;", "viewRef", "Ljava/lang/ref/WeakReference;", "exitAnim", "startValue", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ScaleFloatViewAnimator implements FloatViewAnimator {
    public final long mDuration = 2000;

    @Override // com.baidu.searchbox.floating.animator.FloatViewAnimator
    public Animator exitAnim(WeakReference<View> viewRef, WindowManager.LayoutParams params, WindowManager windowManager) {
        Intrinsics.checkNotNullParameter(viewRef, "viewRef");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(windowManager, "windowManager");
        return null;
    }

    private final RectEvaluator.ViewRect endValue(View view2, WindowManager.LayoutParams layoutParams, WindowManager windowManager) {
        return new RectEvaluator.ViewRect(layoutParams.x, layoutParams.y, view2.getLayoutParams().width, view2.getLayoutParams().height);
    }

    private final RectEvaluator.ViewRect startValue(View view2, WindowManager.LayoutParams layoutParams, WindowManager windowManager) {
        Context context = view2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        int screenWidth = UtilsKt.getScreenWidth(context);
        return new RectEvaluator.ViewRect(0, 0, screenWidth, (screenWidth / 16) * 9);
    }

    /* renamed from: enterAnim$lambda-0  reason: not valid java name */
    public static final void m85enterAnim$lambda0(WindowManager.LayoutParams params, WeakReference viewRef, WindowManager windowManager, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(viewRef, "$viewRef");
        Intrinsics.checkNotNullParameter(windowManager, "$windowManager");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            RectEvaluator.ViewRect viewRect = (RectEvaluator.ViewRect) animatedValue;
            params.x = viewRect.getX();
            params.y = viewRect.getY();
            params.width = viewRect.getW();
            params.height = viewRect.getH();
            View view2 = (View) viewRef.get();
            if (view2 != null) {
                windowManager.updateViewLayout(view2, params);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.floating.animator.RectEvaluator.ViewRect");
    }

    @Override // com.baidu.searchbox.floating.animator.FloatViewAnimator
    public Animator enterAnim(final WeakReference<View> viewRef, final WindowManager.LayoutParams params, final WindowManager windowManager) {
        Intrinsics.checkNotNullParameter(viewRef, "viewRef");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(windowManager, "windowManager");
        View view2 = viewRef.get();
        if (view2 == null) {
            return null;
        }
        ValueAnimator duration = ValueAnimator.ofObject(new RectEvaluator(), startValue(view2, params, windowManager), endValue(view2, params, windowManager)).setDuration(this.mDuration);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.io1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    ScaleFloatViewAnimator.m85enterAnim$lambda0(params, viewRef, windowManager, valueAnimator);
                }
            }
        });
        return duration;
    }
}
