package com.baidu.live.bottompanel;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.live.liveroom.d.d;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class AlaAudienceLiveRoomBottomPanelAdapter extends PagerAdapter {
    private d aHn;
    private int mSkinType = 0;
    private int mPrimaryPosition = -1;
    private final List<d> aHm = new ArrayList();

    public void setData(List<d> list) {
        this.aHm.clear();
        if (!ListUtils.isEmpty(list)) {
            this.aHm.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.aHm.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        d dVar = (d) ListUtils.getItem(this.aHm, i);
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

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.mPrimaryPosition != i) {
            this.mPrimaryPosition = i;
            if (obj instanceof d) {
                d dVar = (d) obj;
                if (this.aHn != viewGroup) {
                    if (this.aHn != null) {
                        this.aHn.enterBackground();
                    }
                    dVar.enterForeground();
                    this.aHn = dVar;
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof d) && ((d) obj).getPanelView() == view;
    }

    public void Dw() {
        if (this.aHn != null) {
            this.aHn.enterForeground();
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
    }
}
