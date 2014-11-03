package com.baidu.tbadk.core.tabHost;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import java.util.List;
/* loaded from: classes.dex */
public class a extends FragmentPagerAdapter {
    private int Cw;
    private List<b> Cx;

    public a(FragmentManager fragmentManager, List<b> list) {
        super(fragmentManager);
        this.Cw = -1;
        this.Cx = list;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.Cx.get(i).Cz;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public long getItemId(int i) {
        return this.Cx.get(i).Cz.hashCode();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.Cx.size();
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.Cw != i) {
            if (this.Cw != -1) {
                ((BaseFragment) getItem(this.Cw)).setPrimary(false);
            }
            this.Cw = i;
            ((BaseFragment) obj).setPrimary(true);
        }
    }
}
