package com.baidu.live.gift.panel;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import com.baidu.live.tbadk.core.BaseFragment;
/* loaded from: classes11.dex */
public class GiftPanelFragmentPagerAdapter extends FragmentPagerAdapter {
    private Fragment bip;
    private Fragment[] biq;

    public Fragment[] KB() {
        return this.biq;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.biq[i];
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.biq.length;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.bip != obj) {
            if (this.bip instanceof BaseFragment) {
                ((BaseFragment) this.bip).setPrimary(false);
            }
            this.bip = (Fragment) obj;
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
        }
    }
}
