package com.baidu.live.gift.panel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.BaseFragment;
/* loaded from: classes4.dex */
public class GiftPanelFragmentPagerAdapter extends FragmentPagerAdapter {
    private Fragment aQG;
    private Fragment[] aQH;

    public Fragment[] BO() {
        return this.aQH;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.aQH[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.aQH.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.aQG != obj) {
            if (this.aQG instanceof BaseFragment) {
                ((BaseFragment) this.aQG).setPrimary(false);
            }
            this.aQG = (Fragment) obj;
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
        }
    }
}
