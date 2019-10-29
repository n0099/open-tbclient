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
    private a csZ;
    private b cta;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.csZ = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.csZ);
        this.cta = new b(context, this.csZ.ctf, this.csZ.ctd, this.csZ.ctc, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            am.setBackgroundColor(aVar.getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(aVar.title, R.color.cp_cont_c, 1);
            am.setBackgroundColor(aVar.cte, R.color.cp_bg_line_c);
            am.setViewTextColor(aVar.ctc, R.color.cp_cont_d, 1);
            am.setBackgroundColor(aVar.ctc, R.color.cp_bg_line_d);
            aVar.ctc.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.ctd.setSelector(am.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.ctd.setDrawable(am.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.csZ.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.csZ.ctf;
    }

    public IndicatorView getIndicatorView() {
        return this.csZ.ctd;
    }

    public TextView getMoreView() {
        return this.csZ.ctc;
    }

    public a getViewHolder() {
        return this.csZ;
    }

    public void setMaxScrollCountLimit(int i) {
        this.cta.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.cta.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.cta.ey(z);
    }

    public void setDatas(List<m> list) {
        this.cta.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.cta.setAutoScrollIntervalTime(j);
    }
}
