package com.baidu.searchbox.floating.animator;

import android.animation.Animator;
import android.view.View;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J/\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\f\u001a\u0004\u0018\u00010\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/floating/animator/FloatViewAnimator;", "Lkotlin/Any;", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "viewRef", "Landroid/view/WindowManager$LayoutParams;", "params", "Landroid/view/WindowManager;", "windowManager", "Landroid/animation/Animator;", "enterAnim", "(Ljava/lang/ref/WeakReference;Landroid/view/WindowManager$LayoutParams;Landroid/view/WindowManager;)Landroid/animation/Animator;", "exitAnim", "lib-player-floating_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public interface FloatViewAnimator {
    Animator enterAnim(WeakReference<View> weakReference, WindowManager.LayoutParams layoutParams, WindowManager windowManager);

    Animator exitAnim(WeakReference<View> weakReference, WindowManager.LayoutParams layoutParams, WindowManager windowManager);
}
