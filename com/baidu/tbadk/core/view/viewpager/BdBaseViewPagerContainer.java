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
    private a aMl;
    private b aMm;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.aMl = new a(LayoutInflater.from(context).inflate(e.h.bd_base_viewpager_container, viewGroup, z), context);
        a(this.aMl);
        this.aMm = new b(context, this.aMl.aMr, this.aMl.aMp, this.aMl.aMo, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            al.j(aVar.getView(), e.d.cp_bg_line_d);
            al.c(aVar.title, e.d.cp_cont_c, 1);
            al.j(aVar.aMq, e.d.cp_bg_line_b);
            al.c(aVar.aMo, e.d.cp_cont_d, 1);
            al.j(aVar.aMo, e.d.cp_bg_line_d);
            aVar.aMo.setText(TbadkCoreApplication.getInst().getString(e.j.recommend_frs_hot_thread_more));
            aVar.aMp.setSelector(al.getDrawable(e.f.icon_choose_dot_s));
            aVar.aMp.setDrawable(al.getDrawable(e.f.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.aMl.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.aMl.aMr;
    }

    public IndicatorView getIndicatorView() {
        return this.aMl.aMp;
    }

    public TextView getMoreView() {
        return this.aMl.aMo;
    }

    public a getViewHolder() {
        return this.aMl;
    }

    public void setMaxScrollCountLimit(int i) {
        this.aMm.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.aMm.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.aMm.bO(z);
    }

    public void setDatas(List<h> list) {
        this.aMm.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.aMm.setAutoScrollIntervalTime(j);
    }
}
