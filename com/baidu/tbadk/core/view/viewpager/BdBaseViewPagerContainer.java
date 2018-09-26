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
    private a aCL;
    private b aCM;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.aCL = new a(LayoutInflater.from(context).inflate(e.h.bd_base_viewpager_container, viewGroup, z), context);
        a(this.aCL);
        this.aCM = new b(context, this.aCL.aCR, this.aCL.aCP, this.aCL.aCO, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            al.j(aVar.getView(), e.d.cp_bg_line_d);
            al.c(aVar.title, e.d.cp_cont_c, 1);
            al.j(aVar.aCQ, e.d.cp_bg_line_b);
            al.c(aVar.aCO, e.d.cp_cont_d, 1);
            al.j(aVar.aCO, e.d.cp_bg_line_d);
            aVar.aCO.setText(TbadkCoreApplication.getInst().getString(e.j.recommend_frs_hot_thread_more));
            aVar.aCP.setSelector(al.getDrawable(e.f.icon_choose_dot_s));
            aVar.aCP.setDrawable(al.getDrawable(e.f.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.aCL.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.aCL.aCR;
    }

    public IndicatorView getIndicatorView() {
        return this.aCL.aCP;
    }

    public TextView getMoreView() {
        return this.aCL.aCO;
    }

    public a getViewHolder() {
        return this.aCL;
    }

    public void setMaxScrollCountLimit(int i) {
        this.aCM.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.aCM.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.aCM.bl(z);
    }

    public void setDatas(List<h> list) {
        this.aCM.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.aCM.setAutoScrollIntervalTime(j);
    }
}
