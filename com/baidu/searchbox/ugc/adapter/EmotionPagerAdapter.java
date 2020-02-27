package com.baidu.searchbox.ugc.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class EmotionPagerAdapter extends PagerAdapter {
    private List<View> mViewList = new ArrayList();

    public EmotionPagerAdapter(View view) {
        this.mViewList.clear();
        this.mViewList.add(view);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.mViewList.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        int indexOf = this.mViewList.indexOf(obj);
        if (indexOf == -1) {
            return -2;
        }
        return indexOf;
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View view = this.mViewList.get(i);
        viewGroup.addView(view);
        return view;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.mViewList.get(i));
    }
}
