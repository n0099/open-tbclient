package com.baidu.tbadk.browser;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class c extends Animation implements Animation.AnimationListener {
    final /* synthetic */ GameWebViewActivity a;
    private View b;
    private boolean c;
    private int d;
    private int e;

    public c(GameWebViewActivity gameWebViewActivity, View view, boolean z) {
        this.a = gameWebViewActivity;
        this.b = view;
        this.c = z;
        setDuration(300L);
        setAnimationListener(this);
        view.measure(0, 0);
        this.d = -view.getMeasuredHeight();
        this.e = Math.abs(this.d);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        super.applyTransformation(f, transformation);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        if (this.c) {
            if (f <= 1.0f && f >= 0.0f) {
                layoutParams.setMargins(layoutParams.leftMargin, this.d + ((int) (this.e * f)), layoutParams.rightMargin, layoutParams.bottomMargin);
            }
        } else if (f <= 1.0f && f >= 0.0f) {
            layoutParams.setMargins(layoutParams.leftMargin, -((int) (this.e * f)), layoutParams.rightMargin, layoutParams.bottomMargin);
        }
        this.b.setLayoutParams(layoutParams);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.a.mNavigationBar.c(((TbadkApplication) this.a.getApplication()).getSkinType());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.a.c = this.c;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
