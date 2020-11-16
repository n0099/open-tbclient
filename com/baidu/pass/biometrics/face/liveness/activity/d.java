package com.baidu.pass.biometrics.face.liveness.activity;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.widget.TextView;
import com.baidu.pass.biometrics.face.liveness.view.XfordView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    private IntEvaluator f2733a = new IntEvaluator();
    final /* synthetic */ LivenessRecogActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(LivenessRecogActivity livenessRecogActivity) {
        this.b = livenessRecogActivity;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        TextView textView;
        XfordView xfordView;
        XfordView xfordView2;
        XfordView xfordView3;
        float intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue() / 100.0f;
        int intValue2 = this.f2733a.evaluate(intValue, (Integer) 255, (Integer) 51).intValue();
        textView = this.b.x;
        textView.setTextColor(Color.rgb(intValue2, intValue2, intValue2));
        int intValue3 = this.f2733a.evaluate(intValue, (Integer) 0, (Integer) 255).intValue();
        int intValue4 = this.f2733a.evaluate(intValue, (Integer) 66, (Integer) 255).intValue();
        xfordView = this.b.E;
        if (xfordView != null) {
            xfordView2 = this.b.E;
            xfordView2.setBgPaintColor(Color.argb(intValue4, intValue3, intValue3, intValue3));
            xfordView3 = this.b.E;
            xfordView3.postInvalidate();
        }
    }
}
