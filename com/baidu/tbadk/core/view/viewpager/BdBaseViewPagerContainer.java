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
    private a eUX;
    private b eUY;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.eUX = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.eUX);
        this.eUY = new b(context, this.eUX.eVd, this.eUX.eVb, this.eUX.eVa, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            ap.setBackgroundColor(aVar.getView(), R.color.cp_bg_line_d);
            ap.setViewTextColor(aVar.title, R.color.cp_cont_c, 1);
            ap.setBackgroundColor(aVar.eVc, R.color.cp_bg_line_c);
            ap.setViewTextColor(aVar.eVa, R.color.cp_cont_d, 1);
            ap.setBackgroundColor(aVar.eVa, R.color.cp_bg_line_d);
            aVar.eVa.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.eVb.setSelector(ap.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.eVb.setDrawable(ap.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.eUX.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.eUX.eVd;
    }

    public IndicatorView getIndicatorView() {
        return this.eUX.eVb;
    }

    public TextView getMoreView() {
        return this.eUX.eVa;
    }

    public a getViewHolder() {
        return this.eUX;
    }

    public void setMaxScrollCountLimit(int i) {
        this.eUY.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.eUY.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.eUY.jn(z);
    }

    public void setDatas(List<q> list) {
        this.eUY.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.eUY.setAutoScrollIntervalTime(j);
    }
}
