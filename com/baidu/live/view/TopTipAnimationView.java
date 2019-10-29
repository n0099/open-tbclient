package com.baidu.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes6.dex */
public class TopTipAnimationView extends TextView {
    private Animation atc;
    private TranslateAnimation atd;
    private Runnable ate;
    private a atf;
    private int mDuration;

    /* loaded from: classes6.dex */
    public interface a {
        void wH();
    }

    public TopTipAnimationView(Context context) {
        super(context);
        this.mDuration = 3000;
        this.ate = new Runnable() { // from class: com.baidu.live.view.TopTipAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                TopTipAnimationView.this.hideTip();
            }
        };
        init();
    }

    public TopTipAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDuration = 3000;
        this.ate = new Runnable() { // from class: com.baidu.live.view.TopTipAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                TopTipAnimationView.this.hideTip();
            }
        };
        init();
    }

    public TopTipAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDuration = 3000;
        this.ate = new Runnable() { // from class: com.baidu.live.view.TopTipAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                TopTipAnimationView.this.hideTip();
            }
        };
        init();
    }

    private void init() {
        int i;
        int i2;
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds86);
        int dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds28);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            i = UtilHelper.getStatusBarHeight() + dimensionPixelOffset;
            i2 = UtilHelper.getStatusBarHeight() + dimensionPixelOffset2;
        } else {
            i = dimensionPixelOffset;
            i2 = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = getContext().getResources().getDimensionPixelOffset(a.e.sdk_ds34);
        setPadding(i2, dimensionPixelOffset3, dimensionPixelOffset2, dimensionPixelOffset3);
        this.atd = new TranslateAnimation(0.0f, 0.0f, 0 - i, 0.0f);
        this.atc = new TranslateAnimation(0.0f, 0.0f, 0.0f, 0 - i);
        setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.atc.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.view.TopTipAnimationView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TopTipAnimationView.this.onDestroy();
                ViewGroup viewGroup = (ViewGroup) TopTipAnimationView.this.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(TopTipAnimationView.this);
                }
                if (TopTipAnimationView.this.atf != null) {
                    TopTipAnimationView.this.atf.wH();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.atd.setDuration(400L);
        this.atd.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.view.TopTipAnimationView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TopTipAnimationView.this.postDelayed(TopTipAnimationView.this.ate, TopTipAnimationView.this.mDuration);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        removeCallbacks(this.ate);
        if (this != null && getParent() != null) {
            startAnimation(this.atc);
        }
    }

    public void setTipDuration(int i) {
        if (i > 0) {
            this.mDuration = i;
        }
    }

    public void onDestroy() {
        removeCallbacks(this.ate);
    }

    public void setOnTipCompletedCallback(a aVar) {
        this.atf = aVar;
    }
}
