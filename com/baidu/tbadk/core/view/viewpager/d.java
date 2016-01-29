package com.baidu.tbadk.core.view.viewpager;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements ViewPager.OnPageChangeListener {
    final /* synthetic */ b aij;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.aij = bVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        a aVar;
        ViewPager viewPager;
        ViewPager viewPager2;
        ViewPager viewPager3;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.aij.aif;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.aij.aif;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
        if (i == 1) {
            this.aij.xp();
        } else if (i == 0) {
            aVar = this.aij.ahZ;
            int count = aVar.getCount();
            if (count >= 2) {
                viewPager = this.aij.ahW;
                int currentItem = viewPager.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    viewPager3 = this.aij.ahW;
                    viewPager3.setCurrentItem(i2, false);
                } else if (currentItem > i2) {
                    viewPager2 = this.aij.ahW;
                    viewPager2.setCurrentItem(1, false);
                }
                this.aij.xo();
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.aij.aif;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.aij.aif;
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
        fVar = this.aij.aia;
        if (fVar != null) {
            fVar2 = this.aij.aia;
            if (fVar2.dp(i) == i) {
                indicatorView = this.aij.ahX;
                if (indicatorView != null) {
                    indicatorView2 = this.aij.ahX;
                    fVar4 = this.aij.aia;
                    indicatorView2.setPosition(fVar4.dq(i));
                }
                onPageChangeListener = this.aij.aif;
                if (onPageChangeListener != null) {
                    onPageChangeListener2 = this.aij.aif;
                    fVar3 = this.aij.aia;
                    onPageChangeListener2.onPageSelected(fVar3.dq(i));
                }
            }
        }
    }
}
