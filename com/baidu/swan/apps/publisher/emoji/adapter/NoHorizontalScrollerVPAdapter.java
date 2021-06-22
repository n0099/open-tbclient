package com.baidu.swan.apps.publisher.emoji.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;
/* loaded from: classes3.dex */
public class NoHorizontalScrollerVPAdapter extends PagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<View> f11156a;

    public NoHorizontalScrollerVPAdapter(List<View> list) {
        this.f11156a = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        viewGroup.removeView(this.f11156a.get(i2));
        super.destroyItem(viewGroup, i2, obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f11156a.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        viewGroup.addView(this.f11156a.get(i2));
        return this.f11156a.get(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }
}
