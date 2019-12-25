package com.baidu.live.bottompanel;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.liveroom.c.d;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AlaAudienceLiveRoomBottomPanelAdapter extends PagerAdapter {
    private d TV;
    private int mSkinType = 0;
    private int mPrimaryPosition = -1;
    private final List<d> TU = new ArrayList();

    public void setData(List<d> list) {
        this.TU.clear();
        if (!ListUtils.isEmpty(list)) {
            this.TU.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.TU.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        d dVar = (d) ListUtils.getItem(this.TU, i);
        if (dVar != null && dVar.uj() != null) {
            View uj = dVar.uj();
            if (uj.getParent() != null) {
                ((ViewGroup) uj.getParent()).removeView(uj);
            }
            dVar.onChangeSkinType(this.mSkinType);
            viewGroup.addView(uj);
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
                if (this.TV != viewGroup) {
                    if (this.TV != null) {
                        this.TV.enterBackground();
                    }
                    dVar.enterForeground();
                    this.TV = dVar;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof d) && ((d) obj).uj() == view;
    }

    public void oM() {
        if (this.TV != null) {
            this.TV.enterForeground();
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
    }
}
