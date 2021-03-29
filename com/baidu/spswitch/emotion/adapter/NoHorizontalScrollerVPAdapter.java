package com.baidu.spswitch.emotion.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout;
import java.util.List;
/* loaded from: classes2.dex */
public class NoHorizontalScrollerVPAdapter extends PagerAdapter {
    public List<BDEmotionBagVerticalLayout> mDatas;

    public NoHorizontalScrollerVPAdapter(List<BDEmotionBagVerticalLayout> list) {
        this.mDatas = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView(this.mDatas.get(i));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.mDatas.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        viewGroup.addView(this.mDatas.get(i));
        return this.mDatas.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }
}
