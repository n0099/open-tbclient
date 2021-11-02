package com.baidu.searchbox.ui.viewpager;

import androidx.viewpager.widget.ViewPager;
/* loaded from: classes7.dex */
public interface PageIndicator extends ViewPager.OnPageChangeListener {
    void notifyDataSetChanged();

    void setCurrentItem(int i2);

    void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener);

    void setViewPager(ViewPager viewPager);

    void setViewPager(ViewPager viewPager, int i2);
}
