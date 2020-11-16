package com.baidu.live.view.tabhost;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaViewPagerAdapter extends PagerAdapter {
    private a bLv;
    private int mSkinType = 0;
    private int mPrimaryPosition = -1;
    private final List<a> aEp = new ArrayList();

    public void setData(List<a> list) {
        this.aEp.clear();
        if (!ListUtils.isEmpty(list)) {
            this.aEp.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.aEp.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        a aVar = (a) ListUtils.getItem(this.aEp, i);
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

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // android.support.v4.view.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.mPrimaryPosition != i) {
            this.mPrimaryPosition = i;
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.bLv != viewGroup) {
                    if (this.bLv != null) {
                        this.bLv.enterBackground();
                    }
                    aVar.enterForeground();
                    this.bLv = aVar;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof a) && ((a) obj).getPanelView() == view;
    }
}
