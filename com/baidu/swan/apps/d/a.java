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
    private List<AnimatorSet> bIZ = new CopyOnWriteArrayList();

    private ObjectAnimator a(SwanAppActivity swanAppActivity, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.QD().cMl, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    private AnimatorSet d(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.QD().cMn, "translationX", 0.0f, -ag.dip2px(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(240L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.QD().cMo, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(240L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    private AnimatorSet e(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.QD().cMn, "translationX", -ag.dip2px(AppRuntime.getAppContext(), 9.5f), ag.dip2px(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(380L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.QD().cMo, "translationX", 0.0f, -ag.dip2px(AppRuntime.getAppContext(), 19.0f));
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
        g.alx().f(new UbcFlowEvent("first_anim_start"));
        com.baidu.swan.apps.al.a.aqT().oo("first_anim_start");
        this.bIZ.add(animatorSet);
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
        c QD;
        if (!swanAppActivity.isFinishing() && (QD = swanAppActivity.QD()) != null) {
            QD.cMl.setVisibility(8);
            if (!com.baidu.swan.apps.u.a.aeU().RA()) {
                if (this.bIZ != null) {
                    for (AnimatorSet animatorSet : this.bIZ) {
                        animatorSet.cancel();
                    }
                }
                swanAppActivity.QC().reset();
                return;
            }
            aj.p(new Runnable() { // from class: com.baidu.swan.apps.d.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!swanAppActivity.isFinishing()) {
                        if (a.this.bIZ != null) {
                            for (AnimatorSet animatorSet2 : a.this.bIZ) {
                                animatorSet2.cancel();
                            }
                        }
                        swanAppActivity.QC().reset();
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
                    swanAppActivity.QD().auw();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!swanAppActivity.isFinishing()) {
                    swanAppActivity.QD().cMl.setVisibility(8);
                    swanAppActivity.QD().TP();
                    swanAppActivity.QC().reset();
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
        this.bIZ.add(animatorSet);
    }

    public void TP() {
        for (AnimatorSet animatorSet : this.bIZ) {
            animatorSet.removeAllListeners();
            animatorSet.cancel();
        }
        this.bIZ.clear();
    }
}
