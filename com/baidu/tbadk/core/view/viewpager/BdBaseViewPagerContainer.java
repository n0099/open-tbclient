package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    private BdBaseViewPagerContainerHolder frb;
    private a frd;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.frb = new BdBaseViewPagerContainerHolder(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.frb);
        this.frd = new a(context, this.frb.fri, this.frb.frg, this.frb.frf, 4, false, true);
    }

    private void a(BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder) {
        if (bdBaseViewPagerContainerHolder != null) {
            ao.setBackgroundColor(bdBaseViewPagerContainerHolder.getView(), R.color.CAM_X0201);
            ao.setViewTextColor(bdBaseViewPagerContainerHolder.title, R.color.CAM_X0108, 1);
            ao.setBackgroundColor(bdBaseViewPagerContainerHolder.frh, R.color.CAM_X0204);
            ao.setViewTextColor(bdBaseViewPagerContainerHolder.frf, R.color.CAM_X0109, 1);
            ao.setBackgroundColor(bdBaseViewPagerContainerHolder.frf, R.color.CAM_X0201);
            bdBaseViewPagerContainerHolder.frf.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            bdBaseViewPagerContainerHolder.frg.setSelector(ao.getDrawable(R.drawable.icon_choose_dot_s));
            bdBaseViewPagerContainerHolder.frg.setDrawable(ao.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.frb.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.frb.fri;
    }

    public IndicatorView getIndicatorView() {
        return this.frb.frg;
    }

    public TextView getMoreView() {
        return this.frb.frf;
    }

    public BdBaseViewPagerContainerHolder getViewHolder() {
        return this.frb;
    }

    public void setMaxScrollCountLimit(int i) {
        this.frd.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.frd.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.frd.kj(z);
    }

    public void setDatas(List<n> list) {
        this.frd.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.frd.setAutoScrollIntervalTime(j);
    }
}
