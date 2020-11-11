package com.baidu.swan.apps.e;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.view.c;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class a {
    private List<AnimatorSet> cwT = new CopyOnWriteArrayList();

    private ObjectAnimator a(SwanAppActivity swanAppActivity, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.afI().dGb, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    private AnimatorSet e(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.afI().dGd, "translationX", 0.0f, -ah.dip2px(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(240L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.afI().dGe, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(240L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    private AnimatorSet f(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.afI().dGd, "translationX", -ah.dip2px(AppRuntime.getAppContext(), 9.5f), ah.dip2px(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(380L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.afI().dGe, "translationX", 0.0f, -ah.dip2px(AppRuntime.getAppContext(), 19.0f));
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
        i.aDG().f(new UbcFlowEvent("first_anim_start"));
        com.baidu.swan.apps.ak.a.aJS().sS("first_anim_start");
        this.cwT.add(animatorSet);
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
        c afI;
        if (!swanAppActivity.isFinishing() && (afI = swanAppActivity.afI()) != null) {
            afI.dGb.setVisibility(8);
            if (!com.baidu.swan.apps.t.a.awD().agG()) {
                if (this.cwT != null) {
                    for (AnimatorSet animatorSet : this.cwT) {
                        animatorSet.cancel();
                    }
                }
                swanAppActivity.afH().reset();
                return;
            }
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!swanAppActivity.isFinishing()) {
                        if (a.this.cwT != null) {
                            for (AnimatorSet animatorSet2 : a.this.cwT) {
                                animatorSet2.cancel();
                            }
                        }
                        swanAppActivity.afH().reset();
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
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.baidu.swan.apps.e.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (!swanAppActivity.isFinishing()) {
                    swanAppActivity.afI().aNL();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!swanAppActivity.isFinishing()) {
                    swanAppActivity.afI().dGb.setVisibility(8);
                    swanAppActivity.afI().ajv();
                    swanAppActivity.afH().reset();
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
        this.cwT.add(animatorSet);
    }

    public void ajv() {
        for (AnimatorSet animatorSet : this.cwT) {
            animatorSet.removeAllListeners();
            animatorSet.cancel();
        }
        this.cwT.clear();
    }
}
