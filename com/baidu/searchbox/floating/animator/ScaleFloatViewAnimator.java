package com.baidu.searchbox.floating.animator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.baidu.searchbox.floating.animator.RectEvaluator;
import com.baidu.searchbox.floating.utils.UtilsKt;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000e\u001a\u0004\u0018\u00010\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0010\u001a\u0004\u0018\u00010\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ'\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\nR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/floating/animator/ScaleFloatViewAnimator;", "Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;", "Landroid/view/View;", "view", "Landroid/view/WindowManager$LayoutParams;", "params", "Landroid/view/WindowManager;", "windowManager", "Lcom/baidu/searchbox/floating/animator/RectEvaluator$ViewRect;", "endValue", "(Landroid/view/View;Landroid/view/WindowManager$LayoutParams;Landroid/view/WindowManager;)Lcom/baidu/searchbox/floating/animator/RectEvaluator$ViewRect;", "Ljava/lang/ref/WeakReference;", "viewRef", "Landroid/animation/Animator;", "enterAnim", "(Ljava/lang/ref/WeakReference;Landroid/view/WindowManager$LayoutParams;Landroid/view/WindowManager;)Landroid/animation/Animator;", "exitAnim", "startValue", "", "mDuration", "J", "<init>", "()V", "floating-view_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
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

    @Override // com.baidu.searchbox.floating.animator.FloatViewAnimator
    public Animator enterAnim(final WeakReference<View> viewRef, final WindowManager.LayoutParams params, final WindowManager windowManager) {
        Intrinsics.checkNotNullParameter(viewRef, "viewRef");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(windowManager, "windowManager");
        View view2 = viewRef.get();
        if (view2 != null) {
            Intrinsics.checkNotNullExpressionValue(view2, "viewRef.get() ?: return null");
            ValueAnimator duration = ValueAnimator.ofObject(new RectEvaluator(), startValue(view2, params, windowManager), endValue(view2, params, windowManager)).setDuration(this.mDuration);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.floating.animator.ScaleFloatViewAnimator$enterAnim$1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator it) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Object animatedValue = it.getAnimatedValue();
                    if (animatedValue != null) {
                        RectEvaluator.ViewRect viewRect = (RectEvaluator.ViewRect) animatedValue;
                        params.x = viewRect.getX();
                        params.y = viewRect.getY();
                        params.width = viewRect.getW();
                        params.height = viewRect.getH();
                        View view3 = (View) viewRef.get();
                        if (view3 != null) {
                            windowManager.updateViewLayout(view3, params);
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.floating.animator.RectEvaluator.ViewRect");
                }
            });
            return duration;
        }
        return null;
    }
}
