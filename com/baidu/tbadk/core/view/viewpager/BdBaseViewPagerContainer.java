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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    private a azK;
    private b azL;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.azK = new a(LayoutInflater.from(context).inflate(d.h.bd_base_viewpager_container, viewGroup, z), context);
        a(this.azK);
        this.azL = new b(context, this.azK.azQ, this.azK.azO, this.azK.azN, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            am.j(aVar.getView(), d.C0140d.cp_bg_line_d);
            am.c(aVar.title, d.C0140d.cp_cont_c, 1);
            am.j(aVar.azP, d.C0140d.cp_bg_line_b);
            am.c(aVar.azN, d.C0140d.cp_cont_d, 1);
            am.j(aVar.azN, d.C0140d.cp_bg_line_d);
            aVar.azN.setText(TbadkCoreApplication.getInst().getString(d.j.recommend_frs_hot_thread_more));
            aVar.azO.setSelector(am.getDrawable(d.f.icon_choose_dot_s));
            aVar.azO.setDrawable(am.getDrawable(d.f.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.azK.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.azK.azQ;
    }

    public IndicatorView getIndicatorView() {
        return this.azK.azO;
    }

    public TextView getMoreView() {
        return this.azK.azN;
    }

    public a getViewHolder() {
        return this.azK;
    }

    public void setMaxScrollCountLimit(int i) {
        this.azL.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.azL.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.azL.aY(z);
    }

    public void setDatas(List<h> list) {
        this.azL.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.azL.setAutoScrollIntervalTime(j);
    }
}
