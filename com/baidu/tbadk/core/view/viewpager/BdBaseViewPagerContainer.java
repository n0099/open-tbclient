package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    private a aMm;
    private b aMn;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.aMm = new a(LayoutInflater.from(context).inflate(e.h.bd_base_viewpager_container, viewGroup, z), context);
        a(this.aMm);
        this.aMn = new b(context, this.aMm.aMs, this.aMm.aMq, this.aMm.aMp, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            al.j(aVar.getView(), e.d.cp_bg_line_d);
            al.c(aVar.title, e.d.cp_cont_c, 1);
            al.j(aVar.aMr, e.d.cp_bg_line_b);
            al.c(aVar.aMp, e.d.cp_cont_d, 1);
            al.j(aVar.aMp, e.d.cp_bg_line_d);
            aVar.aMp.setText(TbadkCoreApplication.getInst().getString(e.j.recommend_frs_hot_thread_more));
            aVar.aMq.setSelector(al.getDrawable(e.f.icon_choose_dot_s));
            aVar.aMq.setDrawable(al.getDrawable(e.f.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.aMm.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.aMm.aMs;
    }

    public IndicatorView getIndicatorView() {
        return this.aMm.aMq;
    }

    public TextView getMoreView() {
        return this.aMm.aMp;
    }

    public a getViewHolder() {
        return this.aMm;
    }

    public void setMaxScrollCountLimit(int i) {
        this.aMn.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.aMn.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.aMn.bO(z);
    }

    public void setDatas(List<h> list) {
        this.aMn.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.aMn.setAutoScrollIntervalTime(j);
    }
}
