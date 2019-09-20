package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    private a ceN;
    private b ceO;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.ceN = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.ceN);
        this.ceO = new b(context, this.ceN.ceT, this.ceN.ceR, this.ceN.ceQ, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            am.l(aVar.getView(), R.color.cp_bg_line_d);
            am.f(aVar.title, R.color.cp_cont_c, 1);
            am.l(aVar.ceS, R.color.cp_bg_line_c);
            am.f(aVar.ceQ, R.color.cp_cont_d, 1);
            am.l(aVar.ceQ, R.color.cp_bg_line_d);
            aVar.ceQ.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.ceR.setSelector(am.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.ceR.setDrawable(am.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.ceN.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.ceN.ceT;
    }

    public IndicatorView getIndicatorView() {
        return this.ceN.ceR;
    }

    public TextView getMoreView() {
        return this.ceN.ceQ;
    }

    public a getViewHolder() {
        return this.ceN;
    }

    public void setMaxScrollCountLimit(int i) {
        this.ceO.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.ceO.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.ceO.eB(z);
    }

    public void setDatas(List<m> list) {
        this.ceO.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.ceO.setAutoScrollIntervalTime(j);
    }
}
