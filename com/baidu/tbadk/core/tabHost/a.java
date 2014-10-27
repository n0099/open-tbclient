package com.baidu.tbadk.core.tabHost;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import com.baidu.tbadk.core.BaseFragment;
import java.util.List;
/* loaded from: classes.dex */
public class a extends FragmentPagerAdapter {
    private int Cv;
    private List<b> Cw;

    public a(FragmentManager fragmentManager, List<b> list) {
        super(fragmentManager);
        this.Cv = -1;
        this.Cw = list;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.Cw.get(i).Cy;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public long getItemId(int i) {
        return this.Cw.get(i).Cy.hashCode();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.Cw.size();
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.Cv != i) {
            if (this.Cv != -1) {
                ((BaseFragment) getItem(this.Cv)).setPrimary(false);
            }
            this.Cv = i;
            ((BaseFragment) obj).setPrimary(true);
        }
    }
}
