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
    private a cdN;
    private b cdO;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.cdN = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.cdN);
        this.cdO = new b(context, this.cdN.cdT, this.cdN.cdR, this.cdN.cdQ, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            am.l(aVar.getView(), R.color.cp_bg_line_d);
            am.f(aVar.title, R.color.cp_cont_c, 1);
            am.l(aVar.cdS, R.color.cp_bg_line_b);
            am.f(aVar.cdQ, R.color.cp_cont_d, 1);
            am.l(aVar.cdQ, R.color.cp_bg_line_d);
            aVar.cdQ.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.cdR.setSelector(am.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.cdR.setDrawable(am.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.cdN.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.cdN.cdT;
    }

    public IndicatorView getIndicatorView() {
        return this.cdN.cdR;
    }

    public TextView getMoreView() {
        return this.cdN.cdQ;
    }

    public a getViewHolder() {
        return this.cdN;
    }

    public void setMaxScrollCountLimit(int i) {
        this.cdO.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.cdO.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.cdO.ey(z);
    }

    public void setDatas(List<m> list) {
        this.cdO.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.cdO.setAutoScrollIntervalTime(j);
    }
}
