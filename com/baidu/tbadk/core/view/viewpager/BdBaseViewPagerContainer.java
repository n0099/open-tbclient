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
    private a bUO;
    private b bUP;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.bUO = new a(LayoutInflater.from(context).inflate(d.h.bd_base_viewpager_container, viewGroup, z), context);
        a(this.bUO);
        this.bUP = new b(context, this.bUO.bUU, this.bUO.bUS, this.bUO.bUR, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            al.l(aVar.getView(), d.C0277d.cp_bg_line_d);
            al.d(aVar.title, d.C0277d.cp_cont_c, 1);
            al.l(aVar.bUT, d.C0277d.cp_bg_line_b);
            al.d(aVar.bUR, d.C0277d.cp_cont_d, 1);
            al.l(aVar.bUR, d.C0277d.cp_bg_line_d);
            aVar.bUR.setText(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_hot_thread_more));
            aVar.bUS.setSelector(al.getDrawable(d.f.icon_choose_dot_s));
            aVar.bUS.setDrawable(al.getDrawable(d.f.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.bUO.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.bUO.bUU;
    }

    public IndicatorView getIndicatorView() {
        return this.bUO.bUS;
    }

    public TextView getMoreView() {
        return this.bUO.bUR;
    }

    public a getViewHolder() {
        return this.bUO;
    }

    public void setMaxScrollCountLimit(int i) {
        this.bUP.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.bUP.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.bUP.dX(z);
    }

    public void setDatas(List<m> list) {
        this.bUP.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.bUP.setAutoScrollIntervalTime(j);
    }
}
