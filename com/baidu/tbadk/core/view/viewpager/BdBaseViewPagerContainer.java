package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    private a ccK;
    private b ccL;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.ccK = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.ccK);
        this.ccL = new b(context, this.ccK.ccQ, this.ccK.ccO, this.ccK.ccN, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            al.l(aVar.getView(), R.color.cp_bg_line_d);
            al.f(aVar.title, R.color.cp_cont_c, 1);
            al.l(aVar.ccP, R.color.cp_bg_line_b);
            al.f(aVar.ccN, R.color.cp_cont_d, 1);
            al.l(aVar.ccN, R.color.cp_bg_line_d);
            aVar.ccN.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.ccO.setSelector(al.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.ccO.setDrawable(al.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.ccK.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.ccK.ccQ;
    }

    public IndicatorView getIndicatorView() {
        return this.ccK.ccO;
    }

    public TextView getMoreView() {
        return this.ccK.ccN;
    }

    public a getViewHolder() {
        return this.ccK;
    }

    public void setMaxScrollCountLimit(int i) {
        this.ccL.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.ccL.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.ccL.eu(z);
    }

    public void setDatas(List<m> list) {
        this.ccL.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.ccL.setAutoScrollIntervalTime(j);
    }
}
