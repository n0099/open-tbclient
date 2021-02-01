package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NavigationBarShadowView extends View {
    private AlphaAnimation fhx;
    private AlphaAnimation fhy;
    private int mSkinType;

    public NavigationBarShadowView(Context context) {
        this(context, null);
    }

    public NavigationBarShadowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationBarShadowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        setVisibility(8);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void show() {
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (getVisibility() != 0) {
            setVisibility(0);
            if (this.fhx == null) {
                this.fhx = new AlphaAnimation(0.0f, 1.0f);
                this.fhx.setFillAfter(true);
                this.fhx.setDuration(300L);
            }
            startAnimation(this.fhx);
        }
    }

    public void hide() {
        if (getVisibility() == 0) {
            if (this.fhy == null) {
                this.fhy = new AlphaAnimation(1.0f, 0.0f);
                this.fhy.setFillAfter(true);
                this.fhy.setDuration(300L);
                this.fhy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.core.view.NavigationBarShadowView.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        NavigationBarShadowView.this.setVisibility(8);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
            }
            startAnimation(this.fhy);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }
}
