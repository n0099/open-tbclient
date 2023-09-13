package com.baidu.searchbox.floating.animator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import com.baidu.searchbox.floating.animator.DefaultFloatViewAnimator;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/floating/animator/DefaultFloatViewAnimator;", "Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;", "()V", "mDuration", "", "enterAnim", "Landroid/animation/Animator;", "viewRef", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "params", "Landroid/view/WindowManager$LayoutParams;", "windowManager", "Landroid/view/WindowManager;", "exitAnim", "initValue", "", "view", "floating-view_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultFloatViewAnimator implements FloatViewAnimator {
    public final long mDuration = 325;

    /* renamed from: enterAnim$lambda-0  reason: not valid java name */
    public static final void m83enterAnim$lambda0(WindowManager.LayoutParams params, WeakReference viewRef, WindowManager windowManager, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(viewRef, "$viewRef");
        Intrinsics.checkNotNullParameter(windowManager, "$windowManager");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            params.x = ((Integer) animatedValue).intValue();
            View view2 = (View) viewRef.get();
            if (view2 != null) {
                windowManager.updateViewLayout(view2, params);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* renamed from: exitAnim$lambda-1  reason: not valid java name */
    public static final void m84exitAnim$lambda1(WindowManager.LayoutParams params, WeakReference viewRef, WindowManager windowManager, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(viewRef, "$viewRef");
        Intrinsics.checkNotNullParameter(windowManager, "$windowManager");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            params.x = ((Integer) animatedValue).intValue();
            View view2 = (View) viewRef.get();
            if (view2 != null) {
                windowManager.updateViewLayout(view2, params);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    private final int initValue(View view2, WindowManager.LayoutParams layoutParams, WindowManager windowManager) {
        Rect rect = new Rect();
        windowManager.getDefaultDisplay().getRectSize(rect);
        int i = layoutParams.x;
        if (i < rect.right - (view2.getRight() + i)) {
            return -view2.getRight();
        }
        return rect.right;
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
        ValueAnimator duration = ValueAnimator.ofInt(initValue(view2, params, windowManager), params.x).setDuration(this.mDuration);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.qn1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    DefaultFloatViewAnimator.m83enterAnim$lambda0(params, viewRef, windowManager, valueAnimator);
                }
            }
        });
        return duration;
    }

    @Override // com.baidu.searchbox.floating.animator.FloatViewAnimator
    public Animator exitAnim(final WeakReference<View> viewRef, final WindowManager.LayoutParams params, final WindowManager windowManager) {
        Intrinsics.checkNotNullParameter(viewRef, "viewRef");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(windowManager, "windowManager");
        View view2 = viewRef.get();
        if (view2 == null) {
            return null;
        }
        ValueAnimator duration = ValueAnimator.ofInt(params.x, initValue(view2, params, windowManager)).setDuration(this.mDuration);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pn1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                    DefaultFloatViewAnimator.m84exitAnim$lambda1(params, viewRef, windowManager, valueAnimator);
                }
            }
        });
        return duration;
    }
}
