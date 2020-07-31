package com.baidu.live.bottompanel;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.liveroom.d.d;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaAudienceLiveRoomBottomPanelAdapter extends PagerAdapter {
    private d awo;
    private int mSkinType = 0;
    private int mPrimaryPosition = -1;
    private final List<d> awn = new ArrayList();

    public void setData(List<d> list) {
        this.awn.clear();
        if (!ListUtils.isEmpty(list)) {
            this.awn.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.awn.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        d dVar = (d) ListUtils.getItem(this.awn, i);
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
                if (this.awo != viewGroup) {
                    if (this.awo != null) {
                        this.awo.enterBackground();
                    }
                    dVar.enterForeground();
                    this.awo = dVar;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof d) && ((d) obj).getPanelView() == view;
    }

    public void vX() {
        if (this.awo != null) {
            this.awo.enterForeground();
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
    }
}
