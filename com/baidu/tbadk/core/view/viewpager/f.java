package com.baidu.tbadk.core.view.viewpager;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements ViewPager.OnPageChangeListener {
    final /* synthetic */ d ahy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.ahy = dVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        a aVar;
        ViewPager viewPager;
        ViewPager viewPager2;
        ViewPager viewPager3;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.ahy.ahv;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.ahy.ahv;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
        if (i == 1) {
            this.ahy.wb();
        } else if (i == 0) {
            aVar = this.ahy.ahp;
            int count = aVar.getCount();
            if (count >= 2) {
                viewPager = this.ahy.mViewPager;
                int currentItem = viewPager.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    viewPager3 = this.ahy.mViewPager;
                    viewPager3.setCurrentItem(i2, false);
                } else if (currentItem > i2) {
                    viewPager2 = this.ahy.mViewPager;
                    viewPager2.setCurrentItem(1, false);
                }
                this.ahy.wa();
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.ahy.ahv;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.ahy.ahv;
            onPageChangeListener2.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        h hVar;
        h hVar2;
        IndicatorView indicatorView;
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        h hVar3;
        IndicatorView indicatorView2;
        h hVar4;
        hVar = this.ahy.ahq;
        if (hVar != null) {
            hVar2 = this.ahy.ahq;
            if (hVar2.cT(i) == i) {
                indicatorView = this.ahy.ahm;
                if (indicatorView != null) {
                    indicatorView2 = this.ahy.ahm;
                    hVar4 = this.ahy.ahq;
                    indicatorView2.setPosition(hVar4.cU(i));
                }
                onPageChangeListener = this.ahy.ahv;
                if (onPageChangeListener != null) {
                    onPageChangeListener2 = this.ahy.ahv;
                    hVar3 = this.ahy.ahq;
                    onPageChangeListener2.onPageSelected(hVar3.cU(i));
                }
            }
        }
    }
}
