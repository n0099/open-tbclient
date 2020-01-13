package com.baidu.swan.apps.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.f;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class a {
    private List<AnimatorSet> aYn = new CopyOnWriteArrayList();

    private ObjectAnimator a(SwanAppActivity swanAppActivity, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.Eh().bVS, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    private AnimatorSet e(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.Eh().bVU, "translationX", 0.0f, -af.dip2px(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(240L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.Eh().bVV, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(240L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    private AnimatorSet f(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.Eh().bVU, "translationX", -af.dip2px(AppRuntime.getAppContext(), 9.5f), af.dip2px(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(380L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.Eh().bVV, "translationX", 0.0f, -af.dip2px(AppRuntime.getAppContext(), 19.0f));
        ofFloat2.setDuration(380L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    public void g(SwanAppActivity swanAppActivity) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(e(swanAppActivity)).before(f(swanAppActivity));
        animatorSet.start();
        f.XF().f(new UbcFlowEvent("first_anim_start"));
        com.baidu.swan.apps.an.a.acr().ln("first_anim_start");
        this.aYn.add(animatorSet);
    }

    public void a(SwanAppActivity swanAppActivity, int i) {
        switch (i) {
            case 1:
                h(swanAppActivity);
                return;
            case 2:
                a(swanAppActivity, false);
                return;
            case 3:
                a(swanAppActivity, true);
                return;
            default:
                h(swanAppActivity);
                return;
        }
    }

    private void h(final SwanAppActivity swanAppActivity) {
        f.XF().f(new UbcFlowEvent("second_anim_start"));
        com.baidu.swan.apps.an.a.acr().ln("second_anim_start");
        f.XF().f(new UbcFlowEvent("second_anim_end")).Xl();
        com.baidu.swan.apps.an.a.acr().ln("second_anim_end");
        if (!swanAppActivity.isFinishing()) {
            swanAppActivity.Eh().bVS.setVisibility(8);
            if (!com.baidu.swan.apps.w.a.RJ().Fg()) {
                if (this.aYn != null) {
                    for (AnimatorSet animatorSet : this.aYn) {
                        animatorSet.cancel();
                    }
                }
                swanAppActivity.Eg().reset();
                return;
            }
            ai.l(new Runnable() { // from class: com.baidu.swan.apps.d.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!swanAppActivity.isFinishing()) {
                        if (a.this.aYn != null) {
                            for (AnimatorSet animatorSet2 : a.this.aYn) {
                                animatorSet2.cancel();
                            }
                        }
                        swanAppActivity.Eg().reset();
                    }
                }
            });
        }
    }

    private void a(final SwanAppActivity swanAppActivity, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        int i = 0;
        if (z) {
            i = 100;
        }
        animatorSet.play(a(swanAppActivity, 150L));
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.d.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (!swanAppActivity.isFinishing()) {
                    swanAppActivity.Eh().afp();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!swanAppActivity.isFinishing()) {
                    swanAppActivity.Eh().bVS.setVisibility(8);
                    swanAppActivity.Eh().Hk();
                    swanAppActivity.Eg().reset();
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
        this.aYn.add(animatorSet);
    }

    public void Hk() {
        for (AnimatorSet animatorSet : this.aYn) {
            animatorSet.removeAllListeners();
            animatorSet.cancel();
        }
        this.aYn.clear();
    }
}
