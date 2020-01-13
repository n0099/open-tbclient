package com.baidu.spswitch.emotion.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes12.dex */
public class NoHorizontalScrollerVPAdapter extends FragmentPagerAdapter {
    private List<Fragment> mDatas;

    public NoHorizontalScrollerVPAdapter(FragmentManager fragmentManager, List<Fragment> list) {
        super(fragmentManager);
        this.mDatas = list;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.mDatas.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mDatas.size();
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        super.destroyItem(viewGroup, i, obj);
    }
}
