package com.baidu.live.gift.panel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.BaseFragment;
/* loaded from: classes7.dex */
public class GiftPanelFragmentPagerAdapter extends FragmentPagerAdapter {
    private Fragment aVU;
    private Fragment[] aVV;

    public Fragment[] Hr() {
        return this.aVV;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.aVV[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.aVV.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.aVU != obj) {
            if (this.aVU instanceof BaseFragment) {
                ((BaseFragment) this.aVU).setPrimary(false);
            }
            this.aVU = (Fragment) obj;
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
        }
    }
}
