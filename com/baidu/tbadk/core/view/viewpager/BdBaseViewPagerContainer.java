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
    private a aLH;
    private b aLI;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.aLH = new a(LayoutInflater.from(context).inflate(e.h.bd_base_viewpager_container, viewGroup, z), context);
        a(this.aLH);
        this.aLI = new b(context, this.aLH.aLN, this.aLH.aLL, this.aLH.aLK, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            al.j(aVar.getView(), e.d.cp_bg_line_d);
            al.c(aVar.title, e.d.cp_cont_c, 1);
            al.j(aVar.aLM, e.d.cp_bg_line_b);
            al.c(aVar.aLK, e.d.cp_cont_d, 1);
            al.j(aVar.aLK, e.d.cp_bg_line_d);
            aVar.aLK.setText(TbadkCoreApplication.getInst().getString(e.j.recommend_frs_hot_thread_more));
            aVar.aLL.setSelector(al.getDrawable(e.f.icon_choose_dot_s));
            aVar.aLL.setDrawable(al.getDrawable(e.f.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.aLH.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.aLH.aLN;
    }

    public IndicatorView getIndicatorView() {
        return this.aLH.aLL;
    }

    public TextView getMoreView() {
        return this.aLH.aLK;
    }

    public a getViewHolder() {
        return this.aLH;
    }

    public void setMaxScrollCountLimit(int i) {
        this.aLI.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.aLI.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.aLI.bN(z);
    }

    public void setDatas(List<h> list) {
        this.aLI.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.aLI.setAutoScrollIntervalTime(j);
    }
}
