package com.baidu.pass.biometrics.face.liveness.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.pass.biometrics.face.R;
/* loaded from: classes6.dex */
public class ConstrastLoadingView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f4047a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f4048b;

    public ConstrastLoadingView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_pass_liveness_constrast_loading, this);
        this.f4047a = (ImageView) findViewById(R.id.iv_recog_circle);
        this.f4048b = (ImageView) findViewById(R.id.iv_recog_logo);
        b();
    }

    private void b() {
        this.f4047a.startAnimation(a(true, 1200L));
    }

    public void setVisible(int i) {
        setVisibility(i);
        b();
    }

    public ConstrastLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private RotateAnimation a(boolean z, long j) {
        RotateAnimation rotateAnimation;
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        if (z) {
            rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        } else {
            rotateAnimation = new RotateAnimation(0.0f, -359.0f, 1, 0.5f, 1, 0.5f);
        }
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setDuration(j);
        rotateAnimation.setInterpolator(linearInterpolator);
        return rotateAnimation;
    }

    public void a() {
        this.f4047a.clearAnimation();
        clearAnimation();
        setVisibility(4);
    }
}
