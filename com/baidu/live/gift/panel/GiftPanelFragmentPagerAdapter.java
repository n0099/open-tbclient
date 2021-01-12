package com.baidu.live.gift.panel;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.live.tbadk.core.BaseFragment;
/* loaded from: classes10.dex */
public class GiftPanelFragmentPagerAdapter extends FragmentPagerAdapter {
    private Fragment bdw;
    private Fragment[] bdx;

    public Fragment[] GG() {
        return this.bdx;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.bdx[i];
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.bdx.length;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.bdw != obj) {
            if (this.bdw instanceof BaseFragment) {
                ((BaseFragment) this.bdw).setPrimary(false);
            }
            this.bdw = (Fragment) obj;
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
        }
    }
}
