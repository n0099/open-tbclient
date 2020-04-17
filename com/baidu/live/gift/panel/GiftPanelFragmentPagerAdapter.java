package com.baidu.live.gift.panel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.BaseFragment;
/* loaded from: classes3.dex */
public class GiftPanelFragmentPagerAdapter extends FragmentPagerAdapter {
    private Fragment aGR;
    private Fragment[] aGS;

    public GiftPanelFragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public Fragment[] zw() {
        return this.aGS;
    }

    public void a(Fragment... fragmentArr) {
        this.aGS = fragmentArr;
    }

    public Fragment zx() {
        return this.aGR;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.aGS[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.aGS.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.aGR != obj) {
            if (this.aGR instanceof BaseFragment) {
                ((BaseFragment) this.aGR).setPrimary(false);
            }
            this.aGR = (Fragment) obj;
            if (obj instanceof BaseFragment) {
                ((BaseFragment) obj).setPrimary(true);
            }
        }
    }
}
