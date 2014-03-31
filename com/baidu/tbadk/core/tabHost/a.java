package com.baidu.tbadk.core.tabHost;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import java.util.List;
/* loaded from: classes.dex */
public final class a extends FragmentPagerAdapter {
    private int a;
    private List<b> b;

    public a(FragmentManager fragmentManager, List<b> list) {
        super(fragmentManager);
        this.a = -1;
        this.b = list;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public final Fragment getItem(int i) {
        return this.b.get(i).c;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public final long getItemId(int i) {
        return this.b.get(i).c.hashCode();
    }

    @Override // android.support.v4.view.PagerAdapter
    public final int getCount() {
        return this.b.size();
    }

    @Override // android.support.v4.app.FragmentPagerAdapter, android.support.v4.view.PagerAdapter
    public final void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.a != i) {
            if (this.a != -1) {
                ((com.baidu.tbadk.core.d) getItem(this.a)).setPrimary(false);
            }
            this.a = i;
            ((com.baidu.tbadk.core.d) obj).setPrimary(true);
        }
    }
}
