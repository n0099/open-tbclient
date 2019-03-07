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
    private a bUL;
    private b bUM;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.bUL = new a(LayoutInflater.from(context).inflate(d.h.bd_base_viewpager_container, viewGroup, z), context);
        a(this.bUL);
        this.bUM = new b(context, this.bUL.bUR, this.bUL.bUP, this.bUL.bUO, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            al.l(aVar.getView(), d.C0236d.cp_bg_line_d);
            al.d(aVar.title, d.C0236d.cp_cont_c, 1);
            al.l(aVar.bUQ, d.C0236d.cp_bg_line_b);
            al.d(aVar.bUO, d.C0236d.cp_cont_d, 1);
            al.l(aVar.bUO, d.C0236d.cp_bg_line_d);
            aVar.bUO.setText(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_hot_thread_more));
            aVar.bUP.setSelector(al.getDrawable(d.f.icon_choose_dot_s));
            aVar.bUP.setDrawable(al.getDrawable(d.f.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.bUL.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.bUL.bUR;
    }

    public IndicatorView getIndicatorView() {
        return this.bUL.bUP;
    }

    public TextView getMoreView() {
        return this.bUL.bUO;
    }

    public a getViewHolder() {
        return this.bUL;
    }

    public void setMaxScrollCountLimit(int i) {
        this.bUM.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.bUM.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.bUM.dX(z);
    }

    public void setDatas(List<m> list) {
        this.bUM.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.bUM.setAutoScrollIntervalTime(j);
    }
}
