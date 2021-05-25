package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes2.dex */
public class LivenessVideoWarningTipTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    public boolean f6070a;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b();
    }

    public LivenessVideoWarningTipTextView(Context context) {
        super(context);
    }

    public void startInvisibleAnim() {
        if (this.f6070a || getVisibility() != 0) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setDuration(300L);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoWarningTipTextView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LivenessVideoWarningTipTextView.this.setVisibility(4);
                LivenessVideoWarningTipTextView.this.f6070a = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                LivenessVideoWarningTipTextView.this.f6070a = true;
            }
        });
        startAnimation(alphaAnimation);
    }

    public void startTranslateAnim(final a aVar) {
        final int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.liveness_video_warning_toast_margintop_afteranim) - getResources().getDimensionPixelOffset(R.dimen.liveness_video_warning_toast_originmargintop);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, dimensionPixelOffset);
        translateAnimation.setDuration(300L);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoWarningTipTextView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b();
                }
                LivenessVideoWarningTipTextView.this.clearAnimation();
                LivenessVideoWarningTipTextView.this.setTranslationY(dimensionPixelOffset);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }
        });
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new LinearInterpolator());
        startAnimation(translateAnimation);
    }

    public void startVisibleAnim() {
        if (this.f6070a || getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setDuration(300L);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoWarningTipTextView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                LivenessVideoWarningTipTextView.this.clearAnimation();
                LivenessVideoWarningTipTextView.this.f6070a = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                LivenessVideoWarningTipTextView.this.f6070a = true;
            }
        });
        startAnimation(alphaAnimation);
    }

    public LivenessVideoWarningTipTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
