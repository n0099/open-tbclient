package com.baidu.ala.widget.multicolumn.absView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
/* loaded from: classes.dex */
public abstract class AbsTabPagerAdapter extends FragmentPagerAdapter {
    public AbsTabPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public abstract int getPageType(int i2);

    public abstract String getTabTitle(int i2);
}
