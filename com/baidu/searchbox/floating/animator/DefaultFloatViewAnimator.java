package com.baidu.searchbox.floating.animator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\f\u001a\u0004\u0018\u00010\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/floating/animator/DefaultFloatViewAnimator;", "Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "viewRef", "Landroid/view/WindowManager$LayoutParams;", "params", "Landroid/view/WindowManager;", "windowManager", "Landroid/animation/Animator;", "enterAnim", "(Ljava/lang/ref/WeakReference;Landroid/view/WindowManager$LayoutParams;Landroid/view/WindowManager;)Landroid/animation/Animator;", "exitAnim", "view", "", "initValue", "(Landroid/view/View;Landroid/view/WindowManager$LayoutParams;Landroid/view/WindowManager;)I", "", "mDuration", "J", "<init>", "()V", "lib-player-floating_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class DefaultFloatViewAnimator implements FloatViewAnimator {
    public final long mDuration = 325;

    private final int initValue(View view, WindowManager.LayoutParams layoutParams, WindowManager windowManager) {
        Rect rect = new Rect();
        windowManager.getDefaultDisplay().getRectSize(rect);
        int i = layoutParams.x;
        return i < rect.right - (view.getRight() + i) ? -view.getRight() : rect.right;
    }

    @Override // com.baidu.searchbox.floating.animator.FloatViewAnimator
    public Animator enterAnim(final WeakReference<View> weakReference, final WindowManager.LayoutParams layoutParams, final WindowManager windowManager) {
        View view = weakReference.get();
        if (view != null) {
            Intrinsics.checkExpressionValueIsNotNull(view, "view");
            ValueAnimator duration = ValueAnimator.ofInt(initValue(view, layoutParams, windowManager), layoutParams.x).setDuration(this.mDuration);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.floating.animator.DefaultFloatViewAnimator$enterAnim$1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator it) {
                    WindowManager.LayoutParams layoutParams2 = layoutParams;
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    Object animatedValue = it.getAnimatedValue();
                    if (animatedValue != null) {
                        layoutParams2.x = ((Integer) animatedValue).intValue();
                        View view2 = (View) weakReference.get();
                        if (view2 != null) {
                            windowManager.updateViewLayout(view2, layoutParams);
                            return;
                        }
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                }
            });
            return duration;
        }
        return null;
    }

    @Override // com.baidu.searchbox.floating.animator.FloatViewAnimator
    public Animator exitAnim(final WeakReference<View> weakReference, final WindowManager.LayoutParams layoutParams, final WindowManager windowManager) {
        View view = weakReference.get();
        if (view != null) {
            Intrinsics.checkExpressionValueIsNotNull(view, "view");
            ValueAnimator duration = ValueAnimator.ofInt(layoutParams.x, initValue(view, layoutParams, windowManager)).setDuration(this.mDuration);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.floating.animator.DefaultFloatViewAnimator$exitAnim$1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator it) {
                    WindowManager.LayoutParams layoutParams2 = layoutParams;
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    Object animatedValue = it.getAnimatedValue();
                    if (animatedValue != null) {
                        layoutParams2.x = ((Integer) animatedValue).intValue();
                        View view2 = (View) weakReference.get();
                        if (view2 != null) {
                            windowManager.updateViewLayout(view2, layoutParams);
                            return;
                        }
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                }
            });
            return duration;
        }
        return null;
    }
}
