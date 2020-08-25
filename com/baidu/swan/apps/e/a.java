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
/* loaded from: classes8.dex */
public class a {
    private List<AnimatorSet> bUb = new CopyOnWriteArrayList();

    private ObjectAnimator a(SwanAppActivity swanAppActivity, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.XT().ddy, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(j);
        return ofFloat;
    }

    private AnimatorSet e(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.XT().ddA, "translationX", 0.0f, -ah.dip2px(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(240L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.XT().ddB, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(240L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        return animatorSet;
    }

    private AnimatorSet f(SwanAppActivity swanAppActivity) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swanAppActivity.XT().ddA, "translationX", -ah.dip2px(AppRuntime.getAppContext(), 9.5f), ah.dip2px(AppRuntime.getAppContext(), 9.5f));
        ofFloat.setDuration(380L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swanAppActivity.XT().ddB, "translationX", 0.0f, -ah.dip2px(AppRuntime.getAppContext(), 19.0f));
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
        i.avS().f(new UbcFlowEvent("first_anim_start"));
        com.baidu.swan.apps.ak.a.aCf().re("first_anim_start");
        this.bUb.add(animatorSet);
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
        c XT;
        if (!swanAppActivity.isFinishing() && (XT = swanAppActivity.XT()) != null) {
            XT.ddy.setVisibility(8);
            if (!com.baidu.swan.apps.t.a.aoM().YR()) {
                if (this.bUb != null) {
                    for (AnimatorSet animatorSet : this.bUb) {
                        animatorSet.cancel();
                    }
                }
                swanAppActivity.XS().reset();
                return;
            }
            ak.m(new Runnable() { // from class: com.baidu.swan.apps.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!swanAppActivity.isFinishing()) {
                        if (a.this.bUb != null) {
                            for (AnimatorSet animatorSet2 : a.this.bUb) {
                                animatorSet2.cancel();
                            }
                        }
                        swanAppActivity.XS().reset();
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
                    swanAppActivity.XT().aFY();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!swanAppActivity.isFinishing()) {
                    swanAppActivity.XT().ddy.setVisibility(8);
                    swanAppActivity.XT().abG();
                    swanAppActivity.XS().reset();
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
        this.bUb.add(animatorSet);
    }

    public void abG() {
        for (AnimatorSet animatorSet : this.bUb) {
            animatorSet.removeAllListeners();
            animatorSet.cancel();
        }
        this.bUb.clear();
    }
}
