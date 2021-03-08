package com.baidu.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes10.dex */
public class TopTipAnimationView extends TextView {
    private Animation bVS;
    private TranslateAnimation bVT;
    private Runnable bVU;
    private a bVV;
    private int mDuration;

    /* loaded from: classes10.dex */
    public interface a {
        void XJ();
    }

    public TopTipAnimationView(Context context) {
        super(context);
        this.mDuration = 3000;
        this.bVU = new Runnable() { // from class: com.baidu.live.view.TopTipAnimationView.1
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
        this.bVU = new Runnable() { // from class: com.baidu.live.view.TopTipAnimationView.1
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
        this.bVU = new Runnable() { // from class: com.baidu.live.view.TopTipAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                TopTipAnimationView.this.hideTip();
            }
        };
        init();
    }

    private void init() {
        int i;
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds86);
        int dimensionPixelOffset2 = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds28);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            dimensionPixelOffset += UtilHelper.getStatusBarHeight();
            i = UtilHelper.getStatusBarHeight() + dimensionPixelOffset2;
        } else {
            i = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = getContext().getResources().getDimensionPixelOffset(a.d.sdk_ds34);
        setPadding(i, dimensionPixelOffset3, dimensionPixelOffset2, dimensionPixelOffset3);
        this.bVT = new TranslateAnimation(0.0f, 0.0f, 0 - dimensionPixelOffset, 0.0f);
        this.bVS = new TranslateAnimation(0.0f, 0.0f, 0.0f, 0 - dimensionPixelOffset);
        setTextSize(0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds28));
        this.bVS.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.view.TopTipAnimationView.2
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
                if (TopTipAnimationView.this.bVV != null) {
                    TopTipAnimationView.this.bVV.XJ();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.bVT.setDuration(400L);
        this.bVT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.view.TopTipAnimationView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TopTipAnimationView.this.postDelayed(TopTipAnimationView.this.bVU, TopTipAnimationView.this.mDuration);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideTip() {
        removeCallbacks(this.bVU);
        if (this != null && getParent() != null) {
            startAnimation(this.bVS);
        }
    }

    public void setTipDuration(int i) {
        if (i > 0) {
            this.mDuration = i;
        }
    }

    public void onDestroy() {
        removeCallbacks(this.bVU);
    }

    public void setOnTipCompletedCallback(a aVar) {
        this.bVV = aVar;
    }
}
