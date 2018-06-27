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
    private a azR;
    private b azS;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.azR = new a(LayoutInflater.from(context).inflate(d.i.bd_base_viewpager_container, viewGroup, z), context);
        a(this.azR);
        this.azS = new b(context, this.azR.azX, this.azR.azV, this.azR.azU, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            am.j(aVar.getView(), d.C0142d.cp_bg_line_d);
            am.c(aVar.title, d.C0142d.cp_cont_c, 1);
            am.j(aVar.azW, d.C0142d.cp_bg_line_b);
            am.c(aVar.azU, d.C0142d.cp_cont_d, 1);
            am.j(aVar.azU, d.C0142d.cp_bg_line_d);
            aVar.azU.setText(TbadkCoreApplication.getInst().getString(d.k.recommend_frs_hot_thread_more));
            aVar.azV.setSelector(am.getDrawable(d.f.icon_choose_dot_s));
            aVar.azV.setDrawable(am.getDrawable(d.f.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.azR.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.azR.azX;
    }

    public IndicatorView getIndicatorView() {
        return this.azR.azV;
    }

    public TextView getMoreView() {
        return this.azR.azU;
    }

    public a getViewHolder() {
        return this.azR;
    }

    public void setMaxScrollCountLimit(int i) {
        this.azS.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.azS.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.azS.ba(z);
    }

    public void setDatas(List<h> list) {
        this.azS.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.azS.setAutoScrollIntervalTime(j);
    }
}
