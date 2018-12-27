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
    private a aLJ;
    private b aLK;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.aLJ = new a(LayoutInflater.from(context).inflate(e.h.bd_base_viewpager_container, viewGroup, z), context);
        a(this.aLJ);
        this.aLK = new b(context, this.aLJ.aLP, this.aLJ.aLN, this.aLJ.aLM, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            al.j(aVar.getView(), e.d.cp_bg_line_d);
            al.c(aVar.title, e.d.cp_cont_c, 1);
            al.j(aVar.aLO, e.d.cp_bg_line_b);
            al.c(aVar.aLM, e.d.cp_cont_d, 1);
            al.j(aVar.aLM, e.d.cp_bg_line_d);
            aVar.aLM.setText(TbadkCoreApplication.getInst().getString(e.j.recommend_frs_hot_thread_more));
            aVar.aLN.setSelector(al.getDrawable(e.f.icon_choose_dot_s));
            aVar.aLN.setDrawable(al.getDrawable(e.f.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.aLJ.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.aLJ.aLP;
    }

    public IndicatorView getIndicatorView() {
        return this.aLJ.aLN;
    }

    public TextView getMoreView() {
        return this.aLJ.aLM;
    }

    public a getViewHolder() {
        return this.aLJ;
    }

    public void setMaxScrollCountLimit(int i) {
        this.aLK.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.aLK.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.aLK.bN(z);
    }

    public void setDatas(List<h> list) {
        this.aLK.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.aLK.setAutoScrollIntervalTime(j);
    }
}
