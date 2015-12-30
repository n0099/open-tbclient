package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPager;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class b extends RelativeLayout implements BdBaseViewPager.a {
    private c ahh;
    private d ahi;

    public b(Context context) {
        super(context);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.ahh = new c(LayoutInflater.from(context).inflate(n.h.bd_base_viewpager_container, viewGroup, z), context);
        a(this.ahh);
        this.ahi = new d(context, this.ahh.aho, this.ahh.ahm, this.ahh.ahl, 4, false, true);
    }

    private void a(c cVar) {
        if (cVar != null) {
            as.j(cVar.getView(), n.d.cp_bg_line_d);
            as.b(cVar.ahk, n.d.cp_cont_c, 1);
            as.j(cVar.ahn, n.d.cp_bg_line_b);
            as.b(cVar.ahl, n.d.cp_cont_d, 1);
            as.j((View) cVar.ahl, n.d.cp_bg_line_d);
            cVar.ahl.setText(TbadkCoreApplication.m411getInst().getString(n.j.recommend_frs_hot_thread_more));
            cVar.ahm.setSelector(as.getDrawable(n.f.icon_choose_dot_s));
            cVar.ahm.setDrawable(as.getDrawable(n.f.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.ahh.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.ahh.aho;
    }

    public IndicatorView getIndicatorView() {
        return this.ahh.ahm;
    }

    public TextView getMoreView() {
        return this.ahh.ahl;
    }

    public c getViewHolder() {
        return this.ahh;
    }

    public void setMaxScrollCountLimit(int i) {
        this.ahi.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.ahi.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.ahi.az(z);
    }

    public void setDatas(List<u> list) {
        this.ahi.setDatas(list);
    }

    public void notifyDataSetChanged() {
        this.ahi.notifyDataSetChanged();
    }

    public void a(Context context, g<?, ?> gVar) {
        this.ahi.a(context, gVar);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void wa() {
        this.ahi.wa();
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void wb() {
        this.ahi.wb();
    }

    public void cK(int i) {
        if (i != this.ahh.ahf) {
            a(this.ahh);
            this.ahi.cK(i);
            this.ahh.ahf = i;
        }
    }

    public void setAutoScrollIntervalTime(long j) {
        this.ahi.setAutoScrollIntervalTime(j);
    }
}
