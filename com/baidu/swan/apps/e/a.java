package com.baidu.swan.apps.e;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.f;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class a {
    private List<AnimatorSet> ake = new CopyOnWriteArrayList();

    private ObjectAnimator a(SwanAppActivity swanAppActivity, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.uv().aYu, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    private AnimatorSet a(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.uv().aYv, "translationX", 0.0f, -x.dip2px(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(240L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.uv().aYw, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(240L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    private AnimatorSet b(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.uv().aYv, "translationX", -x.dip2px(AppRuntime.getAppContext(), 9.5f), x.dip2px(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(380L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.uv().aYw, "translationX", 0.0f, -x.dip2px(AppRuntime.getAppContext(), 19.0f));
        ofFloat2.setDuration(380L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    public void c(SwanAppActivity swanAppActivity) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(a(swanAppActivity)).before(b(swanAppActivity));
        animatorSet.start();
        f.FQ().f(new UbcFlowEvent("first_anim_start"));
        com.baidu.swan.apps.y.f.EP().fm("first_anim_start");
        this.ake.add(animatorSet);
    }

    public void a(SwanAppActivity swanAppActivity, int i) {
        switch (i) {
            case 1:
                d(swanAppActivity);
                return;
            case 2:
                a(swanAppActivity, false);
                return;
            case 3:
                a(swanAppActivity, true);
                return;
            default:
                d(swanAppActivity);
                return;
        }
    }

    private void d(final SwanAppActivity swanAppActivity) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(e(swanAppActivity));
        animatorSet.start();
        f.FQ().f(new UbcFlowEvent("second_anim_start"));
        com.baidu.swan.apps.y.f.EP().fm("second_anim_start");
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.e.a.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.FQ().f(new UbcFlowEvent("second_anim_end")).Fv();
                com.baidu.swan.apps.y.f.EP().fm("second_anim_end");
                if (!swanAppActivity.isFinishing()) {
                    swanAppActivity.uv().aYu.setVisibility(8);
                    swanAppActivity.uu().reset();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ake.add(animatorSet);
    }

    private void a(final SwanAppActivity swanAppActivity, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        int i = 760;
        if (z) {
            i = 1060;
        }
        animatorSet.play(a(swanAppActivity, 300L));
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.e.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!swanAppActivity.isFinishing()) {
                    swanAppActivity.uv().aYu.setVisibility(8);
                    swanAppActivity.uu().reset();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.setStartDelay(i);
        animatorSet.start();
        this.ake.add(animatorSet);
    }

    private ObjectAnimator e(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.uv().aYu, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(150L);
        return ofFloat;
    }

    public void wl() {
        for (AnimatorSet animatorSet : this.ake) {
            animatorSet.removeAllListeners();
            animatorSet.cancel();
        }
        this.ake.clear();
    }
}
