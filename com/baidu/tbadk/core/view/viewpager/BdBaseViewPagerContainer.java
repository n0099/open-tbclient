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
    private a aHr;
    private b aHs;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.aHr = new a(LayoutInflater.from(context).inflate(e.h.bd_base_viewpager_container, viewGroup, z), context);
        a(this.aHr);
        this.aHs = new b(context, this.aHr.aHx, this.aHr.aHv, this.aHr.aHu, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            al.j(aVar.getView(), e.d.cp_bg_line_d);
            al.c(aVar.title, e.d.cp_cont_c, 1);
            al.j(aVar.aHw, e.d.cp_bg_line_b);
            al.c(aVar.aHu, e.d.cp_cont_d, 1);
            al.j(aVar.aHu, e.d.cp_bg_line_d);
            aVar.aHu.setText(TbadkCoreApplication.getInst().getString(e.j.recommend_frs_hot_thread_more));
            aVar.aHv.setSelector(al.getDrawable(e.f.icon_choose_dot_s));
            aVar.aHv.setDrawable(al.getDrawable(e.f.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.aHr.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.aHr.aHx;
    }

    public IndicatorView getIndicatorView() {
        return this.aHr.aHv;
    }

    public TextView getMoreView() {
        return this.aHr.aHu;
    }

    public a getViewHolder() {
        return this.aHr;
    }

    public void setMaxScrollCountLimit(int i) {
        this.aHs.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.aHs.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.aHs.bv(z);
    }

    public void setDatas(List<h> list) {
        this.aHs.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.aHs.setAutoScrollIntervalTime(j);
    }
}
