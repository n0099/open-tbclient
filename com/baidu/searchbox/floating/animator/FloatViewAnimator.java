package com.baidu.searchbox.floating.animator;

import android.animation.Animator;
import android.view.View;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import kotlin.h;
@h
/* loaded from: classes19.dex */
public interface FloatViewAnimator {
    Animator enterAnim(WeakReference<View> weakReference, WindowManager.LayoutParams layoutParams, WindowManager windowManager);

    Animator exitAnim(WeakReference<View> weakReference, WindowManager.LayoutParams layoutParams, WindowManager windowManager);
}
