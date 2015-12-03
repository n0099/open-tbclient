package com.baidu.tbadk.core.view.viewpager;

import android.support.v4.view.ViewPager;
import com.baidu.adp.widget.IndicatorView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements ViewPager.OnPageChangeListener {
    final /* synthetic */ d agr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.agr = dVar;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        a aVar;
        ViewPager viewPager;
        ViewPager viewPager2;
        ViewPager viewPager3;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.agr.ago;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.agr.ago;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
        if (i == 1) {
            this.agr.wq();
        } else if (i == 0) {
            aVar = this.agr.agi;
            int count = aVar.getCount();
            if (count >= 2) {
                viewPager = this.agr.mViewPager;
                int currentItem = viewPager.getCurrentItem();
                int i2 = count - 2;
                if (currentItem < 1) {
                    viewPager3 = this.agr.mViewPager;
                    viewPager3.setCurrentItem(i2, false);
                } else if (currentItem > i2) {
                    viewPager2 = this.agr.mViewPager;
                    viewPager2.setCurrentItem(1, false);
                }
                this.agr.wp();
            }
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.agr.ago;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.agr.ago;
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
        hVar = this.agr.agj;
        if (hVar != null) {
            hVar2 = this.agr.agj;
            if (hVar2.da(i) == i) {
                indicatorView = this.agr.agf;
                if (indicatorView != null) {
                    indicatorView2 = this.agr.agf;
                    hVar4 = this.agr.agj;
                    indicatorView2.setPosition(hVar4.db(i));
                }
                onPageChangeListener = this.agr.ago;
                if (onPageChangeListener != null) {
                    onPageChangeListener2 = this.agr.ago;
                    hVar3 = this.agr.agj;
                    onPageChangeListener2.onPageSelected(hVar3.db(i));
                }
            }
        }
    }
}
