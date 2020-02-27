package com.baidu.live.view.tabhost;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaViewPagerAdapter extends PagerAdapter {
    private a aFS;
    private int mSkinType = 0;
    private int mPrimaryPosition = -1;
    private final List<a> VU = new ArrayList();

    public void setData(List<a> list) {
        this.VU.clear();
        if (!ListUtils.isEmpty(list)) {
            this.VU.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.VU.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        a aVar = (a) ListUtils.getItem(this.VU, i);
        if (aVar != null && aVar.we() != null) {
            View we = aVar.we();
            if (we.getParent() != null) {
                ((ViewGroup) we.getParent()).removeView(we);
            }
            aVar.onChangeSkinType(this.mSkinType);
            viewGroup.addView(we);
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
                if (this.aFS != viewGroup) {
                    if (this.aFS != null) {
                        this.aFS.enterBackground();
                    }
                    aVar.enterForeground();
                    this.aFS = aVar;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof a) && ((a) obj).we() == view;
    }
}
