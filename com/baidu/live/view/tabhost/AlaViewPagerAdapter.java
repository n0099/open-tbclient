package com.baidu.live.view.tabhost;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class AlaViewPagerAdapter extends PagerAdapter {
    private a bWN;
    private int mSkinType = 0;
    private int mPrimaryPosition = -1;
    private final List<a> aFM = new ArrayList();

    public void setData(List<a> list) {
        this.aFM.clear();
        if (!ListUtils.isEmpty(list)) {
            this.aFM.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.aFM.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        a aVar = (a) ListUtils.getItem(this.aFM, i);
        if (aVar != null && aVar.getPanelView() != null) {
            View panelView = aVar.getPanelView();
            if (panelView.getParent() != null) {
                ((ViewGroup) panelView.getParent()).removeView(panelView);
            }
            aVar.onChangeSkinType(this.mSkinType);
            viewGroup.addView(panelView);
            return aVar;
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.mPrimaryPosition != i) {
            this.mPrimaryPosition = i;
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.bWN != viewGroup) {
                    if (this.bWN != null) {
                        this.bWN.enterBackground();
                    }
                    aVar.enterForeground();
                    this.bWN = aVar;
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof a) && ((a) obj).getPanelView() == view;
    }
}
