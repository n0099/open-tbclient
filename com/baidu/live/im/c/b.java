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
/* loaded from: classes4.dex */
public class b implements com.baidu.live.n.b {
    private TextView bkf;
    private RelativeLayout boJ;
    int color = Color.parseColor("#FF4D4D");
    private String content;
    AnimatorSet mAnimatorSet;
    private Context mContext;
    private int mScreenWidth;

    public b(Context context) {
        this.mContext = context;
        this.boJ = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.g.ala_warning_broadcast_layout, (ViewGroup) null);
        this.bkf = (TextView) this.boJ.findViewById(a.f.warning_content);
        this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        NS();
    }

    private void NS() {
        this.mAnimatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.boJ, "TranslationX", this.mScreenWidth, 20.0f);
        ofFloat.setDuration(2000L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.boJ, "TranslationX", 20.0f, -this.mScreenWidth);
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
        if (this.boJ != null && this.boJ.getParent() != null) {
            this.boJ.clearAnimation();
            ((ViewGroup) this.boJ.getParent()).removeView(this.boJ);
        }
    }

    @Override // com.baidu.live.n.b
    public View NT() {
        return this.boJ;
    }

    @Override // com.baidu.live.n.b
    public void ih(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.content = str;
            this.bkf.setText(this.content);
            this.mAnimatorSet.start();
        }
    }
}
