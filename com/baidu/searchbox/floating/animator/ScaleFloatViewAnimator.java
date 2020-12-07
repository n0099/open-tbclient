package com.baidu.searchbox.floating.animator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.baidu.searchbox.floating.animator.RectEvaluator;
import com.baidu.searchbox.floating.utils.UtilsKt;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.lang.ref.WeakReference;
import kotlin.TypeCastException;
import kotlin.e;
import kotlin.jvm.internal.p;
@e
/* loaded from: classes16.dex */
public final class ScaleFloatViewAnimator implements FloatViewAnimator {
    private final long mDuration = 2000;

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
        ValueAnimator duration = ValueAnimator.ofObject(new RectEvaluator(), startValue(view, layoutParams, windowManager), endValue(view, layoutParams, windowManager)).setDuration(this.mDuration);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.searchbox.floating.animator.ScaleFloatViewAnimator$enterAnim$1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                p.n(valueAnimator, AdvanceSetting.NETWORK_TYPE);
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (animatedValue == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.baidu.searchbox.floating.animator.RectEvaluator.ViewRect");
                }
                RectEvaluator.ViewRect viewRect = (RectEvaluator.ViewRect) animatedValue;
                layoutParams.x = viewRect.getX();
                layoutParams.y = viewRect.getY();
                layoutParams.width = viewRect.getW();
                layoutParams.height = viewRect.getH();
                View view2 = (View) weakReference.get();
                if (view2 != null) {
                    windowManager.updateViewLayout(view2, layoutParams);
                }
            }
        });
        return duration;
    }

    @Override // com.baidu.searchbox.floating.animator.FloatViewAnimator
    public Animator exitAnim(WeakReference<View> weakReference, WindowManager.LayoutParams layoutParams, WindowManager windowManager) {
        p.o(weakReference, "viewRef");
        p.o(layoutParams, "params");
        p.o(windowManager, "windowManager");
        return null;
    }

    private final RectEvaluator.ViewRect endValue(View view, WindowManager.LayoutParams layoutParams, WindowManager windowManager) {
        return new RectEvaluator.ViewRect(layoutParams.x, layoutParams.y, view.getLayoutParams().width, view.getLayoutParams().height);
    }

    private final RectEvaluator.ViewRect startValue(View view, WindowManager.LayoutParams layoutParams, WindowManager windowManager) {
        Context context = view.getContext();
        p.n(context, "view.context");
        int screenWidth = UtilsKt.getScreenWidth(context);
        return new RectEvaluator.ViewRect(0, 0, screenWidth, (screenWidth / 16) * 9);
    }
}
