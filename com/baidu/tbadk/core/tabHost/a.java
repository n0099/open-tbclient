package com.baidu.tbadk.core.tabHost;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import java.util.List;
/* loaded from: classes.dex */
public class a extends FragmentPagerAdapter {
    private List<b> GG;
    private int mPrimaryPosition;

    public a(FragmentManager fragmentManager, List<b> list) {
        super(fragmentManager);
        this.mPrimaryPosition = -1;
        this.GG = list;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.GG.get(i).GI;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public long getItemId(int i) {
        return this.GG.get(i).GI.hashCode();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.GG.size();
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.mPrimaryPosition != i) {
            if (this.mPrimaryPosition != -1) {
                ((BaseFragment) getItem(this.mPrimaryPosition)).setPrimary(false);
            }
            this.mPrimaryPosition = i;
            ((BaseFragment) obj).setPrimary(true);
        }
    }
}
