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
    private c aga;
    private d agb;

    public b(Context context) {
        super(context);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.aga = new c(LayoutInflater.from(context).inflate(n.g.bd_base_viewpager_container, viewGroup, z), context);
        a(this.aga);
        this.agb = new d(context, this.aga.agh, this.aga.agf, this.aga.age, 4, false, true);
    }

    private void a(c cVar) {
        if (cVar != null) {
            as.j(cVar.getView(), n.c.cp_bg_line_d);
            as.b(cVar.agd, n.c.cp_cont_c, 1);
            as.j(cVar.agg, n.c.cp_bg_line_b);
            as.b(cVar.age, n.c.cp_cont_d, 1);
            as.j((View) cVar.age, n.c.cp_bg_line_d);
            cVar.age.setText(TbadkCoreApplication.m411getInst().getString(n.i.recommend_frs_hot_thread_more));
            cVar.agf.setSelector(as.getDrawable(n.e.icon_choose_dot_s));
            cVar.agf.setDrawable(as.getDrawable(n.e.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.aga.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.aga.agh;
    }

    public IndicatorView getIndicatorView() {
        return this.aga.agf;
    }

    public TextView getMoreView() {
        return this.aga.age;
    }

    public c getViewHolder() {
        return this.aga;
    }

    public void setMaxScrollCountLimit(int i) {
        this.agb.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.agb.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.agb.aC(z);
    }

    public void setDatas(List<u> list) {
        this.agb.setDatas(list);
    }

    public void notifyDataSetChanged() {
        this.agb.notifyDataSetChanged();
    }

    public void a(Context context, g<?, ?> gVar) {
        this.agb.a(context, gVar);
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void wp() {
        this.agb.wp();
    }

    @Override // com.baidu.tbadk.core.view.viewpager.BdBaseViewPager.a
    public void wq() {
        this.agb.wq();
    }

    public void cZ(int i) {
        if (i != this.aga.afY) {
            a(this.aga);
            this.agb.cZ(i);
            this.aga.afY = i;
        }
    }

    public void setAutoScrollIntervalTime(long j) {
        this.agb.setAutoScrollIntervalTime(j);
    }
}
