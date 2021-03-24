package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class NavigationBarShadowView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f13395e;

    /* renamed from: f  reason: collision with root package name */
    public AlphaAnimation f13396f;

    /* renamed from: g  reason: collision with root package name */
    public AlphaAnimation f13397g;

    /* loaded from: classes3.dex */
    public class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            NavigationBarShadowView.this.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public NavigationBarShadowView(Context context) {
        this(context, null);
    }

    public void a() {
        if (getVisibility() != 0) {
            return;
        }
        if (this.f13397g == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            this.f13397g = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.f13397g.setDuration(300L);
            this.f13397g.setAnimationListener(new a());
        }
        startAnimation(this.f13397g);
    }

    public void b(int i) {
        if (this.f13395e != i) {
            SkinManager.setBackgroundResource(this, R.drawable.personalize_tab_shadow);
            this.f13395e = i;
        }
    }

    public void c() {
        b(TbadkCoreApplication.getInst().getSkinType());
        if (getVisibility() == 0) {
            return;
        }
        setVisibility(0);
        if (this.f13396f == null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.f13396f = alphaAnimation;
            alphaAnimation.setFillAfter(true);
            this.f13396f.setDuration(300L);
        }
        startAnimation(this.f13396f);
    }

    public NavigationBarShadowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationBarShadowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13395e = 3;
        setVisibility(8);
        b(TbadkCoreApplication.getInst().getSkinType());
    }
}
