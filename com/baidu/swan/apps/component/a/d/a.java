package com.baidu.swan.apps.component.a.d;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.v;
import com.baidu.swan.apps.component.a.d.b;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.console.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public abstract class a<V extends View, M extends b> extends com.baidu.swan.apps.component.b.a<V, M> {
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.swan.apps.component.a.d.a<V extends android.view.View, M extends com.baidu.swan.apps.component.a.d.b> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.swan.apps.component.b.a
    protected /* bridge */ /* synthetic */ void a(@NonNull View view, @NonNull com.baidu.swan.apps.component.b.b bVar, @NonNull com.baidu.swan.apps.component.d.b bVar2) {
        a((a<V, M>) view, (View) ((b) bVar), bVar2);
    }

    public a(@Nullable Context context, @NonNull M m) {
        super(context, m);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    public com.baidu.swan.apps.component.d.b a(@NonNull M m, @NonNull M m2) {
        com.baidu.swan.apps.component.d.b a2 = super.a(m, m2);
        if (m2.cIN != null && (m.cIN == null || !TextUtils.equals(m.cIN.toString(), m2.cIN.toString()))) {
            a2.gs(4);
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull V v, @NonNull M m, @NonNull com.baidu.swan.apps.component.d.b bVar) {
        super.a((a<V, M>) v, (V) m, bVar);
        if (bVar.gt(4)) {
            b(v, m);
            a((a<V, M>) v, (V) m);
            c(v, m);
        }
    }

    protected void b(@NonNull V v, @NonNull M m) {
        if (m.cIN != null) {
            if (DEBUG) {
                Log.d("Component-View", "renderPadding");
            }
            JSONArray jSONArray = m.cIP;
            if (jSONArray != null) {
                if (jSONArray.length() == 4) {
                    v.setPadding(ah.O((float) jSONArray.optDouble(3, 0.0d)), ah.O((float) jSONArray.optDouble(0, 0.0d)), ah.O((float) jSONArray.optDouble(1, 0.0d)), ah.O((float) jSONArray.optDouble(2, 0.0d)));
                } else {
                    c.e("Component-View", "invalid padding array length: " + jSONArray.length());
                }
            }
        }
    }

    protected void a(@NonNull V v, @NonNull M m) {
        if (m.cIN != null) {
            if (DEBUG) {
                Log.d("Component-View", "renderBackground");
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(m.backgroundColor);
            gradientDrawable.setCornerRadius(m.cIO);
            gradientDrawable.setStroke(m.borderWidth, m.borderColor);
            v.setBackground(gradientDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(@NonNull View view, @NonNull M m) {
        if (m.cIN != null) {
            if (DEBUG) {
                Log.d("Component-View", "renderAlpha");
            }
            if (akz()) {
                if (DEBUG) {
                    Log.d("Component-View", "renderAlpha with animation");
                }
                if (!akB()) {
                    c.w("Component-View", "performAlphaUpdateAnimation fail");
                }
            } else if (m.aZx >= 0.0f && m.aZx <= 1.0f) {
                view.setAlpha(m.aZx);
            } else {
                c.w("Component-View", "alpha invalid: " + m.aZx);
            }
        }
    }

    public final boolean akz() {
        if (gp(4) && akK()) {
            b bVar = (b) akG();
            return (bVar.cIQ == null || TextUtils.isEmpty(bVar.cIQ.optString("duration"))) ? false : true;
        }
        return false;
    }

    public final boolean akA() {
        return eR(true);
    }

    private boolean akB() {
        return eR(false);
    }

    private boolean eR(boolean z) {
        SwanAppComponentContainerView akI = akI();
        b bVar = (b) akJ();
        b bVar2 = (b) akG();
        if (akI == null || bVar == null) {
            return false;
        }
        if (bVar2.cIQ == null || TextUtils.isEmpty(bVar2.cIQ.optString("duration"))) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add(a(akI, bVar, bVar2, false));
            arrayList.add(a(akI, bVar, bVar2, true));
        } else {
            arrayList.add(a(akI, bVar, bVar2));
        }
        AnimatorSet a2 = a(bVar2.duration, lt(bVar2.cIR), arrayList);
        if (a2 != null) {
            a2.start();
        }
        return true;
    }

    @Nullable
    private ValueAnimator a(@NonNull final SwanAppComponentContainerView swanAppComponentContainerView, @NonNull b bVar, @NonNull final b bVar2, final boolean z) {
        if (bVar.cJg == null || bVar2.cJg == null) {
            return null;
        }
        int left = z ? bVar.cJg.getLeft() : bVar.cJg.aCg();
        int left2 = z ? bVar2.cJg.getLeft() : bVar2.cJg.aCg();
        if (left != left2) {
            ValueAnimator ofInt = ValueAnimator.ofInt(left, left2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.swan.apps.component.a.d.a.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ViewGroup.LayoutParams layoutParams = swanAppComponentContainerView.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (z) {
                            marginLayoutParams.leftMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        } else {
                            marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        }
                        bVar2.cJg.ij(marginLayoutParams.leftMargin);
                        bVar2.cJg.ik(marginLayoutParams.topMargin);
                        swanAppComponentContainerView.setLayoutParams(marginLayoutParams);
                    }
                }
            });
            return ofInt;
        }
        return null;
    }

    @Nullable
    private ValueAnimator a(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull b bVar, @NonNull b bVar2) {
        if (bVar2.cIN == null) {
            return null;
        }
        float f = v.getFloat(bVar.cIN, "opacity", 1.0f);
        float f2 = v.getFloat(bVar2.cIN, "opacity", f);
        if (f == f2) {
            return null;
        }
        return ObjectAnimator.ofFloat(swanAppComponentContainerView, "alpha", f, f2);
    }

    private Interpolator lt(@NonNull String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1965120668:
                if (str.equals("ease-in")) {
                    c = 1;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c = 0;
                    break;
                }
                break;
            case -789192465:
                if (str.equals("ease-out")) {
                    c = 2;
                    break;
                }
                break;
            case -361990811:
                if (str.equals("ease-in-out")) {
                    c = 3;
                    break;
                }
                break;
            case 3105774:
                if (str.equals("ease")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return PathInterpolatorCompat.create(0.0f, 0.0f, 1.0f, 1.0f);
            case 1:
                return PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f);
            case 2:
                return PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
            case 3:
                return PathInterpolatorCompat.create(0.42f, 0.0f, 0.58f, 1.0f);
            default:
                return PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f);
        }
    }

    private AnimatorSet a(long j, @NonNull Interpolator interpolator, List<Animator> list) {
        if (j <= 0 || list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Animator animator : list) {
            if (animator != null) {
                arrayList.add(animator);
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(interpolator);
        animatorSet.setDuration(j);
        animatorSet.playTogether(arrayList);
        return animatorSet;
    }
}
