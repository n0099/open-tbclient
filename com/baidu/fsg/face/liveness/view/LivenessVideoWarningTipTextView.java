package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.baidu.sapi2.biometrics.liveness.R;
/* loaded from: classes16.dex */
public class LivenessVideoWarningTipTextView extends TextView {
    private boolean a;

    /* loaded from: classes16.dex */
    public interface a {
        void a();

        void b();
    }

    public LivenessVideoWarningTipTextView(Context context) {
        super(context);
    }

    public LivenessVideoWarningTipTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void startTranslateAnim(final a aVar) {
        final int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.liveness_video_warning_toast_margintop_afteranim) - getResources().getDimensionPixelOffset(R.dimen.liveness_video_warning_toast_originmargintop);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, dimensionPixelOffset);
        translateAnimation.setDuration(300L);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoWarningTipTextView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (aVar != null) {
                    aVar.a();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (aVar != null) {
                    aVar.b();
                }
                LivenessVideoWarningTipTextView.this.clearAnimation();
                LivenessVideoWarningTipTextView.this.setTranslationY(dimensionPixelOffset);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new LinearInterpolator());
        startAnimation(translateAnimation);
    }

    public void startVisibleAnim() {
        if (!this.a && getVisibility() != 0) {
            setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            alphaAnimation.setDuration(300L);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoWarningTipTextView.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    LivenessVideoWarningTipTextView.this.a = true;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    LivenessVideoWarningTipTextView.this.clearAnimation();
                    LivenessVideoWarningTipTextView.this.a = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            startAnimation(alphaAnimation);
        }
    }

    public void startInvisibleAnim() {
        if (!this.a && getVisibility() == 0) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            alphaAnimation.setDuration(300L);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.fsg.face.liveness.view.LivenessVideoWarningTipTextView.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    LivenessVideoWarningTipTextView.this.a = true;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    LivenessVideoWarningTipTextView.this.setVisibility(4);
                    LivenessVideoWarningTipTextView.this.a = false;
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            startAnimation(alphaAnimation);
        }
    }
}
