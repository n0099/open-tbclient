package com.baidu.ala.widget.multicolumn.absView;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
/* loaded from: classes2.dex */
public abstract class AbsTabPagerAdapter extends FragmentPagerAdapter {
    public abstract int getPageType(int i);

    public abstract String getTabTitle(int i);

    public AbsTabPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }
}
