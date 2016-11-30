package com.baidu.tbadk.core.view.viewpager;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ b aiP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.aiP = bVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        a aVar;
        ViewPager viewPager;
        ViewPager viewPager2;
        ViewPager viewPager3;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.aiP.aiL;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.aiP.aiL;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
        if (i == 1) {
            this.aiP.xa();
        } else if (i == 0) {
            aVar = this.aiP.aiF;
            int count = aVar.getCount();
            if (count >= 2) {
                viewPager = this.aiP.aiC;
                int currentItem = viewPager.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    viewPager3 = this.aiP.aiC;
                    viewPager3.setCurrentItem(i2, false);
                } else if (currentItem > i2) {
                    viewPager2 = this.aiP.aiC;
                    viewPager2.setCurrentItem(1, false);
                }
                this.aiP.wZ();
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.aiP.aiL;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.aiP.aiL;
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
        fVar = this.aiP.aiG;
        if (fVar != null) {
            fVar2 = this.aiP.aiG;
            if (fVar2.dr(i) == i) {
                indicatorView = this.aiP.aiD;
                if (indicatorView != null) {
                    indicatorView2 = this.aiP.aiD;
                    fVar4 = this.aiP.aiG;
                    indicatorView2.setPosition(fVar4.ds(i));
                }
                onPageChangeListener = this.aiP.aiL;
                if (onPageChangeListener != null) {
                    onPageChangeListener2 = this.aiP.aiL;
                    fVar3 = this.aiP.aiG;
                    onPageChangeListener2.onPageSelected(fVar3.ds(i));
                }
            }
        }
    }
}
