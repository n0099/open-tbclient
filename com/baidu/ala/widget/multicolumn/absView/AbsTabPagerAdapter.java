package com.baidu.ala.widget.multicolumn.absView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
/* loaded from: classes9.dex */
public abstract class AbsTabPagerAdapter extends FragmentPagerAdapter {
    public abstract int getPageType(int i);

    public abstract String getTabTitle(int i);

    public AbsTabPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }
}
