package com.baidu.tbadk.core.view.viewpager;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
class e implements ViewPager.OnPageChangeListener {
    final /* synthetic */ c ans;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.ans = cVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        b bVar;
        ViewPager viewPager;
        ViewPager viewPager2;
        ViewPager viewPager3;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.ans.ano;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.ans.ano;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
        if (i == 1) {
            this.ans.wO();
        } else if (i == 0) {
            bVar = this.ans.ani;
            int count = bVar.getCount();
            if (count >= 2) {
                viewPager = this.ans.mViewPager;
                int currentItem = viewPager.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    viewPager3 = this.ans.mViewPager;
                    viewPager3.setCurrentItem(i2, false);
                } else if (currentItem > i2) {
                    viewPager2 = this.ans.mViewPager;
                    viewPager2.setCurrentItem(1, false);
                }
                this.ans.wN();
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.ans.ano;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.ans.ano;
            onPageChangeListener2.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        g gVar;
        g gVar2;
        IndicatorView indicatorView;
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        g gVar3;
        IndicatorView indicatorView2;
        g gVar4;
        gVar = this.ans.anj;
        if (gVar != null) {
            gVar2 = this.ans.anj;
            if (gVar2.dr(i) == i) {
                indicatorView = this.ans.ang;
                if (indicatorView != null) {
                    indicatorView2 = this.ans.ang;
                    gVar4 = this.ans.anj;
                    indicatorView2.setPosition(gVar4.ds(i));
                }
                onPageChangeListener = this.ans.ano;
                if (onPageChangeListener != null) {
                    onPageChangeListener2 = this.ans.ano;
                    gVar3 = this.ans.anj;
                    onPageChangeListener2.onPageSelected(gVar3.ds(i));
                }
            }
        }
    }
}
