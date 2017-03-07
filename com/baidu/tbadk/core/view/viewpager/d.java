package com.baidu.tbadk.core.view.viewpager;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ b amZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.amZ = bVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        a aVar;
        ViewPager viewPager;
        ViewPager viewPager2;
        ViewPager viewPager3;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.amZ.amV;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.amZ.amV;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
        if (i == 1) {
            this.amZ.xe();
        } else if (i == 0) {
            aVar = this.amZ.amP;
            int count = aVar.getCount();
            if (count >= 2) {
                viewPager = this.amZ.mViewPager;
                int currentItem = viewPager.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    viewPager3 = this.amZ.mViewPager;
                    viewPager3.setCurrentItem(i2, false);
                } else if (currentItem > i2) {
                    viewPager2 = this.amZ.mViewPager;
                    viewPager2.setCurrentItem(1, false);
                }
                this.amZ.xd();
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.amZ.amV;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.amZ.amV;
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
        fVar = this.amZ.amQ;
        if (fVar != null) {
            fVar2 = this.amZ.amQ;
            if (fVar2.dq(i) == i) {
                indicatorView = this.amZ.amN;
                if (indicatorView != null) {
                    indicatorView2 = this.amZ.amN;
                    fVar4 = this.amZ.amQ;
                    indicatorView2.setPosition(fVar4.dr(i));
                }
                onPageChangeListener = this.amZ.amV;
                if (onPageChangeListener != null) {
                    onPageChangeListener2 = this.amZ.amV;
                    fVar3 = this.amZ.amQ;
                    onPageChangeListener2.onPageSelected(fVar3.dr(i));
                }
            }
        }
    }
}
