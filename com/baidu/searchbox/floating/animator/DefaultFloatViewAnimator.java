package com.baidu.searchbox.floating.animator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.lang.ref.WeakReference;
import kotlin.TypeCastException;
import kotlin.e;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes16.dex */
public final class DefaultFloatViewAnimator implements FloatViewAnimator {
    private final long mDuration = 325;

    @Override // com.baidu.searchbox.floating.animator.FloatViewAnimator
    public Animator enterAnim(final WeakReference<View> weakReference, final WindowManager.LayoutParams layoutParams, final WindowManager windowManager) {
        p.o(weakReference, "viewRef");
        p.o(layoutParams, "params");
        p.o(windowManager, "windowManager");
        View view = weakReference.get();
        if (view == null) {
            return null;
        }
        p.n(view, "view");
        ValueAnimator duration = ValueAnimator.ofInt(initValue(view, layoutParams, windowManager), layoutParams.x).setDuration(this.mDuration);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.floating.animator.DefaultFloatViewAnimator$enterAnim$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WindowManager.LayoutParams layoutParams2 = layoutParams;
                p.n(valueAnimator, AdvanceSetting.NETWORK_TYPE);
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                }
                layoutParams2.x = ((Integer) animatedValue).intValue();
                View view2 = (View) weakReference.get();
                if (view2 != null) {
                    windowManager.updateViewLayout(view2, layoutParams);
                }
            }
        });
        return duration;
    }

    @Override // com.baidu.searchbox.floating.animator.FloatViewAnimator
    public Animator exitAnim(final WeakReference<View> weakReference, final WindowManager.LayoutParams layoutParams, final WindowManager windowManager) {
        p.o(weakReference, "viewRef");
        p.o(layoutParams, "params");
        p.o(windowManager, "windowManager");
        View view = weakReference.get();
        if (view == null) {
            return null;
        }
        p.n(view, "view");
        ValueAnimator duration = ValueAnimator.ofInt(layoutParams.x, initValue(view, layoutParams, windowManager)).setDuration(this.mDuration);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.floating.animator.DefaultFloatViewAnimator$exitAnim$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                WindowManager.LayoutParams layoutParams2 = layoutParams;
                p.n(valueAnimator, AdvanceSetting.NETWORK_TYPE);
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
                }
                layoutParams2.x = ((Integer) animatedValue).intValue();
                View view2 = (View) weakReference.get();
                if (view2 != null) {
                    windowManager.updateViewLayout(view2, layoutParams);
                }
            }
        });
        return duration;
    }

    private final int initValue(View view, WindowManager.LayoutParams layoutParams, WindowManager windowManager) {
        Rect rect = new Rect();
        windowManager.getDefaultDisplay().getRectSize(rect);
        int i = layoutParams.x;
        return i < rect.right - (view.getRight() + i) ? -view.getRight() : rect.right;
    }
}
