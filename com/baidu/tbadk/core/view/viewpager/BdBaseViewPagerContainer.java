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
    private BdBaseViewPagerContainerHolder fms;
    private a fmt;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.fms = new BdBaseViewPagerContainerHolder(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.fms);
        this.fmt = new a(context, this.fms.fmy, this.fms.fmw, this.fms.fmv, 4, false, true);
    }

    private void a(BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder) {
        if (bdBaseViewPagerContainerHolder != null) {
            ao.setBackgroundColor(bdBaseViewPagerContainerHolder.getView(), R.color.CAM_X0201);
            ao.setViewTextColor(bdBaseViewPagerContainerHolder.title, R.color.CAM_X0108, 1);
            ao.setBackgroundColor(bdBaseViewPagerContainerHolder.fmx, R.color.CAM_X0204);
            ao.setViewTextColor(bdBaseViewPagerContainerHolder.fmv, R.color.CAM_X0109, 1);
            ao.setBackgroundColor(bdBaseViewPagerContainerHolder.fmv, R.color.CAM_X0201);
            bdBaseViewPagerContainerHolder.fmv.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            bdBaseViewPagerContainerHolder.fmw.setSelector(ao.getDrawable(R.drawable.icon_choose_dot_s));
            bdBaseViewPagerContainerHolder.fmw.setDrawable(ao.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.fms.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.fms.fmy;
    }

    public IndicatorView getIndicatorView() {
        return this.fms.fmw;
    }

    public TextView getMoreView() {
        return this.fms.fmv;
    }

    public BdBaseViewPagerContainerHolder getViewHolder() {
        return this.fms;
    }

    public void setMaxScrollCountLimit(int i) {
        this.fmt.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.fmt.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.fmt.kf(z);
    }

    public void setDatas(List<n> list) {
        this.fmt.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.fmt.setAutoScrollIntervalTime(j);
    }
}
