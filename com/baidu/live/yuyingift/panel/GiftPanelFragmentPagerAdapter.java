package com.baidu.live.yuyingift.panel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.BaseFragment;
/* loaded from: classes4.dex */
public class GiftPanelFragmentPagerAdapter extends FragmentPagerAdapter {
    private Fragment bcG;
    private Fragment[] bcH;

    public Fragment[] Ja() {
        return this.bcH;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.bcH[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bcH.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.bcG != obj) {
            if (this.bcG instanceof BaseFragment) {
                ((BaseFragment) this.bcG).setPrimary(false);
            }
            this.bcG = (Fragment) obj;
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
        }
    }
}
