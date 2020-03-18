package com.baidu.live.view.tabhost;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaViewPagerAdapter extends PagerAdapter {
    private a aGi;
    private int mSkinType = 0;
    private int mPrimaryPosition = -1;
    private final List<a> Wf = new ArrayList();

    public void setData(List<a> list) {
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
        a aVar = (a) ListUtils.getItem(this.Wf, i);
        if (aVar != null && aVar.wj() != null) {
            View wj = aVar.wj();
            if (wj.getParent() != null) {
                ((ViewGroup) wj.getParent()).removeView(wj);
            }
            aVar.onChangeSkinType(this.mSkinType);
            viewGroup.addView(wj);
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
                if (this.aGi != viewGroup) {
                    if (this.aGi != null) {
                        this.aGi.enterBackground();
                    }
                    aVar.enterForeground();
                    this.aGi = aVar;
                }
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return (obj instanceof a) && ((a) obj).wj() == view;
    }
}
