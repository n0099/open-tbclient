package com.baidu.tbadk.core.view.viewpager;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ b aiz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.aiz = bVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        a aVar;
        ViewPager viewPager;
        ViewPager viewPager2;
        ViewPager viewPager3;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.aiz.aiv;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.aiz.aiv;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
        if (i == 1) {
            this.aiz.xP();
        } else if (i == 0) {
            aVar = this.aiz.aip;
            int count = aVar.getCount();
            if (count >= 2) {
                viewPager = this.aiz.aim;
                int currentItem = viewPager.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    viewPager3 = this.aiz.aim;
                    viewPager3.setCurrentItem(i2, false);
                } else if (currentItem > i2) {
                    viewPager2 = this.aiz.aim;
                    viewPager2.setCurrentItem(1, false);
                }
                this.aiz.xO();
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.aiz.aiv;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.aiz.aiv;
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
        fVar = this.aiz.aiq;
        if (fVar != null) {
            fVar2 = this.aiz.aiq;
            if (fVar2.ds(i) == i) {
                indicatorView = this.aiz.ain;
                if (indicatorView != null) {
                    indicatorView2 = this.aiz.ain;
                    fVar4 = this.aiz.aiq;
                    indicatorView2.setPosition(fVar4.dt(i));
                }
                onPageChangeListener = this.aiz.aiv;
                if (onPageChangeListener != null) {
                    onPageChangeListener2 = this.aiz.aiv;
                    fVar3 = this.aiz.aiq;
                    onPageChangeListener2.onPageSelected(fVar3.dt(i));
                }
            }
        }
    }
}
