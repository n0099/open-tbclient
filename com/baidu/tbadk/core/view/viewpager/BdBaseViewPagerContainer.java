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
    private a bUP;
    private b bUQ;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.bUP = new a(LayoutInflater.from(context).inflate(d.h.bd_base_viewpager_container, viewGroup, z), context);
        a(this.bUP);
        this.bUQ = new b(context, this.bUP.bUV, this.bUP.bUT, this.bUP.bUS, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            al.l(aVar.getView(), d.C0277d.cp_bg_line_d);
            al.d(aVar.title, d.C0277d.cp_cont_c, 1);
            al.l(aVar.bUU, d.C0277d.cp_bg_line_b);
            al.d(aVar.bUS, d.C0277d.cp_cont_d, 1);
            al.l(aVar.bUS, d.C0277d.cp_bg_line_d);
            aVar.bUS.setText(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_hot_thread_more));
            aVar.bUT.setSelector(al.getDrawable(d.f.icon_choose_dot_s));
            aVar.bUT.setDrawable(al.getDrawable(d.f.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.bUP.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.bUP.bUV;
    }

    public IndicatorView getIndicatorView() {
        return this.bUP.bUT;
    }

    public TextView getMoreView() {
        return this.bUP.bUS;
    }

    public a getViewHolder() {
        return this.bUP;
    }

    public void setMaxScrollCountLimit(int i) {
        this.bUQ.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.bUQ.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.bUQ.dX(z);
    }

    public void setDatas(List<m> list) {
        this.bUQ.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.bUQ.setAutoScrollIntervalTime(j);
    }
}
