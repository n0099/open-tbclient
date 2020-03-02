package com.baidu.tbadk.core.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class NavigationBarShadowView extends View {
    private AlphaAnimation dfI;
    private AlphaAnimation dfJ;
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
            if (this.dfI == null) {
                this.dfI = new AlphaAnimation(0.0f, 1.0f);
                this.dfI.setFillAfter(true);
                this.dfI.setDuration(300L);
            }
            startAnimation(this.dfI);
        }
    }

    public void hide() {
        if (getVisibility() == 0) {
            if (this.dfJ == null) {
                this.dfJ = new AlphaAnimation(1.0f, 0.0f);
                this.dfJ.setFillAfter(true);
                this.dfJ.setDuration(300L);
                this.dfJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.core.view.NavigationBarShadowView.1
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
            startAnimation(this.dfJ);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }
}
