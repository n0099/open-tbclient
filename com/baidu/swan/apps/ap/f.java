package com.baidu.swan.apps.ap;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
/* loaded from: classes8.dex */
public class f {
    public static void a(com.baidu.swan.apps.core.d.f fVar, Context context) {
        final View view;
        if (fVar != null && fVar.ahp() >= 2) {
            com.baidu.swan.apps.core.d.c gY = fVar.gY(fVar.ahp() - 2);
            float displayWidth = ah.getDisplayWidth(context) >> 2;
            if (gY != null && (view = gY.getView()) != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, -displayWidth);
                ofFloat.setDuration(300L).start();
                ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.ap.f.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        view.setTranslationX(0.0f);
                    }
                });
            }
        }
    }

    public static void b(com.baidu.swan.apps.core.d.f fVar, Context context) {
        a(fVar, context, 2);
    }

    public static void a(com.baidu.swan.apps.core.d.f fVar, Context context, int i) {
        View view;
        if (fVar != null && fVar.ahp() >= i) {
            com.baidu.swan.apps.core.d.c gY = fVar.gY(fVar.ahp() - i);
            float displayWidth = ah.getDisplayWidth(context) >> 2;
            if (gY != null && (view = gY.getView()) != null) {
                ObjectAnimator.ofFloat(view, "translationX", -displayWidth, 0.0f).setDuration(300L).start();
            }
        }
    }
}
