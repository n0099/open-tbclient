package com.baidu.swan.apps.as;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
/* loaded from: classes11.dex */
public class d {
    public static void a(com.baidu.swan.apps.core.d.e eVar, Context context) {
        final View view;
        if (eVar != null && eVar.Ot() >= 2) {
            com.baidu.swan.apps.core.d.b ew = eVar.ew(eVar.Ot() - 2);
            float displayWidth = af.getDisplayWidth(context) >> 2;
            if (ew != null && (view = ew.getView()) != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", 0.0f, -displayWidth);
                ofFloat.setDuration(300L).start();
                ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.swan.apps.as.d.1
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
        if (eVar != null && eVar.Ot() >= i) {
            com.baidu.swan.apps.core.d.b ew = eVar.ew(eVar.Ot() - i);
            float displayWidth = af.getDisplayWidth(context) >> 2;
            if (ew != null && (view = ew.getView()) != null) {
                ObjectAnimator.ofFloat(view, "translationX", -displayWidth, 0.0f).setDuration(300L).start();
            }
        }
    }
}
