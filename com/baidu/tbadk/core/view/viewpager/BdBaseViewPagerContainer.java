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
import com.baidu.tieba.f;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    private a azH;
    private b azI;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.azH = new a(LayoutInflater.from(context).inflate(f.h.bd_base_viewpager_container, viewGroup, z), context);
        a(this.azH);
        this.azI = new b(context, this.azH.azN, this.azH.azL, this.azH.azK, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            am.j(aVar.getView(), f.d.cp_bg_line_d);
            am.c(aVar.title, f.d.cp_cont_c, 1);
            am.j(aVar.azM, f.d.cp_bg_line_b);
            am.c(aVar.azK, f.d.cp_cont_d, 1);
            am.j(aVar.azK, f.d.cp_bg_line_d);
            aVar.azK.setText(TbadkCoreApplication.getInst().getString(f.j.recommend_frs_hot_thread_more));
            aVar.azL.setSelector(am.getDrawable(f.C0146f.icon_choose_dot_s));
            aVar.azL.setDrawable(am.getDrawable(f.C0146f.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.azH.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.azH.azN;
    }

    public IndicatorView getIndicatorView() {
        return this.azH.azL;
    }

    public TextView getMoreView() {
        return this.azH.azK;
    }

    public a getViewHolder() {
        return this.azH;
    }

    public void setMaxScrollCountLimit(int i) {
        this.azI.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.azI.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.azI.aZ(z);
    }

    public void setDatas(List<h> list) {
        this.azI.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.azI.setAutoScrollIntervalTime(j);
    }
}
