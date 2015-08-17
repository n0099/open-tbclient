package com.baidu.cloudsdk.social.share.uiwithlayout;

import android.support.v4.view.ViewPager;
/* loaded from: classes.dex */
public interface PageIndicator extends ViewPager.OnPageChangeListener {
    void notifyDataSetChanged();

    void setCurrentItem(int i);

    void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener);

    void setViewPager(ViewPager viewPager);

    void setViewPager(ViewPager viewPager, int i);
}
