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
    private d Um;
    private int mSkinType = 0;
    private int mPrimaryPosition = -1;
    private final List<d> Ul = new ArrayList();

    public void setData(List<d> list) {
        this.Ul.clear();
        if (!ListUtils.isEmpty(list)) {
            this.Ul.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.Ul.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        d dVar = (d) ListUtils.getItem(this.Ul, i);
        if (dVar != null && dVar.uA() != null) {
            View uA = dVar.uA();
            if (uA.getParent() != null) {
                ((ViewGroup) uA.getParent()).removeView(uA);
            }
            dVar.onChangeSkinType(this.mSkinType);
            viewGroup.addView(uA);
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
                if (this.Um != viewGroup) {
                    if (this.Um != null) {
                        this.Um.enterBackground();
                    }
                    dVar.enterForeground();
                    this.Um = dVar;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof d) && ((d) obj).uA() == view;
    }

    public void oT() {
        if (this.Um != null) {
            this.Um.enterForeground();
        }
    }

    public void onChangeSkinType(int i) {
        this.mSkinType = i;
    }
}
