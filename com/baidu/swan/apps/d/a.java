package com.baidu.swan.apps.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.view.c;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class a {
    private List<AnimatorSet> bNN = new CopyOnWriteArrayList();

    private ObjectAnimator a(SwanAppActivity swanAppActivity, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.RJ().cQV, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    private AnimatorSet d(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.RJ().cQX, "translationX", 0.0f, -ag.dip2px(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(240L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.RJ().cQY, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(240L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    private AnimatorSet e(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.RJ().cQX, "translationX", -ag.dip2px(AppRuntime.getAppContext(), 9.5f), ag.dip2px(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(380L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.RJ().cQY, "translationX", 0.0f, -ag.dip2px(AppRuntime.getAppContext(), 19.0f));
        ofFloat2.setDuration(380L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    public void f(SwanAppActivity swanAppActivity) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(d(swanAppActivity)).before(e(swanAppActivity));
        animatorSet.start();
        g.amD().f(new UbcFlowEvent("first_anim_start"));
        com.baidu.swan.apps.al.a.arZ().ow("first_anim_start");
        this.bNN.add(animatorSet);
    }

    public void a(SwanAppActivity swanAppActivity, int i) {
        switch (i) {
            case 1:
                g(swanAppActivity);
                return;
            case 2:
                a(swanAppActivity, false);
                return;
            case 3:
                a(swanAppActivity, true);
                return;
            default:
                g(swanAppActivity);
                return;
        }
    }

    private void g(final SwanAppActivity swanAppActivity) {
        c RJ;
        if (!swanAppActivity.isFinishing() && (RJ = swanAppActivity.RJ()) != null) {
            RJ.cQV.setVisibility(8);
            if (!com.baidu.swan.apps.u.a.aga().SG()) {
                if (this.bNN != null) {
                    for (AnimatorSet animatorSet : this.bNN) {
                        animatorSet.cancel();
                    }
                }
                swanAppActivity.RI().reset();
                return;
            }
            aj.p(new Runnable() { // from class: com.baidu.swan.apps.d.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!swanAppActivity.isFinishing()) {
                        if (a.this.bNN != null) {
                            for (AnimatorSet animatorSet2 : a.this.bNN) {
                                animatorSet2.cancel();
                            }
                        }
                        swanAppActivity.RI().reset();
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
                    swanAppActivity.RJ().avC();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!swanAppActivity.isFinishing()) {
                    swanAppActivity.RJ().cQV.setVisibility(8);
                    swanAppActivity.RJ().UV();
                    swanAppActivity.RI().reset();
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
        this.bNN.add(animatorSet);
    }

    public void UV() {
        for (AnimatorSet animatorSet : this.bNN) {
            animatorSet.removeAllListeners();
            animatorSet.cancel();
        }
        this.bNN.clear();
    }
}
