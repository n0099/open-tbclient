package com.baidu.live.view.tabhost;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaViewPagerAdapter extends PagerAdapter {
    private a aBL;
    private int mSkinType = 0;
    private int mPrimaryPosition = -1;
    private final List<a> Ul = new ArrayList();

    public void setData(List<a> list) {
        this.Ul.clear();
        if (!ListUtils.isEmpty(list)) {
            this.Ul.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.Ul.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        a aVar = (a) ListUtils.getItem(this.Ul, i);
        if (aVar != null && aVar.uA() != null) {
            View uA = aVar.uA();
            if (uA.getParent() != null) {
                ((ViewGroup) uA.getParent()).removeView(uA);
            }
            aVar.onChangeSkinType(this.mSkinType);
            viewGroup.addView(uA);
            return aVar;
        }
        return null;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.mPrimaryPosition != i) {
            this.mPrimaryPosition = i;
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.aBL != viewGroup) {
                    if (this.aBL != null) {
                        this.aBL.enterBackground();
                    }
                    aVar.enterForeground();
                    this.aBL = aVar;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof a) && ((a) obj).uA() == view;
    }
}
