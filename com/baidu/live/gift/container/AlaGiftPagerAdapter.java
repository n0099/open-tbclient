package com.baidu.live.gift.container;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class AlaGiftPagerAdapter extends PagerAdapter {
    private List<View> YT;

    public AlaGiftPagerAdapter(List<View> list) {
        this.YT = new ArrayList();
        this.YT = list;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.YT == null) {
            return 0;
        }
        return this.YT.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (i >= 0 && i < getCount()) {
            viewGroup.removeView(this.YT.get(i));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        View view = this.YT.get(i);
        viewGroup.addView(view);
        return view;
    }
}
