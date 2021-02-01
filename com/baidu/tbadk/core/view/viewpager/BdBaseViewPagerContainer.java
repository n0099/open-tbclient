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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    private BdBaseViewPagerContainerHolder foK;
    private a foL;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.foK = new BdBaseViewPagerContainerHolder(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.foK);
        this.foL = new a(context, this.foK.foQ, this.foK.foO, this.foK.foN, 4, false, true);
    }

    private void a(BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder) {
        if (bdBaseViewPagerContainerHolder != null) {
            ap.setBackgroundColor(bdBaseViewPagerContainerHolder.getView(), R.color.CAM_X0201);
            ap.setViewTextColor(bdBaseViewPagerContainerHolder.title, R.color.CAM_X0108, 1);
            ap.setBackgroundColor(bdBaseViewPagerContainerHolder.foP, R.color.CAM_X0204);
            ap.setViewTextColor(bdBaseViewPagerContainerHolder.foN, R.color.CAM_X0109, 1);
            ap.setBackgroundColor(bdBaseViewPagerContainerHolder.foN, R.color.CAM_X0201);
            bdBaseViewPagerContainerHolder.foN.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            bdBaseViewPagerContainerHolder.foO.setSelector(ap.getDrawable(R.drawable.icon_choose_dot_s));
            bdBaseViewPagerContainerHolder.foO.setDrawable(ap.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.foK.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.foK.foQ;
    }

    public IndicatorView getIndicatorView() {
        return this.foK.foO;
    }

    public TextView getMoreView() {
        return this.foK.foN;
    }

    public BdBaseViewPagerContainerHolder getViewHolder() {
        return this.foK;
    }

    public void setMaxScrollCountLimit(int i) {
        this.foL.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.foL.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.foL.ki(z);
    }

    public void setDatas(List<n> list) {
        this.foL.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.foL.setAutoScrollIntervalTime(j);
    }
}
