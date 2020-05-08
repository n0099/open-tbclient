package com.baidu.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class TopTipAnimationView extends TextView {
    private Animation bbI;
    private TranslateAnimation bbJ;
    private Runnable bbK;
    private a bbL;
    private int mDuration;

    /* loaded from: classes3.dex */
    public interface a {
        void HD();
    }

    public TopTipAnimationView(Context context) {
        super(context);
        this.mDuration = 3000;
        this.bbK = new Runnable() { // from class: com.baidu.live.view.TopTipAnimationView.1
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
        this.bbK = new Runnable() { // from class: com.baidu.live.view.TopTipAnimationView.1
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
        this.bbK = new Runnable() { // from class: com.baidu.live.view.TopTipAnimationView.1
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
        this.bbJ = new TranslateAnimation(0.0f, 0.0f, 0 - i, 0.0f);
        this.bbI = new TranslateAnimation(0.0f, 0.0f, 0.0f, 0 - i);
        setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds28));
        this.bbI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.view.TopTipAnimationView.2
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
                if (TopTipAnimationView.this.bbL != null) {
                    TopTipAnimationView.this.bbL.HD();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.bbJ.setDuration(400L);
        this.bbJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.view.TopTipAnimationView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TopTipAnimationView.this.postDelayed(TopTipAnimationView.this.bbK, TopTipAnimationView.this.mDuration);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        removeCallbacks(this.bbK);
        if (this != null && getParent() != null) {
            startAnimation(this.bbI);
        }
    }

    public void setTipDuration(int i) {
        if (i > 0) {
            this.mDuration = i;
        }
    }

    public void onDestroy() {
        removeCallbacks(this.bbK);
    }

    public void setOnTipCompletedCallback(a aVar) {
        this.bbL = aVar;
    }
}
