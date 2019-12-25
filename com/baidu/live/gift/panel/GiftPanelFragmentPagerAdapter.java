package com.baidu.live.gift.panel;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
public class GiftPanelFragmentPagerAdapter extends FragmentPagerAdapter {
    public Fragment aln;
    private Fragment[] alo;

    public GiftPanelFragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public void a(Fragment... fragmentArr) {
        this.alo = fragmentArr;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.alo[i];
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.alo.length;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        this.aln = (Fragment) obj;
        super.setPrimaryItem(viewGroup, i, obj);
    }
}
