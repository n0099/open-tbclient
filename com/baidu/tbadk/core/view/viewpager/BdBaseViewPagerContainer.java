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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    private a bUM;
    private b bUN;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.bUM = new a(LayoutInflater.from(context).inflate(d.h.bd_base_viewpager_container, viewGroup, z), context);
        a(this.bUM);
        this.bUN = new b(context, this.bUM.bUS, this.bUM.bUQ, this.bUM.bUP, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            al.l(aVar.getView(), d.C0277d.cp_bg_line_d);
            al.d(aVar.title, d.C0277d.cp_cont_c, 1);
            al.l(aVar.bUR, d.C0277d.cp_bg_line_b);
            al.d(aVar.bUP, d.C0277d.cp_cont_d, 1);
            al.l(aVar.bUP, d.C0277d.cp_bg_line_d);
            aVar.bUP.setText(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_hot_thread_more));
            aVar.bUQ.setSelector(al.getDrawable(d.f.icon_choose_dot_s));
            aVar.bUQ.setDrawable(al.getDrawable(d.f.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.bUM.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.bUM.bUS;
    }

    public IndicatorView getIndicatorView() {
        return this.bUM.bUQ;
    }

    public TextView getMoreView() {
        return this.bUM.bUP;
    }

    public a getViewHolder() {
        return this.bUM;
    }

    public void setMaxScrollCountLimit(int i) {
        this.bUN.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.bUN.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.bUN.dX(z);
    }

    public void setDatas(List<m> list) {
        this.bUN.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.bUN.setAutoScrollIntervalTime(j);
    }
}
