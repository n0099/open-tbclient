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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    private a dgi;
    private b dgj;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.dgi = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.dgi);
        this.dgj = new b(context, this.dgi.dgo, this.dgi.dgm, this.dgi.dgl, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            am.setBackgroundColor(aVar.getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(aVar.title, R.color.cp_cont_c, 1);
            am.setBackgroundColor(aVar.dgn, R.color.cp_bg_line_c);
            am.setViewTextColor(aVar.dgl, R.color.cp_cont_d, 1);
            am.setBackgroundColor(aVar.dgl, R.color.cp_bg_line_d);
            aVar.dgl.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.dgm.setSelector(am.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.dgm.setDrawable(am.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.dgi.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.dgi.dgo;
    }

    public IndicatorView getIndicatorView() {
        return this.dgi.dgm;
    }

    public TextView getMoreView() {
        return this.dgi.dgl;
    }

    public a getViewHolder() {
        return this.dgi;
    }

    public void setMaxScrollCountLimit(int i) {
        this.dgj.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.dgj.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.dgj.fP(z);
    }

    public void setDatas(List<m> list) {
        this.dgj.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.dgj.setAutoScrollIntervalTime(j);
    }
}
