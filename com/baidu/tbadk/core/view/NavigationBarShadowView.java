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
    private AlphaAnimation fiZ;
    private AlphaAnimation fja;
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
            if (this.fiZ == null) {
                this.fiZ = new AlphaAnimation(0.0f, 1.0f);
                this.fiZ.setFillAfter(true);
                this.fiZ.setDuration(300L);
            }
            startAnimation(this.fiZ);
        }
    }

    public void hide() {
        if (getVisibility() == 0) {
            if (this.fja == null) {
                this.fja = new AlphaAnimation(1.0f, 0.0f);
                this.fja.setFillAfter(true);
                this.fja.setDuration(300L);
                this.fja.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tbadk.core.view.NavigationBarShadowView.1
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
            startAnimation(this.fja);
        }
    }

    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this, R.drawable.personalize_tab_shadow);
            this.mSkinType = i;
        }
    }
}
