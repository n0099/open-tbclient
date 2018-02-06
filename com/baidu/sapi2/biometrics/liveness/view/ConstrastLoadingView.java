package com.baidu.sapi2.biometrics.liveness.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes2.dex */
public class ConstrastLoadingView extends LinearLayout {
    private ViewSwitcher a;
    private ImageView b;
    private ImageView c;
    private ImageView d;
    private TextView e;
    private ImageView f;

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    public ConstrastLoadingView(Context context) {
        super(context);
        a(context);
    }

    public ConstrastLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_sapi_liveness_constrast_loading, this);
        this.a = (ViewSwitcher) findViewById(R.id.view_switcher);
        this.b = (ImageView) findViewById(R.id.iv_recog_circle);
        this.c = (ImageView) findViewById(R.id.iv_recog_loading);
        this.d = (ImageView) findViewById(R.id.iv_recog_logo);
        this.e = (TextView) findViewById(R.id.tv_recog_text);
        this.f = (ImageView) findViewById(R.id.iv_liveness_recog_ok);
        this.a.setDisplayedChild(1);
        a();
    }

    private RotateAnimation a(long j) {
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setDuration(j);
        rotateAnimation.setInterpolator(linearInterpolator);
        return rotateAnimation;
    }

    private void a() {
        this.b.startAnimation(a(1800L));
        this.c.startAnimation(a(1200L));
    }

    public void clearAnim() {
        this.b.clearAnimation();
        this.c.clearAnimation();
        clearAnimation();
        setVisibility(4);
    }

    public void setVisible(int i) {
        setVisibility(i);
        this.a.setDisplayedChild(1);
        a();
    }

    public void startRecogSuccessAnim(final a aVar) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300L);
        this.b.startAnimation(alphaAnimation);
        this.d.startAnimation(alphaAnimation);
        this.e.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.sapi2.biometrics.liveness.view.ConstrastLoadingView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ConstrastLoadingView.this.a.setDisplayedChild(0);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setDuration(300L);
                ConstrastLoadingView.this.f.startAnimation(alphaAnimation2);
                alphaAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.sapi2.biometrics.liveness.view.ConstrastLoadingView.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        aVar.a();
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }
                });
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation2.setDuration(300L);
        this.c.startAnimation(alphaAnimation2);
    }

    public void setRecogTextViewTxt(CharSequence charSequence) {
        this.e.setText(charSequence);
    }
}
