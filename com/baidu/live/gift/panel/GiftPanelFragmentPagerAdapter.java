package com.baidu.live.gift.panel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.BaseFragment;
/* loaded from: classes3.dex */
public class GiftPanelFragmentPagerAdapter extends FragmentPagerAdapter {
    private Fragment aGX;
    private Fragment[] aGY;

    public GiftPanelFragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public Fragment[] zv() {
        return this.aGY;
    }

    public void a(Fragment... fragmentArr) {
        this.aGY = fragmentArr;
    }

    public Fragment zw() {
        return this.aGX;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.aGY[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.aGY.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.aGX != obj) {
            if (this.aGX instanceof BaseFragment) {
                ((BaseFragment) this.aGX).setPrimary(false);
            }
            this.aGX = (Fragment) obj;
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
        }
    }
}
