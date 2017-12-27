package android.support.design.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.b.af;
import android.support.b.n;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;
/* loaded from: classes2.dex */
public class TextScale extends n {
    @Override // android.support.b.n, android.support.b.r
    public void captureStartValues(af afVar) {
        a(afVar);
    }

    @Override // android.support.b.n, android.support.b.r
    public void captureEndValues(af afVar) {
        a(afVar);
    }

    private void a(af afVar) {
        if (afVar.view instanceof TextView) {
            afVar.values.put("android:textscale:scale", Float.valueOf(((TextView) afVar.view).getScaleX()));
        }
    }

    @Override // android.support.b.n, android.support.b.r
    public Animator createAnimator(ViewGroup viewGroup, af afVar, af afVar2) {
        if (afVar == null || afVar2 == null || !(afVar.view instanceof TextView) || !(afVar2.view instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) afVar2.view;
        Map<String, Object> map = afVar.values;
        Map<String, Object> map2 = afVar2.values;
        float floatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        float floatValue2 = map2.get("android:textscale:scale") != null ? ((Float) map2.get("android:textscale:scale")).floatValue() : 1.0f;
        if (floatValue == floatValue2) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(floatValue, floatValue2);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.internal.TextScale.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(floatValue3);
                textView.setScaleY(floatValue3);
            }
        });
        return ofFloat;
    }
}
