package com.baidu.searchbox.lottie;

import android.animation.Animator;
import android.app.Activity;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.e;
import com.airbnb.lottie.n;
import java.lang.ref.WeakReference;
/* loaded from: classes19.dex */
public class LottieManager {
    public static void showLottieWindow(WeakReference<Activity> weakReference, String str, int i) {
        Activity activity;
        if (weakReference != null && (activity = weakReference.get()) != null && !TextUtils.isEmpty(str)) {
            final LottieAnimationView lottieAnimationView = new LottieAnimationView(activity);
            lottieAnimationView.setBackgroundResource(i);
            final ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            viewGroup.addView(lottieAnimationView, layoutParams);
            lottieAnimationView.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.searchbox.lottie.LottieManager.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
            lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() { // from class: com.baidu.searchbox.lottie.LottieManager.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    viewGroup.removeView(lottieAnimationView);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            e.a.a(activity, str, new n() { // from class: com.baidu.searchbox.lottie.LottieManager.3
                @Override // com.airbnb.lottie.n
                public void onCompositionLoaded(@Nullable e eVar) {
                    if (eVar == null) {
                        viewGroup.removeView(lottieAnimationView);
                        return;
                    }
                    lottieAnimationView.setComposition(eVar);
                    lottieAnimationView.useHardwareAcceleration(true);
                    lottieAnimationView.playAnimation();
                }
            });
        }
    }
}
