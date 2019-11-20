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
    private a csi;
    private b csj;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.csi = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.csi);
        this.csj = new b(context, this.csi.cso, this.csi.csm, this.csi.csl, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            am.setBackgroundColor(aVar.getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(aVar.title, R.color.cp_cont_c, 1);
            am.setBackgroundColor(aVar.csn, R.color.cp_bg_line_c);
            am.setViewTextColor(aVar.csl, R.color.cp_cont_d, 1);
            am.setBackgroundColor(aVar.csl, R.color.cp_bg_line_d);
            aVar.csl.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.csm.setSelector(am.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.csm.setDrawable(am.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.csi.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.csi.cso;
    }

    public IndicatorView getIndicatorView() {
        return this.csi.csm;
    }

    public TextView getMoreView() {
        return this.csi.csl;
    }

    public a getViewHolder() {
        return this.csi;
    }

    public void setMaxScrollCountLimit(int i) {
        this.csj.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.csj.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.csj.ey(z);
    }

    public void setDatas(List<m> list) {
        this.csj.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.csj.setAutoScrollIntervalTime(j);
    }
}
