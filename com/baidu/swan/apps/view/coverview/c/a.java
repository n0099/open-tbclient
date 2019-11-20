package com.baidu.swan.apps.view.coverview.c;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ScrollView;
import com.baidu.swan.apps.an.o;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {
    public static boolean a(SwanAppNAViewContainer swanAppNAViewContainer, com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (swanAppNAViewContainer == null) {
            return false;
        }
        View nAView = swanAppNAViewContainer.getNAView();
        if (nAView instanceof com.baidu.swan.apps.view.coverview.subview.a) {
            com.baidu.swan.apps.view.coverview.subview.a aVar2 = (com.baidu.swan.apps.view.coverview.subview.a) nAView;
            if (aVar == null || aVar.aXr == null || !aVar.aXr.isValid()) {
                return false;
            }
            com.baidu.swan.apps.view.coverview.b.a model = aVar2.getModel();
            if (model == null || model.aXr == null || !model.aXr.isValid()) {
                return false;
            }
            com.baidu.swan.apps.view.container.c.a a = a(model, aVar);
            if ((a.Vj() & 4) == 4 && c(swanAppNAViewContainer, aVar)) {
                return true;
            }
            if ((a.Vj() & 2) == 2) {
                aVar2.a(aVar);
                aVar2.setAlpha(aVar);
            } else {
                aVar2.setModel(aVar);
            }
            if ((a.Vj() & 16) == 16) {
                return b(swanAppNAViewContainer, aVar);
            }
            if ((a.Vj() & 32) == 32 && swanAppNAViewContainer.getScrollView() != null) {
                swanAppNAViewContainer.getScrollView().smoothScrollTo(0, aVar.aXl);
            }
            return swanAppNAViewContainer.a(aVar);
        }
        return false;
    }

    private static boolean b(SwanAppNAViewContainer swanAppNAViewContainer, com.baidu.swan.apps.view.coverview.b.a aVar) {
        if (aVar == null || swanAppNAViewContainer == null || swanAppNAViewContainer.getParent() == null) {
            return false;
        }
        ScrollView scrollView = swanAppNAViewContainer.getScrollView();
        if (scrollView != null) {
            if (scrollView.getParent() == null) {
                return false;
            }
            ((ViewGroup) swanAppNAViewContainer.getParent()).removeView(swanAppNAViewContainer);
            ((ViewGroup) scrollView.getParent()).removeView(scrollView);
            swanAppNAViewContainer.setScrollView(null);
        } else {
            ((ViewGroup) swanAppNAViewContainer.getParent()).removeView(swanAppNAViewContainer);
        }
        swanAppNAViewContainer.b(aVar);
        return swanAppNAViewContainer.Vb();
    }

    @NonNull
    public static com.baidu.swan.apps.view.container.c.a a(com.baidu.swan.apps.view.coverview.b.a aVar, com.baidu.swan.apps.view.coverview.b.a aVar2) {
        com.baidu.swan.apps.view.container.c.a aVar3 = new com.baidu.swan.apps.view.container.c.a();
        if (aVar != aVar2) {
            if (aVar != null && aVar2 != null) {
                aVar.a(aVar2, aVar3);
            } else {
                aVar3.fG(63);
            }
        }
        return aVar3;
    }

    private static boolean c(@NonNull SwanAppNAViewContainer swanAppNAViewContainer, @NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        long j;
        if (aVar.bvm == null || TextUtils.isEmpty(aVar.bvm.optString("duration"))) {
            return false;
        }
        View nAView = swanAppNAViewContainer.getNAView();
        if (nAView == null || !(nAView instanceof com.baidu.swan.apps.view.coverview.subview.a)) {
            return false;
        }
        com.baidu.swan.apps.view.coverview.subview.a aVar2 = (com.baidu.swan.apps.view.coverview.subview.a) nAView;
        ValueAnimator a = a(swanAppNAViewContainer, aVar, false);
        ValueAnimator a2 = a(swanAppNAViewContainer, aVar, true);
        ValueAnimator d = d(swanAppNAViewContainer, aVar);
        try {
            j = Long.parseLong(aVar.bvm.optString("duration"));
        } catch (Exception e) {
            j = 0;
        }
        Interpolator jj = com.baidu.swan.apps.view.coverview.b.a.jj(aVar.bvm.optString("easing"));
        aVar2.a(aVar);
        swanAppNAViewContainer.b(aVar);
        AnimatorSet a3 = a(swanAppNAViewContainer, aVar, j, jj, a, a2, d);
        if (a3 != null) {
            a3.start();
        }
        return true;
    }

    private static ValueAnimator a(@NonNull final SwanAppNAViewContainer swanAppNAViewContainer, @NonNull com.baidu.swan.apps.view.coverview.b.a aVar, final boolean z) {
        com.baidu.swan.apps.view.coverview.b.a model;
        ValueAnimator valueAnimator;
        View nAView = swanAppNAViewContainer.getNAView();
        if (nAView == null || !(nAView instanceof com.baidu.swan.apps.view.coverview.subview.a) || (model = ((com.baidu.swan.apps.view.coverview.subview.a) nAView).getModel()) == null) {
            return null;
        }
        int left = z ? model.aXr.getLeft() : model.aXr.Mu();
        int left2 = z ? aVar.aXr.getLeft() : aVar.aXr.Mu();
        if (left != left2) {
            valueAnimator = ValueAnimator.ofInt(left, left2);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.view.coverview.c.a.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    if (SwanAppNAViewContainer.this != null) {
                        ViewGroup.LayoutParams layoutParams = SwanAppNAViewContainer.this.getLayoutParams();
                        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                            if (z) {
                                marginLayoutParams.leftMargin = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                            } else {
                                marginLayoutParams.topMargin = ((Integer) valueAnimator2.getAnimatedValue()).intValue();
                            }
                            SwanAppNAViewContainer.this.a(marginLayoutParams);
                        }
                    }
                }
            });
        } else {
            valueAnimator = null;
        }
        return valueAnimator;
    }

    private static ValueAnimator d(@NonNull SwanAppNAViewContainer swanAppNAViewContainer, @NonNull com.baidu.swan.apps.view.coverview.b.a aVar) {
        com.baidu.swan.apps.view.coverview.b.a model;
        ObjectAnimator objectAnimator;
        View nAView = swanAppNAViewContainer.getNAView();
        if (nAView == null || !(nAView instanceof com.baidu.swan.apps.view.coverview.subview.a) || (model = ((com.baidu.swan.apps.view.coverview.subview.a) nAView).getModel()) == null) {
            return null;
        }
        if (aVar.aEB != null) {
            float a = o.a(model.aEB, "opacity", 1.0f);
            float a2 = o.a(aVar.aEB, "opacity", a);
            if (a != a2) {
                objectAnimator = ObjectAnimator.ofFloat(swanAppNAViewContainer, "alpha", a, a2);
                return objectAnimator;
            }
        }
        objectAnimator = null;
        return objectAnimator;
    }

    private static AnimatorSet a(SwanAppNAViewContainer swanAppNAViewContainer, com.baidu.swan.apps.view.coverview.b.a aVar, long j, @NonNull Interpolator interpolator, ValueAnimator... valueAnimatorArr) {
        if (j <= 0 || valueAnimatorArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            if (valueAnimator != null) {
                arrayList.add(valueAnimator);
            }
        }
        if (arrayList.size() != 0) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setInterpolator(interpolator);
            animatorSet.setDuration(j);
            animatorSet.playTogether(arrayList);
            return animatorSet;
        }
        return null;
    }
}
