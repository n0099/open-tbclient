package com.baidu.swan.apps.aq;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
/* loaded from: classes11.dex */
public class e {
    public static void a(com.baidu.swan.apps.core.d.e eVar, Context context) {
        final View view;
        if (eVar != null && eVar.ZY() >= 2) {
            com.baidu.swan.apps.core.d.b eX = eVar.eX(eVar.ZY() - 2);
            float displayWidth = ag.getDisplayWidth(context) >> 2;
            if (eX != null && (view = eX.getView()) != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, -displayWidth);
                ofFloat.setDuration(300L).start();
                ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.aq.e.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        view.setTranslationX(0.0f);
                    }
                });
            }
        }
    }

    public static void b(com.baidu.swan.apps.core.d.e eVar, Context context) {
        a(eVar, context, 2);
    }

    public static void a(com.baidu.swan.apps.core.d.e eVar, Context context, int i) {
        View view;
        if (eVar != null && eVar.ZY() >= i) {
            com.baidu.swan.apps.core.d.b eX = eVar.eX(eVar.ZY() - i);
            float displayWidth = ag.getDisplayWidth(context) >> 2;
            if (eX != null && (view = eX.getView()) != null) {
                ObjectAnimator.ofFloat(view, "translationX", -displayWidth, 0.0f).setDuration(300L).start();
            }
        }
    }
}
