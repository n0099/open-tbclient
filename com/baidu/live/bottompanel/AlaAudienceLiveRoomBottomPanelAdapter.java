package com.baidu.live.bottompanel;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.liveroom.d.d;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaAudienceLiveRoomBottomPanelAdapter extends PagerAdapter {
    private d VV;
    private int mSkinType = 0;
    private int mPrimaryPosition = -1;
    private final List<d> VU = new ArrayList();

    public void setData(List<d> list) {
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
        d dVar = (d) ListUtils.getItem(this.VU, i);
        if (dVar != null && dVar.we() != null) {
            View we = dVar.we();
            if (we.getParent() != null) {
                ((ViewGroup) we.getParent()).removeView(we);
            }
            dVar.onChangeSkinType(this.mSkinType);
            viewGroup.addView(we);
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
                if (this.VV != viewGroup) {
                    if (this.VV != null) {
                        this.VV.enterBackground();
                    }
                    dVar.enterForeground();
                    this.VV = dVar;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof d) && ((d) obj).we() == view;
    }

    public void pE() {
        if (this.VV != null) {
            this.VV.enterForeground();
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
    }
}
