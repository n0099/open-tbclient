package com.baidu.live.gift.panel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.BaseFragment;
/* loaded from: classes3.dex */
public class GiftPanelFragmentPagerAdapter extends FragmentPagerAdapter {
    private Fragment aPn;
    private Fragment[] aPo;

    public Fragment[] Bm() {
        return this.aPo;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.aPo[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.aPo.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.aPn != obj) {
            if (this.aPn instanceof BaseFragment) {
                ((BaseFragment) this.aPn).setPrimary(false);
            }
            this.aPn = (Fragment) obj;
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
        }
    }
}
