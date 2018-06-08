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
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    private a ayZ;
    private b aza;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.ayZ = new a(LayoutInflater.from(context).inflate(d.i.bd_base_viewpager_container, viewGroup, z), context);
        a(this.ayZ);
        this.aza = new b(context, this.ayZ.azf, this.ayZ.azd, this.ayZ.azc, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            al.j(aVar.getView(), d.C0141d.cp_bg_line_d);
            al.c(aVar.title, d.C0141d.cp_cont_c, 1);
            al.j(aVar.aze, d.C0141d.cp_bg_line_b);
            al.c(aVar.azc, d.C0141d.cp_cont_d, 1);
            al.j(aVar.azc, d.C0141d.cp_bg_line_d);
            aVar.azc.setText(TbadkCoreApplication.getInst().getString(d.k.recommend_frs_hot_thread_more));
            aVar.azd.setSelector(al.getDrawable(d.f.icon_choose_dot_s));
            aVar.azd.setDrawable(al.getDrawable(d.f.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.ayZ.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.ayZ.azf;
    }

    public IndicatorView getIndicatorView() {
        return this.ayZ.azd;
    }

    public TextView getMoreView() {
        return this.ayZ.azc;
    }

    public a getViewHolder() {
        return this.ayZ;
    }

    public void setMaxScrollCountLimit(int i) {
        this.aza.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.aza.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.aza.aX(z);
    }

    public void setDatas(List<h> list) {
        this.aza.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.aza.setAutoScrollIntervalTime(j);
    }
}
