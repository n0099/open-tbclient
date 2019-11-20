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
    private d MZ;
    private int mSkinType = 0;
    private int mPrimaryPosition = -1;
    private final List<d> MY = new ArrayList();

    public void setData(List<d> list) {
        this.MY.clear();
        if (!ListUtils.isEmpty(list)) {
            this.MY.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.MY.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        d dVar = (d) ListUtils.getItem(this.MY, i);
        if (dVar != null && dVar.ss() != null) {
            View ss = dVar.ss();
            if (ss.getParent() != null) {
                ((ViewGroup) ss.getParent()).removeView(ss);
            }
            dVar.onChangeSkinType(this.mSkinType);
            viewGroup.addView(ss);
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
                if (this.MZ != viewGroup) {
                    if (this.MZ != null) {
                        this.MZ.enterBackground();
                    }
                    dVar.enterForeground();
                    this.MZ = dVar;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof d) && ((d) obj).ss() == view;
    }

    public void nt() {
        if (this.MZ != null) {
            this.MZ.enterForeground();
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
    }
}
