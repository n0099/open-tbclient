package com.baidu.tbadk.core.view.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes.dex */
public class BdBaseViewPagerContainer extends RelativeLayout {
    private a eAu;
    private b eAv;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.eAu = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.eAu);
        this.eAv = new b(context, this.eAu.eAA, this.eAu.eAy, this.eAu.eAx, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            ap.setBackgroundColor(aVar.getView(), R.color.cp_bg_line_d);
            ap.setViewTextColor(aVar.title, R.color.cp_cont_c, 1);
            ap.setBackgroundColor(aVar.eAz, R.color.cp_bg_line_c);
            ap.setViewTextColor(aVar.eAx, R.color.cp_cont_d, 1);
            ap.setBackgroundColor(aVar.eAx, R.color.cp_bg_line_d);
            aVar.eAx.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.eAy.setSelector(ap.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.eAy.setDrawable(ap.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.eAu.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.eAu.eAA;
    }

    public IndicatorView getIndicatorView() {
        return this.eAu.eAy;
    }

    public TextView getMoreView() {
        return this.eAu.eAx;
    }

    public a getViewHolder() {
        return this.eAu;
    }

    public void setMaxScrollCountLimit(int i) {
        this.eAv.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.eAv.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.eAv.iC(z);
    }

    public void setDatas(List<q> list) {
        this.eAv.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.eAv.setAutoScrollIntervalTime(j);
    }
}
