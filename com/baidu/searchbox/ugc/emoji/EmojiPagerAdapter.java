package com.baidu.searchbox.ugc.emoji;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import java.util.List;
/* loaded from: classes12.dex */
public class EmojiPagerAdapter extends PagerAdapter {
    private List<GridView> gridViews;

    public EmojiPagerAdapter(List<GridView> list) {
        this.gridViews = list;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.gridViews.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        viewGroup.addView(this.gridViews.get(i));
        return this.gridViews.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.gridViews.get(i));
    }
}
