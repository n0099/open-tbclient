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
    private d Wg;
    private int mSkinType = 0;
    private int mPrimaryPosition = -1;
    private final List<d> Wf = new ArrayList();

    public void setData(List<d> list) {
        this.Wf.clear();
        if (!ListUtils.isEmpty(list)) {
            this.Wf.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.Wf.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        d dVar = (d) ListUtils.getItem(this.Wf, i);
        if (dVar != null && dVar.wj() != null) {
            View wj = dVar.wj();
            if (wj.getParent() != null) {
                ((ViewGroup) wj.getParent()).removeView(wj);
            }
            dVar.onChangeSkinType(this.mSkinType);
            viewGroup.addView(wj);
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
                if (this.Wg != viewGroup) {
                    if (this.Wg != null) {
                        this.Wg.enterBackground();
                    }
                    dVar.enterForeground();
                    this.Wg = dVar;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof d) && ((d) obj).wj() == view;
    }

    public void pJ() {
        if (this.Wg != null) {
            this.Wg.enterForeground();
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
    }
}
