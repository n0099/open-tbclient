package com.baidu.tbadk.core.view.viewpager;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
/* loaded from: classes.dex */
class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ b ahD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.ahD = bVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        a aVar;
        ViewPager viewPager;
        ViewPager viewPager2;
        ViewPager viewPager3;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.ahD.ahz;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.ahD.ahz;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
        if (i == 1) {
            this.ahD.wH();
        } else if (i == 0) {
            aVar = this.ahD.aht;
            int count = aVar.getCount();
            if (count >= 2) {
                viewPager = this.ahD.mViewPager;
                int currentItem = viewPager.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    viewPager3 = this.ahD.mViewPager;
                    viewPager3.setCurrentItem(i2, false);
                } else if (currentItem > i2) {
                    viewPager2 = this.ahD.mViewPager;
                    viewPager2.setCurrentItem(1, false);
                }
                this.ahD.wG();
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.ahD.ahz;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.ahD.ahz;
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
        fVar = this.ahD.ahu;
        if (fVar != null) {
            fVar2 = this.ahD.ahu;
            if (fVar2.du(i) == i) {
                indicatorView = this.ahD.ahr;
                if (indicatorView != null) {
                    indicatorView2 = this.ahD.ahr;
                    fVar4 = this.ahD.ahu;
                    indicatorView2.setPosition(fVar4.dv(i));
                }
                onPageChangeListener = this.ahD.ahz;
                if (onPageChangeListener != null) {
                    onPageChangeListener2 = this.ahD.ahz;
                    fVar3 = this.ahD.ahu;
                    onPageChangeListener2.onPageSelected(fVar3.dv(i));
                }
            }
        }
    }
}
