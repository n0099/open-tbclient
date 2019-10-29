package com.baidu.live.bottompanel;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.liveroom.c.d;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class AlaAudienceLiveRoomBottomPanelAdapter extends PagerAdapter {
    private d Nz;
    private int mSkinType = 0;
    private int mPrimaryPosition = -1;
    private final List<d> Ny = new ArrayList();

    public void setData(List<d> list) {
        this.Ny.clear();
        if (!ListUtils.isEmpty(list)) {
            this.Ny.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.Ny.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        d dVar = (d) ListUtils.getItem(this.Ny, i);
        if (dVar != null && dVar.sr() != null) {
            View sr = dVar.sr();
            if (sr.getParent() != null) {
                ((ViewGroup) sr.getParent()).removeView(sr);
            }
            dVar.onChangeSkinType(this.mSkinType);
            viewGroup.addView(sr);
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
                if (this.Nz != viewGroup) {
                    if (this.Nz != null) {
                        this.Nz.enterBackground();
                    }
                    dVar.enterForeground();
                    this.Nz = dVar;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof d) && ((d) obj).sr() == view;
    }

    public void nt() {
        if (this.Nz != null) {
            this.Nz.enterForeground();
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
    }
}
