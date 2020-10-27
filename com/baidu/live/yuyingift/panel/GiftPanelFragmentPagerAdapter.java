package com.baidu.live.yuyingift.panel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.BaseFragment;
/* loaded from: classes4.dex */
public class GiftPanelFragmentPagerAdapter extends FragmentPagerAdapter {
    private Fragment bcY;
    private Fragment[] bcZ;

    public Fragment[] Ji() {
        return this.bcZ;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.bcZ[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bcZ.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.bcY != obj) {
            if (this.bcY instanceof BaseFragment) {
                ((BaseFragment) this.bcY).setPrimary(false);
            }
            this.bcY = (Fragment) obj;
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
        }
    }
}
