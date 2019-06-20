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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    private a ccL;
    private b ccM;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.ccL = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.ccL);
        this.ccM = new b(context, this.ccL.ccR, this.ccL.ccP, this.ccL.ccO, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            al.l(aVar.getView(), R.color.cp_bg_line_d);
            al.f(aVar.title, R.color.cp_cont_c, 1);
            al.l(aVar.ccQ, R.color.cp_bg_line_b);
            al.f(aVar.ccO, R.color.cp_cont_d, 1);
            al.l(aVar.ccO, R.color.cp_bg_line_d);
            aVar.ccO.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.ccP.setSelector(al.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.ccP.setDrawable(al.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.ccL.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.ccL.ccR;
    }

    public IndicatorView getIndicatorView() {
        return this.ccL.ccP;
    }

    public TextView getMoreView() {
        return this.ccL.ccO;
    }

    public a getViewHolder() {
        return this.ccL;
    }

    public void setMaxScrollCountLimit(int i) {
        this.ccM.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.ccM.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.ccM.eu(z);
    }

    public void setDatas(List<m> list) {
        this.ccM.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.ccM.setAutoScrollIntervalTime(j);
    }
}
