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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    private a aqS;
    private b aqT;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.aqS = new a(LayoutInflater.from(context).inflate(d.i.bd_base_viewpager_container, viewGroup, z), context);
        a(this.aqS);
        this.aqT = new b(context, this.aqS.aqY, this.aqS.aqW, this.aqS.aqV, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            ak.j(aVar.getView(), d.C0126d.cp_bg_line_d);
            ak.c(aVar.title, d.C0126d.cp_cont_c, 1);
            ak.j(aVar.aqX, d.C0126d.cp_bg_line_b);
            ak.c(aVar.aqV, d.C0126d.cp_cont_d, 1);
            ak.j(aVar.aqV, d.C0126d.cp_bg_line_d);
            aVar.aqV.setText(TbadkCoreApplication.getInst().getString(d.k.recommend_frs_hot_thread_more));
            aVar.aqW.setSelector(ak.getDrawable(d.f.icon_choose_dot_s));
            aVar.aqW.setDrawable(ak.getDrawable(d.f.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.aqS.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.aqS.aqY;
    }

    public IndicatorView getIndicatorView() {
        return this.aqS.aqW;
    }

    public TextView getMoreView() {
        return this.aqS.aqV;
    }

    public a getViewHolder() {
        return this.aqS;
    }

    public void setMaxScrollCountLimit(int i) {
        this.aqT.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.aqT.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.aqT.aT(z);
    }

    public void setDatas(List<h> list) {
        this.aqT.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.aqT.setAutoScrollIntervalTime(j);
    }
}
