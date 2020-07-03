package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    private a ehO;
    private b ehP;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.ehO = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.ehO);
        this.ehP = new b(context, this.ehO.ehU, this.ehO.ehS, this.ehO.ehR, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            an.setBackgroundColor(aVar.getView(), R.color.cp_bg_line_d);
            an.setViewTextColor(aVar.title, R.color.cp_cont_c, 1);
            an.setBackgroundColor(aVar.ehT, R.color.cp_bg_line_c);
            an.setViewTextColor(aVar.ehR, R.color.cp_cont_d, 1);
            an.setBackgroundColor(aVar.ehR, R.color.cp_bg_line_d);
            aVar.ehR.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.ehS.setSelector(an.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.ehS.setDrawable(an.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.ehO.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.ehO.ehU;
    }

    public IndicatorView getIndicatorView() {
        return this.ehO.ehS;
    }

    public TextView getMoreView() {
        return this.ehO.ehR;
    }

    public a getViewHolder() {
        return this.ehO;
    }

    public void setMaxScrollCountLimit(int i) {
        this.ehP.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.ehP.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.ehP.hC(z);
    }

    public void setDatas(List<q> list) {
        this.ehP.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.ehP.setAutoScrollIntervalTime(j);
    }
}
