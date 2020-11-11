package com.baidu.live.gift.panel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.BaseFragment;
/* loaded from: classes4.dex */
public class GiftPanelFragmentPagerAdapter extends FragmentPagerAdapter {
    private Fragment bes;
    private Fragment[] beu;

    public Fragment[] JJ() {
        return this.beu;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.beu[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.beu.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.bes != obj) {
            if (this.bes instanceof BaseFragment) {
                ((BaseFragment) this.bes).setPrimary(false);
            }
            this.bes = (Fragment) obj;
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
        }
    }
}
