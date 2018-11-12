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
    private a aIh;
    private b aIi;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.aIh = new a(LayoutInflater.from(context).inflate(e.h.bd_base_viewpager_container, viewGroup, z), context);
        a(this.aIh);
        this.aIi = new b(context, this.aIh.aIn, this.aIh.aIl, this.aIh.aIk, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            al.j(aVar.getView(), e.d.cp_bg_line_d);
            al.c(aVar.title, e.d.cp_cont_c, 1);
            al.j(aVar.aIm, e.d.cp_bg_line_b);
            al.c(aVar.aIk, e.d.cp_cont_d, 1);
            al.j(aVar.aIk, e.d.cp_bg_line_d);
            aVar.aIk.setText(TbadkCoreApplication.getInst().getString(e.j.recommend_frs_hot_thread_more));
            aVar.aIl.setSelector(al.getDrawable(e.f.icon_choose_dot_s));
            aVar.aIl.setDrawable(al.getDrawable(e.f.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.aIh.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.aIh.aIn;
    }

    public IndicatorView getIndicatorView() {
        return this.aIh.aIl;
    }

    public TextView getMoreView() {
        return this.aIh.aIk;
    }

    public a getViewHolder() {
        return this.aIh;
    }

    public void setMaxScrollCountLimit(int i) {
        this.aIi.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.aIi.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.aIi.bM(z);
    }

    public void setDatas(List<h> list) {
        this.aIi.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.aIi.setAutoScrollIntervalTime(j);
    }
}
