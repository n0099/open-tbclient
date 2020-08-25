package com.baidu.live.bottompanel;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.liveroom.d.d;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class AlaAudienceLiveRoomBottomPanelAdapter extends PagerAdapter {
    private d aBq;
    private int mSkinType = 0;
    private int mPrimaryPosition = -1;
    private final List<d> aBp = new ArrayList();

    public void setData(List<d> list) {
        this.aBp.clear();
        if (!ListUtils.isEmpty(list)) {
            this.aBp.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.aBp.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        d dVar = (d) ListUtils.getItem(this.aBp, i);
        if (dVar != null && dVar.getPanelView() != null) {
            View panelView = dVar.getPanelView();
            if (panelView.getParent() != null) {
                ((ViewGroup) panelView.getParent()).removeView(panelView);
            }
            dVar.onChangeSkinType(this.mSkinType);
            viewGroup.addView(panelView);
            return dVar;
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
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (this.aBq != viewGroup) {
                    if (this.aBq != null) {
                        this.aBq.enterBackground();
                    }
                    dVar.enterForeground();
                    this.aBq = dVar;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof d) && ((d) obj).getPanelView() == view;
    }

    public void Bv() {
        if (this.aBq != null) {
            this.aBq.enterForeground();
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
    }
}
