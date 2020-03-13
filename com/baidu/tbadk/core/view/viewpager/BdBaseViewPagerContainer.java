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
    private a dkC;
    private b dkD;

    public BdBaseViewPagerContainer(Context context) {
        super(context);
        a(context, this, true);
    }

    public BdBaseViewPagerContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, this, true);
    }

    private void a(Context context, ViewGroup viewGroup, boolean z) {
        this.dkC = new a(LayoutInflater.from(context).inflate(R.layout.bd_base_viewpager_container, viewGroup, z), context);
        a(this.dkC);
        this.dkD = new b(context, this.dkC.dkI, this.dkC.dkG, this.dkC.dkF, 4, false, true);
    }

    private void a(a aVar) {
        if (aVar != null) {
            am.setBackgroundColor(aVar.getView(), R.color.cp_bg_line_d);
            am.setViewTextColor(aVar.title, R.color.cp_cont_c, 1);
            am.setBackgroundColor(aVar.dkH, R.color.cp_bg_line_c);
            am.setViewTextColor(aVar.dkF, R.color.cp_cont_d, 1);
            am.setBackgroundColor(aVar.dkF, R.color.cp_bg_line_d);
            aVar.dkF.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_frs_hot_thread_more));
            aVar.dkG.setSelector(am.getDrawable(R.drawable.icon_choose_dot_s));
            aVar.dkG.setDrawable(am.getDrawable(R.drawable.icon_choose_dot_n));
        }
    }

    @Override // android.view.View
    public View getRootView() {
        return this.dkC.getView();
    }

    public BdBaseViewPager getViewPager() {
        return this.dkC.dkI;
    }

    public IndicatorView getIndicatorView() {
        return this.dkC.dkG;
    }

    public TextView getMoreView() {
        return this.dkC.dkF;
    }

    public a getViewHolder() {
        return this.dkC;
    }

    public void setMaxScrollCountLimit(int i) {
        this.dkD.setMaxScrollCountLimit(i);
    }

    public void setIsMaxScrollEnabled(boolean z) {
        this.dkD.setIsMaxScrollEnabled(z);
    }

    public void setIsAutoScrollEnabled(boolean z) {
        this.dkD.fW(z);
    }

    public void setDatas(List<m> list) {
        this.dkD.setDatas(list);
    }

    public void setAutoScrollIntervalTime(long j) {
        this.dkD.setAutoScrollIntervalTime(j);
    }
}
