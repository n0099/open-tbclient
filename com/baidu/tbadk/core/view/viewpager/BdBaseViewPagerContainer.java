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
    private BdBaseViewPagerContainerHolder fqk;
    private a fql;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.fqk = new BdBaseViewPagerContainerHolder(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.fqk);
        this.fql = new a(context, this.fqk.fqq, this.fqk.fqo, this.fqk.fqn, 4, false, true);
    }

    private void a(BdBaseViewPagerContainerHolder bdBaseViewPagerContainerHolder) {
        if (bdBaseViewPagerContainerHolder != null) {
            ap.setBackgroundColor(bdBaseViewPagerContainerHolder.getView(), R.color.CAM_X0201);
            ap.setViewTextColor(bdBaseViewPagerContainerHolder.title, R.color.CAM_X0108, 1);
            ap.setBackgroundColor(bdBaseViewPagerContainerHolder.fqp, R.color.CAM_X0204);
            ap.setViewTextColor(bdBaseViewPagerContainerHolder.fqn, R.color.CAM_X0109, 1);
            ap.setBackgroundColor(bdBaseViewPagerContainerHolder.fqn, R.color.CAM_X0201);
            bdBaseViewPagerContainerHolder.fqn.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            bdBaseViewPagerContainerHolder.fqo.setSelector(ap.getDrawable(R.drawable.icon_choose_dot_s));
            bdBaseViewPagerContainerHolder.fqo.setDrawable(ap.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.fqk.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.fqk.fqq;
    }

    public IndicatorView getIndicatorView() {
        return this.fqk.fqo;
    }

    public TextView getMoreView() {
        return this.fqk.fqn;
    }

    public BdBaseViewPagerContainerHolder getViewHolder() {
        return this.fqk;
    }

    public void setMaxScrollCountLimit(int i) {
        this.fql.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.fql.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.fql.ki(z);
    }

    public void setDatas(List<n> list) {
        this.fql.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.fql.setAutoScrollIntervalTime(j);
    }
}
