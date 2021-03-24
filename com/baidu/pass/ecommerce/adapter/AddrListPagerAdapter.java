package com.baidu.pass.ecommerce.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.pass.ecommerce.view.addressdialog.ListPagerView;
import java.util.List;
/* loaded from: classes2.dex */
public class AddrListPagerAdapter extends PagerAdapter {
    public static final int MAX_PAGER_NUMBER = 4;
    public List<ListPagerView> mViews;

    public AddrListPagerAdapter(List<ListPagerView> list) {
        this.mViews = list;
    }

    private int fixPositionInViewList(int i) {
        if (this.mViews == null) {
            return 0;
        }
        if (i < 0) {
            i = 0;
        }
        return i >= this.mViews.size() ? this.mViews.size() - 1 : i;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView(this.mViews.get(fixPositionInViewList(i)));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 4;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        int fixPositionInViewList = fixPositionInViewList(i);
        viewGroup.addView(this.mViews.get(i));
        return this.mViews.get(fixPositionInViewList);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }
}
