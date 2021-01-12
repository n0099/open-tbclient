package com.baidu.live.im.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class b implements com.baidu.live.o.b {
    private TextView bgU;
    private RelativeLayout blF;
    int color = Color.parseColor("#FF4D4D");
    private String content;
    AnimatorSet mAnimatorSet;
    private Context mContext;
    private int mScreenWidth;

    public b(Context context) {
        this.mContext = context;
        this.blF = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.g.ala_warning_broadcast_layout, (ViewGroup) null);
        this.bgU = (TextView) this.blF.findViewById(a.f.warning_content);
        this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        Jz();
    }

    private void Jz() {
        this.mAnimatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.blF, "TranslationX", this.mScreenWidth, 20.0f);
        ofFloat.setDuration(2000L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.blF, "TranslationX", 20.0f, -this.mScreenWidth);
        ofFloat2.setDuration(750L);
        ofFloat2.setInterpolator(new AccelerateInterpolator());
        this.mAnimatorSet.play(ofFloat2).after(6000L).after(ofFloat);
        this.mAnimatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.live.im.c.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.onDestroy();
            }
        });
    }

    public void onDestroy() {
        if (this.blF != null && this.blF.getParent() != null) {
            this.blF.clearAnimation();
            ((ViewGroup) this.blF.getParent()).removeView(this.blF);
        }
    }

    @Override // com.baidu.live.o.b
    public View JA() {
        return this.blF;
    }

    @Override // com.baidu.live.o.b
    public void gH(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.content = str;
            this.bgU.setText(this.content);
            this.mAnimatorSet.start();
        }
    }
}
