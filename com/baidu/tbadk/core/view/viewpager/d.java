package com.baidu.tbadk.core.view.viewpager;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ b ann;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.ann = bVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        a aVar;
        ViewPager viewPager;
        ViewPager viewPager2;
        ViewPager viewPager3;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.ann.anj;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.ann.anj;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
        if (i == 1) {
            this.ann.xA();
        } else if (i == 0) {
            aVar = this.ann.and;
            int count = aVar.getCount();
            if (count >= 2) {
                viewPager = this.ann.mViewPager;
                int currentItem = viewPager.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    viewPager3 = this.ann.mViewPager;
                    viewPager3.setCurrentItem(i2, false);
                } else if (currentItem > i2) {
                    viewPager2 = this.ann.mViewPager;
                    viewPager2.setCurrentItem(1, false);
                }
                this.ann.xz();
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.ann.anj;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.ann.anj;
            onPageChangeListener2.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        f fVar;
        f fVar2;
        IndicatorView indicatorView;
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        f fVar3;
        IndicatorView indicatorView2;
        f fVar4;
        fVar = this.ann.ane;
        if (fVar != null) {
            fVar2 = this.ann.ane;
            if (fVar2.dt(i) == i) {
                indicatorView = this.ann.anb;
                if (indicatorView != null) {
                    indicatorView2 = this.ann.anb;
                    fVar4 = this.ann.ane;
                    indicatorView2.setPosition(fVar4.du(i));
                }
                onPageChangeListener = this.ann.anj;
                if (onPageChangeListener != null) {
                    onPageChangeListener2 = this.ann.anj;
                    fVar3 = this.ann.ane;
                    onPageChangeListener2.onPageSelected(fVar3.du(i));
                }
            }
        }
    }
}
